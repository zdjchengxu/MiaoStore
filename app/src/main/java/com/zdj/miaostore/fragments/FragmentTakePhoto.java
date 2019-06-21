package com.zdj.miaostore.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.CropOptions;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.OkHttp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FragmentTakePhoto extends com.jph.takephoto.app.TakePhotoFragment {

    private View view;
    //UIs
    private Button takeFromCameraBtn, takeFromGalleyBtn;
    private ImageView imageView;
    //TakePhoto
    private TakePhoto takePhoto;
    private CropOptions cropOptions;  //裁剪参数
    private CompressConfig compressConfig;  //压缩参数
    private Uri imageUri;  //图片保存路径

    private static final String TAG = "FragmentTakePhoto";

    private User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_takephoto,container,false);
        MyStoreApplication application = (MyStoreApplication)getActivity().getApplication();
        user = application.getUser();
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();  //设置压缩、裁剪参数
        takeFromCameraBtn = (Button) view.findViewById(R.id.take_from_camera);
        takeFromCameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUri = getImageCropUri();
                //拍照并裁剪
                takePhoto.onPickFromCaptureWithCrop(imageUri, cropOptions);
                //仅仅拍照不裁剪
                //takePhoto.onPickFromCapture(imageUri);
            }
        });
        takeFromGalleyBtn = (Button) view.findViewById(R.id.take_from_galley);
        takeFromGalleyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUri = getImageCropUri();
                //从相册中选取图片并裁剪
//                takePhoto.onPickFromGalleryWithCrop(imageUri, cropOptions);
                //从相册中选取不裁剪
//                takePhoto.onPickFromGallery();
                takePhoto.onPickMultiple(4);
            }
        });
        imageView = (ImageView) view.findViewById(R.id.image_view);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
        ArrayList<TImage> images = result.getImages();
        for (TImage e :images) {
            LogUtil.e(TAG,"compresspath: "+e.getOriginalPath().toString()+"   OriginalPath"+e.getOriginalPath().toString()+"   FromType"+e.getFromType());
        }
        sendPost(images);
    }

    private void sendPost(final ArrayList<TImage> images) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> paths = new ArrayList<>();
                for (TImage e:images) {
//                    Uri uri = Uri.parse(e.getCompressPath());
//                    String realPathFromUri = getRealPathFromUri(getContext(), uri);
//                    LogUtil.e(TAG,"realPathFromUri: "+realPathFromUri);
                    paths.add(e.getOriginalPath().toString());
                }
                Map<String,String>mMap = new HashMap<>();
                mMap.put("userId",user.getData().getUserId()+"");
                mMap.put("userToken",user.getData().getUserToken());
                mMap.put("spaceType","1");
                mMap.put("spaceContent","赵大江——内容");
                mMap.put("spaceTile","赵大江——标题");
                OkHttp.sendPost("/homePage/releaseMessage",mMap,paths);
            }
        }).start();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
        Toast.makeText(getActivity(), "Error:" + msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void takeCancel() {
        super.takeCancel();
    }
    private void initData() {
        ////获取TakePhoto实例
        takePhoto = getTakePhoto();
        //设置裁剪参数
        cropOptions = new CropOptions.Builder().setAspectX(1).setAspectY(1).setWithOwnCrop(false).create();
        //设置压缩参数
        compressConfig=new CompressConfig.Builder().setMaxSize(50*1024).setMaxPixel(800).create();
        takePhoto.onEnableCompress(compressConfig,true);  //设置为需要压缩
    }

    //获得照片的输出保存Uri
    private Uri getImageCropUri() {
        File file=new File(Environment.getExternalStorageDirectory(), "/temp/"+System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists())file.getParentFile().mkdirs();
        return Uri.fromFile(file);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }




}
