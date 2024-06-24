package com.animaconnected.msgpack;

import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class UIntegerValue extends Value {
    private final int uinteger;

    public /* synthetic */ UIntegerValue(int r1, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1);
    }

    /* renamed from: copy-WZ4Q5Ns$default, reason: not valid java name */
    public static /* synthetic */ UIntegerValue m758copyWZ4Q5Ns$default(UIntegerValue uIntegerValue, int r1, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            r1 = uIntegerValue.uinteger;
        }
        return uIntegerValue.m760copyWZ4Q5Ns(r1);
    }

    /* renamed from: component1-pVg5ArA, reason: not valid java name */
    public final int m759component1pVg5ArA() {
        return this.uinteger;
    }

    /* renamed from: copy-WZ4Q5Ns, reason: not valid java name */
    public final UIntegerValue m760copyWZ4Q5Ns(int r3) {
        return new UIntegerValue(r3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof UIntegerValue) && this.uinteger == ((UIntegerValue) obj).uinteger) {
            return true;
        }
        return false;
    }

    /* renamed from: getUinteger-pVg5ArA, reason: not valid java name */
    public final int m761getUintegerpVg5ArA() {
        return this.uinteger;
    }

    public int hashCode() {
        return Integer.hashCode(this.uinteger);
    }

    public String toString() {
        return "UIntegerValue(uinteger=" + ((Object) UInt.m1664toStringimpl(this.uinteger)) + ')';
    }

    private UIntegerValue(int r2) {
        super(null);
        this.uinteger = r2;
    }
}
