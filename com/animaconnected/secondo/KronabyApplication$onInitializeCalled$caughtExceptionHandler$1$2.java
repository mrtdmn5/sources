package com.animaconnected.secondo;

import com.animaconnected.logger.LibLogger;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.utils.debugging.DogfoodLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KronabyApplication.kt */
@DebugMetadata(c = "com.animaconnected.secondo.KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2", f = "KronabyApplication.kt", l = {72}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2(Continuation<? super KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DogfoodLogger dogfoodLogger;
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
            LibLogger currentLogger = LogKt.getCurrentLogger();
            if (currentLogger instanceof DogfoodLogger) {
                dogfoodLogger = (DogfoodLogger) currentLogger;
            } else {
                dogfoodLogger = null;
            }
            if (dogfoodLogger == null) {
                return null;
            }
            this.label = 1;
            if (dogfoodLogger.savePendingDataToFile(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KronabyApplication$onInitializeCalled$caughtExceptionHandler$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
