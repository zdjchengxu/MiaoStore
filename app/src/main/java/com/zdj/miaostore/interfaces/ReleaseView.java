package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.NetBack;

public interface ReleaseView extends BaseView {

    void onSendSuccess(NetBack netBack);

    void onError();

}
