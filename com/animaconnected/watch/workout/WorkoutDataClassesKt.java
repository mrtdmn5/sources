package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* compiled from: WorkoutDataClasses.kt */
/* loaded from: classes3.dex */
public final class WorkoutDataClassesKt {

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

    public static final List<PointEntry> deserializeToPointEntry(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Json.Default r0 = Json.Default;
        r0.getClass();
        return (List) r0.decodeFromString(new ArrayListSerializer(PointEntry.Companion.serializer()), str);
    }

    public static final List<MetricItem> metricItems(SessionListItem sessionListItem) {
        boolean z;
        Intrinsics.checkNotNullParameter(sessionListItem, "<this>");
        ArrayList arrayList = new ArrayList();
        if (sessionListItem.getActiveTime().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            arrayList.add(new MetricItem(MetricType.ACTIVE_TIME, sessionListItem.getActiveTime()));
        }
        int r1 = WhenMappings.$EnumSwitchMapping$0[sessionListItem.getSessionType().ordinal()];
        if (r1 != 1 && r1 != 2) {
            if (r1 != 3) {
                if (r1 == 4) {
                    arrayList.add(new MetricItem(MetricType.TOTAL_TIME, sessionListItem.getTotalTime()));
                    arrayList.add(new MetricItem(MetricType.STEPS, sessionListItem.getSteps()));
                    arrayList.add(new MetricItem(MetricType.ACTIVE_CALORIES, sessionListItem.getCalories()));
                    arrayList.add(new MetricItem(MetricType.TOTAL_CALORIES, sessionListItem.getTotalCalories()));
                }
            } else {
                arrayList.add(new MetricItem(MetricType.TOTAL_TIME, sessionListItem.getTotalTime()));
                arrayList.add(new MetricItem(MetricType.DISTANCE, sessionListItem.getDistance()));
                arrayList.add(new MetricItem(MetricType.SPEED_AVG, sessionListItem.getSpeed()));
                arrayList.add(new MetricItem(MetricType.ACTIVE_CALORIES, sessionListItem.getCalories()));
                arrayList.add(new MetricItem(MetricType.TOTAL_CALORIES, sessionListItem.getTotalCalories()));
            }
        } else {
            arrayList.add(new MetricItem(MetricType.TOTAL_TIME, sessionListItem.getTotalTime()));
            arrayList.add(new MetricItem(MetricType.DISTANCE, sessionListItem.getDistance()));
            arrayList.add(new MetricItem(MetricType.STEPS, sessionListItem.getSteps()));
            arrayList.add(new MetricItem(MetricType.PACE_AVG, sessionListItem.getPace()));
            arrayList.add(new MetricItem(MetricType.ACTIVE_CALORIES, sessionListItem.getCalories()));
            arrayList.add(new MetricItem(MetricType.TOTAL_CALORIES, sessionListItem.getTotalCalories()));
        }
        return arrayList;
    }

    public static final String serialize(List<PointEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Json.Default r0 = Json.Default;
        r0.getClass();
        return r0.encodeToString(new ArrayListSerializer(PointEntry.Companion.serializer()), list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.util.List<com.animaconnected.watch.graphs.BarEntry> toSplitBarEntries(java.util.List<com.animaconnected.watch.fitness.Split> r31, com.animaconnected.watch.fitness.FitnessProvider.Profile.Measurement r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.WorkoutDataClassesKt.toSplitBarEntries(java.util.List, com.animaconnected.watch.fitness.FitnessProvider$Profile$Measurement, boolean):java.util.List");
    }
}
