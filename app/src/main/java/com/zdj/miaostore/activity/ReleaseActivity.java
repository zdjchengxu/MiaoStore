package com.zdj.miaostore.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseActivity;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.interfaces.ReleaseView;
import com.zdj.miaostore.presenter.ReleasePresenter;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReleaseActivity extends BaseActivity<ReleaseView, ReleasePresenter> implements TakePhoto.TakeResultListener, ReleaseView {
    private static final String TAG = "ReleaseActivity";
    @BindView(R.id.iv_back_release)
    ImageView ivBackRelease;
    @BindView(R.id.btn_send_release)
    Button btnSendRelease;
    @BindView(R.id.ed_spacecontent_release)
    EditText edSpacecontentRelease;
    @BindView(R.id.iv_showphoto_release)
    ImageView ivShowphotoRelease;
    @BindView(R.id.iv_takephoto_release)
    ImageView ivTakephotoRelease;
    private TakePhoto takePhoto;

    private CompressConfig compressConfig;
    private User user;
    private ArrayList<TImage> images;
    private List<String> imgPaths;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getTakePhoto().onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        ButterKnife.bind(this);
        StatusBarUtil.setStatusBar(this, false);
        initView();
    }

    private void initView() {
        imgPaths = new ArrayList<>();
        MyStoreApplication myStoreApplication = (MyStoreApplication) getApplication();
        user = myStoreApplication.getUser();
        initTakeData();
    }

    @OnClick({R.id.iv_back_release, R.id.btn_send_release, R.id.iv_takephoto_release})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back_release:
                finish();
                break;
            case R.id.btn_send_release:
                btnSendRelease.setClickable(false);
                sendSpaceMsg();
                break;
            case R.id.iv_takephoto_release:
                takePhoto.onPickMultiple(4);
                break;
        }
    }

    private void sendSpaceMsg() {
        String content = edSpacecontentRelease.getText().toString();
        if (content == null || imgPaths.size() == 0) {
            Toast.makeText(ReleaseActivity.this, "请输入要发表的内容并选取图片", Toast.LENGTH_LONG).show();
        } else if (user == null) {
            Toast.makeText(this, "用户为空", Toast.LENGTH_LONG).show();
        } else {
            getPresenter().sendSpaceMsg(user.getData().getUserToken(), user.getData().getUserId(), Contans.SPACE_TYPE_FIRST, content, imgPaths);
        }
    }

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = new TakePhotoImpl(this, this);
        }
        return takePhoto;
    }

    //成功
    @Override
    public void takeSuccess(TResult result) {
        LogUtil.e(TAG, "成功: ");
        images = result.getImages();
        Glide.with(this).load(images.get(0).getOriginalPath()).into(ivShowphotoRelease);
        for (TImage e : images) {
            imgPaths.add(e.getOriginalPath());
            LogUtil.e(TAG, "compresspath: " + e.getCompressPath() + "   OriginalPath" + e.getOriginalPath() + "   FromType" + e.getFromType());
        }
    }

    private void initTakeData() {
        ////获取TakePhoto实例
        takePhoto = getTakePhoto();
        //设置压缩参数
        compressConfig = new CompressConfig.Builder().setMaxSize(50 * 1024).setMaxPixel(800).create();
        takePhoto.onEnableCompress(compressConfig, true);  //设置为需要压缩
    }

    @Override
    public void takeFail(TResult result, String msg) {
        LogUtil.e(TAG, "失败" + msg);
    }

    //取消
    @Override
    public void takeCancel() {
        LogUtil.e(TAG, "取消");
    }

    @Override
    protected ReleaseView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected ReleasePresenter createPresenter() {
        return new ReleasePresenter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        takePhoto.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        takePhoto.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSendSuccess(final NetBack netBack) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                if (netBack.getCode() == 200) {
                    Intent intent = new Intent("mineAction");
                    intent.putExtra("spaceChange", "yes");
                    LocalBroadcastManager.getInstance(ReleaseActivity.this).sendBroadcast(intent);
                    Toast.makeText(ReleaseActivity.this, "发表空间消息成功", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(ReleaseActivity.this, "出错了...." + netBack.getMsg(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onError() {
//        Toast.makeText(this, "出错了....", Toast.LENGTH_LONG).show();
    }
}
