package com.zdj.miaostore.fragments;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.adapter.RvDrinkAdapter;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.interfaces.DrinkView;
import com.zdj.miaostore.presenter.DrinkPresenter;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.customview.UILoader;


public class DrinkFragment extends BaseFragmentS<DrinkView, DrinkPresenter> implements DrinkView, UILoader.OnRetryClickListener {

    RecyclerView rvDrink;
    private View rootView;
    private UILoader mUILoader;
    private static final String TAG = "DrinkFragment";
    private RvDrinkAdapter rvDrinkAdapter;

    @Override
    protected DrinkView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected DrinkPresenter createPresenter() {
        return new DrinkPresenter();
    }

    @Override
    protected View onSubViewLoaded(final LayoutInflater layoutInflater, ViewGroup container) {
        mUILoader = new UILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(layoutInflater,container);
            }
        };

        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        rvDrink.setLayoutManager(manager);

        rvDrinkAdapter = new RvDrinkAdapter(getContext());

        mUILoader.setOnRetryClickListener(this);
        if (mUILoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUILoader.getParent()).removeView(mUILoader);
        }
        getPresenter().getCategoryDrink();
        return mUILoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        rootView = layoutInflater.inflate(R.layout.fragment_drink, container, false);
        rvDrink = rootView.findViewById(R.id.rv_drink);
        return rootView;
    }


    @Override
    public void onSuccess(final CategoryDataBean categoryDataBean) {
        LogUtil.e(TAG,categoryDataBean.toString());
        mUILoader.updateStatus(UILoader.UIStatus.SUCCESS);
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                rvDrinkAdapter.setDataList(categoryDataBean.getData().getList());
                rvDrinkAdapter.notifyDataSetChanged();
                rvDrink.setAdapter(rvDrinkAdapter);
            }
        });
    }

    @Override
    public void onLoading() {
        mUILoader.updateStatus(UILoader.UIStatus.LOADING);
    }

    @Override
    public void onEmpty() {
        mUILoader.updateStatus(UILoader.UIStatus.EMPTY);
    }

    @Override
    public void onNetError() {
        mUILoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
    }


    @Override
    public void onRetryClick() {
        getPresenter().getCategoryDrink();
    }
}
