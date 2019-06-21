package com.zdj.miaostore.model;

import android.nfc.Tag;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.BuyCarBean;
import com.zdj.miaostore.util.LogUtil;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.OAEPParameterSpec;

public class BuyCarModel {

    private static final String TAG = "BuyCarModel";

    public BuyCarBean getBuycarListData(String userToken, String userId) {
        Map<String,String>parmes = new HashMap<>();
        parmes.put("userToken",userToken);
        parmes.put("userId",userId);
        try {
            JSONObject jsonObject = OkHttp.sendGet("/selectShoppCard", parmes);
            LogUtil.e(TAG,jsonObject.toString());
            return new Gson().fromJson(jsonObject.toString(),BuyCarBean.class);
        }catch (Exception e){
            return null;
        }
    }

}
