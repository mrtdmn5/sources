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
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$read$2", f = "RxJavaTwoGattConnection.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$read$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ BluetoothGattCharacteristic $btgc;
    int label;
    final /* synthetic */ RxJavaTwoGattConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$read$2(RxJavaTwoGattConnection rxJavaTwoGattConnection, BluetoothGattCharacteristic bluetoothGattCharacteristic, Continuation<? super RxJavaTwoGattConnection$read$2> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattConnection;
        this.$btgc = bluetoothGattCharacteristic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$read$2(this.this$0, this.$btgc, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        RxBleConnection rxBleConnection;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            rxBleConnection = this.this$0.connection;
            if (rxBleConnection != null) {
                return rxBleConnection.readCharacteristic(this.$btgc).blockingGet();
            }
            throw new IOException("RxBleConnection is null");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((RxJavaTwoGattConnection$read$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
