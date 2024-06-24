package com.polidea.rxandroidble2.internal.serialization;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble2.internal.connection.DisconnectionRouterOutput;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.operations.Operation;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.observers.DisposableObserver;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public final class ConnectionOperationQueueImpl implements ConnectionOperationQueue, ConnectionSubscriptionWatcher {
    public final String deviceMacAddress;
    public final DisconnectionRouterOutput disconnectionRouterOutput;
    public AnonymousClass3 disconnectionThrowableSubscription;
    public final Future<?> runnableFuture;
    public final OperationPriorityFifoBlockingQueue queue = new OperationPriorityFifoBlockingQueue();
    public volatile boolean shouldRun = true;
    public BleException disconnectionException = null;

    public ConnectionOperationQueueImpl(final String str, DisconnectionRouterOutput disconnectionRouterOutput, ExecutorService executorService, final Scheduler scheduler) {
        this.deviceMacAddress = str;
        this.disconnectionRouterOutput = disconnectionRouterOutput;
        this.runnableFuture = executorService.submit(new Runnable() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.1
            @Override // java.lang.Runnable
            public final void run() {
                while (ConnectionOperationQueueImpl.this.shouldRun) {
                    try {
                        FIFORunnableEntry take = ConnectionOperationQueueImpl.this.queue.q.take();
                        Operation<T> operation = take.operation;
                        long currentTimeMillis = System.currentTimeMillis();
                        LoggerUtil.logOperationStarted(operation);
                        RxBleLog.i("RUNNING  %s", operation);
                        QueueSemaphore queueSemaphore = new QueueSemaphore();
                        take.run(queueSemaphore, scheduler);
                        queueSemaphore.awaitRelease();
                        LoggerUtil.logOperationFinished(operation, currentTimeMillis, System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        synchronized (ConnectionOperationQueueImpl.this) {
                            if (!ConnectionOperationQueueImpl.this.shouldRun) {
                                break;
                            } else {
                                RxBleLog.throwShade(6, e, "Error while processing connection operation queue", new Object[0]);
                            }
                        }
                    }
                }
                ConnectionOperationQueueImpl connectionOperationQueueImpl = ConnectionOperationQueueImpl.this;
                synchronized (connectionOperationQueueImpl) {
                    while (!connectionOperationQueueImpl.queue.q.isEmpty()) {
                        ((ObservableCreate.CreateEmitter) connectionOperationQueueImpl.queue.q.poll().operationResultObserver).tryOnError(connectionOperationQueueImpl.disconnectionException);
                    }
                }
                RxBleLog.v("Terminated (%s)", LoggerUtil.commonMacMessage(str));
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl$3, io.reactivex.Observer] */
    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionSubscribed() {
        ObservableSource asValueOnlyObservable = this.disconnectionRouterOutput.asValueOnlyObservable();
        ?? r1 = new DisposableObserver<BleException>() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.3
            @Override // io.reactivex.Observer
            public final void onNext(Object obj) {
                ConnectionOperationQueueImpl.this.terminate((BleException) obj);
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
            }
        };
        asValueOnlyObservable.subscribe(r1);
        this.disconnectionThrowableSubscription = r1;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionUnsubscribed() {
        dispose();
        this.disconnectionThrowableSubscription = null;
        terminate(new BleDisconnectedException(this.deviceMacAddress, -1));
    }

    @Override // com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue
    public final synchronized <T> Observable<T> queue(final Operation<T> operation) {
        if (!this.shouldRun) {
            return Observable.error(this.disconnectionException);
        }
        return new ObservableCreate(new ObservableOnSubscribe<T>() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableCreate.CreateEmitter createEmitter) {
                Operation operation2 = operation;
                final FIFORunnableEntry fIFORunnableEntry = new FIFORunnableEntry(operation2, createEmitter);
                DisposableHelper.set(createEmitter, new CancellableDisposable(new Cancellable() { // from class: com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl.2.1
                    @Override // io.reactivex.functions.Cancellable
                    public final void cancel() {
                        boolean z;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        PriorityBlockingQueue<FIFORunnableEntry> priorityBlockingQueue = ConnectionOperationQueueImpl.this.queue.q;
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
                ConnectionOperationQueueImpl.this.queue.q.add(fIFORunnableEntry);
            }
        });
    }

    public final synchronized void terminate(BleException bleException) {
        if (this.disconnectionException != null) {
            return;
        }
        RxBleLog.throwShade(3, bleException, "Connection operations queue to be terminated (%s)", LoggerUtil.commonMacMessage(this.deviceMacAddress));
        this.shouldRun = false;
        this.disconnectionException = bleException;
        this.runnableFuture.cancel(true);
    }
}
