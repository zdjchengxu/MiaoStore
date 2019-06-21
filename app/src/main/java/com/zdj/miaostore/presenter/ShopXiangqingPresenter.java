package com.zdj.miaostore.presenter;

import android.util.Log;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.AskStatusBean;
import com.zdj.miaostore.interfaces.ShopXiangqingView;
import com.zdj.miaostore.model.ShopXiangqingModel;

public class ShopXiangqingPresenter extends BasePresenter<ShopXiangqingView> {

    ShopXiangqingModel shopXiangqingModel;

    public ShopXiangqingPresenter() {
        shopXiangqingModel = new ShopXiangqingModel();
    }

    public void addShoppCard(final String userToken, final int shopId, final String shopSum, final int userId){
        if (shopXiangqingModel != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    AskStatusBean askStatusBean = shopXiangqingModel.addShoppCard(userToken, shopId, shopSum, userId);
                    if(askStatusBean != null){
                        if(askStatusBean.getCode() == 200){
                            getBaseView().onSuccess();
                        }else{
                            getBaseView().onNetErrorStatus(askStatusBean);
                        }
                    }
                }
            }).start();
        }
    }

}

