package androidx.compose.foundation.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Size.kt */
/* loaded from: classes.dex */
final class UnspecifiedConstraintsElement extends ModifierNodeElement<UnspecifiedConstraintsNode> {
    public final float minHeight;
    public final float minWidth;

    public UnspecifiedConstraintsElement(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final UnspecifiedConstraintsNode create() {
        return new UnspecifiedConstraintsNode(this.minWidth, this.minHeight);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UnspecifiedConstraintsElement)) {
            return false;
        }
        UnspecifiedConstraintsElement unspecifiedConstraintsElement = (UnspecifiedConstraintsElement) obj;
        if (!Dp.m579equalsimpl0(this.minWidth, unspecifiedConstraintsElement.minWidth) || !Dp.m579equalsimpl0(this.minHeight, unspecifiedConstraintsElement.minHeight)) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return Float.hashCode(this.minHeight) + (Float.hashCode(this.minWidth) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(UnspecifiedConstraintsNode unspecifiedConstraintsNode) {
        UnspecifiedConstraintsNode node = unspecifiedConstraintsNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.minWidth = this.minWidth;
        node.minHeight = this.minHeight;
    }
}
