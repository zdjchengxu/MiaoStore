package com.zdj.miaostore.presenter;

import com.google.gson.Gson;
import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.AddressBean;
import com.zdj.miaostore.interfaces.MineView;
import com.zdj.miaostore.model.MineModel;
import com.zdj.miaostore.util.OkHttp;

import java.util.HashMap;
import java.util.Map;

public class MinePresenter extends BasePresenter<MineView> {

    private MineModel model;

    public MinePresenter() {
        model = new MineModel();
    }

    public void getMyDefaultAddress(final String userToken, final int userId){
        new Thread(new Runnable() {
            @Override
            public void run() {
                AddressBean myDefaultAddress = model.getMyDefaultAddress(userToken, userId);
                if(myDefaultAddress != null){
                    getBaseView().onSuccess(myDefaultAddress);
                }else{
                    getBaseView().onError();
                }
            }
        }).start();

    }

}
