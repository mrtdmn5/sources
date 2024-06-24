package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Row.kt */
/* loaded from: classes.dex */
public final class RowKt {
    public static final RowColumnImplKt$rowColumnMeasurePolicy$1 DefaultRowMeasurePolicy;

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
        Arrangement$Start$1 arrangement$Start$1 = Arrangement.Start;
        int r2 = CrossAxisAlignment.$r8$clinit;
        CrossAxisAlignment.VerticalCrossAxisAlignment verticalCrossAxisAlignment = new CrossAxisAlignment.VerticalCrossAxisAlignment(Alignment.Companion.Top);
        DefaultRowMeasurePolicy = RowColumnImplKt.m80rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.RowKt$DefaultRowMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Integer num, int[] r8, LayoutDirection layoutDirection, Density density, int[] r11) {
                int intValue = num.intValue();
                int[] size = r8;
                LayoutDirection layoutDirection2 = layoutDirection;
                Density density2 = density;
                int[] outPosition = r11;
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                Intrinsics.checkNotNullParameter(density2, "density");
                Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                Arrangement.Start.arrange(intValue, density2, layoutDirection2, size, outPosition);
                return Unit.INSTANCE;
            }
        }, 0, SizeMode.Wrap, verticalCrossAxisAlignment);
    }

    public static final MeasurePolicy rowMeasurePolicy(final Arrangement.Horizontal horizontalArrangement, BiasAlignment.Vertical vertical, Composer composer) {
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(horizontalArrangement, "horizontalArrangement");
        composer.startReplaceableGroup(-837807694);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (Intrinsics.areEqual(horizontalArrangement, Arrangement.Start) && Intrinsics.areEqual(vertical, Alignment.Companion.Top)) {
            measurePolicy = DefaultRowMeasurePolicy;
        } else {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(horizontalArrangement) | composer.changed(vertical);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.Empty) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                float mo61getSpacingD9Ej5fM = horizontalArrangement.mo61getSpacingD9Ej5fM();
                int r2 = CrossAxisAlignment.$r8$clinit;
                CrossAxisAlignment.VerticalCrossAxisAlignment verticalCrossAxisAlignment = new CrossAxisAlignment.VerticalCrossAxisAlignment(vertical);
                rememberedValue = RowColumnImplKt.m80rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.RowKt$rowMeasurePolicy$1$1
                    {
                        super(5);
                    }

                    @Override // kotlin.jvm.functions.Function5
                    public final Unit invoke(Integer num, int[] r8, LayoutDirection layoutDirection, Density density, int[] r11) {
                        int intValue = num.intValue();
                        int[] size = r8;
                        LayoutDirection layoutDirection2 = layoutDirection;
                        Density density2 = density;
                        int[] outPosition = r11;
                        Intrinsics.checkNotNullParameter(size, "size");
                        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                        Intrinsics.checkNotNullParameter(density2, "density");
                        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                        Arrangement.Horizontal.this.arrange(intValue, density2, layoutDirection2, size, outPosition);
                        return Unit.INSTANCE;
                    }
                }, mo61getSpacingD9Ej5fM, SizeMode.Wrap, verticalCrossAxisAlignment);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) rememberedValue;
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }
}
