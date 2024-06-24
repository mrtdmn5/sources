package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* loaded from: classes.dex */
public final class MutablePair<T> {
    public T first;
    public T second;

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.first;
        if (f != obj2 && (f == 0 || !f.equals(obj2))) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        Object obj3 = this.second;
        S s = pair.second;
        if (s != obj3 && (s == 0 || !s.equals(obj3))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        T t = this.first;
        int r1 = 0;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        T t2 = this.second;
        if (t2 != null) {
            r1 = t2.hashCode();
        }
        return hashCode ^ r1;
    }

    public final String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
