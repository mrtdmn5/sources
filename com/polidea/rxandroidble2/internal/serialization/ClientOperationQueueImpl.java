package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.ActionDisposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public final class ClientOperationQueueImpl implements ClientOperationQueue {
    public final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();

    public ClientOperationQueueImpl(final Scheduler scheduler) {
        new Thread(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.1
            @Override // java.lang.Runnable
            public final void run() {
                while (true) {
                    try {
                        FIFORunnableEntry take = ClientOperationQueueImpl.this.queue.q.take();
                        Operation<T> operation = take.operation;
                        long currentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        RxBleLog.i("RUNNING  %s", operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        take.run(queueSemaphore, scheduler);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, currentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        RxBleLog.throwShade(6, e, "Error while processing client operation queue", new Object[0]);
                    }
                }
            }
        }).start();
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue
    public final <T> Observable<T> queue(final Operation<T> operation) {
        return new ObservableCreate(new ObservableOnSubscribe<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2
            /* JADX WARN: Type inference failed for: r2v0, types: [com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl$2$1] */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableCreate.CreateEmitter createEmitter) {
                Operation operation2 = operation;
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation2, createEmitter);
                DisposableHelper.set(createEmitter, new ActionDisposable(new Action() { // from class: com.polidea.rxandroidble2.internal.serialization.ClientOperationQueueImpl.2.1
                    @Override // io.reactivex.functions.Action
                    public final void run() {
                        boolean z;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        PriorityBlockingQueue<FIFORunnableEntry> priorityBlockingQueue = ClientOperationQueueImpl.this.queue.q;
                        Iterator<FIFORunnableEntry> it = priorityBlockingQueue.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                FIFORunnableEntry next = it.next();
                                if (next == fIFORunnableEntry) {
                                    z = priorityBlockingQueue.remove(next);
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            LoggerUtil.logOperationRemoved(operation);
                        }
                    }
                }));
                LoggerUtil.logOperationQueued(operation2);
                ClientOperationQueueImpl.this.queue.q.add(fIFORunnableEntry);
            }
        });
    }
}
