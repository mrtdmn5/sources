package com.animaconnected.secondo.app;

import com.animaconnected.secondo.utils.debugging.DogfoodLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeviceService.kt */
@DebugMetadata(c = "com.animaconnected.secondo.app.DeviceService$onLowMemory$2", f = "DeviceService.kt", l = {329}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DeviceService$onLowMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DogfoodLogger $logger;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceService$onLowMemory$2(DogfoodLogger dogfoodLogger, Continuation<? super DeviceService$onLowMemory$2> continuation) {
        super(2, continuation);
        this.$logger = dogfoodLogger;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceService$onLowMemory$2(this.$logger, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            DogfoodLogger dogfoodLogger = this.$logger;
            this.label = 1;
            if (dogfoodLogger.savePendingDataToFile(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceService$onLowMemory$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
