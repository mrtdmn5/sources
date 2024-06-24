package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import com.animaconnected.bluetooth.gatt.ReadCallback;
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
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$writeRead$1", f = "RxJavaTwoGattDevice.kt", l = {280}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$writeRead$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothGattCharacteristic $btgc;
    final /* synthetic */ ReadCallback $callback;
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$writeRead$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, ReadCallback readCallback, Continuation<? super RxJavaTwoGattDevice$writeRead$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
        this.$btgc = bluetoothGattCharacteristic;
        this.$data = bArr;
        this.$callback = readCallback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattDevice$writeRead$1(this.this$0, this.$btgc, this.$data, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxJavaTwoGattConnection rxJavaTwoGattConnection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                rxJavaTwoGattConnection = this.this$0.connection;
                if (rxJavaTwoGattConnection != null) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$btgc;
                    byte[] bArr = this.$data;
                    this.label = 1;
                    obj = rxJavaTwoGattConnection.writeRead(bluetoothGattCharacteristic, bArr, this);
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
            this.$callback.onError(e);
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$writeRead$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
