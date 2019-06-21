package com.zdj.miaostore.interfaces;

import com.zdj.miaostore.base.BaseView;
import com.zdj.miaostore.bean.AddressBean;

public interface MineView extends BaseView {

    void onSuccess(AddressBean addressBean);

    void onError();

}
