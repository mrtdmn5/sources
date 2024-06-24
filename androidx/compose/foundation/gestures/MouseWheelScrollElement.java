package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
final class MouseWheelScrollElement extends ModifierNodeElement<MouseWheelScrollNode> {
    public final ScrollConfig mouseWheelScrollConfig;
    public final State<ScrollingLogic> scrollingLogicState;

    public MouseWheelScrollElement(MutableState mutableState) {
        AndroidConfig androidConfig = AndroidConfig.INSTANCE;
        this.scrollingLogicState = mutableState;
        this.mouseWheelScrollConfig = androidConfig;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final MouseWheelScrollNode create() {
        return new MouseWheelScrollNode(this.scrollingLogicState, this.mouseWheelScrollConfig);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MouseWheelScrollElement)) {
            return false;
        }
        MouseWheelScrollElement mouseWheelScrollElement = (MouseWheelScrollElement) obj;
        if (Intrinsics.areEqual(this.scrollingLogicState, mouseWheelScrollElement.scrollingLogicState) && Intrinsics.areEqual(this.mouseWheelScrollConfig, mouseWheelScrollElement.mouseWheelScrollConfig)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        return this.mouseWheelScrollConfig.hashCode() + (this.scrollingLogicState.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(MouseWheelScrollNode mouseWheelScrollNode) {
        MouseWheelScrollNode node = mouseWheelScrollNode;
        Intrinsics.checkNotNullParameter(node, "node");
        State<ScrollingLogic> state = this.scrollingLogicState;
        Intrinsics.checkNotNullParameter(state, "<set-?>");
        node.scrollingLogicState = state;
        ScrollConfig scrollConfig = this.mouseWheelScrollConfig;
        Intrinsics.checkNotNullParameter(scrollConfig, "<set-?>");
        node.mouseWheelScrollConfig = scrollConfig;
    }
}
