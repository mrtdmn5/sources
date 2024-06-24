package com.animaconnected.msgpack;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class ShortValue extends Value {

    /* renamed from: short, reason: not valid java name */
    private final short f21short;

    public ShortValue(short s) {
        super(null);
        this.f21short = s;
    }

    public static /* synthetic */ ShortValue copy$default(ShortValue shortValue, short s, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            s = shortValue.f21short;
        }
        return shortValue.copy(s);
    }

    public final short component1() {
        return this.f21short;
    }

    public final ShortValue copy(short s) {
        return new ShortValue(s);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ShortValue) && this.f21short == ((ShortValue) obj).f21short) {
            return true;
        }
        return false;
    }

    public final short getShort() {
        return this.f21short;
    }

    public int hashCode() {
        return Short.hashCode(this.f21short);
    }

    public String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("ShortValue(short="), this.f21short, ')');
    }
}
