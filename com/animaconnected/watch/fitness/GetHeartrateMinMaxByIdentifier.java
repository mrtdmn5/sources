package com.animaconnected.watch.fitness;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetHeartrateMinMaxByIdentifier.kt */
/* loaded from: classes3.dex */
public final class GetHeartrateMinMaxByIdentifier {
    private final Integer highMax;
    private final Integer lowMin;

    public GetHeartrateMinMaxByIdentifier(Integer num, Integer num2) {
        this.lowMin = num;
        this.highMax = num2;
    }

    public static /* synthetic */ GetHeartrateMinMaxByIdentifier copy$default(GetHeartrateMinMaxByIdentifier getHeartrateMinMaxByIdentifier, Integer num, Integer num2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            num = getHeartrateMinMaxByIdentifier.lowMin;
        }
        if ((r3 & 2) != 0) {
            num2 = getHeartrateMinMaxByIdentifier.highMax;
        }
        return getHeartrateMinMaxByIdentifier.copy(num, num2);
    }

    public final Integer component1() {
        return this.lowMin;
    }

    public final Integer component2() {
        return this.highMax;
    }

    public final GetHeartrateMinMaxByIdentifier copy(Integer num, Integer num2) {
        return new GetHeartrateMinMaxByIdentifier(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetHeartrateMinMaxByIdentifier)) {
            return false;
        }
        GetHeartrateMinMaxByIdentifier getHeartrateMinMaxByIdentifier = (GetHeartrateMinMaxByIdentifier) obj;
        if (Intrinsics.areEqual(this.lowMin, getHeartrateMinMaxByIdentifier.lowMin) && Intrinsics.areEqual(this.highMax, getHeartrateMinMaxByIdentifier.highMax)) {
            return true;
        }
        return false;
    }

    public final Integer getHighMax() {
        return this.highMax;
    }

    public final Integer getLowMin() {
        return this.lowMin;
    }

    public int hashCode() {
        int hashCode;
        Integer num = this.lowMin;
        int r1 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = hashCode * 31;
        Integer num2 = this.highMax;
        if (num2 != null) {
            r1 = num2.hashCode();
        }
        return r0 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetHeartrateMinMaxByIdentifier(lowMin=");
        sb.append(this.lowMin);
        sb.append(", highMax=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.highMax, ')');
    }
}
