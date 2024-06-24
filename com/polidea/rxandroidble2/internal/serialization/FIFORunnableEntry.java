package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class FIFORunnableEntry<T> implements Comparable<FIFORunnableEntry> {
    public static final AtomicLong SEQUENCE = new AtomicLong(0);
    public final Operation<T> operation;
    public final ObservableEmitter<T> operationResultObserver;
    public final long seqNum = SEQUENCE.getAndIncrement();

    public FIFORunnableEntry(Operation operation, ObservableCreate.CreateEmitter createEmitter) {
        this.operation = operation;
        this.operationResultObserver = createEmitter;
    }

    @Override // java.lang.Comparable
    public final int compareTo(FIFORunnableEntry fIFORunnableEntry) {
        int r5;
        FIFORunnableEntry fIFORunnableEntry2 = fIFORunnableEntry;
        Operation<T> operation = fIFORunnableEntry2.operation;
        Operation<T> operation2 = this.operation;
        int compareTo = operation2.compareTo(operation);
        if (compareTo == 0 && fIFORunnableEntry2.operation != operation2) {
            if (this.seqNum < fIFORunnableEntry2.seqNum) {
                r5 = -1;
            } else {
                r5 = 1;
            }
            return r5;
        }
        return compareTo;
    }

    public final void run(final QueueSemaphore queueSemaphore, final Scheduler scheduler) {
        if (((ObservableCreate.CreateEmitter) this.operationResultObserver).isDisposed()) {
            int r3 = LoggerUtil.$r8$clinit;
            if (RxBleLog.isAtLeast(2)) {
                Operation<T> operation = this.operation;
                RxBleLog.v("SKIPPED  %s(%d) just before running — is disposed", operation.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(operation)));
            }
            queueSemaphore.release();
            return;
        }
        scheduler.scheduleDirect(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.FIFORunnableEntry.1
            @Override // java.lang.Runnable
            public final void run() {
                FIFORunnableEntry.this.operation.run(queueSemaphore).unsubscribeOn(scheduler).subscribe(new Observer<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.FIFORunnableEntry.1.1
                    @Override // io.reactivex.Observer
                    public final void onComplete() {
                        ((ObservableCreate.CreateEmitter) FIFORunnableEntry.this.operationResultObserver).onComplete();
                    }

                    @Override // io.reactivex.Observer
                    public final void onError(Throwable th) {
                        ((ObservableCreate.CreateEmitter) FIFORunnableEntry.this.operationResultObserver).tryOnError(th);
                    }

                    @Override // io.reactivex.Observer
                    public final void onNext(T t) {
                        ((ObservableCreate.CreateEmitter) FIFORunnableEntry.this.operationResultObserver).onNext(t);
                    }

                    @Override // io.reactivex.Observer
                    public final void onSubscribe(Disposable disposable) {
                        ObservableCreate.CreateEmitter createEmitter = (ObservableCreate.CreateEmitter) FIFORunnableEntry.this.operationResultObserver;
                        createEmitter.getClass();
                        DisposableHelper.set(createEmitter, disposable);
                    }
                });
            }
        });
    }
}
