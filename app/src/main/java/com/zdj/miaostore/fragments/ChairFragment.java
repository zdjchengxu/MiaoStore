package com.zdj.miaostore.fragments;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.adapter.RvChairAdapter;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.interfaces.ChairView;
import com.zdj.miaostore.presenter.ChairPresenter;
import com.zdj.miaostore.customview.UILoader;

public class ChairFragment extends BaseFragmentS<ChairView,ChairPresenter>implements ChairView, UILoader.OnRetryClickListener {

    private View rootView;
    private UILoader mUILoader;
    RecyclerView rvChari;
    RvChairAdapter mRvChairAdapter;

    @Override
    protected ChairView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected ChairPresenter createPresenter() {
        return new ChairPresenter();
    }

    @Override
    protected View onSubViewLoaded(final LayoutInflater layoutInflater, ViewGroup container) {
        mUILoader = new UILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(layoutInflater,container);
            }
        };
        mUILoader.setOnRetryClickListener(this);
        if (mUILoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUILoader.getParent()).removeView(mUILoader);
        }
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvChari.setLayoutManager(manager);
        mRvChairAdapter = new RvChairAdapter(getContext());
        getPresenter().getCategoryChair();
        return mUILoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        rootView = layoutInflater.inflate(R.layout.fragment_chair,container,false);
        rvChari = rootView.findViewById(R.id.rv_chair);
        return rootView;
    }

    @Override
    public void onSuccess(final CategoryDataBean categoryDataBean) {
        mUILoader.updateStatus(UILoader.UIStatus.SUCCESS);
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                mRvChairAdapter.setDatalist(categoryDataBean.getData().getList());
                mRvChairAdapter.notifyDataSetChanged();
                rvChari.setAdapter(mRvChairAdapter);
            }
        });
    }

    @Override
    public void onNetError() {

    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onRetryClick() {
        getPresenter().getCategoryChair();
    }
}
