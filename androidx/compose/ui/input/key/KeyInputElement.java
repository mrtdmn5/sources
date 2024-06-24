package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeyInputModifier.kt */
/* loaded from: classes.dex */
public final class KeyInputElement extends ModifierNodeElement<KeyInputNode> {
    public final Function1<KeyEvent, Boolean> onKeyEvent;
    public final Function1<KeyEvent, Boolean> onPreKeyEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public KeyInputElement(Function1<? super KeyEvent, Boolean> function1, Function1<? super KeyEvent, Boolean> function12) {
        this.onKeyEvent = function1;
        this.onPreKeyEvent = function12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final KeyInputNode create() {
        return new KeyInputNode(this.onKeyEvent, this.onPreKeyEvent);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        if (Intrinsics.areEqual(this.onKeyEvent, keyInputElement.onKeyEvent) && Intrinsics.areEqual(this.onPreKeyEvent, keyInputElement.onPreKeyEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        Function1<KeyEvent, Boolean> function1 = this.onKeyEvent;
        if (function1 == null) {
            hashCode = 0;
        } else {
            hashCode = function1.hashCode();
        }
        int r1 = hashCode * 31;
        Function1<KeyEvent, Boolean> function12 = this.onPreKeyEvent;
        if (function12 != null) {
            r0 = function12.hashCode();
        }
        return r1 + r0;
    }

    public final String toString() {
        return "KeyInputElement(onKeyEvent=" + this.onKeyEvent + ", onPreKeyEvent=" + this.onPreKeyEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(KeyInputNode keyInputNode) {
        KeyInputNode node = keyInputNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.onEvent = this.onKeyEvent;
        node.onPreEvent = this.onPreKeyEvent;
    }
}
