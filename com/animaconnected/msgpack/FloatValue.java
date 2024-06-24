package com.animaconnected.msgpack;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class FloatValue extends Value {

    /* renamed from: float, reason: not valid java name */
    private final float f19float;

    public FloatValue(float f) {
        super(null);
        this.f19float = f;
    }

    public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, float f, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            f = floatValue.f19float;
        }
        return floatValue.copy(f);
    }

    public final float component1() {
        return this.f19float;
    }

    public final FloatValue copy(float f) {
        return new FloatValue(f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FloatValue) && Float.compare(this.f19float, ((FloatValue) obj).f19float) == 0) {
            return true;
        }
        return false;
    }

    public final float getFloat() {
        return this.f19float;
    }

    public int hashCode() {
        return Float.hashCode(this.f19float);
    }

    public String toString() {
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("FloatValue(float="), this.f19float, ')');
    }
}
