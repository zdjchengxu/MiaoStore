package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.interfaces.RegisterView;
import com.zdj.miaostore.model.RegisterModel;
import com.zdj.miaostore.util.LogUtil;

public class RegisterPresenter extends BasePresenter<RegisterView> {

    RegisterModel mRegisterModel;

    public RegisterPresenter() {
        mRegisterModel = new RegisterModel();
    }

    public void sendRegister(final String userPhone, final String userPwd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetBack netBack = mRegisterModel.register(userPhone, userPwd);
                LogUtil.e("P", netBack.toString());
                if (netBack != null) {
                    if (netBack.getCode() == 200) {
                        getBaseView().onRegisterSuccess(netBack);
                    } else {
                        getBaseView().onRegisterError(netBack);
                    }
                } else getBaseView().onRegisterError(netBack);
            }
        }).start();

    }

}
