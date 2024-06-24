package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Slider.kt */
/* loaded from: classes.dex */
public final class SliderDraggableState implements DraggableState {
    public final Function1<Float, Unit> onDelta;
    public final ParcelableSnapshotMutableState isDragging$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
    public final SliderDraggableState$dragScope$1 dragScope = new DragScope() { // from class: androidx.compose.material.SliderDraggableState$dragScope$1
        @Override // androidx.compose.foundation.gestures.DragScope
        public final void dragBy(float f) {
            SliderDraggableState.this.onDelta.invoke(Float.valueOf(f));
        }
    };
    public final MutatorMutex scrollMutex = new MutatorMutex();

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.material.SliderDraggableState$dragScope$1] */
    public SliderDraggableState(SliderKt$Slider$3$draggableState$1$1 sliderKt$Slider$3$draggableState$1$1) {
        this.onDelta = sliderKt$Slider$3$draggableState$1$1;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public final Object drag(MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new SliderDraggableState$drag$2(this, mutatePriority, function2, null), continuation);
        if (coroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
