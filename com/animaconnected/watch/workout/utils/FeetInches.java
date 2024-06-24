package com.animaconnected.watch.workout.utils;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: ProfileUtils.kt */
/* loaded from: classes3.dex */
public final class FeetInches {
    private final int feet;
    private final int inches;

    public FeetInches(int r1, int r2) {
        this.feet = r1;
        this.inches = r2;
    }

    public static /* synthetic */ FeetInches copy$default(FeetInches feetInches, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = feetInches.feet;
        }
        if ((r3 & 2) != 0) {
            r2 = feetInches.inches;
        }
        return feetInches.copy(r1, r2);
    }

    public final int component1() {
        return this.feet;
    }

    public final int component2() {
        return this.inches;
    }

    public final FeetInches copy(int r2, int r3) {
        return new FeetInches(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeetInches)) {
            return false;
        }
        FeetInches feetInches = (FeetInches) obj;
        if (this.feet == feetInches.feet && this.inches == feetInches.inches) {
            return true;
        }
        return false;
    }

    public final int getFeet() {
        return this.feet;
    }

    public final int getInches() {
        return this.inches;
    }

    public int hashCode() {
        return Integer.hashCode(this.inches) + (Integer.hashCode(this.feet) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FeetInches(feet=");
        sb.append(this.feet);
        sb.append(", inches=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.inches, ')');
    }
}
