package androidx.compose.foundation.text;

import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;

/* compiled from: HeightInLinesModifier.kt */
/* loaded from: classes.dex */
public final class HeightInLinesModifierKt {
    public static final void validateMinMaxLines(int r3, int r4) {
        boolean z;
        boolean z2 = true;
        if (r3 > 0 && r4 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r3 > r4) {
                z2 = false;
            }
            if (z2) {
                return;
            } else {
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("minLines ", r3, " must be less than or equal to maxLines ", r4).toString());
            }
        }
        throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("both minLines ", r3, " and maxLines ", r4, " must be greater than zero").toString());
    }
}
