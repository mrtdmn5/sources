package androidx.compose.ui.focus;

import androidx.compose.ui.node.DelegatableNode;

/* compiled from: FocusEventModifierNode.kt */
/* loaded from: classes.dex */
public interface FocusEventModifierNode extends DelegatableNode {
    void onFocusEvent(FocusStateImpl focusStateImpl);
}
