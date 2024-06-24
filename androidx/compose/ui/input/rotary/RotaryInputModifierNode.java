package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.DelegatableNode;

/* compiled from: RotaryInputModifierNode.kt */
/* loaded from: classes.dex */
public interface RotaryInputModifierNode extends DelegatableNode {
    boolean onPreRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent);

    boolean onRotaryScrollEvent(RotaryScrollEvent rotaryScrollEvent);
}
