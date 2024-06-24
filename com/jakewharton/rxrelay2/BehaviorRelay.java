package com.jakewharton.rxrelay2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public final class BehaviorRelay<T> extends Relay<T> {
    public long index;
    public final Lock readLock;
    public final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    public final AtomicReference<T> value;
    public final Lock writeLock;
    public static final Object[] EMPTY_ARRAY = new Object[0];
    public static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];

    /* loaded from: classes3.dex */
    public static final class BehaviorDisposable<T> implements Disposable, Predicate {
        public volatile boolean cancelled;
        public final Observer<? super T> downstream;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList<T> queue;
        public final BehaviorRelay<T> state;

        public BehaviorDisposable(Observer<? super T> observer, BehaviorRelay<T> behaviorRelay) {
            this.downstream = observer;
            this.state = behaviorRelay;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(T t) {
            if (!this.cancelled) {
                this.downstream.onNext(t);
                return false;
            }
            return false;
        }
    }

    public BehaviorRelay() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T t) {
        if (t != null) {
            Lock lock = this.writeLock;
            lock.lock();
            this.index++;
            this.value.lazySet(t);
            lock.unlock();
            for (BehaviorDisposable<T> behaviorDisposable : this.subscribers.get()) {
                long j = this.index;
                if (!behaviorDisposable.cancelled) {
                    if (!behaviorDisposable.fastPath) {
                        synchronized (behaviorDisposable) {
                            try {
                                if (!behaviorDisposable.cancelled) {
                                    if (behaviorDisposable.index != j) {
                                        if (behaviorDisposable.emitting) {
                                            AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = behaviorDisposable.queue;
                                            if (appendOnlyLinkedArrayList == null) {
                                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                                                behaviorDisposable.queue = appendOnlyLinkedArrayList;
                                            }
                                            int r6 = appendOnlyLinkedArrayList.offset;
                                            if (r6 == 4) {
                                                Object[] objArr = new Object[5];
                                                appendOnlyLinkedArrayList.tail[4] = objArr;
                                                appendOnlyLinkedArrayList.tail = objArr;
                                                r6 = 0;
                                            }
                                            appendOnlyLinkedArrayList.tail[r6] = t;
                                            appendOnlyLinkedArrayList.offset = r6 + 1;
                                        } else {
                                            behaviorDisposable.next = true;
                                            behaviorDisposable.fastPath = true;
                                        }
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    behaviorDisposable.test(t);
                }
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public final boolean hasObservers() {
        if (this.subscribers.get().length != 0) {
            return true;
        }
        return false;
    }

    public final void remove(BehaviorDisposable<T> behaviorDisposable) {
        boolean z;
        BehaviorDisposable<T>[] behaviorDisposableArr;
        do {
            AtomicReference<BehaviorDisposable<T>[]> atomicReference = this.subscribers;
            BehaviorDisposable<T>[] behaviorDisposableArr2 = atomicReference.get();
            int length = behaviorDisposableArr2.length;
            if (length == 0) {
                return;
            }
            z = false;
            int r4 = 0;
            while (true) {
                if (r4 < length) {
                    if (behaviorDisposableArr2[r4] == behaviorDisposable) {
                        break;
                    } else {
                        r4++;
                    }
                } else {
                    r4 = -1;
                    break;
                }
            }
            if (r4 < 0) {
                return;
            }
            if (length == 1) {
                behaviorDisposableArr = EMPTY;
            } else {
                BehaviorDisposable<T>[] behaviorDisposableArr3 = new BehaviorDisposable[length - 1];
                System.arraycopy(behaviorDisposableArr2, 0, behaviorDisposableArr3, 0, r4);
                System.arraycopy(behaviorDisposableArr2, r4 + 1, behaviorDisposableArr3, r4, (length - r4) - 1);
                behaviorDisposableArr = behaviorDisposableArr3;
            }
            while (true) {
                if (atomicReference.compareAndSet(behaviorDisposableArr2, behaviorDisposableArr)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != behaviorDisposableArr2) {
                    break;
                }
            }
        } while (!z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:            r7 = r7.head;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x007f, code lost:            if (r7 == null) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:            r1 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:            if (r1 >= 4) goto L78;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0085, code lost:            r3 = r7[r1];     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0087, code lost:            if (r3 != null) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008a, code lost:            r0.test(r3);        r1 = r1 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0090, code lost:            r7 = r7[4];     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void subscribeActual(io.reactivex.Observer<? super T> r7) {
        /*
            r6 = this;
            com.jakewharton.rxrelay2.BehaviorRelay$BehaviorDisposable r0 = new com.jakewharton.rxrelay2.BehaviorRelay$BehaviorDisposable
            r0.<init>(r7, r6)
            r7.onSubscribe(r0)
        L8:
            java.util.concurrent.atomic.AtomicReference<com.jakewharton.rxrelay2.BehaviorRelay$BehaviorDisposable<T>[]> r7 = r6.subscribers
            java.lang.Object r1 = r7.get()
            com.jakewharton.rxrelay2.BehaviorRelay$BehaviorDisposable[] r1 = (com.jakewharton.rxrelay2.BehaviorRelay.BehaviorDisposable[]) r1
            int r2 = r1.length
            int r3 = r2 + 1
            com.jakewharton.rxrelay2.BehaviorRelay$BehaviorDisposable[] r3 = new com.jakewharton.rxrelay2.BehaviorRelay.BehaviorDisposable[r3]
            r4 = 0
            java.lang.System.arraycopy(r1, r4, r3, r4, r2)
            r3[r2] = r0
        L1b:
            boolean r2 = r7.compareAndSet(r1, r3)
            r5 = 1
            if (r2 == 0) goto L24
            r7 = r5
            goto L2b
        L24:
            java.lang.Object r2 = r7.get()
            if (r2 == r1) goto L1b
            r7 = r4
        L2b:
            if (r7 == 0) goto L8
            boolean r7 = r0.cancelled
            if (r7 == 0) goto L36
            r6.remove(r0)
            goto L98
        L36:
            boolean r7 = r0.cancelled
            if (r7 == 0) goto L3b
            goto L98
        L3b:
            monitor-enter(r0)
            boolean r7 = r0.cancelled     // Catch: java.lang.Throwable -> L99
            if (r7 == 0) goto L42
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            goto L98
        L42:
            boolean r7 = r0.next     // Catch: java.lang.Throwable -> L99
            if (r7 == 0) goto L48
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            goto L98
        L48:
            com.jakewharton.rxrelay2.BehaviorRelay<T> r7 = r0.state     // Catch: java.lang.Throwable -> L99
            java.util.concurrent.locks.Lock r1 = r7.readLock     // Catch: java.lang.Throwable -> L99
            r1.lock()     // Catch: java.lang.Throwable -> L99
            long r2 = r7.index     // Catch: java.lang.Throwable -> L99
            r0.index = r2     // Catch: java.lang.Throwable -> L99
            java.util.concurrent.atomic.AtomicReference<T> r7 = r7.value     // Catch: java.lang.Throwable -> L99
            java.lang.Object r7 = r7.get()     // Catch: java.lang.Throwable -> L99
            r1.unlock()     // Catch: java.lang.Throwable -> L99
            if (r7 == 0) goto L60
            r1 = r5
            goto L61
        L60:
            r1 = r4
        L61:
            r0.emitting = r1     // Catch: java.lang.Throwable -> L99
            r0.next = r5     // Catch: java.lang.Throwable -> L99
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            if (r7 == 0) goto L98
            r0.test(r7)
        L6b:
            boolean r7 = r0.cancelled
            if (r7 == 0) goto L70
            goto L98
        L70:
            monitor-enter(r0)
            com.jakewharton.rxrelay2.AppendOnlyLinkedArrayList<T> r7 = r0.queue     // Catch: java.lang.Throwable -> L95
            if (r7 != 0) goto L79
            r0.emitting = r4     // Catch: java.lang.Throwable -> L95
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            goto L98
        L79:
            r1 = 0
            r0.queue = r1     // Catch: java.lang.Throwable -> L95
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.Object[] r7 = r7.head
        L7f:
            if (r7 == 0) goto L6b
            r1 = r4
        L82:
            r2 = 4
            if (r1 >= r2) goto L90
            r3 = r7[r1]
            if (r3 != 0) goto L8a
            goto L90
        L8a:
            r0.test(r3)
            int r1 = r1 + 1
            goto L82
        L90:
            r7 = r7[r2]
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            goto L7f
        L95:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L95
            throw r7
        L98:
            return
        L99:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L99
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jakewharton.rxrelay2.BehaviorRelay.subscribeActual(io.reactivex.Observer):void");
    }
}
