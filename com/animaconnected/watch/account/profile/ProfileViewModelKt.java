package com.animaconnected.watch.account.profile;

import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;

/* compiled from: ProfileViewModel.kt */
/* loaded from: classes3.dex */
public final class ProfileViewModelKt {

    /* compiled from: ProfileViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] r0 = new int[FitnessProvider.Profile.Gender.values().length];
            try {
                r0[FitnessProvider.Profile.Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FitnessProvider.Profile.Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FitnessProvider.Profile.Gender.Other.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FitnessProvider.Profile.Temperature.values().length];
            try {
                r02[FitnessProvider.Profile.Temperature.Celsius.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[FitnessProvider.Profile.Temperature.Fahrenheit.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = r02;
            int[] r03 = new int[FitnessProvider.Profile.Measurement.values().length];
            try {
                r03[FitnessProvider.Profile.Measurement.Metric.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r03[FitnessProvider.Profile.Measurement.Imperial.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = r03;
        }
    }

    public static final /* synthetic */ String access$getMeasurementUnit(FitnessProvider.Profile.Measurement measurement) {
        return getMeasurementUnit(measurement);
    }

    public static final /* synthetic */ String access$getTemperatureUnit(FitnessProvider.Profile.Temperature temperature) {
        return getTemperatureUnit(temperature);
    }

    public static final /* synthetic */ String access$toReadableString(FitnessProvider.Profile.Gender gender) {
        return toReadableString(gender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getMeasurementUnit(FitnessProvider.Profile.Measurement measurement) {
        int r1;
        if (measurement == null) {
            r1 = -1;
        } else {
            r1 = WhenMappings.$EnumSwitchMapping$2[measurement.ordinal()];
        }
        if (r1 != 1) {
            if (r1 != 2) {
                return "-";
            }
            return StringsExtensionsKt.getAppString(Key.measurement_imperial);
        }
        return StringsExtensionsKt.getAppString(Key.measurement_metric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getTemperatureUnit(FitnessProvider.Profile.Temperature temperature) {
        int r1;
        if (temperature == null) {
            r1 = -1;
        } else {
            r1 = WhenMappings.$EnumSwitchMapping$1[temperature.ordinal()];
        }
        if (r1 != 1) {
            if (r1 != 2) {
                return "-";
            }
            return StringsExtensionsKt.getAppString(Key.temperature_fahrenheit);
        }
        return StringsExtensionsKt.getAppString(Key.temperature_celsius);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toReadableString(FitnessProvider.Profile.Gender gender) {
        int r1;
        if (gender == null) {
            r1 = -1;
        } else {
            r1 = WhenMappings.$EnumSwitchMapping$0[gender.ordinal()];
        }
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    return "-";
                }
                return StringsExtensionsKt.getAppString(Key.profile_gender_other);
            }
            return StringsExtensionsKt.getAppString(Key.profile_gender_female);
        }
        return StringsExtensionsKt.getAppString(Key.profile_gender_male);
    }
}
