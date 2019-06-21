package com.zdj.miaostore.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdj.miaostore.R;
import com.zdj.miaostore.adapter.ShopIndicatorAdapter;
import com.zdj.miaostore.adapter.ShopVpAdapter;
import com.zdj.miaostore.base.BaseFragment;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.interfaces.ShopView;
import com.zdj.miaostore.presenter.ShopPresenter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShopFragment extends BaseFragmentS<ShopView,ShopPresenter> implements ShopView {

    @BindView(R.id.shop_magic_indicator)
    MagicIndicator shopMagicIndicator;
    @BindView(R.id.shop_vp)
    ViewPager shopVp;
    private View view;
    private ShopIndicatorAdapter shopIndicatorAdapter;
    private ShopVpAdapter shopVpAdapter;
    private Unbinder unbinder;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        view = layoutInflater.inflate(R.layout.fragment_shop, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        initMagicIndicator();
    }

    //初始化indicator
    private void initMagicIndicator() {
        shopMagicIndicator.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        //创建一个适配器
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        shopIndicatorAdapter = new ShopIndicatorAdapter(getContext());
        shopIndicatorAdapter.setOnIndicatorTapClickListener(new ShopIndicatorAdapter.OnIndicatorTapClickListener() {
            @Override
            public void onTabClick(int index) {
                if (shopVp != null) {
                    shopVp.setCurrentItem(index);
                }
            }
        });
        commonNavigator.setAdapter(shopIndicatorAdapter);
        commonNavigator.setAdjustMode(true);
        //创建内容适配器
        shopVpAdapter = new ShopVpAdapter(getChildFragmentManager());
        shopVp.setAdapter(shopVpAdapter);
        //绑定ViewPager
        shopMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(shopMagicIndicator, shopVp);
    }


    @Override
    protected ShopView createView() {
        return this;
    }

    @Override
    protected ShopPresenter createPresenter() {
        return new ShopPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
