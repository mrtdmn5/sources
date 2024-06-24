package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$fakeConnect$4", f = "RxJavaTwoGattDevice.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$fakeConnect$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RxJavaTwoGattConnection $fakeDevice;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$fakeConnect$4(RxJavaTwoGattConnection rxJavaTwoGattConnection, Continuation<? super RxJavaTwoGattDevice$fakeConnect$4> continuation) {
        super(2, continuation);
        this.$fakeDevice = rxJavaTwoGattConnection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattDevice$fakeConnect$4(this.$fakeDevice, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$fakeDevice.disconnect();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$fakeConnect$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
