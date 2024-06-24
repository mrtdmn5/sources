package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import java.util.List;
import kotlin.Pair;
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
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1", f = "WatchFitnessProvider.kt", l = {128}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $tsEnd;
    final /* synthetic */ long $tsStart;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1(WatchFitnessProvider watchFitnessProvider, long j, long j2, Continuation<? super WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$tsStart = j;
        this.$tsEnd = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1 watchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1 = new WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1(this.this$0, this.$tsStart, this.$tsEnd, continuation);
        watchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1.L$0 = obj;
        return watchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Watch watch;
        Watch watch2;
        FitnessSyncWatch fitnessSync$watch_release;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r2 = this.label;
        if (r2 != 0) {
            if (r2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FitnessQueries db = this.this$0.getDb();
            long j = this.$tsStart;
            long j2 = this.$tsEnd;
            watch = this.this$0.watch;
            if (watch != null) {
                List<LocationEntry> executeAsList = FitnessDatabaseExtensionsKt.m1232getLocationDataEntriesOPDSpw(db, j, j2, watch.m1046getHistoryDeviceIdV9ZILtA()).executeAsList();
                final int r13 = (int) FitnessDataUtilsKt.totalDistance(executeAsList);
                Pair<Double, Double> accuracyStandardDerivation = LocationUtilsKt.accuracyStandardDerivation(executeAsList);
                final double doubleValue = accuracyStandardDerivation.first.doubleValue();
                final double doubleValue2 = accuracyStandardDerivation.second.doubleValue();
                LogKt.debug$default((Object) coroutineScope, "SpeedCalib", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "write Stop: distance: " + r13 + ", mean: " + doubleValue + ", std: " + doubleValue2;
                    }
                }, 6, (Object) null);
                watch2 = this.this$0.watch;
                if (watch2 != null && (fitnessSync$watch_release = watch2.getFitnessSync$watch_release()) != null) {
                    SpeedCalibrationStop speedCalibrationStop = new SpeedCalibrationStop(r13, doubleValue, doubleValue2);
                    this.label = 1;
                    if (fitnessSync$watch_release.writeSpeedCalibration(speedCalibrationStop, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
