package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAccessibilityManager.android.kt */
/* loaded from: classes.dex */
public final class Api29Impl {
    public static final Api29Impl INSTANCE = new Api29Impl();

    public final int getRecommendedTimeoutMillis(android.view.accessibility.AccessibilityManager accessibilityManager, int r3, int r4) {
        Intrinsics.checkNotNullParameter(accessibilityManager, "accessibilityManager");
        return accessibilityManager.getRecommendedTimeoutMillis(r3, r4);
    }
}
