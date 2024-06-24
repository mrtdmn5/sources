package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Draggable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$5", f = "Draggable.kt", l = {194}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DraggableKt$draggable$5 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> $onDragStopped;
    public final /* synthetic */ Orientation $orientation;
    public /* synthetic */ long J$0;
    public /* synthetic */ CoroutineScope L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DraggableKt$draggable$5(Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function3, Orientation orientation, Continuation<? super DraggableKt$draggable$5> continuation) {
        super(3, continuation);
        this.$onDragStopped = function3;
        this.$orientation = orientation;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, Velocity velocity, Continuation<? super Unit> continuation) {
        long j = velocity.packedValue;
        DraggableKt$draggable$5 draggableKt$draggable$5 = new DraggableKt$draggable$5(this.$onDragStopped, this.$orientation, continuation);
        draggableKt$draggable$5.L$0 = coroutineScope;
        draggableKt$draggable$5.J$0 = j;
        return draggableKt$draggable$5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        float m604getXimpl;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.L$0;
            long j = this.J$0;
            if (this.$orientation == Orientation.Vertical) {
                m604getXimpl = Velocity.m605getYimpl(j);
            } else {
                m604getXimpl = Velocity.m604getXimpl(j);
            }
            Float f = new Float(m604getXimpl);
            this.label = 1;
            if (this.$onDragStopped.invoke(coroutineScope, f, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
