package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessData.kt */
/* loaded from: classes3.dex */
public final class SyncResult {
    private final String error;
    private final float percentage;
    private final SyncState state;

    public SyncResult(SyncState state, float f, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.percentage = f;
        this.error = str;
    }

    public static /* synthetic */ SyncResult copy$default(SyncResult syncResult, SyncState syncState, float f, String str, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            syncState = syncResult.state;
        }
        if ((r4 & 2) != 0) {
            f = syncResult.percentage;
        }
        if ((r4 & 4) != 0) {
            str = syncResult.error;
        }
        return syncResult.copy(syncState, f, str);
    }

    public final SyncState component1() {
        return this.state;
    }

    public final float component2() {
        return this.percentage;
    }

    public final String component3() {
        return this.error;
    }

    public final SyncResult copy(SyncState state, float f, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new SyncResult(state, f, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncResult)) {
            return false;
        }
        SyncResult syncResult = (SyncResult) obj;
        if (this.state == syncResult.state && Float.compare(this.percentage, syncResult.percentage) == 0 && Intrinsics.areEqual(this.error, syncResult.error)) {
            return true;
        }
        return false;
    }

    public final String getError() {
        return this.error;
    }

    public final float getPercentage() {
        return this.percentage;
    }

    public final SyncState getState() {
        return this.state;
    }

    public int hashCode() {
        int hashCode;
        int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.percentage, this.state.hashCode() * 31, 31);
        String str = this.error;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return m + hashCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SyncResult(state=");
        sb.append(this.state);
        sb.append(", percentage=");
        sb.append(this.percentage);
        sb.append(", error=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.error, ')');
    }

    public /* synthetic */ SyncResult(SyncState syncState, float f, String str, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(syncState, f, (r4 & 4) != 0 ? null : str);
    }
}
