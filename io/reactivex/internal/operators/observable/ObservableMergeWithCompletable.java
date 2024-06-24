package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* loaded from: classes.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {
    public final CompletableSource other;

    /* loaded from: classes.dex */
    public static final class MergeWithObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        public final Observer<? super T> downstream;
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final AtomicReference<Disposable> mainDisposable = new AtomicReference<>();
        public final OtherObserver otherObserver = new OtherObserver(this);
        public final AtomicThrowable error = new AtomicThrowable();

        /* loaded from: classes.dex */
        public static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            public final MergeWithObserver<?> parent;

            public OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public final void onComplete() {
                MergeWithObserver<?> mergeWithObserver = this.parent;
                mergeWithObserver.otherDone = true;
                if (mergeWithObserver.mainDone) {
                    MagicApiIntrinsics.onComplete(mergeWithObserver.downstream, mergeWithObserver, mergeWithObserver.error);
                }
            }

            @Override // io.reactivex.CompletableObserver
            public final void onError(Throwable th) {
                MergeWithObserver<?> mergeWithObserver = this.parent;
                DisposableHelper.dispose(mergeWithObserver.mainDisposable);
                MagicApiIntrinsics.onError(mergeWithObserver.downstream, th, mergeWithObserver, mergeWithObserver.error);
            }

            @Override // io.reactivex.CompletableObserver
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public MergeWithObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                MagicApiIntrinsics.onComplete(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            MagicApiIntrinsics.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            MagicApiIntrinsics.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.mainDisposable, disposable);
        }
    }

    public ObservableMergeWithCompletable(Observable observable, Completable completable) {
        super(observable);
        this.other = completable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(observer);
        observer.onSubscribe(mergeWithObserver);
        this.source.subscribe(mergeWithObserver);
        this.other.subscribe(mergeWithObserver.otherObserver);
    }
}
