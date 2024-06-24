package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$connect$1", f = "RxJavaTwoGattConnection.kt", l = {49}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$connect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Throwable, Unit> $disconnectCallback;
    int label;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RxJavaTwoGattConnection$connect$1(RxJavaTwoGattConnection rxJavaTwoGattConnection, Function1<? super Throwable, Unit> function1, Continuation<? super RxJavaTwoGattConnection$connect$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattConnection;
        this.$disconnectCallback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$connect$1(this.this$0, this.$disconnectCallback, continuation);
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
            int r6 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(30, DurationUnit.MINUTES);
            this.label = 1;
            if (DelayKt.m1695delayVtjQ1oo(duration, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        this.this$0.clean();
        this.$disconnectCallback.invoke(new RuntimeException("Connection attempt timed out after 30min"));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattConnection$connect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
