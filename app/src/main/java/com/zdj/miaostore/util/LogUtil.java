package com.zdj.miaostore.util;

import android.util.Log;

public class LogUtil {

    public static String sTAG = "LogUtil";

    //控制是否要输出log
    public static boolean sIsRelease = false;

    /**
     * 如果是要发布了，可以在application里面把这里release一下，这样子就没有log输出了
     */
    public static void init(boolean isRelease) {
        sIsRelease = isRelease;
    }

    public static void d(String TAG, String content) {
        if (!sIsRelease) {
            Log.d("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void v(String TAG, String content) {
        if (!sIsRelease) {
            Log.v("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void i(String TAG, String content) {
        if (!sIsRelease) {
            Log.i("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void w(String TAG, String content) {
        if (!sIsRelease) {
            Log.w("[" + sTAG + "]" + TAG, content);
        }
    }

    public static void e(String TAG, String content) {
        if (!sIsRelease) {
            Log.e("[" + sTAG + "]" + TAG, content);
        }
    }

}
