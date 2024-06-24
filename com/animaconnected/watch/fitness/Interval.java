package com.animaconnected.watch.fitness;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class Interval {
    public static final Companion Companion = new Companion(null);
    private final long endTimestamp;
    private final long startTimestamp;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Interval> serializer() {
            return Interval$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Interval(int r2, long j, long j2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (r2 & 3)) {
            zzac.throwMissingFieldException(r2, 3, Interval$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.startTimestamp = j;
        this.endTimestamp = j2;
    }

    public static /* synthetic */ Interval copy$default(Interval interval, long j, long j2, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            j = interval.startTimestamp;
        }
        if ((r5 & 2) != 0) {
            j2 = interval.endTimestamp;
        }
        return interval.copy(j, j2);
    }

    public static final /* synthetic */ void write$Self$watch_release(Interval interval, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeLongElement(serialDescriptor, 0, interval.startTimestamp);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, interval.endTimestamp);
    }

    public final long component1() {
        return this.startTimestamp;
    }

    public final long component2() {
        return this.endTimestamp;
    }

    public final Interval copy(long j, long j2) {
        return new Interval(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) obj;
        if (this.startTimestamp == interval.startTimestamp && this.endTimestamp == interval.endTimestamp) {
            return true;
        }
        return false;
    }

    public final long getEndTimestamp() {
        return this.endTimestamp;
    }

    public final long getStartTimestamp() {
        return this.startTimestamp;
    }

    public int hashCode() {
        return Long.hashCode(this.endTimestamp) + (Long.hashCode(this.startTimestamp) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Interval(startTimestamp=");
        sb.append(this.startTimestamp);
        sb.append(", endTimestamp=");
        return FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, this.endTimestamp, ')');
    }

    public Interval(long j, long j2) {
        this.startTimestamp = j;
        this.endTimestamp = j2;
    }
}
