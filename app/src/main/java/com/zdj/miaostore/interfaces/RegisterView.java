package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.NetBack;

public interface RegisterView extends BaseView {

    void onRegisterSuccess(NetBack mNetBack);

    void onRegisterError(NetBack mNetBack);

}
