package com.znlccy.tangmonk.pager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ContentViewPager extends ViewPager {

    /* 声明默认构造函数 */
    public ContentViewPager(@NonNull Context context, AttributeSet attrs) {
        super(context,attrs);
    }

    //去子控件,如果没有子控件则不触发 触摸事件
    private static boolean GO_TOUCH_CHILD = true;

    /* 声明阻塞打算事件 */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (GO_TOUCH_CHILD) {
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }

    /* 声明触摸事件 */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (GO_TOUCH_CHILD) {
            return false;
        }
        return super.onTouchEvent(ev);
    }
}
