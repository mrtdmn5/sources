package com.animaconnected.watch.fitness.session;

import com.animaconnected.watch.fitness.CurrentSessionData;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.LocationEntry;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionProviderImpl.kt */
/* loaded from: classes3.dex */
public final class SessionProviderImplKt {
    /* renamed from: getLastLocation-VAJrmyI, reason: not valid java name */
    public static final LocationEntry m1526getLastLocationVAJrmyI(CurrentSessionData getLastLocation, FitnessQueries db, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getLastLocation, "$this$getLastLocation");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        if (getLastLocation.getIdentifier() != null) {
            return FitnessDatabaseExtensionsKt.m1229getLastLocationDataByIdentifierEntryW5HvN8Q(db, r4.intValue() * 1000, historyDeviceId, 1).executeAsOneOrNull();
        }
        return null;
    }

    /* renamed from: getLastRawLocations-W5HvN8Q, reason: not valid java name */
    public static final List<LocationEntry> m1527getLastRawLocationsW5HvN8Q(CurrentSessionData getLastRawLocations, FitnessQueries db, String historyDeviceId, int r7) {
        Intrinsics.checkNotNullParameter(getLastRawLocations, "$this$getLastRawLocations");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        if (getLastRawLocations.getIdentifier() != null) {
            return FitnessDatabaseExtensionsKt.m1230getLastRawLocationDataByIdentifierEntryW5HvN8Q(db, r4.intValue() * 1000, historyDeviceId, r7).executeAsList();
        }
        return EmptyList.INSTANCE;
    }
}
