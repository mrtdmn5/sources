package com.animaconnected.watch.fitness;

import com.animaconnected.watch.Watch;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1", f = "WatchFitnessProvider.kt", l = {107}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Distance $distance;
    final /* synthetic */ GpsQuality $gpsQuality;
    final /* synthetic */ Float $speedMeterPerSecond;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1(WatchFitnessProvider watchFitnessProvider, GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$gpsQuality = gpsQuality;
        this.$distance = distance;
        this.$speedMeterPerSecond = f;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1(this.this$0, this.$gpsQuality, this.$distance, this.$speedMeterPerSecond, continuation);
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
            watch = this.this$0.watch;
            if (watch != null && (fitnessSync$watch_release = watch.getFitnessSync$watch_release()) != null) {
                GpsQuality gpsQuality = this.$gpsQuality;
                Distance distance = this.$distance;
                Float f = this.$speedMeterPerSecond;
                this.label = 1;
                if (fitnessSync$watch_release.writeSessionDataFeed(gpsQuality, distance, f, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
