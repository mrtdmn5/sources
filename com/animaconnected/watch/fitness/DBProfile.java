package com.animaconnected.watch.fitness;

import app.cash.sqldelight.ColumnAdapter;
import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DBProfile.kt */
/* loaded from: classes3.dex */
public final class DBProfile {
    private final Integer bedtime_hour;
    private final Integer bedtime_min;
    private final Integer gender;
    private final Integer height;
    private final Integer measurement;
    private final Integer temperature;
    private final long timestamp;
    private final Long ts_of_birth;
    private final Integer weight;

    /* compiled from: DBProfile.kt */
    /* loaded from: classes3.dex */
    public static final class Adapter {
        private final ColumnAdapter<Integer, Long> bedtime_hourAdapter;
        private final ColumnAdapter<Integer, Long> bedtime_minAdapter;
        private final ColumnAdapter<Integer, Long> genderAdapter;
        private final ColumnAdapter<Integer, Long> heightAdapter;
        private final ColumnAdapter<Integer, Long> measurementAdapter;
        private final ColumnAdapter<Integer, Long> temperatureAdapter;
        private final ColumnAdapter<Integer, Long> weightAdapter;

        public Adapter(ColumnAdapter<Integer, Long> heightAdapter, ColumnAdapter<Integer, Long> weightAdapter, ColumnAdapter<Integer, Long> genderAdapter, ColumnAdapter<Integer, Long> measurementAdapter, ColumnAdapter<Integer, Long> temperatureAdapter, ColumnAdapter<Integer, Long> bedtime_hourAdapter, ColumnAdapter<Integer, Long> bedtime_minAdapter) {
            Intrinsics.checkNotNullParameter(heightAdapter, "heightAdapter");
            Intrinsics.checkNotNullParameter(weightAdapter, "weightAdapter");
            Intrinsics.checkNotNullParameter(genderAdapter, "genderAdapter");
            Intrinsics.checkNotNullParameter(measurementAdapter, "measurementAdapter");
            Intrinsics.checkNotNullParameter(temperatureAdapter, "temperatureAdapter");
            Intrinsics.checkNotNullParameter(bedtime_hourAdapter, "bedtime_hourAdapter");
            Intrinsics.checkNotNullParameter(bedtime_minAdapter, "bedtime_minAdapter");
            this.heightAdapter = heightAdapter;
            this.weightAdapter = weightAdapter;
            this.genderAdapter = genderAdapter;
            this.measurementAdapter = measurementAdapter;
            this.temperatureAdapter = temperatureAdapter;
            this.bedtime_hourAdapter = bedtime_hourAdapter;
            this.bedtime_minAdapter = bedtime_minAdapter;
        }

        public final ColumnAdapter<Integer, Long> getBedtime_hourAdapter() {
            return this.bedtime_hourAdapter;
        }

        public final ColumnAdapter<Integer, Long> getBedtime_minAdapter() {
            return this.bedtime_minAdapter;
        }

        public final ColumnAdapter<Integer, Long> getGenderAdapter() {
            return this.genderAdapter;
        }

        public final ColumnAdapter<Integer, Long> getHeightAdapter() {
            return this.heightAdapter;
        }

        public final ColumnAdapter<Integer, Long> getMeasurementAdapter() {
            return this.measurementAdapter;
        }

        public final ColumnAdapter<Integer, Long> getTemperatureAdapter() {
            return this.temperatureAdapter;
        }

        public final ColumnAdapter<Integer, Long> getWeightAdapter() {
            return this.weightAdapter;
        }
    }

    public DBProfile(long j, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.timestamp = j;
        this.height = num;
        this.weight = num2;
        this.ts_of_birth = l;
        this.gender = num3;
        this.measurement = num4;
        this.temperature = num5;
        this.bedtime_hour = num6;
        this.bedtime_min = num7;
    }

    public static /* synthetic */ DBProfile copy$default(DBProfile dBProfile, long j, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, int r22, Object obj) {
        long j2;
        Integer num8;
        Integer num9;
        Long l2;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        if ((r22 & 1) != 0) {
            j2 = dBProfile.timestamp;
        } else {
            j2 = j;
        }
        if ((r22 & 2) != 0) {
            num8 = dBProfile.height;
        } else {
            num8 = num;
        }
        if ((r22 & 4) != 0) {
            num9 = dBProfile.weight;
        } else {
            num9 = num2;
        }
        if ((r22 & 8) != 0) {
            l2 = dBProfile.ts_of_birth;
        } else {
            l2 = l;
        }
        if ((r22 & 16) != 0) {
            num10 = dBProfile.gender;
        } else {
            num10 = num3;
        }
        if ((r22 & 32) != 0) {
            num11 = dBProfile.measurement;
        } else {
            num11 = num4;
        }
        if ((r22 & 64) != 0) {
            num12 = dBProfile.temperature;
        } else {
            num12 = num5;
        }
        if ((r22 & 128) != 0) {
            num13 = dBProfile.bedtime_hour;
        } else {
            num13 = num6;
        }
        if ((r22 & 256) != 0) {
            num14 = dBProfile.bedtime_min;
        } else {
            num14 = num7;
        }
        return dBProfile.copy(j2, num8, num9, l2, num10, num11, num12, num13, num14);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final Integer component2() {
        return this.height;
    }

    public final Integer component3() {
        return this.weight;
    }

    public final Long component4() {
        return this.ts_of_birth;
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

    public final Integer component8() {
        return this.bedtime_hour;
    }

    public final Integer component9() {
        return this.bedtime_min;
    }

    public final DBProfile copy(long j, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        return new DBProfile(j, num, num2, l, num3, num4, num5, num6, num7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DBProfile)) {
            return false;
        }
        DBProfile dBProfile = (DBProfile) obj;
        if (this.timestamp == dBProfile.timestamp && Intrinsics.areEqual(this.height, dBProfile.height) && Intrinsics.areEqual(this.weight, dBProfile.weight) && Intrinsics.areEqual(this.ts_of_birth, dBProfile.ts_of_birth) && Intrinsics.areEqual(this.gender, dBProfile.gender) && Intrinsics.areEqual(this.measurement, dBProfile.measurement) && Intrinsics.areEqual(this.temperature, dBProfile.temperature) && Intrinsics.areEqual(this.bedtime_hour, dBProfile.bedtime_hour) && Intrinsics.areEqual(this.bedtime_min, dBProfile.bedtime_min)) {
            return true;
        }
        return false;
    }

    public final Integer getBedtime_hour() {
        return this.bedtime_hour;
    }

    public final Integer getBedtime_min() {
        return this.bedtime_min;
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

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final Long getTs_of_birth() {
        return this.ts_of_birth;
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
        int hashCode8 = Long.hashCode(this.timestamp) * 31;
        Integer num = this.height;
        int r2 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int r0 = (hashCode8 + hashCode) * 31;
        Integer num2 = this.weight;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Long l = this.ts_of_birth;
        if (l == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = l.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Integer num3 = this.gender;
        if (num3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num3.hashCode();
        }
        int r04 = (r03 + hashCode4) * 31;
        Integer num4 = this.measurement;
        if (num4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num4.hashCode();
        }
        int r05 = (r04 + hashCode5) * 31;
        Integer num5 = this.temperature;
        if (num5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = num5.hashCode();
        }
        int r06 = (r05 + hashCode6) * 31;
        Integer num6 = this.bedtime_hour;
        if (num6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num6.hashCode();
        }
        int r07 = (r06 + hashCode7) * 31;
        Integer num7 = this.bedtime_min;
        if (num7 != null) {
            r2 = num7.hashCode();
        }
        return r07 + r2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DBProfile(timestamp=");
        sb.append(this.timestamp);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", ts_of_birth=");
        sb.append(this.ts_of_birth);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", measurement=");
        sb.append(this.measurement);
        sb.append(", temperature=");
        sb.append(this.temperature);
        sb.append(", bedtime_hour=");
        sb.append(this.bedtime_hour);
        sb.append(", bedtime_min=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.bedtime_min, ')');
    }
}
