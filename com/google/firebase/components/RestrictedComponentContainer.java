package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class RestrictedComponentContainer implements ComponentContainer {
    public final Set<Qualified<?>> allowedDeferredInterfaces;
    public final Set<Qualified<?>> allowedDirectInterfaces;
    public final Set<Qualified<?>> allowedProviderInterfaces;
    public final Set<Class<?>> allowedPublishedEvents;
    public final Set<Qualified<?>> allowedSetDirectInterfaces;
    public final Set<Qualified<?>> allowedSetProviderInterfaces;
    public final ComponentContainer delegateContainer;

    /* loaded from: classes3.dex */
    public static class RestrictedPublisher implements Publisher {
        public final Set<Class<?>> allowedPublishedEvents;
        public final Publisher delegate;

        public RestrictedPublisher(Set<Class<?>> set, Publisher publisher) {
            this.allowedPublishedEvents = set;
            this.delegate = publisher;
        }
    }

    public RestrictedComponentContainer(Component component, ComponentRuntime componentRuntime) {
        boolean z;
        boolean z2;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.dependencies) {
            int r7 = dependency.injection;
            if (r7 == 0) {
                z = true;
            } else {
                z = false;
            }
            int r12 = dependency.type;
            Qualified<?> qualified = dependency.anInterface;
            if (z) {
                if (r12 == 2) {
                    hashSet4.add(qualified);
                } else {
                    hashSet.add(qualified);
                }
            } else {
                if (r7 == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    hashSet3.add(qualified);
                } else if (r12 == 2) {
                    hashSet5.add(qualified);
                } else {
                    hashSet2.add(qualified);
                }
            }
        }
        Set<Class<?>> set = component.publishedEvents;
        if (!set.isEmpty()) {
            hashSet.add(Qualified.unqualified(Publisher.class));
        }
        this.allowedDirectInterfaces = Collections.unmodifiableSet(hashSet);
        this.allowedProviderInterfaces = Collections.unmodifiableSet(hashSet2);
        this.allowedDeferredInterfaces = Collections.unmodifiableSet(hashSet3);
        this.allowedSetDirectInterfaces = Collections.unmodifiableSet(hashSet4);
        this.allowedSetProviderInterfaces = Collections.unmodifiableSet(hashSet5);
        this.allowedPublishedEvents = set;
        this.delegateContainer = componentRuntime;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> T get(Class<T> cls) {
        if (this.allowedDirectInterfaces.contains(Qualified.unqualified(cls))) {
            T t = (T) this.delegateContainer.get(cls);
            return !cls.equals(Publisher.class) ? t : (T) new RestrictedPublisher(this.allowedPublishedEvents, (Publisher) t);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    public final <T> Deferred<T> getDeferred(Class<T> cls) {
        return getDeferred(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Provider<T> getProvider(Class<T> cls) {
        return getProvider(Qualified.unqualified(cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Set<T> setOf(Qualified<T> qualified) {
        if (this.allowedSetDirectInterfaces.contains(qualified)) {
            return this.delegateContainer.setOf(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        if (this.allowedSetProviderInterfaces.contains(qualified)) {
            return this.delegateContainer.setOfProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        if (this.allowedDeferredInterfaces.contains(qualified)) {
            return this.delegateContainer.getDeferred(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> Provider<T> getProvider(Qualified<T> qualified) {
        if (this.allowedProviderInterfaces.contains(qualified)) {
            return this.delegateContainer.getProvider(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", qualified));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final <T> T get(Qualified<T> qualified) {
        if (this.allowedDirectInterfaces.contains(qualified)) {
            return (T) this.delegateContainer.get(qualified);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", qualified));
    }
}
