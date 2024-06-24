package com.animaconnected.secondo.behaviour.distress;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin$distressInterface$1$stopEmergency$1", f = "DistressPlugin.kt", l = {245}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressPlugin$distressInterface$1$stopEmergency$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DistressPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$distressInterface$1$stopEmergency$1(DistressPlugin distressPlugin, Continuation<? super DistressPlugin$distressInterface$1$stopEmergency$1> continuation) {
        super(2, continuation);
        this.this$0 = distressPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DistressPlugin$distressInterface$1$stopEmergency$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object stopDistress;
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
            DistressPlugin distressPlugin = this.this$0;
            this.label = 1;
            stopDistress = distressPlugin.stopDistress(this);
            if (stopDistress == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressPlugin$distressInterface$1$stopEmergency$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
