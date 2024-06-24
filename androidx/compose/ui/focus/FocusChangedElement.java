package androidx.compose.ui.focus;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusChangedModifier.kt */
/* loaded from: classes.dex */
final class FocusChangedElement extends ModifierNodeElement<FocusChangedNode> {
    public final Function1<FocusState, Unit> onFocusChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusChangedElement(Function1<? super FocusState, Unit> onFocusChanged) {
        Intrinsics.checkNotNullParameter(onFocusChanged, "onFocusChanged");
        this.onFocusChanged = onFocusChanged;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FocusChangedNode create() {
        return new FocusChangedNode(this.onFocusChanged);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FocusChangedElement) && Intrinsics.areEqual(this.onFocusChanged, ((FocusChangedElement) obj).onFocusChanged)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onFocusChanged.hashCode();
    }

    public final String toString() {
        return "FocusChangedElement(onFocusChanged=" + this.onFocusChanged + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FocusChangedNode focusChangedNode) {
        FocusChangedNode node = focusChangedNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<FocusState, Unit> function1 = this.onFocusChanged;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.onFocusChanged = function1;
    }
}
