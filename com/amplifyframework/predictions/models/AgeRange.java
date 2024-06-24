package com.amplifyframework.predictions.models;

/* loaded from: classes.dex */
public final class AgeRange {
    private final int high;
    private final int low;

    public AgeRange(int r1, int r2) {
        if (r2 >= r1) {
            this.low = r1;
            this.high = r2;
            return;
        }
        throw new IllegalArgumentException("Low cannot be higher than High.");
    }

    public boolean contains(int r2) {
        if (r2 >= this.low && r2 <= this.high) {
            return true;
        }
        return false;
    }

    public int getHigh() {
        return this.high;
    }

    public int getLow() {
        return this.low;
    }
}
