package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ColorVectorConverter.kt */
/* loaded from: classes.dex */
public final class ColorVectorConverterKt$ColorToVector$1 extends Lambda implements Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>> {
    public static final ColorVectorConverterKt$ColorToVector$1 INSTANCE = new ColorVectorConverterKt$ColorToVector$1();

    public ColorVectorConverterKt$ColorToVector$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final TwoWayConverter<Color, AnimationVector4D> invoke(ColorSpace colorSpace) {
        final ColorSpace colorSpace2 = colorSpace;
        Intrinsics.checkNotNullParameter(colorSpace2, "colorSpace");
        return VectorConvertersKt.TwoWayConverter(new Function1<Color, AnimationVector4D>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
            @Override // kotlin.jvm.functions.Function1
            public final AnimationVector4D invoke(Color color) {
                long m315convertvNxB06k = Color.m315convertvNxB06k(color.value, ColorSpaces.Oklab);
                return new AnimationVector4D(Color.m318getAlphaimpl(m315convertvNxB06k), Color.m322getRedimpl(m315convertvNxB06k), Color.m321getGreenimpl(m315convertvNxB06k), Color.m319getBlueimpl(m315convertvNxB06k));
            }
        }, new Function1<AnimationVector4D, Color>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Color invoke(AnimationVector4D animationVector4D) {
                AnimationVector4D vector = animationVector4D;
                Intrinsics.checkNotNullParameter(vector, "vector");
                return new Color(Color.m315convertvNxB06k(ColorKt.Color(RangesKt___RangesKt.coerceIn(vector.v2, 0.0f, 1.0f), RangesKt___RangesKt.coerceIn(vector.v3, -0.5f, 0.5f), RangesKt___RangesKt.coerceIn(vector.v4, -0.5f, 0.5f), RangesKt___RangesKt.coerceIn(vector.v1, 0.0f, 1.0f), ColorSpaces.Oklab), ColorSpace.this));
            }
        });
    }
}
