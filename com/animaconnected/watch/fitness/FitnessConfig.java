package com.animaconnected.watch.fitness;

import com.google.android.gms.tasks.zzac;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: FitnessData.kt */
@Serializable
/* loaded from: classes3.dex */
public final class FitnessConfig {
    public static final Companion Companion = new Companion(null);
    private final Bedtime bedtime;
    private final Long dateOfBirthTs;
    private final Integer gender;
    private final Integer height;
    private final Integer measurement;
    private final Integer temperature;
    private final Long timestamp;
    private final Integer weight;

    /* compiled from: FitnessData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<FitnessConfig> serializer() {
            return FitnessConfig$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public FitnessConfig() {
        this((Long) null, (Integer) null, (Integer) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, (Bedtime) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FitnessConfig copy$default(FitnessConfig fitnessConfig, Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Bedtime bedtime, int r18, Object obj) {
        Long l3;
        Integer num6;
        Integer num7;
        Long l4;
        Integer num8;
        Integer num9;
        Integer num10;
        Bedtime bedtime2;
        if ((r18 & 1) != 0) {
            l3 = fitnessConfig.timestamp;
        } else {
            l3 = l;
        }
        if ((r18 & 2) != 0) {
            num6 = fitnessConfig.height;
        } else {
            num6 = num;
        }
        if ((r18 & 4) != 0) {
            num7 = fitnessConfig.weight;
        } else {
            num7 = num2;
        }
        if ((r18 & 8) != 0) {
            l4 = fitnessConfig.dateOfBirthTs;
        } else {
            l4 = l2;
        }
        if ((r18 & 16) != 0) {
            num8 = fitnessConfig.gender;
        } else {
            num8 = num3;
        }
        if ((r18 & 32) != 0) {
            num9 = fitnessConfig.measurement;
        } else {
            num9 = num4;
        }
        if ((r18 & 64) != 0) {
            num10 = fitnessConfig.temperature;
        } else {
            num10 = num5;
        }
        if ((r18 & 128) != 0) {
            bedtime2 = fitnessConfig.bedtime;
        } else {
            bedtime2 = bedtime;
        }
        return fitnessConfig.copy(l3, num6, num7, l4, num8, num9, num10, bedtime2);
    }

    public static final /* synthetic */ void write$Self$watch_release(FitnessConfig fitnessConfig, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8 = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.timestamp != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, fitnessConfig.timestamp);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.height != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, IntSerializer.INSTANCE, fitnessConfig.height);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.weight != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, IntSerializer.INSTANCE, fitnessConfig.weight);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.dateOfBirthTs != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, fitnessConfig.dateOfBirthTs);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.gender != null) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, IntSerializer.INSTANCE, fitnessConfig.gender);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.measurement != null) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, IntSerializer.INSTANCE, fitnessConfig.measurement);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.temperature != null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, fitnessConfig.temperature);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || fitnessConfig.bedtime != null) {
            z8 = true;
        }
        if (z8) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, Bedtime$$serializer.INSTANCE, fitnessConfig.bedtime);
        }
    }

    public final Long component1() {
        return this.timestamp;
    }

    public final Integer component2() {
        return this.height;
    }

    public final Integer component3() {
        return this.weight;
    }

    public final Long component4() {
        return this.dateOfBirthTs;
    }

    public final Integer component5() {
        return this.gender;
    }

    public final Integer component6() {
        return this.measurement;
    }

    public final Integer component7() {
        return this.temperature;
    }

    public final Bedtime component8() {
        return this.bedtime;
    }

    public final FitnessConfig copy(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Bedtime bedtime) {
        return new FitnessConfig(l, num, num2, l2, num3, num4, num5, bedtime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessConfig)) {
            return false;
        }
        FitnessConfig fitnessConfig = (FitnessConfig) obj;
        if (Intrinsics.areEqual(this.timestamp, fitnessConfig.timestamp) && Intrinsics.areEqual(this.height, fitnessConfig.height) && Intrinsics.areEqual(this.weight, fitnessConfig.weight) && Intrinsics.areEqual(this.dateOfBirthTs, fitnessConfig.dateOfBirthTs) && Intrinsics.areEqual(this.gender, fitnessConfig.gender) && Intrinsics.areEqual(this.measurement, fitnessConfig.measurement) && Intrinsics.areEqual(this.temperature, fitnessConfig.temperature) && Intrinsics.areEqual(this.bedtime, fitnessConfig.bedtime)) {
            return true;
        }
        return false;
    }

    public final Bedtime getBedtime() {
        return this.bedtime;
    }

    public final Long getDateOfBirthTs() {
        return this.dateOfBirthTs;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getMeasurement() {
        return this.measurement;
    }

    public final Integer getTemperature() {
        return this.temperature;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final Integer getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        Long l = this.timestamp;
        int r1 = 0;
        if (l == null) {
            hashCode = 0;
        } else {
            hashCode = l.hashCode();
        }
        int r0 = hashCode * 31;
        Integer num = this.height;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Integer num2 = this.weight;
        if (num2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num2.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Long l2 = this.dateOfBirthTs;
        if (l2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = l2.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Integer num3 = this.gender;
        if (num3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num3.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Integer num4 = this.measurement;
        if (num4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = num4.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        Integer num5 = this.temperature;
        if (num5 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num5.hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        Bedtime bedtime = this.bedtime;
        if (bedtime != null) {
            r1 = bedtime.hashCode();
        }
        return r07 + r1;
    }

    public String toString() {
        return "FitnessConfig(timestamp=" + this.timestamp + ", height=" + this.height + ", weight=" + this.weight + ", dateOfBirthTs=" + this.dateOfBirthTs + ", gender=" + this.gender + ", measurement=" + this.measurement + ", temperature=" + this.temperature + ", bedtime=" + this.bedtime + ')';
    }

    public /* synthetic */ FitnessConfig(int r2, Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Bedtime bedtime, SerializationConstructorMarker serializationConstructorMarker) {
        if ((r2 & 0) != 0) {
            zzac.throwMissingFieldException(r2, 0, FitnessConfig$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        if ((r2 & 1) == 0) {
            this.timestamp = null;
        } else {
            this.timestamp = l;
        }
        if ((r2 & 2) == 0) {
            this.height = null;
        } else {
            this.height = num;
        }
        if ((r2 & 4) == 0) {
            this.weight = null;
        } else {
            this.weight = num2;
        }
        if ((r2 & 8) == 0) {
            this.dateOfBirthTs = null;
        } else {
            this.dateOfBirthTs = l2;
        }
        if ((r2 & 16) == 0) {
            this.gender = null;
        } else {
            this.gender = num3;
        }
        if ((r2 & 32) == 0) {
            this.measurement = null;
        } else {
            this.measurement = num4;
        }
        if ((r2 & 64) == 0) {
            this.temperature = null;
        } else {
            this.temperature = num5;
        }
        if ((r2 & 128) == 0) {
            this.bedtime = null;
        } else {
            this.bedtime = bedtime;
        }
    }

    public FitnessConfig(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Bedtime bedtime) {
        this.timestamp = l;
        this.height = num;
        this.weight = num2;
        this.dateOfBirthTs = l2;
        this.gender = num3;
        this.measurement = num4;
        this.temperature = num5;
        this.bedtime = bedtime;
    }

    public /* synthetic */ FitnessConfig(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Bedtime bedtime, int r18, DefaultConstructorMarker defaultConstructorMarker) {
        this((r18 & 1) != 0 ? null : l, (r18 & 2) != 0 ? null : num, (r18 & 4) != 0 ? null : num2, (r18 & 8) != 0 ? null : l2, (r18 & 16) != 0 ? null : num3, (r18 & 32) != 0 ? null : num4, (r18 & 64) != 0 ? null : num5, (r18 & 128) == 0 ? bedtime : null);
    }
}
