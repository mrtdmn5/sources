package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValidatingOffsetMapping.kt */
/* loaded from: classes.dex */
public final class ValidatingOffsetMapping implements OffsetMapping {
    public final OffsetMapping delegate;
    public final int originalLength;
    public final int transformedLength;

    public ValidatingOffsetMapping(OffsetMapping delegate, int r3, int r4) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.originalLength = r3;
        this.transformedLength = r4;
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public final int originalToTransformed(int r6) {
        int originalToTransformed = this.delegate.originalToTransformed(r6);
        int r1 = this.transformedLength;
        boolean z = false;
        if (originalToTransformed >= 0 && originalToTransformed <= r1) {
            z = true;
        }
        if (z) {
            return originalToTransformed;
        }
        throw new IllegalStateException(AndroidWindowInsets$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("OffsetMapping.originalToTransformed returned invalid mapping: ", r6, " -> ", originalToTransformed, " is not in range of transformed text [0, "), r1, ']').toString());
    }

    @Override // androidx.compose.ui.text.input.OffsetMapping
    public final int transformedToOriginal(int r6) {
        int transformedToOriginal = this.delegate.transformedToOriginal(r6);
        int r1 = this.originalLength;
        boolean z = false;
        if (transformedToOriginal >= 0 && transformedToOriginal <= r1) {
            z = true;
        }
        if (z) {
            return transformedToOriginal;
        }
        throw new IllegalStateException(AndroidWindowInsets$$ExternalSyntheticOutline0.m(ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("OffsetMapping.transformedToOriginal returned invalid mapping: ", r6, " -> ", transformedToOriginal, " is not in range of original text [0, "), r1, ']').toString());
    }
}
