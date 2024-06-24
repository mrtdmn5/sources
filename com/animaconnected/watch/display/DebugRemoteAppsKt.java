package com.animaconnected.watch.display;

/* compiled from: DebugRemoteApps.kt */
/* loaded from: classes3.dex */
public final class DebugRemoteAppsKt {
    public static final int leftmostForY(int r6, int r7) {
        if (r6 < (r7 / 2) + 195) {
            r7 = 0;
        }
        double d = 2;
        return (int) (195.0d - Math.sqrt(Math.pow(195.0d, d) - Math.pow((r6 + r7) - 195.0d, d)));
    }

    public static /* synthetic */ int leftmostForY$default(int r0, int r1, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            r1 = 14;
        }
        return leftmostForY(r0, r1);
    }
}
