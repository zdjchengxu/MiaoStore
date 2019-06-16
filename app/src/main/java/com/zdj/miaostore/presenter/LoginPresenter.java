package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.model.LoginModel;
import com.zdj.miaostore.interfaces.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private LoginModel model;
    public LoginPresenter(){
        this.model = new LoginModel();
    }

    public void sendLogin(final String userPhone, final String userPwd) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                User user = model.login(userPhone, userPwd);
                if(getBaseView() != null){
                    if (user != null) {
                        getBaseView().onLoginSuccess(user);
                    } else {
                        getBaseView().onLoginError();
                    }
                }

            }
        }).start();

    }

    /*public void sendRegister(final String userPhone, final String userPwd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetBack netBack = model.register(userPhone, userPwd);
                LogUtil.e("P",netBack.toString());
            }
        }).start();

    }*/

}
