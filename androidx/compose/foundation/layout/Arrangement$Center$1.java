package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement$Center$1 implements Arrangement.Horizontal, Arrangement.Vertical {
    public final float spacing = 0;

    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
    public final void arrange(int r2, Density density, LayoutDirection layoutDirection, int[] sizes, int[] outPositions) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(outPositions, "outPositions");
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.placeCenter$foundation_layout_release(r2, sizes, outPositions, false);
        } else {
            Arrangement.placeCenter$foundation_layout_release(r2, sizes, outPositions, true);
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
    /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final float mo61getSpacingD9Ej5fM() {
        return this.spacing;
    }

    public final String toString() {
        return "Arrangement#Center";
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Vertical
    public final void arrange(Density density, int r3, int[] sizes, int[] outPositions) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(sizes, "sizes");
        Intrinsics.checkNotNullParameter(outPositions, "outPositions");
        Arrangement.placeCenter$foundation_layout_release(r3, sizes, outPositions, false);
    }
}
