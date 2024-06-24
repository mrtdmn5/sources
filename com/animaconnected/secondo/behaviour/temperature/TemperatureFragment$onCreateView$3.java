package com.animaconnected.secondo.behaviour.temperature;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.provider.weather.TemperatureState;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: TemperatureFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.TemperatureFragment$onCreateView$3", f = "TemperatureFragment.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TemperatureFragment$onCreateView$3 extends SuspendLambda implements Function3<FlowCollector<? super TemperatureState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public TemperatureFragment$onCreateView$3(Continuation<? super TemperatureFragment$onCreateView$3> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LogKt.debug$default(this.L$0, "Something went wrong with collecting temperatureState", (String) null, (Throwable) null, false, 14, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super TemperatureState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        TemperatureFragment$onCreateView$3 temperatureFragment$onCreateView$3 = new TemperatureFragment$onCreateView$3(continuation);
        temperatureFragment$onCreateView$3.L$0 = flowCollector;
        return temperatureFragment$onCreateView$3.invokeSuspend(Unit.INSTANCE);
    }
}
