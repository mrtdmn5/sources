package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.AbstractApplier;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorCompose.kt */
/* loaded from: classes.dex */
public final class VectorApplier extends AbstractApplier<VNode> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorApplier(GroupComponent root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    public static GroupComponent asGroup(VNode vNode) {
        if (vNode instanceof GroupComponent) {
            return (GroupComponent) vNode;
        }
        throw new IllegalStateException("Cannot only insert VNode into Group".toString());
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertBottomUp(int r1, Object obj) {
        VNode instance = (VNode) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void insertTopDown(int r4, Object obj) {
        VNode instance = (VNode) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        GroupComponent asGroup = asGroup((VNode) this.current);
        asGroup.getClass();
        ArrayList arrayList = asGroup.children;
        if (r4 < arrayList.size()) {
            arrayList.set(r4, instance);
        } else {
            arrayList.add(instance);
        }
        instance.setInvalidateListener$ui_release(asGroup.invalidateListener);
        asGroup.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void move(int r6, int r7, int r8) {
        GroupComponent asGroup = asGroup((VNode) this.current);
        ArrayList arrayList = asGroup.children;
        int r2 = 0;
        if (r6 > r7) {
            while (r2 < r8) {
                VNode vNode = (VNode) arrayList.get(r6);
                arrayList.remove(r6);
                arrayList.add(r7, vNode);
                r7++;
                r2++;
            }
        } else {
            while (r2 < r8) {
                VNode vNode2 = (VNode) arrayList.get(r6);
                arrayList.remove(r6);
                arrayList.add(r7 - 1, vNode2);
                r2++;
            }
        }
        asGroup.invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.AbstractApplier
    public final void onClear() {
        GroupComponent asGroup = asGroup((VNode) this.root);
        asGroup.remove(0, asGroup.children.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void remove(int r2, int r3) {
        asGroup((VNode) this.current).remove(r2, r3);
    }
}
