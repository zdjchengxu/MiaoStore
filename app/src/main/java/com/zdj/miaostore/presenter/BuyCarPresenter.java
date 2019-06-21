package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.BuyCarBean;
import com.zdj.miaostore.interfaces.BuyCarView;
import com.zdj.miaostore.model.BuyCarModel;
import com.zdj.miaostore.util.LogUtil;

public class BuyCarPresenter extends BasePresenter<BuyCarView> {

    private BuyCarModel buyCarModel;

    public BuyCarPresenter() {
        this.buyCarModel = new BuyCarModel();
    }
    public void getBuycarListData(final String userToken, final String userId){
        getBaseView().onLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                BuyCarBean buycarListData = buyCarModel.getBuycarListData(userToken, userId);
                if(buycarListData != null){

                    if(buycarListData.getData().getList().size() != 0){
                        getBaseView().onSuccess(buycarListData);
                    }else{
                        getBaseView().onEmpty();
                    }
                }else{
                    getBaseView().onNetError();
                }
            }
        }).start();

    }


}
