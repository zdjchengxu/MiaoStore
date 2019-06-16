package com.zdj.miaostore.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragmentS <V extends BaseView, P extends BasePresenter<V>> extends Fragment {

    private P presenter;
    private V view;
    private View rootView;

    public P getPresenter() {
        if(presenter == null){
            createPresenter();
        }
        return presenter;
    }

    protected abstract V createView();
    protected abstract P createPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = onSubViewLoaded(inflater,container);
        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter != null && this.view != null) {
            this.presenter.detachView();
        }
    }
    protected abstract View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container);
}