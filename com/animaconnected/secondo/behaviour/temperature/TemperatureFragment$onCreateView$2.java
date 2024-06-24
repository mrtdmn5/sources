package com.animaconnected.secondo.behaviour.temperature;

import com.animaconnected.watch.provider.weather.TemperatureState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: TemperatureFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.TemperatureFragment$onCreateView$2", f = "TemperatureFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TemperatureFragment$onCreateView$2 extends SuspendLambda implements Function2<TemperatureState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TemperatureFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureFragment$onCreateView$2(TemperatureFragment temperatureFragment, Continuation<? super TemperatureFragment$onCreateView$2> continuation) {
        super(2, continuation);
        this.this$0 = temperatureFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TemperatureFragment$onCreateView$2 temperatureFragment$onCreateView$2 = new TemperatureFragment$onCreateView$2(this.this$0, continuation);
        temperatureFragment$onCreateView$2.L$0 = obj;
        return temperatureFragment$onCreateView$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(TemperatureState temperatureState, Continuation<? super Unit> continuation) {
        return ((TemperatureFragment$onCreateView$2) create(temperatureState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateViews((TemperatureState) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
