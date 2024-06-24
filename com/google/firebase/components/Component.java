package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Component<T> {
    public final Set<Dependency> dependencies;
    public final ComponentFactory<T> factory;
    public final int instantiation;
    public final String name;
    public final Set<Qualified<? super T>> providedInterfaces;
    public final Set<Class<?>> publishedEvents;
    public final int type;

    /* loaded from: classes3.dex */
    public static class Builder<T> {
        public final HashSet dependencies;
        public ComponentFactory<T> factory;
        public int instantiation;
        public String name = null;
        public final HashSet providedInterfaces;
        public final HashSet publishedEvents;
        public int type;

        public Builder(Class cls, Class[] clsArr) {
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            hashSet.add(Qualified.unqualified(cls));
            for (Class cls2 : clsArr) {
                if (cls2 != null) {
                    this.providedInterfaces.add(Qualified.unqualified(cls2));
                } else {
                    throw new NullPointerException("Null interface");
                }
            }
        }

        public final void add(Dependency dependency) {
            if (!this.providedInterfaces.contains(dependency.anInterface)) {
                this.dependencies.add(dependency);
                return;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public final Component<T> build() {
            boolean z;
            if (this.factory != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new Component<>(this.name, new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public final void setInstantiation(int r2) {
            boolean z;
            if (this.instantiation == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.instantiation = r2;
                return;
            }
            throw new IllegalStateException("Instantiation type has already been set.");
        }
    }

    public Component(String str, Set<Qualified<? super T>> set, Set<Dependency> set2, int r4, int r5, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.name = str;
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = r4;
        this.type = r5;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t, Class<T> cls, Class<? super T>... clsArr) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        hashSet.add(Qualified.unqualified(cls));
        for (Class<? super T> cls2 : clsArr) {
            if (cls2 != null) {
                hashSet.add(Qualified.unqualified(cls2));
            } else {
                throw new NullPointerException("Null interface");
            }
        }
        return new Component<>(null, new HashSet(hashSet), new HashSet(hashSet2), 0, 0, new Component$$ExternalSyntheticLambda0(t), hashSet3);
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }
}
