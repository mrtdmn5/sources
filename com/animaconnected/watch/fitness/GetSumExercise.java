package com.animaconnected.watch.fitness;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetSumExercise.kt */
/* loaded from: classes3.dex */
public final class GetSumExercise {
    private final Integer SUM;

    public GetSumExercise(Integer num) {
        this.SUM = num;
    }

    public static /* synthetic */ GetSumExercise copy$default(GetSumExercise getSumExercise, Integer num, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            num = getSumExercise.SUM;
        }
        return getSumExercise.copy(num);
    }

    public final Integer component1() {
        return this.SUM;
    }

    public final GetSumExercise copy(Integer num) {
        return new GetSumExercise(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetSumExercise) && Intrinsics.areEqual(this.SUM, ((GetSumExercise) obj).SUM)) {
            return true;
        }
        return false;
    }

    public final Integer getSUM() {
        return this.SUM;
    }

    public int hashCode() {
        Integer num = this.SUM;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return NoProxyHost$$ExternalSyntheticOutline0.m(new StringBuilder("GetSumExercise(SUM="), this.SUM, ')');
    }
}
