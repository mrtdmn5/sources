package com.airbnb.lottie.manager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ImageAssetManager {
    public static final Object bitmapHashLock = new Object();
    public final Context context;
    public final Map<String, LottieImageAsset> imageAssets;
    public final String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, Map map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.imagesFolder = str.concat("/");
        } else {
            this.imagesFolder = str;
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
        } else {
            this.context = ((View) callback).getContext();
            this.imageAssets = map;
        }
    }
}
