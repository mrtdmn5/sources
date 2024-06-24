package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;

/* compiled from: ListImplementation.kt */
/* loaded from: classes.dex */
public final class ListImplementation {
    public static final void checkElementIndex$runtime_release(int r3, int r4) {
        if (r3 >= 0 && r3 < r4) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r3, ", size: ", r4));
        }
    }

    public static final void checkPositionIndex$runtime_release(int r3, int r4) {
        if (r3 >= 0 && r3 <= r4) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r3, ", size: ", r4));
        }
    }

    public static final void checkRangeIndexes$runtime_release(int r4, int r5, int r6) {
        if (r4 >= 0 && r5 <= r6) {
            if (r4 <= r5) {
            } else {
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("fromIndex: ", r4, " > toIndex: ", r5));
            }
        } else {
            StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("fromIndex: ", r4, ", toIndex: ", r5, ", size: ");
            m.append(r6);
            throw new IndexOutOfBoundsException(m.toString());
        }
    }
}
