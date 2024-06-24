package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattCharacteristic;
import com.animaconnected.bluetooth.util.Callback;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$setNotification$1", f = "RxJavaTwoGattDevice.kt", l = {366}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$setNotification$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Callback<Void> $callback;
    final /* synthetic */ UUID $characteristic;
    final /* synthetic */ byte[] $descriptorType;
    final /* synthetic */ UUID $service;
    final /* synthetic */ BluetoothGattCharacteristic $uuid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$setNotification$1(BluetoothGattCharacteristic bluetoothGattCharacteristic, RxJavaTwoGattDevice rxJavaTwoGattDevice, byte[] bArr, Callback<Void> callback, UUID r5, UUID r6, Continuation<? super RxJavaTwoGattDevice$setNotification$1> continuation) {
        super(2, continuation);
        this.$uuid = bluetoothGattCharacteristic;
        this.this$0 = rxJavaTwoGattDevice;
        this.$descriptorType = bArr;
        this.$callback = callback;
        this.$service = r5;
        this.$characteristic = r6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RxJavaTwoGattDevice$setNotification$1 rxJavaTwoGattDevice$setNotification$1 = new RxJavaTwoGattDevice$setNotification$1(this.$uuid, this.this$0, this.$descriptorType, this.$callback, this.$service, this.$characteristic, continuation);
        rxJavaTwoGattDevice$setNotification$1.L$0 = obj;
        return rxJavaTwoGattDevice$setNotification$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 != r2) goto Ld
            kotlin.ResultKt.throwOnFailure(r11)
            goto L63
        Ld:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L15:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Register notification: "
            r1.<init>(r3)
            android.bluetooth.BluetoothGattCharacteristic r3 = r10.$uuid
            java.util.UUID r3 = r3.getUuid()
            r1.append(r3)
            r3 = 125(0x7d, float:1.75E-43)
            r1.append(r3)
            java.lang.String r4 = r1.toString()
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r1 = r10.this$0
            java.lang.String r5 = r1.getTAG()
            r6 = 0
            r7 = 1
            r8 = 4
            r9 = 0
            r3 = r11
            com.animaconnected.logger.LogKt.debug$default(r3, r4, r5, r6, r7, r8, r9)
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r1 = r10.this$0
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection r1 = com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice.access$getConnection$p(r1)
            if (r1 == 0) goto L6a
            android.bluetooth.BluetoothGattCharacteristic r3 = r10.$uuid
            byte[] r4 = r10.$descriptorType
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$setNotification$1$success$1 r5 = new com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$setNotification$1$success$1
            com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice r6 = r10.this$0
            java.util.UUID r7 = r10.$service
            java.util.UUID r8 = r10.$characteristic
            r5.<init>()
            r10.label = r2
            java.lang.Object r11 = r1.setNotification(r3, r4, r5, r10)
            if (r11 != r0) goto L63
            return r0
        L63:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            goto L6b
        L6a:
            r11 = 0
        L6b:
            if (r11 == 0) goto L74
            com.animaconnected.bluetooth.util.Callback<java.lang.Void> r11 = r10.$callback
            r0 = 0
            r11.onSuccess(r0)
            goto L80
        L74:
            com.animaconnected.bluetooth.util.Callback<java.lang.Void> r11 = r10.$callback
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Setting notification failed"
            r0.<init>(r1)
            r11.onError(r0)
        L80:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$setNotification$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RxJavaTwoGattDevice$setNotification$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
