package com.animaconnected.watch.fitness;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.session.SessionProviderImplKt;
import com.animaconnected.watch.location.LocationResult;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: LocationUtils.kt */
/* loaded from: classes3.dex */
public final class LocationUtilsKt {
    public static final int ACCURACY_THRESHOLD_METER = 60;
    public static final int DISTANCE_THRESHOLD_METER = 10;
    public static final int MOVEMENT_THRESHOLD_METER = 100;
    public static final int STANDARD_DERIVATION_AMOUNT = 20;
    private static final int splitMinDistanceInMeters = 100;

    /* compiled from: LocationUtils.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DistUnit.values().length];
            try {
                r0[DistUnit.Miles.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DistUnit.Kilometers.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[DistUnit.NauticalMiles.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* renamed from: acceptQuality-kRTOawE */
    public static final SpotQualityResult m1451acceptQualitykRTOawE(final Spot acceptQuality, String historyDeviceId, FitnessQueries db, CurrentSessionData currentSessionData) {
        double d;
        Intrinsics.checkNotNullParameter(acceptQuality, "$this$acceptQuality");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(currentSessionData, "currentSessionData");
        if (acceptQuality.accuracy > 60.0f) {
            LogKt.debug$default((Object) acceptQuality, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$acceptQuality$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Rejected: Bad accuracy: " + Spot.this;
                }
            }, 7, (Object) null);
            return new SpotQualityResult(false, 0.0d, 2, null);
        }
        final LocationEntry m1526getLastLocationVAJrmyI = SessionProviderImplKt.m1526getLastLocationVAJrmyI(currentSessionData, db, historyDeviceId);
        if (m1526getLastLocationVAJrmyI != null) {
            d = distance(m1526getLastLocationVAJrmyI, toLocationEntry(acceptQuality));
        } else {
            d = 0.0d;
        }
        final double d2 = d;
        if (m1526getLastLocationVAJrmyI != null && d2 < 10.0d) {
            LogKt.debug$default((Object) acceptQuality, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$acceptQuality$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Rejected: Too short dist from previous loc: " + Spot.this;
                }
            }, 7, (Object) null);
            return new SpotQualityResult(false, 0.0d, 2, null);
        }
        Pair<Double, Double> accuracyStandardDerivation = accuracyStandardDerivation(SessionProviderImplKt.m1527getLastRawLocationsW5HvN8Q(currentSessionData, db, historyDeviceId, 20));
        if (acceptQuality.accuracy > (accuracyStandardDerivation.second.doubleValue() * 3.0d) + accuracyStandardDerivation.first.doubleValue() + 3.0d) {
            LogKt.debug$default((Object) acceptQuality, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$acceptQuality$3
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Rejected: STD-derivation: " + Spot.this;
                }
            }, 7, (Object) null);
            return new SpotQualityResult(false, 0.0d, 2, null);
        }
        LogKt.debug$default((Object) acceptQuality, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$acceptQuality$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return StringsKt__IndentKt.trimIndent("\n        Prev: " + LocationEntry.this + "\n        Accepted: " + LocationUtilsKt.toLocationEntry(acceptQuality) + "\n        Diff: " + d2 + "\n    ");
            }
        }, 7, (Object) null);
        return new SpotQualityResult(true, d2);
    }

    public static final Pair<Double, Double> accuracyStandardDerivation(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        boolean isEmpty = list.isEmpty();
        double d = 0.0d;
        Double valueOf = Double.valueOf(0.0d);
        if (isEmpty) {
            return new Pair<>(valueOf, valueOf);
        }
        List<LocationEntry> list2 = list;
        double d2 = 0.0d;
        while (list2.iterator().hasNext()) {
            d2 += ((LocationEntry) r3.next()).getAccuracy();
        }
        for (LocationEntry locationEntry : list2) {
            d += locationEntry.getAccuracy() * locationEntry.getAccuracy();
        }
        return new Pair<>(Double.valueOf(d2 / list.size()), Double.valueOf(Math.sqrt((d / list.size()) - Math.pow(d2 / list.size(), 2))));
    }

    public static final List<Split> calculateSplitsFromActivityData(List<Interval> activeIntervals, List<ActivityEntry> activityEntries, FitnessProvider.Profile.Measurement measurement, int r5) {
        double d;
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        ArrayList flatten = CollectionsKt__IteratorsJVMKt.flatten(calculateTimeDistanceActivityData(activeIntervals, activityEntries));
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            d = 1000.0d;
        } else {
            d = 1609.344d;
        }
        return toSplits(flatten, d * r5);
    }

    public static /* synthetic */ List calculateSplitsFromActivityData$default(List list, List list2, FitnessProvider.Profile.Measurement measurement, int r3, int r4, Object obj) {
        if ((r4 & 8) != 0) {
            r3 = 1;
        }
        return calculateSplitsFromActivityData(list, list2, measurement, r3);
    }

    public static final List<Split> calculateSplitsFromLocations(List<Interval> activeIntervals, List<LocationEntry> locations, FitnessProvider.Profile.Measurement measurement, int r5) {
        double d;
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(locations, "locations");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        ArrayList flatten = CollectionsKt__IteratorsJVMKt.flatten(calculateTimeDistanceLocations(activeIntervals, locations));
        if (measurement == FitnessProvider.Profile.Measurement.Metric) {
            d = 1000.0d;
        } else {
            d = 1609.344d;
        }
        return toSplits(flatten, d * r5);
    }

    public static /* synthetic */ List calculateSplitsFromLocations$default(List list, List list2, FitnessProvider.Profile.Measurement measurement, int r3, int r4, Object obj) {
        if ((r4 & 8) != 0) {
            r3 = 1;
        }
        return calculateSplitsFromLocations(list, list2, measurement, r3);
    }

    public static final List<List<TimeDistance>> calculateTimeDistanceActivityData(List<Interval> activeIntervals, List<ActivityEntry> activityEntries) {
        TimeDistance timeDistance;
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        List<Interval> list = activeIntervals;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (Interval interval : list) {
            final ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (ActivityEntry activityEntry : activityEntries) {
                if (activityEntry.getDistance() != null) {
                    timeDistance = new TimeDistance(activityEntry.getTimestamp(), r6.intValue());
                } else {
                    timeDistance = null;
                }
                if (timeDistance != null) {
                    arrayList3.add(timeDistance);
                }
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (new LongRange(interval.getStartTimestamp(), interval.getEndTimestamp()).contains(((TimeDistance) next).getTime())) {
                    arrayList4.add(next);
                }
            }
            if (!arrayList4.isEmpty()) {
                TimeDistance timeDistance2 = (TimeDistance) CollectionsKt___CollectionsKt.first((List) arrayList4);
                arrayList2.add(new TimeDistance(timeDistance2.getTime() - interval.getStartTimestamp(), timeDistance2.getDistance()));
            }
            CollectionsKt___CollectionsKt.windowed$default(arrayList4, 2, 0, new Function1<List<? extends TimeDistance>, Boolean>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$calculateTimeDistanceActivityData$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(List<TimeDistance> list2) {
                    Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                    TimeDistance timeDistance3 = list2.get(0);
                    TimeDistance timeDistance4 = list2.get(1);
                    return Boolean.valueOf(arrayList2.add(new TimeDistance(timeDistance4.getTime() - timeDistance3.getTime(), timeDistance4.getDistance())));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(List<? extends TimeDistance> list2) {
                    return invoke2((List<TimeDistance>) list2);
                }
            }, 6);
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public static final List<List<TimeDistance>> calculateTimeDistanceLocations(List<Interval> activeIntervals, List<LocationEntry> locations) {
        Intrinsics.checkNotNullParameter(activeIntervals, "activeIntervals");
        Intrinsics.checkNotNullParameter(locations, "locations");
        List<Interval> list = activeIntervals;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (Interval interval : list) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = locations.iterator();
            while (true) {
                boolean z = false;
                if (it.hasNext()) {
                    Object next = it.next();
                    LocationEntry locationEntry = (LocationEntry) next;
                    if (locationEntry.getTimestamp() >= interval.getStartTimestamp() && locationEntry.getTimestamp() < interval.getEndTimestamp()) {
                        z = true;
                    }
                    if (z) {
                        arrayList2.add(next);
                    }
                }
            }
            arrayList.add(CollectionsKt___CollectionsKt.windowed$default(arrayList2, 2, 0, new Function1<List<? extends LocationEntry>, TimeDistance>() { // from class: com.animaconnected.watch.fitness.LocationUtilsKt$calculateTimeDistanceLocations$1$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final TimeDistance invoke2(List<LocationEntry> list2) {
                    Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                    LocationEntry locationEntry2 = list2.get(0);
                    LocationEntry locationEntry3 = list2.get(1);
                    return new TimeDistance(locationEntry3.getTimestamp() - locationEntry2.getTimestamp(), LocationUtilsKt.distance(locationEntry2, locationEntry3));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ TimeDistance invoke(List<? extends LocationEntry> list2) {
                    return invoke2((List<LocationEntry>) list2);
                }
            }, 6));
        }
        return arrayList;
    }

    private static final double degToRad(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    private static final double distance(LocationEntry locationEntry, LocationEntry locationEntry2, DistUnit distUnit) {
        double d;
        double radToDeg = radToDeg(Math.acos((Math.cos(degToRad(locationEntry.getLong() - locationEntry2.getLong())) * Math.cos(degToRad(locationEntry2.getLat())) * Math.cos(degToRad(locationEntry.getLat()))) + (Math.sin(degToRad(locationEntry2.getLat())) * Math.sin(degToRad(locationEntry.getLat()))))) * 60 * 1.1515d;
        int r8 = WhenMappings.$EnumSwitchMapping$0[distUnit.ordinal()];
        if (r8 == 1) {
            return radToDeg;
        }
        if (r8 == 2) {
            d = 1.609344d;
        } else {
            if (r8 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            d = 0.8684d;
        }
        return radToDeg * d;
    }

    public static final List<LocationEntry> filterRouteOrSingleLocation(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        LocationEntry locationEntry = (LocationEntry) CollectionsKt___CollectionsKt.first((List) list);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (distance(locationEntry, (LocationEntry) it.next()) > 100.0d) {
                return list;
            }
        }
        return CollectionsKt__CollectionsKt.listOf(locationEntry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List<List<LocationEntry>> filterRouteOrSingleLocationIntervals(List<? extends List<LocationEntry>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty() && !((List) CollectionsKt___CollectionsKt.first((List) list)).isEmpty()) {
            List<LocationEntry> filterRouteOrSingleLocation = filterRouteOrSingleLocation(CollectionsKt__IteratorsJVMKt.flatten(list));
            if (filterRouteOrSingleLocation.size() == 1) {
                return CollectionsKt__CollectionsKt.listOf(filterRouteOrSingleLocation);
            }
            return list;
        }
        return CollectionsKt__CollectionsKt.listOf(EmptyList.INSTANCE);
    }

    public static final Bounds getBounds(List<LocationEntry> list) {
        Double valueOf;
        double d;
        Double valueOf2;
        double d2;
        Double valueOf3;
        double d3;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<LocationEntry> list2 = list;
        Iterator<T> it = list2.iterator();
        Double d4 = null;
        if (!it.hasNext()) {
            valueOf = null;
        } else {
            double lat = ((LocationEntry) it.next()).getLat();
            while (it.hasNext()) {
                lat = Math.max(lat, ((LocationEntry) it.next()).getLat());
            }
            valueOf = Double.valueOf(lat);
        }
        double d5 = 0.0d;
        if (valueOf != null) {
            d = valueOf.doubleValue();
        } else {
            d = 0.0d;
        }
        Iterator<T> it2 = list2.iterator();
        if (!it2.hasNext()) {
            valueOf2 = null;
        } else {
            double d6 = ((LocationEntry) it2.next()).getLong();
            while (it2.hasNext()) {
                d6 = Math.max(d6, ((LocationEntry) it2.next()).getLong());
            }
            valueOf2 = Double.valueOf(d6);
        }
        if (valueOf2 != null) {
            d2 = valueOf2.doubleValue();
        } else {
            d2 = 0.0d;
        }
        Iterator<T> it3 = list2.iterator();
        if (!it3.hasNext()) {
            valueOf3 = null;
        } else {
            double lat2 = ((LocationEntry) it3.next()).getLat();
            while (it3.hasNext()) {
                lat2 = Math.min(lat2, ((LocationEntry) it3.next()).getLat());
            }
            valueOf3 = Double.valueOf(lat2);
        }
        if (valueOf3 != null) {
            d3 = valueOf3.doubleValue();
        } else {
            d3 = 0.0d;
        }
        Iterator<T> it4 = list2.iterator();
        if (it4.hasNext()) {
            double d7 = ((LocationEntry) it4.next()).getLong();
            while (it4.hasNext()) {
                d7 = Math.min(d7, ((LocationEntry) it4.next()).getLong());
            }
            d4 = Double.valueOf(d7);
        }
        if (d4 != null) {
            d5 = d4.doubleValue();
        }
        return new Bounds(d, d2, d3, d5);
    }

    public static final GpsQuality gpsQuality(LocationResult locationResult, boolean z) {
        Intrinsics.checkNotNullParameter(locationResult, "<this>");
        if (!z) {
            return GpsQuality.None;
        }
        boolean z2 = locationResult instanceof Spot;
        if (z2 && ((Spot) locationResult).accuracy < 60.0f) {
            return GpsQuality.Good;
        }
        if (z2) {
            return GpsQuality.Bad;
        }
        return GpsQuality.None;
    }

    private static final double radToDeg(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    public static final LocationEntry toLocationEntry(Spot spot) {
        Intrinsics.checkNotNullParameter(spot, "<this>");
        return new LocationEntry(HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion), spot.timeStamp, spot.longitude, spot.latitude, spot.accuracy, spot.altitude, false, 64, (DefaultConstructorMarker) null);
    }

    public static final List<Split> toSplits(List<TimeDistance> list, double d) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return SequencesKt___SequencesKt.toList(new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(new LocationUtilsKt$toSplits$1(list, d, null)));
    }

    public static final double distance(LocationEntry loc1, LocationEntry loc2) {
        Intrinsics.checkNotNullParameter(loc1, "loc1");
        Intrinsics.checkNotNullParameter(loc2, "loc2");
        double distance = distance(loc1, loc2, DistUnit.Kilometers) * 1000;
        if (Double.isNaN(distance)) {
            return 0.0d;
        }
        return Math.hypot(distance, Math.abs(loc1.getAltitude() - loc2.getAltitude()));
    }
}
