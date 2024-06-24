package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Set;

/* loaded from: classes3.dex */
public interface ComponentContainer {
    default <T> T get(Class<T> cls) {
        return (T) get(Qualified.unqualified(cls));
    }

    <T> Deferred<T> getDeferred(Qualified<T> qualified);

    <T> Provider<T> getProvider(Qualified<T> qualified);

    default <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    default <T> Set<T> setOf(Qualified<T> qualified) {
        return setOfProvider(qualified).get();
    }

    <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified);

    default <T> T get(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return null;
        }
        return provider.get();
    }
}
