package com.laucherish.myanimator;

import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Author : liuyangchi.
 * Description : MyObjectAnimator.
 * Date : 2020/8/14.
 */
public class MyObjectAnimator implements VSYNCManager.AnimationFrameCallback{

    private long mDuration = 300;
    private WeakReference<View> target;
    private MyFloatPropertyValuesHolder myFloatPropertyValuesHolder;
    private int index = 0;
    private TimeInterpolator interpolator;

    private MyObjectAnimator(View view, String propertyName, float... values) {
        target = new WeakReference<View>(view);
        myFloatPropertyValuesHolder = new MyFloatPropertyValuesHolder(propertyName, values);
    }

    public static MyObjectAnimator ofFloat(View view, String propertyName, float... values) {
        return new MyObjectAnimator(view, propertyName, values);
    }

    public void start() {
        myFloatPropertyValuesHolder.setupSetter(target);
        VSYNCManager.getInstance().add(this);
    }

    public void setDuration(long mDuration) {
        this.mDuration = mDuration;
    }

    public void setInterpolator(TimeInterpolator interpolator) {
        this.interpolator = interpolator;
    }

    @Override
    public boolean doAnimationFrame(long currentTime) {
        float total = mDuration / 16;
        float fraction = (index++) / total;
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        if (index >= total) {
            index = 0;
        }
        myFloatPropertyValuesHolder.setAnimatedValue(target.get(), fraction);

        return false;
    }
}
