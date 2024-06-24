package androidx.compose.foundation.text.selection;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleLayout.kt */
/* loaded from: classes.dex */
public final class SimpleLayoutKt$SimpleLayout$1 implements MeasurePolicy {
    public static final SimpleLayoutKt$SimpleLayout$1 INSTANCE = new SimpleLayoutKt$SimpleLayout$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        Integer num = 0;
        for (int r4 = 0; r4 < size; r4++) {
            arrayList.add(measurables.get(r4).mo421measureBRTryo0(j));
        }
        int size2 = arrayList.size();
        Integer num2 = num;
        for (int r9 = 0; r9 < size2; r9++) {
            num2 = Integer.valueOf(Math.max(num2.intValue(), ((Placeable) arrayList.get(r9)).width));
        }
        int intValue = num2.intValue();
        int size3 = arrayList.size();
        for (int r2 = 0; r2 < size3; r2++) {
            num = Integer.valueOf(Math.max(num.intValue(), ((Placeable) arrayList.get(r2)).height));
        }
        return Layout.layout(intValue, num.intValue(), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.selection.SimpleLayoutKt$SimpleLayout$1$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List<Placeable> list = arrayList;
                int size4 = list.size();
                for (int r22 = 0; r22 < size4; r22++) {
                    Placeable.PlacementScope.place(list.get(r22), 0, 0, 0.0f);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
