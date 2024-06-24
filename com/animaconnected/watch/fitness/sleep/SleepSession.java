package com.animaconnected.watch.fitness.sleep;

import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import com.animaconnected.watch.fitness.SleepEntry;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SleepSession.kt */
/* loaded from: classes3.dex */
public final class SleepSession {
    private final List<SleepEntry> entries;
    private final SleepTimePeriod sleepTimePeriod;
    private final SleepSessionState state;

    public SleepSession(SleepTimePeriod sleepTimePeriod, List<SleepEntry> entries, SleepSessionState state) {
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "sleepTimePeriod");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(state, "state");
        this.sleepTimePeriod = sleepTimePeriod;
        this.entries = entries;
        this.state = state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SleepSession copy$default(SleepSession sleepSession, SleepTimePeriod sleepTimePeriod, List list, SleepSessionState sleepSessionState, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            sleepTimePeriod = sleepSession.sleepTimePeriod;
        }
        if ((r4 & 2) != 0) {
            list = sleepSession.entries;
        }
        if ((r4 & 4) != 0) {
            sleepSessionState = sleepSession.state;
        }
        return sleepSession.copy(sleepTimePeriod, list, sleepSessionState);
    }

    public final SleepTimePeriod component1() {
        return this.sleepTimePeriod;
    }

    public final List<SleepEntry> component2() {
        return this.entries;
    }

    public final SleepSessionState component3() {
        return this.state;
    }

    public final SleepSession copy(SleepTimePeriod sleepTimePeriod, List<SleepEntry> entries, SleepSessionState state) {
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "sleepTimePeriod");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(state, "state");
        return new SleepSession(sleepTimePeriod, entries, state);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSession)) {
            return false;
        }
        SleepSession sleepSession = (SleepSession) obj;
        if (Intrinsics.areEqual(this.sleepTimePeriod, sleepSession.sleepTimePeriod) && Intrinsics.areEqual(this.entries, sleepSession.entries) && this.state == sleepSession.state) {
            return true;
        }
        return false;
    }

    public final List<SleepEntry> getEntries() {
        return this.entries;
    }

    public final SleepTimePeriod getSleepTimePeriod() {
        return this.sleepTimePeriod;
    }

    public final SleepSessionState getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode() + VectorGroup$$ExternalSyntheticOutline0.m(this.entries, this.sleepTimePeriod.hashCode() * 31, 31);
    }

    public String toString() {
        return "SleepSession(sleepTimePeriod=" + this.sleepTimePeriod + ", entries=" + this.entries + ", state=" + this.state + ')';
    }
}
