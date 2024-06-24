package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import com.animaconnected.bluetooth.gatt.GattAuthFailError;
import com.animaconnected.bluetooth.gatt.ReadCallback;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$read$1", f = "RxJavaTwoGattDevice.kt", l = {309}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$read$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothGattCharacteristic $btgc;
    final /* synthetic */ ReadCallback $callback;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$read$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, ReadCallback readCallback, Continuation<? super RxJavaTwoGattDevice$read$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
        this.$btgc = bluetoothGattCharacteristic;
        this.$callback = readCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattDevice$read$1(this.this$0, this.$btgc, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int r1;
        RxJavaTwoGattConnection rxJavaTwoGattConnection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r12 = this.label;
        try {
            if (r12 != 0) {
                if (r12 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                rxJavaTwoGattConnection = this.this$0.connection;
                if (rxJavaTwoGattConnection != null) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$btgc;
                    this.label = 1;
                    obj = rxJavaTwoGattConnection.read(bluetoothGattCharacteristic, this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    throw new IOException("RxJavaTwoGattConnection is null");
                }
            }
            this.$callback.onSuccess((byte[]) obj);
            return Unit.INSTANCE;
        } catch (Exception e) {
            if (e instanceof BleGattCharacteristicException) {
                r1 = this.this$0.gattAuthFail;
                if (((BleGattCharacteristicException) e).status == r1) {
                    this.$callback.onError(new GattAuthFailError(e));
                    return Unit.INSTANCE;
                }
            }
            this.$callback.onError(e);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$read$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
