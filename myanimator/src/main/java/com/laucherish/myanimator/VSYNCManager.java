package com.laucherish.myanimator;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : liuyangchi.
 * Description : VSYNCManager.
 * Date : 2020/8/14.
 */
public class VSYNCManager {
    private static final VSYNCManager ourInstance = new VSYNCManager();

    public static VSYNCManager getInstance() {
        return ourInstance;
    }

    private VSYNCManager() {
        new Thread(runnable).start();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (AnimationFrameCallback callback : list) {
                    callback.doAnimationFrame(System.currentTimeMillis());
                }
            }
        }
    };

    private List<AnimationFrameCallback> list = new ArrayList<>();

    public void add(AnimationFrameCallback animationFrameCallback) {
        list.add(animationFrameCallback);
    }

    interface AnimationFrameCallback{
        boolean doAnimationFrame(long currentTime);
    }
}
