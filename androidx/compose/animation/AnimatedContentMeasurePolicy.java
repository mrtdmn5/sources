package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: AnimatedContent.kt */
/* loaded from: classes.dex */
public final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    public final AnimatedContentTransitionScopeImpl<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, final int r5) {
        Comparable comparable;
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence = CollectionsKt___CollectionsKt.asSequence(measurables);
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicHeight$1
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
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$maxIntrinsicWidth$1
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.ranges.IntProgressionIterator] */
    /* JADX WARN: Type inference failed for: r14v8, types: [kotlin.ranges.IntProgressionIterator] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Placeable placeable;
        byte b;
        Placeable placeable2;
        int r14;
        int r4;
        final int r12;
        byte b2;
        int r13;
        int r2;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        int size = measurables.size();
        final Placeable[] placeableArr = new Placeable[size];
        int size2 = measurables.size();
        final int r3 = 0;
        int r42 = 0;
        while (true) {
            boolean z = true;
            placeable = null;
            AnimatedContentTransitionScopeImpl.ChildData childData = null;
            if (r42 >= size2) {
                break;
            }
            Measurable measurable = measurables.get(r42);
            Object parentData = measurable.getParentData();
            if (parentData instanceof AnimatedContentTransitionScopeImpl.ChildData) {
                childData = (AnimatedContentTransitionScopeImpl.ChildData) parentData;
            }
            if (childData == null || !childData.isTarget) {
                z = false;
            }
            if (z) {
                placeableArr[r42] = measurable.mo421measureBRTryo0(j);
            }
            r42++;
        }
        int size3 = measurables.size();
        for (int r43 = 0; r43 < size3; r43++) {
            Measurable measurable2 = measurables.get(r43);
            if (placeableArr[r43] == null) {
                placeableArr[r43] = measurable2.mo421measureBRTryo0(j);
            }
        }
        if (size == 0) {
            b = true;
        } else {
            b = false;
        }
        if (b != false) {
            placeable2 = null;
        } else {
            placeable2 = placeableArr[0];
            int r132 = size - 1;
            if (r132 != 0) {
                if (placeable2 != null) {
                    r14 = placeable2.width;
                } else {
                    r14 = 0;
                }
                ?? it = new IntRange(1, r132).iterator();
                while (it.hasNext) {
                    Placeable placeable3 = placeableArr[it.nextInt()];
                    if (placeable3 != null) {
                        r4 = placeable3.width;
                    } else {
                        r4 = 0;
                    }
                    if (r14 < r4) {
                        placeable2 = placeable3;
                        r14 = r4;
                    }
                }
            }
        }
        if (placeable2 != null) {
            r12 = placeable2.width;
        } else {
            r12 = 0;
        }
        if (size == 0) {
            b2 = true;
        } else {
            b2 = false;
        }
        if (b2 == false) {
            placeable = placeableArr[0];
            int r0 = size - 1;
            if (r0 != 0) {
                if (placeable != null) {
                    r13 = placeable.height;
                } else {
                    r13 = 0;
                }
                ?? it2 = new IntRange(1, r0).iterator();
                while (it2.hasNext) {
                    Placeable placeable4 = placeableArr[it2.nextInt()];
                    if (placeable4 != null) {
                        r2 = placeable4.height;
                    } else {
                        r2 = 0;
                    }
                    if (r13 < r2) {
                        placeable = placeable4;
                        r13 = r2;
                    }
                }
            }
        }
        if (placeable != null) {
            r3 = placeable.height;
        }
        this.rootScope.measuredSize$delegate.setValue(new IntSize(IntSizeKt.IntSize(r12, r3)));
        return measure.layout(r12, r3, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                for (Placeable placeable5 : placeableArr) {
                    if (placeable5 != null) {
                        long mo229alignKFBX0sM = this.rootScope.contentAlignment.mo229alignKFBX0sM(IntSizeKt.IntSize(placeable5.width, placeable5.height), IntSizeKt.IntSize(r12, r3), LayoutDirection.Ltr);
                        Placeable.PlacementScope.place(placeable5, (int) (mo229alignKFBX0sM >> 32), IntOffset.m590getYimpl(mo229alignKFBX0sM), 0.0f);
                    }
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
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicHeight$1
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
        Function1<IntrinsicMeasurable, Integer> function1 = new Function1<IntrinsicMeasurable, Integer>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$minIntrinsicWidth$1
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
