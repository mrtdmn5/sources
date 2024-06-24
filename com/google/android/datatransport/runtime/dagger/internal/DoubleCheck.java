package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DoubleCheck<T> implements Provider<T> {
    public static final Object UNINITIALIZED = new Object();
    public volatile Object instance = UNINITIALIZED;
    public volatile Provider<T> provider;

    public DoubleCheck(Factory factory) {
        this.provider = factory;
    }

    public static Provider provider(Factory factory) {
        if (factory instanceof DoubleCheck) {
            return factory;
        }
        return new DoubleCheck(factory);
    }

    @Override // javax.inject.Provider
    public final T get() {
        boolean z;
        T t = (T) this.instance;
        Object obj = UNINITIALIZED;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.instance;
                if (t == obj) {
                    t = this.provider.get();
                    Object obj2 = this.instance;
                    if (obj2 != obj) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && obj2 != t) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + t + ". This is likely due to a circular dependency.");
                    }
                    this.instance = t;
                    this.provider = null;
                }
            }
        }
        return t;
    }
}
