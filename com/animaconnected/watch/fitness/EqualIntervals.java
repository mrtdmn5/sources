package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: TimePeriod.kt */
/* loaded from: classes3.dex */
public final class EqualIntervals extends EntriesAmount {
    private final int amountOfEntries;

    public EqualIntervals(int r2) {
        super(null);
        this.amountOfEntries = r2;
    }

    public static /* synthetic */ EqualIntervals copy$default(EqualIntervals equalIntervals, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = equalIntervals.amountOfEntries;
        }
        return equalIntervals.copy(r1);
    }

    public final int component1() {
        return this.amountOfEntries;
    }

    public final EqualIntervals copy(int r2) {
        return new EqualIntervals(r2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof EqualIntervals) && this.amountOfEntries == ((EqualIntervals) obj).amountOfEntries) {
            return true;
        }
        return false;
    }

    public final int getAmountOfEntries() {
        return this.amountOfEntries;
    }

    public int hashCode() {
        return Integer.hashCode(this.amountOfEntries);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("EqualIntervals(amountOfEntries="), this.amountOfEntries, ')');
    }
}
