package com.zdj.miaostore.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.activity.ShopXiangqingActivity;
import com.zdj.miaostore.adapter.RvRecommendAdapter;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.HomePageBean;
import com.zdj.miaostore.interfaces.OnRecommendCardViewClickListener;
import com.zdj.miaostore.interfaces.RecommendView;
import com.zdj.miaostore.presenter.RecommendPresenter;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.customview.UILoader;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BaseFragmentS<RecommendView, RecommendPresenter> implements RecommendView, UILoader.OnRetryClickListener, OnBannerListener {

    Banner bannerRecommend;
    RecyclerView rvRecommend;


    private View rootView;
    private static final String TAG = "RecommendFragment";
    private UILoader mUILoader;
    private String userToken = "";
    private List<Serializable> objectList;

    @Override
    protected RecommendView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected RecommendPresenter createPresenter() {
        return new RecommendPresenter();
    }

    @Override
    protected View onSubViewLoaded(final LayoutInflater layoutInflater, ViewGroup container) {
        mUILoader = new UILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup viewGroup) {
                return createSuccessView(layoutInflater, viewGroup);
            }
        };
        MyStoreApplication application = (MyStoreApplication) getActivity().getApplication();
        if(application != null){
            userToken = application.getUser().getData().getUserToken();
        }
        if (!userToken.equals("") && getPresenter() != null) {
            getPresenter().getRecommendList(userToken);
        } else {
            mUILoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
        }

        if (mUILoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUILoader.getParent()).removeView(mUILoader);
        }

        mUILoader.setOnRetryClickListener(this);

        return mUILoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        rootView = layoutInflater.inflate(R.layout.fragment_recommend, container, false);
        bannerRecommend = rootView.findViewById(R.id.banner_recommend);
        rvRecommend = rootView.findViewById(R.id.rv_recommend);
        return rootView;
    }

    @Override
    public void onSuccess(final HomePageBean homePageBean) {
        mUILoader.updateStatus(UILoader.UIStatus.SUCCESS);
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                invalidBanner(homePageBean.getData().getList_shop_hot());
                invalidRecycleView(homePageBean.getData().getList_adv(), homePageBean.getData().getList_shop_recommend());
            }
        });
    }

    private void invalidRecycleView(List<HomePageBean.DataBean.ListAdvBean> listAdv, List<HomePageBean.DataBean.ListShopRecommendBean> listShopRecommend) {

        int indexAdv = listAdv.size() - 1;
        int indexRec = listShopRecommend.size() - 1;
        int mSize = indexAdv + indexRec + 2;
        objectList = new ArrayList<>();
        for (int i = 0; i < mSize; i++) {
            if (i % 2 == 0) {
                if (indexAdv >= 0) {
                    if (listAdv.get(indexAdv) != null) {
                        objectList.add(listAdv.get(indexAdv));
                        indexAdv--;
                    }
                }
            } else {
                if (indexRec >= 0) {
                    objectList.add(listShopRecommend.get(indexRec));
                    indexRec--;
                }
            }
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRecommend.setLayoutManager(linearLayoutManager);
        RvRecommendAdapter rvRecommendAdapter = new RvRecommendAdapter(getContext());
        rvRecommendAdapter.setData(objectList);
        rvRecommend.setAdapter(rvRecommendAdapter);
        rvRecommendAdapter.setmOnClick(new OnRecommendCardViewClickListener() {
            @Override
            public void onClick(int position) {
                intentShopXiangqing(position);
            }
        });
    }

    private void intentShopXiangqing(int position) {
        Intent intent = new Intent(getContext(),ShopXiangqingActivity.class);
        if (objectList != null) {
            intent.putExtra("shopBean",objectList.get(position));
        }
        startActivity(intent);
    }


    private void invalidBanner(List<HomePageBean.DataBean.ListShopHotBean> list_shop_hot) {
        bannerRecommend.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        List<String> paths = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        for (HomePageBean.DataBean.ListShopHotBean e : list_shop_hot) {
            paths.add(Contans.URL_SHOP + e.getShopThumbnail());
            LogUtil.e(TAG, Contans.URL_SHOP + e.getShopThumbnail());
            titles.add(e.getShopDesc());
        }
        bannerRecommend.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .placeholder(R.mipmap.jiazaizhong)
                        .error(R.mipmap.tupianjiazaishibai)
                        .into(imageView);
            }
        });
        bannerRecommend.setDelayTime(4000);
        bannerRecommend.setBannerAnimation(Transformer.Accordion);
        bannerRecommend.setImages(paths);
        bannerRecommend.setBannerTitles(titles);
        bannerRecommend.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();
    }


    @Override
    public void onEmpty() {
        mUILoader.updateStatus(UILoader.UIStatus.EMPTY);
    }

    @Override
    public void onError() {
        mUILoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
    }

    @Override
    public void onLoading() {
        mUILoader.updateStatus(UILoader.UIStatus.LOADING);
    }

    @Override
    public void onRetryClick() {
        if (!userToken.equals("")) {
            getPresenter().getRecommendList(userToken);
            mUILoader.updateStatus(UILoader.UIStatus.LOADING);
        } else {
            mUILoader.updateStatus(UILoader.UIStatus.EMPTY);
        }

    }

    @Override
    public void OnBannerClick(int position) {

    }

}
