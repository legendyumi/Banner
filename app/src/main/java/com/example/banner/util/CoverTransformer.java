package com.example.banner.util;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

public class CoverTransformer implements ViewPager.PageTransformer {

    public static final String TAG = "CoverTransformer";

    public static final float SCALE_MIN = 0.3f;
    public static final float SCALE_MAX = 1f;
    public static final float MARGIN_MIN = 0f;
    public static final float MARGIN_MAX = 50f;
    public float scale = 0f;
    public float scaley = 0f;

    private float pagerMargin = 0f;
    private float spaceValue = 0f;
    //View的内容相对于View在水平方向上的偏移量，以像素为单位
    //当mScrollX为正数时，内容相对于View从右向左移动，反之则向从左向右移动
    private float rotationX = 0f;
    //View的内容相对于View在垂直方向上的偏移量，以像素为单位
    //当mScrollY为负数时，内容相对于View从下向上移动，反之则向从上向下移动
    private float rotationY = 0f;

    public CoverTransformer(float scale, float scaley, float pagerMargin, float spaceValue, float rotationY) {
        this.scale = scale;
        this.scaley = scaley;
        this.pagerMargin = pagerMargin;
        this.spaceValue = spaceValue;
        this.rotationY = rotationY;
    }

    @Override
    public void transformPage(View page, float position) {
        Log.d(TAG, "position:" + position);
        if (rotationY != 0) {
            float realRotationY = Math.min(rotationY, Math.abs(position * rotationY));
            page.setRotationY(position < 0f ? realRotationY : -realRotationY);
        }
        if (scale != 0f) {
            float realScale = Utils.getFloat(1 - Math.abs(position * scale), SCALE_MIN, SCALE_MAX);
            page.setScaleX(realScale);
        }
        if (scaley != 0f) {
            float realScale = Utils.getFloat(1 - Math.abs(position * scaley), SCALE_MIN, SCALE_MAX);
            page.setScaleY(realScale);
        }
        if (pagerMargin != 0) {
            float realPagerMargin = position * (pagerMargin);
            if (spaceValue != 0) {
                float realSpaceValue = Utils.getFloat(Math.abs(position * spaceValue), MARGIN_MIN, MARGIN_MAX);
                realPagerMargin += (position > 0) ? realSpaceValue : -realSpaceValue;
            }
            page.setTranslationX(realPagerMargin);
        }
    }
}
