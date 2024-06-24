package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes3.dex */
    public static final class Equals extends Equivalence<Object> implements Serializable {
        public static final Equals INSTANCE = new Equals();

        @Override // com.google.common.base.Equivalence
        public final boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        public final int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Identity extends Equivalence<Object> implements Serializable {
        public static final Identity INSTANCE = new Identity();

        @Override // com.google.common.base.Equivalence
        public final boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        public final int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    public abstract boolean doEquivalent(T t, T t2);

    public abstract int doHash(T t);

    public final boolean equivalent(T t, T t2) {
        if (t == t2) {
            return true;
        }
        if (t != null && t2 != null) {
            return doEquivalent(t, t2);
        }
        return false;
    }
}
