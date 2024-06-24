package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class Field extends AbstractSafeParcelable {
    public static final Field FIELD_ACCURACY;
    public static final Field FIELD_ALTITUDE;
    public static final Field FIELD_AVERAGE;
    public static final Field FIELD_BPM;
    public static final Field FIELD_CALORIES;
    public static final Field FIELD_DISTANCE;
    public static final Field FIELD_DURATION;
    public static final Field FIELD_EXERCISE;
    public static final Field FIELD_FOOD_ITEM;
    public static final Field FIELD_HEIGHT;
    public static final Field FIELD_HIGH_LATITUDE;
    public static final Field FIELD_HIGH_LONGITUDE;
    public static final Field FIELD_INTENSITY;
    public static final Field FIELD_LATITUDE;
    public static final Field FIELD_LONGITUDE;
    public static final Field FIELD_LOW_LATITUDE;
    public static final Field FIELD_LOW_LONGITUDE;
    public static final Field FIELD_MAX;
    public static final Field FIELD_MAX_INT;
    public static final Field FIELD_MEAL_TYPE;
    public static final Field FIELD_MIN;
    public static final Field FIELD_MIN_INT;
    public static final Field FIELD_NUM_SEGMENTS;
    public static final Field FIELD_NUTRIENTS;
    public static final Field FIELD_OCCURRENCES;
    public static final Field FIELD_PERCENTAGE;
    public static final Field FIELD_REPETITIONS;
    public static final Field FIELD_RESISTANCE;
    public static final Field FIELD_RESISTANCE_TYPE;
    public static final Field FIELD_REVOLUTIONS;
    public static final Field FIELD_RPM;
    public static final Field FIELD_SPEED;
    public static final Field FIELD_STEPS;
    public static final Field FIELD_VOLUME;
    public static final Field FIELD_WATTS;
    public static final Field FIELD_WEIGHT;
    public static final Field zza;
    public static final Field zzd;
    public static final Field zze;
    public static final Field zzg;
    public static final Field zzh;
    public static final Field zzi;
    public static final Field zzj;
    public static final Field zzk;
    public static final Field zzl;
    public static final Field zzm;
    public static final Field zzn;
    public static final Field zzo;
    public static final Field zzp;
    public static final Field zzq;
    public static final Field zzr;
    public static final Field zzs;
    public static final Field zzt;
    public static final Field zzu;
    public static final Field zzv;
    public static final Field zzw;
    public static final Field zzx;
    public static final Field zzy;
    public static final Field zzz;
    public final String zzA;
    public final int zzB;
    public final Boolean zzC;
    public static final Parcelable.Creator<Field> CREATOR = new zzq();
    public static final Field FIELD_ACTIVITY = zzd("activity");
    public static final Field FIELD_SLEEP_SEGMENT_TYPE = zzd("sleep_segment_type");

    static {
        zzb("confidence");
        FIELD_STEPS = zzd("steps");
        zzb("step_length");
        FIELD_DURATION = zzd("duration");
        zza = zzf("duration");
        new Field("activity_duration.ascending", 4, null);
        new Field("activity_duration.descending", 4, null);
        FIELD_BPM = zzb("bpm");
        zzd = zzb("respiratory_rate");
        FIELD_LATITUDE = zzb("latitude");
        FIELD_LONGITUDE = zzb("longitude");
        FIELD_ACCURACY = zzb("accuracy");
        Boolean bool = Boolean.TRUE;
        FIELD_ALTITUDE = new Field("altitude", 2, bool);
        FIELD_DISTANCE = zzb("distance");
        FIELD_HEIGHT = zzb("height");
        FIELD_WEIGHT = zzb("weight");
        FIELD_PERCENTAGE = zzb("percentage");
        FIELD_SPEED = zzb(TransferTable.COLUMN_SPEED);
        FIELD_RPM = zzb("rpm");
        zze = zza("google.android.fitness.GoalV2");
        zza("google.android.fitness.Device");
        FIELD_REVOLUTIONS = zzd("revolutions");
        FIELD_CALORIES = zzb("calories");
        FIELD_WATTS = zzb("watts");
        FIELD_VOLUME = zzb("volume");
        FIELD_MEAL_TYPE = zzf("meal_type");
        FIELD_FOOD_ITEM = new Field("food_item", 3, bool);
        FIELD_NUTRIENTS = new Field("nutrients", 4, null);
        FIELD_EXERCISE = new Field("exercise", 3, null);
        FIELD_REPETITIONS = zzf("repetitions");
        FIELD_RESISTANCE = new Field("resistance", 2, bool);
        FIELD_RESISTANCE_TYPE = zzf("resistance_type");
        FIELD_NUM_SEGMENTS = zzd("num_segments");
        FIELD_AVERAGE = zzb("average");
        FIELD_MAX = zzb("max");
        FIELD_MIN = zzb("min");
        FIELD_LOW_LATITUDE = zzb("low_latitude");
        FIELD_LOW_LONGITUDE = zzb("low_longitude");
        FIELD_HIGH_LATITUDE = zzb("high_latitude");
        FIELD_HIGH_LONGITUDE = zzb("high_longitude");
        FIELD_OCCURRENCES = zzd("occurrences");
        zzg = zzd("sensor_type");
        zzh = new Field("timestamps", 5, null);
        zzi = new Field("sensor_values", 6, null);
        FIELD_INTENSITY = zzb("intensity");
        zzj = new Field("activity_confidence", 4, null);
        zzk = zzb("probability");
        zzl = zza("google.android.fitness.SleepAttributes");
        zzm = zza("google.android.fitness.SleepSchedule");
        zzb("circumference");
        zzn = zza("google.android.fitness.PacedWalkingAttributes");
        zzo = new Field("zone_id", 3, null);
        zzp = zzb("met");
        zzq = zzb("internal_device_temperature");
        zzr = zzb("skin_temperature");
        zzs = zzd("custom_heart_rate_zone_status");
        FIELD_MIN_INT = zzd("min_int");
        FIELD_MAX_INT = zzd("max_int");
        zzt = zzf("lightly_active_duration");
        zzu = zzf("moderately_active_duration");
        zzv = zzf("very_active_duration");
        zzw = zza("google.android.fitness.SedentaryTime");
        zzx = zza("google.android.fitness.MomentaryStressAlgorithm");
        zzy = zzd("magnet_presence");
        zzz = zza("google.android.fitness.MomentaryStressAlgorithmWindows");
    }

    public Field(String str, int r2, Boolean bool) {
        Preconditions.checkNotNull(str);
        this.zzA = str;
        this.zzB = r2;
        this.zzC = bool;
    }

    public static Field zza(String str) {
        return new Field(str, 7, null);
    }

    public static Field zzb(String str) {
        return new Field(str, 2, null);
    }

    public static Field zzd(String str) {
        return new Field(str, 1, null);
    }

    public static Field zzf(String str) {
        return new Field(str, 1, Boolean.TRUE);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }
        Field field = (Field) obj;
        if (this.zzA.equals(field.zzA) && this.zzB == field.zzB) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzA.hashCode();
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zzA;
        if (this.zzB == 1) {
            str = "i";
        } else {
            str = "f";
        }
        objArr[1] = str;
        return String.format("%s(%s)", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zzA);
        OnTimeoutKt.writeInt(parcel, 2, this.zzB);
        Boolean bool = this.zzC;
        if (bool != null) {
            parcel.writeInt(262147);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        OnTimeoutKt.zzb(parcel, zza2);
    }
}
