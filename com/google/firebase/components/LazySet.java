package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class LazySet<T> implements Provider<Set<T>> {
    public volatile Set<T> actualSet = null;
    public volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());

    public LazySet(Collection<Provider<T>> collection) {
        this.providers.addAll(collection);
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        if (this.actualSet == null) {
            synchronized (this) {
                if (this.actualSet == null) {
                    this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                    synchronized (this) {
                        Iterator<Provider<T>> it = this.providers.iterator();
                        while (it.hasNext()) {
                            this.actualSet.add(it.next().get());
                        }
                        this.providers = null;
                    }
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }
}
