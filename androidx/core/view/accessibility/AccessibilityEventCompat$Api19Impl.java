package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class AccessibilityEventCompat$Api19Impl {
    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getContentChangeTypes();
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int r1) {
        accessibilityEvent.setContentChangeTypes(r1);
    }
}
