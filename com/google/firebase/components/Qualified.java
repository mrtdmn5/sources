package com.google.firebase.components;

import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public final class Qualified<T> {
    public final Class<? extends Annotation> qualifier;
    public final Class<T> type;

    /* loaded from: classes3.dex */
    public @interface Unqualified {
    }

    public Qualified(Class<? extends Annotation> cls, Class<T> cls2) {
        this.qualifier = cls;
        this.type = cls2;
    }

    public static <T> Qualified<T> unqualified(Class<T> cls) {
        return new Qualified<>(Unqualified.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (!this.type.equals(qualified.type)) {
            return false;
        }
        return this.qualifier.equals(qualified.qualifier);
    }

    public final int hashCode() {
        return this.qualifier.hashCode() + (this.type.hashCode() * 31);
    }

    public final String toString() {
        Class<T> cls = this.type;
        Class<? extends Annotation> cls2 = this.qualifier;
        if (cls2 == Unqualified.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + " " + cls.getName();
    }
}
