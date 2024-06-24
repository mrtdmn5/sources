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

/* compiled from: Column.kt */
/* loaded from: classes.dex */
public final class ColumnKt {
    public static final RowColumnImplKt$rowColumnMeasurePolicy$1 DefaultColumnMeasurePolicy;

    static {
        LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
        Arrangement$Start$1 arrangement$Start$1 = Arrangement.Start;
        int r2 = CrossAxisAlignment.$r8$clinit;
        CrossAxisAlignment.HorizontalCrossAxisAlignment horizontalCrossAxisAlignment = new CrossAxisAlignment.HorizontalCrossAxisAlignment(Alignment.Companion.Start);
        DefaultColumnMeasurePolicy = RowColumnImplKt.m80rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.ColumnKt$DefaultColumnMeasurePolicy$1
            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(Integer num, int[] r3, LayoutDirection layoutDirection, Density density, int[] r6) {
                int intValue = num.intValue();
                int[] size = r3;
                Density density2 = density;
                int[] outPosition = r6;
                Intrinsics.checkNotNullParameter(size, "size");
                Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                Intrinsics.checkNotNullParameter(density2, "density");
                Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                Arrangement.Top.arrange(density2, intValue, size, outPosition);
                return Unit.INSTANCE;
            }
        }, 0, SizeMode.Wrap, horizontalCrossAxisAlignment);
    }

    public static final MeasurePolicy columnMeasurePolicy(final Arrangement.Vertical verticalArrangement, BiasAlignment.Horizontal horizontal, Composer composer) {
        MeasurePolicy measurePolicy;
        Intrinsics.checkNotNullParameter(verticalArrangement, "verticalArrangement");
        composer.startReplaceableGroup(1089876336);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (Intrinsics.areEqual(verticalArrangement, Arrangement.Top) && Intrinsics.areEqual(horizontal, Alignment.Companion.Start)) {
            measurePolicy = DefaultColumnMeasurePolicy;
        } else {
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(verticalArrangement) | composer.changed(horizontal);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.Empty) {
                LayoutOrientation layoutOrientation = LayoutOrientation.Vertical;
                float mo61getSpacingD9Ej5fM = verticalArrangement.mo61getSpacingD9Ej5fM();
                int r2 = CrossAxisAlignment.$r8$clinit;
                CrossAxisAlignment.HorizontalCrossAxisAlignment horizontalCrossAxisAlignment = new CrossAxisAlignment.HorizontalCrossAxisAlignment(horizontal);
                rememberedValue = RowColumnImplKt.m80rowColumnMeasurePolicyTDGSqEk(layoutOrientation, new Function5<Integer, int[], LayoutDirection, Density, int[], Unit>() { // from class: androidx.compose.foundation.layout.ColumnKt$columnMeasurePolicy$1$1
                    {
                        super(5);
                    }

                    @Override // kotlin.jvm.functions.Function5
                    public final Unit invoke(Integer num, int[] r3, LayoutDirection layoutDirection, Density density, int[] r6) {
                        int intValue = num.intValue();
                        int[] size = r3;
                        Density density2 = density;
                        int[] outPosition = r6;
                        Intrinsics.checkNotNullParameter(size, "size");
                        Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 2>");
                        Intrinsics.checkNotNullParameter(density2, "density");
                        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
                        Arrangement.Vertical.this.arrange(density2, intValue, size, outPosition);
                        return Unit.INSTANCE;
                    }
                }, mo61getSpacingD9Ej5fM, SizeMode.Wrap, horizontalCrossAxisAlignment);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            measurePolicy = (MeasurePolicy) rememberedValue;
        }
        composer.endReplaceableGroup();
        return measurePolicy;
    }
}
