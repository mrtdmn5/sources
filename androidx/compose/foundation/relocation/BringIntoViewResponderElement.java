package androidx.compose.foundation.relocation;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BringIntoViewResponder.kt */
/* loaded from: classes.dex */
public final class BringIntoViewResponderElement extends ModifierNodeElement<BringIntoViewResponderNode> {
    public final BringIntoViewResponder responder;

    public BringIntoViewResponderElement(BringIntoViewResponder responder) {
        Intrinsics.checkNotNullParameter(responder, "responder");
        this.responder = responder;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BringIntoViewResponderNode create() {
        return new BringIntoViewResponderNode(this.responder);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BringIntoViewResponderElement) {
                if (Intrinsics.areEqual(this.responder, ((BringIntoViewResponderElement) obj).responder)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.responder.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BringIntoViewResponderNode bringIntoViewResponderNode) {
        BringIntoViewResponderNode node = bringIntoViewResponderNode;
        Intrinsics.checkNotNullParameter(node, "node");
        BringIntoViewResponder bringIntoViewResponder = this.responder;
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "<set-?>");
        node.responder = bringIntoViewResponder;
    }
}
