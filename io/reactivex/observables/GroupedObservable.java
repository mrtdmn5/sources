package io.reactivex.observables;

import io.reactivex.Observable;

/* loaded from: classes.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    public final K key;

    public GroupedObservable(K k) {
        this.key = k;
    }
}
