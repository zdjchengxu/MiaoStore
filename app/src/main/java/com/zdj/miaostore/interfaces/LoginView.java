package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.User;

public interface LoginView extends BaseView {

    /**
     * 登录成功回调
     * */
    void onLoginSuccess(User user);

    /**
     * 登录失败回调
     * */
    void onLoginError();



}
