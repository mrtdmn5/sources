package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: AnchoredDraggable.kt */
/* loaded from: classes.dex */
public final class AnchoredDraggableState$draggableState$1 implements DraggableState {
    public final AnchoredDraggableState$draggableState$1$dragScope$1 dragScope;
    public final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.material.AnchoredDraggableState$draggableState$1$dragScope$1] */
    public AnchoredDraggableState$draggableState$1(final AnchoredDraggableState<T> anchoredDraggableState) {
        this.this$0 = anchoredDraggableState;
        this.dragScope = new DragScope() { // from class: androidx.compose.material.AnchoredDraggableState$draggableState$1$dragScope$1
            @Override // androidx.compose.foundation.gestures.DragScope
            public final void dragBy(float f) {
                AnchoredDraggableState<T> anchoredDraggableState2 = anchoredDraggableState;
                anchoredDraggableState2.anchoredDragScope.dragTo(anchoredDraggableState2.newOffsetForDelta$material_release(f), 0.0f);
            }
        };
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AnchoredDraggableState$draggableState$1$drag$2 anchoredDraggableState$draggableState$1$drag$2 = new AnchoredDraggableState$draggableState$1$drag$2(this, function2, null);
        AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
        anchoredDraggableState.getClass();
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new AnchoredDraggableState$doAnchoredDrag$2(null, anchoredDraggableState, mutatePriority, anchoredDraggableState$draggableState$1$drag$2, null), continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (coroutineScope != coroutineSingletons) {
            coroutineScope = Unit.INSTANCE;
        }
        if (coroutineScope != coroutineSingletons) {
            coroutineScope = Unit.INSTANCE;
        }
        if (coroutineScope == coroutineSingletons) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
