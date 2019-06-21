package com.zdj.miaostore;

import android.app.Application;
import android.os.Handler;

import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.SharedPreferencesManager;


public class MyStoreApplication extends Application {

    private static Handler mHandler = null;
    private User user;


    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(false);
        SharedPreferencesManager.init(this,true,"setting");
        mHandler = new Handler();
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public void createUser(User user) {
        if (user != null) {
            this.user = user;
        }
    }

    public User getUser() {
        if (this.user != null) {
            return this.user;
        } else {
            return null;
        }
    }
}
