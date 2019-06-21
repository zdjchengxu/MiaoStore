package com.zdj.miaostore.activity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.MainActivity;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseActivity;
import com.zdj.miaostore.bean.AskStatusBean;
import com.zdj.miaostore.bean.HomePageBean;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.interfaces.ShopXiangqingView;
import com.zdj.miaostore.presenter.ShopXiangqingPresenter;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopXiangqingActivity extends BaseActivity<ShopXiangqingView, ShopXiangqingPresenter> implements ShopXiangqingView {

    @BindView(R.id.iv_shop_img_xiang)
    ImageView ivShopImgXiang;
    @BindView(R.id.iv_back_xiang)
    ImageView ivBackXiang;
    @BindView(R.id.tv_shop_price_xiang)
    TextView tvShopPriceXiang;
    @BindView(R.id.tv_shop_name_xiang)
    TextView tvShopNameXiang;
    @BindView(R.id.tv_shop_desc_xiang)
    TextView tvShopDescXiang;
    @BindView(R.id.tv_shop_add_xiang)
    TextView tvShopAddXiang;
    @BindView(R.id.tv_shop_type_xiang)
    TextView tvShopTypeXiang;
    private static final String TAG = "ShopXiangqingActivity";
    @BindView(R.id.iv_add_xiang)
    ImageView ivAddXiang;
    @BindView(R.id.tv_shop_sum_xiang)
    TextView tvShopSumXiang;
    @BindView(R.id.iv_jian_xiang)
    ImageView ivJianXiang;
    @BindView(R.id.tv_addbuycar_xiang)
    TextView tvAddbuycarXiang;
    int sum = 0;
    private HomePageBean.DataBean.ListShopRecommendBean shopRecommendBean;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setStatusBar(this, false);
        setContentView(R.layout.activity_shop_xiangqing);
        MyStoreApplication application = (MyStoreApplication) getApplication();
        user = application.getUser();
        ButterKnife.bind(this);
        shopRecommendBean = (HomePageBean.DataBean.ListShopRecommendBean) getIntent().getSerializableExtra("shopBean");
        iniView();
    }



    private void iniView() {
        initViewListener();
        if (shopRecommendBean != null) {
            tvShopAddXiang.setText(shopRecommendBean.getShopAddress());
            tvShopDescXiang.setText(shopRecommendBean.getShopDesc());
            tvShopNameXiang.setText(shopRecommendBean.getCategoryName());
            tvShopPriceXiang.setText("￥" + shopRecommendBean.getShopPrice() + "");
            switch (shopRecommendBean.getShopType()) {
                case Contans.SHOP_XIANG_TYPE_GENERAL:
                    tvShopTypeXiang.setText("普通商品");
                    break;
                case Contans.SHOP_XIANG_TYPE_HOT:
                    tvShopTypeXiang.setText("正在热销");
                    break;
                case Contans.SHOP_XIANG_TYPE_RECOMMEND:
                    tvShopTypeXiang.setText("店长推荐");
                    break;
            }
            Glide.with(this).load(Contans.URL_SHOP + shopRecommendBean.getShopThumbnail()).into(ivShopImgXiang);
        }
    }


    private void initViewListener() {
        ivBackXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivAddXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum >= 0) {
                    sum++;
                    tvShopSumXiang.setText(sum + "");
                }
            }
        });
        ivJianXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sum > 0) {
                    sum--;
                    tvShopSumXiang.setText(sum + "");
                }
            }
        });
        tvAddbuycarXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user != null) {
                    getPresenter().addShoppCard(user.getData().getUserToken()
                            , shopRecommendBean.getShopId()
                            , tvShopSumXiang.getText().toString()
                            , user.getData().getUserId());
                }
            }
        });
    }

    @Override
    protected ShopXiangqingView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected ShopXiangqingPresenter createPresenter() {
        return new ShopXiangqingPresenter();
    }

    @Override
    public void onNetErrorStatus(final AskStatusBean mAskStatusBean) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ShopXiangqingActivity.this, "状态码：" + mAskStatusBean.getCode() + "——" + mAskStatusBean.getMsg(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onSuccess() {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent("jerry");
                intent.putExtra("change", "yes");
                LocalBroadcastManager.getInstance(ShopXiangqingActivity.this).sendBroadcast(intent);
                Toast.makeText(ShopXiangqingActivity.this, "请到购物车结算", Toast.LENGTH_LONG).show();
            }
        });
    }
}
