package com.animaconnected.watch.fitness;

import com.animaconnected.watch.WatchDatabase;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessDatabaseImport.kt */
/* loaded from: classes3.dex */
public final class FitnessDatabaseImportKt {
    public static final void moveFitnessData(WatchDatabase from, WatchDatabase to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        TimePeriod none = TimePeriod.Companion.none();
        FitnessDatabaseParser fitnessDatabaseParser = FitnessDatabaseParser.INSTANCE;
        fitnessDatabaseParser.importFitnessData(to.getFitnessQueries(), fitnessDatabaseParser.toFitnessData(from.getFitnessQueries(), none));
        for (DBProfile dBProfile : from.getFitnessQueries().getProfilesInInterval(none.getStartTs(), none.getEndTs()).executeAsList()) {
            to.getFitnessQueries().insertProfile(Long.valueOf(dBProfile.getTimestamp()), dBProfile.getHeight(), dBProfile.getWeight(), dBProfile.getTs_of_birth(), dBProfile.getGender(), dBProfile.getMeasurement(), dBProfile.getTemperature(), dBProfile.getBedtime_hour(), dBProfile.getBedtime_min());
        }
    }
}
