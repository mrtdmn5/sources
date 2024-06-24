package com.animaconnected.watch;

import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.WatchIO;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$setCalibrationMode$1", f = "WatchProvider.kt", l = {507}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$setCalibrationMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ WatchIO $io;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$setCalibrationMode$1(WatchIO watchIO, boolean z, WatchProvider watchProvider, Continuation<? super WatchProvider$setCalibrationMode$1> continuation) {
        super(2, continuation);
        this.$io = watchIO;
        this.$enabled = z;
        this.this$0 = watchProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchProvider$setCalibrationMode$1 watchProvider$setCalibrationMode$1 = new WatchProvider$setCalibrationMode$1(this.$io, this.$enabled, this.this$0, continuation);
        watchProvider$setCalibrationMode$1.L$0 = obj;
        return watchProvider$setCalibrationMode$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Exception e;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e2) {
                    e = e2;
                    LogKt.debug$default((Object) coroutineScope, Model$$ExternalSyntheticOutline0.m("Failed to change calibration. Error:  ", e), (String) null, (Throwable) null, false, 14, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                WatchIO watchIO = this.$io;
                boolean z = this.$enabled;
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (watchIO.writeRecalibrate(z, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope = coroutineScope2;
            } catch (Exception e3) {
                coroutineScope = coroutineScope2;
                e = e3;
                LogKt.debug$default((Object) coroutineScope, Model$$ExternalSyntheticOutline0.m("Failed to change calibration. Error:  ", e), (String) null, (Throwable) null, false, 14, (Object) null);
                return Unit.INSTANCE;
            }
        }
        if (!this.$enabled) {
            this.this$0.setDeviceTime();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchProvider$setCalibrationMode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
