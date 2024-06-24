package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RotaryInputModifier.kt */
/* loaded from: classes.dex */
public final class RotaryInputElement extends ModifierNodeElement<RotaryInputNode> {
    public final Function1<RotaryScrollEvent, Boolean> onPreRotaryScrollEvent = null;
    public final Function1<RotaryScrollEvent, Boolean> onRotaryScrollEvent;

    public RotaryInputElement(AndroidComposeView$rotaryInputModifier$1 androidComposeView$rotaryInputModifier$1) {
        this.onRotaryScrollEvent = androidComposeView$rotaryInputModifier$1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final RotaryInputNode create() {
        return new RotaryInputNode(this.onRotaryScrollEvent, this.onPreRotaryScrollEvent);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotaryInputElement)) {
            return false;
        }
        RotaryInputElement rotaryInputElement = (RotaryInputElement) obj;
        if (Intrinsics.areEqual(this.onRotaryScrollEvent, rotaryInputElement.onRotaryScrollEvent) && Intrinsics.areEqual(this.onPreRotaryScrollEvent, rotaryInputElement.onPreRotaryScrollEvent)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        Function1<RotaryScrollEvent, Boolean> function1 = this.onRotaryScrollEvent;
        if (function1 == null) {
            hashCode = 0;
        } else {
            hashCode = function1.hashCode();
        }
        int r1 = hashCode * 31;
        Function1<RotaryScrollEvent, Boolean> function12 = this.onPreRotaryScrollEvent;
        if (function12 != null) {
            r0 = function12.hashCode();
        }
        return r1 + r0;
    }

    public final String toString() {
        return "RotaryInputElement(onRotaryScrollEvent=" + this.onRotaryScrollEvent + ", onPreRotaryScrollEvent=" + this.onPreRotaryScrollEvent + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(RotaryInputNode rotaryInputNode) {
        RotaryInputNode node = rotaryInputNode;
        Intrinsics.checkNotNullParameter(node, "node");
        node.onEvent = this.onRotaryScrollEvent;
        node.onPreEvent = this.onPreRotaryScrollEvent;
    }
}
