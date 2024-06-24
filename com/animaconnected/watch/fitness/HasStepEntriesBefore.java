package com.animaconnected.watch.fitness;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;

/* compiled from: HasStepEntriesBefore.kt */
/* loaded from: classes3.dex */
public final class HasStepEntriesBefore {
    private final boolean run;
    private final boolean walk;

    public HasStepEntriesBefore(boolean z, boolean z2) {
        this.walk = z;
        this.run = z2;
    }

    public static /* synthetic */ HasStepEntriesBefore copy$default(HasStepEntriesBefore hasStepEntriesBefore, boolean z, boolean z2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            z = hasStepEntriesBefore.walk;
        }
        if ((r3 & 2) != 0) {
            z2 = hasStepEntriesBefore.run;
        }
        return hasStepEntriesBefore.copy(z, z2);
    }

    public final boolean component1() {
        return this.walk;
    }

    public final boolean component2() {
        return this.run;
    }

    public final HasStepEntriesBefore copy(boolean z, boolean z2) {
        return new HasStepEntriesBefore(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HasStepEntriesBefore)) {
            return false;
        }
        HasStepEntriesBefore hasStepEntriesBefore = (HasStepEntriesBefore) obj;
        if (this.walk == hasStepEntriesBefore.walk && this.run == hasStepEntriesBefore.run) {
            return true;
        }
        return false;
    }

    public final boolean getRun() {
        return this.run;
    }

    public final boolean getWalk() {
        return this.walk;
    }

    public int hashCode() {
        return Boolean.hashCode(this.run) + (Boolean.hashCode(this.walk) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HasStepEntriesBefore(walk=");
        sb.append(this.walk);
        sb.append(", run=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.run, ')');
    }
}
