package com.animaconnected.watch.location;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: LocationResult.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Spot extends LocationResult {
    public static final Companion Companion = new Companion(null);
    public final float accuracy;
    public final String addressLine;
    public final double altitude;
    public final double latitude;
    public final double longitude;
    public final String name;
    public final Float speed;
    public final long timeStamp;

    /* compiled from: LocationResult.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Spot> serializer() {
            return Spot$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Spot() {
        this(0L, 0.0d, 0.0d, (String) null, 0.0f, (String) null, 0.0d, (Float) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Spot copy$default(Spot spot, long j, double d, double d2, String str, float f, String str2, double d3, Float f2, int r26, Object obj) {
        long j2;
        double d4;
        double d5;
        String str3;
        float f3;
        String str4;
        double d6;
        Float f4;
        if ((r26 & 1) != 0) {
            j2 = spot.timeStamp;
        } else {
            j2 = j;
        }
        if ((r26 & 2) != 0) {
            d4 = spot.latitude;
        } else {
            d4 = d;
        }
        if ((r26 & 4) != 0) {
            d5 = spot.longitude;
        } else {
            d5 = d2;
        }
        if ((r26 & 8) != 0) {
            str3 = spot.addressLine;
        } else {
            str3 = str;
        }
        if ((r26 & 16) != 0) {
            f3 = spot.accuracy;
        } else {
            f3 = f;
        }
        if ((r26 & 32) != 0) {
            str4 = spot.name;
        } else {
            str4 = str2;
        }
        if ((r26 & 64) != 0) {
            d6 = spot.altitude;
        } else {
            d6 = d3;
        }
        if ((r26 & 128) != 0) {
            f4 = spot.speed;
        } else {
            f4 = f2;
        }
        return spot.copy(j2, d4, d5, str3, f3, str4, d6, f4);
    }

    public static final /* synthetic */ void write$Self$watch_release(Spot spot, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || spot.timeStamp != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeLongElement(serialDescriptor, 0, spot.timeStamp);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || Double.compare(spot.latitude, 0.0d) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeDoubleElement(serialDescriptor, 1, spot.latitude);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || Double.compare(spot.longitude, 0.0d) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeDoubleElement(serialDescriptor, 2, spot.longitude);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || spot.addressLine != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, spot.addressLine);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || Float.compare(spot.accuracy, 0.0f) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            compositeEncoder.encodeFloatElement(serialDescriptor, 4, spot.accuracy);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || spot.name != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, spot.name);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || Double.compare(spot.altitude, 0.0d) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            compositeEncoder.encodeDoubleElement(serialDescriptor, 6, spot.altitude);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || spot.speed != null) {
            z8 = true;
        }
        if (z8) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, FloatSerializer.INSTANCE, spot.speed);
        }
    }

    public final long component1() {
        return this.timeStamp;
    }

    public final double component2() {
        return this.latitude;
    }

    public final double component3() {
        return this.longitude;
    }

    public final String component4() {
        return this.addressLine;
    }

    public final float component5() {
        return this.accuracy;
    }

    public final String component6() {
        return this.name;
    }

    public final double component7() {
        return this.altitude;
    }

    public final Float component8() {
        return this.speed;
    }

    public final Spot copy(long j, double d, double d2, String str, float f, String str2, double d3, Float f2) {
        return new Spot(j, d, d2, str, f, str2, d3, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Spot)) {
            return false;
        }
        Spot spot = (Spot) obj;
        if (this.timeStamp == spot.timeStamp && Double.compare(this.latitude, spot.latitude) == 0 && Double.compare(this.longitude, spot.longitude) == 0 && Intrinsics.areEqual(this.addressLine, spot.addressLine) && Float.compare(this.accuracy, spot.accuracy) == 0 && Intrinsics.areEqual(this.name, spot.name) && Double.compare(this.altitude, spot.altitude) == 0 && Intrinsics.areEqual(this.speed, spot.speed)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int m = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.longitude, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.latitude, Long.hashCode(this.timeStamp) * 31, 31), 31);
        String str = this.addressLine;
        int r2 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int m2 = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.accuracy, (m + hashCode) * 31, 31);
        String str2 = this.name;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int m3 = JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.altitude, (m2 + hashCode2) * 31, 31);
        Float f = this.speed;
        if (f != null) {
            r2 = f.hashCode();
        }
        return m3 + r2;
    }

    public String toString() {
        return "Spot: " + this.name + ' ' + this.addressLine + ' ' + this.timeStamp;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Spot(int r9, long j, double d, double d2, String str, float f, String str2, double d3, Float f2, SerializationConstructorMarker serializationConstructorMarker) {
        super(null);
        if ((r9 & 0) != 0) {
            zzac.throwMissingFieldException(r9, 0, Spot$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.timeStamp = (r9 & 1) == 0 ? 0L : j;
        if ((r9 & 2) == 0) {
            this.latitude = 0.0d;
        } else {
            this.latitude = d;
        }
        if ((r9 & 4) == 0) {
            this.longitude = 0.0d;
        } else {
            this.longitude = d2;
        }
        if ((r9 & 8) == 0) {
            this.addressLine = null;
        } else {
            this.addressLine = str;
        }
        this.accuracy = (r9 & 16) == 0 ? 0.0f : f;
        if ((r9 & 32) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        this.altitude = (r9 & 64) != 0 ? d3 : 0.0d;
        if ((r9 & 128) == 0) {
            this.speed = null;
        } else {
            this.speed = f2;
        }
    }

    public /* synthetic */ Spot(long j, double d, double d2, String str, float f, String str2, double d3, Float f2, int r27, DefaultConstructorMarker defaultConstructorMarker) {
        this((r27 & 1) != 0 ? 0L : j, (r27 & 2) != 0 ? 0.0d : d, (r27 & 4) != 0 ? 0.0d : d2, (r27 & 8) != 0 ? null : str, (r27 & 16) != 0 ? 0.0f : f, (r27 & 32) != 0 ? null : str2, (r27 & 64) == 0 ? d3 : 0.0d, (r27 & 128) == 0 ? f2 : null);
    }

    public Spot(long j, double d, double d2, String str, float f, String str2, double d3, Float f2) {
        super(null);
        this.timeStamp = j;
        this.latitude = d;
        this.longitude = d2;
        this.addressLine = str;
        this.accuracy = f;
        this.name = str2;
        this.altitude = d3;
        this.speed = f2;
    }
}
