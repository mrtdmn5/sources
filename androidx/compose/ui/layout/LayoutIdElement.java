package androidx.compose.ui.layout;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutId.kt */
/* loaded from: classes.dex */
final class LayoutIdElement extends ModifierNodeElement<LayoutIdModifier> {
    public final Object layoutId;

    public LayoutIdElement(String str) {
        this.layoutId = str;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final LayoutIdModifier create() {
        return new LayoutIdModifier(this.layoutId);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LayoutIdElement) && Intrinsics.areEqual(this.layoutId, ((LayoutIdElement) obj).layoutId)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.layoutId.hashCode();
    }

    public final String toString() {
        return "LayoutIdElement(layoutId=" + this.layoutId + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(LayoutIdModifier layoutIdModifier) {
        LayoutIdModifier node = layoutIdModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        Object obj = this.layoutId;
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        node.layoutId = obj;
    }
}
