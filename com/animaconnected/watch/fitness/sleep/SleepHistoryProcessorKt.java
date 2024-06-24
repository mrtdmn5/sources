package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.sleep.SleepTimePeriod;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;

/* compiled from: SleepHistoryProcessor.kt */
/* loaded from: classes3.dex */
public final class SleepHistoryProcessorKt {
    public static final List<SleepTimePeriod> toSleepTimePeriods(TimePeriod timePeriod, FitnessQueries db) {
        Bedtime defaultBedtime;
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(db, "db");
        ArrayList arrayList = new ArrayList();
        for (Instant start = timePeriod.getStart(); start.compareTo(timePeriod.getEnd()) < 0; start = start.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS))) {
            FitnessConfig executeAsOneOrNull = FitnessDatabaseExtensionsKt.getProfile(db, start.toEpochMilliseconds()).executeAsOneOrNull();
            if (executeAsOneOrNull == null || (defaultBedtime = executeAsOneOrNull.getBedtime()) == null) {
                defaultBedtime = Bedtime.Companion.defaultBedtime();
            }
            SleepTimePeriod fromInstant$default = SleepTimePeriod.Companion.fromInstant$default(SleepTimePeriod.Companion, start, defaultBedtime, null, 4, null);
            if (fromInstant$default != null && fromInstant$default.getStart().compareTo(timePeriod.getStart()) >= 0) {
                arrayList.add(fromInstant$default);
            }
            int r2 = Duration.$r8$clinit;
        }
        return arrayList;
    }
}
