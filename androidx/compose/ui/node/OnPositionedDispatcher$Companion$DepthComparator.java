package androidx.compose.ui.node;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnPositionedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnPositionedDispatcher$Companion$DepthComparator implements Comparator<LayoutNode> {
    public static final OnPositionedDispatcher$Companion$DepthComparator INSTANCE = new OnPositionedDispatcher$Companion$DepthComparator();

    @Override // java.util.Comparator
    public final int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
        LayoutNode a = layoutNode;
        LayoutNode b = layoutNode2;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        int compare = Intrinsics.compare(b.depth, a.depth);
        if (compare == 0) {
            return Intrinsics.compare(a.hashCode(), b.hashCode());
        }
        return compare;
    }
}
