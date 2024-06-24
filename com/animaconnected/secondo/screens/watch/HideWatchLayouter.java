package com.animaconnected.secondo.screens.watch;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HideWatchLayouter.kt */
/* loaded from: classes3.dex */
public final class HideWatchLayouter implements WatchViewLayouter {
    public static final int $stable = 0;
    private final int hideMode;

    public HideWatchLayouter() {
        this(0, 1, null);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return this.hideMode;
    }

    public HideWatchLayouter(int r1) {
        this.hideMode = r1;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    public /* synthetic */ HideWatchLayouter(int r1, int r2, DefaultConstructorMarker defaultConstructorMarker) {
        this((r2 & 1) != 0 ? 2 : r1);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r1) {
    }
}
