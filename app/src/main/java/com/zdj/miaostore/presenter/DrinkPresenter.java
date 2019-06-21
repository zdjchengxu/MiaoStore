package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.interfaces.DrinkView;
import com.zdj.miaostore.model.DrinkModel;

public class DrinkPresenter extends BasePresenter<DrinkView> {

    private DrinkModel drinkModel;

    public DrinkPresenter() {
        this.drinkModel = new DrinkModel();
    }

    public void getCategoryDrink(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                getBaseView().onLoading();
                CategoryDataBean categoryDrink = drinkModel.getCategoryDrink();
                if (categoryDrink != null) {
                    if(categoryDrink.getData().getList().size() != 0){
                        getBaseView().onSuccess(categoryDrink);
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
