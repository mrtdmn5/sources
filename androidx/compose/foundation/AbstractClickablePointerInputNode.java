package androidx.compose.foundation;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.AbstractClickableNode;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
/* loaded from: classes.dex */
public abstract class AbstractClickablePointerInputNode extends DelegatingNode implements ModifierLocalModifierNode, CompositionLocalConsumerModifierNode, PointerInputModifierNode {
    public final AbstractClickablePointerInputNode$delayPressInteraction$1 delayPressInteraction;
    public boolean enabled;
    public final AbstractClickableNode.InteractionData interactionData;
    public MutableInteractionSource interactionSource;
    public Function0<Unit> onClick;
    public final SuspendingPointerInputModifierNode pointerInputNode;

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.AbstractClickablePointerInputNode$delayPressInteraction$1] */
    public AbstractClickablePointerInputNode(boolean z, MutableInteractionSource mutableInteractionSource, Function0 function0, AbstractClickableNode.InteractionData interactionData) {
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.onClick = function0;
        this.interactionData = interactionData;
        final ClickablePointerInputNode clickablePointerInputNode = (ClickablePointerInputNode) this;
        this.delayPressInteraction = new Function0<Boolean>() { // from class: androidx.compose.foundation.AbstractClickablePointerInputNode$delayPressInteraction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z2;
                ProvidableModifierLocal<Boolean> providableModifierLocal = ScrollableKt.ModifierLocalScrollableContainer;
                AbstractClickablePointerInputNode abstractClickablePointerInputNode = clickablePointerInputNode;
                boolean z3 = true;
                if (!((Boolean) abstractClickablePointerInputNode.getCurrent(providableModifierLocal)).booleanValue()) {
                    int r0 = Clickable_androidKt.$r8$clinit;
                    ViewParent parent = ((View) CompositionLocalConsumerModifierNodeKt.currentValueOf(abstractClickablePointerInputNode, AndroidCompositionLocals_androidKt.LocalView)).getParent();
                    while (parent != null && (parent instanceof ViewGroup)) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        if (viewGroup.shouldDelayChildPressedState()) {
                            z2 = true;
                            break;
                        }
                        parent = viewGroup.getParent();
                    }
                    z2 = false;
                    if (!z2) {
                        z3 = false;
                    }
                }
                return Boolean.valueOf(z3);
            }
        };
        AbstractClickablePointerInputNode$pointerInputNode$1 abstractClickablePointerInputNode$pointerInputNode$1 = new AbstractClickablePointerInputNode$pointerInputNode$1(this, null);
        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = new SuspendingPointerInputModifierNodeImpl(abstractClickablePointerInputNode$pointerInputNode$1);
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

    public abstract Object pointerInput(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation);
}
