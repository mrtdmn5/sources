package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableElement extends ModifierNodeElement<DraggableNode> {
    public final Function1<PointerInputChange, Boolean> canDrag;
    public final boolean enabled;
    public final MutableInteractionSource interactionSource;
    public final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    public final Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> onDragStopped;
    public final Orientation orientation;
    public final boolean reverseDirection;
    public final Function0<Boolean> startDragImmediately;
    public final DraggableState state;

    /* JADX WARN: Multi-variable type inference failed */
    public DraggableElement(DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean z2) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        this.state = state;
        this.canDrag = canDrag;
        this.orientation = orientation;
        this.enabled = z;
        this.interactionSource = mutableInteractionSource;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.reverseDirection = z2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final DraggableNode create() {
        return new DraggableNode(this.state, this.canDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(DraggableElement.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DraggableElement");
        DraggableElement draggableElement = (DraggableElement) obj;
        if (Intrinsics.areEqual(this.state, draggableElement.state) && Intrinsics.areEqual(this.canDrag, draggableElement.canDrag) && this.orientation == draggableElement.orientation && this.enabled == draggableElement.enabled && Intrinsics.areEqual(this.interactionSource, draggableElement.interactionSource) && Intrinsics.areEqual(this.startDragImmediately, draggableElement.startDragImmediately) && Intrinsics.areEqual(this.onDragStarted, draggableElement.onDragStarted) && Intrinsics.areEqual(this.onDragStopped, draggableElement.onDragStopped) && this.reverseDirection == draggableElement.reverseDirection) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int r1;
        int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.enabled, (this.orientation.hashCode() + ((this.canDrag.hashCode() + (this.state.hashCode() * 31)) * 31)) * 31, 31);
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            r1 = mutableInteractionSource.hashCode();
        } else {
            r1 = 0;
        }
        return Boolean.hashCode(this.reverseDirection) + ((this.onDragStopped.hashCode() + ((this.onDragStarted.hashCode() + ((this.startDragImmediately.hashCode() + ((m + r1) * 31)) * 31)) * 31)) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(DraggableNode draggableNode) {
        boolean z;
        DraggableNode node = draggableNode;
        Intrinsics.checkNotNullParameter(node, "node");
        DraggableState state = this.state;
        Intrinsics.checkNotNullParameter(state, "state");
        Function1<PointerInputChange, Boolean> canDrag = this.canDrag;
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Orientation orientation = this.orientation;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Function0<Boolean> startDragImmediately = this.startDragImmediately;
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted = this.onDragStarted;
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> onDragStopped = this.onDragStopped;
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        boolean z2 = true;
        if (!Intrinsics.areEqual(node.state, state)) {
            node.state = state;
            z = true;
        } else {
            z = false;
        }
        node.canDrag = canDrag;
        if (node.orientation != orientation) {
            node.orientation = orientation;
            z = true;
        }
        boolean z3 = node.enabled;
        boolean z4 = this.enabled;
        if (z3 != z4) {
            node.enabled = z4;
            if (!z4) {
                node.disposeInteractionSource();
            }
            z = true;
        }
        MutableInteractionSource mutableInteractionSource = node.interactionSource;
        MutableInteractionSource mutableInteractionSource2 = this.interactionSource;
        if (!Intrinsics.areEqual(mutableInteractionSource, mutableInteractionSource2)) {
            node.disposeInteractionSource();
            node.interactionSource = mutableInteractionSource2;
        }
        node.startDragImmediately = startDragImmediately;
        node.onDragStarted = onDragStarted;
        node.onDragStopped = onDragStopped;
        boolean z5 = node.reverseDirection;
        boolean z6 = this.reverseDirection;
        if (z5 != z6) {
            node.reverseDirection = z6;
        } else {
            z2 = z;
        }
        if (z2) {
            node.pointerInputNode.resetPointerInputHandler();
        }
    }
}
