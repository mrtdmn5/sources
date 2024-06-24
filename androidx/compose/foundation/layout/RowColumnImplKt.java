package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class RowColumnImplKt {
    public static final int access$intrinsicSize(List list, Function2 function2, Function2 function22, int r12, int r13, LayoutOrientation layoutOrientation, LayoutOrientation layoutOrientation2) {
        int roundToInt;
        int r14;
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (layoutOrientation == layoutOrientation2) {
            int size = list.size();
            float f = 0.0f;
            int r15 = 0;
            int r4 = 0;
            for (int r142 = 0; r142 < size; r142++) {
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(r142);
                float weight = getWeight(getRowColumnParentData(intrinsicMeasurable));
                int intValue = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(r12))).intValue();
                if (weight == 0.0f) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    r4 += intValue;
                } else if (weight > 0.0f) {
                    f += weight;
                    r15 = Math.max(r15, MathKt__MathJVMKt.roundToInt(intValue / weight));
                }
            }
            return ((list.size() - 1) * r13) + MathKt__MathJVMKt.roundToInt(r15 * f) + r4;
        }
        int min = Math.min((list.size() - 1) * r13, r12);
        int size2 = list.size();
        float f2 = 0.0f;
        int r42 = 0;
        for (int r152 = 0; r152 < size2; r152++) {
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(r152);
            float weight2 = getWeight(getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                int min2 = Math.min(((Number) function22.invoke(intrinsicMeasurable2, Integer.MAX_VALUE)).intValue(), r12 - min);
                min += min2;
                r42 = Math.max(r42, ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(min2))).intValue());
            } else if (weight2 > 0.0f) {
                f2 += weight2;
            }
        }
        if (f2 != 0.0f) {
            z3 = false;
        }
        if (z3) {
            roundToInt = 0;
        } else if (r12 == Integer.MAX_VALUE) {
            roundToInt = Integer.MAX_VALUE;
        } else {
            roundToInt = MathKt__MathJVMKt.roundToInt(Math.max(r12 - min, 0) / f2);
        }
        int size3 = list.size();
        for (int r2 = 0; r2 < size3; r2++) {
            IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) list.get(r2);
            float weight3 = getWeight(getRowColumnParentData(intrinsicMeasurable3));
            if (weight3 > 0.0f) {
                if (roundToInt != Integer.MAX_VALUE) {
                    r14 = MathKt__MathJVMKt.roundToInt(roundToInt * weight3);
                } else {
                    r14 = Integer.MAX_VALUE;
                }
                r42 = Math.max(r42, ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(r14))).intValue());
            }
        }
        return r42;
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.weight;
        }
        return 0.0f;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1] */
    /* renamed from: rowColumnMeasurePolicy-TDGSqEk, reason: not valid java name */
    public static final RowColumnImplKt$rowColumnMeasurePolicy$1 m80rowColumnMeasurePolicyTDGSqEk(final LayoutOrientation orientation, final Function5 arrangement, final float f, final SizeMode crossAxisSize, final CrossAxisAlignment crossAxisAlignment) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r5) {
                Function3 function3;
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    function3 = IntrinsicMeasureBlocks.HorizontalMaxHeight;
                } else {
                    function3 = IntrinsicMeasureBlocks.VerticalMaxHeight;
                }
                return ((Number) function3.invoke(measurables, Integer.valueOf(r5), Integer.valueOf(intrinsicMeasureScope.mo44roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r5) {
                Function3 function3;
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    function3 = IntrinsicMeasureBlocks.HorizontalMaxWidth;
                } else {
                    function3 = IntrinsicMeasureBlocks.VerticalMaxWidth;
                }
                return ((Number) function3.invoke(measurables, Integer.valueOf(r5), Integer.valueOf(intrinsicMeasureScope.mo44roundToPx0680j_4(f)))).intValue();
            }

            /* JADX WARN: Type inference failed for: r8v5, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo4measure3p2s80s(final MeasureScope measure, List<? extends Measurable> measurables, long j) {
                int m566getMinHeightimpl;
                int m564getMaxHeightimpl;
                int m567getMinWidthimpl;
                int m565getMaxWidthimpl;
                List<Measurable> list;
                RowColumnParentData[] rowColumnParentDataArr;
                Placeable[] placeableArr;
                int m567getMinWidthimpl2;
                int r1;
                float f2;
                int r20;
                int r8;
                int coerceIn;
                int r22;
                List<Measurable> list2;
                RowColumnParentData[] rowColumnParentDataArr2;
                long j2;
                boolean z;
                int r12;
                int r11;
                long j3;
                int r7;
                int max;
                int r13;
                int r5;
                int r222;
                int r0;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                final RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(LayoutOrientation.this, arrangement, f, crossAxisSize, crossAxisAlignment, measurables, new Placeable[measurables.size()]);
                int size = measurables.size();
                LayoutOrientation orientation2 = rowColumnMeasurementHelper.orientation;
                Intrinsics.checkNotNullParameter(orientation2, "orientation");
                LayoutOrientation layoutOrientation = LayoutOrientation.Horizontal;
                if (orientation2 == layoutOrientation) {
                    m566getMinHeightimpl = Constraints.m567getMinWidthimpl(j);
                } else {
                    m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
                }
                if (orientation2 == layoutOrientation) {
                    m564getMaxHeightimpl = Constraints.m565getMaxWidthimpl(j);
                } else {
                    m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
                }
                if (orientation2 == layoutOrientation) {
                    m567getMinWidthimpl = Constraints.m566getMinHeightimpl(j);
                } else {
                    m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
                }
                if (orientation2 == layoutOrientation) {
                    m565getMaxWidthimpl = Constraints.m564getMaxHeightimpl(j);
                } else {
                    m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                }
                long Constraints = ConstraintsKt.Constraints(m566getMinHeightimpl, m564getMaxHeightimpl, m567getMinWidthimpl, m565getMaxWidthimpl);
                long mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(rowColumnMeasurementHelper.arrangementSpacing);
                int r14 = size + 0;
                float f3 = 0.0f;
                float f4 = 0.0f;
                int r142 = 0;
                int r15 = 0;
                int r17 = 0;
                long j4 = 0;
                int r202 = 0;
                while (true) {
                    list = rowColumnMeasurementHelper.measurables;
                    rowColumnParentDataArr = rowColumnMeasurementHelper.rowColumnParentData;
                    placeableArr = rowColumnMeasurementHelper.placeables;
                    if (r142 >= size) {
                        break;
                    }
                    Measurable measurable = list.get(r142);
                    float weight = RowColumnImplKt.getWeight(rowColumnParentDataArr[r142]);
                    if (weight > f3) {
                        f4 += weight;
                        r15++;
                        r5 = r14;
                        r222 = size;
                    } else {
                        int m565getMaxWidthimpl2 = Constraints.m565getMaxWidthimpl(Constraints);
                        Placeable placeable = placeableArr[r142];
                        if (placeable == null) {
                            if (m565getMaxWidthimpl2 == Integer.MAX_VALUE) {
                                r5 = r14;
                                r0 = Integer.MAX_VALUE;
                            } else {
                                r5 = r14;
                                long j5 = m565getMaxWidthimpl2 - j4;
                                if (j5 < 0) {
                                    j5 = 0;
                                }
                                r0 = (int) j5;
                            }
                            placeable = measurable.mo421measureBRTryo0(OrientationIndependentConstraints.m70toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(0, r0, 0, Constraints.m564getMaxHeightimpl(Constraints)), orientation2));
                        } else {
                            r5 = r14;
                        }
                        Placeable placeable2 = placeable;
                        int r16 = (int) mo44roundToPx0680j_4;
                        r222 = size;
                        long mainAxisSize = (m565getMaxWidthimpl2 - j4) - rowColumnMeasurementHelper.mainAxisSize(placeable2);
                        if (mainAxisSize < 0) {
                            mainAxisSize = 0;
                        }
                        r17 = Math.min(r16, (int) mainAxisSize);
                        j4 += rowColumnMeasurementHelper.mainAxisSize(placeable2) + r17;
                        r202 = Math.max(r202, rowColumnMeasurementHelper.crossAxisSize(placeable2));
                        placeableArr[r142] = placeable2;
                    }
                    r142++;
                    r14 = r5;
                    size = r222;
                    f3 = 0.0f;
                }
                int r52 = r14;
                int r223 = size;
                int r72 = r202;
                if (r15 == 0) {
                    j4 -= r17;
                    r20 = r52;
                    r8 = r72;
                    coerceIn = 0;
                } else {
                    if (f4 > 0.0f && Constraints.m565getMaxWidthimpl(Constraints) != Integer.MAX_VALUE) {
                        m567getMinWidthimpl2 = Constraints.m565getMaxWidthimpl(Constraints);
                    } else {
                        m567getMinWidthimpl2 = Constraints.m567getMinWidthimpl(Constraints);
                    }
                    long j6 = (r15 - 1) * mo44roundToPx0680j_4;
                    long j7 = (m567getMinWidthimpl2 - j4) - j6;
                    if (j7 < 0) {
                        j7 = 0;
                    }
                    if (f4 > 0.0f) {
                        f2 = ((float) j7) / f4;
                        r1 = r223;
                    } else {
                        r1 = r223;
                        f2 = 0.0f;
                    }
                    ?? it = RangesKt___RangesKt.until(0, r1).iterator();
                    int r73 = 0;
                    while (true) {
                        r20 = r52;
                        if (!it.hasNext) {
                            break;
                        }
                        r73 += MathKt__MathJVMKt.roundToInt(RowColumnImplKt.getWeight(rowColumnParentDataArr[it.nextInt()]) * f2);
                        r52 = r20;
                    }
                    long j8 = j7 - r73;
                    r8 = r72;
                    int r53 = 0;
                    int r74 = 0;
                    while (r74 < r1) {
                        if (placeableArr[r74] == null) {
                            r22 = r1;
                            Measurable measurable2 = list.get(r74);
                            list2 = list;
                            RowColumnParentData rowColumnParentData = rowColumnParentDataArr[r74];
                            float weight2 = RowColumnImplKt.getWeight(rowColumnParentData);
                            boolean z2 = true;
                            if (weight2 > 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                if (j8 < 0) {
                                    rowColumnParentDataArr2 = rowColumnParentDataArr;
                                    r12 = -1;
                                } else if (j8 > 0) {
                                    rowColumnParentDataArr2 = rowColumnParentDataArr;
                                    r12 = 1;
                                } else {
                                    rowColumnParentDataArr2 = rowColumnParentDataArr;
                                    r12 = 0;
                                }
                                j2 = j6;
                                j8 -= r12;
                                int max2 = Math.max(0, MathKt__MathJVMKt.roundToInt(weight2 * f2) + r12);
                                if (rowColumnParentData != null) {
                                    z2 = rowColumnParentData.fill;
                                }
                                if (z2 && max2 != Integer.MAX_VALUE) {
                                    r11 = max2;
                                } else {
                                    r11 = 0;
                                }
                                Placeable mo421measureBRTryo0 = measurable2.mo421measureBRTryo0(OrientationIndependentConstraints.m70toBoxConstraintsOenEA2s(ConstraintsKt.Constraints(r11, max2, 0, Constraints.m564getMaxHeightimpl(Constraints)), orientation2));
                                int mainAxisSize2 = rowColumnMeasurementHelper.mainAxisSize(mo421measureBRTryo0) + r53;
                                r8 = Math.max(r8, rowColumnMeasurementHelper.crossAxisSize(mo421measureBRTryo0));
                                placeableArr[r74] = mo421measureBRTryo0;
                                r53 = mainAxisSize2;
                            } else {
                                throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                            }
                        } else {
                            r22 = r1;
                            list2 = list;
                            rowColumnParentDataArr2 = rowColumnParentDataArr;
                            j2 = j6;
                        }
                        r74++;
                        list = list2;
                        r1 = r22;
                        rowColumnParentDataArr = rowColumnParentDataArr2;
                        j6 = j2;
                    }
                    r223 = r1;
                    coerceIn = (int) RangesKt___RangesKt.coerceIn(r53 + j6, 0L, Constraints.m565getMaxWidthimpl(Constraints) - j4);
                }
                long j9 = j4 + coerceIn;
                if (j9 < 0) {
                    j3 = 0;
                } else {
                    j3 = j9;
                }
                int max3 = Math.max((int) j3, Constraints.m567getMinWidthimpl(Constraints));
                if (Constraints.m564getMaxHeightimpl(Constraints) != Integer.MAX_VALUE && rowColumnMeasurementHelper.crossAxisSize == SizeMode.Expand) {
                    max = Constraints.m564getMaxHeightimpl(Constraints);
                    r13 = r20;
                    r7 = 0;
                } else {
                    r7 = 0;
                    max = Math.max(r8, Math.max(Constraints.m566getMinHeightimpl(Constraints), 0));
                    r13 = r20;
                }
                int[] r9 = new int[r13];
                for (int r2 = r7; r2 < r13; r2++) {
                    r9[r2] = r7;
                }
                int[] r3 = new int[r13];
                while (r7 < r13) {
                    Placeable placeable3 = placeableArr[r7 + 0];
                    Intrinsics.checkNotNull(placeable3);
                    r3[r7] = rowColumnMeasurementHelper.mainAxisSize(placeable3);
                    r7++;
                }
                rowColumnMeasurementHelper.arrangement.invoke(Integer.valueOf(max3), r3, measure.getLayoutDirection(), measure, r9);
                final RowColumnMeasureHelperResult rowColumnMeasureHelperResult = new RowColumnMeasureHelperResult(max, max3, r223, r9);
                if (LayoutOrientation.this != LayoutOrientation.Horizontal) {
                    int r34 = max;
                    max = max3;
                    max3 = r34;
                }
                return measure.layout(max3, max, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1$measure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Placeable.PlacementScope placementScope) {
                        RowColumnParentData rowColumnParentData2;
                        CrossAxisAlignment crossAxisAlignment2;
                        LayoutDirection layoutDirection;
                        Placeable.PlacementScope layout = placementScope;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        LayoutDirection layoutDirection2 = measure.getLayoutDirection();
                        RowColumnMeasurementHelper rowColumnMeasurementHelper2 = RowColumnMeasurementHelper.this;
                        rowColumnMeasurementHelper2.getClass();
                        RowColumnMeasureHelperResult measureResult = rowColumnMeasureHelperResult;
                        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
                        Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
                        int r18 = measureResult.startIndex;
                        for (int r32 = r18; r32 < measureResult.endIndex; r32++) {
                            Placeable placeable4 = rowColumnMeasurementHelper2.placeables[r32];
                            Intrinsics.checkNotNull(placeable4);
                            Object parentData = rowColumnMeasurementHelper2.measurables.get(r32).getParentData();
                            if (parentData instanceof RowColumnParentData) {
                                rowColumnParentData2 = (RowColumnParentData) parentData;
                            } else {
                                rowColumnParentData2 = null;
                            }
                            if (rowColumnParentData2 == null || (crossAxisAlignment2 = rowColumnParentData2.crossAxisAlignment) == null) {
                                crossAxisAlignment2 = rowColumnMeasurementHelper2.crossAxisAlignment;
                            }
                            int crossAxisSize2 = measureResult.crossAxisSize - rowColumnMeasurementHelper2.crossAxisSize(placeable4);
                            LayoutOrientation layoutOrientation2 = LayoutOrientation.Horizontal;
                            LayoutOrientation layoutOrientation3 = rowColumnMeasurementHelper2.orientation;
                            if (layoutOrientation3 == layoutOrientation2) {
                                layoutDirection = LayoutDirection.Ltr;
                            } else {
                                layoutDirection = layoutDirection2;
                            }
                            int align$foundation_layout_release = crossAxisAlignment2.align$foundation_layout_release(crossAxisSize2, layoutDirection, placeable4) + 0;
                            int[] r92 = measureResult.mainAxisPositions;
                            if (layoutOrientation3 == layoutOrientation2) {
                                Placeable.PlacementScope.place(placeable4, r92[r32 - r18], align$foundation_layout_release, 0.0f);
                            } else {
                                Placeable.PlacementScope.place(placeable4, align$foundation_layout_release, r92[r32 - r18], 0.0f);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r5) {
                Function3 function3;
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    function3 = IntrinsicMeasureBlocks.HorizontalMinHeight;
                } else {
                    function3 = IntrinsicMeasureBlocks.VerticalMinHeight;
                }
                return ((Number) function3.invoke(measurables, Integer.valueOf(r5), Integer.valueOf(intrinsicMeasureScope.mo44roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r5) {
                Function3 function3;
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                if (LayoutOrientation.this == LayoutOrientation.Horizontal) {
                    function3 = IntrinsicMeasureBlocks.HorizontalMinWidth;
                } else {
                    function3 = IntrinsicMeasureBlocks.VerticalMinWidth;
                }
                return ((Number) function3.invoke(measurables, Integer.valueOf(r5), Integer.valueOf(intrinsicMeasureScope.mo44roundToPx0680j_4(f)))).intValue();
            }
        };
    }
}
