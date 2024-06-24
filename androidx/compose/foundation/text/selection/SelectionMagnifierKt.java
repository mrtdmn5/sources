package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionMagnifier.kt */
/* loaded from: classes.dex */
public final class SelectionMagnifierKt {
    public static final SpringSpec<Offset> MagnifierSpringSpec;
    public static final long OffsetDisplacementThreshold;
    public static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);
    public static final TwoWayConverterImpl UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(Offset offset) {
            long j = offset.packedValue;
            if (OffsetKt.m266isSpecifiedk4lQ0M(j)) {
                return new AnimationVector2D(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
            }
            return SelectionMagnifierKt.UnspecifiedAnimationVector2D;
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2
        @Override // kotlin.jvm.functions.Function1
        public final Offset invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new Offset(OffsetKt.Offset(it.v1, it.v2));
        }
    });

    static {
        long Offset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = Offset;
        MagnifierSpringSpec = new SpringSpec<>(new Offset(Offset), 3);
    }
}
