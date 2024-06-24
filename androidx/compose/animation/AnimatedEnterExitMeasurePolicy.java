package androidx.compose.animation;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedVisibility.kt */
/* loaded from: classes.dex */
public final class AnimatedEnterExitMeasurePolicy implements MeasurePolicy {
    public final AnimatedVisibilityScopeImpl scope;

    public AnimatedEnterExitMeasurePolicy(AnimatedVisibilityScopeImpl scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, final int r5) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicHeight$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
                IntrinsicMeasurable it = intrinsicMeasurable;
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.maxIntrinsicHeight(r5));
            }
        };
        Iterator<Object> it = asSequence.iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable comparable2 = (Comparable) function1.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable3 = (Comparable) function1.invoke(it.next());
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = comparable3;
                }
            }
            comparable = comparable2;
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, final int r5) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$maxIntrinsicWidth$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
                IntrinsicMeasurable it = intrinsicMeasurable;
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.maxIntrinsicWidth(r5));
            }
        };
        Iterator<Object> it = asSequence.iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable comparable2 = (Comparable) function1.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable3 = (Comparable) function1.invoke(it.next());
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = comparable3;
                }
            }
            comparable = comparable2;
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Object obj;
        int r9;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends Measurable> list = measurables;
        final ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo421measureBRTryo0(j));
        }
        int r10 = 1;
        Object obj2 = null;
        int r1 = 0;
        if (arrayList.isEmpty()) {
            obj = null;
        } else {
            obj = arrayList.get(0);
            int r2 = ((Placeable) obj).width;
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex) {
                int r4 = 1;
                while (true) {
                    Object obj3 = arrayList.get(r4);
                    int r6 = ((Placeable) obj3).width;
                    if (r2 < r6) {
                        obj = obj3;
                        r2 = r6;
                    }
                    if (r4 == lastIndex) {
                        break;
                    }
                    r4++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        if (placeable != null) {
            r9 = placeable.width;
        } else {
            r9 = 0;
        }
        if (!arrayList.isEmpty()) {
            obj2 = arrayList.get(0);
            int r22 = ((Placeable) obj2).height;
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (1 <= lastIndex2) {
                while (true) {
                    Object obj4 = arrayList.get(r10);
                    int r5 = ((Placeable) obj4).height;
                    if (r22 < r5) {
                        obj2 = obj4;
                        r22 = r5;
                    }
                    if (r10 == lastIndex2) {
                        break;
                    }
                    r10++;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        if (placeable2 != null) {
            r1 = placeable2.height;
        }
        this.scope.targetSize.setValue(new IntSize(IntSizeKt.IntSize(r9, r1)));
        return measure.layout(r9, r1, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List<Placeable> list2 = arrayList;
                int size = list2.size();
                for (int r23 = 0; r23 < size; r23++) {
                    Placeable.PlacementScope.place(list2.get(r23), 0, 0, 0.0f);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, final int r5) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicHeight$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
                IntrinsicMeasurable it = intrinsicMeasurable;
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.minIntrinsicHeight(r5));
            }
        };
        Iterator<Object> it = asSequence.iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable comparable2 = (Comparable) function1.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable3 = (Comparable) function1.invoke(it.next());
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = comparable3;
                }
            }
            comparable = comparable2;
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, final int r5) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedEnterExitMeasurePolicy$minIntrinsicWidth$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable) {
                IntrinsicMeasurable it = intrinsicMeasurable;
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.minIntrinsicWidth(r5));
            }
        };
        Iterator<Object> it = asSequence.iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            Comparable comparable2 = (Comparable) function1.invoke(it.next());
            while (it.hasNext()) {
                Comparable comparable3 = (Comparable) function1.invoke(it.next());
                if (comparable2.compareTo(comparable3) < 0) {
                    comparable2 = comparable3;
                }
            }
            comparable = comparable2;
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
