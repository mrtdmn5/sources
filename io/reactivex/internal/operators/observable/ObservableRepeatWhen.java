package io.reactivex.internal.operators.observable;

import com.polidea.rxandroidble2.internal.scan.ScanSettingsEmulator;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.SerializedSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* loaded from: classes.dex */
public final class ObservableRepeatWhen<T> extends AbstractObservableWithUpstream<T, T> {
    public final Function<? super Observable<Object>, ? extends ObservableSource<?>> handler;

    /* loaded from: classes.dex */
    public static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public volatile boolean active;
        public final Observer<? super T> downstream;
        public final Subject<Object> signaller;
        public final ObservableSource<T> source;
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicThrowable error = new AtomicThrowable();
        public final RepeatWhenObserver<T>.InnerRepeatObserver inner = new InnerRepeatObserver();
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();

        /* loaded from: classes.dex */
        public final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            public InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.upstream);
                MagicApiIntrinsics.onComplete(repeatWhenObserver.downstream, repeatWhenObserver, repeatWhenObserver.error);
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                RepeatWhenObserver repeatWhenObserver = RepeatWhenObserver.this;
                DisposableHelper.dispose(repeatWhenObserver.upstream);
                MagicApiIntrinsics.onError(repeatWhenObserver.downstream, th, repeatWhenObserver, repeatWhenObserver.error);
            }

            @Override // io.reactivex.Observer
            public final void onNext(Object obj) {
                RepeatWhenObserver.this.subscribeNext();
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public RepeatWhenObserver(Observer<? super T> observer, Subject<Object> subject, ObservableSource<T> observableSource) {
            this.downstream = observer;
            this.signaller = subject;
            this.source = observableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.inner);
            MagicApiIntrinsics.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            MagicApiIntrinsics.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public final void subscribeNext() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    this.active = true;
                    this.source.subscribe(this);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public ObservableRepeatWhen(Observable observable, ScanSettingsEmulator.AnonymousClass2.AnonymousClass1 anonymousClass1) {
        super(observable);
        this.handler = anonymousClass1;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        Subject publishSubject = new PublishSubject();
        if (!(publishSubject instanceof SerializedSubject)) {
            publishSubject = new SerializedSubject(publishSubject);
        }
        try {
            ObservableSource<?> apply = this.handler.apply(publishSubject);
            ObjectHelper.requireNonNull(apply, "The handler returned a null ObservableSource");
            ObservableSource<?> observableSource = apply;
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, publishSubject, this.source);
            observer.onSubscribe(repeatWhenObserver);
            observableSource.subscribe(repeatWhenObserver.inner);
            repeatWhenObserver.subscribeNext();
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            EmptyDisposable.error(th, observer);
        }
    }
}
