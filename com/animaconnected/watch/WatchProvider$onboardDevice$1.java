package com.animaconnected.watch;

import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$onboardDevice$1", f = "WatchProvider.kt", l = {314}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$onboardDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HybridDevice $scannedDevice;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$onboardDevice$1(WatchProvider watchProvider, HybridDevice hybridDevice, Continuation<? super WatchProvider$onboardDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
        this.$scannedDevice = hybridDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchProvider$onboardDevice$1(this.this$0, this.$scannedDevice, continuation);
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
            WatchManager watchManager = this.this$0.getWatchManager();
            String address = this.$scannedDevice.getAddress();
            DeviceType deviceType = this.$scannedDevice.getDeviceType();
            FirmwareVariant firmwareVariant = this.$scannedDevice.getFirmwareVariant();
            this.label = 1;
            if (watchManager.addWatch(address, deviceType, firmwareVariant, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchProvider$onboardDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
