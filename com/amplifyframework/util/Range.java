package com.amplifyframework.util;

import java.lang.Comparable;

/* loaded from: classes.dex */
public final class Range<T extends Comparable<T>> {
    private final T high;
    private final T low;

    public Range(T t, T t2) throws IllegalArgumentException {
        if (t.compareTo(t2) <= 0) {
            this.low = t;
            this.high = t2;
            return;
        }
        throw new IllegalArgumentException("Low value should be lower than high");
    }

    public boolean contains(T t) {
        if (t.compareTo(this.low) >= 0 && t.compareTo(this.high) <= 0) {
            return true;
        }
        return false;
    }
}
