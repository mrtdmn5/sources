package com.animaconnected.watch.workout.utils;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.DBProfile;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantKt;
import kotlinx.datetime.TimeZone;

/* compiled from: BMRUtils.kt */
/* loaded from: classes3.dex */
public final class BMRUtilsKt {
    private static final FitnessProvider.Profile.Gender defaultGender = FitnessProvider.Profile.Gender.Male;
    private static final int defaultHeightAge = 30;
    private static final int defaultHeightMm = 1750;
    private static final int defaultWeightGram = 78000;

    public static final float calculateBMI(int r4, int r5) {
        return r5 / ((float) Math.pow(r4 / 100.0f, 2.0f));
    }

    public static final int calculateBMR(FitnessQueries db, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(timePeriod.getStart(), null, 2, null);
        Instant startOfDay$default2 = DateTimeUtilsKt.getStartOfDay$default(timePeriod.getEnd(), null, 2, null);
        int r4 = Duration.$r8$clinit;
        Instant m1706plusLRDsOJo = startOfDay$default2.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        DBProfile executeAsOneOrNull = db.getProfileForTimestamp(timePeriod.getStart().toEpochMilliseconds()).executeAsOneOrNull();
        List<DBProfile> executeAsList = db.getProfilesInInterval(startOfDay$default.toEpochMilliseconds(), m1706plusLRDsOJo.toEpochMilliseconds()).executeAsList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : executeAsList) {
            Instant.Companion companion = Instant.Companion;
            long timestamp = ((DBProfile) obj).getTimestamp();
            companion.getClass();
            Instant startOfDay$default3 = DateTimeUtilsKt.getStartOfDay$default(Instant.Companion.fromEpochMilliseconds(timestamp), null, 2, null);
            Object obj2 = linkedHashMap.get(startOfDay$default3);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(startOfDay$default3, obj2);
            }
            ((List) obj2).add(obj);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), (DBProfile) CollectionsKt___CollectionsKt.last((List) entry.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (((Instant) entry2.getKey()).compareTo(timePeriod.getStart()) >= 0 && ((Instant) entry2.getKey()).compareTo(timePeriod.getEnd()) < 0) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        Map plus = MapsKt__MapsKt.plus(MapsKt__MapsKt.plus(MapsKt__MapsJVMKt.mapOf(new Pair(timePeriod.getStart(), executeAsOneOrNull)), linkedHashMap3), new Pair(timePeriod.getEnd(), null));
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        CollectionsKt___CollectionsKt.windowed$default(plus.entrySet(), 2, 1, new Function1<List<? extends Map.Entry<? extends Instant, ? extends DBProfile>>, Unit>() { // from class: com.animaconnected.watch.workout.utils.BMRUtilsKt$calculateBMR$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Map.Entry<? extends Instant, ? extends DBProfile>> list) {
                invoke2((List<? extends Map.Entry<Instant, DBProfile>>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Map.Entry<Instant, DBProfile>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Map.Entry entry3 = (Map.Entry) CollectionsKt___CollectionsKt.first((List) it);
                DBProfile dBProfile = (DBProfile) entry3.getValue();
                Map.Entry entry4 = (Map.Entry) CollectionsKt___CollectionsKt.last(it);
                BmrProfile bmrProfile = BMRUtilsKt.getBmrProfile(dBProfile);
                Ref$IntRef ref$IntRef2 = Ref$IntRef.this;
                ref$IntRef2.element = BMRUtilsKt.calculateBMR(bmrProfile.getWeight(), bmrProfile.getHeight(), bmrProfile.getAge(), bmrProfile.isMale(), new TimePeriod((Instant) entry3.getKey(), (Instant) entry4.getKey())) + ref$IntRef2.element;
            }
        }, 4);
        return ref$IntRef.element;
    }

    public static final BmrProfile getBmrProfile(DBProfile dBProfile) {
        int r0;
        int r1;
        int r2;
        Integer num;
        boolean z;
        Long ts_of_birth;
        Integer height;
        Integer weight;
        if (dBProfile != null && (weight = dBProfile.getWeight()) != null) {
            r0 = weight.intValue();
        } else {
            r0 = defaultWeightGram;
        }
        int r02 = r0 / 1000;
        if (dBProfile != null && (height = dBProfile.getHeight()) != null) {
            r1 = height.intValue();
        } else {
            r1 = defaultHeightMm;
        }
        int r12 = r1 / 10;
        if (dBProfile != null && (ts_of_birth = dBProfile.getTs_of_birth()) != null) {
            long longValue = ts_of_birth.longValue();
            Instant.Companion.getClass();
            Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(longValue);
            Instant now = DateTimeUtilsKt.now();
            TimeZone.Companion.getClass();
            r2 = InstantKt.yearsUntil(fromEpochMilliseconds, now, TimeZone.UTC);
        } else {
            r2 = 30;
        }
        FitnessProvider.Profile.Gender.Companion companion = FitnessProvider.Profile.Gender.Companion;
        if (dBProfile != null) {
            num = dBProfile.getGender();
        } else {
            num = null;
        }
        FitnessProvider.Profile.Gender fromId$watch_release = companion.fromId$watch_release(num);
        if (fromId$watch_release == null) {
            fromId$watch_release = defaultGender;
        }
        if (fromId$watch_release == FitnessProvider.Profile.Gender.Male) {
            z = true;
        } else {
            z = false;
        }
        return new BmrProfile(r02, r12, r2, z);
    }

    public static final int calculateBMR(int r4, int r5, int r6, boolean z, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        float calculateBMR = calculateBMR(r4, r5, r6, z);
        int r52 = Duration.$r8$clinit;
        long m1677getInWholeMillisecondsimpl = (int) (((float) Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.DAYS))) / calculateBMR);
        return (int) ((timePeriod.getEndTs() - (timePeriod.getStartTs() - (timePeriod.getStartTs() % m1677getInWholeMillisecondsimpl))) / m1677getInWholeMillisecondsimpl);
    }

    public static final float calculateBMR(int r4, int r5, int r6, boolean z) {
        float f;
        float f2;
        float calculateBMI = calculateBMI(r5, r4);
        if (calculateBMI > 30.0f && z) {
            return (((r5 * 6.25f) + (r4 * 10.0f)) - (r6 * 5.0f)) + 5.0f;
        }
        if (calculateBMI > 30.0f && !z) {
            return (((r5 * 6.25f) + (r4 * 10.0f)) - (r6 * 5.0f)) - 161.0f;
        }
        if (z) {
            f = ((r5 * 4.799f) + (r4 * 13.397f)) - (r6 * 5.677f);
            f2 = 88.362f;
        } else {
            if (z) {
                return 0.0f;
            }
            f = ((r5 * 3.098f) + (r4 * 9.247f)) - (r6 * 4.33f);
            f2 = 447.593f;
        }
        return f + f2;
    }
}
