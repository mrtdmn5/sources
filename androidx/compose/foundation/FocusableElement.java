package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusableElement extends ModifierNodeElement<FocusableNode> {
    public final MutableInteractionSource interactionSource;

    public FocusableElement(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FocusableNode create() {
        return new FocusableNode(this.interactionSource);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FocusableElement)) {
            return false;
        }
        if (Intrinsics.areEqual(this.interactionSource, ((FocusableElement) obj).interactionSource)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            return mutableInteractionSource.hashCode();
        }
        return 0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FocusableNode focusableNode) {
        FocusInteraction$Focus focusInteraction$Focus;
        FocusableNode node = focusableNode;
        Intrinsics.checkNotNullParameter(node, "node");
        FocusableInteractionNode focusableInteractionNode = node.focusableInteractionNode;
        MutableInteractionSource mutableInteractionSource = focusableInteractionNode.interactionSource;
        MutableInteractionSource mutableInteractionSource2 = this.interactionSource;
        if (!Intrinsics.areEqual(mutableInteractionSource, mutableInteractionSource2)) {
            MutableInteractionSource mutableInteractionSource3 = focusableInteractionNode.interactionSource;
            if (mutableInteractionSource3 != null && (focusInteraction$Focus = focusableInteractionNode.focusedInteraction) != null) {
                mutableInteractionSource3.tryEmit(new FocusInteraction$Unfocus(focusInteraction$Focus));
            }
            focusableInteractionNode.focusedInteraction = null;
            focusableInteractionNode.interactionSource = mutableInteractionSource2;
        }
    }
}
