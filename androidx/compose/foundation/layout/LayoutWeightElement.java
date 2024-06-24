package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class LayoutWeightElement extends ModifierNodeElement<LayoutWeightNode> {
    public final boolean fill;
    public final float weight;

    public LayoutWeightElement(float f, boolean z) {
        this.weight = f;
        this.fill = z;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final LayoutWeightNode create() {
        return new LayoutWeightNode(this.weight, this.fill);
    }

    public final boolean equals(Object obj) {
        LayoutWeightElement layoutWeightElement;
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutWeightElement) {
            layoutWeightElement = (LayoutWeightElement) obj;
        } else {
            layoutWeightElement = null;
        }
        if (layoutWeightElement == null) {
            return false;
        }
        if (this.weight == layoutWeightElement.weight) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.fill == layoutWeightElement.fill) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Boolean.hashCode(this.fill) + (Float.hashCode(this.weight) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(LayoutWeightNode layoutWeightNode) {
        LayoutWeightNode node = layoutWeightNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.weight = this.weight;
        node.fill = this.fill;
    }
}
