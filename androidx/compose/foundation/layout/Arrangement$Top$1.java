package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement$Top$1 implements Arrangement.Vertical {
    @Override // androidx.compose.foundation.layout.Arrangement.Vertical
    public final void arrange(Density density, int r2, int[] sizes, int[] outPositions) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(outPositions, "outPositions");
        Arrangement.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
    }

    public final String toString() {
        return "Arrangement#Top";
    }
}
