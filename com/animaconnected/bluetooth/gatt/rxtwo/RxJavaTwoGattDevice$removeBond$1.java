package com.animaconnected.bluetooth.gatt.rxtwo;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattDevice.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$removeBond$1", f = "RxJavaTwoGattDevice.kt", l = {505, 506, 506, 506}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattDevice$removeBond$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RxJavaTwoGattDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattDevice$removeBond$1(RxJavaTwoGattDevice rxJavaTwoGattDevice, Continuation<? super RxJavaTwoGattDevice$removeBond$1> continuation) {
        super(2, continuation);
        this.this$0 = rxJavaTwoGattDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattDevice$removeBond$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattDevice$removeBond$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RxJavaTwoGattDevice$removeBond$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
