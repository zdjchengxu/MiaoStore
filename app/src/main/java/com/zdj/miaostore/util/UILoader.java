package com.zdj.miaostore.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;

public abstract class UILoader extends FrameLayout {

    private View loadingView;
    private View successView;
    private View netWorkErrorView;
    private View emptyView;
    private OnRetryClickListener onRetryClickListener;

    public enum UIStatus {
        LOADING, SUCCESS, NETWORK_ERROR, EMPTY, NONE
    }

    public UIStatus mUIStatus;

    public UILoader(@NonNull Context context) {
        this(context, null);
    }

    public UILoader(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public UILoader(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mUIStatus = UIStatus.NONE;
        init();
    }

    public void updateStatus(final UIStatus status) {
        mUIStatus = status;
        //更新UI一定要在主线程上
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                switchUIByCurrentStatus();
            }
        });
    }

    /**
     * 初始化UI
     */
    private void init() {
        switchUIByCurrentStatus();
    }

    private void switchUIByCurrentStatus() {
        //加载中
        if (loadingView == null) {
            loadingView = getLoadingView();
            addView(loadingView);
        }
        //根据状态设置是否可见
        loadingView.setVisibility(mUIStatus == UIStatus.LOADING ? VISIBLE : GONE);

        //成功
        if (successView == null) {
            successView = getSuccessView(this);
            addView(successView);
        }
        //根据状态设置是否可见
        successView.setVisibility(mUIStatus == UIStatus.SUCCESS ? VISIBLE : GONE);

        //网络错误页面
        if (netWorkErrorView == null) {
            netWorkErrorView = getNetWorkErrorView();
            addView(netWorkErrorView);
        }
        //根据状态设置是否可见
        netWorkErrorView.setVisibility(mUIStatus == UIStatus.NETWORK_ERROR ? VISIBLE : GONE);

        //数据为空界面
        if (emptyView == null) {
            emptyView = getEmptyView();
            addView(emptyView);
        }
        //根据状态设置是否可见
        emptyView.setVisibility(mUIStatus == UIStatus.EMPTY ? VISIBLE : GONE);


    }

    private static final String TAG = "UILoader";

    private View getEmptyView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_empty_view, this, false);
    }

    private View getNetWorkErrorView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_netwrokerror_view, this, false);
        view.findViewById(R.id.iv_neterror).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //网络加载出错
                if (onRetryClickListener != null) {
                    onRetryClickListener.onRetryClick();
                }
            }
        });
        return view;
    }

    protected abstract View getSuccessView(ViewGroup container);

    private View getLoadingView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_loading_view, this, false);
    }

    public void setOnRetryClickListener(OnRetryClickListener onRetryClickListener) {
        this.onRetryClickListener = onRetryClickListener;
    }

    public interface OnRetryClickListener {
        void onRetryClick();
    }

}