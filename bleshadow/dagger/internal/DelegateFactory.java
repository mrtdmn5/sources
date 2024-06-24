package bleshadow.dagger.internal;

import bleshadow.javax.inject.Provider;

/* loaded from: classes.dex */
public final class DelegateFactory<T> implements Provider {
    public Provider<T> delegate;

    @Override // bleshadow.javax.inject.Provider
    public final T get() {
        Provider<T> provider = this.delegate;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }
}
