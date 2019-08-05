package com.hjq.mallone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hjq.mallone.base.delegates.LatteDelegate;

public class MainDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
