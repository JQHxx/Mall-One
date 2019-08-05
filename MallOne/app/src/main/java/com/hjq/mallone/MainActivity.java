package com.hjq.mallone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hjq.mallone.base.activities.ProxyActivity;
import com.hjq.mallone.base.delegates.LatteDelegate;
import com.hjq.mallone.pro.EcBottomDelegate;

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
