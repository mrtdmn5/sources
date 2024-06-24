package com.jakewharton.rxrelay2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* loaded from: classes3.dex */
public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    public abstract boolean hasObservers();
}
