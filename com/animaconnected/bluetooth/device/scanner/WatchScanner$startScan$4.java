package com.animaconnected.bluetooth.device.scanner;

import com.animaconnected.logger.LogKt;
import java.util.Iterator;
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

/* compiled from: WatchScanner.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$4", f = "WatchScanner.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WatchScanner$startScan$4 extends SuspendLambda implements Function2<ScannedDevice, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WatchScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchScanner$startScan$4(WatchScanner watchScanner, Continuation<? super WatchScanner$startScan$4> continuation) {
        super(2, continuation);
        this.this$0 = watchScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchScanner$startScan$4 watchScanner$startScan$4 = new WatchScanner$startScan$4(this.this$0, continuation);
        watchScanner$startScan$4.L$0 = obj;
        return watchScanner$startScan$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScannedDevice scannedDevice, Continuation<? super Unit> continuation) {
        return ((WatchScanner$startScan$4) create(scannedDevice, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Function0 function0;
        Object obj2;
        String str;
        Set set;
        String str2;
        String str3;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final ScannedDevice scannedDevice = (ScannedDevice) this.L$0;
            z = this.this$0.allowSmarTime;
            if (z || !(scannedDevice instanceof SmarTimeDevice)) {
                function0 = this.this$0.onboardedDevices;
                Iterator it = ((Iterable) function0.invoke()).iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((HybridDevice) obj2).getAddress(), scannedDevice.getAddress())) {
                            break;
                        }
                    } else {
                        obj2 = null;
                        break;
                    }
                }
                if (obj2 != null) {
                    WatchScanner watchScanner = this.this$0;
                    str3 = watchScanner.tag;
                    Intrinsics.checkNotNullExpressionValue(str3, "access$getTag$p(...)");
                    LogKt.debug$default((Object) watchScanner, str3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$4.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Already onboarded: " + ScannedDevice.this.getAddress();
                        }
                    }, 6, (Object) null);
                    return Unit.INSTANCE;
                }
                if (!this.this$0.getOneDeviceFound()) {
                    WatchScanner watchScanner2 = this.this$0;
                    str2 = watchScanner2.tag;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTag$p(...)");
                    LogKt.debug$default((Object) watchScanner2, str2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$4.3
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "First device found. Returning: " + ScannedDevice.this;
                        }
                    }, 6, (Object) null);
                    this.this$0.onDeviceFound(scannedDevice);
                    this.this$0.oneDeviceFound = true;
                } else {
                    WatchScanner watchScanner3 = this.this$0;
                    str = watchScanner3.tag;
                    Intrinsics.checkNotNullExpressionValue(str, "access$getTag$p(...)");
                    LogKt.debug$default((Object) watchScanner3, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.bluetooth.device.scanner.WatchScanner$startScan$4.4
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Device found. Adding to buffer: " + ScannedDevice.this;
                        }
                    }, 6, (Object) null);
                    set = this.this$0.deviceBuffer;
                    set.add(scannedDevice);
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
