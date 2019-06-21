package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReleaseModel {

    public NetBack sendSpaceMsg(String userToken, int userId, int spaceType, String spaceContent, List<String>paths){
        Map<String,String>mMap = new HashMap<>();
        mMap.put("userId",userId+"");
        mMap.put("userToken",userToken);
        mMap.put("spaceType",spaceType+"");
        mMap.put("spaceContent",spaceContent);
        mMap.put("spaceTile","标题_zdj");
        JSONObject jsonObject = OkHttp.sendPost("/homePage/releaseMessage", mMap, paths);
        if(jsonObject != null){
            return new Gson().fromJson(jsonObject.toString(),NetBack.class);
        }
        return null;
    }

}
