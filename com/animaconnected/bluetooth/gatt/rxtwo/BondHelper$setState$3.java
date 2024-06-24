package com.animaconnected.bluetooth.gatt.rxtwo;

import android.content.BroadcastReceiver;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BondHelper.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.BondHelper$setState$3", f = "BondHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BondHelper$setState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref$ObjectRef<BroadcastReceiver> $receiver;
    int label;
    final /* synthetic */ BondHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BondHelper$setState$3(Ref$ObjectRef<BroadcastReceiver> ref$ObjectRef, BondHelper bondHelper, Continuation<? super BondHelper$setState$3> continuation) {
        super(2, continuation);
        this.$receiver = ref$ObjectRef;
        this.this$0 = bondHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BondHelper$setState$3(this.$receiver, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BroadcastReceiver broadcastReceiver = this.$receiver.element;
            if (broadcastReceiver != null) {
                this.this$0.getContext().unregisterReceiver(broadcastReceiver);
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BondHelper$setState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
