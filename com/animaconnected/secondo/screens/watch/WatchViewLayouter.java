package com.animaconnected.secondo.screens.watch;

/* compiled from: WatchViewLayouter.kt */
/* loaded from: classes3.dex */
public interface WatchViewLayouter {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int HIDE_DONT_HIDE = 0;
    public static final int HIDE_FADE = 2;
    public static final int HIDE_TO_LEFT = 1;

    /* compiled from: WatchViewLayouter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int HIDE_DONT_HIDE = 0;
        public static final int HIDE_FADE = 2;
        public static final int HIDE_TO_LEFT = 1;

        private Companion() {
        }
    }

    int[] getWatchOffset(int r1, int r2, int r3, int r4);

    int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5);

    int hideWatch();

    void onWatchViewLayouted();

    void onWatchViewUpdated(int r1);
}
