package com.animaconnected.watch.fitness;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetTotalStandsIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetTotalStandsIntervaled {
    private final long interval_index;
    private final Integer total_stands;

    public GetTotalStandsIntervaled(long j, Integer num) {
        this.interval_index = j;
        this.total_stands = num;
    }

    public static /* synthetic */ GetTotalStandsIntervaled copy$default(GetTotalStandsIntervaled getTotalStandsIntervaled, long j, Integer num, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getTotalStandsIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            num = getTotalStandsIntervaled.total_stands;
        }
        return getTotalStandsIntervaled.copy(j, num);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Integer component2() {
        return this.total_stands;
    }

    public final GetTotalStandsIntervaled copy(long j, Integer num) {
        return new GetTotalStandsIntervaled(j, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTotalStandsIntervaled)) {
            return false;
        }
        GetTotalStandsIntervaled getTotalStandsIntervaled = (GetTotalStandsIntervaled) obj;
        if (this.interval_index == getTotalStandsIntervaled.interval_index && Intrinsics.areEqual(this.total_stands, getTotalStandsIntervaled.total_stands)) {
            return true;
        }
        return false;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public final Integer getTotal_stands() {
        return this.total_stands;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Integer num = this.total_stands;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetTotalStandsIntervaled(interval_index=");
        sb.append(this.interval_index);
        sb.append(", total_stands=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.total_stands, ')');
    }
}
