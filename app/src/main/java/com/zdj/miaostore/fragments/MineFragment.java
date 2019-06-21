package com.zdj.miaostore.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zdj.miaostore.MyStoreApplication;
import com.zdj.miaostore.R;
import com.zdj.miaostore.base.BaseFragmentS;
import com.zdj.miaostore.bean.AddressBean;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.interfaces.MineView;
import com.zdj.miaostore.presenter.MinePresenter;
import com.zdj.miaostore.util.Contans;

public class MineFragment extends BaseFragmentS<MineView, MinePresenter> implements MineView {

    //&addressName=海南省琼海市嘉积镇富海路158号&addressDesc=zdj添加的地址测试&addressPhone=15607535217&addressUserName=赵&addressType=1
    //userToken=c474f8853ef06851957836fc790fe29b&userId=67

    private TextView tvUserName, tvUserPhone, tvEditAdd, tvUserAdd, tvCheackOrder;
    private LinearLayout lineMyOrder;
    private ImageView ivHead;
    private User user;

    @Override
    protected View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.fragment_mine, container, false);
        MyStoreApplication myStoreApplication = (MyStoreApplication) getActivity().getApplication();
        user = myStoreApplication.getUser();
        initView(view);
        return view;
    }

    private void initView(View view) {
        tvCheackOrder = view.findViewById(R.id.tv_cheackorder_mine);
        ivHead = view.findViewById(R.id.iv_head_mine);
        tvUserAdd = view.findViewById(R.id.tv_useradd_mine);
        tvEditAdd = view.findViewById(R.id.tv_editadd_mine);
        tvUserName = view.findViewById(R.id.tv_username_mine);
        tvUserPhone = view.findViewById(R.id.tv_userphone_mine);
        lineMyOrder = view.findViewById(R.id.line_myorder_mine);
        tvEditAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        tvCheackOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        if (user != null) {
            updateView();
        }
    }

    private void updateView() {
        getPresenter().getMyDefaultAddress(user.getData().getUserToken(), user.getData().getUserId());
        Glide.with(getContext()).load(Contans.URL_SHOP + user.getData().getUserImg()).into(ivHead);
        tvUserPhone.setText(user.getData().getUserPhone());
        tvUserName.setText(user.getData().getUsername());


    }

    @Override
    protected MineView createView() {
        getPresenter().attachView(this);
        return this;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    public void onSuccess(final AddressBean addressBean) {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                for (AddressBean.DataBean.ListBean e : addressBean.getData().getList()) {
                    if (e.getAddressType() == Contans.ADDRESS_TYPE_DEFAULT) {
                        tvUserAdd.setText(e.getAddressName());
                    }
                }
            }
        });
    }

    @Override
    public void onError() {
        MyStoreApplication.getmHandler().post(new Runnable() {
            @Override
            public void run() {
                tvUserAdd.setText("请设置默认地址");
            }
        });
    }
}
