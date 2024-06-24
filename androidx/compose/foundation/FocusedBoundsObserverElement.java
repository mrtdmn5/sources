package androidx.compose.foundation;

import androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FocusedBounds.kt */
/* loaded from: classes.dex */
public final class FocusedBoundsObserverElement extends ModifierNodeElement<FocusedBoundsObserverNode> {
    public final Function1<LayoutCoordinates, Unit> onPositioned;

    public FocusedBoundsObserverElement(ContentInViewModifier$modifier$1 contentInViewModifier$modifier$1) {
        this.onPositioned = contentInViewModifier$modifier$1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final FocusedBoundsObserverNode create() {
        return new FocusedBoundsObserverNode(this.onPositioned);
    }

    public final boolean equals(Object obj) {
        FocusedBoundsObserverElement focusedBoundsObserverElement;
        if (this == obj) {
            return true;
        }
        if (obj instanceof FocusedBoundsObserverElement) {
            focusedBoundsObserverElement = (FocusedBoundsObserverElement) obj;
        } else {
            focusedBoundsObserverElement = null;
        }
        if (focusedBoundsObserverElement == null) {
            return false;
        }
        return Intrinsics.areEqual(this.onPositioned, focusedBoundsObserverElement.onPositioned);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.onPositioned.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(FocusedBoundsObserverNode focusedBoundsObserverNode) {
        FocusedBoundsObserverNode node = focusedBoundsObserverNode;
        Intrinsics.checkNotNullParameter(node, "node");
        Function1<LayoutCoordinates, Unit> function1 = this.onPositioned;
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        node.onPositioned = function1;
    }
}
