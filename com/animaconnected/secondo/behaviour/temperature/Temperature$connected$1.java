package com.animaconnected.secondo.behaviour.temperature;

import com.animaconnected.watch.HybridWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Temperature.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.Temperature$connected$1", f = "Temperature.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Temperature$connected$1 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ HybridWatch $hybrid;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Temperature$connected$1(HybridWatch hybridWatch, Continuation<? super Temperature$connected$1> continuation) {
        super(2, continuation);
        this.$hybrid = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Temperature$connected$1(this.$hybrid, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Float f, Continuation<? super Unit> continuation) {
        return ((Temperature$connected$1) create(f, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$hybrid.updateRemoteComplication();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
