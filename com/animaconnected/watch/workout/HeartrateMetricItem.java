package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.HeartrateValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class HeartrateMetricItem {
    private final HeartrateValue heartrateValue;
    private final HeartrateSource source;
    private final Instant timestamp;

    public HeartrateMetricItem(HeartrateValue heartrateValue, Instant timestamp, HeartrateSource source) {
        Intrinsics.checkNotNullParameter(heartrateValue, "heartrateValue");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(source, "source");
        this.heartrateValue = heartrateValue;
        this.timestamp = timestamp;
        this.source = source;
    }

    public static /* synthetic */ HeartrateMetricItem copy$default(HeartrateMetricItem heartrateMetricItem, HeartrateValue heartrateValue, Instant instant, HeartrateSource heartrateSource, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            heartrateValue = heartrateMetricItem.heartrateValue;
        }
        if ((r4 & 2) != 0) {
            instant = heartrateMetricItem.timestamp;
        }
        if ((r4 & 4) != 0) {
            heartrateSource = heartrateMetricItem.source;
        }
        return heartrateMetricItem.copy(heartrateValue, instant, heartrateSource);
    }

    public final HeartrateValue component1() {
        return this.heartrateValue;
    }

    public final Instant component2() {
        return this.timestamp;
    }

    public final HeartrateSource component3() {
        return this.source;
    }

    public final HeartrateValue conditionalHeartrateValue(Instant now) {
        Intrinsics.checkNotNullParameter(now, "now");
        long m1704minus5sfh64U = now.m1704minus5sfh64U(this.timestamp);
        int r5 = Duration.$r8$clinit;
        if (Duration.m1672compareToLRDsOJo(m1704minus5sfh64U, DurationKt.toDuration(1.5d, DurationUnit.HOURS)) <= 0) {
            return this.heartrateValue;
        }
        return null;
    }

    public final Instant conditionalTimestamp(Instant now) {
        Intrinsics.checkNotNullParameter(now, "now");
        int r0 = Duration.$r8$clinit;
        boolean z = true;
        long duration = DurationKt.toDuration(1, DurationUnit.MINUTES);
        long duration2 = DurationKt.toDuration(1.5d, DurationUnit.HOURS);
        long m1704minus5sfh64U = now.m1704minus5sfh64U(this.timestamp);
        if (new Duration(m1704minus5sfh64U).compareTo(new Duration(duration)) < 0 || new Duration(m1704minus5sfh64U).compareTo(new Duration(duration2)) > 0) {
            z = false;
        }
        if (z) {
            return this.timestamp;
        }
        return null;
    }

    public final HeartrateMetricItem copy(HeartrateValue heartrateValue, Instant timestamp, HeartrateSource source) {
        Intrinsics.checkNotNullParameter(heartrateValue, "heartrateValue");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(source, "source");
        return new HeartrateMetricItem(heartrateValue, timestamp, source);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeartrateMetricItem)) {
            return false;
        }
        HeartrateMetricItem heartrateMetricItem = (HeartrateMetricItem) obj;
        if (Intrinsics.areEqual(this.heartrateValue, heartrateMetricItem.heartrateValue) && Intrinsics.areEqual(this.timestamp, heartrateMetricItem.timestamp) && this.source == heartrateMetricItem.source) {
            return true;
        }
        return false;
    }

    public final HeartrateValue getHeartrateValue() {
        return this.heartrateValue;
    }

    public final HeartrateSource getSource() {
        return this.source;
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return this.source.hashCode() + ((this.timestamp.hashCode() + (this.heartrateValue.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "HeartrateMetricItem(heartrateValue=" + this.heartrateValue + ", timestamp=" + this.timestamp + ", source=" + this.source + ')';
    }
}
