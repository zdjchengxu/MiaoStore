package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.CategoryDataBean;

public interface ChairView extends BaseView {

    void onSuccess(CategoryDataBean categoryDataBean);

    void onNetError();

    void onEmpty();

    void onLoading();

}
