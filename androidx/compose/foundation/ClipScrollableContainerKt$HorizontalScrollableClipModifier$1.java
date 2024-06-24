package androidx.compose.foundation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClipScrollableContainer.kt */
/* loaded from: classes.dex */
public final class ClipScrollableContainerKt$HorizontalScrollableClipModifier$1 implements Shape {
    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI, reason: not valid java name */
    public final Outline mo27createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo44roundToPx0680j_4 = density.mo44roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation);
        return new Outline.Rectangle(new Rect(0.0f, -mo44roundToPx0680j_4, Size.m276getWidthimpl(j), Size.m274getHeightimpl(j) + mo44roundToPx0680j_4));
    }
}
