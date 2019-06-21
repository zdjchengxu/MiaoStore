package com.zdj.miaostore.presenter;

import com.zdj.miaostore.base.BasePresenter;
import com.zdj.miaostore.bean.SpaceBean;
import com.zdj.miaostore.interfaces.SpaceView;
import com.zdj.miaostore.model.SpaceModel;
import com.zdj.miaostore.util.Contans;

import java.util.ArrayList;
import java.util.List;

public class SpacePresenter extends BasePresenter<SpaceView> {

    private SpaceModel spaceModel;

    public SpacePresenter() {
        this.spaceModel = new SpaceModel();
    }

    public void getSpaceDataList() {
        getBaseView().onLoading();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (spaceModel != null) {
                    SpaceBean spaceDataList = spaceModel.getSpaceDataList();
                    if (spaceDataList == null) {
                        getBaseView().onNetWorkError();
                    } else if (spaceDataList.getData().getList().size() == 0) {
                        getBaseView().onEmpty();
                    } else {
                        getBaseView().onSuccess(spaceDataList);
                    }
                }
            }
        }).start();
    }


}
