package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NodeChain.kt */
/* loaded from: classes.dex */
public final class ForceUpdateElement extends ModifierNodeElement<Modifier.Node> {
    public final ModifierNodeElement<?> original;

    public ForceUpdateElement(ModifierNodeElement<?> original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        throw new IllegalStateException("Shouldn't be called");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ForceUpdateElement) && Intrinsics.areEqual(this.original, ((ForceUpdateElement) obj).original)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.original.hashCode();
    }

    public final String toString() {
        return "ForceUpdateElement(original=" + this.original + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        throw new IllegalStateException("Shouldn't be called");
    }
}
