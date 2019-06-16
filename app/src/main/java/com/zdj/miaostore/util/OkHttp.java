package com.zdj.miaostore.util;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp {

    private static final String TAG = "OkHttp";
    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    private static String url = "http://119.27.173.65:10010/shop";

    public static JSONObject sendGet(String action, Map<String, String> mParamsMap) {
        String mUrl = url + action;
        if (mParamsMap != null) {
            mUrl = mUrl + "?";
            for (String key : mParamsMap.keySet()) {
                mUrl = mUrl + key + "=" + mParamsMap.get(key) + "&";
            }
            mUrl = mUrl.substring(0, mUrl.length() - 1);
        }
        JSONObject jsonObject1 = null;
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(mUrl)
                .get()
                .build();
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String str = response.body().string();
                LogUtil.e(TAG, "str:" + str);
                jsonObject1 = new JSONObject(str);
            } else {
                LogUtil.e(TAG, "失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }

    public static JSONObject sendPost(String action, Map<String, String> mParamsMap) {
        String mUrl = url + action;
        if (mParamsMap != null) {
            mUrl = mUrl + "?";
            for (String key : mParamsMap.keySet()) {
                mUrl = mUrl + key + "=" + mParamsMap.get(key) + "&";
            }
            mUrl = mUrl.substring(0, mUrl.length() - 1);
        }
        JSONObject jsonObject1 = null;
        Response response = null;
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON,"");
        Request request = new Request.Builder()
                .url(mUrl)
                .post(requestBody)
                .build();
        try {
            Log.e("Tag", "str:");
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String str = response.body().string();
                Log.e("Tag", "str:" + str);
                jsonObject1 = new JSONObject(str);
            } else {
                Log.e("Tag", "失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject1;
    }




}
