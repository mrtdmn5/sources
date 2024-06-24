package com.animaconnected.msgpack;

import kotlin.UByte;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class UByteValue extends Value {
    private final byte ubyte;

    public /* synthetic */ UByteValue(byte b, DefaultConstructorMarker defaultConstructorMarker) {
        this(b);
    }

    /* renamed from: copy-7apg3OU$default, reason: not valid java name */
    public static /* synthetic */ UByteValue m754copy7apg3OU$default(UByteValue uByteValue, byte b, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            b = uByteValue.ubyte;
        }
        return uByteValue.m756copy7apg3OU(b);
    }

    /* renamed from: component1-w2LRezQ, reason: not valid java name */
    public final byte m755component1w2LRezQ() {
        return this.ubyte;
    }

    /* renamed from: copy-7apg3OU, reason: not valid java name */
    public final UByteValue m756copy7apg3OU(byte b) {
        return new UByteValue(b, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UByteValue) && this.ubyte == ((UByteValue) obj).ubyte) {
            return true;
        }
        return false;
    }

    /* renamed from: getUbyte-w2LRezQ, reason: not valid java name */
    public final byte m757getUbytew2LRezQ() {
        return this.ubyte;
    }

    public int hashCode() {
        return Byte.hashCode(this.ubyte);
    }

    public String toString() {
        return "UByteValue(ubyte=" + ((Object) UByte.m1663toStringimpl(this.ubyte)) + ')';
    }

    private UByteValue(byte b) {
        super(null);
        this.ubyte = b;
    }
}
