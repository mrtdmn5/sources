package com.google.android.gms.internal.measurement;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbs {
    public static final int zza;

    static {
        int r0;
        if (Build.VERSION.SDK_INT >= 31) {
            r0 = 33554432;
        } else {
            r0 = 0;
        }
        zza = r0;
    }
}
