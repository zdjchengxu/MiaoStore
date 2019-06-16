package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.HomePageBean;

public interface RecommendView extends BaseView {

    void onSuccess(HomePageBean homePageBean);

    //错误
    void onEmpty();

    //为空
    void onError();

    void onLoading();

}
