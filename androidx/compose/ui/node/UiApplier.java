package androidx.compose.ui.node;

import androidx.compose.runtime.AbstractApplier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiApplier.android.kt */
/* loaded from: classes.dex */
public final class UiApplier extends AbstractApplier<LayoutNode> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiApplier(LayoutNode root) {
        super(root);
        Intrinsics.checkNotNullParameter(root, "root");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void insertBottomUp(int r2, Object obj) {
        LayoutNode instance = (LayoutNode) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
        ((LayoutNode) this.current).insertAt$ui_release(r2, instance);
    }

    @Override // androidx.compose.runtime.Applier
    public final void insertTopDown(int r1, Object obj) {
        LayoutNode instance = (LayoutNode) obj;
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void move(int r2, int r3, int r4) {
        ((LayoutNode) this.current).move$ui_release(r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.AbstractApplier
    public final void onClear() {
        ((LayoutNode) this.root).removeAll$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void onEndChanges() {
        Owner owner = ((LayoutNode) this.root).owner;
        if (owner != null) {
            owner.onEndApplyChanges();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.Applier
    public final void remove(int r2, int r3) {
        ((LayoutNode) this.current).removeAt$ui_release(r2, r3);
    }
}
