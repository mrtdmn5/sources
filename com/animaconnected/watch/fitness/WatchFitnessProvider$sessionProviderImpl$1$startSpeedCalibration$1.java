package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1", f = "WatchFitnessProvider.kt", l = {114}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1(WatchFitnessProvider watchFitnessProvider, Continuation<? super WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1 watchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1 = new WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1(this.this$0, continuation);
        watchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1.L$0 = obj;
        return watchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Watch watch;
        FitnessSyncWatch fitnessSync$watch_release;
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
            LogKt.debug$default(this.L$0, "SpeedCalib", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1.1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "write Start";
                }
            }, 6, (Object) null);
            watch = this.this$0.watch;
            if (watch != null && (fitnessSync$watch_release = watch.getFitnessSync$watch_release()) != null) {
                SpeedCalibrationStart speedCalibrationStart = SpeedCalibrationStart.INSTANCE;
                this.label = 1;
                if (fitnessSync$watch_release.writeSpeedCalibration(speedCalibrationStart, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
