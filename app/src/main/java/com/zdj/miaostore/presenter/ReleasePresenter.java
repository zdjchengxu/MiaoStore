package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.NetBack;
import com.zdj.miaostore.interfaces.ReleaseView;
import com.zdj.miaostore.model.ReleaseModel;
import com.zdj.miaostore.util.OkHttp;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReleasePresenter extends BasePresenter<ReleaseView> {

    private ReleaseModel releaseModel;

    public ReleasePresenter() {
        releaseModel = new ReleaseModel();
    }

    public void  sendSpaceMsg(final String userToken, final int userId, final int spaceType, final String spaceContent, final List<String> paths){
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetBack netBack = releaseModel.sendSpaceMsg(userToken, userId, spaceType, spaceContent, paths);
                if(netBack == null){
                    getBaseView().onError();
                }else{
                    getBaseView().onSendSuccess(netBack);
                }
            }
        }).start();

    }

}
