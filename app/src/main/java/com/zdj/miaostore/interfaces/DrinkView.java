package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.CategoryDataBean;

public interface DrinkView extends BaseView {

    void onSuccess(CategoryDataBean categoryDataBean);

    void onLoading();

    void onEmpty();

    void onNetError();

}
