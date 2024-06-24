package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class LottieImageAsset {
    public Bitmap bitmap;
    public final String fileName;
    public final int height;
    public final int width;

    public LottieImageAsset(int r1, int r2, String str, String str2) {
        this.width = r1;
        this.height = r2;
        this.fileName = str2;
    }
}
