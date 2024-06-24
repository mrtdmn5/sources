package com.animaconnected.msgpack;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class ByteValue extends Value {

    /* renamed from: byte, reason: not valid java name */
    private final byte f16byte;

    public ByteValue(byte b) {
        super(null);
        this.f16byte = b;
    }

    public static /* synthetic */ ByteValue copy$default(ByteValue byteValue, byte b, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            b = byteValue.f16byte;
        }
        return byteValue.copy(b);
    }

    public final byte component1() {
        return this.f16byte;
    }

    public final ByteValue copy(byte b) {
        return new ByteValue(b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ByteValue) && this.f16byte == ((ByteValue) obj).f16byte) {
            return true;
        }
        return false;
    }

    public final byte getByte() {
        return this.f16byte;
    }

    public int hashCode() {
        return Byte.hashCode(this.f16byte);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("ByteValue(byte="), this.f16byte, ')');
    }
}
