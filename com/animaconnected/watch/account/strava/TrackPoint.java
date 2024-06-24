package com.animaconnected.watch.account.strava;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import com.animaconnected.watch.fitness.LocationEntry;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: StravaTcx.kt */
/* loaded from: classes3.dex */
final class TrackPoint {
    private final Integer heartRate;
    private final LocationEntry locationEntry;
    private final Instant time;

    public TrackPoint(Instant time, LocationEntry locationEntry, Integer num) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.time = time;
        this.locationEntry = locationEntry;
        this.heartRate = num;
    }

    public static /* synthetic */ TrackPoint copy$default(TrackPoint trackPoint, Instant instant, LocationEntry locationEntry, Integer num, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            instant = trackPoint.time;
        }
        if ((r4 & 2) != 0) {
            locationEntry = trackPoint.locationEntry;
        }
        if ((r4 & 4) != 0) {
            num = trackPoint.heartRate;
        }
        return trackPoint.copy(instant, locationEntry, num);
    }

    public final Instant component1() {
        return this.time;
    }

    public final LocationEntry component2() {
        return this.locationEntry;
    }

    public final Integer component3() {
        return this.heartRate;
    }

    public final TrackPoint copy(Instant time, LocationEntry locationEntry, Integer num) {
        Intrinsics.checkNotNullParameter(time, "time");
        return new TrackPoint(time, locationEntry, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrackPoint)) {
            return false;
        }
        TrackPoint trackPoint = (TrackPoint) obj;
        if (Intrinsics.areEqual(this.time, trackPoint.time) && Intrinsics.areEqual(this.locationEntry, trackPoint.locationEntry) && Intrinsics.areEqual(this.heartRate, trackPoint.heartRate)) {
            return true;
        }
        return false;
    }

    public final Integer getHeartRate() {
        return this.heartRate;
    }

    public final LocationEntry getLocationEntry() {
        return this.locationEntry;
    }

    public final Instant getTime() {
        return this.time;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.time.hashCode() * 31;
        LocationEntry locationEntry = this.locationEntry;
        int r2 = 0;
        if (locationEntry == null) {
            hashCode = 0;
        } else {
            hashCode = locationEntry.hashCode();
        }
        int r0 = (hashCode2 + hashCode) * 31;
        Integer num = this.heartRate;
        if (num != null) {
            r2 = num.hashCode();
        }
        return r0 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackPoint(time=");
        sb.append(this.time);
        sb.append(", locationEntry=");
        sb.append(this.locationEntry);
        sb.append(", heartRate=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.heartRate, ')');
    }

    public /* synthetic */ TrackPoint(Instant instant, LocationEntry locationEntry, Integer num, int r5, DefaultConstructorMarker defaultConstructorMarker) {
        this(instant, (r5 & 2) != 0 ? null : locationEntry, (r5 & 4) != 0 ? null : num);
    }
}
