package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnGloballyPositionedModifier.kt */
/* loaded from: classes.dex */
public final class OnGloballyPositionedElement extends ModifierNodeElement<OnGloballyPositionedNode> {
    public final Function1<LayoutCoordinates, Unit> onGloballyPositioned;

    /* JADX WARN: Multi-variable type inference failed */
    public OnGloballyPositionedElement(Function1<? super LayoutCoordinates, Unit> onGloballyPositioned) {
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "onGloballyPositioned");
        this.onGloballyPositioned = onGloballyPositioned;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final OnGloballyPositionedNode create() {
        return new OnGloballyPositionedNode(this.onGloballyPositioned);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnGloballyPositionedElement)) {
            return false;
        }
        return Intrinsics.areEqual(this.onGloballyPositioned, ((OnGloballyPositionedElement) obj).onGloballyPositioned);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onGloballyPositioned.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(OnGloballyPositionedNode onGloballyPositionedNode) {
        OnGloballyPositionedNode node = onGloballyPositionedNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<LayoutCoordinates, Unit> function1 = this.onGloballyPositioned;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.callback = function1;
    }
}
