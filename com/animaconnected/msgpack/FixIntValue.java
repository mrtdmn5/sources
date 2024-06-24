package com.animaconnected.msgpack;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class FixIntValue extends Value {

    /* renamed from: byte, reason: not valid java name */
    private final byte f18byte;

    public FixIntValue(byte b) {
        super(null);
        this.f18byte = b;
    }

    public static /* synthetic */ FixIntValue copy$default(FixIntValue fixIntValue, byte b, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            b = fixIntValue.f18byte;
        }
        return fixIntValue.copy(b);
    }

    public final byte component1() {
        return this.f18byte;
    }

    public final FixIntValue copy(byte b) {
        return new FixIntValue(b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FixIntValue) && this.f18byte == ((FixIntValue) obj).f18byte) {
            return true;
        }
        return false;
    }

    public final byte getByte() {
        return this.f18byte;
    }

    public int hashCode() {
        return Byte.hashCode(this.f18byte);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("FixIntValue(byte="), this.f18byte, ')');
    }
}
