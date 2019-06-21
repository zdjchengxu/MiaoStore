package com.zdj.miaostore.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.activity.ReleaseActivity;
import com.zdj.miaostore.adapter.RvSpaceAdapter;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.SpaceBean;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.customview.SpaceUILoader;
import com.zdj.miaostore.interfaces.SpaceView;
import com.zdj.miaostore.presenter.SpacePresenter;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.StatusBarUtil;

public class SpaceFragment extends BaseFragmentS<SpaceView, SpacePresenter> implements SpaceView, SpaceUILoader.OnRetryClickListener {

    private SpaceUILoader spaceUILoader;
    private View successView;
    private CollapsingToolbarLayout collapsingToolbar;
    private RecyclerView rvSpace;
    private AppBarLayout appBarLayout;
    private ImageView ivHead,ivSpace;
    private User user;
    private RvSpaceAdapter rvSpaceAdapter;


    @Override
    protected SpaceView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected SpacePresenter createPresenter() {
        return new SpacePresenter();
    }

    @Override
    protected View onSubViewLoaded(final LayoutInflater layoutInflater, ViewGroup container) {
        spaceUILoader = new SpaceUILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(layoutInflater, container);
            }
        };

        getPresenter().getSpaceDataList();
        spaceUILoader.setOnRetryClickListener(this);

        if (spaceUILoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) spaceUILoader.getParent()).removeView(spaceUILoader);
        }

        return spaceUILoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        MyStoreApplication application = (MyStoreApplication) getActivity().getApplication();
        user = application.getUser();

        successView = layoutInflater.inflate(R.layout.fragment_space, container, false);
        StatusBarUtil.setStatusBar(getActivity(), false);

        collapsingToolbar = successView.findViewById(R.id.collapsing_toolbar_space);
        appBarLayout = successView.findViewById(R.id.appBar_space);
        ivHead = successView.findViewById(R.id.iv_head_space);
        rvSpace = successView.findViewById(R.id.rv_space);
        ivSpace = successView.findViewById(R.id.iv_fabu_space);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSpace.setLayoutManager(linearLayoutManager);
        rvSpaceAdapter = new RvSpaceAdapter(getContext());

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int color = Color.argb(200, 0, 0, 0);
                collapsingToolbar.setCollapsedTitleTextColor(color);
                if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) { // 折叠状态
                    collapsingToolbar.setTitle("朋友圈");
                    ivHead.setVisibility(View.GONE);
                } else { // 非折叠状态
                    collapsingToolbar.setTitle("");
                    ivHead.setVisibility(View.VISIBLE);
                }
            }
        });

        ivSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentCamera();
            }
        });

        return successView;
    }

    private void intentCamera() {
        Intent intent = new Intent(getActivity(),ReleaseActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoading() {
        spaceUILoader.updateStatus(SpaceUILoader.SpaceUIStatus.LOADING);
    }

    @Override
    public void onSuccess(final SpaceBean mSpaceBean) {
        spaceUILoader.updateStatus(SpaceUILoader.SpaceUIStatus.SUCCESS);
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                if (user != null) {
                    Glide.with(getActivity()).load(Contans.URL_SHOP + user.getData().getUserImg()).into(ivHead);
                }
                rvSpaceAdapter.setDatalist(mSpaceBean.getData().getList());
                rvSpaceAdapter.notifyDataSetChanged();
                rvSpace.setAdapter(rvSpaceAdapter);
            }
        });
    }

    @Override
    public void onNetWorkError() {
        spaceUILoader.updateStatus(SpaceUILoader.SpaceUIStatus.NETWORK_ERROR);
    }

    @Override
    public void onEmpty() {
        spaceUILoader.updateStatus(SpaceUILoader.SpaceUIStatus.EMPTY);
    }

    @Override
    public void onRetryClick() {
        if (getPresenter() != null) {
            getPresenter().getSpaceDataList();
        }
    }


}
