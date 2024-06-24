package androidx.compose.ui.platform;

import androidx.compose.ui.unit.DpKt;

/* compiled from: ViewConfiguration.kt */
/* loaded from: classes.dex */
public interface ViewConfiguration {
    void getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    default long mo449getMinimumTouchTargetSizeMYxV2XQ() {
        float f = 48;
        return DpKt.m582DpSizeYgX7TsA(f, f);
    }

    float getTouchSlop();
}
