package com.animaconnected.watch.fitness;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class UnknownDistance extends Distance {
    public static final UnknownDistance INSTANCE = new UnknownDistance();

    private UnknownDistance() {
        super(null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnknownDistance)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 10598098;
    }

    public String toString() {
        return "UnknownDistance";
    }
}
