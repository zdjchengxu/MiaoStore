package com.zdj.miaostore.base;

public abstract class BasePresenter<V extends BaseView> {

    private V sendView;

    public V getBaseView() {
        return sendView;
    }

    public void attachView(V sendView){
        this.sendView = sendView;
    }

    public void detachView(){
        this.sendView = null;
    }

}
