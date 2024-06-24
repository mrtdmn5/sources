package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement$Start$1 implements Arrangement.Horizontal {
    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
    public final void arrange(int r2, Density density, LayoutDirection layoutDirection, int[] sizes, int[] outPositions) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(outPositions, "outPositions");
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
        } else {
            Arrangement.placeRightOrBottom$foundation_layout_release(r2, sizes, outPositions, true);
        }
    }

    public final String toString() {
        return "Arrangement#Start";
    }
}
