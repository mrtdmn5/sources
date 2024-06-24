package com.polidea.rxandroidble2.internal;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.operations.Operation;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.internal.operators.observable.ObservableCreate;

/* loaded from: classes3.dex */
public abstract class QueueOperation<T> implements Operation<T> {
    @Override // java.lang.Comparable
    public final int compareTo(Operation<?> operation) {
        operation.definedPriority().getClass();
        definedPriority().getClass();
        return 0;
    }

    @Override // com.polidea.rxandroidble2.internal.operations.Operation
    public Priority definedPriority() {
        return Priority.NORMAL;
    }

    public abstract void protectedRun(ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) throws Throwable;

    public abstract BleException provideException(DeadObjectException deadObjectException);

    @Override // com.polidea.rxandroidble2.internal.operations.Operation
    public final ObservableCreate run(final QueueSemaphore queueSemaphore) {
        return new ObservableCreate(new ObservableOnSubscribe<Object>() { // from class: com.polidea.rxandroidble2.internal.QueueOperation.1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableCreate.CreateEmitter createEmitter) {
                QueueOperation queueOperation = QueueOperation.this;
                try {
                    queueOperation.protectedRun(createEmitter, queueSemaphore);
                } catch (DeadObjectException e) {
                    createEmitter.tryOnError(queueOperation.provideException(e));
                    RxBleLog.throwShade(6, e, "QueueOperation terminated with a DeadObjectException", new Object[0]);
                } catch (Throwable th) {
                    createEmitter.tryOnError(th);
                    RxBleLog.throwShade(6, th, "QueueOperation terminated with an unexpected exception", new Object[0]);
                }
            }
        });
    }
}
