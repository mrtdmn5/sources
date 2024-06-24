package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* loaded from: classes3.dex */
public final class Lazy<T> implements Provider<T> {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance = UNINITIALIZED;
    public volatile Provider<T> provider;

    public Lazy(Provider<T> provider) {
        this.provider = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public final T get() {
        T t = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }
}
