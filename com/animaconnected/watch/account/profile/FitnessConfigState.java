package com.animaconnected.watch.account.profile;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileViewModel.kt */
/* loaded from: classes3.dex */
public final class FitnessConfigState {
    private final String dateOfBirth;
    private final String gender;
    private final String height;
    private final String measurement;
    private final String temperature;
    private final String weight;

    public FitnessConfigState(String dateOfBirth, String gender, String height, String weight, String measurement, String temperature) {
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.measurement = measurement;
        this.temperature = temperature;
    }

    public static /* synthetic */ FitnessConfigState copy$default(FitnessConfigState fitnessConfigState, String str, String str2, String str3, String str4, String str5, String str6, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            str = fitnessConfigState.dateOfBirth;
        }
        if ((r11 & 2) != 0) {
            str2 = fitnessConfigState.gender;
        }
        String str7 = str2;
        if ((r11 & 4) != 0) {
            str3 = fitnessConfigState.height;
        }
        String str8 = str3;
        if ((r11 & 8) != 0) {
            str4 = fitnessConfigState.weight;
        }
        String str9 = str4;
        if ((r11 & 16) != 0) {
            str5 = fitnessConfigState.measurement;
        }
        String str10 = str5;
        if ((r11 & 32) != 0) {
            str6 = fitnessConfigState.temperature;
        }
        return fitnessConfigState.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.dateOfBirth;
    }

    public final String component2() {
        return this.gender;
    }

    public final String component3() {
        return this.height;
    }

    public final String component4() {
        return this.weight;
    }

    public final String component5() {
        return this.measurement;
    }

    public final String component6() {
        return this.temperature;
    }

    public final FitnessConfigState copy(String dateOfBirth, String gender, String height, String weight, String measurement, String temperature) {
        Intrinsics.checkNotNullParameter(dateOfBirth, "dateOfBirth");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(height, "height");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        Intrinsics.checkNotNullParameter(temperature, "temperature");
        return new FitnessConfigState(dateOfBirth, gender, height, weight, measurement, temperature);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessConfigState)) {
            return false;
        }
        FitnessConfigState fitnessConfigState = (FitnessConfigState) obj;
        if (Intrinsics.areEqual(this.dateOfBirth, fitnessConfigState.dateOfBirth) && Intrinsics.areEqual(this.gender, fitnessConfigState.gender) && Intrinsics.areEqual(this.height, fitnessConfigState.height) && Intrinsics.areEqual(this.weight, fitnessConfigState.weight) && Intrinsics.areEqual(this.measurement, fitnessConfigState.measurement) && Intrinsics.areEqual(this.temperature, fitnessConfigState.temperature)) {
            return true;
        }
        return false;
    }

    public final String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getHeight() {
        return this.height;
    }

    public final String getMeasurement() {
        return this.measurement;
    }

    public final String getTemperature() {
        return this.temperature;
    }

    public final String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return this.temperature.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.measurement, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.weight, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.height, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.gender, this.dateOfBirth.hashCode() * 31, 31), 31), 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FitnessConfigState(dateOfBirth=");
        sb.append(this.dateOfBirth);
        sb.append(", gender=");
        sb.append(this.gender);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", weight=");
        sb.append(this.weight);
        sb.append(", measurement=");
        sb.append(this.measurement);
        sb.append(", temperature=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.temperature, ')');
    }
}
