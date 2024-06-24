package com.animaconnected.watch.fitness;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetTotalExerciseIntervaled.kt */
/* loaded from: classes3.dex */
public final class GetTotalExerciseIntervaled {
    private final long interval_index;
    private final Integer total_active_minutes;

    public GetTotalExerciseIntervaled(long j, Integer num) {
        this.interval_index = j;
        this.total_active_minutes = num;
    }

    public static /* synthetic */ GetTotalExerciseIntervaled copy$default(GetTotalExerciseIntervaled getTotalExerciseIntervaled, long j, Integer num, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            j = getTotalExerciseIntervaled.interval_index;
        }
        if ((r4 & 2) != 0) {
            num = getTotalExerciseIntervaled.total_active_minutes;
        }
        return getTotalExerciseIntervaled.copy(j, num);
    }

    public final long component1() {
        return this.interval_index;
    }

    public final Integer component2() {
        return this.total_active_minutes;
    }

    public final GetTotalExerciseIntervaled copy(long j, Integer num) {
        return new GetTotalExerciseIntervaled(j, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTotalExerciseIntervaled)) {
            return false;
        }
        GetTotalExerciseIntervaled getTotalExerciseIntervaled = (GetTotalExerciseIntervaled) obj;
        if (this.interval_index == getTotalExerciseIntervaled.interval_index && Intrinsics.areEqual(this.total_active_minutes, getTotalExerciseIntervaled.total_active_minutes)) {
            return true;
        }
        return false;
    }

    public final long getInterval_index() {
        return this.interval_index;
    }

    public final Integer getTotal_active_minutes() {
        return this.total_active_minutes;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Long.hashCode(this.interval_index) * 31;
        Integer num = this.total_active_minutes;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetTotalExerciseIntervaled(interval_index=");
        sb.append(this.interval_index);
        sb.append(", total_active_minutes=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.total_active_minutes, ')');
    }
}
