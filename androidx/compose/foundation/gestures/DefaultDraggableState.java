package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material.SwipeableState$draggableState$1;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Draggable.kt */
/* loaded from: classes.dex */
public final class DefaultDraggableState implements DraggableState {
    public final Function1<Float, Unit> onDelta;
    public final DefaultDraggableState$dragScope$1 dragScope = new DragScope() { // from class: androidx.compose.foundation.gestures.DefaultDraggableState$dragScope$1
        @Override // androidx.compose.foundation.gestures.DragScope
        public final void dragBy(float f) {
            DefaultDraggableState.this.onDelta.invoke(Float.valueOf(f));
        }
    };
    public final MutatorMutex scrollMutex = new MutatorMutex();

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.foundation.gestures.DefaultDraggableState$dragScope$1] */
    public DefaultDraggableState(SwipeableState$draggableState$1 swipeableState$draggableState$1) {
        this.onDelta = swipeableState$draggableState$1;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new DefaultDraggableState$drag$2(this, mutatePriority, function2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
