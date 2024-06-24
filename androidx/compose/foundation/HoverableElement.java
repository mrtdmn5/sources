package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Hoverable.kt */
/* loaded from: classes.dex */
final class HoverableElement extends ModifierNodeElement<HoverableNode> {
    public final MutableInteractionSource interactionSource;

    public HoverableElement(MutableInteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        this.interactionSource = interactionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final HoverableNode create() {
        return new HoverableNode(this.interactionSource);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof HoverableElement) && Intrinsics.areEqual(((HoverableElement) obj).interactionSource, this.interactionSource)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.interactionSource.hashCode() * 31;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(HoverableNode hoverableNode) {
        HoverableNode node = hoverableNode;
        Intrinsics.checkNotNullParameter(node, "node");
        MutableInteractionSource interactionSource = this.interactionSource;
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        if (!Intrinsics.areEqual(node.interactionSource, interactionSource)) {
            node.tryEmitExit();
            node.interactionSource = interactionSource;
        }
    }
}
