package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.RxBleConnection;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$write$2", f = "RxJavaTwoGattConnection.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$write$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ BluetoothGattCharacteristic $btgc;
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$write$2(RxJavaTwoGattConnection rxJavaTwoGattConnection, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, Continuation<? super RxJavaTwoGattConnection$write$2> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattConnection;
        this.$btgc = bluetoothGattCharacteristic;
        this.$data = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$write$2(this.this$0, this.$btgc, this.$data, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxBleConnection rxBleConnection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            rxBleConnection = this.this$0.connection;
            if (rxBleConnection != null) {
                return rxBleConnection.writeCharacteristic(this.$btgc, this.$data).blockingGet();
            }
            throw new IOException("RxBleConnection is null");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((RxJavaTwoGattConnection$write$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
