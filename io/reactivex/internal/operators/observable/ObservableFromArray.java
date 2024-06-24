package io.reactivex.internal.operators.observable;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* loaded from: classes.dex */
public final class ObservableFromArray<T> extends Observable<T> {
    public final T[] array;

    /* loaded from: classes.dex */
    public static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        public final T[] array;
        public volatile boolean disposed;
        public final Observer<? super T> downstream;
        public boolean fusionMode;
        public int index;

        public FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.downstream = observer;
            this.array = tArr;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.index = this.array.length;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            if (this.index == this.array.length) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() {
            int r0 = this.index;
            T[] tArr = this.array;
            if (r0 != tArr.length) {
                this.index = r0 + 1;
                T t = tArr[r0];
                ObjectHelper.requireNonNull(t, "The array element is null");
                return t;
            }
            return null;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r2) {
            if ((r2 & 1) != 0) {
                this.fusionMode = true;
                return 1;
            }
            return 0;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        T[] tArr = this.array;
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, tArr);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.fusionMode) {
            return;
        }
        int length = tArr.length;
        for (int r2 = 0; r2 < length && !fromArrayDisposable.disposed; r2++) {
            T t = tArr[r2];
            if (t == null) {
                fromArrayDisposable.downstream.onError(new NullPointerException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("The element at index ", r2, " is null")));
                return;
            }
            fromArrayDisposable.downstream.onNext(t);
        }
        if (!fromArrayDisposable.disposed) {
            fromArrayDisposable.downstream.onComplete();
        }
    }
}
