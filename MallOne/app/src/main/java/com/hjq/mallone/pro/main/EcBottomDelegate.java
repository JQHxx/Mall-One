package com.hjq.mallone.pro.main;

import android.graphics.Color;

import com.hjq.mallone.R;
import com.hjq.mallone.base.bottom.BaseBottomDelegate;
import com.hjq.mallone.base.bottom.BottomItemDelegate;
import com.hjq.mallone.base.bottom.BottomTabBean;
import com.hjq.mallone.base.bottom.ItemBuilder;
import com.hjq.mallone.pro.discover.view.DiscoverDelegate;
import com.hjq.mallone.pro.index.view.IndexDelegate;
import com.hjq.mallone.pro.main.persional.view.PersionalDelegate;
import com.hjq.mallone.pro.main.sort.view.SortDelegate;

import java.util.LinkedHashMap;


/**
 * 底部导航
 * */
public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean(R.mipmap.ic_launcher, R.mipmap.ic_category_0, "主页"), new IndexDelegate());
        items.put(new BottomTabBean(R.mipmap.ic_launcher, R.mipmap.ic_category_0, "分类"), new SortDelegate());
        items.put(new BottomTabBean(R.mipmap.ic_launcher, R.mipmap.ic_category_0, "发现"), new DiscoverDelegate());
        items.put(new BottomTabBean(R.mipmap.ic_launcher, R.mipmap.ic_category_0, "我的"), new PersionalDelegate());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
