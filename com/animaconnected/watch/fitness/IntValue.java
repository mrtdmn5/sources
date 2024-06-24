package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: FitnessMetric.kt */
/* loaded from: classes3.dex */
public final class IntValue extends MetricValue {
    private final int value;

    public IntValue(int r2) {
        super(null);
        this.value = r2;
    }

    public static /* synthetic */ IntValue copy$default(IntValue intValue, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = intValue.value;
        }
        return intValue.copy(r1);
    }

    public final int component1() {
        return this.value;
    }

    public final IntValue copy(int r2) {
        return new IntValue(r2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof IntValue) && this.value == ((IntValue) obj).value) {
            return true;
        }
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return Integer.hashCode(this.value);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("IntValue(value="), this.value, ')');
    }
}
