package com.zdj.miaostore.model;

import android.hardware.usb.UsbRequest;
import android.util.Log;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.HomePageBean;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

public class RecommendModel {

    private static final String TAG = "RecommendModel";
    private static String action = "/homePage/";

    public HomePageBean getRecommendList(String userToken){
        LogUtil.e(TAG,action+userToken);
        JSONObject jsonObject = OkHttp.sendGet(action + userToken, null);

        if(jsonObject != null){
            HomePageBean homePageBean = new Gson().fromJson(jsonObject.toString(), HomePageBean.class);
            if (homePageBean != null) {
                return homePageBean;
            }
        }
        return null;
    }

}
