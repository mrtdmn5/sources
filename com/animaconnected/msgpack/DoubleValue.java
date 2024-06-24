package com.animaconnected.msgpack;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class DoubleValue extends Value {

    /* renamed from: double, reason: not valid java name */
    private final double f17double;

    public DoubleValue(double d) {
        super(null);
        this.f17double = d;
    }

    public static /* synthetic */ DoubleValue copy$default(DoubleValue doubleValue, double d, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            d = doubleValue.f17double;
        }
        return doubleValue.copy(d);
    }

    public final double component1() {
        return this.f17double;
    }

    public final DoubleValue copy(double d) {
        return new DoubleValue(d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DoubleValue) && Double.compare(this.f17double, ((DoubleValue) obj).f17double) == 0) {
            return true;
        }
        return false;
    }

    public final double getDouble() {
        return this.f17double;
    }

    public int hashCode() {
        return Double.hashCode(this.f17double);
    }

    public String toString() {
        return "DoubleValue(double=" + this.f17double + ')';
    }
}
