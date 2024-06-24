package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class SerializedSubject<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
    public final Subject<T> actual;
    public volatile boolean done;
    public boolean emitting;
    public AppendOnlyLinkedArrayList<Object> queue;

    public SerializedSubject(Subject<T> subject) {
        this.actual = subject;
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
            this.done = true;
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(NotificationLite.complete());
                return;
            }
            this.emitting = true;
            this.actual.onComplete();
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
                    this.done = true;
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>();
                            this.queue = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.head[0] = NotificationLite.error(th);
                        return;
                    }
                    this.emitting = true;
                    z = false;
                }
                if (z) {
                    RxJavaPlugins.onError(th);
                } else {
                    this.actual.onError(th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        if (this.done) {
            return;
        }
        synchronized (this) {
            if (this.done) {
                return;
            }
            if (this.emitting) {
                AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.queue;
                if (appendOnlyLinkedArrayList2 == null) {
                    appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>();
                    this.queue = appendOnlyLinkedArrayList2;
                }
                appendOnlyLinkedArrayList2.add(NotificationLite.next(t));
                return;
            }
            this.emitting = true;
            this.actual.onNext(t);
            while (true) {
                synchronized (this) {
                    appendOnlyLinkedArrayList = this.queue;
                    if (appendOnlyLinkedArrayList == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                appendOnlyLinkedArrayList.forEachWhile(this);
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        boolean z = true;
        if (!this.done) {
            synchronized (this) {
                if (!this.done) {
                    if (this.emitting) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList2 = this.queue;
                        if (appendOnlyLinkedArrayList2 == null) {
                            appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>();
                            this.queue = appendOnlyLinkedArrayList2;
                        }
                        appendOnlyLinkedArrayList2.add(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.emitting = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
            return;
        }
        this.actual.onSubscribe(disposable);
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.actual.subscribe(observer);
    }

    @Override // io.reactivex.functions.Predicate
    public final boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.actual);
    }
}
