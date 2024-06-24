package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import com.animaconnected.bluetooth.util.Callback;
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
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$write$1", f = "RxJavaTwoGattDevice.kt", l = {331}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$write$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BluetoothGattCharacteristic $btgc;
    final /* synthetic */ Callback<Void> $callback;
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$write$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, Callback<Void> callback, Continuation<? super RxJavaTwoGattDevice$write$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
        this.$btgc = bluetoothGattCharacteristic;
        this.$data = bArr;
        this.$callback = callback;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattDevice$write$1(this.this$0, this.$btgc, this.$data, this.$callback, continuation);
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
                    if (rxJavaTwoGattConnection.write(bluetoothGattCharacteristic, bArr, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    throw new IOException("RxJavaTwoGattConnection is null");
                }
            }
            Callback<Void> callback = this.$callback;
            if (callback != null) {
                callback.onSuccess(null);
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            Callback<Void> callback2 = this.$callback;
            if (callback2 != null) {
                callback2.onError(e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$write$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
