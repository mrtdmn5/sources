package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class BehaviorSubject<T> extends Subject<T> {
    public long index;
    public final Lock readLock;
    public final AtomicReference<BehaviorDisposable<T>[]> subscribers;
    public final AtomicReference<Throwable> terminalEvent;
    public final AtomicReference<Object> value;
    public final Lock writeLock;
    public static final Object[] EMPTY_ARRAY = new Object[0];
    public static final BehaviorDisposable[] EMPTY = new BehaviorDisposable[0];
    public static final BehaviorDisposable[] TERMINATED = new BehaviorDisposable[0];

    /* loaded from: classes.dex */
    public static final class BehaviorDisposable<T> implements Disposable, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        public volatile boolean cancelled;
        public final Observer<? super T> downstream;
        public boolean emitting;
        public boolean fastPath;
        public long index;
        public boolean next;
        public AppendOnlyLinkedArrayList<Object> queue;
        public final BehaviorSubject<T> state;

        public BehaviorDisposable(Observer<? super T> observer, BehaviorSubject<T> behaviorSubject) {
            this.downstream = observer;
            this.state = behaviorSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.state.remove(this);
            }
        }

        public final void emitNext(long j, Object obj) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j) {
                        return;
                    }
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            if (!this.cancelled && !NotificationLite.accept(obj, this.downstream)) {
                return false;
            }
            return true;
        }
    }

    public BehaviorSubject() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.readLock = reentrantReadWriteLock.readLock();
        this.writeLock = reentrantReadWriteLock.writeLock();
        this.subscribers = new AtomicReference<>(EMPTY);
        this.value = new AtomicReference<>();
        this.terminalEvent = new AtomicReference<>();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        int r3;
        boolean z;
        AtomicReference<Throwable> atomicReference = this.terminalEvent;
        ExceptionHelper.Termination termination = ExceptionHelper.TERMINATED;
        while (true) {
            if (atomicReference.compareAndSet(null, termination)) {
                z = true;
                break;
            } else if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        if (!z) {
            return;
        }
        Object complete = NotificationLite.complete();
        AtomicReference<BehaviorDisposable<T>[]> atomicReference2 = this.subscribers;
        BehaviorDisposable<T>[] behaviorDisposableArr = TERMINATED;
        BehaviorDisposable<T>[] andSet = atomicReference2.getAndSet(behaviorDisposableArr);
        if (andSet != behaviorDisposableArr) {
            Lock lock = this.writeLock;
            lock.lock();
            this.index++;
            this.value.lazySet(complete);
            lock.unlock();
        }
        for (BehaviorDisposable<T> behaviorDisposable : andSet) {
            behaviorDisposable.emitNext(this.index, complete);
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        int r2;
        boolean z;
        if (th != null) {
            AtomicReference<Throwable> atomicReference = this.terminalEvent;
            while (true) {
                if (atomicReference.compareAndSet(null, th)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != null) {
                    z = false;
                    break;
                }
            }
            if (!z) {
                RxJavaPlugins.onError(th);
                return;
            }
            Object error = NotificationLite.error(th);
            AtomicReference<BehaviorDisposable<T>[]> atomicReference2 = this.subscribers;
            BehaviorDisposable<T>[] behaviorDisposableArr = TERMINATED;
            BehaviorDisposable<T>[] andSet = atomicReference2.getAndSet(behaviorDisposableArr);
            if (andSet != behaviorDisposableArr) {
                Lock lock = this.writeLock;
                lock.lock();
                this.index++;
                this.value.lazySet(error);
                lock.unlock();
            }
            for (BehaviorDisposable<T> behaviorDisposable : andSet) {
                behaviorDisposable.emitNext(this.index, error);
            }
            return;
        }
        throw new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (t != null) {
            if (this.terminalEvent.get() != null) {
                return;
            }
            Object next = NotificationLite.next(t);
            Lock lock = this.writeLock;
            lock.lock();
            this.index++;
            this.value.lazySet(next);
            lock.unlock();
            for (BehaviorDisposable<T> behaviorDisposable : this.subscribers.get()) {
                behaviorDisposable.emitNext(this.index, next);
            }
            return;
        }
        throw new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.terminalEvent.get() != null) {
            disposable.dispose();
        }
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

    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:            r8.forEachWhile(r0);     */
    @Override // io.reactivex.Observable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void subscribeActual(io.reactivex.Observer<? super T> r8) {
        /*
            r7 = this;
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable r0 = new io.reactivex.subjects.BehaviorSubject$BehaviorDisposable
            r0.<init>(r8, r7)
            r8.onSubscribe(r0)
        L8:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.subjects.BehaviorSubject$BehaviorDisposable<T>[]> r1 = r7.subscribers
            java.lang.Object r2 = r1.get()
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r2 = (io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[]) r2
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r3 = io.reactivex.subjects.BehaviorSubject.TERMINATED
            r4 = 1
            r5 = 0
            if (r2 != r3) goto L18
            r1 = r5
            goto L34
        L18:
            int r3 = r2.length
            int r6 = r3 + 1
            io.reactivex.subjects.BehaviorSubject$BehaviorDisposable[] r6 = new io.reactivex.subjects.BehaviorSubject.BehaviorDisposable[r6]
            java.lang.System.arraycopy(r2, r5, r6, r5, r3)
            r6[r3] = r0
        L22:
            boolean r3 = r1.compareAndSet(r2, r6)
            if (r3 == 0) goto L2a
            r1 = r4
            goto L31
        L2a:
            java.lang.Object r3 = r1.get()
            if (r3 == r2) goto L22
            r1 = r5
        L31:
            if (r1 == 0) goto L8
            r1 = r4
        L34:
            if (r1 == 0) goto L95
            boolean r8 = r0.cancelled
            if (r8 == 0) goto L3f
            r7.remove(r0)
            goto La8
        L3f:
            boolean r8 = r0.cancelled
            if (r8 == 0) goto L45
            goto La8
        L45:
            monitor-enter(r0)
            boolean r8 = r0.cancelled     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L4c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            goto La8
        L4c:
            boolean r8 = r0.next     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L52
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            goto La8
        L52:
            io.reactivex.subjects.BehaviorSubject<T> r8 = r0.state     // Catch: java.lang.Throwable -> L92
            java.util.concurrent.locks.Lock r1 = r8.readLock     // Catch: java.lang.Throwable -> L92
            r1.lock()     // Catch: java.lang.Throwable -> L92
            long r2 = r8.index     // Catch: java.lang.Throwable -> L92
            r0.index = r2     // Catch: java.lang.Throwable -> L92
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r8 = r8.value     // Catch: java.lang.Throwable -> L92
            java.lang.Object r8 = r8.get()     // Catch: java.lang.Throwable -> L92
            r1.unlock()     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto L6a
            r1 = r4
            goto L6b
        L6a:
            r1 = r5
        L6b:
            r0.emitting = r1     // Catch: java.lang.Throwable -> L92
            r0.next = r4     // Catch: java.lang.Throwable -> L92
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            if (r8 == 0) goto La8
            boolean r8 = r0.test(r8)
            if (r8 == 0) goto L79
            goto La8
        L79:
            boolean r8 = r0.cancelled
            if (r8 == 0) goto L7e
            goto La8
        L7e:
            monitor-enter(r0)
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r8 = r0.queue     // Catch: java.lang.Throwable -> L8f
            if (r8 != 0) goto L87
            r0.emitting = r5     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            goto La8
        L87:
            r1 = 0
            r0.queue = r1     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            r8.forEachWhile(r0)
            goto L79
        L8f:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r8
        L92:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L92
            throw r8
        L95:
            java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r0 = r7.terminalEvent
            java.lang.Object r0 = r0.get()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            io.reactivex.internal.util.ExceptionHelper$Termination r1 = io.reactivex.internal.util.ExceptionHelper.TERMINATED
            if (r0 != r1) goto La5
            r8.onComplete()
            goto La8
        La5:
            r8.onError(r0)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.subjects.BehaviorSubject.subscribeActual(io.reactivex.Observer):void");
    }
}
