package com.animaconnected.secondo.screens.activity;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityViewModel.kt */
/* loaded from: classes3.dex */
public final class StepProgress {
    public static final int $stable = 0;
    private final int goal;
    private final String percentage;
    private final String progress;
    private final int steps;

    public StepProgress() {
        this(0, 0, null, null, 15, null);
    }

    public static /* synthetic */ StepProgress copy$default(StepProgress stepProgress, int r1, int r2, String str, String str2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            r1 = stepProgress.steps;
        }
        if ((r5 & 2) != 0) {
            r2 = stepProgress.goal;
        }
        if ((r5 & 4) != 0) {
            str = stepProgress.percentage;
        }
        if ((r5 & 8) != 0) {
            str2 = stepProgress.progress;
        }
        return stepProgress.copy(r1, r2, str, str2);
    }

    public final int component1() {
        return this.steps;
    }

    public final int component2() {
        return this.goal;
    }

    public final String component3() {
        return this.percentage;
    }

    public final String component4() {
        return this.progress;
    }

    public final StepProgress copy(int r2, int r3, String percentage, String progress) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(progress, "progress");
        return new StepProgress(r2, r3, percentage, progress);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepProgress)) {
            return false;
        }
        StepProgress stepProgress = (StepProgress) obj;
        if (this.steps == stepProgress.steps && this.goal == stepProgress.goal && Intrinsics.areEqual(this.percentage, stepProgress.percentage) && Intrinsics.areEqual(this.progress, stepProgress.progress)) {
            return true;
        }
        return false;
    }

    public final int getGoal() {
        return this.goal;
    }

    public final String getPercentage() {
        return this.percentage;
    }

    public final String getProgress() {
        return this.progress;
    }

    public final int getSteps() {
        return this.steps;
    }

    public int hashCode() {
        return this.progress.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.percentage, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.goal, Integer.hashCode(this.steps) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StepProgress(steps=");
        sb.append(this.steps);
        sb.append(", goal=");
        sb.append(this.goal);
        sb.append(", percentage=");
        sb.append(this.percentage);
        sb.append(", progress=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.progress, ')');
    }

    public StepProgress(int r2, int r3, String percentage, String progress) {
        Intrinsics.checkNotNullParameter(percentage, "percentage");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.steps = r2;
        this.goal = r3;
        this.percentage = percentage;
        this.progress = progress;
    }

    public /* synthetic */ StepProgress(int r2, int r3, String str, String str2, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0 : r2, (r6 & 2) != 0 ? 0 : r3, (r6 & 4) != 0 ? "" : str, (r6 & 8) != 0 ? "" : str2);
    }
}
