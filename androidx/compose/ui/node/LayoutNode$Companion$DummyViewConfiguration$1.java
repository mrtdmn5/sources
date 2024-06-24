package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.DpSize;

/* compiled from: LayoutNode.kt */
/* loaded from: classes.dex */
public final class LayoutNode$Companion$DummyViewConfiguration$1 implements ViewConfiguration {
    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getDoubleTapTimeoutMillis() {
        return 300L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final long getLongPressTimeoutMillis() {
        return 400L;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
    public final long mo449getMinimumTouchTargetSizeMYxV2XQ() {
        int r0 = DpSize.$r8$clinit;
        return DpSize.Zero;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final float getTouchSlop() {
        return 16.0f;
    }

    @Override // androidx.compose.ui.platform.ViewConfiguration
    public final void getDoubleTapMinTimeMillis() {
    }
}
