package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class DataType extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
    public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
    public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
    public static final DataType AGGREGATE_CALORIES_EXPENDED;
    public static final DataType AGGREGATE_DISTANCE_DELTA;
    public static final DataType AGGREGATE_HEART_POINTS;
    public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
    public static final DataType AGGREGATE_HEIGHT_SUMMARY;
    public static final DataType AGGREGATE_HYDRATION;
    public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
    public static final DataType AGGREGATE_MOVE_MINUTES;
    public static final DataType AGGREGATE_NUTRITION_SUMMARY;
    public static final DataType AGGREGATE_POWER_SUMMARY;
    public static final DataType AGGREGATE_SPEED_SUMMARY;
    public static final DataType AGGREGATE_STEP_COUNT_DELTA;
    public static final DataType AGGREGATE_WEIGHT_SUMMARY;
    public static final Parcelable.Creator<DataType> CREATOR = new zzk();
    public static final DataType TYPE_ACTIVITY_SEGMENT;
    public static final DataType TYPE_BASAL_METABOLIC_RATE;
    public static final DataType TYPE_BODY_FAT_PERCENTAGE;
    public static final DataType TYPE_CALORIES_EXPENDED;
    public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
    public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
    public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
    public static final DataType TYPE_CYCLING_WHEEL_RPM;
    public static final DataType TYPE_DISTANCE_DELTA;
    public static final DataType TYPE_HEART_POINTS;
    public static final DataType TYPE_HEART_RATE_BPM;
    public static final DataType TYPE_HEIGHT;
    public static final DataType TYPE_HYDRATION;
    public static final DataType TYPE_LOCATION_SAMPLE;

    @Deprecated
    public static final DataType TYPE_LOCATION_TRACK;
    public static final DataType TYPE_MOVE_MINUTES;
    public static final DataType TYPE_NUTRITION;
    public static final DataType TYPE_POWER_SAMPLE;
    public static final DataType TYPE_SLEEP_SEGMENT;
    public static final DataType TYPE_SPEED;
    public static final DataType TYPE_STEP_COUNT_CADENCE;
    public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
    public static final DataType TYPE_STEP_COUNT_DELTA;
    public static final DataType TYPE_WEIGHT;
    public static final DataType TYPE_WORKOUT_EXERCISE;
    public static final DataType zza;
    public static final DataType zzb;
    public static final DataType zzc;
    public static final DataType zzd;
    public static final DataType zze;
    public static final DataType zzf;
    public static final DataType zzg;
    public static final DataType zzh;
    public static final DataType zzi;
    public static final DataType zzj;
    public static final DataType zzk;
    public static final DataType zzl;
    public static final DataType zzm;
    public static final DataType zzn;
    public static final DataType zzo;
    public static final DataType zzp;
    public static final DataType zzq;
    public static final DataType zzr;
    public static final DataType zzs;
    public final String zzt;
    public final List zzu;
    public final String zzv;
    public final String zzw;

    static {
        Field field = Field.FIELD_STEPS;
        DataType dataType = new DataType("com.google.step_count.delta", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        TYPE_STEP_COUNT_DELTA = dataType;
        TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field);
        Field field2 = Field.FIELD_RPM;
        TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        zza = new DataType("com.google.internal.goal", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zze);
        Field field3 = Field.FIELD_ACTIVITY;
        TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3);
        TYPE_SLEEP_SEGMENT = new DataType("com.google.sleep.segment", "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.FIELD_SLEEP_SEGMENT_TYPE);
        Field field4 = Field.FIELD_CALORIES;
        DataType dataType2 = new DataType("com.google.calories.expended", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        TYPE_CALORIES_EXPENDED = dataType2;
        TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field4);
        TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.FIELD_WATTS);
        zzb = new DataType("com.google.sensor.events", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzg, Field.zzh, Field.zzi);
        TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.FIELD_BPM);
        zzc = new DataType("com.google.respiratory_rate", "https://www.googleapis.com/auth/fitness.respiratory_rate.read", "https://www.googleapis.com/auth/fitness.respiratory_rate.write", Field.zzd);
        Field field5 = Field.FIELD_LATITUDE;
        Field field6 = Field.FIELD_LONGITUDE;
        Field field7 = Field.FIELD_ACCURACY;
        Field field8 = Field.FIELD_ALTITUDE;
        TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        TYPE_LOCATION_TRACK = new DataType("com.google.location.track", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field5, field6, field7, field8);
        DataType dataType3 = new DataType("com.google.distance.delta", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_DISTANCE);
        TYPE_DISTANCE_DELTA = dataType3;
        TYPE_SPEED = new DataType("com.google.speed", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_SPEED);
        Field field9 = Field.FIELD_REVOLUTIONS;
        TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field9);
        TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field2);
        TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field9);
        TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field2);
        TYPE_HEIGHT = new DataType("com.google.height", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_HEIGHT);
        TYPE_WEIGHT = new DataType("com.google.weight", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_WEIGHT);
        TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", Field.FIELD_PERCENTAGE);
        Field field10 = Field.FIELD_NUTRIENTS;
        Field field11 = Field.FIELD_MEAL_TYPE;
        TYPE_NUTRITION = new DataType("com.google.nutrition", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11, Field.FIELD_FOOD_ITEM);
        DataType dataType4 = new DataType("com.google.hydration", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", Field.FIELD_VOLUME);
        TYPE_HYDRATION = dataType4;
        TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.zza, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE);
        Field field12 = Field.FIELD_DURATION;
        DataType dataType5 = new DataType("com.google.active_minutes", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field12);
        TYPE_MOVE_MINUTES = dataType5;
        AGGREGATE_MOVE_MINUTES = dataType5;
        zzd = new DataType("com.google.device_on_body", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzk);
        AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field3, field12, Field.FIELD_NUM_SEGMENTS);
        Field field13 = Field.FIELD_AVERAGE;
        Field field14 = Field.FIELD_MAX;
        Field field15 = Field.FIELD_MIN;
        AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        AGGREGATE_STEP_COUNT_DELTA = dataType;
        AGGREGATE_DISTANCE_DELTA = dataType3;
        AGGREGATE_CALORIES_EXPENDED = dataType2;
        Field field16 = Field.FIELD_INTENSITY;
        TYPE_HEART_POINTS = new DataType("com.google.heart_minutes", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16);
        AGGREGATE_HEART_POINTS = new DataType("com.google.heart_minutes.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field16, field12);
        AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", field13, field14, field15);
        AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE);
        AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", field13, field14, field15);
        AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", field13, field14, field15);
        AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_HEIGHT_SUMMARY = new DataType("com.google.height.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", field13, field14, field15);
        AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", field10, field11);
        AGGREGATE_HYDRATION = dataType4;
        zze = new DataType("com.google.activity.samples", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzj);
        zzf = new DataType("com.google.internal.sleep_attributes", "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzl);
        zzg = new DataType("com.google.internal.sleep_schedule", "https://www.googleapis.com/auth/fitness.sleep.read", "https://www.googleapis.com/auth/fitness.sleep.write", Field.zzm);
        zzh = new DataType("com.google.internal.paced_walking_attributes", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzn);
        zzi = new DataType("com.google.time_zone_change", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", Field.zzo);
        zzj = new DataType("com.google.internal.met", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzp);
        zzk = new DataType("com.google.internal.internal_device_temperature", "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzq);
        zzl = new DataType("com.google.internal.skin_temperature", "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", Field.zzr);
        Field field17 = Field.zzs;
        Field field18 = Field.FIELD_MIN_INT;
        zzm = new DataType("com.google.internal.custom_heart_rate_zone", "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", field17, field18, field18);
        zzn = new DataType("com.google.internal.active_minutes_combined", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzt, Field.zzu, Field.zzv);
        zzo = new DataType("com.google.internal.sedentary_time", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzw);
        zzp = new DataType("com.google.internal.custom_max_heart_rate", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.FIELD_MAX_INT);
        zzq = new DataType("com.google.internal.momentary_stress_algorithm", "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzx);
        zzr = new DataType("com.google.internal.magnetic_field_presence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", Field.zzy);
        zzs = new DataType("com.google.internal.momentary_stress_algorithm_windows", "https://www.googleapis.com/auth/fitness.heart_rate.read", "https://www.googleapis.com/auth/fitness.heart_rate.write", Field.zzz);
    }

    public DataType(String str, String str2, String str3, Field... fieldArr) {
        this.zzt = str;
        this.zzu = Collections.unmodifiableList(Arrays.asList(fieldArr));
        this.zzv = str2;
        this.zzw = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataType)) {
            return false;
        }
        DataType dataType = (DataType) obj;
        if (this.zzt.equals(dataType.zzt) && this.zzu.equals(dataType.zzu)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzt.hashCode();
    }

    public final String toString() {
        return String.format("DataType{%s%s}", this.zzt, this.zzu);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r4) {
        int zza2 = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeString(parcel, 1, this.zzt);
        OnTimeoutKt.writeTypedList(parcel, 2, this.zzu);
        OnTimeoutKt.writeString(parcel, 3, this.zzv);
        OnTimeoutKt.writeString(parcel, 4, this.zzw);
        OnTimeoutKt.zzb(parcel, zza2);
    }

    public DataType(String str, String str2, String str3, ArrayList arrayList) {
        this.zzt = str;
        this.zzu = Collections.unmodifiableList(arrayList);
        this.zzv = str2;
        this.zzw = str3;
    }
}
