package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class Position {
    public static final int $stable = 8;
    private float bottom;
    private float metric;
    private float workout;

    public Position() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public static /* synthetic */ Position copy$default(Position position, float f, float f2, float f3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            f = position.workout;
        }
        if ((r4 & 2) != 0) {
            f2 = position.metric;
        }
        if ((r4 & 4) != 0) {
            f3 = position.bottom;
        }
        return position.copy(f, f2, f3);
    }

    public final float component1() {
        return this.workout;
    }

    public final float component2() {
        return this.metric;
    }

    public final float component3() {
        return this.bottom;
    }

    public final Position copy(float f, float f2, float f3) {
        return new Position(f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        Position position = (Position) obj;
        if (Float.compare(this.workout, position.workout) == 0 && Float.compare(this.metric, position.metric) == 0 && Float.compare(this.bottom, position.bottom) == 0) {
            return true;
        }
        return false;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getMetric() {
        return this.metric;
    }

    public final float getWorkout() {
        return this.workout;
    }

    public int hashCode() {
        return Float.hashCode(this.bottom) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.metric, Float.hashCode(this.workout) * 31, 31);
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final void setMetric(float f) {
        this.metric = f;
    }

    public final void setWorkout(float f) {
        this.workout = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Position(workout=");
        sb.append(this.workout);
        sb.append(", metric=");
        sb.append(this.metric);
        sb.append(", bottom=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.bottom, ')');
    }

    public Position(float f, float f2, float f3) {
        this.workout = f;
        this.metric = f2;
        this.bottom = f3;
    }

    public /* synthetic */ Position(float f, float f2, float f3, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this((r5 & 1) != 0 ? 0.0f : f, (r5 & 2) != 0 ? 0.0f : f2, (r5 & 4) != 0 ? 0.0f : f3);
    }
}
