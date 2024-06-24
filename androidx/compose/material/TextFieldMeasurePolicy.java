package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.layout.AlignmentLineKt;
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

/* compiled from: TextField.kt */
/* loaded from: classes.dex */
public final class TextFieldMeasurePolicy implements MeasurePolicy {
    public final float animationProgress;
    public final PaddingValues paddingValues;
    public final boolean singleLine;

    public TextFieldMeasurePolicy(boolean z, float f, PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.singleLine = z;
        this.animationProgress = f;
        this.paddingValues = paddingValues;
    }

    public static int intrinsicWidth(List list, int r10, Function2 function2) {
        Object obj;
        Object obj2;
        int r2;
        Object obj3;
        int r4;
        Object obj4;
        int r5;
        List list2 = list;
        for (Object obj5 : list2) {
            if (Intrinsics.areEqual(TextFieldImplKt.getLayoutId((IntrinsicMeasurable) obj5), "TextField")) {
                int intValue = ((Number) function2.invoke(obj5, Integer.valueOf(r10))).intValue();
                Iterator it = list2.iterator();
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
                int r1 = 0;
                if (intrinsicMeasurable != null) {
                    r2 = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(r10))).intValue();
                } else {
                    r2 = 0;
                }
                Iterator it2 = list2.iterator();
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
                    r4 = ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(r10))).intValue();
                } else {
                    r4 = 0;
                }
                Iterator it3 = list2.iterator();
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
                    r5 = ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(r10))).intValue();
                } else {
                    r5 = 0;
                }
                Iterator it4 = list2.iterator();
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
                    r1 = ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(r10))).intValue();
                }
                long j = TextFieldImplKt.ZeroConstraints;
                float f = TextFieldKt.FirstBaselineOffset;
                return Math.max(Math.max(intValue, Math.max(r2, r1)) + r5 + r4, Constraints.m567getMinWidthimpl(j));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int intrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int r14, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        Object obj;
        Object obj2;
        int r4;
        Object obj3;
        int r5;
        Object obj4;
        int r6;
        int r13;
        boolean z;
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
                    r6 = function2.invoke(intrinsicMeasurable3, Integer.valueOf(r14)).intValue();
                } else {
                    r6 = 0;
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
                if (r4 > 0) {
                    z = true;
                } else {
                    z = false;
                }
                return TextFieldKt.m214access$calculateHeightO3s9Psw(intValue, z, r4, r6, r5, r13, TextFieldImplKt.ZeroConstraints, intrinsicMeasureScope.getDensity(), this.paddingValues);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicHeight$1
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
        return intrinsicWidth(measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$maxIntrinsicWidth$1
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
        final Placeable placeable3;
        Object obj3;
        Placeable placeable4;
        int r4;
        int r5;
        Object obj4;
        Placeable placeable5;
        boolean z;
        TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        PaddingValues paddingValues = textFieldMeasurePolicy.paddingValues;
        final int mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(paddingValues.mo79calculateTopPaddingD9Ej5fM());
        int mo44roundToPx0680j_42 = measure.mo44roundToPx0680j_4(paddingValues.mo76calculateBottomPaddingD9Ej5fM());
        final int mo44roundToPx0680j_43 = measure.mo44roundToPx0680j_4(TextFieldKt.TextFieldTopPadding);
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
            placeable2 = placeable;
            placeable3 = measurable2.mo421measureBRTryo0(ConstraintsKt.m578offsetNN6EwU(m558copyZbe2FdA$default, -widthOrZero, 0));
        } else {
            placeable2 = placeable;
            placeable3 = null;
        }
        int widthOrZero2 = TextFieldImplKt.widthOrZero(placeable3) + widthOrZero;
        int r52 = -mo44roundToPx0680j_42;
        int r7 = -widthOrZero2;
        long m578offsetNN6EwU = ConstraintsKt.m578offsetNN6EwU(m558copyZbe2FdA$default, r7, r52);
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
            placeable4 = measurable3.mo421measureBRTryo0(m578offsetNN6EwU);
        } else {
            placeable4 = null;
        }
        if (placeable4 != null) {
            r4 = placeable4.get(AlignmentLineKt.LastBaseline);
            if (r4 == Integer.MIN_VALUE) {
                r4 = placeable4.height;
            }
        } else {
            r4 = 0;
        }
        final int max = Math.max(r4, mo44roundToPx0680j_4);
        if (placeable4 != null) {
            r5 = (r52 - mo44roundToPx0680j_43) - max;
        } else {
            r5 = (-mo44roundToPx0680j_4) - mo44roundToPx0680j_42;
        }
        long m578offsetNN6EwU2 = ConstraintsKt.m578offsetNN6EwU(Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 11), r7, r5);
        for (Measurable measurable4 : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "TextField")) {
                final Placeable mo421measureBRTryo0 = measurable4.mo421measureBRTryo0(m578offsetNN6EwU2);
                long m558copyZbe2FdA$default2 = Constraints.m558copyZbe2FdA$default(m578offsetNN6EwU2, 0, 0, 0, 0, 14);
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
                    placeable5 = measurable5.mo421measureBRTryo0(m558copyZbe2FdA$default2);
                } else {
                    placeable5 = null;
                }
                final int max2 = Math.max(Math.max(mo421measureBRTryo0.width, Math.max(TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable5))) + TextFieldImplKt.widthOrZero(placeable2) + TextFieldImplKt.widthOrZero(placeable3), Constraints.m567getMinWidthimpl(j));
                int r0 = mo421measureBRTryo0.height;
                if (placeable4 != null) {
                    z = true;
                } else {
                    z = false;
                }
                final int m214access$calculateHeightO3s9Psw = TextFieldKt.m214access$calculateHeightO3s9Psw(r0, z, max, TextFieldImplKt.heightOrZero(placeable2), TextFieldImplKt.heightOrZero(placeable3), TextFieldImplKt.heightOrZero(placeable5), j, measure.getDensity(), textFieldMeasurePolicy.paddingValues);
                final Placeable placeable6 = placeable4;
                final int r3 = r4;
                final Placeable placeable7 = placeable5;
                final Placeable placeable8 = placeable2;
                return measure.layout(max2, m214access$calculateHeightO3s9Psw, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Placeable.PlacementScope placementScope) {
                        int r42;
                        int roundToInt;
                        Placeable.PlacementScope layout = placementScope;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        Placeable placeable9 = mo421measureBRTryo0;
                        MeasureScope measureScope = measure;
                        Placeable placeable10 = placeable3;
                        Placeable placeable11 = placeable8;
                        Placeable placeable12 = placeable7;
                        int r11 = m214access$calculateHeightO3s9Psw;
                        int r12 = max2;
                        TextFieldMeasurePolicy textFieldMeasurePolicy2 = this;
                        Placeable placeable13 = Placeable.this;
                        if (placeable13 != null) {
                            int r32 = mo44roundToPx0680j_4 - r3;
                            if (r32 < 0) {
                                r32 = 0;
                            }
                            boolean z2 = textFieldMeasurePolicy2.singleLine;
                            int r6 = mo44roundToPx0680j_43 + max;
                            float density = measureScope.getDensity();
                            float f = TextFieldKt.FirstBaselineOffset;
                            if (placeable11 != null) {
                                Placeable.PlacementScope.placeRelative$default(layout, placeable11, 0, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable11.height) / 2.0f)));
                            }
                            if (placeable10 != null) {
                                Placeable.PlacementScope.placeRelative$default(layout, placeable10, r12 - placeable10.width, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable10.height) / 2.0f)));
                            }
                            if (z2) {
                                roundToInt = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable13.height) / 2.0f));
                            } else {
                                roundToInt = MathKt__MathJVMKt.roundToInt(TextFieldImplKt.TextFieldPadding * density);
                            }
                            Placeable.PlacementScope.placeRelative$default(layout, placeable13, TextFieldImplKt.widthOrZero(placeable11), roundToInt - MathKt__MathJVMKt.roundToInt((roundToInt - r32) * textFieldMeasurePolicy2.animationProgress));
                            Placeable.PlacementScope.placeRelative$default(layout, placeable9, TextFieldImplKt.widthOrZero(placeable11), r6);
                            if (placeable12 != null) {
                                Placeable.PlacementScope.placeRelative$default(layout, placeable12, TextFieldImplKt.widthOrZero(placeable11), r6);
                            }
                        } else {
                            boolean z3 = textFieldMeasurePolicy2.singleLine;
                            float density2 = measureScope.getDensity();
                            float f2 = TextFieldKt.FirstBaselineOffset;
                            int roundToInt2 = MathKt__MathJVMKt.roundToInt(textFieldMeasurePolicy2.paddingValues.mo79calculateTopPaddingD9Ej5fM() * density2);
                            if (placeable11 != null) {
                                Placeable.PlacementScope.placeRelative$default(layout, placeable11, 0, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable11.height) / 2.0f)));
                            }
                            if (placeable10 != null) {
                                Placeable.PlacementScope.placeRelative$default(layout, placeable10, r12 - placeable10.width, MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable10.height) / 2.0f)));
                            }
                            if (z3) {
                                r42 = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable9.height) / 2.0f));
                            } else {
                                r42 = roundToInt2;
                            }
                            Placeable.PlacementScope.placeRelative$default(layout, placeable9, TextFieldImplKt.widthOrZero(placeable11), r42);
                            if (placeable12 != null) {
                                if (z3) {
                                    roundToInt2 = MathKt__MathJVMKt.roundToInt((1 + 0.0f) * ((r11 - placeable12.height) / 2.0f));
                                }
                                Placeable.PlacementScope.placeRelative$default(layout, placeable12, TextFieldImplKt.widthOrZero(placeable11), roundToInt2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            textFieldMeasurePolicy = this;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return intrinsicHeight(intrinsicMeasureScope, measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicHeight$1
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
        return intrinsicWidth(measurables, r4, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.TextFieldMeasurePolicy$minIntrinsicWidth$1
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
