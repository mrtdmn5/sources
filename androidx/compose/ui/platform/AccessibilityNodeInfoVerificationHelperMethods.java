package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityNodeInfoVerificationHelperMethods {
    public static final AccessibilityNodeInfoVerificationHelperMethods INSTANCE = new AccessibilityNodeInfoVerificationHelperMethods();

    public final void setAvailableExtraData(AccessibilityNodeInfo node, List<String> data) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(data, "data");
        node.setAvailableExtraData(data);
    }
}
