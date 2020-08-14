package com.laucherish.myanimator;

import android.view.View;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author : liuyangchi.
 * Description : MyFloatPropertyValuesHolder.
 * Date : 2020/8/14.
 */
public class MyFloatPropertyValuesHolder {

    // 属性名字
    String mPropertyName;
    // float
    Class mValueType;
    // 方法
    Method mSetter = null;
    MyKeyframeSet mMyKeyframeSet;

    public MyFloatPropertyValuesHolder(String propertyName, float... values) {
        mPropertyName = propertyName;
        mValueType = float.class;
        mMyKeyframeSet = MyKeyframeSet.ofFloat(values);
    }

    public void setupSetter(WeakReference<View> target) {
        char firstLetter = Character.toUpperCase(mPropertyName.charAt(0));
        String theRest = mPropertyName.substring(1);
        String methodName="set"+ firstLetter + theRest;
        try {
            mSetter = View.class.getDeclaredMethod(methodName, float.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void setAnimatedValue(View target, float fraction) {
        Object value = mMyKeyframeSet.getValue(fraction);

        try {
            mSetter.invoke(target, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
