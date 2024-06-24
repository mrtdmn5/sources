package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class VerticalAlignElement extends ModifierNodeElement<VerticalAlignNode> {
    public final Alignment.Vertical alignment;

    public VerticalAlignElement(BiasAlignment.Vertical vertical) {
        this.alignment = vertical;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final VerticalAlignNode create() {
        return new VerticalAlignNode(this.alignment);
    }

    public final boolean equals(Object obj) {
        VerticalAlignElement verticalAlignElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof VerticalAlignElement) {
            verticalAlignElement = (VerticalAlignElement) obj;
        } else {
            verticalAlignElement = null;
        }
        if (verticalAlignElement == null) {
            return false;
        }
        return Intrinsics.areEqual(this.alignment, verticalAlignElement.alignment);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.alignment.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(VerticalAlignNode verticalAlignNode) {
        VerticalAlignNode node = verticalAlignNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Alignment.Vertical vertical = this.alignment;
        Intrinsics.checkNotNullParameter(vertical, "<set-?>");
        node.vertical = vertical;
    }
}
