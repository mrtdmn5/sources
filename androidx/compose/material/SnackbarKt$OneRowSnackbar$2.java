package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snackbar.kt */
/* loaded from: classes.dex */
public final class SnackbarKt$OneRowSnackbar$2 implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        int r9;
        boolean z;
        boolean z2;
        int max;
        final int r7;
        final int r10;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<? extends Measurable> list = measurables;
        for (Measurable measurable : list) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), AnalyticsConstants.KEY_ACTION)) {
                final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
                int m565getMaxWidthimpl = (Constraints.m565getMaxWidthimpl(j) - mo421measureBRTryo0.width) - Layout.mo44roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing);
                int m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
                if (m565getMaxWidthimpl < m567getMinWidthimpl) {
                    r9 = m567getMinWidthimpl;
                } else {
                    r9 = m565getMaxWidthimpl;
                }
                for (Measurable measurable2 : list) {
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "text")) {
                        final Placeable mo421measureBRTryo02 = measurable2.mo421measureBRTryo0(Constraints.m558copyZbe2FdA$default(j, 0, r9, 0, 0, 9));
                        HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.FirstBaseline;
                        int r3 = mo421measureBRTryo02.get(horizontalAlignmentLine);
                        boolean z3 = true;
                        int r72 = 0;
                        if (r3 != Integer.MIN_VALUE) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            int r8 = mo421measureBRTryo02.get(AlignmentLineKt.LastBaseline);
                            if (r8 != Integer.MIN_VALUE) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (r3 != r8) {
                                    z3 = false;
                                }
                                final int m565getMaxWidthimpl2 = Constraints.m565getMaxWidthimpl(j) - mo421measureBRTryo0.width;
                                if (z3) {
                                    max = Math.max(Layout.mo44roundToPx0680j_4(SnackbarKt.SnackbarMinHeightOneLine), mo421measureBRTryo0.height);
                                    int r82 = (max - mo421measureBRTryo02.height) / 2;
                                    int r1 = mo421measureBRTryo0.get(horizontalAlignmentLine);
                                    if (r1 != Integer.MIN_VALUE) {
                                        r72 = (r3 + r82) - r1;
                                    }
                                    r10 = r72;
                                    r7 = r82;
                                } else {
                                    int mo44roundToPx0680j_4 = Layout.mo44roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - r3;
                                    max = Math.max(Layout.mo44roundToPx0680j_4(SnackbarKt.SnackbarMinHeightTwoLines), mo421measureBRTryo02.height + mo44roundToPx0680j_4);
                                    r7 = mo44roundToPx0680j_4;
                                    r10 = (max - mo421measureBRTryo0.height) / 2;
                                }
                                return Layout.layout(Constraints.m565getMaxWidthimpl(j), max, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$OneRowSnackbar$2$measure$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope layout = placementScope;
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Placeable.PlacementScope.placeRelative$default(layout, Placeable.this, 0, r7);
                                        Placeable.PlacementScope.placeRelative$default(layout, mo421measureBRTryo0, m565getMaxWidthimpl2, r10);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            throw new IllegalArgumentException("No baselines for text".toString());
                        }
                        throw new IllegalArgumentException("No baselines for text".toString());
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
