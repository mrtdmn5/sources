package androidx.compose.foundation.layout;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public final class AlignmentLineOffsetDpElement extends ModifierNodeElement<AlignmentLineOffsetDpNode> {
    public final float after;
    public final AlignmentLine alignmentLine;
    public final float before;
    public final Function1<InspectorInfo, Unit> inspectorInfo;

    public AlignmentLineOffsetDpElement() {
        throw null;
    }

    public AlignmentLineOffsetDpElement(HorizontalAlignmentLine alignmentLine, float f, float f2) {
        InspectableValueKt$NoInspectorInfo$1 inspectorInfo = InspectableValueKt.NoInspectorInfo;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.alignmentLine = alignmentLine;
        this.before = f;
        this.after = f2;
        this.inspectorInfo = inspectorInfo;
        if (!((f >= 0.0f || Dp.m579equalsimpl0(f, Float.NaN)) && (f2 >= 0.0f || Dp.m579equalsimpl0(f2, Float.NaN)))) {
            throw new IllegalArgumentException("Padding from alignment line must be a non-negative number".toString());
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final AlignmentLineOffsetDpNode create() {
        return new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after);
    }

    public final boolean equals(Object obj) {
        AlignmentLineOffsetDpElement alignmentLineOffsetDpElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof AlignmentLineOffsetDpElement) {
            alignmentLineOffsetDpElement = (AlignmentLineOffsetDpElement) obj;
        } else {
            alignmentLineOffsetDpElement = null;
        }
        if (alignmentLineOffsetDpElement == null) {
            return false;
        }
        if (Intrinsics.areEqual(this.alignmentLine, alignmentLineOffsetDpElement.alignmentLine) && Dp.m579equalsimpl0(this.before, alignmentLineOffsetDpElement.before) && Dp.m579equalsimpl0(this.after, alignmentLineOffsetDpElement.after)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Float.hashCode(this.after) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.before, this.alignmentLine.hashCode() * 31, 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(AlignmentLineOffsetDpNode alignmentLineOffsetDpNode) {
        AlignmentLineOffsetDpNode node = alignmentLineOffsetDpNode;
        Intrinsics.checkNotNullParameter(node, "node");
        AlignmentLine alignmentLine = this.alignmentLine;
        Intrinsics.checkNotNullParameter(alignmentLine, "<set-?>");
        node.alignmentLine = alignmentLine;
        node.before = this.before;
        node.after = this.after;
    }
}
