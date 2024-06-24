package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerBasedShape.kt */
/* loaded from: classes.dex */
public abstract class CornerBasedShape implements Shape {
    public final CornerSize bottomEnd;
    public final CornerSize bottomStart;
    public final CornerSize topEnd;
    public final CornerSize topStart;

    public CornerBasedShape(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        this.topStart = topStart;
        this.topEnd = topEnd;
        this.bottomEnd = bottomEnd;
        this.bottomStart = bottomStart;
    }

    public abstract RoundedCornerShape copy(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4);

    /* renamed from: createOutline-LjSzlW0 */
    public abstract Outline mo110createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection);

    @Override // androidx.compose.ui.graphics.Shape
    /* renamed from: createOutline-Pq9zytI */
    public final Outline mo27createOutlinePq9zytI(long j, LayoutDirection layoutDirection, Density density) {
        boolean z;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        float mo111toPxTmRCtEA = this.topStart.mo111toPxTmRCtEA(j, density);
        float mo111toPxTmRCtEA2 = this.topEnd.mo111toPxTmRCtEA(j, density);
        float mo111toPxTmRCtEA3 = this.bottomEnd.mo111toPxTmRCtEA(j, density);
        float mo111toPxTmRCtEA4 = this.bottomStart.mo111toPxTmRCtEA(j, density);
        float m275getMinDimensionimpl = Size.m275getMinDimensionimpl(j);
        float f = mo111toPxTmRCtEA + mo111toPxTmRCtEA4;
        if (f > m275getMinDimensionimpl) {
            float f2 = m275getMinDimensionimpl / f;
            mo111toPxTmRCtEA *= f2;
            mo111toPxTmRCtEA4 *= f2;
        }
        float f3 = mo111toPxTmRCtEA4;
        float f4 = mo111toPxTmRCtEA2 + mo111toPxTmRCtEA3;
        if (f4 > m275getMinDimensionimpl) {
            float f5 = m275getMinDimensionimpl / f4;
            mo111toPxTmRCtEA2 *= f5;
            mo111toPxTmRCtEA3 *= f5;
        }
        if (mo111toPxTmRCtEA >= 0.0f && mo111toPxTmRCtEA2 >= 0.0f && mo111toPxTmRCtEA3 >= 0.0f && f3 >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return mo110createOutlineLjSzlW0(j, mo111toPxTmRCtEA, mo111toPxTmRCtEA2, mo111toPxTmRCtEA3, f3, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + mo111toPxTmRCtEA + ", topEnd = " + mo111toPxTmRCtEA2 + ", bottomEnd = " + mo111toPxTmRCtEA3 + ", bottomStart = " + f3 + ")!").toString());
    }
}
