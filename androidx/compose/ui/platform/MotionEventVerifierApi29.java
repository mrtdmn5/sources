package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeView.android.kt */
/* loaded from: classes.dex */
public final class MotionEventVerifierApi29 {
    public static final MotionEventVerifierApi29 INSTANCE = new MotionEventVerifierApi29();

    public final boolean isValidMotionEvent(MotionEvent event, int r6) {
        float rawX;
        boolean z;
        float rawY;
        boolean z2;
        Intrinsics.checkNotNullParameter(event, "event");
        rawX = event.getRawX(r6);
        if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            rawY = event.getRawY(r6);
            if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }
}
