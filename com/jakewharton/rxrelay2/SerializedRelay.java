package com.jakewharton.rxrelay2;

import io.reactivex.Observer;

/* loaded from: classes3.dex */
public final class SerializedRelay<T> extends Relay<T> {
    public final Relay<T> actual;
    public boolean emitting;
    public AppendOnlyLinkedArrayList<T> queue;

    public SerializedRelay(PublishRelay publishRelay) {
        this.actual = publishRelay;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T t) {
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        synchronized (this) {
            try {
                int r1 = 0;
                if (this.emitting) {
                    AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList2 = this.queue;
                    if (appendOnlyLinkedArrayList2 == null) {
                        appendOnlyLinkedArrayList2 = new AppendOnlyLinkedArrayList<>();
                        this.queue = appendOnlyLinkedArrayList2;
                    }
                    int r4 = appendOnlyLinkedArrayList2.offset;
                    if (r4 == 4) {
                        Object[] objArr = new Object[5];
                        appendOnlyLinkedArrayList2.tail[4] = objArr;
                        appendOnlyLinkedArrayList2.tail = objArr;
                    } else {
                        r1 = r4;
                    }
                    appendOnlyLinkedArrayList2.tail[r1] = t;
                    appendOnlyLinkedArrayList2.offset = r1 + 1;
                    return;
                }
                this.emitting = true;
                this.actual.accept(t);
                while (true) {
                    synchronized (this) {
                        appendOnlyLinkedArrayList = this.queue;
                        if (appendOnlyLinkedArrayList == null) {
                            this.emitting = false;
                            return;
                        }
                        this.queue = null;
                    }
                    Relay<T> relay = this.actual;
                    for (Object[] objArr2 = appendOnlyLinkedArrayList.head; objArr2 != null; objArr2 = objArr2[4]) {
                        for (int r3 = 0; r3 < 4; r3++) {
                            Object[] objArr3 = objArr2[r3];
                            if (objArr3 == null) {
                                break;
                            }
                            relay.accept(objArr3);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public final boolean hasObservers() {
        return this.actual.hasObservers();
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.actual.subscribe(observer);
    }
}
