package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.AddressBean;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MineModel {

    private JSONObject jsonObject = null;

    public AddressBean getMyDefaultAddress(String userToken, int userId){
        Map<String,String>mMap = new HashMap<>();
        mMap.put("userToken",userToken);
        mMap.put("userId",userId+"");
        try {
            jsonObject = OkHttp.sendGet("/address", mMap);
            return new Gson().fromJson(jsonObject.toString(), AddressBean.class);
        }catch (Exception e){
            return null;
        }



    }

}
