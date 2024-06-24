package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusRequesterModifier.kt */
/* loaded from: classes.dex */
final class FocusRequesterElement extends ModifierNodeElement<FocusRequesterNode> {
    public final FocusRequester focusRequester;

    public FocusRequesterElement(FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        this.focusRequester = focusRequester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FocusRequesterNode create() {
        return new FocusRequesterNode(this.focusRequester);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FocusRequesterElement) && Intrinsics.areEqual(this.focusRequester, ((FocusRequesterElement) obj).focusRequester)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.focusRequester.hashCode();
    }

    public final String toString() {
        return "FocusRequesterElement(focusRequester=" + this.focusRequester + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FocusRequesterNode focusRequesterNode) {
        FocusRequesterNode node = focusRequesterNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.focusRequester.focusRequesterNodes.remove(node);
        FocusRequester focusRequester = this.focusRequester;
        Intrinsics.checkNotNullParameter(focusRequester, "<set-?>");
        node.focusRequester = focusRequester;
        focusRequester.focusRequesterNodes.add(node);
    }
}
