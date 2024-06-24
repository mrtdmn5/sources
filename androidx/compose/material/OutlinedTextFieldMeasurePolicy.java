package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import com.amplifyframework.predictions.models.Label;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: OutlinedTextField.kt */
/* loaded from: classes.dex */
public final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {
    public final float animationProgress;
    public final Function1<Size, Unit> onLabelMeasured;
    public final PaddingValues paddingValues;
    public final boolean singleLine;

    /* JADX WARN: Multi-variable type inference failed */
    public OutlinedTextFieldMeasurePolicy(Function1<? super Size, Unit> onLabelMeasured, boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.onLabelMeasured = onLabelMeasured;
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int r14, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        int r4;
        Object obj3;
        int r5;
        Object obj4;
        int r1;
        int r13;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj5 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), "TextField")) {
                int intValue = function2.invoke(obj5, Integer.valueOf(r14)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), Label.FEATURE_TYPE)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
                if (intrinsicMeasurable != null) {
                    r4 = function2.invoke(intrinsicMeasurable, Integer.valueOf(r14)).intValue();
                } else {
                    r4 = 0;
                }
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj3 = it2.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Trailing")) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
                if (intrinsicMeasurable2 != null) {
                    r5 = function2.invoke(intrinsicMeasurable2, Integer.valueOf(r14)).intValue();
                } else {
                    r5 = 0;
                }
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        obj4 = it3.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "Leading")) {
                            break;
                        }
                    } else {
                        obj4 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
                if (intrinsicMeasurable3 != null) {
                    r1 = function2.invoke(intrinsicMeasurable3, Integer.valueOf(r14)).intValue();
                } else {
                    r1 = 0;
                }
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                if (intrinsicMeasurable4 != null) {
                    r13 = function2.invoke(intrinsicMeasurable4, Integer.valueOf(r14)).intValue();
                } else {
                    r13 = 0;
                }
                return OutlinedTextFieldKt.m193access$calculateHeightO3s9Psw(r1, r5, intValue, r4, r13, this.animationProgress, TextFieldImplKt.ZeroConstraints, intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int intrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int r14, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        int r4;
        Object obj3;
        int r5;
        Object obj4;
        int r1;
        int r13;
        List<? extends IntrinsicMeasurable> list2 = list;
        for (Object obj5 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), "TextField")) {
                int intValue = function2.invoke(obj5, Integer.valueOf(r14)).intValue();
                Iterator<T> it = list2.iterator();
                while (true) {
                    obj = null;
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj2), Label.FEATURE_TYPE)) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
                if (intrinsicMeasurable != null) {
                    r4 = function2.invoke(intrinsicMeasurable, Integer.valueOf(r14)).intValue();
                } else {
                    r4 = 0;
                }
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        obj3 = it2.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj3), "Trailing")) {
                            break;
                        }
                    } else {
                        obj3 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
                if (intrinsicMeasurable2 != null) {
                    r5 = function2.invoke(intrinsicMeasurable2, Integer.valueOf(r14)).intValue();
                } else {
                    r5 = 0;
                }
                Iterator<T> it3 = list2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        obj4 = it3.next();
                        if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj4), "Leading")) {
                            break;
                        }
                    } else {
                        obj4 = null;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
                if (intrinsicMeasurable3 != null) {
                    r1 = function2.invoke(intrinsicMeasurable3, Integer.valueOf(r14)).intValue();
                } else {
                    r1 = 0;
                }
                Iterator<T> it4 = list2.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        break;
                    }
                    Object next = it4.next();
                    if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) next), "Hint")) {
                        obj = next;
                        break;
                    }
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                if (intrinsicMeasurable4 != null) {
                    r13 = function2.invoke(intrinsicMeasurable4, Integer.valueOf(r14)).intValue();
                } else {
                    r13 = 0;
                }
                return OutlinedTextFieldKt.m194access$calculateWidthO3s9Psw(r1, r5, intValue, r4, r13, this.animationProgress, TextFieldImplKt.ZeroConstraints, intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                IntrinsicMeasurable intrinsicMeasurable2 = intrinsicMeasurable;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(intrinsicMeasurable2, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable2.maxIntrinsicHeight(intValue));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$maxIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                IntrinsicMeasurable intrinsicMeasurable2 = intrinsicMeasurable;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(intrinsicMeasurable2, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable2.maxIntrinsicWidth(intValue));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Object obj;
        Placeable placeable;
        Object obj2;
        Placeable placeable2;
        Object obj3;
        Placeable placeable3;
        Object obj4;
        Placeable placeable4;
        int r2;
        int r0;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        PaddingValues paddingValues = this.paddingValues;
        int mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(paddingValues.mo76calculateBottomPaddingD9Ej5fM());
        long m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 10);
        List<? extends Measurable> list = measurables;
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), "Leading")) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Measurable measurable = (Measurable) obj;
        if (measurable != null) {
            placeable = measurable.mo421measureBRTryo0(m558copyZbe2FdA$default);
        } else {
            placeable = null;
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + 0;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), "Trailing")) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            placeable2 = measurable2.mo421measureBRTryo0(ConstraintsKt.m578offsetNN6EwU(m558copyZbe2FdA$default, -widthOrZero, 0));
        } else {
            placeable2 = null;
        }
        int widthOrZero2 = TextFieldImplKt.widthOrZero(placeable2) + widthOrZero;
        int r6 = -widthOrZero2;
        int r22 = -mo44roundToPx0680j_4;
        long m578offsetNN6EwU = ConstraintsKt.m578offsetNN6EwU(m558copyZbe2FdA$default, MathKt__MathJVMKt.roundToInt(((-r13) - r10) * this.animationProgress) + (r6 - (measure.mo44roundToPx0680j_4(paddingValues.mo78calculateRightPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo44roundToPx0680j_4(paddingValues.mo77calculateLeftPaddingu2uoSUM(measure.getLayoutDirection())))), r22);
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (it3.hasNext()) {
                obj3 = it3.next();
                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj3), Label.FEATURE_TYPE)) {
                    break;
                }
            } else {
                obj3 = null;
                break;
            }
        }
        Measurable measurable3 = (Measurable) obj3;
        if (measurable3 != null) {
            placeable3 = measurable3.mo421measureBRTryo0(m578offsetNN6EwU);
        } else {
            placeable3 = null;
        }
        if (placeable3 != null) {
            this.onLabelMeasured.invoke(new Size(SizeKt.Size(placeable3.width, placeable3.height)));
        }
        long m558copyZbe2FdA$default2 = Constraints.m558copyZbe2FdA$default(ConstraintsKt.m578offsetNN6EwU(j, r6, r22 - Math.max(TextFieldImplKt.heightOrZero(placeable3) / 2, measure.mo44roundToPx0680j_4(paddingValues.mo79calculateTopPaddingD9Ej5fM()))), 0, 0, 0, 0, 11);
        for (Measurable measurable4 : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                final Placeable mo421measureBRTryo0 = measurable4.mo421measureBRTryo0(m558copyZbe2FdA$default2);
                long m558copyZbe2FdA$default3 = Constraints.m558copyZbe2FdA$default(m558copyZbe2FdA$default2, 0, 0, 0, 0, 14);
                Iterator<T> it4 = list.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        obj4 = it4.next();
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj4), "Hint")) {
                            break;
                        }
                    } else {
                        obj4 = null;
                        break;
                    }
                }
                Measurable measurable5 = (Measurable) obj4;
                if (measurable5 != null) {
                    placeable4 = measurable5.mo421measureBRTryo0(m558copyZbe2FdA$default3);
                } else {
                    placeable4 = null;
                }
                final int m194access$calculateWidthO3s9Psw = OutlinedTextFieldKt.m194access$calculateWidthO3s9Psw(TextFieldImplKt.widthOrZero(placeable), TextFieldImplKt.widthOrZero(placeable2), mo421measureBRTryo0.width, TextFieldImplKt.widthOrZero(placeable3), TextFieldImplKt.widthOrZero(placeable4), this.animationProgress, j, measure.getDensity(), this.paddingValues);
                final int m193access$calculateHeightO3s9Psw = OutlinedTextFieldKt.m193access$calculateHeightO3s9Psw(TextFieldImplKt.heightOrZero(placeable), TextFieldImplKt.heightOrZero(placeable2), mo421measureBRTryo0.height, TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeable4), this.animationProgress, j, measure.getDensity(), this.paddingValues);
                for (Measurable measurable6 : list) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable6), "border")) {
                        if (m194access$calculateWidthO3s9Psw != Integer.MAX_VALUE) {
                            r2 = m194access$calculateWidthO3s9Psw;
                        } else {
                            r2 = 0;
                        }
                        if (m193access$calculateHeightO3s9Psw != Integer.MAX_VALUE) {
                            r0 = m193access$calculateHeightO3s9Psw;
                        } else {
                            r0 = 0;
                        }
                        final Placeable mo421measureBRTryo02 = measurable6.mo421measureBRTryo0(ConstraintsKt.Constraints(r2, m194access$calculateWidthO3s9Psw, r0, m193access$calculateHeightO3s9Psw));
                        final Placeable placeable5 = placeable;
                        final Placeable placeable6 = placeable2;
                        final Placeable placeable7 = placeable3;
                        final Placeable placeable8 = placeable4;
                        return measure.layout(m194access$calculateWidthO3s9Psw, m193access$calculateHeightO3s9Psw, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$measure$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Placeable.PlacementScope placementScope) {
                                int r4;
                                int r13;
                                float widthOrZero3;
                                Placeable.PlacementScope layout = placementScope;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
                                float f = outlinedTextFieldMeasurePolicy.animationProgress;
                                MeasureScope measureScope = measure;
                                float density = measureScope.getDensity();
                                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                float f2 = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                                PaddingValues paddingValues2 = outlinedTextFieldMeasurePolicy.paddingValues;
                                int roundToInt = MathKt__MathJVMKt.roundToInt(paddingValues2.mo79calculateTopPaddingD9Ej5fM() * density);
                                int roundToInt2 = MathKt__MathJVMKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues2, layoutDirection) * density);
                                float f3 = TextFieldImplKt.HorizontalIconPadding * density;
                                int r8 = m193access$calculateHeightO3s9Psw;
                                Placeable placeable9 = placeable5;
                                if (placeable9 != null) {
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable9, 0, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r8 - placeable9.height) / 2.0f)));
                                }
                                Placeable placeable10 = placeable6;
                                if (placeable10 != null) {
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable10, m194access$calculateWidthO3s9Psw - placeable10.width, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r8 - placeable10.height) / 2.0f)));
                                }
                                boolean z = outlinedTextFieldMeasurePolicy.singleLine;
                                Placeable placeable11 = placeable7;
                                if (placeable11 != null) {
                                    if (z) {
                                        r13 = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r8 - placeable11.height) / 2.0f));
                                    } else {
                                        r13 = roundToInt;
                                    }
                                    int roundToInt3 = MathKt__MathJVMKt.roundToInt(((-(placeable11.height / 2)) - r13) * f) + r13;
                                    if (placeable9 == null) {
                                        widthOrZero3 = 0.0f;
                                    } else {
                                        widthOrZero3 = (1 - f) * (TextFieldImplKt.widthOrZero(placeable9) - f3);
                                    }
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable11, MathKt__MathJVMKt.roundToInt(widthOrZero3) + roundToInt2, roundToInt3);
                                }
                                Placeable placeable12 = mo421measureBRTryo0;
                                if (z) {
                                    r4 = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r8 - placeable12.height) / 2.0f));
                                } else {
                                    r4 = roundToInt;
                                }
                                Placeable.PlacementScope.placeRelative$default(layout, placeable12, TextFieldImplKt.widthOrZero(placeable9), Math.max(r4, TextFieldImplKt.heightOrZero(placeable11) / 2));
                                Placeable placeable13 = placeable8;
                                if (placeable13 != null) {
                                    if (z) {
                                        roundToInt = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r8 - placeable13.height) / 2.0f));
                                    }
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable13, TextFieldImplKt.widthOrZero(placeable9), Math.max(roundToInt, TextFieldImplKt.heightOrZero(placeable11) / 2));
                                }
                                Placeable.PlacementScope.m432place70tqf50(mo421measureBRTryo02, IntOffset.Zero, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicHeight$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                IntrinsicMeasurable intrinsicMeasurable2 = intrinsicMeasurable;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(intrinsicMeasurable2, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable2.minIntrinsicHeight(intValue));
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicWidth(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$minIntrinsicWidth$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, Integer num) {
                IntrinsicMeasurable intrinsicMeasurable2 = intrinsicMeasurable;
                int intValue = num.intValue();
                Intrinsics.checkNotNullParameter(intrinsicMeasurable2, "intrinsicMeasurable");
                return Integer.valueOf(intrinsicMeasurable2.minIntrinsicWidth(intValue));
            }
        });
    }
}
