package com.laucherish.myanimator;

/**
 * Author : liuyangchi.
 * Description : 关键帧.
 * Date : 2020/8/14.
 */
public class MyFloatKeyframe {
    float mFraction;
    Class mValueType;
    float mValue;

    public MyFloatKeyframe(float fraction, float value) {
        mFraction = fraction;
        mValue = value;
        mValueType = float.class;
    }

    public float getFraction() {
        return mFraction;
    }

    public void setFraction(float mFraction) {
        this.mFraction = mFraction;
    }

    public Class getValueType() {
        return mValueType;
    }

    public void setValueType(Class mValueType) {
        this.mValueType = mValueType;
    }

    public float getValue() {
        return mValue;
    }

    public void setValue(float mValue) {
        this.mValue = mValue;
    }
}
