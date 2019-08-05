package com.hjq.mallone;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 解决 使得这个dex的方法数量被限制在65535之内保错问题
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized App getInstance() {
        return instance;
    }
}
