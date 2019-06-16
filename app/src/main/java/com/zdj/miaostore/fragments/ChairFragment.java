package com.zdj.miaostore.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseFragment;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.interfaces.ChairView;
import com.zdj.miaostore.presenter.ChairPresenter;

public class ChairFragment extends BaseFragmentS<ChairView,ChairPresenter>implements ChairView {

    private View rootView;

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
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        rootView = layoutInflater.inflate(R.layout.fragment_buycar,container,false);
        return rootView;
    }
}
