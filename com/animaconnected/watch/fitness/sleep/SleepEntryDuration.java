package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.watch.fitness.SleepEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SleepSession.kt */
/* loaded from: classes3.dex */
public final class SleepEntryDuration {
    private final long duration;
    private final SleepEntry entry;

    public /* synthetic */ SleepEntryDuration(SleepEntry sleepEntry, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(sleepEntry, j);
    }

    /* renamed from: copy-HG0u8IE$default, reason: not valid java name */
    public static /* synthetic */ SleepEntryDuration m1528copyHG0u8IE$default(SleepEntryDuration sleepEntryDuration, SleepEntry sleepEntry, long j, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            sleepEntry = sleepEntryDuration.entry;
        }
        if ((r4 & 2) != 0) {
            j = sleepEntryDuration.duration;
        }
        return sleepEntryDuration.m1530copyHG0u8IE(sleepEntry, j);
    }

    public final SleepEntry component1() {
        return this.entry;
    }

    /* renamed from: component2-UwyO8pc, reason: not valid java name */
    public final long m1529component2UwyO8pc() {
        return this.duration;
    }

    /* renamed from: copy-HG0u8IE, reason: not valid java name */
    public final SleepEntryDuration m1530copyHG0u8IE(SleepEntry entry, long j) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return new SleepEntryDuration(entry, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepEntryDuration)) {
            return false;
        }
        SleepEntryDuration sleepEntryDuration = (SleepEntryDuration) obj;
        if (Intrinsics.areEqual(this.entry, sleepEntryDuration.entry) && Duration.m1675equalsimpl0(this.duration, sleepEntryDuration.duration)) {
            return true;
        }
        return false;
    }

    /* renamed from: getDuration-UwyO8pc, reason: not valid java name */
    public final long m1531getDurationUwyO8pc() {
        return this.duration;
    }

    public final SleepEntry getEntry() {
        return this.entry;
    }

    public int hashCode() {
        int hashCode = this.entry.hashCode() * 31;
        long j = this.duration;
        int r3 = Duration.$r8$clinit;
        return Long.hashCode(j) + hashCode;
    }

    public String toString() {
        return "SleepEntryDuration(entry=" + this.entry + ", duration=" + ((Object) Duration.m1690toStringimpl(this.duration)) + ')';
    }

    private SleepEntryDuration(SleepEntry entry, long j) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        this.entry = entry;
        this.duration = j;
    }
}
