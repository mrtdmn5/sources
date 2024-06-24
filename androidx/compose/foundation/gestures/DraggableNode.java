package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction$Cancel;
import androidx.compose.foundation.interaction.DragInteraction$Start;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DraggableNode extends DelegatingNode implements PointerInputModifierNode {
    public final DraggableNode$_canDrag$1 _canDrag;
    public final DraggableNode$_startDragImmediately$1 _startDragImmediately;
    public Function1<? super PointerInputChange, Boolean> canDrag;
    public final BufferedChannel channel;
    public DragInteraction$Start dragInteraction;
    public boolean enabled;
    public MutableInteractionSource interactionSource;
    public Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    public Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    public Orientation orientation;
    public final SuspendingPointerInputModifierNode pointerInputNode;
    public boolean reverseDirection;
    public Function0<Boolean> startDragImmediately;
    public DraggableState state;
    public final VelocityTracker velocityTracker;

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.foundation.gestures.DraggableNode$_canDrag$1] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.foundation.gestures.DraggableNode$_startDragImmediately$1] */
    public DraggableNode(DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean z2) {
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
        this._canDrag = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableNode$_canDrag$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange pointerInputChange) {
                PointerInputChange it = pointerInputChange;
                Intrinsics.checkNotNullParameter(it, "it");
                return DraggableNode.this.canDrag.invoke(it);
            }
        };
        this._startDragImmediately = new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableNode$_startDragImmediately$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return DraggableNode.this.startDragImmediately.invoke();
            }
        };
        this.velocityTracker = new VelocityTracker();
        DraggableNode$pointerInputNode$1 draggableNode$pointerInputNode$1 = new DraggableNode$pointerInputNode$1(this, null);
        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = new SuspendingPointerInputModifierNodeImpl(draggableNode$pointerInputNode$1);
        delegate(suspendingPointerInputModifierNodeImpl);
        this.pointerInputNode = suspendingPointerInputModifierNodeImpl;
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$processDragCancel(androidx.compose.foundation.gestures.DraggableNode r9, kotlin.coroutines.Continuation r10, kotlinx.coroutines.CoroutineScope r11) {
        /*
            r9.getClass()
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1
            if (r0 == 0) goto L16
            r0 = r10
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragCancel$1
            r0.<init>(r9, r10)
        L1b:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L41
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L76
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlinx.coroutines.CoroutineScope r9 = r0.L$1
            androidx.compose.foundation.gestures.DraggableNode r11 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            r8 = r11
            r11 = r9
            r9 = r8
            goto L5e
        L41:
            kotlin.ResultKt.throwOnFailure(r10)
            androidx.compose.foundation.interaction.DragInteraction$Start r10 = r9.dragInteraction
            if (r10 == 0) goto L60
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r9.interactionSource
            if (r2 == 0) goto L5e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r10)
            r0.L$0 = r9
            r0.L$1 = r11
            r0.label = r4
            java.lang.Object r10 = r2.emit(r6, r0)
            if (r10 != r1) goto L5e
            goto L78
        L5e:
            r9.dragInteraction = r5
        L60:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9 = r9.onDragStopped
            long r6 = androidx.compose.ui.unit.Velocity.Zero
            androidx.compose.ui.unit.Velocity r10 = new androidx.compose.ui.unit.Velocity
            r10.<init>(r6)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r9 = r9.invoke(r11, r10, r0)
            if (r9 != r1) goto L76
            goto L78
        L76:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.access$processDragCancel(androidx.compose.foundation.gestures.DraggableNode, kotlin.coroutines.Continuation, kotlinx.coroutines.CoroutineScope):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Type inference failed for: r11v4, types: [androidx.compose.foundation.interaction.Interaction, androidx.compose.foundation.interaction.DragInteraction$Start] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$processDragStart(androidx.compose.foundation.gestures.DraggableNode r8, kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStarted r10, kotlin.coroutines.Continuation r11) {
        /*
            r8.getClass()
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragStart$1
            if (r0 == 0) goto L16
            r0 = r11
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            androidx.compose.foundation.gestures.DraggableNode$processDragStart$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStart$1
            r0.<init>(r8, r11)
        L1b:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4f
            if (r2 == r5) goto L45
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.ResultKt.throwOnFailure(r11)
            goto Laf
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            androidx.compose.foundation.interaction.DragInteraction$Start r8 = r0.L$3
            androidx.compose.foundation.gestures.DragEvent$DragStarted r9 = r0.L$2
            kotlinx.coroutines.CoroutineScope r10 = r0.L$1
            androidx.compose.foundation.gestures.DraggableNode r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8d
        L45:
            androidx.compose.foundation.gestures.DragEvent$DragStarted r10 = r0.L$2
            kotlinx.coroutines.CoroutineScope r9 = r0.L$1
            androidx.compose.foundation.gestures.DraggableNode r8 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6e
        L4f:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = r8.dragInteraction
            if (r11 == 0) goto L6e
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L6e
            androidx.compose.foundation.interaction.DragInteraction$Cancel r6 = new androidx.compose.foundation.interaction.DragInteraction$Cancel
            r6.<init>(r11)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r5
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L6e
            goto Lb1
        L6e:
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = new androidx.compose.foundation.interaction.DragInteraction$Start
            r11.<init>()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L92
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r4
            java.lang.Object r2 = r2.emit(r11, r0)
            if (r2 != r1) goto L88
            goto Lb1
        L88:
            r2 = r8
            r8 = r11
            r7 = r10
            r10 = r9
            r9 = r7
        L8d:
            r11 = r8
            r8 = r2
            r7 = r10
            r10 = r9
            r9 = r7
        L92:
            r8.dragInteraction = r11
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.geometry.Offset, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8 = r8.onDragStarted
            long r10 = r10.startPoint
            androidx.compose.ui.geometry.Offset r2 = new androidx.compose.ui.geometry.Offset
            r2.<init>(r10)
            r10 = 0
            r0.L$0 = r10
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r10
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r9, r2, r0)
            if (r8 != r1) goto Laf
            goto Lb1
        Laf:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        Lb1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.access$processDragStart(androidx.compose.foundation.gestures.DraggableNode, kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStarted, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$processDragStop(androidx.compose.foundation.gestures.DraggableNode r8, kotlinx.coroutines.CoroutineScope r9, androidx.compose.foundation.gestures.DragEvent.DragStopped r10, kotlin.coroutines.Continuation r11) {
        /*
            r8.getClass()
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.DraggableNode$processDragStop$1
            if (r0 == 0) goto L16
            r0 = r11
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = (androidx.compose.foundation.gestures.DraggableNode$processDragStop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.label = r1
            goto L1b
        L16:
            androidx.compose.foundation.gestures.DraggableNode$processDragStop$1 r0 = new androidx.compose.foundation.gestures.DraggableNode$processDragStop$1
            r0.<init>(r8, r11)
        L1b:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7c
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            androidx.compose.foundation.gestures.DragEvent$DragStopped r8 = r0.L$2
            kotlinx.coroutines.CoroutineScope r9 = r0.L$1
            androidx.compose.foundation.gestures.DraggableNode r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            r7 = r10
            r10 = r8
            r8 = r7
            goto L62
        L43:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.interaction.DragInteraction$Start r11 = r8.dragInteraction
            if (r11 == 0) goto L64
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8.interactionSource
            if (r2 == 0) goto L62
            androidx.compose.foundation.interaction.DragInteraction$Stop r6 = new androidx.compose.foundation.interaction.DragInteraction$Stop
            r6.<init>(r11)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            java.lang.Object r11 = r2.emit(r6, r0)
            if (r11 != r1) goto L62
            goto L7e
        L62:
            r8.dragInteraction = r5
        L64:
            kotlin.jvm.functions.Function3<? super kotlinx.coroutines.CoroutineScope, ? super androidx.compose.ui.unit.Velocity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r8 = r8.onDragStopped
            long r10 = r10.velocity
            androidx.compose.ui.unit.Velocity r2 = new androidx.compose.ui.unit.Velocity
            r2.<init>(r10)
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r9, r2, r0)
            if (r8 != r1) goto L7c
            goto L7e
        L7c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableNode.access$processDragStop(androidx.compose.foundation.gestures.DraggableNode, kotlinx.coroutines.CoroutineScope, androidx.compose.foundation.gestures.DragEvent$DragStopped, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void disposeInteractionSource() {
        DragInteraction$Start dragInteraction$Start = this.dragInteraction;
        if (dragInteraction$Start != null) {
            MutableInteractionSource mutableInteractionSource = this.interactionSource;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(new DragInteraction$Cancel(dragInteraction$Start));
            }
            this.dragInteraction = null;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractionSource();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public final void mo13onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long j) {
        Intrinsics.checkNotNullParameter(pass, "pass");
        this.pointerInputNode.mo13onPointerEventH0pRuoY(pointerEvent, pass, j);
    }
}
