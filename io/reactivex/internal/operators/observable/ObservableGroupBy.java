package io.reactivex.internal.operators.observable;

import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    public final int bufferSize;
    public final boolean delayError;
    public final Function<? super T, ? extends K> keySelector;
    public final Function<? super T, ? extends V> valueSelector;

    /* loaded from: classes.dex */
    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        public static final Object NULL_KEY = new Object();
        public final int bufferSize;
        public final boolean delayError;
        public final Observer<? super GroupedObservable<K, V>> downstream;
        public final Function<? super T, ? extends K> keySelector;
        public Disposable upstream;
        public final Function<? super T, ? extends V> valueSelector;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final ConcurrentHashMap groups = new ConcurrentHashMap();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int r5, boolean z) {
            this.downstream = observer;
            this.keySelector = function;
            this.valueSelector = function2;
            this.bufferSize = r5;
            this.delayError = z;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                State<T, K> state = ((GroupedUnicast) it.next()).state;
                state.done = true;
                state.drain();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                State<T, K> state = ((GroupedUnicast) it.next()).state;
                state.error = th;
                state.done = true;
                state.drain();
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            Object obj;
            try {
                Object apply = this.keySelector.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = NULL_KEY;
                }
                ConcurrentHashMap concurrentHashMap = this.groups;
                GroupedUnicast groupedUnicast = (GroupedUnicast) concurrentHashMap.get(obj);
                if (groupedUnicast == null) {
                    if (this.cancelled.get()) {
                        return;
                    }
                    GroupedUnicast groupedUnicast2 = new GroupedUnicast(apply, new State(this.bufferSize, this, apply, this.delayError));
                    concurrentHashMap.put(obj, groupedUnicast2);
                    getAndIncrement();
                    this.downstream.onNext(groupedUnicast2);
                    groupedUnicast = groupedUnicast2;
                }
                try {
                    V apply2 = this.valueSelector.apply(t);
                    ObjectHelper.requireNonNull(apply2, "The value supplied is null");
                    State<T, K> state = groupedUnicast.state;
                    state.queue.offer(apply2);
                    state.drain();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.upstream.dispose();
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        public final State<T, K> state;

        public GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.state = state;
        }

        @Override // io.reactivex.Observable
        public final void subscribeActual(Observer<? super T> observer) {
            this.state.subscribe(observer);
        }
    }

    /* loaded from: classes.dex */
    public static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final K key;
        public final GroupByObserver<?, K, T> parent;
        public final SpscLinkedArrayQueue<T> queue;
        public final AtomicBoolean cancelled = new AtomicBoolean();
        public final AtomicBoolean once = new AtomicBoolean();
        public final AtomicReference<Observer<? super T>> actual = new AtomicReference<>();

        public State(int r2, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.queue = new SpscLinkedArrayQueue<>(r2);
            this.parent = groupByObserver;
            this.key = k;
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.actual.lazySet(null);
                GroupByObserver<?, K, T> groupByObserver = this.parent;
                groupByObserver.getClass();
                Object obj = this.key;
                if (obj == null) {
                    obj = GroupByObserver.NULL_KEY;
                }
                groupByObserver.groups.remove(obj);
                if (groupByObserver.decrementAndGet() == 0) {
                    groupByObserver.upstream.dispose();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void drain() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                io.reactivex.internal.queue.SpscLinkedArrayQueue<T> r0 = r13.queue
                boolean r1 = r13.delayError
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r2 = r13.actual
                java.lang.Object r2 = r2.get()
                io.reactivex.Observer r2 = (io.reactivex.Observer) r2
                r3 = 1
                r4 = r3
            L15:
                if (r2 == 0) goto L89
            L17:
                boolean r5 = r13.done
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r6 != 0) goto L22
                r8 = r3
                goto L23
            L22:
                r8 = r7
            L23:
                java.util.concurrent.atomic.AtomicBoolean r9 = r13.cancelled
                boolean r9 = r9.get()
                io.reactivex.internal.queue.SpscLinkedArrayQueue<T> r10 = r13.queue
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r11 = r13.actual
                r12 = 0
                if (r9 == 0) goto L53
                r10.clear()
                io.reactivex.internal.operators.observable.ObservableGroupBy$GroupByObserver<?, K, T> r5 = r13.parent
                K r7 = r13.key
                r5.getClass()
                if (r7 == 0) goto L3d
                goto L3f
            L3d:
                java.lang.Object r7 = io.reactivex.internal.operators.observable.ObservableGroupBy.GroupByObserver.NULL_KEY
            L3f:
                java.util.concurrent.ConcurrentHashMap r9 = r5.groups
                r9.remove(r7)
                int r7 = r5.decrementAndGet()
                if (r7 != 0) goto L4f
                io.reactivex.disposables.Disposable r5 = r5.upstream
                r5.dispose()
            L4f:
                r11.lazySet(r12)
                goto L7e
            L53:
                if (r5 == 0) goto L7f
                if (r1 == 0) goto L68
                if (r8 == 0) goto L7f
                java.lang.Throwable r5 = r13.error
                r11.lazySet(r12)
                if (r5 == 0) goto L64
                r2.onError(r5)
                goto L7e
            L64:
                r2.onComplete()
                goto L7e
            L68:
                java.lang.Throwable r5 = r13.error
                if (r5 == 0) goto L76
                r10.clear()
                r11.lazySet(r12)
                r2.onError(r5)
                goto L7e
            L76:
                if (r8 == 0) goto L7f
                r11.lazySet(r12)
                r2.onComplete()
            L7e:
                r7 = r3
            L7f:
                if (r7 == 0) goto L82
                return
            L82:
                if (r8 == 0) goto L85
                goto L89
            L85:
                r2.onNext(r6)
                goto L17
            L89:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L91
                return
            L91:
                if (r2 != 0) goto L15
                java.util.concurrent.atomic.AtomicReference<io.reactivex.Observer<? super T>> r2 = r13.actual
                java.lang.Object r2 = r2.get()
                io.reactivex.Observer r2 = (io.reactivex.Observer) r2
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableGroupBy.State.drain():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled.get();
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            if (this.once.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                AtomicReference<Observer<? super T>> atomicReference = this.actual;
                atomicReference.lazySet(observer);
                if (this.cancelled.get()) {
                    atomicReference.lazySet(null);
                    return;
                } else {
                    drain();
                    return;
                }
            }
            EmptyDisposable.error(new IllegalStateException("Only one Observer allowed!"), observer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableGroupBy(ObservableSource observableSource, ScanSettingsEmulator.AnonymousClass3.AnonymousClass2 anonymousClass2, int r4) {
        super(observableSource);
        Functions.Identity identity = Functions.IDENTITY;
        this.keySelector = anonymousClass2;
        this.valueSelector = identity;
        this.bufferSize = r4;
        this.delayError = false;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.keySelector, this.valueSelector, this.bufferSize, this.delayError));
    }
}
