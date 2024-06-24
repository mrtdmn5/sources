package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: LayoutNodeAlignmentLines.kt */
/* loaded from: classes.dex */
public abstract class AlignmentLines {
    public final AlignmentLinesOwner alignmentLinesOwner;
    public boolean previousUsedDuringParentLayout;
    public AlignmentLinesOwner queryOwner;
    public boolean usedByModifierLayout;
    public boolean usedByModifierMeasurement;
    public boolean usedDuringParentLayout;
    public boolean usedDuringParentMeasurement;
    public boolean dirty = true;
    public final HashMap alignmentLineMap = new HashMap();

    public AlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        this.alignmentLinesOwner = alignmentLinesOwner;
    }

    public static final void access$addAlignmentLine(AlignmentLines alignmentLines, AlignmentLine alignmentLine, int r4, NodeCoordinator nodeCoordinator) {
        int roundToInt;
        alignmentLines.getClass();
        float f = r4;
        long Offset = OffsetKt.Offset(f, f);
        while (true) {
            Offset = alignmentLines.mo439calculatePositionInParentR5De75A(nodeCoordinator, Offset);
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            if (Intrinsics.areEqual(nodeCoordinator, alignmentLines.alignmentLinesOwner.getInnerCoordinator())) {
                break;
            } else if (alignmentLines.getAlignmentLinesMap(nodeCoordinator).containsKey(alignmentLine)) {
                float positionFor = alignmentLines.getPositionFor(nodeCoordinator, alignmentLine);
                Offset = OffsetKt.Offset(positionFor, positionFor);
            }
        }
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(Offset));
        } else {
            roundToInt = MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(Offset));
        }
        HashMap hashMap = alignmentLines.alignmentLineMap;
        if (hashMap.containsKey(alignmentLine)) {
            int intValue = ((Number) MapsKt__MapsKt.getValue(alignmentLine, hashMap)).intValue();
            HorizontalAlignmentLine horizontalAlignmentLine = AlignmentLineKt.FirstBaseline;
            Intrinsics.checkNotNullParameter(alignmentLine, "<this>");
            roundToInt = alignmentLine.merger.invoke(Integer.valueOf(intValue), Integer.valueOf(roundToInt)).intValue();
        }
        hashMap.put(alignmentLine, Integer.valueOf(roundToInt));
    }

    /* renamed from: calculatePositionInParent-R5De75A */
    public abstract long mo439calculatePositionInParentR5De75A(NodeCoordinator nodeCoordinator, long j);

    public abstract Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator);

    public abstract int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine);

    public final boolean getQueried$ui_release() {
        if (!this.usedDuringParentMeasurement && !this.previousUsedDuringParentLayout && !this.usedByModifierMeasurement && !this.usedByModifierLayout) {
            return false;
        }
        return true;
    }

    public final boolean getRequired$ui_release() {
        recalculateQueryOwner();
        if (this.queryOwner != null) {
            return true;
        }
        return false;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        AlignmentLinesOwner parentAlignmentLinesOwner = alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null) {
            return;
        }
        if (this.usedDuringParentMeasurement) {
            parentAlignmentLinesOwner.requestMeasure();
        } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
            parentAlignmentLinesOwner.requestLayout();
        }
        if (this.usedByModifierMeasurement) {
            alignmentLinesOwner.requestMeasure();
        }
        if (this.usedByModifierLayout) {
            alignmentLinesOwner.requestLayout();
        }
        parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
    }

    public final void recalculate() {
        HashMap hashMap = this.alignmentLineMap;
        hashMap.clear();
        Function1<AlignmentLinesOwner, Unit> function1 = new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.AlignmentLines$recalculate$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                AlignmentLines alignmentLines;
                AlignmentLinesOwner childOwner = alignmentLinesOwner;
                Intrinsics.checkNotNullParameter(childOwner, "childOwner");
                if (childOwner.isPlaced()) {
                    if (childOwner.getAlignmentLines().dirty) {
                        childOwner.layoutChildren();
                    }
                    Iterator it = childOwner.getAlignmentLines().alignmentLineMap.entrySet().iterator();
                    while (true) {
                        boolean hasNext = it.hasNext();
                        alignmentLines = AlignmentLines.this;
                        if (!hasNext) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        AlignmentLines.access$addAlignmentLine(alignmentLines, (AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), childOwner.getInnerCoordinator());
                    }
                    NodeCoordinator nodeCoordinator = childOwner.getInnerCoordinator().wrappedBy;
                    Intrinsics.checkNotNull(nodeCoordinator);
                    while (!Intrinsics.areEqual(nodeCoordinator, alignmentLines.alignmentLinesOwner.getInnerCoordinator())) {
                        for (AlignmentLine alignmentLine : alignmentLines.getAlignmentLinesMap(nodeCoordinator).keySet()) {
                            AlignmentLines.access$addAlignmentLine(alignmentLines, alignmentLine, alignmentLines.getPositionFor(nodeCoordinator, alignmentLine), nodeCoordinator);
                        }
                        nodeCoordinator = nodeCoordinator.wrappedBy;
                        Intrinsics.checkNotNull(nodeCoordinator);
                    }
                }
                return Unit.INSTANCE;
            }
        };
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        alignmentLinesOwner.forEachChildAlignmentLinesOwner(function1);
        hashMap.putAll(getAlignmentLinesMap(alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        AlignmentLines alignmentLines;
        AlignmentLines alignmentLines2;
        boolean queried$ui_release = getQueried$ui_release();
        AlignmentLinesOwner alignmentLinesOwner = this.alignmentLinesOwner;
        if (!queried$ui_release) {
            AlignmentLinesOwner parentAlignmentLinesOwner = alignmentLinesOwner.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner == null) {
                return;
            }
            alignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines().queryOwner;
            if (alignmentLinesOwner == null || !alignmentLinesOwner.getAlignmentLines().getQueried$ui_release()) {
                AlignmentLinesOwner alignmentLinesOwner2 = this.queryOwner;
                if (alignmentLinesOwner2 != null && !alignmentLinesOwner2.getAlignmentLines().getQueried$ui_release()) {
                    AlignmentLinesOwner parentAlignmentLinesOwner2 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                    if (parentAlignmentLinesOwner2 != null && (alignmentLines2 = parentAlignmentLinesOwner2.getAlignmentLines()) != null) {
                        alignmentLines2.recalculateQueryOwner();
                    }
                    AlignmentLinesOwner parentAlignmentLinesOwner3 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                    if (parentAlignmentLinesOwner3 != null && (alignmentLines = parentAlignmentLinesOwner3.getAlignmentLines()) != null) {
                        alignmentLinesOwner = alignmentLines.queryOwner;
                    } else {
                        alignmentLinesOwner = null;
                    }
                } else {
                    return;
                }
            }
        }
        this.queryOwner = alignmentLinesOwner;
    }
}
