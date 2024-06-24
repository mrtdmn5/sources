package com.animaconnected.watch.behaviour.temperature;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: WeatherHttpClient.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Temp {
    public static final Companion Companion = new Companion(null);
    private final double max;
    private final double min;

    /* compiled from: WeatherHttpClient.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Temp> serializer() {
            return Temp$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public Temp(double d, double d2) {
        this.max = d;
        this.min = d2;
    }

    public static /* synthetic */ Temp copy$default(Temp temp, double d, double d2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            d = temp.max;
        }
        if ((r5 & 2) != 0) {
            d2 = temp.min;
        }
        return temp.copy(d, d2);
    }

    public static final /* synthetic */ void write$Self$watch_release(Temp temp, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeDoubleElement(serialDescriptor, 0, temp.max);
        compositeEncoder.encodeDoubleElement(serialDescriptor, 1, temp.min);
    }

    public final double component1() {
        return this.max;
    }

    public final double component2() {
        return this.min;
    }

    public final Temp copy(double d, double d2) {
        return new Temp(d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Temp)) {
            return false;
        }
        Temp temp = (Temp) obj;
        if (Double.compare(this.max, temp.max) == 0 && Double.compare(this.min, temp.min) == 0) {
            return true;
        }
        return false;
    }

    public final double getMax() {
        return this.max;
    }

    public final double getMin() {
        return this.min;
    }

    public int hashCode() {
        return Double.hashCode(this.min) + (Double.hashCode(this.max) * 31);
    }

    public String toString() {
        return "Temp(max=" + this.max + ", min=" + this.min + ')';
    }

    public /* synthetic */ Temp(int r2, double d, double d2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, Temp$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.max = d;
        this.min = d2;
    }
}
