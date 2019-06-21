package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.AskStatusBean;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopXiangqingModel {

//    /addShoppCard

    public AskStatusBean addShoppCard(String userToken, int shopId, String shopSum, int userId) {
        Map<String, String> mMap = new LinkedHashMap<>();
        mMap.put("userToken", userToken);
        mMap.put("shopId", shopId + "");
        mMap.put("shoppcardbaseSum", shopSum);
        mMap.put("userId", userId + "");
        JSONObject jsonObject = null;
        try {
            jsonObject = OkHttp.sendPost("/addShoppCard", mMap);
            return new Gson().fromJson(jsonObject.toString(),AskStatusBean.class);
        }catch (Exception e){
            return null;
        }
    }


}
