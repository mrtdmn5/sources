package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.device.StringsBackendKt;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.Session;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: StravaTcx.kt */
/* loaded from: classes3.dex */
public final class StravaTcxKt {
    private static final Lazy iso8601$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DateFormatter>() { // from class: com.animaconnected.watch.account.strava.StravaTcxKt$iso8601$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DateFormatter invoke() {
            return StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), "yyyy-MM-dd'T'HH:mm:ssX", false, 2, null);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final String asIsoDateTime(Instant instant) {
        DateFormatter iso8601 = getIso8601();
        TimeZone.Companion.getClass();
        return StringsBackendKt.format(iso8601, instant, TimeZone.UTC, true);
    }

    private static final Integer findMatchingHeartRate(LocationEntry locationEntry, List<HeartrateEntry> list) {
        Object obj;
        boolean z;
        if (list.isEmpty()) {
            return null;
        }
        int r0 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(10, DurationUnit.SECONDS);
        Instant.Companion companion = Instant.Companion;
        long timestamp = locationEntry.getTimestamp();
        companion.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(timestamp);
        Instant m1705minusLRDsOJo = fromEpochMilliseconds.m1705minusLRDsOJo(duration);
        Instant that = fromEpochMilliseconds.m1706plusLRDsOJo(duration);
        Intrinsics.checkNotNullParameter(m1705minusLRDsOJo, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                Instant.Companion companion2 = Instant.Companion;
                long timestamp2 = ((HeartrateEntry) obj).getTimestamp();
                companion2.getClass();
                Instant fromEpochMilliseconds2 = Instant.Companion.fromEpochMilliseconds(timestamp2);
                if (fromEpochMilliseconds2.compareTo(m1705minusLRDsOJo) >= 0 && fromEpochMilliseconds2.compareTo(that) <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        HeartrateEntry heartrateEntry = (HeartrateEntry) obj;
        if (heartrateEntry == null) {
            return null;
        }
        return Integer.valueOf(heartrateEntry.getHeartrate());
    }

    private static final DateFormatter getIso8601() {
        return (DateFormatter) iso8601$delegate.getValue();
    }

    public static final String toTcx(Session session) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(session, "<this>");
        if (session.getGps() && session.getLocationEntries().size() >= 2) {
            List<LocationEntry> locationEntries = session.getLocationEntries();
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(locationEntries, 10));
            for (LocationEntry locationEntry : locationEntries) {
                Instant.Companion companion = Instant.Companion;
                long timestamp = locationEntry.getTimestamp();
                companion.getClass();
                arrayList.add(new TrackPoint(Instant.Companion.fromEpochMilliseconds(timestamp), locationEntry, findMatchingHeartRate(locationEntry, session.getHeartrateEntries())));
            }
        } else {
            List<HeartrateEntry> heartrateEntries = session.getHeartrateEntries();
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(heartrateEntries, 10));
            for (HeartrateEntry heartrateEntry : heartrateEntries) {
                Instant.Companion companion2 = Instant.Companion;
                long timestamp2 = heartrateEntry.getTimestamp();
                companion2.getClass();
                arrayList.add(new TrackPoint(Instant.Companion.fromEpochMilliseconds(timestamp2), null, Integer.valueOf(heartrateEntry.getHeartrate())));
            }
        }
        String stravaType = StravaClientKt.toStravaType(session.getType());
        Instant.Companion companion3 = Instant.Companion;
        long startTs = session.getStartTs();
        companion3.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(startTs);
        int calories = session.getCalories();
        int r0 = Duration.$r8$clinit;
        return toTcx(new Activity(stravaType, fromEpochMilliseconds, DurationKt.toDuration(session.getTotalTimeMs(), DurationUnit.MILLISECONDS), calories, session.getTotalDistanceMeter(), session.getGps(), arrayList, null));
    }

    private static final String toTcx(Activity activity) {
        int r1;
        String trimMargin;
        String trimMargin2;
        List<TrackPoint> points = activity.getPoints();
        if ((points instanceof Collection) && points.isEmpty()) {
            r1 = 0;
        } else {
            Iterator<T> it = points.iterator();
            r1 = 0;
            while (it.hasNext()) {
                if ((((TrackPoint) it.next()).getLocationEntry() != null) && (r1 = r1 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                    throw null;
                }
            }
        }
        final boolean z = r1 < 2;
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(activity.getPoints(), "", null, null, new Function1<TrackPoint, CharSequence>() { // from class: com.animaconnected.watch.account.strava.StravaTcxKt$toTcx$trackPointsXml$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(TrackPoint trackPoint) {
                String str;
                String str2;
                String asIsoDateTime;
                String trimMargin3;
                Intrinsics.checkNotNullParameter(trackPoint, "trackPoint");
                LocationEntry locationEntry = trackPoint.getLocationEntry();
                Integer heartRate = trackPoint.getHeartRate();
                if (z || locationEntry == null) {
                    str = "";
                } else {
                    str = StringsKt__IndentKt.trimMargin("\n            |<Position>\n            |  <LatitudeDegrees>" + locationEntry.getLat() + "</LatitudeDegrees>\n            |  <LongitudeDegrees>" + locationEntry.getLong() + "</LongitudeDegrees>\n            |</Position>\n            ", "|");
                }
                if (heartRate != null) {
                    str2 = StringsKt__IndentKt.trimMargin("\n            |<HeartRateBpm>\n            |  <Value>" + heartRate + "</Value>\n            |</HeartRateBpm>\n            ", "|");
                } else {
                    str2 = "";
                }
                if (!(str2.length() > 0)) {
                    if (!(str.length() > 0)) {
                        return "";
                    }
                }
                StringBuilder sb = new StringBuilder("\n            |<Trackpoint>\n            |  <Time>");
                asIsoDateTime = StravaTcxKt.asIsoDateTime(trackPoint.getTime());
                sb.append(asIsoDateTime);
                sb.append("</Time>\n            |  ");
                sb.append(str);
                sb.append("\n            |  ");
                sb.append(str2);
                sb.append("\n            |</Trackpoint>\n            ");
                trimMargin3 = StringsKt__IndentKt.trimMargin(sb.toString(), "|");
                return trimMargin3;
            }
        }, 30);
        String str = "";
        if (joinToString$default.length() == 0) {
            trimMargin = "";
        } else {
            trimMargin = StringsKt__IndentKt.trimMargin("\n        |<Track>\n        |    " + joinToString$default + "\n        |</Track>\n    ", "|");
        }
        if (z) {
            str = StringsKt__IndentKt.trimMargin("\n        |<DistanceMeters>" + activity.getTotalDistanceMeter() + "</DistanceMeters>\n        ", "|");
        }
        trimMargin2 = StringsKt__IndentKt.trimMargin("\n        |<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n        |<TrainingCenterDatabase xmlns=\"http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2\">\n        |  <Activities>\n        |    <Activity Sport=\"" + activity.getActivityType() + "\">\n        |      <Id>" + asIsoDateTime(activity.getStartTime()) + "</Id>\n        |      <Lap StartTime=\"" + asIsoDateTime(activity.getStartTime()) + "\">\n        |        <TotalTimeSeconds>" + Duration.m1679getInWholeSecondsimpl(activity.m1057getTotalTimeUwyO8pc()) + "</TotalTimeSeconds>\n        |        <Calories>" + activity.getCalories() + "</Calories>\n        |        " + str + "\n        |        <Intensity>Active</Intensity>\n        |        <TriggerMethod>Manual</TriggerMethod>\n        |        " + trimMargin + "\n        |      </Lap>\n        |    </Activity>\n        |  </Activities>\n        |</TrainingCenterDatabase>\n    ", "|");
        return trimMargin2;
    }
}
