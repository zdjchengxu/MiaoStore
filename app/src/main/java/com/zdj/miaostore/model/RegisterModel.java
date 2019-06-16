package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterModel  {

    public NetBack register(String userPhone, String userPassword){
        NetBack mNetBack = null;
        Map<String, String> mParme = new HashMap<>();
        mParme.put("userPhone", userPhone);
        mParme.put("userPassword", userPassword);
        JSONObject result = OkHttp.sendPost("/register", mParme);
        mNetBack = new Gson().fromJson(result.toString(), NetBack.class);
        if (mNetBack != null) {
            return mNetBack;
        }
        return null;
    }

}
