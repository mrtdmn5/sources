package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DepthSortedSet.kt */
/* loaded from: classes.dex */
public final class DepthSortedSet$DepthComparator$1 implements Comparator<LayoutNode> {
    @Override // java.util.Comparator
    public final int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
        LayoutNode l1 = layoutNode;
        LayoutNode l2 = layoutNode2;
        Intrinsics.checkNotNullParameter(l1, "l1");
        Intrinsics.checkNotNullParameter(l2, "l2");
        int compare = Intrinsics.compare(l1.depth, l2.depth);
        if (compare == 0) {
            return Intrinsics.compare(l1.hashCode(), l2.hashCode());
        }
        return compare;
    }
}
