package com.hjq.mallone.base.bottom;

public class BottomTabBean {

    private final int ICON;
    private final int SELECTICON;
    private final CharSequence TITLE;

    public BottomTabBean(int icon, int selecticon, CharSequence title) {
        this.ICON = icon;
        this.SELECTICON = selecticon;
        this.TITLE = title;
    }

    public int getIcon() {
        return ICON;
    }

    public int getSELECTICON() {
        return SELECTICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }
}
