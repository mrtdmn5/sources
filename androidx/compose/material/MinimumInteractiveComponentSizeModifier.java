package androidx.compose.material;

import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpSize;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: InteractiveComponentSize.kt */
/* loaded from: classes.dex */
public final class MinimumInteractiveComponentSizeModifier implements LayoutModifier {
    public final long size;

    public MinimumInteractiveComponentSizeModifier(long j) {
        this.size = j;
    }

    public final boolean equals(Object obj) {
        MinimumInteractiveComponentSizeModifier minimumInteractiveComponentSizeModifier;
        if (obj instanceof MinimumInteractiveComponentSizeModifier) {
            minimumInteractiveComponentSizeModifier = (MinimumInteractiveComponentSizeModifier) obj;
        } else {
            minimumInteractiveComponentSizeModifier = null;
        }
        if (minimumInteractiveComponentSizeModifier == null) {
            return false;
        }
        int r1 = DpSize.$r8$clinit;
        if (this.size != minimumInteractiveComponentSizeModifier.size) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int r0 = DpSize.$r8$clinit;
        return Long.hashCode(this.size);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo5measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        int r5 = mo421measureBRTryo0.width;
        long j2 = this.size;
        final int max = Math.max(r5, measure.mo44roundToPx0680j_4(DpSize.m587getWidthD9Ej5fM(j2)));
        final int max2 = Math.max(mo421measureBRTryo0.height, measure.mo44roundToPx0680j_4(DpSize.m586getHeightD9Ej5fM(j2)));
        return measure.layout(max, max2, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.MinimumInteractiveComponentSizeModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place(mo421measureBRTryo0, MathKt__MathJVMKt.roundToInt((max - r5.width) / 2.0f), MathKt__MathJVMKt.roundToInt((max2 - r5.height) / 2.0f), 0.0f);
                return Unit.INSTANCE;
            }
        });
    }
}
