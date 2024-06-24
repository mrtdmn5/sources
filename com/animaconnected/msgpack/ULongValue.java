package com.animaconnected.msgpack;

import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class ULongValue extends Value {
    private final long ulong;

    public /* synthetic */ ULongValue(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    /* renamed from: copy-VKZWuLQ$default, reason: not valid java name */
    public static /* synthetic */ ULongValue m762copyVKZWuLQ$default(ULongValue uLongValue, long j, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            j = uLongValue.ulong;
        }
        return uLongValue.m764copyVKZWuLQ(j);
    }

    /* renamed from: component1-s-VKNKU, reason: not valid java name */
    public final long m763component1sVKNKU() {
        return this.ulong;
    }

    /* renamed from: copy-VKZWuLQ, reason: not valid java name */
    public final ULongValue m764copyVKZWuLQ(long j) {
        return new ULongValue(j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ULongValue) && this.ulong == ((ULongValue) obj).ulong) {
            return true;
        }
        return false;
    }

    /* renamed from: getUlong-s-VKNKU, reason: not valid java name */
    public final long m765getUlongsVKNKU() {
        return this.ulong;
    }

    public int hashCode() {
        return Long.hashCode(this.ulong);
    }

    public String toString() {
        return "ULongValue(ulong=" + ((Object) UnsignedKt.ulongToString(10, this.ulong)) + ')';
    }

    private ULongValue(long j) {
        super(null);
        this.ulong = j;
    }
}
