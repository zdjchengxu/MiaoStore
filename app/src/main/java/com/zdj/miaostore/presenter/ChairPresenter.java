package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.interfaces.ChairView;
import com.zdj.miaostore.model.ChairModel;

public class ChairPresenter extends BasePresenter<ChairView> {

    ChairModel chairModel;

    public ChairPresenter() {
        this.chairModel = new ChairModel();
    }

    public void getCategoryChair() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getBaseView().onLoading();
                CategoryDataBean categoryDrink = chairModel.getCategoryChair();
                if (categoryDrink != null) {
                    if (categoryDrink.getData().getList().size() != 0) {
                        getBaseView().onSuccess(categoryDrink);
                    } else {
                        getBaseView().onEmpty();
                    }
                } else {
                    getBaseView().onNetError();
                }
            }
        }).start();
    }

}
