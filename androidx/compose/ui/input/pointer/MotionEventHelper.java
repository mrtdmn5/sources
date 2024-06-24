package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MotionEventAdapter.android.kt */
/* loaded from: classes.dex */
public final class MotionEventHelper {
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    /* renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m410toRawOffsetdBAh8RU(MotionEvent motionEvent, int r3) {
        float rawX;
        float rawY;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        rawX = motionEvent.getRawX(r3);
        rawY = motionEvent.getRawY(r3);
        return OffsetKt.Offset(rawX, rawY);
    }
}
