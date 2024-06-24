package com.animaconnected.msgpack;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class LongValue extends Value {

    /* renamed from: long, reason: not valid java name */
    private final long f20long;

    public LongValue(long j) {
        super(null);
        this.f20long = j;
    }

    public static /* synthetic */ LongValue copy$default(LongValue longValue, long j, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            j = longValue.f20long;
        }
        return longValue.copy(j);
    }

    public final long component1() {
        return this.f20long;
    }

    public final LongValue copy(long j) {
        return new LongValue(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof LongValue) && this.f20long == ((LongValue) obj).f20long) {
            return true;
        }
        return false;
    }

    public final long getLong() {
        return this.f20long;
    }

    public int hashCode() {
        return Long.hashCode(this.f20long);
    }

    public String toString() {
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(new StringBuilder("LongValue(long="), this.f20long, ')');
    }
}
