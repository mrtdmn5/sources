package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableReplay<T> extends ConnectableObservable<T> implements ResettableConnectable {
    public static final UnBoundedFactory DEFAULT_UNBOUNDED_FACTORY = new UnBoundedFactory();
    public final BufferSupplier<T> bufferFactory;
    public final AtomicReference<ReplayObserver<T>> current;
    public final ObservableSource<T> onSubscribe;
    public final ObservableSource<T> source;

    /* loaded from: classes.dex */
    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        public int size;
        public Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null);
            this.tail = node;
            set(node);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            Node node = new Node(NotificationLite.complete());
            this.tail.set(node);
            this.tail = node;
            this.size++;
            Node node2 = get();
            if (node2.value != null) {
                Node node3 = new Node(null);
                node3.lazySet(node2.get());
                set(node3);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            Node node = new Node(NotificationLite.error(th));
            this.tail.set(node);
            this.tail = node;
            this.size++;
            Node node2 = get();
            if (node2.value != null) {
                Node node3 = new Node(null);
                node3.lazySet(node2.get());
                set(node3);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            Node node = new Node(NotificationLite.next(t));
            this.tail.set(node);
            this.tail = node;
            this.size++;
            SizeBoundReplayBuffer sizeBoundReplayBuffer = (SizeBoundReplayBuffer) this;
            if (sizeBoundReplayBuffer.size > sizeBoundReplayBuffer.limit) {
                sizeBoundReplayBuffer.size--;
                sizeBoundReplayBuffer.set(sizeBoundReplayBuffer.get().get());
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            int r0 = 1;
            do {
                Node node = (Node) innerDisposable.index;
                if (node == null) {
                    node = get();
                    innerDisposable.index = node;
                }
                while (!innerDisposable.cancelled) {
                    Node node2 = node.get();
                    if (node2 != null) {
                        if (NotificationLite.accept(node2.value, innerDisposable.child)) {
                            innerDisposable.index = null;
                            return;
                        }
                        node = node2;
                    } else {
                        innerDisposable.index = node;
                        r0 = innerDisposable.addAndGet(-r0);
                    }
                }
                innerDisposable.index = null;
                return;
            } while (r0 != 0);
        }
    }

    /* loaded from: classes.dex */
    public interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    /* loaded from: classes.dex */
    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        public volatile boolean cancelled;
        public final Observer<? super T> child;
        public Serializable index;
        public final ReplayObserver<T> parent;

        public InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.parent = replayObserver;
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.remove(this);
                this.index = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* loaded from: classes.dex */
    public static final class Node extends AtomicReference<Node> {
        public final Object value;

        public Node(Object obj) {
            this.value = obj;
        }
    }

    /* loaded from: classes.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th);

        void next(T t);

        void replay(InnerDisposable<T> innerDisposable);
    }

    /* loaded from: classes.dex */
    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        public final int bufferSize = 1;

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public final ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.bufferSize);
        }
    }

    /* loaded from: classes.dex */
    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        public static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        public final ReplayBuffer<T> buffer;
        public boolean done;
        public final AtomicReference<InnerDisposable[]> observers = new AtomicReference<>(EMPTY);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (this.observers.get() == TERMINATED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                ReplayBuffer<T> replayBuffer = this.buffer;
                replayBuffer.complete();
                for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                    replayBuffer.replay(innerDisposable);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (!this.done) {
                this.done = true;
                ReplayBuffer<T> replayBuffer = this.buffer;
                replayBuffer.error(th);
                for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                    replayBuffer.replay(innerDisposable);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (!this.done) {
                ReplayBuffer<T> replayBuffer = this.buffer;
                replayBuffer.next(t);
                for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                    replayBuffer.replay(innerDisposable);
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                    this.buffer.replay(innerDisposable);
                }
            }
        }

        public final void remove(InnerDisposable<T> innerDisposable) {
            boolean z;
            InnerDisposable[] innerDisposableArr;
            do {
                AtomicReference<InnerDisposable[]> atomicReference = this.observers;
                InnerDisposable[] innerDisposableArr2 = atomicReference.get();
                int length = innerDisposableArr2.length;
                if (length == 0) {
                    return;
                }
                z = false;
                int r4 = 0;
                while (true) {
                    if (r4 < length) {
                        if (innerDisposableArr2[r4].equals(innerDisposable)) {
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
                    innerDisposableArr = EMPTY;
                } else {
                    InnerDisposable[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr2, 0, innerDisposableArr3, 0, r4);
                    System.arraycopy(innerDisposableArr2, r4 + 1, innerDisposableArr3, r4, (length - r4) - 1);
                    innerDisposableArr = innerDisposableArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerDisposableArr2, innerDisposableArr)) {
                        z = true;
                        break;
                    } else if (atomicReference.get() != innerDisposableArr2) {
                        break;
                    }
                }
            } while (!z);
        }
    }

    /* loaded from: classes.dex */
    public static final class ReplaySource<T> implements ObservableSource<T> {
        public final BufferSupplier<T> bufferFactory;
        public final AtomicReference<ReplayObserver<T>> curr;

        public ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.curr = atomicReference;
            this.bufferFactory = bufferSupplier;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            ReplayObserver<T> replayObserver;
            boolean z;
            boolean z2;
            while (true) {
                replayObserver = this.curr.get();
                if (replayObserver != null) {
                    break;
                }
                ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
                AtomicReference<ReplayObserver<T>> atomicReference = this.curr;
                while (true) {
                    if (atomicReference.compareAndSet(null, replayObserver2)) {
                        z2 = true;
                        break;
                    } else if (atomicReference.get() != null) {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    replayObserver = replayObserver2;
                    break;
                }
            }
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(replayObserver, observer);
            observer.onSubscribe(innerDisposable);
            do {
                AtomicReference<InnerDisposable[]> atomicReference2 = replayObserver.observers;
                InnerDisposable[] innerDisposableArr = atomicReference2.get();
                if (innerDisposableArr == ReplayObserver.TERMINATED) {
                    break;
                }
                int length = innerDisposableArr.length;
                InnerDisposable[] innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
                while (true) {
                    if (atomicReference2.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                        z = true;
                        break;
                    } else if (atomicReference2.get() != innerDisposableArr) {
                        z = false;
                        break;
                    }
                }
            } while (!z);
            if (innerDisposable.cancelled) {
                replayObserver.remove(innerDisposable);
            } else {
                replayObserver.buffer.replay(innerDisposable);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        public final int limit;

        public SizeBoundReplayBuffer(int r1) {
            this.limit = r1;
        }
    }

    /* loaded from: classes.dex */
    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        @Override // io.reactivex.internal.operators.observable.ObservableReplay.BufferSupplier
        public final ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer();
        }
    }

    /* loaded from: classes.dex */
    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        public volatile int size;

        public UnboundedReplayBuffer() {
            super(16);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void complete() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void next(T t) {
            add(NotificationLite.next(t));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableReplay.ReplayBuffer
        public final void replay(InnerDisposable<T> innerDisposable) {
            int r3;
            if (innerDisposable.getAndIncrement() != 0) {
                return;
            }
            Observer<? super T> observer = innerDisposable.child;
            int r1 = 1;
            while (!innerDisposable.cancelled) {
                int r2 = this.size;
                Integer num = (Integer) innerDisposable.index;
                if (num != null) {
                    r3 = num.intValue();
                } else {
                    r3 = 0;
                }
                while (r3 < r2) {
                    if (NotificationLite.accept(get(r3), observer) || innerDisposable.cancelled) {
                        return;
                    } else {
                        r3++;
                    }
                }
                innerDisposable.index = Integer.valueOf(r3);
                r1 = innerDisposable.addAndGet(-r1);
                if (r1 == 0) {
                    return;
                }
            }
        }
    }

    public ObservableReplay(ReplaySource replaySource, Observable observable, AtomicReference atomicReference, BufferSupplier bufferSupplier) {
        this.onSubscribe = replaySource;
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = bufferSupplier;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public final void connect(Consumer<? super Disposable> consumer) {
        ReplayObserver<T> replayObserver;
        boolean z;
        boolean z2;
        while (true) {
            AtomicReference<ReplayObserver<T>> atomicReference = this.current;
            replayObserver = atomicReference.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver<T> replayObserver2 = new ReplayObserver<>(this.bufferFactory.call());
            while (true) {
                if (atomicReference.compareAndSet(replayObserver, replayObserver2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != replayObserver) {
                    z = false;
                    break;
                }
            }
            if (z) {
                replayObserver = replayObserver2;
                break;
            }
        }
        boolean z3 = replayObserver.shouldConnect.get();
        AtomicBoolean atomicBoolean = replayObserver.shouldConnect;
        if (!z3 && atomicBoolean.compareAndSet(false, true)) {
            z2 = true;
        } else {
            z2 = false;
        }
        try {
            consumer.accept(replayObserver);
            if (z2) {
                this.source.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z2) {
                atomicBoolean.compareAndSet(true, false);
            }
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public final void resetIf(Disposable disposable) {
        AtomicReference<ReplayObserver<T>> atomicReference;
        ReplayObserver<T> replayObserver = (ReplayObserver) disposable;
        do {
            atomicReference = this.current;
            if (atomicReference.compareAndSet(replayObserver, null)) {
                return;
            }
        } while (atomicReference.get() == replayObserver);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }
}
