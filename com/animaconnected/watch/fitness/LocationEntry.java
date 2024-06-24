package com.animaconnected.watch.fitness;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.model.HistoryDeviceId$$serializer;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonNames;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class LocationEntry extends Entry {
    public static final Companion Companion = new Companion(null);
    private final boolean accepted;
    private final float accuracy;
    private final double altitude;
    private String historyDeviceId;
    private final double lat;

    /* renamed from: long */
    private final double f110long;
    private long timestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<LocationEntry> serializer() {
            return LocationEntry$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ LocationEntry(int r1, @JsonNames(names = {"identifier"}) String str, long j, double d, double d2, float f, double d3, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, str, j, d, d2, f, d3, serializationConstructorMarker);
    }

    /* renamed from: copy-EBUUAns$default */
    public static /* synthetic */ LocationEntry m1447copyEBUUAns$default(LocationEntry locationEntry, String str, long j, double d, double d2, float f, double d3, boolean z, int r24, Object obj) {
        String str2;
        long j2;
        double d4;
        double d5;
        float f2;
        double d6;
        boolean z2;
        if ((r24 & 1) != 0) {
            str2 = locationEntry.historyDeviceId;
        } else {
            str2 = str;
        }
        if ((r24 & 2) != 0) {
            j2 = locationEntry.timestamp;
        } else {
            j2 = j;
        }
        if ((r24 & 4) != 0) {
            d4 = locationEntry.f110long;
        } else {
            d4 = d;
        }
        if ((r24 & 8) != 0) {
            d5 = locationEntry.lat;
        } else {
            d5 = d2;
        }
        if ((r24 & 16) != 0) {
            f2 = locationEntry.accuracy;
        } else {
            f2 = f;
        }
        if ((r24 & 32) != 0) {
            d6 = locationEntry.altitude;
        } else {
            d6 = d3;
        }
        if ((r24 & 64) != 0) {
            z2 = locationEntry.accepted;
        } else {
            z2 = z;
        }
        return locationEntry.m1450copyEBUUAns(str2, j2, d4, d5, f2, d6, z2);
    }

    public static final /* synthetic */ void write$Self$watch_release(LocationEntry locationEntry, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, HistoryDeviceId$$serializer.INSTANCE, HistoryDeviceId.m1556boximpl(locationEntry.mo1121getHistoryDeviceIdV9ZILtA()));
        compositeEncoder.encodeLongElement(serialDescriptor, 1, locationEntry.getTimestamp());
        compositeEncoder.encodeDoubleElement(serialDescriptor, 2, locationEntry.f110long);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 3, locationEntry.lat);
        compositeEncoder.encodeFloatElement(serialDescriptor, 4, locationEntry.accuracy);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 5, locationEntry.altitude);
    }

    /* renamed from: component1-V9ZILtA */
    public final String m1449component1V9ZILtA() {
        return this.historyDeviceId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final double component3() {
        return this.f110long;
    }

    public final double component4() {
        return this.lat;
    }

    public final float component5() {
        return this.accuracy;
    }

    public final double component6() {
        return this.altitude;
    }

    public final boolean component7() {
        return this.accepted;
    }

    /* renamed from: copy-EBUUAns */
    public final LocationEntry m1450copyEBUUAns(String historyDeviceId, long j, double d, double d2, float f, double d3, boolean z) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return new LocationEntry(historyDeviceId, j, d, d2, f, d3, z, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationEntry)) {
            return false;
        }
        LocationEntry locationEntry = (LocationEntry) obj;
        if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, locationEntry.historyDeviceId) && this.timestamp == locationEntry.timestamp && Double.compare(this.f110long, locationEntry.f110long) == 0 && Double.compare(this.lat, locationEntry.lat) == 0 && Float.compare(this.accuracy, locationEntry.accuracy) == 0 && Double.compare(this.altitude, locationEntry.altitude) == 0 && this.accepted == locationEntry.accepted) {
            return true;
        }
        return false;
    }

    public final boolean getAccepted() {
        return this.accepted;
    }

    public final float getAccuracy() {
        return this.accuracy;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: getHistoryDeviceId-V9ZILtA */
    public String mo1121getHistoryDeviceIdV9ZILtA() {
        return this.historyDeviceId;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f110long;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return Boolean.hashCode(this.accepted) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.altitude, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.accuracy, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.lat, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.f110long, Scale$$ExternalSyntheticOutline0.m(this.timestamp, HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31, 31), 31), 31), 31), 31);
    }

    @Override // com.animaconnected.watch.fitness.Entry
    /* renamed from: setHistoryDeviceId-Y1s2hH8 */
    public void mo1122setHistoryDeviceIdY1s2hH8(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.historyDeviceId = str;
    }

    @Override // com.animaconnected.watch.fitness.Entry
    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LocationEntry(historyDeviceId=");
        ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", timestamp=");
        sb.append(this.timestamp);
        sb.append(", long=");
        sb.append(this.f110long);
        sb.append(", lat=");
        sb.append(this.lat);
        sb.append(", accuracy=");
        sb.append(this.accuracy);
        sb.append(", altitude=");
        sb.append(this.altitude);
        sb.append(", accepted=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.accepted, ')');
    }

    public /* synthetic */ LocationEntry(String str, long j, double d, double d2, float f, double d3, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, d, d2, f, d3, z);
    }

    private LocationEntry(int r2, String str, long j, double d, double d2, float f, double d3, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (r2 & 63)) {
            zzac.throwMissingFieldException(r2, 63, LocationEntry$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.historyDeviceId = str;
        this.timestamp = j;
        this.f110long = d;
        this.lat = d2;
        this.accuracy = f;
        this.altitude = d3;
        this.accepted = true;
    }

    public /* synthetic */ LocationEntry(String str, long j, double d, double d2, float f, double d3, boolean z, int r26, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, d, d2, f, d3, (r26 & 64) != 0 ? true : z, (DefaultConstructorMarker) null);
    }

    private LocationEntry(String historyDeviceId, long j, double d, double d2, float f, double d3, boolean z) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        this.historyDeviceId = historyDeviceId;
        this.timestamp = j;
        this.f110long = d;
        this.lat = d2;
        this.accuracy = f;
        this.altitude = d3;
        this.accepted = z;
    }

    public static /* synthetic */ void getAccepted$annotations() {
    }

    @JsonNames(names = {FitnessDataKt.oldJsonNameForHistoryDeviceId})
    /* renamed from: getHistoryDeviceId-V9ZILtA$annotations */
    public static /* synthetic */ void m1448getHistoryDeviceIdV9ZILtA$annotations() {
    }
}
