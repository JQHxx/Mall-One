package com.hjq.mallone.base.delegates;

public abstract class LatteDelegate extends BaseDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
