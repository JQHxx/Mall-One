package com.hjq.mallone.base.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.hjq.mallone.R;
import com.hjq.mallone.base.delegates.LatteDelegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import me.yokeyword.fragmentation.ISupportFragment;


public abstract class BaseBottomDelegate extends LatteDelegate implements View.OnClickListener {

    @BindView(R.id.bottom_bar_delegate_container)
    ContentFrameLayout mBottomBarDelegateContainer;
    @BindView(R.id.bottom_bar)
    LinearLayoutCompat mBottomBar;

    private final ArrayList<BottomTabBean> TAB_BEANS = new ArrayList<>();
    private final ArrayList<BottomItemDelegate> ITEM_DELEGATES = new ArrayList<>();
    private final LinkedHashMap<BottomTabBean, BottomItemDelegate> ITEMS = new LinkedHashMap<>();
    private int mCurrentDelegate = 0;//当前显示的delegate
    private int mIndexDelegate = 0;// 默认的delegate
    private int mClickedColor = Color.RED;//点击后的颜色

    public abstract LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder);

    public abstract int setIndexDelegate();

    @ColorInt
    public abstract int setClickedColor();

    @Override
    public Object setLayout() {
        return R.layout.delegate_bottom;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexDelegate = setIndexDelegate();
        if (setClickedColor() != 0) {
            mClickedColor = setClickedColor();
        }
        final ItemBuilder builder = ItemBuilder.builder();
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = setItems(builder);
        ITEMS.putAll(items);
        for (Map.Entry<BottomTabBean, BottomItemDelegate> item : ITEMS.entrySet()) {
            final BottomTabBean key = item.getKey();
            final BottomItemDelegate value = item.getValue();
            TAB_BEANS.add(key);
            ITEM_DELEGATES.add(value);
        }
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        final int size = ITEMS.size();
        for (int i = 0; i < size; i++) {
            LayoutInflater.from(getContext()).inflate(R.layout.bottom_item_icon_text_layout, mBottomBar);
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            //设置item的点击事件
            item.setTag(i);
            item.setOnClickListener(this);
            final ImageView itemIcon = (ImageView) item.getChildAt(0);
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            final BottomTabBean bean = TAB_BEANS.get(i);
            //初始化数据Å
            // itemIcon.setText(bean.getIcon());
            itemIcon.setImageDrawable(getProxyActivity().getResources().getDrawable(bean.getIcon()));
            itemTitle.setText(bean.getTitle());
            if (i == mIndexDelegate) {
                // itemIcon.setTextColor(mClickedColor);
                itemIcon.setImageDrawable(getProxyActivity().getResources().getDrawable(bean.getSELECTICON()));
                itemTitle.setTextColor(mClickedColor);
            }
        }
        final ISupportFragment[] delegateArray = ITEM_DELEGATES.toArray(new ISupportFragment[size]);
        getSupportDelegate().loadMultipleRootFragment(R.id.bottom_bar_delegate_container, mIndexDelegate, delegateArray);
    }

    private void resetColor(final int currentTag) {
        final int count = mBottomBar.getChildCount();
        for (int i = 0; i < count; i++) {
            final BottomTabBean bean = TAB_BEANS.get(i);
            final RelativeLayout item = (RelativeLayout) mBottomBar.getChildAt(i);
            final ImageView itemIcon = (ImageView) item.getChildAt(0);
            itemIcon.setImageDrawable(getProxyActivity().getResources().getDrawable(bean.getIcon()));
            if (i == currentTag) { // 设置当前选中的图片
                itemIcon.setImageDrawable(getProxyActivity().getResources().getDrawable(bean.getSELECTICON()));
            }
            final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
            itemTitle.setTextColor(Color.GRAY);
        }
    }

    @Override
    public void onClick(View v) {
        final int tag = (int) v.getTag();
        resetColor(tag);
        final RelativeLayout item = (RelativeLayout) v;
        final ImageView itemIcon = (ImageView) item.getChildAt(0);
        // itemIcon.setTextColor(mClickedColor);
        final AppCompatTextView itemTitle = (AppCompatTextView) item.getChildAt(1);
        itemTitle.setTextColor(mClickedColor);

        // 隐藏上一个
        getSupportDelegate().showHideFragment(ITEM_DELEGATES.get(tag), ITEM_DELEGATES.get(mCurrentDelegate));
        //注意先后顺序
        mCurrentDelegate = tag;

    }
}
