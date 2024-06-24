package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {
    public volatile boolean done;
    public final Observer<? super T> downstream;
    public boolean emitting;
    public AppendOnlyLinkedArrayList<Object> queue;
    public Disposable upstream;

    public SerializedObserver(Observer<? super T> observer) {
        this.downstream = observer;
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
        if (this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.complete());
                return;
            }
            this.done = true;
            this.emitting = true;
            this.downstream.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
            return;
        }
        synchronized (this) {
            try {
                boolean z = true;
                if (!this.done) {
                    if (this.emitting) {
                        this.done = true;
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.head[0] = NotificationLite.error(th);
                        return;
                    }
                    this.done = true;
                    this.emitting = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        boolean z;
        Object[] objArr;
        if (this.done) {
            return;
        }
        if (t == null) {
            this.upstream.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            this.downstream.onNext(t);
            do {
                synchronized (this) {
                    AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.queue;
                    z = false;
                    if (appendOnlyLinkedArrayList2 == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                    Observer<? super T> observer = this.downstream;
                    Object[] objArr2 = appendOnlyLinkedArrayList2.head;
                    while (true) {
                        if (objArr2 == null) {
                            break;
                        }
                        for (int r3 = 0; r3 < 4 && (objArr = objArr2[r3]) != null; r3++) {
                            if (NotificationLite.acceptFull(objArr, observer)) {
                                z = true;
                                break;
                            }
                        }
                        objArr2 = objArr2[4];
                    }
                }
            } while (!z);
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
