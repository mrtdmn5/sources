package com.animaconnected.watch.provider.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreferenceProvider.kt */
/* loaded from: classes3.dex */
public final class WorkoutMetrics extends Enum<WorkoutMetrics> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkoutMetrics[] $VALUES;
    public static final Companion Companion;
    private static final int reverseOrderBitmask = 32768;
    private final int bitmask;
    public static final WorkoutMetrics ELAPSED_TIME = new WorkoutMetrics("ELAPSED_TIME", 0, 1);
    public static final WorkoutMetrics DISTANCE = new WorkoutMetrics("DISTANCE", 1, 2);
    public static final WorkoutMetrics PACE = new WorkoutMetrics("PACE", 2, 4);
    public static final WorkoutMetrics SPEED = new WorkoutMetrics("SPEED", 3, 8);
    public static final WorkoutMetrics HEART_RATE = new WorkoutMetrics("HEART_RATE", 4, 16);
    public static final WorkoutMetrics STEPS = new WorkoutMetrics("STEPS", 5, 32);
    public static final WorkoutMetrics CALORIES = new WorkoutMetrics("CALORIES", 6, 64);

    /* compiled from: PreferenceProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<Integer> toInt$watch_release(List<? extends WorkoutMetrics> metrics) {
            int r1;
            int r12;
            Intrinsics.checkNotNullParameter(metrics, "metrics");
            ArrayList chunked = CollectionsKt___CollectionsKt.chunked(metrics, 2);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked, 10));
            Iterator it = chunked.iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                WorkoutMetrics workoutMetrics = (WorkoutMetrics) CollectionsKt___CollectionsKt.first(list);
                WorkoutMetrics workoutMetrics2 = (WorkoutMetrics) CollectionsKt___CollectionsKt.lastOrNull(list);
                if (workoutMetrics2 == null) {
                    r12 = workoutMetrics.getBitmask$watch_release();
                } else {
                    int bitmask$watch_release = workoutMetrics.getBitmask$watch_release() | workoutMetrics2.getBitmask$watch_release();
                    if (workoutMetrics.getBitmask$watch_release() > workoutMetrics2.getBitmask$watch_release()) {
                        r1 = 32768;
                    } else {
                        r1 = 0;
                    }
                    r12 = r1 | bitmask$watch_release;
                }
                arrayList.add(Integer.valueOf(r12));
            }
            return arrayList;
        }

        public final List<WorkoutMetrics> toMetric$watch_release(int r5) {
            boolean z;
            EnumEntries<WorkoutMetrics> entries = WorkoutMetrics.getEntries();
            ArrayList arrayList = new ArrayList();
            for (Object obj : entries) {
                if ((((WorkoutMetrics) obj).getBitmask$watch_release() & r5) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            if ((r5 & 32768) > 0) {
                return new ReversedListReadOnly(arrayList);
            }
            return arrayList;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ WorkoutMetrics[] $values() {
        return new WorkoutMetrics[]{ELAPSED_TIME, DISTANCE, PACE, SPEED, HEART_RATE, STEPS, CALORIES};
    }

    static {
        WorkoutMetrics[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private WorkoutMetrics(String str, int r2, int r3) {
        super(str, r2);
        this.bitmask = r3;
    }

    public static EnumEntries<WorkoutMetrics> getEntries() {
        return $ENTRIES;
    }

    public static WorkoutMetrics valueOf(String str) {
        return (WorkoutMetrics) Enum.valueOf(WorkoutMetrics.class, str);
    }

    public static WorkoutMetrics[] values() {
        return (WorkoutMetrics[]) $VALUES.clone();
    }

    public final int getBitmask$watch_release() {
        return this.bitmask;
    }
}
