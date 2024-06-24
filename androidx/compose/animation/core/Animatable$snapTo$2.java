package androidx.compose.animation.core;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: Animatable.kt */
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class Animatable$snapTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    public final /* synthetic */ T $targetValue;
    public final /* synthetic */ Animatable<T, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Animatable$snapTo$2(Animatable<T, V> animatable, T t, Continuation<? super Animatable$snapTo$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$targetValue = t;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$snapTo$2(this.this$0, this.$targetValue, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((Animatable$snapTo$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        Animatable<T, V> animatable = this.this$0;
        AnimationState<T, V> animationState = animatable.internalState;
        animationState.velocityVector.reset$animation_core_release();
        animationState.lastFrameTimeNanos = Long.MIN_VALUE;
        animatable.isRunning$delegate.setValue(Boolean.FALSE);
        Object access$clampToBounds = Animatable.access$clampToBounds(animatable, this.$targetValue);
        animatable.internalState.value$delegate.setValue(access$clampToBounds);
        animatable.targetValue$delegate.setValue(access$clampToBounds);
        return Unit.INSTANCE;
    }
}
