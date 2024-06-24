package com.animaconnected.msgpack;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class IntegerValue extends Value {
    private final int integer;

    public IntegerValue(int r2) {
        super(null);
        this.integer = r2;
    }

    public static /* synthetic */ IntegerValue copy$default(IntegerValue integerValue, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = integerValue.integer;
        }
        return integerValue.copy(r1);
    }

    public final int component1() {
        return this.integer;
    }

    public final IntegerValue copy(int r2) {
        return new IntegerValue(r2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof IntegerValue) && this.integer == ((IntegerValue) obj).integer) {
            return true;
        }
        return false;
    }

    public final int getInteger() {
        return this.integer;
    }

    public int hashCode() {
        return Integer.hashCode(this.integer);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("IntegerValue(integer="), this.integer, ')');
    }
}
