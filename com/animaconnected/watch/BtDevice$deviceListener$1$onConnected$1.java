package com.animaconnected.watch;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BtDevice.kt */
@DebugMetadata(c = "com.animaconnected.watch.BtDevice$deviceListener$1$onConnected$1", f = "BtDevice.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BtDevice$deviceListener$1$onConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BtDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BtDevice$deviceListener$1$onConnected$1(BtDevice btDevice, Continuation<? super BtDevice$deviceListener$1$onConnected$1> continuation) {
        super(2, continuation);
        this.this$0 = btDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BtDevice$deviceListener$1$onConnected$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object establishConnection;
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
            BtDevice btDevice = this.this$0;
            this.label = 1;
            establishConnection = btDevice.establishConnection(true, this);
            if (establishConnection == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BtDevice$deviceListener$1$onConnected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
