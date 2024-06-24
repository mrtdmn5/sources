package androidx.compose.ui.node;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DepthSortedSet.kt */
/* loaded from: classes.dex */
public final class DepthSortedSetsForDifferentPasses {
    public final DepthSortedSet lookaheadSet = new DepthSortedSet();
    public final DepthSortedSet set = new DepthSortedSet();

    public final void add(LayoutNode node, boolean z) {
        Intrinsics.checkNotNullParameter(node, "node");
        DepthSortedSet depthSortedSet = this.lookaheadSet;
        if (z) {
            depthSortedSet.add(node);
        } else if (!depthSortedSet.contains(node)) {
            this.set.add(node);
        }
    }
}
