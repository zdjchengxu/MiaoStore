package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.BuyCarBean;

public interface BuyCarView extends BaseView {

    void onSuccess(BuyCarBean buyCarBean);

    void onEmpty();

    void onNetError();

    void onLoading();


}
