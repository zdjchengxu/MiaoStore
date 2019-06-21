package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.HomePageBean;
import com.zdj.miaostore.interfaces.RecommendView;
import com.zdj.miaostore.model.RecommendModel;
import com.zdj.miaostore.util.LogUtil;

public class RecommendPresenter extends BasePresenter<RecommendView> {

    private RecommendModel recommendModel = null;
    private static final String TAG = "RecommendPresenter";

    public RecommendPresenter() {
        this.recommendModel = new RecommendModel();
    }

    public void getRecommendList(final String userToken) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if(getBaseView() != null){
                    getBaseView().onLoading();
                }

                HomePageBean homePageBean = recommendModel.getRecommendList(userToken);
                if(homePageBean != null){
                    if(homePageBean.getData().getList_shop_recommend().size() == 0 && homePageBean.getData().getList_adv().size() == 0){
                        getBaseView().onEmpty();
                    }else {
                        getBaseView().onSuccess(homePageBean);
                    }
                }else{
                    LogUtil.e(TAG,"失败");
                    getBaseView().onError();
                }
            }
        }).start();

    }
}
