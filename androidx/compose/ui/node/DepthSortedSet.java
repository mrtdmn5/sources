package androidx.compose.ui.node;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DepthSortedSet.kt */
/* loaded from: classes.dex */
public final class DepthSortedSet {
    public final boolean extraAssertions = false;
    public final Lazy mapOfOriginalDepth$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Map<LayoutNode, Integer>>() { // from class: androidx.compose.ui.node.DepthSortedSet$mapOfOriginalDepth$2
        @Override // kotlin.jvm.functions.Function0
        public final Map<LayoutNode, Integer> invoke() {
            return new LinkedHashMap();
        }
    });
    public final TreeSet<LayoutNode> set = new TreeSet<>(new DepthSortedSet$DepthComparator$1());

    public final void add(LayoutNode node) {
        boolean z;
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            if (this.extraAssertions) {
                Lazy lazy = this.mapOfOriginalDepth$delegate;
                Integer num = (Integer) ((Map) lazy.getValue()).get(node);
                if (num == null) {
                    ((Map) lazy.getValue()).put(node, Integer.valueOf(node.depth));
                } else {
                    if (num.intValue() == node.depth) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            this.set.add(node);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean contains(LayoutNode node) {
        boolean z;
        Intrinsics.checkNotNullParameter(node, "node");
        boolean contains = this.set.contains(node);
        if (this.extraAssertions) {
            if (contains == ((Map) this.mapOfOriginalDepth$delegate.getValue()).containsKey(node)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        return contains;
    }

    public final LayoutNode pop() {
        LayoutNode node = this.set.first();
        Intrinsics.checkNotNullExpressionValue(node, "node");
        remove(node);
        return node;
    }

    public final boolean remove(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached()) {
            boolean remove = this.set.remove(node);
            if (this.extraAssertions) {
                Integer num = (Integer) ((Map) this.mapOfOriginalDepth$delegate.getValue()).remove(node);
                boolean z = true;
                if (remove) {
                    int r6 = node.depth;
                    if (num == null || num.intValue() != r6) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (num != null) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                }
            }
            return remove;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final String toString() {
        String obj = this.set.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "set.toString()");
        return obj;
    }
}
