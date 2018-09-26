package com.eco.ecoseoul.home.control;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by minhyoung on 2018. 9. 16..
 */

public class VerticalViewPager extends ViewPager {
    public VerticalViewPager(Context context) {
        super(context);
        init();
    }

    public void init(){
        setPageTransformer(true,new VerticalViewPagerTransform());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        init();
    }

    private MotionEvent swapXY(MotionEvent event) {
        float x = getWidth();
        float y = getHeight();

        float newX = (event.getY()/y)*y;
        float newY = (event.getX()/x)*x;

        event.setLocation(newX,newY);
        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = super.onInterceptTouchEvent(swapXY(ev));
        swapXY(ev);
        return intercept;
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapXY(ev));
    }

    private class VerticalViewPagerTransform implements ViewPager.PageTransformer{

        private static final float MIN_SCALE = 0.75f;
        @Override
        public void transformPage(View page, float position) {

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                page.setAlpha(1);

                // Counteract the default slide transition
                page.setTranslationX(page.getWidth() * -position);

                //set Y position to swipe in from top
                float yPosition = position * page.getHeight();
                page.setTranslationY(yPosition);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.setAlpha(0);
            }

//            if (position < -1) { // [-Infinity,-1)
//                // This page is way off-screen to the left.
//                page.setAlpha(0);
//
//            }  else if (position <= 0) { // [-1,0]
//                // Use the default slide transition when moving to the left page
//                page.setAlpha(1);
//                // Counteract the default slide transition
//                page.setTranslationX(page.getWidth() * -position);
//
//                //set Y position to swipe in from top
//                float yPosition = position * page.getHeight();
//                page.setTranslationY(yPosition);
//                page.setScaleX(1);
//                page.setScaleY(1);
//
//            } else if (position <= 1) { // [0,1]
//                page.setAlpha(1);
//
//                // Counteract the default slide transition
//                page.setTranslationX(page.getWidth() * -position);
//
//
//                // Scale the page down (between MIN_SCALE and 1)
//                float scaleFactor = MIN_SCALE
//                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
//                page.setScaleX(scaleFactor);
//                page.setScaleY(scaleFactor);
//
//            } else { // (1,+Infinity]
//                // This page is way off-screen to the right.
//                page.setAlpha(0);
//            }

        }

    }
}
