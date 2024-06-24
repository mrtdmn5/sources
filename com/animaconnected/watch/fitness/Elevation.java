package com.animaconnected.watch.fitness;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Elevation {
    public static final Companion Companion = new Companion(null);
    private final double elevation;
    private final double lat;

    /* renamed from: long, reason: not valid java name */
    private final double f109long;
    private final double resolution;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Elevation> serializer() {
            return Elevation$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Elevation(double d, double d2, double d3, double d4) {
        this.f109long = d;
        this.lat = d2;
        this.elevation = d3;
        this.resolution = d4;
    }

    public static /* synthetic */ Elevation copy$default(Elevation elevation, double d, double d2, double d3, double d4, int r18, Object obj) {
        double d5;
        double d6;
        double d7;
        double d8;
        if ((r18 & 1) != 0) {
            d5 = elevation.f109long;
        } else {
            d5 = d;
        }
        if ((r18 & 2) != 0) {
            d6 = elevation.lat;
        } else {
            d6 = d2;
        }
        if ((r18 & 4) != 0) {
            d7 = elevation.elevation;
        } else {
            d7 = d3;
        }
        if ((r18 & 8) != 0) {
            d8 = elevation.resolution;
        } else {
            d8 = d4;
        }
        return elevation.copy(d5, d6, d7, d8);
    }

    public static final /* synthetic */ void write$Self$watch_release(Elevation elevation, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeDoubleElement(serialDescriptor, 0, elevation.f109long);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 1, elevation.lat);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 2, elevation.elevation);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 3, elevation.resolution);
    }

    public final double component1() {
        return this.f109long;
    }

    public final double component2() {
        return this.lat;
    }

    public final double component3() {
        return this.elevation;
    }

    public final double component4() {
        return this.resolution;
    }

    public final Elevation copy(double d, double d2, double d3, double d4) {
        return new Elevation(d, d2, d3, d4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Elevation)) {
            return false;
        }
        Elevation elevation = (Elevation) obj;
        if (Double.compare(this.f109long, elevation.f109long) == 0 && Double.compare(this.lat, elevation.lat) == 0 && Double.compare(this.elevation, elevation.elevation) == 0 && Double.compare(this.resolution, elevation.resolution) == 0) {
            return true;
        }
        return false;
    }

    public final double getElevation() {
        return this.elevation;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLong() {
        return this.f109long;
    }

    public final double getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        return Double.hashCode(this.resolution) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.elevation, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.lat, Double.hashCode(this.f109long) * 31, 31), 31);
    }

    public String toString() {
        return "Elevation(long=" + this.f109long + ", lat=" + this.lat + ", elevation=" + this.elevation + ", resolution=" + this.resolution + ')';
    }

    public /* synthetic */ Elevation(int r2, double d, double d2, double d3, double d4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (r2 & 15)) {
            zzac.throwMissingFieldException(r2, 15, Elevation$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.f109long = d;
        this.lat = d2;
        this.elevation = d3;
        this.resolution = d4;
    }
}
