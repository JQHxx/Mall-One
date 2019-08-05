package com.hjq.mallone.base.bottom;

import android.widget.Toast;

import com.hjq.mallone.base.delegates.LatteDelegate;

public abstract class BottomItemDelegate extends LatteDelegate {

    //再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long touchTime = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - touchTime > WAIT_TIME) {
            Toast.makeText(_mActivity, "双击退出", Toast.LENGTH_SHORT).show();
            touchTime = System.currentTimeMillis();
        } else {
            _mActivity.finish();
        }
        return true;
    }
}
