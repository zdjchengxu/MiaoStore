package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.AskStatusBean;

public interface ShopXiangqingView extends BaseView {

    void onNetErrorStatus(AskStatusBean code);
    void onSuccess();

}
