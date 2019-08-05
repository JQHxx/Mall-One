package com.hjq.mallone;

import android.os.Bundle;

import com.hjq.mallone.base.activities.ProxyActivity;
import com.hjq.mallone.base.delegates.LatteDelegate;
import com.hjq.mallone.pro.main.EcBottomDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
