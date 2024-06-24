package androidx.compose.foundation;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: Focusable.kt */
/* loaded from: classes.dex */
public final class FocusablePinnableContainerNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, ObserverModifierNode {
    public boolean isFocused;
    public PinnableContainer.PinnedHandle pinnedHandle;

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        LazyLayoutPinnableItem lazyLayoutPinnableItem;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ObserverModifierNodeKt.observeReads(this, new FocusablePinnableContainerNode$retrievePinnableContainer$1(ref$ObjectRef, this));
        PinnableContainer pinnableContainer = (PinnableContainer) ref$ObjectRef.element;
        if (this.isFocused) {
            PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            if (pinnableContainer != null) {
                lazyLayoutPinnableItem = pinnableContainer.pin();
            } else {
                lazyLayoutPinnableItem = null;
            }
            this.pinnedHandle = lazyLayoutPinnableItem;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        PinnableContainer.PinnedHandle pinnedHandle = this.pinnedHandle;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.pinnedHandle = null;
    }
}
