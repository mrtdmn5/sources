package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class Heights {
    public static final int $stable = 8;
    private float lastCardPx;
    private float topBarPx;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Heights() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.Heights.<init>():void");
    }

    public static /* synthetic */ Heights copy$default(Heights heights, float f, float f2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            f = heights.topBarPx;
        }
        if ((r3 & 2) != 0) {
            f2 = heights.lastCardPx;
        }
        return heights.copy(f, f2);
    }

    public final float component1() {
        return this.topBarPx;
    }

    public final float component2() {
        return this.lastCardPx;
    }

    public final Heights copy(float f, float f2) {
        return new Heights(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Heights)) {
            return false;
        }
        Heights heights = (Heights) obj;
        if (Float.compare(this.topBarPx, heights.topBarPx) == 0 && Float.compare(this.lastCardPx, heights.lastCardPx) == 0) {
            return true;
        }
        return false;
    }

    public final float getLastCardPx() {
        return this.lastCardPx;
    }

    public final float getTopBarPx() {
        return this.topBarPx;
    }

    public int hashCode() {
        return Float.hashCode(this.lastCardPx) + (Float.hashCode(this.topBarPx) * 31);
    }

    public final void setLastCardPx(float f) {
        this.lastCardPx = f;
    }

    public final void setTopBarPx(float f) {
        this.topBarPx = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Heights(topBarPx=");
        sb.append(this.topBarPx);
        sb.append(", lastCardPx=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.lastCardPx, ')');
    }

    public Heights(float f, float f2) {
        this.topBarPx = f;
        this.lastCardPx = f2;
    }

    public /* synthetic */ Heights(float f, float f2, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? 0.0f : f, (r4 & 2) != 0 ? 0.0f : f2);
    }
}
