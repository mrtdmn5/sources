package com.animaconnected.bluetooth.device.scanner;

import com.animaconnected.logger.LogKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchScanner.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$5", f = "WatchScanner.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WatchScanner$startScan$5 extends SuspendLambda implements Function3<FlowCollector<? super ScannedDevice>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ WatchScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchScanner$startScan$5(WatchScanner watchScanner, Continuation<? super WatchScanner$startScan$5> continuation) {
        super(3, continuation);
        this.this$0 = watchScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            str = this.this$0.tag;
            Intrinsics.checkNotNull(str);
            LogKt.warn$default((Object) flowCollector, "Staring scan failed:", str, th, false, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super ScannedDevice> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        WatchScanner$startScan$5 watchScanner$startScan$5 = new WatchScanner$startScan$5(this.this$0, continuation);
        watchScanner$startScan$5.L$0 = flowCollector;
        watchScanner$startScan$5.L$1 = th;
        return watchScanner$startScan$5.invokeSuspend(Unit.INSTANCE);
    }
}
