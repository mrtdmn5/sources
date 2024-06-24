package com.animaconnected.watch.workout.utils;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;

/* compiled from: BMRUtils.kt */
/* loaded from: classes3.dex */
public final class BmrProfile {
    private final int age;
    private final int height;
    private final boolean isMale;
    private final int weight;

    public BmrProfile(int r1, int r2, int r3, boolean z) {
        this.weight = r1;
        this.height = r2;
        this.age = r3;
        this.isMale = z;
    }

    public static /* synthetic */ BmrProfile copy$default(BmrProfile bmrProfile, int r1, int r2, int r3, boolean z, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = bmrProfile.weight;
        }
        if ((r5 & 2) != 0) {
            r2 = bmrProfile.height;
        }
        if ((r5 & 4) != 0) {
            r3 = bmrProfile.age;
        }
        if ((r5 & 8) != 0) {
            z = bmrProfile.isMale;
        }
        return bmrProfile.copy(r1, r2, r3, z);
    }

    public final int component1() {
        return this.weight;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.age;
    }

    public final boolean component4() {
        return this.isMale;
    }

    public final BmrProfile copy(int r2, int r3, int r4, boolean z) {
        return new BmrProfile(r2, r3, r4, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BmrProfile)) {
            return false;
        }
        BmrProfile bmrProfile = (BmrProfile) obj;
        if (this.weight == bmrProfile.weight && this.height == bmrProfile.height && this.age == bmrProfile.age && this.isMale == bmrProfile.isMale) {
            return true;
        }
        return false;
    }

    public final int getAge() {
        return this.age;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isMale) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.age, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.height, Integer.hashCode(this.weight) * 31, 31), 31);
    }

    public final boolean isMale() {
        return this.isMale;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BmrProfile(weight=");
        sb.append(this.weight);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", age=");
        sb.append(this.age);
        sb.append(", isMale=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isMale, ')');
    }
}
