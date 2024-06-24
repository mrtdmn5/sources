package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class CompletableAndThenCompletable extends Completable {
    public final CompletableSource next;
    public final CompletableSource source;

    /* loaded from: classes.dex */
    public static final class NextObserver implements CompletableObserver {
        public final CompletableObserver downstream;
        public final AtomicReference<Disposable> parent;

        public NextObserver(AtomicReference<Disposable> atomicReference, CompletableObserver completableObserver) {
            this.parent = atomicReference;
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this.parent, disposable);
        }
    }

    /* loaded from: classes.dex */
    public static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public final CompletableObserver actualObserver;
        public final CompletableSource next;

        public SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.actualObserver = completableObserver;
            this.next = completableSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public final void onComplete() {
            this.next.subscribe(new NextObserver(this, this.actualObserver));
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            this.actualObserver.onError(th);
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.actualObserver.onSubscribe(this);
            }
        }
    }

    public CompletableAndThenCompletable(CompletableFromAction completableFromAction, Completable completable) {
        this.source = completableFromAction;
        this.next = completable;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new SourceObserver(completableObserver, this.next));
    }
}
