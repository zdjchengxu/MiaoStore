package com.zdj.miaostore.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.adapter.RvBuyCarAdapter;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.BuyCarBean;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.customview.BaseUILoader;
import com.zdj.miaostore.interfaces.BuyCarView;
import com.zdj.miaostore.presenter.BuyCarPresenter;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.LogUtil;

public class BuycarFragment extends BaseFragmentS<BuyCarView, BuyCarPresenter> implements BuyCarView, BaseUILoader.OnBaseRetryClickListener {

    private View view;
    private static final String TAG = "BuycarFragment";
    private BaseUILoader mUILoader;
    private TextView tvManager;
    private RecyclerView rvBuycar;
    private RvBuyCarAdapter mRvBuyCarAdapter;
    private User user;

    @Override
    protected BuyCarView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected BuyCarPresenter createPresenter() {
        return new BuyCarPresenter();
    }

    @Override
    protected View onSubViewLoaded(final LayoutInflater layoutInflater, ViewGroup container) {
        mUILoader = new BaseUILoader(getContext()) {
            @Override
            protected View getEmptyView(ViewGroup container) {
                return createEmptyView(layoutInflater, container);
            }

            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(layoutInflater, container);
            }
        };

        mRvBuyCarAdapter = new RvBuyCarAdapter(getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvBuycar.setLayoutManager(manager);

        MyStoreApplication application = (MyStoreApplication) getActivity().getApplication();
        user = application.getUser();

        mUILoader.setOnRetryClickListener(this);
        if (mUILoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUILoader.getParent()).removeView(mUILoader);
        }
        getPresenter().getBuycarListData(user.getData().getUserToken(), user.getData().getUserId() + "");

        return mUILoader;
    }

    private View createEmptyView(LayoutInflater layoutInflater, ViewGroup container) {
        return layoutInflater.inflate(R.layout.layout_emptybuycar, container, false);
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        view = layoutInflater.inflate(R.layout.fragment_buycar, container, false);
        tvManager = view.findViewById(R.id.tv_manage_buycar);
        rvBuycar = view.findViewById(R.id.rv_buycar);
        return view;
    }


    @Override
    public void onSuccess(final BuyCarBean buyCarBean) {

        mUILoader.updateStatus(Contans.BaseUIStatus.SUCCESS);
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                LogUtil.e("hei", "这儿" + buyCarBean.toString());
                mRvBuyCarAdapter.setData(buyCarBean.getData().getList());
                mRvBuyCarAdapter.notifyDataSetChanged();
                rvBuycar.setAdapter(mRvBuyCarAdapter);
                registerReceiver();
            }
        });
    }

    @Override
    public void onEmpty() {
        mUILoader.updateStatus(Contans.BaseUIStatus.EMPTY);
    }

    @Override
    public void onNetError() {
        mUILoader.updateStatus(Contans.BaseUIStatus.NETWORK_ERROR);
    }

    @Override
    public void onLoading() {
        mUILoader.updateStatus(Contans.BaseUIStatus.LOADING);
    }

    @Override
    public void onRetryClick() {
        if (getPresenter() != null && user != null) {
            getPresenter().getBuycarListData(user.getData().getUserToken(), user.getData().getUserId() + "");
        }
    }

    /**
     * 注册广播接收器
     */
    private void registerReceiver() {
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(getActivity());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mineAction");
        broadcastManager.registerReceiver(mAdDownLoadReceiver, intentFilter);
    }

    //原创作品，未经允许禁止转载，转载请注明来自：http://www.cnblogs.com/jiangbeixiaoqiao/
    private BroadcastReceiver mAdDownLoadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String change = intent.getStringExtra("change");
            if ("yes".equals(change)) {
                // 这地方只能在主线程中刷新UI,子线程中无效，因此用Handler来实现
                MyStoreApplication.getmHandler().post(new Runnable() {
                    public void run() {
                        //在这里来写你需要刷新的地方
                        //例如：testView.setText("恭喜你成功了");
                        getPresenter().getBuycarListData(user.getData().getUserToken(), user.getData().getUserId() + "");
                    }
                });
            }
        }
    };

}
