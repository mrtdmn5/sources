package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement$Bottom$1 implements Arrangement.Vertical {
    @Override // androidx.compose.foundation.layout.Arrangement.Vertical
    public final void arrange(Density density, int r3, int[] sizes, int[] outPositions) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(outPositions, "outPositions");
        Arrangement.placeRightOrBottom$foundation_layout_release(r3, sizes, outPositions, false);
    }

    public final String toString() {
        return "Arrangement#Bottom";
    }
}
