package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAccessibilityManager.android.kt */
/* loaded from: classes.dex */
public final class AndroidAccessibilityManager implements AccessibilityManager {
    public final android.view.accessibility.AccessibilityManager accessibilityManager;

    public AndroidAccessibilityManager(Context context) {
        Object systemService = context.getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
    }

    @Override // androidx.compose.ui.platform.AccessibilityManager
    public final long calculateRecommendedTimeoutMillis(long j, boolean z) {
        int r0;
        if (j >= 2147483647L) {
            return j;
        }
        if (z) {
            r0 = 7;
        } else {
            r0 = 3;
        }
        int r1 = Build.VERSION.SDK_INT;
        android.view.accessibility.AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (r1 >= 29) {
            int recommendedTimeoutMillis = Api29Impl.INSTANCE.getRecommendedTimeoutMillis(accessibilityManager, (int) j, r0);
            if (recommendedTimeoutMillis != Integer.MAX_VALUE) {
                return recommendedTimeoutMillis;
            }
        } else if (!z || !accessibilityManager.isTouchExplorationEnabled()) {
            return j;
        }
        return Long.MAX_VALUE;
    }
}
