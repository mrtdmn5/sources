package com.animaconnected.watch;

import com.animaconnected.info.DeviceType;
import com.animaconnected.info.EmulatorInfo;
import com.animaconnected.watch.device.DeviceConnectionListener;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EmulatorDevice.kt */
@DebugMetadata(c = "com.animaconnected.watch.EmulatorDevice$connect$1", f = "EmulatorDevice.kt", l = {28}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class EmulatorDevice$connect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EmulatorDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmulatorDevice$connect$1(EmulatorDevice emulatorDevice, Continuation<? super EmulatorDevice$connect$1> continuation) {
        super(2, continuation);
        this.this$0 = emulatorDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EmulatorDevice$connect$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DeviceConnectionListener deviceConnectionListener;
        DeviceConnectionListener deviceConnectionListener2;
        EmulatorInfo emulatorInfo;
        DeviceConnectionListener deviceConnectionListener3;
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
            deviceConnectionListener = this.this$0.connectionListener;
            deviceConnectionListener.onConnecting();
            this.this$0.connected = true;
            deviceConnectionListener2 = this.this$0.connectionListener;
            EmulatorDevice emulatorDevice = this.this$0;
            emulatorInfo = emulatorDevice.emulatorInfo;
            DeviceType deviceType = emulatorInfo.getDeviceType();
            this.label = 1;
            if (deviceConnectionListener2.onWatchConnecting(emulatorDevice, deviceType, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        deviceConnectionListener3 = this.this$0.connectionListener;
        deviceConnectionListener3.onConnected();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EmulatorDevice$connect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
