package com.animaconnected.bluetooth.gatt.rxtwo;

import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RxJavaTwoGattConnection.kt */
@DebugMetadata(c = "com.animaconnected.bluetooth.gatt.rxtwo.RxJavaTwoGattConnection$setNotification$2", f = "RxJavaTwoGattConnection.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RxJavaTwoGattConnection$setNotification$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ RxBleConnection $connection;
    final /* synthetic */ BluetoothGattDescriptor $descriptor;
    final /* synthetic */ byte[] $value;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxJavaTwoGattConnection$setNotification$2(RxBleConnection rxBleConnection, BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr, Continuation<? super RxJavaTwoGattConnection$setNotification$2> continuation) {
        super(2, continuation);
        this.$connection = rxBleConnection;
        this.$descriptor = bluetoothGattDescriptor;
        this.$value = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RxJavaTwoGattConnection$setNotification$2(this.$connection, this.$descriptor, this.$value, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ObservableIgnoreElementsCompletable writeDescriptor = this.$connection.writeDescriptor(this.$descriptor, this.$value);
            writeDescriptor.getClass();
            BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
            writeDescriptor.subscribe(blockingMultiObserver);
            boolean z = true;
            if (blockingMultiObserver.getCount() != 0) {
                try {
                    blockingMultiObserver.await();
                } catch (InterruptedException e) {
                    e = e;
                    blockingMultiObserver.cancelled = true;
                    Disposable disposable = blockingMultiObserver.upstream;
                    if (disposable != null) {
                        disposable.dispose();
                    }
                }
            }
            e = blockingMultiObserver.error;
            if (e != null) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((RxJavaTwoGattConnection$setNotification$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
