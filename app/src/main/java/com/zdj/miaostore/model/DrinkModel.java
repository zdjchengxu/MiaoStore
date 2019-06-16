package com.zdj.miaostore.model;

import com.google.gson.Gson;
import com.zdj.miaostore.bean.CategoryDataBean;
import com.zdj.miaostore.util.Contans;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

public class DrinkModel {

    public CategoryDataBean getCategoryDrink(){

        JSONObject jsonObject = null;
        CategoryDataBean categoryDataBean = null;
        try {
            jsonObject = OkHttp.sendGet("/homePage/shop/"+Contans.CATEGORY_DRINK,null);
            categoryDataBean = new Gson().fromJson(jsonObject.toString(), CategoryDataBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return categoryDataBean;
    }

}
