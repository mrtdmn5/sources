package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;

/* loaded from: classes.dex */
public final class CompletableOnErrorComplete extends Completable {
    public final Predicate<? super Throwable> predicate;
    public final CompletableSource source;

    /* loaded from: classes.dex */
    public final class OnError implements CompletableObserver {
        public final CompletableObserver downstream;

        public OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            CompletableObserver completableObserver = this.downstream;
            try {
                if (CompletableOnErrorComplete.this.predicate.test(th)) {
                    completableObserver.onComplete();
                } else {
                    completableObserver.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                completableObserver.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }

    public CompletableOnErrorComplete(Completable completable) {
        Functions.TruePredicate truePredicate = Functions.ALWAYS_TRUE;
        this.source = completable;
        this.predicate = truePredicate;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new OnError(completableObserver));
    }
}
