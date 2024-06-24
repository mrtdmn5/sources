package androidx.compose.ui.semantics;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsModifier.kt */
/* loaded from: classes.dex */
public final class EmptySemanticsElement extends ModifierNodeElement<EmptySemanticsModifier> {
    public static final EmptySemanticsElement INSTANCE = new EmptySemanticsElement();

    private EmptySemanticsElement() {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final EmptySemanticsModifier create() {
        return new EmptySemanticsModifier();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(EmptySemanticsModifier emptySemanticsModifier) {
        EmptySemanticsModifier node = emptySemanticsModifier;
        Intrinsics.checkNotNullParameter(node, "node");
    }
}
