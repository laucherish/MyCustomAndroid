package com.laucherish.myimageloader.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Author : liuyangchi.
 * Description : ImageCache.
 * Date : 2020/9/10.
 */
public class ImageCache {
    private LruCache<String, Bitmap> imageCache;

    public ImageCache() {
        init();
    }

    private void init() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        imageCache = new LruCache<>(maxMemory / 4);
    }

    public void put(String url, Bitmap bitmap) {
        imageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return imageCache.get(url);
    }
}
