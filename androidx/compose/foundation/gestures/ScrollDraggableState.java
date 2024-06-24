package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
/* loaded from: classes.dex */
public final class ScrollDraggableState implements DraggableState, DragScope {
    public ScrollScope latestScrollScope = ScrollableKt.NoOpScrollScope;
    public final State<ScrollingLogic> scrollLogic;

    public ScrollDraggableState(MutableState mutableState) {
        this.scrollLogic = mutableState;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollLogic.getValue().scrollableState.scroll(mutatePriority, new ScrollDraggableState$drag$2(this, function2, null), continuation);
        if (scroll == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragScope
    public final void dragBy(float f) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m54dispatchScroll3eAAhYA(this.latestScrollScope, value.m58toOffsettuRUvjQ(f), 1);
    }
}
