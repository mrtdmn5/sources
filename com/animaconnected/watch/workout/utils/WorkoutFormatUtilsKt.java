package com.animaconnected.watch.workout.utils;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import androidx.profileinstaller.FileSectionType$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.NumberFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Split;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: WorkoutFormatUtils.kt */
/* loaded from: classes3.dex */
public final class WorkoutFormatUtilsKt {
    private static final Lazy strings$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StringsBackend>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$strings$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StringsBackend invoke() {
            return ServiceLocator.INSTANCE.getStringsBackend();
        }
    });
    private static final Lazy kmMilesFormatter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NumberFormatter>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$kmMilesFormatter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormatter invoke() {
            StringsBackend strings;
            strings = WorkoutFormatUtilsKt.getStrings();
            return strings.createNumberFormatter(1, 6, 2, 2);
        }
    });
    private static final Lazy meterFormatter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NumberFormatter>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$meterFormatter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormatter invoke() {
            StringsBackend strings;
            strings = WorkoutFormatUtilsKt.getStrings();
            return strings.createNumberFormatter(1, 6, 0, 0);
        }
    });
    private static final Lazy splitDistanceFormatter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NumberFormatter>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$splitDistanceFormatter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormatter invoke() {
            StringsBackend strings;
            strings = WorkoutFormatUtilsKt.getStrings();
            return strings.createNumberFormatter(1, 5, 0, 2);
        }
    });
    private static final Lazy centimeterFormatter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NumberFormatter>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$centimeterFormatter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormatter invoke() {
            StringsBackend strings;
            strings = WorkoutFormatUtilsKt.getStrings();
            return strings.createNumberFormatter(0, 6, 0, 1);
        }
    });
    private static final Lazy kiloFormatter$delegate = LazyKt__LazyJVMKt.lazy(new Function0<NumberFormatter>() { // from class: com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt$kiloFormatter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final NumberFormatter invoke() {
            StringsBackend strings;
            strings = WorkoutFormatUtilsKt.getStrings();
            return strings.createNumberFormatter(1, 6, 0, 1);
        }
    });

    public static final String formatDistance(double d, FitnessProvider.Profile.Measurement measurement, boolean z) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            return formatMetricDistance(d, z);
        }
        return formatImperialDistance(d, z);
    }

    public static /* synthetic */ String formatDistance$default(double d, FitnessProvider.Profile.Measurement measurement, boolean z, int r4, Object obj) {
        if ((r4 & 4) != 0) {
            z = true;
        }
        return formatDistance(d, measurement, z);
    }

    /* renamed from: formatDuration-LRDsOJo */
    public static final String m1573formatDurationLRDsOJo(long j) {
        boolean z;
        boolean z2;
        boolean z3;
        long m1679getInWholeSecondsimpl = Duration.m1679getInWholeSecondsimpl(j);
        boolean z4 = true;
        if (1 <= m1679getInWholeSecondsimpl && m1679getInWholeSecondsimpl < 10) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return FileSectionType$$ExternalSyntheticOutline0.m("00:0", m1679getInWholeSecondsimpl);
        }
        if (10 <= m1679getInWholeSecondsimpl && m1679getInWholeSecondsimpl < 60) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return FileSectionType$$ExternalSyntheticOutline0.m("00:", m1679getInWholeSecondsimpl);
        }
        if (60 <= m1679getInWholeSecondsimpl && m1679getInWholeSecondsimpl < 3600) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return m1582getTimeMMSSLRDsOJo(j);
        }
        if (3600 > m1679getInWholeSecondsimpl || m1679getInWholeSecondsimpl > Long.MAX_VALUE) {
            z4 = false;
        }
        if (z4) {
            return m1581getTimeHHMMSSLRDsOJo(j);
        }
        return "00:00";
    }

    public static final String formatDurationHourMinutes(long j) {
        int r0 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
        String valueOf = String.valueOf(Duration.m1676getInWholeHoursimpl(duration));
        String valueOf2 = String.valueOf(Duration.m1678getInWholeMinutesimpl(duration) % 60);
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(valueOf);
        m.append(StringsExtensionsKt.getAppString(Key.time_unit_hour));
        m.append(' ');
        m.append(valueOf2);
        m.append(StringsExtensionsKt.getAppString(Key.time_unit_minute));
        return m.toString();
    }

    /* renamed from: formatElapsedTime-LRDsOJo */
    public static final String m1574formatElapsedTimeLRDsOJo(long j) {
        boolean z;
        long m1676getInWholeHoursimpl = Duration.m1676getInWholeHoursimpl(j);
        int m1680getMinutesComponentimpl = Duration.m1680getMinutesComponentimpl(j);
        int m1682getSecondsComponentimpl = Duration.m1682getSecondsComponentimpl(j);
        Duration.m1681getNanosecondsComponentimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m1676getInWholeHoursimpl > 0) {
            sb.append(m1676getInWholeHoursimpl + StringsExtensionsKt.getAppString(Key.time_unit_hour) + ' ');
        }
        if (m1680getMinutesComponentimpl > 0) {
            sb.append(m1680getMinutesComponentimpl + StringsExtensionsKt.getAppString(Key.time_unit_minute) + ' ');
        }
        if (m1682getSecondsComponentimpl > 0) {
            sb.append(m1682getSecondsComponentimpl + StringsExtensionsKt.getAppString(Key.time_unit_second));
        }
        if (sb.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sb.append("0" + StringsExtensionsKt.getAppString(Key.time_unit_second));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return StringsKt__StringsKt.trim(sb2).toString();
    }

    public static final String formatElevation(int r4, FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            return getMeterFormatter().format(r4) + ' ' + StringsExtensionsKt.getAppString(Key.units_distance_m);
        }
        return getMeterFormatter().format(ProfileUtilsKt.meterToFeet(r4)) + ' ' + StringsExtensionsKt.getAppString(Key.units_distance_feet);
    }

    public static final String formatElevationCentimeter(int r6, FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            return getCentimeterFormatter().format(r6 / 100.0d) + ' ' + StringsExtensionsKt.getAppString(Key.units_distance_m);
        }
        return getCentimeterFormatter().format(ProfileUtilsKt.meterToFeet(r6)) + ' ' + StringsExtensionsKt.getAppString(Key.units_distance_feet);
    }

    public static final String formatImperialDistance(double d, boolean z) {
        String format = getKmMilesFormatter().format(ProfileUtilsKt.meterToMiles(d));
        String appString = StringsExtensionsKt.getAppString(Key.units_distance_miles);
        if (z) {
            return format + ' ' + appString;
        }
        return format;
    }

    public static /* synthetic */ String formatImperialDistance$default(double d, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        return formatImperialDistance(d, z);
    }

    public static final String formatInstantHourMinutes(Instant instant, TimeZone timeZone, boolean z) {
        String maybePadWithLeadingZero;
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, timeZone);
        StringBuilder sb = new StringBuilder();
        sb.append(maybePadWithLeadingZero(localDateTime.getHour()));
        sb.append(':');
        if (z) {
            maybePadWithLeadingZero = "00";
        } else {
            maybePadWithLeadingZero = maybePadWithLeadingZero(localDateTime.getMinute());
        }
        sb.append(maybePadWithLeadingZero);
        return sb.toString();
    }

    public static /* synthetic */ String formatInstantHourMinutes$default(Instant instant, TimeZone timeZone, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        if ((r3 & 4) != 0) {
            z = false;
        }
        return formatInstantHourMinutes(instant, timeZone, z);
    }

    public static final String formatMetricDistance(double d, boolean z) {
        if (d >= 1000.0d) {
            String format = getKmMilesFormatter().format(d / 1000.0d);
            String appString = StringsExtensionsKt.getAppString(Key.units_distance_km);
            if (z) {
                return format + ' ' + appString;
            }
            return format;
        }
        String format2 = getMeterFormatter().format(Math.max(0.0d, d));
        String appString2 = StringsExtensionsKt.getAppString(Key.units_distance_m);
        if (z) {
            return format2 + ' ' + appString2;
        }
        return format2;
    }

    public static /* synthetic */ String formatMetricDistance$default(double d, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        return formatMetricDistance(d, z);
    }

    /* renamed from: formatPace-rnQQ1Ag */
    public static final String m1575formatPacernQQ1Ag(long j, double d, FitnessProvider.Profile.Measurement measurement, boolean z) {
        double d2;
        String str;
        boolean z2;
        long duration;
        Key key;
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        FitnessProvider.Profile.Measurement measurement2 = FitnessProvider.Profile.Measurement.Metric;
        if (measurement == measurement2) {
            d2 = 1000.0d;
        } else {
            d2 = 1609.344d;
        }
        double d3 = ((int) d) / d2;
        if (z) {
            if (measurement == measurement2) {
                key = Key.units_distance_km;
            } else {
                key = Key.units_distance_miles;
            }
            str = " " + StringsExtensionsKt.getAppString(Key.time_unit_minute_short) + '/' + StringsExtensionsKt.getAppString(key);
        } else {
            str = "";
        }
        if (d3 <= 0.0d) {
            return ConstraintSet$$ExternalSyntheticOutline0.m("00:00", str);
        }
        int r8 = Duration.$r8$clinit;
        int roundToInt = MathKt__MathJVMKt.roundToInt(d3);
        if (roundToInt == d3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && roundToInt != 0) {
            duration = Duration.m1674divUwyO8pc(roundToInt, j);
        } else {
            DurationUnit m1683getStorageUnitimpl = Duration.m1683getStorageUnitimpl(j);
            duration = DurationKt.toDuration(Duration.m1688toDoubleimpl(j, m1683getStorageUnitimpl) / d3, m1683getStorageUnitimpl);
        }
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), m1582getTimeMMSSLRDsOJo(duration), str);
    }

    /* renamed from: formatPace-rnQQ1Ag$default */
    public static /* synthetic */ String m1576formatPacernQQ1Ag$default(long j, double d, FitnessProvider.Profile.Measurement measurement, boolean z, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            z = true;
        }
        return m1575formatPacernQQ1Ag(j, d, measurement, z);
    }

    /* renamed from: formatSpeed-rnQQ1Ag */
    public static final String m1577formatSpeedrnQQ1Ag(long j, double d, FitnessProvider.Profile.Measurement measurement, boolean z) {
        double d2;
        String str;
        Key key;
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        FitnessProvider.Profile.Measurement measurement2 = FitnessProvider.Profile.Measurement.Metric;
        if (measurement == measurement2) {
            d2 = 1000.0d;
        } else {
            d2 = 1609.344d;
        }
        double m1688toDoubleimpl = Duration.m1688toDoubleimpl(j, DurationUnit.MINUTES);
        double d3 = d / d2;
        if (z) {
            if (measurement == measurement2) {
                key = Key.units_distance_km;
            } else {
                key = Key.units_distance_miles;
            }
            str = " " + StringsExtensionsKt.getAppString(key) + '/' + StringsExtensionsKt.getAppString(Key.time_unit_hour);
        } else {
            str = "";
        }
        if (m1688toDoubleimpl <= 0.0d) {
            return getKiloFormatter().format(0.0d) + str;
        }
        return getKiloFormatter().format(d3 / (m1688toDoubleimpl / 60.0d)) + str;
    }

    /* renamed from: formatSpeed-rnQQ1Ag$default */
    public static /* synthetic */ String m1578formatSpeedrnQQ1Ag$default(long j, double d, FitnessProvider.Profile.Measurement measurement, boolean z, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            z = true;
        }
        return m1577formatSpeedrnQQ1Ag(j, d, measurement, z);
    }

    public static final String formatSplitDistance(double d, FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            return getSplitDistanceFormatter().format(d / 1000.0d);
        }
        return getSplitDistanceFormatter().format(ProfileUtilsKt.meterToMiles(d));
    }

    public static final String formatToKilo(int r6) {
        if (r6 < 1) {
            return "0";
        }
        if (r6 < 1000) {
            return String.valueOf(r6);
        }
        return getKiloFormatter().format(r6 / 1000.0d) + StringsExtensionsKt.getAppString(Key.kilo_symbol);
    }

    /* renamed from: formatToWholeHours-LRDsOJo */
    public static final String m1579formatToWholeHoursLRDsOJo(long j) {
        return Duration.m1676getInWholeHoursimpl(j) + StringsExtensionsKt.getAppString(Key.time_unit_hour);
    }

    private static final NumberFormatter getCentimeterFormatter() {
        return (NumberFormatter) centimeterFormatter$delegate.getValue();
    }

    private static final NumberFormatter getKiloFormatter() {
        return (NumberFormatter) kiloFormatter$delegate.getValue();
    }

    private static final NumberFormatter getKmMilesFormatter() {
        return (NumberFormatter) kmMilesFormatter$delegate.getValue();
    }

    private static final NumberFormatter getMeterFormatter() {
        return (NumberFormatter) meterFormatter$delegate.getValue();
    }

    private static final NumberFormatter getSplitDistanceFormatter() {
        return (NumberFormatter) splitDistanceFormatter$delegate.getValue();
    }

    public static final StringsBackend getStrings() {
        return (StringsBackend) strings$delegate.getValue();
    }

    /* renamed from: getTimeHHMM-LRDsOJo */
    private static final String m1580getTimeHHMMLRDsOJo(long j) {
        return m1583toHourStringLRDsOJo(j) + ':' + m1584toMinuteStringLRDsOJo(j);
    }

    /* renamed from: getTimeHHMMSS-LRDsOJo */
    private static final String m1581getTimeHHMMSSLRDsOJo(long j) {
        return m1583toHourStringLRDsOJo(j) + ':' + m1584toMinuteStringLRDsOJo(j) + ':' + m1585toSecondsStringLRDsOJo(j);
    }

    /* renamed from: getTimeMMSS-LRDsOJo */
    private static final String m1582getTimeMMSSLRDsOJo(long j) {
        return m1584toMinuteStringLRDsOJo(j) + ':' + m1585toSecondsStringLRDsOJo(j);
    }

    private static final String maybePadWithLeadingZero(long j) {
        return StringsKt__StringsKt.padStart(String.valueOf(j), 2, '0');
    }

    public static final float pace(Split split, FitnessProvider.Profile.Measurement measurement) {
        double d;
        Intrinsics.checkNotNullParameter(split, "<this>");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        int r0 = Duration.$r8$clinit;
        double m1688toDoubleimpl = Duration.m1688toDoubleimpl(DurationKt.toDuration(split.getDuration(), DurationUnit.MILLISECONDS), DurationUnit.MINUTES);
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            d = 1000.0d;
        } else {
            d = 1609.344d;
        }
        return (float) (m1688toDoubleimpl / (split.getDistance() / d));
    }

    /* renamed from: toHourString-LRDsOJo */
    private static final String m1583toHourStringLRDsOJo(long j) {
        return maybePadWithLeadingZero(Duration.m1676getInWholeHoursimpl(j));
    }

    /* renamed from: toMinuteString-LRDsOJo */
    private static final String m1584toMinuteStringLRDsOJo(long j) {
        return maybePadWithLeadingZero(Duration.m1678getInWholeMinutesimpl(j) % 60);
    }

    public static final String toReadablePast(long j, DateFormatter dateFormatter, DateFormatter timeFormatter) {
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(timeFormatter, "timeFormatter");
        Instant.Companion.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(j);
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        if (fromEpochMilliseconds.compareTo(startOfDay$default) > 0) {
            return StringsExtensionsKt.getAppString(Key.timestamp_text_today) + ' ' + DateFormatter.format$default(timeFormatter, j, null, false, 6, null);
        }
        int r2 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.DAYS;
        if (fromEpochMilliseconds.compareTo(startOfDay$default.m1705minusLRDsOJo(DurationKt.toDuration(1, durationUnit))) > 0) {
            return StringsExtensionsKt.getAppString(Key.timestamp_text_yesterday) + ' ' + DateFormatter.format$default(timeFormatter, j, null, false, 6, null);
        }
        if (fromEpochMilliseconds.compareTo(startOfDay$default.m1705minusLRDsOJo(DurationKt.toDuration(6, durationUnit))) > 0) {
            return DateFormatter.format$default(dateFormatter, j, null, false, 6, null);
        }
        return StringsExtensionsKt.getAppString(Key.timestamp_text_many_days_ago, String.valueOf(Duration.m1689toLongimpl(DurationKt.toDuration(DateTimeUtilsKt.currentTimeMillis() - j, DurationUnit.MILLISECONDS), durationUnit)));
    }

    public static final String toReadablePastDay(long j, DateFormatter dateFormatter) {
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Instant.Companion.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(j);
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        if (fromEpochMilliseconds.compareTo(startOfDay$default) > 0) {
            return StringsExtensionsKt.getAppString(Key.timestamp_text_today);
        }
        int r2 = Duration.$r8$clinit;
        if (fromEpochMilliseconds.compareTo(startOfDay$default.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS))) > 0) {
            return StringsExtensionsKt.getAppString(Key.timestamp_text_yesterday);
        }
        return DateFormatter.format$default(dateFormatter, j, null, false, 6, null);
    }

    /* renamed from: toSecondsString-LRDsOJo */
    private static final String m1585toSecondsStringLRDsOJo(long j) {
        return maybePadWithLeadingZero(Duration.m1679getInWholeSecondsimpl(j) % 60);
    }

    private static final String maybePadWithLeadingZero(int r2) {
        return StringsKt__StringsKt.padStart(String.valueOf(r2), 2, '0');
    }
}
