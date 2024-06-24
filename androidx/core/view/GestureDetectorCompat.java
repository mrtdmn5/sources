package androidx.core.view;

import android.content.Context;
import android.view.GestureDetector;

/* loaded from: classes.dex */
public final class GestureDetectorCompat {
    public final GestureDetectorCompatImplJellybeanMr2 mImpl;

    /* loaded from: classes.dex */
    public static class GestureDetectorCompatImplJellybeanMr2 {
        public final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, GestureDetector.OnGestureListener onGestureListener) {
            this.mDetector = new GestureDetector(context, onGestureListener, null);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener);
    }
}
