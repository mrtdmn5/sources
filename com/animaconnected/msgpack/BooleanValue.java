package com.animaconnected.msgpack;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class BooleanValue extends Value {

    /* renamed from: boolean, reason: not valid java name */
    private final boolean f15boolean;

    public BooleanValue(boolean z) {
        super(null);
        this.f15boolean = z;
    }

    public static /* synthetic */ BooleanValue copy$default(BooleanValue booleanValue, boolean z, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            z = booleanValue.f15boolean;
        }
        return booleanValue.copy(z);
    }

    public final boolean component1() {
        return this.f15boolean;
    }

    public final BooleanValue copy(boolean z) {
        return new BooleanValue(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof BooleanValue) && this.f15boolean == ((BooleanValue) obj).f15boolean) {
            return true;
        }
        return false;
    }

    public final boolean getBoolean() {
        return this.f15boolean;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f15boolean);
    }

    public String toString() {
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("BooleanValue(boolean="), this.f15boolean, ')');
    }
}
