package com.hjq.mallone.mvp.presenter.impl;

import com.hjq.mallone.mvp.presenter.MvpPresenter;
import com.hjq.mallone.mvp.view.MvpView;

public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view !=null){
            view = null;
        }
    }
}
