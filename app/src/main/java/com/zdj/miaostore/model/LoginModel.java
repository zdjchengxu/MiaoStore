package com.zdj.miaostore.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.bean.User;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginModel {

    public User login(String userPhone, String userPassword) {
        User user = null;
        Map<String, String> mParme = new HashMap<>();
        mParme.put("userPhone", userPhone);
        mParme.put("userPassword", userPassword);
        JSONObject result = OkHttp.sendGet("/login", mParme);
        if (result != null) {
            user = new Gson().fromJson(result.toString(), User.class);
            if (user != null) {
                return user;
            }
        }
        return null;
    }


}
