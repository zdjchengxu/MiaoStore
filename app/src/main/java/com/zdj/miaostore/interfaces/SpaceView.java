package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.SpaceBean;

import java.util.List;

public interface SpaceView extends BaseView {

    void onLoading();

    void onSuccess(SpaceBean mSpaceBean);

    void onNetWorkError();

    void onEmpty();

}
