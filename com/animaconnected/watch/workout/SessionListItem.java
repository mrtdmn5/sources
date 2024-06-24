package com.animaconnected.watch.workout;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.ActivityEntry$$serializer;
import com.animaconnected.watch.fitness.Elevation;
import com.animaconnected.watch.fitness.Elevation$$serializer;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.LocationEntry$$serializer;
import com.animaconnected.watch.fitness.LocationUtilsKt;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.fitness.SessionTypeSerializer;
import com.animaconnected.watch.fitness.Split;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.BarEntry$$serializer;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.LineChartValue;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.graphs.PointEntry$$serializer;
import com.animaconnected.watch.workout.ListItem;
import com.animaconnected.watch.workout.utils.DataPoint;
import com.animaconnected.watch.workout.utils.HeartrateCompressorKt;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import com.google.android.gms.tasks.zzac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: WorkoutDataClasses.kt */
@Serializable
/* loaded from: classes3.dex */
public final class SessionListItem extends ListItem {
    private static final KSerializer<Object>[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private String activeTime;
    private List<ActivityEntry> activityEntries;
    private String calories;
    private List<Elevation> debugElevation;
    private String distance;
    private String elevationGain;
    private List<PointEntry> elevations;
    private boolean expanded;
    private boolean gps;
    private List<PointEntry> heartrates;
    private final ListItem.Type itemType;
    private String pace;
    private int rawAverageHeartrate;
    private List<LocationEntry> route;
    private SessionType sessionType;
    private String speed;
    private List<BarEntry> splits;
    private String steps;
    private long timestamp;
    private String totalCalories;
    private String totalTime;

    /* compiled from: WorkoutDataClasses.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: WorkoutDataClasses.kt */
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[SessionType.values().length];
                try {
                    r0[SessionType.Running.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[SessionType.Walking.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[SessionType.Bike.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[SessionType.Other.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionListItem fromSession(Session session, FitnessProvider.Profile.Measurement measurement) {
            String str;
            int r26;
            long j;
            List calculateSplitsFromActivityData$default;
            List<Split> calculateSplitsFromActivityData;
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(measurement, "measurement");
            if (session.getActiveTimeMs() < session.getTotalTimeMs()) {
                int r0 = Duration.$r8$clinit;
                str = WorkoutFormatUtilsKt.m1574formatElapsedTimeLRDsOJo(DurationKt.toDuration(session.getActiveTimeMs(), DurationUnit.MILLISECONDS));
            } else {
                str = "";
            }
            String str2 = str;
            int r02 = Duration.$r8$clinit;
            String m1574formatElapsedTimeLRDsOJo = WorkoutFormatUtilsKt.m1574formatElapsedTimeLRDsOJo(DurationKt.toDuration(session.getTotalTimeMs(), DurationUnit.MILLISECONDS));
            List<DataPoint> data = HeartrateCompressorKt.compressForWorkoutGraph(session.getHeartrateEntries(), new TimePeriod(session.getStartTs(), session.getEndTs()), 100).getData();
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(data, 10));
            for (DataPoint dataPoint : data) {
                long timestamp = dataPoint.getTimestamp() - session.getStartTs();
                int r5 = Duration.$r8$clinit;
                String m1574formatElapsedTimeLRDsOJo2 = WorkoutFormatUtilsKt.m1574formatElapsedTimeLRDsOJo(DurationKt.toDuration(timestamp, DurationUnit.MILLISECONDS));
                arrayList.add(new PointEntry(dataPoint.getAvgValue(), m1574formatElapsedTimeLRDsOJo2, m1574formatElapsedTimeLRDsOJo2, false, 8, (DefaultConstructorMarker) null));
            }
            if (!session.getHeartrateEntries().isEmpty()) {
                Iterator<T> it = session.getHeartrateEntries().iterator();
                int r2 = 0;
                while (it.hasNext()) {
                    r2 += ((HeartrateEntry) it.next()).getHeartrate();
                }
                r26 = r2 / session.getHeartrateEntries().size();
            } else {
                r26 = 0;
            }
            if (!session.getElevation().isEmpty()) {
                j = session.getTotalTimeMs() / session.getElevation().size();
            } else {
                j = 0;
            }
            List<Elevation> elevation = session.getElevation();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(elevation, 10));
            int r1 = 0;
            for (Object obj : elevation) {
                int r11 = r1 + 1;
                if (r1 >= 0) {
                    long j2 = r1 * j;
                    int r12 = Duration.$r8$clinit;
                    String m1574formatElapsedTimeLRDsOJo3 = WorkoutFormatUtilsKt.m1574formatElapsedTimeLRDsOJo(DurationKt.toDuration(j2, DurationUnit.MILLISECONDS));
                    arrayList2.add(new PointEntry((LineChartValue) new Known((int) (((Elevation) obj).getElevation() * 100.0d), false, 2, (DefaultConstructorMarker) null), m1574formatElapsedTimeLRDsOJo3, m1574formatElapsedTimeLRDsOJo3, false, 8, (DefaultConstructorMarker) null));
                    r1 = r11;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            String valueOf = String.valueOf(session.getCalories());
            String valueOf2 = String.valueOf(session.getBmr() + session.getCalories());
            int r03 = WhenMappings.$EnumSwitchMapping$0[session.getType().ordinal()];
            if (r03 != 1 && r03 != 2) {
                if (r03 != 3) {
                    if (r03 == 4) {
                        SessionType type = session.getType();
                        long startTs = session.getStartTs();
                        String valueOf3 = String.valueOf(session.getSteps());
                        EmptyList emptyList = EmptyList.INSTANCE;
                        return new SessionListItem(type, startTs, "", valueOf, valueOf2, str2, m1574formatElapsedTimeLRDsOJo, valueOf3, "", "", "", CollectionsKt___CollectionsKt.take(session.getLocationEntries(), 1), emptyList, arrayList, r26, emptyList, session.getActivityEntries(), session.getElevation(), false, session.getGps(), 262144, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (session.getGps()) {
                    calculateSplitsFromActivityData = LocationUtilsKt.calculateSplitsFromLocations(session.getIntervals(), session.getLocationEntries(), measurement, 5);
                } else {
                    calculateSplitsFromActivityData = LocationUtilsKt.calculateSplitsFromActivityData(session.getIntervals(), session.getActivityEntries(), measurement, 5);
                }
                List<Split> list = calculateSplitsFromActivityData;
                SessionType type2 = session.getType();
                long startTs2 = session.getStartTs();
                String formatDistance$default = WorkoutFormatUtilsKt.formatDistance$default(session.getTotalDistanceMeter(), measurement, false, 4, null);
                int r04 = Duration.$r8$clinit;
                return new SessionListItem(type2, startTs2, formatDistance$default, valueOf, valueOf2, str2, m1574formatElapsedTimeLRDsOJo, "", "", WorkoutFormatUtilsKt.m1578formatSpeedrnQQ1Ag$default(DurationKt.toDuration(session.getActiveTimeMs(), DurationUnit.MILLISECONDS), session.getTotalDistanceMeter(), measurement, false, 8, null), WorkoutFormatUtilsKt.formatElevation(session.getElevationGain(), measurement), session.getLocationEntries(), WorkoutDataClassesKt.toSplitBarEntries(list, measurement, true), arrayList, r26, arrayList2, session.getActivityEntries(), session.getElevation(), false, session.getGps(), 262144, null);
            }
            if (session.getGps()) {
                calculateSplitsFromActivityData$default = LocationUtilsKt.calculateSplitsFromLocations$default(session.getIntervals(), session.getLocationEntries(), measurement, 0, 8, null);
            } else {
                calculateSplitsFromActivityData$default = LocationUtilsKt.calculateSplitsFromActivityData$default(session.getIntervals(), session.getActivityEntries(), measurement, 0, 8, null);
            }
            List list2 = calculateSplitsFromActivityData$default;
            SessionType type3 = session.getType();
            long startTs3 = session.getStartTs();
            String formatDistance$default2 = WorkoutFormatUtilsKt.formatDistance$default(session.getTotalDistanceMeter(), measurement, false, 4, null);
            int r05 = Duration.$r8$clinit;
            return new SessionListItem(type3, startTs3, formatDistance$default2, valueOf, valueOf2, str2, m1574formatElapsedTimeLRDsOJo, String.valueOf(session.getSteps()), WorkoutFormatUtilsKt.m1576formatPacernQQ1Ag$default(DurationKt.toDuration(session.getActiveTimeMs(), DurationUnit.MILLISECONDS), session.getTotalDistanceMeter(), measurement, false, 8, null), "", WorkoutFormatUtilsKt.formatElevation(session.getElevationGain(), measurement), session.getLocationEntries(), WorkoutDataClassesKt.toSplitBarEntries(list2, measurement, false), arrayList, r26, arrayList2, session.getActivityEntries(), session.getElevation(), false, session.getGps(), 262144, null);
        }

        public final KSerializer<SessionListItem> serializer() {
            return SessionListItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        PointEntry$$serializer pointEntry$$serializer = PointEntry$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{null, null, null, null, null, null, null, null, null, null, null, new ArrayListSerializer(LocationEntry$$serializer.INSTANCE), new ArrayListSerializer(BarEntry$$serializer.INSTANCE), new ArrayListSerializer(pointEntry$$serializer), null, new ArrayListSerializer(pointEntry$$serializer), new ArrayListSerializer(ActivityEntry$$serializer.INSTANCE), new ArrayListSerializer(Elevation$$serializer.INSTANCE), null, null, EnumsKt.createSimpleEnumSerializer("com.animaconnected.watch.workout.ListItem.Type", ListItem.Type.values())};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionListItem(int r5, SessionType sessionType, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, List list2, List list3, int r21, List list4, List list5, List list6, boolean z, boolean z2, ListItem.Type type, SerializationConstructorMarker serializationConstructorMarker) {
        super(r5, serializationConstructorMarker);
        if (262143 != (r5 & 262143)) {
            zzac.throwMissingFieldException(r5, 262143, SessionListItem$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
        this.sessionType = sessionType;
        this.timestamp = j;
        this.distance = str;
        this.calories = str2;
        this.totalCalories = str3;
        this.activeTime = str4;
        this.totalTime = str5;
        this.steps = str6;
        this.pace = str7;
        this.speed = str8;
        this.elevationGain = str9;
        this.route = list;
        this.splits = list2;
        this.heartrates = list3;
        this.rawAverageHeartrate = r21;
        this.elevations = list4;
        this.activityEntries = list5;
        this.debugElevation = list6;
        if ((262144 & r5) == 0) {
            this.expanded = false;
        } else {
            this.expanded = z;
        }
        if ((524288 & r5) == 0) {
            this.gps = false;
        } else {
            this.gps = z2;
        }
        this.itemType = (r5 & Constants.MB) == 0 ? ListItem.Type.Session : type;
    }

    public static final /* synthetic */ KSerializer[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public static final /* synthetic */ void write$Self$watch_release(SessionListItem sessionListItem, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        boolean z2;
        ListItem.write$Self(sessionListItem, compositeEncoder, serialDescriptor);
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        boolean z3 = false;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, SessionTypeSerializer.INSTANCE, sessionListItem.sessionType);
        compositeEncoder.encodeLongElement(serialDescriptor, 1, sessionListItem.timestamp);
        compositeEncoder.encodeStringElement(serialDescriptor, 2, sessionListItem.distance);
        compositeEncoder.encodeStringElement(serialDescriptor, 3, sessionListItem.calories);
        compositeEncoder.encodeStringElement(serialDescriptor, 4, sessionListItem.totalCalories);
        compositeEncoder.encodeStringElement(serialDescriptor, 5, sessionListItem.activeTime);
        compositeEncoder.encodeStringElement(serialDescriptor, 6, sessionListItem.totalTime);
        compositeEncoder.encodeStringElement(serialDescriptor, 7, sessionListItem.steps);
        compositeEncoder.encodeStringElement(serialDescriptor, 8, sessionListItem.pace);
        compositeEncoder.encodeStringElement(serialDescriptor, 9, sessionListItem.speed);
        compositeEncoder.encodeStringElement(serialDescriptor, 10, sessionListItem.elevationGain);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 11, kSerializerArr[11], sessionListItem.route);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 12, kSerializerArr[12], sessionListItem.splits);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 13, kSerializerArr[13], sessionListItem.heartrates);
        compositeEncoder.encodeIntElement(14, sessionListItem.rawAverageHeartrate, serialDescriptor);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 15, kSerializerArr[15], sessionListItem.elevations);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 16, kSerializerArr[16], sessionListItem.activityEntries);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 17, kSerializerArr[17], sessionListItem.debugElevation);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || sessionListItem.expanded) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 18, sessionListItem.expanded);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || sessionListItem.gps) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 19, sessionListItem.gps);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor) || sessionListItem.getItemType() != ListItem.Type.Session) {
            z3 = true;
        }
        if (z3) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 20, kSerializerArr[20], sessionListItem.getItemType());
        }
    }

    public final SessionType component1() {
        return this.sessionType;
    }

    public final String component10() {
        return this.speed;
    }

    public final String component11() {
        return this.elevationGain;
    }

    public final List<LocationEntry> component12() {
        return this.route;
    }

    public final List<BarEntry> component13() {
        return this.splits;
    }

    public final List<PointEntry> component14() {
        return this.heartrates;
    }

    public final int component15() {
        return this.rawAverageHeartrate;
    }

    public final List<PointEntry> component16() {
        return this.elevations;
    }

    public final List<ActivityEntry> component17() {
        return this.activityEntries;
    }

    public final List<Elevation> component18() {
        return this.debugElevation;
    }

    public final boolean component19() {
        return this.expanded;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final boolean component20() {
        return this.gps;
    }

    public final String component3() {
        return this.distance;
    }

    public final String component4() {
        return this.calories;
    }

    public final String component5() {
        return this.totalCalories;
    }

    public final String component6() {
        return this.activeTime;
    }

    public final String component7() {
        return this.totalTime;
    }

    public final String component8() {
        return this.steps;
    }

    public final String component9() {
        return this.pace;
    }

    public final SessionListItem copy(SessionType sessionType, long j, String distance, String calories, String totalCalories, String activeTime, String totalTime, String steps, String pace, String speed, String elevationGain, List<LocationEntry> route, List<BarEntry> splits, List<PointEntry> heartrates, int r40, List<PointEntry> elevations, List<ActivityEntry> activityEntries, List<Elevation> debugElevation, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(calories, "calories");
        Intrinsics.checkNotNullParameter(totalCalories, "totalCalories");
        Intrinsics.checkNotNullParameter(activeTime, "activeTime");
        Intrinsics.checkNotNullParameter(totalTime, "totalTime");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(pace, "pace");
        Intrinsics.checkNotNullParameter(speed, "speed");
        Intrinsics.checkNotNullParameter(elevationGain, "elevationGain");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(splits, "splits");
        Intrinsics.checkNotNullParameter(heartrates, "heartrates");
        Intrinsics.checkNotNullParameter(elevations, "elevations");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        Intrinsics.checkNotNullParameter(debugElevation, "debugElevation");
        return new SessionListItem(sessionType, j, distance, calories, totalCalories, activeTime, totalTime, steps, pace, speed, elevationGain, route, splits, heartrates, r40, elevations, activityEntries, debugElevation, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionListItem)) {
            return false;
        }
        SessionListItem sessionListItem = (SessionListItem) obj;
        if (this.sessionType == sessionListItem.sessionType && this.timestamp == sessionListItem.timestamp && Intrinsics.areEqual(this.distance, sessionListItem.distance) && Intrinsics.areEqual(this.calories, sessionListItem.calories) && Intrinsics.areEqual(this.totalCalories, sessionListItem.totalCalories) && Intrinsics.areEqual(this.activeTime, sessionListItem.activeTime) && Intrinsics.areEqual(this.totalTime, sessionListItem.totalTime) && Intrinsics.areEqual(this.steps, sessionListItem.steps) && Intrinsics.areEqual(this.pace, sessionListItem.pace) && Intrinsics.areEqual(this.speed, sessionListItem.speed) && Intrinsics.areEqual(this.elevationGain, sessionListItem.elevationGain) && Intrinsics.areEqual(this.route, sessionListItem.route) && Intrinsics.areEqual(this.splits, sessionListItem.splits) && Intrinsics.areEqual(this.heartrates, sessionListItem.heartrates) && this.rawAverageHeartrate == sessionListItem.rawAverageHeartrate && Intrinsics.areEqual(this.elevations, sessionListItem.elevations) && Intrinsics.areEqual(this.activityEntries, sessionListItem.activityEntries) && Intrinsics.areEqual(this.debugElevation, sessionListItem.debugElevation) && this.expanded == sessionListItem.expanded && this.gps == sessionListItem.gps) {
            return true;
        }
        return false;
    }

    public final String getActiveTime() {
        return this.activeTime;
    }

    public final List<ActivityEntry> getActivityEntries() {
        return this.activityEntries;
    }

    public final String getCalories() {
        return this.calories;
    }

    public final List<Elevation> getDebugElevation() {
        return this.debugElevation;
    }

    public final String getDistance() {
        return this.distance;
    }

    public final String getElevationGain() {
        return this.elevationGain;
    }

    public final List<PointEntry> getElevations() {
        return this.elevations;
    }

    public final boolean getExpanded() {
        return this.expanded;
    }

    public final boolean getGps() {
        return this.gps;
    }

    public final List<PointEntry> getHeartrates() {
        return this.heartrates;
    }

    @Override // com.animaconnected.watch.workout.ListItem
    public ListItem.Type getItemType() {
        return this.itemType;
    }

    public final String getPace() {
        return this.pace;
    }

    public final int getRawAverageHeartrate() {
        return this.rawAverageHeartrate;
    }

    public final List<LocationEntry> getRoute() {
        return this.route;
    }

    public final SessionType getSessionType() {
        return this.sessionType;
    }

    public final String getSpeed() {
        return this.speed;
    }

    public final List<BarEntry> getSplits() {
        return this.splits;
    }

    public final String getSteps() {
        return this.steps;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTotalCalories() {
        return this.totalCalories;
    }

    public final String getTotalTime() {
        return this.totalTime;
    }

    public int hashCode() {
        return Boolean.hashCode(this.gps) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.expanded, VectorGroup$$ExternalSyntheticOutline0.m(this.debugElevation, VectorGroup$$ExternalSyntheticOutline0.m(this.activityEntries, VectorGroup$$ExternalSyntheticOutline0.m(this.elevations, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.rawAverageHeartrate, VectorGroup$$ExternalSyntheticOutline0.m(this.heartrates, VectorGroup$$ExternalSyntheticOutline0.m(this.splits, VectorGroup$$ExternalSyntheticOutline0.m(this.route, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.elevationGain, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.speed, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.pace, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.steps, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.totalTime, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.activeTime, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.totalCalories, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.calories, TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.distance, Scale$$ExternalSyntheticOutline0.m(this.timestamp, this.sessionType.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final void setActiveTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activeTime = str;
    }

    public final void setActivityEntries(List<ActivityEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.activityEntries = list;
    }

    public final void setCalories(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.calories = str;
    }

    public final void setDebugElevation(List<Elevation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.debugElevation = list;
    }

    public final void setDistance(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.distance = str;
    }

    public final void setElevationGain(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.elevationGain = str;
    }

    public final void setElevations(List<PointEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.elevations = list;
    }

    public final void setExpanded(boolean z) {
        this.expanded = z;
    }

    public final void setGps(boolean z) {
        this.gps = z;
    }

    public final void setHeartrates(List<PointEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.heartrates = list;
    }

    public final void setPace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pace = str;
    }

    public final void setRawAverageHeartrate(int r1) {
        this.rawAverageHeartrate = r1;
    }

    public final void setRoute(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.route = list;
    }

    public final void setSessionType(SessionType sessionType) {
        Intrinsics.checkNotNullParameter(sessionType, "<set-?>");
        this.sessionType = sessionType;
    }

    public final void setSpeed(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.speed = str;
    }

    public final void setSplits(List<BarEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.splits = list;
    }

    public final void setSteps(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.steps = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setTotalCalories(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalCalories = str;
    }

    public final void setTotalTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.totalTime = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionListItem(sessionType=");
        sb.append(this.sessionType);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", distance=");
        sb.append(this.distance);
        sb.append(", calories=");
        sb.append(this.calories);
        sb.append(", totalCalories=");
        sb.append(this.totalCalories);
        sb.append(", activeTime=");
        sb.append(this.activeTime);
        sb.append(", totalTime=");
        sb.append(this.totalTime);
        sb.append(", steps=");
        sb.append(this.steps);
        sb.append(", pace=");
        sb.append(this.pace);
        sb.append(", speed=");
        sb.append(this.speed);
        sb.append(", elevationGain=");
        sb.append(this.elevationGain);
        sb.append(", route=");
        sb.append(this.route);
        sb.append(", splits=");
        sb.append(this.splits);
        sb.append(", heartrates=");
        sb.append(this.heartrates);
        sb.append(", rawAverageHeartrate=");
        sb.append(this.rawAverageHeartrate);
        sb.append(", elevations=");
        sb.append(this.elevations);
        sb.append(", activityEntries=");
        sb.append(this.activityEntries);
        sb.append(", debugElevation=");
        sb.append(this.debugElevation);
        sb.append(", expanded=");
        sb.append(this.expanded);
        sb.append(", gps=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.gps, ')');
    }

    public /* synthetic */ SessionListItem(SessionType sessionType, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, List list2, List list3, int r40, List list4, List list5, List list6, boolean z, boolean z2, int r46, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionType, j, str, str2, str3, str4, str5, str6, str7, str8, str9, list, list2, list3, r40, list4, list5, list6, (r46 & 262144) != 0 ? false : z, (r46 & 524288) != 0 ? false : z2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionListItem(SessionType sessionType, long j, String distance, String calories, String totalCalories, String activeTime, String totalTime, String steps, String pace, String speed, String elevationGain, List<LocationEntry> route, List<BarEntry> splits, List<PointEntry> heartrates, int r32, List<PointEntry> elevations, List<ActivityEntry> activityEntries, List<Elevation> debugElevation, boolean z, boolean z2) {
        super(null);
        Intrinsics.checkNotNullParameter(sessionType, "sessionType");
        Intrinsics.checkNotNullParameter(distance, "distance");
        Intrinsics.checkNotNullParameter(calories, "calories");
        Intrinsics.checkNotNullParameter(totalCalories, "totalCalories");
        Intrinsics.checkNotNullParameter(activeTime, "activeTime");
        Intrinsics.checkNotNullParameter(totalTime, "totalTime");
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(pace, "pace");
        Intrinsics.checkNotNullParameter(speed, "speed");
        Intrinsics.checkNotNullParameter(elevationGain, "elevationGain");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(splits, "splits");
        Intrinsics.checkNotNullParameter(heartrates, "heartrates");
        Intrinsics.checkNotNullParameter(elevations, "elevations");
        Intrinsics.checkNotNullParameter(activityEntries, "activityEntries");
        Intrinsics.checkNotNullParameter(debugElevation, "debugElevation");
        this.sessionType = sessionType;
        this.timestamp = j;
        this.distance = distance;
        this.calories = calories;
        this.totalCalories = totalCalories;
        this.activeTime = activeTime;
        this.totalTime = totalTime;
        this.steps = steps;
        this.pace = pace;
        this.speed = speed;
        this.elevationGain = elevationGain;
        this.route = route;
        this.splits = splits;
        this.heartrates = heartrates;
        this.rawAverageHeartrate = r32;
        this.elevations = elevations;
        this.activityEntries = activityEntries;
        this.debugElevation = debugElevation;
        this.expanded = z;
        this.gps = z2;
        this.itemType = ListItem.Type.Session;
    }
}
