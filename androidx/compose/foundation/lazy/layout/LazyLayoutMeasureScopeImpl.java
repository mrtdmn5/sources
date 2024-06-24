package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyLayoutMeasureScope.kt */
/* loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    public final LazyLayoutItemContentFactory itemContentFactory;
    public final LazyLayoutItemProvider itemProvider;
    public final HashMap<Integer, List<Placeable>> placeablesCache;
    public final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory itemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        Intrinsics.checkNotNullParameter(itemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "subcomposeMeasureScope");
        this.itemContentFactory = itemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = itemContentFactory.itemProvider.invoke();
        this.placeablesCache = new HashMap<>();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final MeasureResult layout(int r2, int r3, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
        Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
        return this.subcomposeMeasureScope.layout(r2, r3, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    /* renamed from: measure-0kLqBqw */
    public final List<Placeable> mo102measure0kLqBqw(int r7, long j) {
        HashMap<Integer, List<Placeable>> hashMap = this.placeablesCache;
        List<Placeable> list = hashMap.get(Integer.valueOf(r7));
        if (list == null) {
            LazyLayoutItemProvider lazyLayoutItemProvider = this.itemProvider;
            Object key = lazyLayoutItemProvider.getKey(r7);
            List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(key, r7, lazyLayoutItemProvider.getContentType(r7)));
            int size = subcompose.size();
            ArrayList arrayList = new ArrayList(size);
            for (int r4 = 0; r4 < size; r4++) {
                arrayList.add(subcompose.get(r4).mo421measureBRTryo0(j));
            }
            hashMap.put(Integer.valueOf(r7), arrayList);
            return arrayList;
        }
        return list;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public final int mo44roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo44roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public final float mo46toDpu2uoSUM(int r2) {
        return this.subcomposeMeasureScope.mo46toDpu2uoSUM(r2);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public final long mo47toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.mo47toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public final float mo48toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo48toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public final float mo49toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo49toPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public final long mo50toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.mo50toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public final float mo45toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.mo45toDpu2uoSUM(f);
    }
}
