package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Box.kt */
/* loaded from: classes.dex */
final class BoxChildDataElement extends ModifierNodeElement<BoxChildDataNode> {
    public final Alignment alignment;
    public final Function1<InspectorInfo, Unit> inspectorInfo;
    public final boolean matchParentSize;

    public BoxChildDataElement(BiasAlignment biasAlignment, boolean z) {
        InspectableValueKt$NoInspectorInfo$1 inspectorInfo = InspectableValueKt.NoInspectorInfo;
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.alignment = biasAlignment;
        this.matchParentSize = z;
        this.inspectorInfo = inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BoxChildDataNode create() {
        return new BoxChildDataNode(this.alignment, this.matchParentSize);
    }

    public final boolean equals(Object obj) {
        BoxChildDataElement boxChildDataElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoxChildDataElement) {
            boxChildDataElement = (BoxChildDataElement) obj;
        } else {
            boxChildDataElement = null;
        }
        if (boxChildDataElement == null) {
            return false;
        }
        if (Intrinsics.areEqual(this.alignment, boxChildDataElement.alignment) && this.matchParentSize == boxChildDataElement.matchParentSize) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.matchParentSize) + (this.alignment.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BoxChildDataNode boxChildDataNode) {
        BoxChildDataNode node = boxChildDataNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Alignment alignment = this.alignment;
        Intrinsics.checkNotNullParameter(alignment, "<set-?>");
        node.alignment = alignment;
        node.matchParentSize = this.matchParentSize;
    }
}
