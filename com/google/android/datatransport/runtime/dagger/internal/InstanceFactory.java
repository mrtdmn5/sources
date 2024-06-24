package com.google.android.datatransport.runtime.dagger.internal;

/* loaded from: classes3.dex */
public final class InstanceFactory<T> implements Factory<T> {
    public final T instance;

    public InstanceFactory(T t) {
        this.instance = t;
    }

    @Override // javax.inject.Provider
    public final T get() {
        return this.instance;
    }
}
