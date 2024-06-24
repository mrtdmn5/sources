package com.animaconnected.bluetooth.gatt.rxtwo;

import com.animaconnected.logger.LogKt;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import no.nordicsemi.android.dfu.DfuServiceInitiator;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$connectionListener$1$onChanged$1", f = "RxJavaTwoGattDevice.kt", l = {104}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$connectionListener$1$onChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$connectionListener$1$onChanged$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, Continuation<? super RxJavaTwoGattDevice$connectionListener$1$onChanged$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxJavaTwoGattDevice$connectionListener$1$onChanged$1 rxJavaTwoGattDevice$connectionListener$1$onChanged$1 = new RxJavaTwoGattDevice$connectionListener$1$onChanged$1(this.this$0, continuation);
        rxJavaTwoGattDevice$connectionListener$1$onChanged$1.L$0 = obj;
        return rxJavaTwoGattDevice$connectionListener$1$onChanged$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException unused) {
                    coroutineScope = coroutineScope2;
                    LogKt.debug$default((Object) coroutineScope, "BT delay canceled", this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            try {
                LogKt.debug$default((Object) coroutineScope3, "BT enabled. Wait 5sec", this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
                this.L$0 = coroutineScope3;
                this.label = 1;
                if (DelayKt.delay(DfuServiceInitiator.DEFAULT_SCAN_TIMEOUT, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                coroutineScope2 = coroutineScope3;
            } catch (CancellationException unused2) {
                coroutineScope = coroutineScope3;
                LogKt.debug$default((Object) coroutineScope, "BT delay canceled", this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
                return Unit.INSTANCE;
            }
        }
        LogKt.debug$default((Object) coroutineScope2, "BT enabled. Wait is over. onDisconnect()", this.this$0.getTAG(), (Throwable) null, true, 4, (Object) null);
        this.this$0.passiveConnect = true;
        this.this$0.getOnDisconnect().invoke(new RuntimeException("onDisconnect after BT enabled"));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$connectionListener$1$onChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
