package io.reactivex.internal.operators.completable;

import com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda7;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class CompletableResumeNext extends Completable {
    public final Function<? super Throwable, ? extends CompletableSource> errorMapper;
    public final CompletableSource source;

    /* loaded from: classes.dex */
    public static final class ResumeNextObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        public final CompletableObserver downstream;
        public final Function<? super Throwable, ? extends CompletableSource> errorMapper;
        public boolean once;

        public ResumeNextObserver(CompletableObserver completableObserver, Function<? super Throwable, ? extends CompletableSource> function) {
            this.downstream = completableObserver;
            this.errorMapper = function;
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
            this.downstream.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public final void onError(Throwable th) {
            boolean z = this.once;
            CompletableObserver completableObserver = this.downstream;
            if (z) {
                completableObserver.onError(th);
                return;
            }
            this.once = true;
            try {
                CompletableSource apply = this.errorMapper.apply(th);
                ObjectHelper.requireNonNull(apply, "The errorMapper returned a null CompletableSource");
                apply.subscribe(this);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                completableObserver.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.CompletableObserver
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }

    public CompletableResumeNext(ObservableIgnoreElementsCompletable observableIgnoreElementsCompletable, NotificationAndIndicationManager$$ExternalSyntheticLambda7 notificationAndIndicationManager$$ExternalSyntheticLambda7) {
        this.source = observableIgnoreElementsCompletable;
        this.errorMapper = notificationAndIndicationManager$$ExternalSyntheticLambda7;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        ResumeNextObserver resumeNextObserver = new ResumeNextObserver(completableObserver, this.errorMapper);
        completableObserver.onSubscribe(resumeNextObserver);
        this.source.subscribe(resumeNextObserver);
    }
}
