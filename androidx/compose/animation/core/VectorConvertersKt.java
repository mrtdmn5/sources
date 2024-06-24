package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: VectorConverters.kt */
/* loaded from: classes.dex */
public final class VectorConvertersKt {
    public static final TwoWayConverterImpl FloatToVector = TwoWayConverter(new Function1<Float, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector1D invoke(Float f) {
            return new AnimationVector1D(f.floatValue());
        }
    }, new Function1<AnimationVector1D, Float>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(AnimationVector1D animationVector1D) {
            AnimationVector1D it = animationVector1D;
            Intrinsics.checkNotNullParameter(it, "it");
            return Float.valueOf(it.value);
        }
    });
    public static final TwoWayConverterImpl IntToVector = TwoWayConverter(new Function1<Integer, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector1D invoke(Integer num) {
            return new AnimationVector1D(num.intValue());
        }
    }, new Function1<AnimationVector1D, Integer>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(AnimationVector1D animationVector1D) {
            AnimationVector1D it = animationVector1D;
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf((int) it.value);
        }
    });
    public static final TwoWayConverterImpl DpToVector = TwoWayConverter(new Function1<Dp, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector1D invoke(Dp dp) {
            return new AnimationVector1D(dp.value);
        }
    }, new Function1<AnimationVector1D, Dp>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Dp invoke(AnimationVector1D animationVector1D) {
            AnimationVector1D it = animationVector1D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new Dp(it.value);
        }
    });
    public static final TwoWayConverterImpl DpOffsetToVector = TwoWayConverter(new Function1<DpOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(DpOffset dpOffset) {
            long j = dpOffset.packedValue;
            return new AnimationVector2D(DpOffset.m583getXD9Ej5fM(j), DpOffset.m584getYD9Ej5fM(j));
        }
    }, new Function1<AnimationVector2D, DpOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final DpOffset invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new DpOffset(DpKt.m581DpOffsetYgX7TsA(it.v1, it.v2));
        }
    });
    public static final TwoWayConverterImpl SizeToVector = TwoWayConverter(new Function1<Size, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(Size size) {
            long j = size.packedValue;
            return new AnimationVector2D(Size.m276getWidthimpl(j), Size.m274getHeightimpl(j));
        }
    }, new Function1<AnimationVector2D, Size>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Size invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new Size(SizeKt.Size(it.v1, it.v2));
        }
    });
    public static final TwoWayConverterImpl OffsetToVector = TwoWayConverter(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(Offset offset) {
            long j = offset.packedValue;
            return new AnimationVector2D(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Offset invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new Offset(OffsetKt.Offset(it.v1, it.v2));
        }
    });
    public static final TwoWayConverterImpl IntOffsetToVector = TwoWayConverter(new Function1<IntOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(IntOffset intOffset) {
            long j = intOffset.packedValue;
            return new AnimationVector2D((int) (j >> 32), IntOffset.m590getYimpl(j));
        }
    }, new Function1<AnimationVector2D, IntOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final IntOffset invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new IntOffset(IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(it.v1), MathKt__MathJVMKt.roundToInt(it.v2)));
        }
    });
    public static final TwoWayConverterImpl IntSizeToVector = TwoWayConverter(new Function1<IntSize, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector2D invoke(IntSize intSize) {
            long j = intSize.packedValue;
            return new AnimationVector2D((int) (j >> 32), IntSize.m593getHeightimpl(j));
        }
    }, new Function1<AnimationVector2D, IntSize>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final IntSize invoke(AnimationVector2D animationVector2D) {
            AnimationVector2D it = animationVector2D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new IntSize(IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(it.v1), MathKt__MathJVMKt.roundToInt(it.v2)));
        }
    });
    public static final TwoWayConverterImpl RectToVector = TwoWayConverter(new Function1<Rect, AnimationVector4D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector4D invoke(Rect rect) {
            Rect it = rect;
            Intrinsics.checkNotNullParameter(it, "it");
            return new AnimationVector4D(it.left, it.top, it.right, it.bottom);
        }
    }, new Function1<AnimationVector4D, Rect>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Rect invoke(AnimationVector4D animationVector4D) {
            AnimationVector4D it = animationVector4D;
            Intrinsics.checkNotNullParameter(it, "it");
            return new Rect(it.v1, it.v2, it.v3, it.v4);
        }
    });

    public static final TwoWayConverterImpl TwoWayConverter(Function1 convertToVector, Function1 convertFromVector) {
        Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
        Intrinsics.checkNotNullParameter(convertFromVector, "convertFromVector");
        return new TwoWayConverterImpl(convertToVector, convertFromVector);
    }
}
