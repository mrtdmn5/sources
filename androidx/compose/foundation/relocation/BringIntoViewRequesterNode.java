package androidx.compose.foundation.relocation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewRequester.kt */
/* loaded from: classes.dex */
public final class BringIntoViewRequesterNode extends BringIntoViewChildNode {
    public BringIntoViewRequester requester;

    public BringIntoViewRequesterNode(BringIntoViewRequester requester) {
        Intrinsics.checkNotNullParameter(requester, "requester");
        this.requester = requester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        BringIntoViewRequester requester = this.requester;
        Intrinsics.checkNotNullParameter(requester, "requester");
        BringIntoViewRequester bringIntoViewRequester = this.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).modifiers.remove(this);
        }
        if (requester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) requester).modifiers.add(this);
        }
        this.requester = requester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        BringIntoViewRequester bringIntoViewRequester = this.requester;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).modifiers.remove(this);
        }
    }
}
