package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class HorizontalAlignElement extends ModifierNodeElement<HorizontalAlignNode> {
    public final Alignment.Horizontal horizontal;

    public HorizontalAlignElement(BiasAlignment.Horizontal horizontal) {
        this.horizontal = horizontal;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final HorizontalAlignNode create() {
        return new HorizontalAlignNode(this.horizontal);
    }

    public final boolean equals(Object obj) {
        HorizontalAlignElement horizontalAlignElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof HorizontalAlignElement) {
            horizontalAlignElement = (HorizontalAlignElement) obj;
        } else {
            horizontalAlignElement = null;
        }
        if (horizontalAlignElement == null) {
            return false;
        }
        return Intrinsics.areEqual(this.horizontal, horizontalAlignElement.horizontal);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.horizontal.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(HorizontalAlignNode horizontalAlignNode) {
        HorizontalAlignNode node = horizontalAlignNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Alignment.Horizontal horizontal = this.horizontal;
        Intrinsics.checkNotNullParameter(horizontal, "<set-?>");
        node.horizontal = horizontal;
    }
}
