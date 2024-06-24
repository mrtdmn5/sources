package androidx.compose.ui.platform;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public abstract class AccessibilityIterators$AbstractTextSegmentIterator implements AccessibilityIterators$TextSegmentIterator {
    public final int[] segment = new int[2];
    public String text;

    public final int[] getRange(int r3, int r4) {
        if (r3 >= 0 && r4 >= 0 && r3 != r4) {
            int[] r1 = this.segment;
            r1[0] = r3;
            r1[1] = r4;
            return r1;
        }
        return null;
    }

    public final String getText() {
        String str = this.text;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("text");
        throw null;
    }
}
