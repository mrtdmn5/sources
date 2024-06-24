package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: FitnessMetric.kt */
/* loaded from: classes3.dex */
public final class HeartrateValue extends MetricValue {
    private final int confidence;
    private final int heartrate;

    public HeartrateValue(int r2, int r3) {
        super(null);
        this.heartrate = r2;
        this.confidence = r3;
    }

    public static /* synthetic */ HeartrateValue copy$default(HeartrateValue heartrateValue, int r1, int r2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = heartrateValue.heartrate;
        }
        if ((r3 & 2) != 0) {
            r2 = heartrateValue.confidence;
        }
        return heartrateValue.copy(r1, r2);
    }

    public final int component1() {
        return this.heartrate;
    }

    public final int component2() {
        return this.confidence;
    }

    public final HeartrateValue copy(int r2, int r3) {
        return new HeartrateValue(r2, r3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartrateValue)) {
            return false;
        }
        HeartrateValue heartrateValue = (HeartrateValue) obj;
        if (this.heartrate == heartrateValue.heartrate && this.confidence == heartrateValue.confidence) {
            return true;
        }
        return false;
    }

    public final int getConfidence() {
        return this.confidence;
    }

    public final int getHeartrate() {
        return this.heartrate;
    }

    public int hashCode() {
        return Integer.hashCode(this.confidence) + (Integer.hashCode(this.heartrate) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HeartrateValue(heartrate=");
        sb.append(this.heartrate);
        sb.append(", confidence=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.confidence, ')');
    }
}
