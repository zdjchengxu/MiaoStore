package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.SpaceBean;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SpaceModel {

    public SpaceBean getSpaceDataList() {
        Map<String, String> parmes = new HashMap<>();
        parmes.put("page", 1 + "");
        parmes.put("pageSize", 10 + "");
        JSONObject jsonObject = null;
        try {
            jsonObject = OkHttp.sendGet("/homePage/selectSpaceAll", parmes);
            return new Gson().fromJson(jsonObject.toString(), SpaceBean.class);
        } catch (Exception e) {
            return null;
        }
    }

}
