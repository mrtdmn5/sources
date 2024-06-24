package bleshadow.dagger.internal;

import bleshadow.dagger.Lazy;
import bleshadow.javax.inject.Provider;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Provider, Lazy<T> {
    public final T instance;

    public InstanceFactory(T t) {
        this.instance = t;
    }

    public static InstanceFactory create(Object obj) {
        if (obj != null) {
            return new InstanceFactory(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    @Override // bleshadow.javax.inject.Provider
    public final T get() {
        return this.instance;
    }
}
