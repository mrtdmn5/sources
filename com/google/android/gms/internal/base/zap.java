package com.google.android.gms.internal.base;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zap {
    public static final int zaa;

    static {
        int r0;
        if (Build.VERSION.SDK_INT >= 31) {
            r0 = 33554432;
        } else {
            r0 = 0;
        }
        zaa = r0;
    }
}
