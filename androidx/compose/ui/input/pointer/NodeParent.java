package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public class NodeParent {
    public final MutableVector<Node> children = new MutableVector<>(new Node[16]);

    public boolean buildCache(Map<PointerId, PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        MutableVector<Node> mutableVector = this.children;
        int r1 = mutableVector.size;
        if (r1 <= 0) {
            return false;
        }
        Node[] nodeArr = mutableVector.content;
        int r3 = 0;
        boolean z2 = false;
        do {
            if (!nodeArr[r3].buildCache(changes, parentCoordinates, internalPointerEvent, z) && !z2) {
                z2 = false;
            } else {
                z2 = true;
            }
            r3++;
        } while (r3 < r1);
        return z2;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> mutableVector = this.children;
        for (int r0 = mutableVector.size - 1; -1 < r0; r0--) {
            if (mutableVector.content[r0].pointerIds.isEmpty()) {
                mutableVector.removeAt(r0);
            }
        }
    }

    public final void removeDetachedPointerInputFilters() {
        int r0 = 0;
        while (true) {
            MutableVector<Node> mutableVector = this.children;
            if (r0 < mutableVector.size) {
                Node node = mutableVector.content[r0];
                if (!node.modifierNode.isAttached) {
                    mutableVector.removeAt(r0);
                    node.dispatchCancel();
                } else {
                    r0++;
                    node.removeDetachedPointerInputFilters();
                }
            } else {
                return;
            }
        }
    }
}
