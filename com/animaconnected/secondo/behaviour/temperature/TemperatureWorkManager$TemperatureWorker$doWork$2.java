package com.animaconnected.secondo.behaviour.temperature;

import androidx.work.ListenableWorker;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TemperatureWorkManager.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$2", f = "TemperatureWorkManager.kt", l = {65}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TemperatureWorkManager$TemperatureWorker$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
    int label;

    public TemperatureWorkManager$TemperatureWorker$doWork$2(Continuation<? super TemperatureWorkManager$TemperatureWorker$doWork$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemperatureWorkManager$TemperatureWorker$doWork$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        HistoricalWeatherProvider historicalWeatherProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                historicalWeatherProvider = TemperatureWorkManager.provider;
                this.label = 1;
                obj = historicalWeatherProvider.fetchTemperatureSuspending(this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
            z = ((Boolean) obj).booleanValue();
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return new ListenableWorker.Result.Success();
        }
        return new ListenableWorker.Result.Retry();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
        return ((TemperatureWorkManager$TemperatureWorker$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
