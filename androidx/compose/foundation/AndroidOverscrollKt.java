package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOverscroll.kt */
/* loaded from: classes.dex */
public final class AndroidOverscrollKt {
    public static final Modifier StretchOverscrollNonClippingLayer;

    static {
        Modifier modifier;
        if (Build.VERSION.SDK_INT >= 31) {
            int r0 = Modifier.$r8$clinit;
            modifier = LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion.$$INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
                @Override // kotlin.jvm.functions.Function3
                public final MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    MeasureScope layout = measureScope;
                    Measurable measurable2 = measurable;
                    long j = constraints.value;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable2, "measurable");
                    final Placeable mo421measureBRTryo0 = measurable2.mo421measureBRTryo0(j);
                    final int mo44roundToPx0680j_4 = layout.mo44roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation * 2);
                    return layout.layout(mo421measureBRTryo0.getMeasuredWidth() - mo44roundToPx0680j_4, mo421measureBRTryo0.getMeasuredHeight() - mo44roundToPx0680j_4, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout2 = placementScope;
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            int r7 = (-mo44roundToPx0680j_4) / 2;
                            Placeable placeable = mo421measureBRTryo0;
                            Placeable.PlacementScope.placeWithLayer$default(layout2, placeable, r7 - ((placeable.width - placeable.getMeasuredWidth()) / 2), r7 - ((placeable.height - placeable.getMeasuredHeight()) / 2), null, 12);
                            return Unit.INSTANCE;
                        }
                    });
                }
            }), new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
                @Override // kotlin.jvm.functions.Function3
                public final MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    MeasureScope layout = measureScope;
                    Measurable measurable2 = measurable;
                    long j = constraints.value;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Intrinsics.checkNotNullParameter(measurable2, "measurable");
                    final Placeable mo421measureBRTryo0 = measurable2.mo421measureBRTryo0(j);
                    final int mo44roundToPx0680j_4 = layout.mo44roundToPx0680j_4(ClipScrollableContainerKt.MaxSupportedElevation * 2);
                    return layout.layout(mo421measureBRTryo0.width + mo44roundToPx0680j_4, mo421measureBRTryo0.height + mo44roundToPx0680j_4, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout2 = placementScope;
                            Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                            int r3 = mo44roundToPx0680j_4 / 2;
                            Placeable.PlacementScope.place(mo421measureBRTryo0, r3, r3, 0.0f);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        } else {
            int r02 = Modifier.$r8$clinit;
            modifier = Modifier.Companion.$$INSTANCE;
        }
        StretchOverscrollNonClippingLayer = modifier;
    }
}
