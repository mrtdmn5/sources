package androidx.compose.foundation.relocation;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
final class BringIntoViewRequesterElement extends ModifierNodeElement<BringIntoViewRequesterNode> {
    public final BringIntoViewRequester requester;

    public BringIntoViewRequesterElement(BringIntoViewRequester requester) {
        Intrinsics.checkNotNullParameter(requester, "requester");
        this.requester = requester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final BringIntoViewRequesterNode create() {
        return new BringIntoViewRequesterNode(this.requester);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof BringIntoViewRequesterElement) {
                if (Intrinsics.areEqual(this.requester, ((BringIntoViewRequesterElement) obj).requester)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.requester.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(BringIntoViewRequesterNode bringIntoViewRequesterNode) {
        BringIntoViewRequesterNode node = bringIntoViewRequesterNode;
        Intrinsics.checkNotNullParameter(node, "node");
        BringIntoViewRequester requester = this.requester;
        Intrinsics.checkNotNullParameter(requester, "requester");
        BringIntoViewRequester bringIntoViewRequester = node.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).modifiers.remove(node);
        }
        if (requester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) requester).modifiers.add(node);
        }
        node.requester = requester;
    }
}
