package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.SleepEntry;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: SleepTimePeriod.kt */
/* loaded from: classes3.dex */
public final class SleepTimePeriodKt {
    public static final Instant min(Instant a, Instant b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a.compareTo(b) >= 0) {
            return b;
        }
        return a;
    }

    public static final List<SleepEntry> sleepDataEntries(SleepTimePeriod sleepTimePeriod, FitnessQueries db) {
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "<this>");
        Intrinsics.checkNotNullParameter(db, "db");
        return FitnessDatabaseExtensionsKt.getSleepDataEntries(db, sleepTimePeriod.getStart().toEpochMilliseconds(), sleepTimePeriod.getEnd().toEpochMilliseconds()).executeAsList();
    }
}
