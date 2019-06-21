package com.zdj.miaostore.util;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttp {

    private static final String TAG = "OkHttp";
    private static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
    private static String url = "http://119.27.173.65:10010/shop";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/");

    public static JSONObject sendPost(String action, Map<String, String> map, List<String> paths) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        //遍历map中所有参数到builder
        for (String key : map.keySet()) {
            builder.addFormDataPart(key, map.get(key));
        }
        //遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
        for (String path : paths) {
            LogUtil.e(TAG, "img路径" + path);
            builder.addFormDataPart("spaceImg", "jpg", RequestBody.create(MEDIA_TYPE_PNG, new File(path)));
        }
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "...")
                .url(url + action)
                .post(requestBody)
                .build();

        try {
            Response execute = mOkHttpClient.newCall(request).execute();
            if (execute.isSuccessful()) {
                String str = execute.body().string();
                return new JSONObject(str);
            } else {
                LogUtil.e(TAG, "失败.......");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

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
        RequestBody requestBody = RequestBody.create(JSON, "");
        Request request = new Request.Builder()
                .url(mUrl)
                .post(requestBody)
                .build();
        try {
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
