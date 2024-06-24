package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class MouseWheelScrollNode extends DelegatingNode implements PointerInputModifierNode {
    public ScrollConfig mouseWheelScrollConfig;
    public final SuspendingPointerInputModifierNode pointerInputNode;
    public State<ScrollingLogic> scrollingLogicState;

    public MouseWheelScrollNode(State<ScrollingLogic> scrollingLogicState, ScrollConfig mouseWheelScrollConfig) {
        Intrinsics.checkNotNullParameter(scrollingLogicState, "scrollingLogicState");
        Intrinsics.checkNotNullParameter(mouseWheelScrollConfig, "mouseWheelScrollConfig");
        this.scrollingLogicState = scrollingLogicState;
        this.mouseWheelScrollConfig = mouseWheelScrollConfig;
        MouseWheelScrollNode$pointerInputNode$1 mouseWheelScrollNode$pointerInputNode$1 = new MouseWheelScrollNode$pointerInputNode$1(this, null);
        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = new SuspendingPointerInputModifierNodeImpl(mouseWheelScrollNode$pointerInputNode$1);
        delegate(suspendingPointerInputModifierNodeImpl);
        this.pointerInputNode = suspendingPointerInputModifierNodeImpl;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public final void mo13onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.pointerInputNode.mo13onPointerEventH0pRuoY(pointerEvent, pass, j);
    }
}
