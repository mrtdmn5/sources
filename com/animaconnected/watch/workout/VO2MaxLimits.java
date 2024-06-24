package com.animaconnected.watch.workout;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: FitnessIndex.kt */
/* loaded from: classes3.dex */
public final class VO2MaxLimits {
    private final int excellent;
    private final int fair;
    private final int good;
    private final int superior;

    public VO2MaxLimits(int r1, int r2, int r3, int r4) {
        this.superior = r1;
        this.excellent = r2;
        this.good = r3;
        this.fair = r4;
    }

    public static /* synthetic */ VO2MaxLimits copy$default(VO2MaxLimits vO2MaxLimits, int r1, int r2, int r3, int r4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = vO2MaxLimits.superior;
        }
        if ((r5 & 2) != 0) {
            r2 = vO2MaxLimits.excellent;
        }
        if ((r5 & 4) != 0) {
            r3 = vO2MaxLimits.good;
        }
        if ((r5 & 8) != 0) {
            r4 = vO2MaxLimits.fair;
        }
        return vO2MaxLimits.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.superior;
    }

    public final int component2() {
        return this.excellent;
    }

    public final int component3() {
        return this.good;
    }

    public final int component4() {
        return this.fair;
    }

    public final VO2MaxLimits copy(int r2, int r3, int r4, int r5) {
        return new VO2MaxLimits(r2, r3, r4, r5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VO2MaxLimits)) {
            return false;
        }
        VO2MaxLimits vO2MaxLimits = (VO2MaxLimits) obj;
        if (this.superior == vO2MaxLimits.superior && this.excellent == vO2MaxLimits.excellent && this.good == vO2MaxLimits.good && this.fair == vO2MaxLimits.fair) {
            return true;
        }
        return false;
    }

    public final int getExcellent() {
        return this.excellent;
    }

    public final int getFair() {
        return this.fair;
    }

    public final int getGood() {
        return this.good;
    }

    public final int getSuperior() {
        return this.superior;
    }

    public int hashCode() {
        return Integer.hashCode(this.fair) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.good, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.excellent, Integer.hashCode(this.superior) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VO2MaxLimits(superior=");
        sb.append(this.superior);
        sb.append(", excellent=");
        sb.append(this.excellent);
        sb.append(", good=");
        sb.append(this.good);
        sb.append(", fair=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.fair, ')');
    }
}
