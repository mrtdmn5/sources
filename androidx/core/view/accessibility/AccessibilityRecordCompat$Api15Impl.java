package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public final class AccessibilityRecordCompat$Api15Impl {
    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int r1) {
        accessibilityRecord.setMaxScrollX(r1);
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int r1) {
        accessibilityRecord.setMaxScrollY(r1);
    }
}
