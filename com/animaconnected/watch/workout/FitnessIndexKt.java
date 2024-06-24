package com.animaconnected.watch.workout;

import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.FitnessIndexAgeGroup;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantKt;
import kotlinx.datetime.TimeZone;

/* compiled from: FitnessIndex.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexKt {
    private static final VO2MaxLimits fallbackVO2MaxLimits = new VO2MaxLimits(54, 48, 42, 36);
    private static final Map<FitnessProvider.Profile.Gender, Map<FitnessIndexAgeGroup, VO2MaxLimits>> vo2MaxMappings;

    /* compiled from: FitnessIndex.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FitnessIndexCategory.values().length];
            try {
                r0[FitnessIndexCategory.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FitnessIndexCategory.FAIR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FitnessIndexCategory.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FitnessIndexCategory.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FitnessIndexCategory.SUPERIOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        FitnessProvider.Profile.Gender gender = FitnessProvider.Profile.Gender.Male;
        FitnessIndexAgeGroup fitnessIndexAgeGroup = FitnessIndexAgeGroup.Twenties;
        Pair pair = new Pair(fitnessIndexAgeGroup, new VO2MaxLimits(60, 55, 48, 32));
        FitnessIndexAgeGroup fitnessIndexAgeGroup2 = FitnessIndexAgeGroup.Thirties;
        Pair pair2 = new Pair(fitnessIndexAgeGroup2, new VO2MaxLimits(56, 49, 42, 30));
        FitnessIndexAgeGroup fitnessIndexAgeGroup3 = FitnessIndexAgeGroup.Fourties;
        Pair pair3 = new Pair(fitnessIndexAgeGroup3, new VO2MaxLimits(52, 45, 38, 27));
        FitnessIndexAgeGroup fitnessIndexAgeGroup4 = FitnessIndexAgeGroup.Fifties;
        Pair pair4 = new Pair(fitnessIndexAgeGroup4, new VO2MaxLimits(46, 40, 33, 23));
        FitnessIndexAgeGroup fitnessIndexAgeGroup5 = FitnessIndexAgeGroup.Sixties;
        Pair pair5 = new Pair(fitnessIndexAgeGroup5, new VO2MaxLimits(40, 34, 28, 20));
        FitnessIndexAgeGroup fitnessIndexAgeGroup6 = FitnessIndexAgeGroup.Seventies;
        vo2MaxMappings = MapsKt__MapsKt.mapOf(new Pair(gender, MapsKt__MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, new Pair(fitnessIndexAgeGroup6, new VO2MaxLimits(37, 30, 24, 17)))), new Pair(FitnessProvider.Profile.Gender.Female, MapsKt__MapsKt.mapOf(new Pair(fitnessIndexAgeGroup, new VO2MaxLimits(51, 44, 38, 24)), new Pair(fitnessIndexAgeGroup2, new VO2MaxLimits(41, 36, 30, 21)), new Pair(fitnessIndexAgeGroup3, new VO2MaxLimits(38, 32, 27, 19)), new Pair(fitnessIndexAgeGroup4, new VO2MaxLimits(32, 28, 23, 17)), new Pair(fitnessIndexAgeGroup5, new VO2MaxLimits(27, 24, 20, 15)), new Pair(fitnessIndexAgeGroup6, new VO2MaxLimits(23, 21, 18, 14)))));
    }

    public static final FitnessIndexAgeGroup getFitnessIndexAgeGroup(FitnessProvider.Profile profile, Instant instant) {
        long j;
        Intrinsics.checkNotNullParameter(profile, "<this>");
        FitnessIndexAgeGroup.Companion companion = FitnessIndexAgeGroup.Companion;
        Instant.Companion companion2 = Instant.Companion;
        Long dateOfBirth = profile.getDateOfBirth();
        if (dateOfBirth != null) {
            j = dateOfBirth.longValue();
        } else {
            j = 0;
        }
        companion2.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(j);
        if (instant == null) {
            companion2.getClass();
            instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        }
        TimeZone.Companion.getClass();
        return companion.fromYears(InstantKt.yearsUntil(fromEpochMilliseconds, instant, TimeZone.Companion.currentSystemDefault()));
    }

    public static final String getName(FitnessIndexCategory fitnessIndexCategory) {
        Intrinsics.checkNotNullParameter(fitnessIndexCategory, "<this>");
        int r1 = WhenMappings.$EnumSwitchMapping$0[fitnessIndexCategory.ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    if (r1 != 4) {
                        if (r1 == 5) {
                            return StringsExtensionsKt.getAppString(Key.fitness_index_superior_title);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return StringsExtensionsKt.getAppString(Key.fitness_index_excellent_title);
                }
                return StringsExtensionsKt.getAppString(Key.fitness_index_good_title);
            }
            return StringsExtensionsKt.getAppString(Key.fitness_index_fair_title);
        }
        return StringsExtensionsKt.getAppString(Key.fitness_index_poor_title);
    }

    public static final IntRange getRange(FitnessIndexCategory fitnessIndexCategory, FitnessProvider.Profile profile, Instant instant) {
        final VO2MaxLimits vO2MaxLimits;
        Intrinsics.checkNotNullParameter(fitnessIndexCategory, "<this>");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Map<FitnessProvider.Profile.Gender, Map<FitnessIndexAgeGroup, VO2MaxLimits>> map = vo2MaxMappings;
        FitnessProvider.Profile.Gender gender = profile.getGender();
        if (gender == null) {
            gender = FitnessProvider.Profile.Gender.Male;
        }
        Map<FitnessIndexAgeGroup, VO2MaxLimits> map2 = map.get(gender);
        final FitnessIndexAgeGroup fitnessIndexAgeGroup = getFitnessIndexAgeGroup(profile, instant);
        if (map2 == null || (vO2MaxLimits = map2.get(fitnessIndexAgeGroup)) == null) {
            vO2MaxLimits = fallbackVO2MaxLimits;
        }
        final int ceil = (int) Math.ceil((vO2MaxLimits.getSuperior() - vO2MaxLimits.getExcellent()) * 0.6666666666666666d);
        LogKt.verbose$default((Object) fitnessIndexCategory, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.workout.FitnessIndexKt$getRange$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Using ageGroup=" + FitnessIndexAgeGroup.this + " with the following limits limits=" + vO2MaxLimits + ", tenPercentile=" + ceil;
            }
        }, 7, (Object) null);
        int r8 = WhenMappings.$EnumSwitchMapping$0[fitnessIndexCategory.ordinal()];
        if (r8 != 1) {
            if (r8 != 2) {
                if (r8 != 3) {
                    if (r8 != 4) {
                        if (r8 == 5) {
                            return new IntRange(vO2MaxLimits.getSuperior(), vO2MaxLimits.getSuperior() + ceil);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new IntRange(vO2MaxLimits.getExcellent(), vO2MaxLimits.getSuperior());
                }
                return new IntRange(vO2MaxLimits.getGood(), vO2MaxLimits.getExcellent());
            }
            return new IntRange(vO2MaxLimits.getFair(), vO2MaxLimits.getGood());
        }
        return new IntRange(vO2MaxLimits.getFair() - ceil, vO2MaxLimits.getFair());
    }
}
