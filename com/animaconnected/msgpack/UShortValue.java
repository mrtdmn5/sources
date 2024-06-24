package com.animaconnected.msgpack;

import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class UShortValue extends Value {
    private final short ushort;

    public /* synthetic */ UShortValue(short s, DefaultConstructorMarker defaultConstructorMarker) {
        this(s);
    }

    /* renamed from: copy-xj2QHRw$default, reason: not valid java name */
    public static /* synthetic */ UShortValue m766copyxj2QHRw$default(UShortValue uShortValue, short s, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            s = uShortValue.ushort;
        }
        return uShortValue.m768copyxj2QHRw(s);
    }

    /* renamed from: component1-Mh2AYeg, reason: not valid java name */
    public final short m767component1Mh2AYeg() {
        return this.ushort;
    }

    /* renamed from: copy-xj2QHRw, reason: not valid java name */
    public final UShortValue m768copyxj2QHRw(short s) {
        return new UShortValue(s, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UShortValue) && this.ushort == ((UShortValue) obj).ushort) {
            return true;
        }
        return false;
    }

    /* renamed from: getUshort-Mh2AYeg, reason: not valid java name */
    public final short m769getUshortMh2AYeg() {
        return this.ushort;
    }

    public int hashCode() {
        return Short.hashCode(this.ushort);
    }

    public String toString() {
        return "UShortValue(ushort=" + ((Object) UShort.m1665toStringimpl(this.ushort)) + ')';
    }

    private UShortValue(short s) {
        super(null);
        this.ushort = s;
    }
}
