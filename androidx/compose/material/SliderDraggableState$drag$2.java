package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.MutatorMutex$mutateWith$2;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Slider.kt */
@DebugMetadata(c = "androidx.compose.material.SliderDraggableState$drag$2", f = "Slider.kt", l = {1183}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SliderDraggableState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    public final /* synthetic */ MutatePriority $dragPriority;
    public int label;
    public final /* synthetic */ SliderDraggableState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SliderDraggableState$drag$2(SliderDraggableState sliderDraggableState, MutatePriority mutatePriority, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super SliderDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = sliderDraggableState;
        this.$dragPriority = mutatePriority;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SliderDraggableState$drag$2(this.this$0, this.$dragPriority, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SliderDraggableState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        SliderDraggableState sliderDraggableState = this.this$0;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sliderDraggableState.isDragging$delegate.setValue(Boolean.TRUE);
            SliderDraggableState$dragScope$1 sliderDraggableState$dragScope$1 = sliderDraggableState.dragScope;
            this.label = 1;
            MutatePriority mutatePriority = this.$dragPriority;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.$block;
            MutatorMutex mutatorMutex = sliderDraggableState.scrollMutex;
            mutatorMutex.getClass();
            if (CoroutineScopeKt.coroutineScope(new MutatorMutex$mutateWith$2(mutatePriority, mutatorMutex, function2, sliderDraggableState$dragScope$1, null), this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        sliderDraggableState.isDragging$delegate.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }
}
