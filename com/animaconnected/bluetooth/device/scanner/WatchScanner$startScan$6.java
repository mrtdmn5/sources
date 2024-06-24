package com.animaconnected.bluetooth.device.scanner;

import com.animaconnected.bluetooth.device.scanner.WatchScanner;
import com.animaconnected.logger.LogKt;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* compiled from: WatchScanner.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$6", f = "WatchScanner.kt", l = {78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WatchScanner$startScan$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchScanner$startScan$6(WatchScanner watchScanner, Continuation<? super WatchScanner$startScan$6> continuation) {
        super(2, continuation);
        this.this$0 = watchScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchScanner$startScan$6 watchScanner$startScan$6 = new WatchScanner$startScan$6(this.this$0, continuation);
        watchScanner$startScan$6.L$0 = obj;
        return watchScanner$startScan$6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j;
        CoroutineScope coroutineScope;
        Job job;
        final ScannedDevice selectDevice;
        WatchScanner.WatchScannerListener watchScannerListener;
        String str;
        String str2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            j = this.this$0.scanTimeout;
            this.L$0 = coroutineScope3;
            this.label = 1;
            if (DelayKt.m1695delayVtjQ1oo(j, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
            coroutineScope = coroutineScope3;
        }
        job = this.this$0.scannerJob;
        if (job != null) {
            job.cancel(null);
        }
        selectDevice = this.this$0.selectDevice();
        watchScannerListener = this.this$0.listener;
        if (watchScannerListener != null) {
            str2 = this.this$0.tag;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTag$p(...)");
            LogKt.debug$default((Object) coroutineScope, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$6.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Scan completed. Return from buffer: " + ScannedDevice.this;
                }
            }, 6, (Object) null);
            this.this$0.onDeviceFound(selectDevice);
        } else {
            str = this.this$0.tag;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTag$p(...)");
            final WatchScanner watchScanner = this.this$0;
            LogKt.debug$default((Object) coroutineScope, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$6.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    Set set;
                    StringBuilder sb = new StringBuilder("Scan completed. ");
                    set = WatchScanner.this.deviceBuffer;
                    sb.append(set.size());
                    sb.append(" devices in buffer for next scan");
                    return sb.toString();
                }
            }, 6, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchScanner$startScan$6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
