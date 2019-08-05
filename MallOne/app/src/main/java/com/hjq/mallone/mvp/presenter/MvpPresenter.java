package com.hjq.mallone.mvp.presenter;


import com.hjq.mallone.mvp.view.MvpView;

public interface MvpPresenter<V extends MvpView>  {
    public void attachView(V view);
    public void detachView();
}
