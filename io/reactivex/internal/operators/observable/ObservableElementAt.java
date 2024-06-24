package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    public final T defaultValue;
    public final boolean errorOnFewer;
    public final long index;

    /* loaded from: classes.dex */
    public static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        public long count;
        public final T defaultValue;
        public boolean done;
        public final Observer<? super T> downstream;
        public final boolean errorOnFewer;
        public final long index;
        public Disposable upstream;

        public ElementAtObserver(Observer<? super T> observer, long j, T t, boolean z) {
            this.downstream = observer;
            this.index = j;
            this.defaultValue = t;
            this.errorOnFewer = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                Observer<? super T> observer = this.downstream;
                T t = this.defaultValue;
                if (t == null && this.errorOnFewer) {
                    observer.onError(new NoSuchElementException());
                    return;
                }
                if (t != null) {
                    observer.onNext(t);
                }
                observer.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.count;
            if (j == this.index) {
                this.done = true;
                this.upstream.dispose();
                Observer<? super T> observer = this.downstream;
                observer.onNext(t);
                observer.onComplete();
                return;
            }
            this.count = j + 1;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j, T t, boolean z) {
        super(observableSource);
        this.index = j;
        this.defaultValue = t;
        this.errorOnFewer = z;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.index, this.defaultValue, this.errorOnFewer));
    }
}
