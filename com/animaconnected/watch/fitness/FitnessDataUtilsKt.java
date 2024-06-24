package com.animaconnected.watch.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: FitnessDataUtils.kt */
/* loaded from: classes3.dex */
public final class FitnessDataUtilsKt {

    /* compiled from: FitnessDataUtils.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionEvent.values().length];
            try {
                r0[SessionEvent.Start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionEvent.Pause.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionEvent.Resume.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionEvent.Stop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final int getTotalSteps(ActivityEntry activityEntry) {
        int r0;
        Intrinsics.checkNotNullParameter(activityEntry, "<this>");
        Integer walkSteps = activityEntry.getWalkSteps();
        int r1 = 0;
        if (walkSteps != null) {
            r0 = walkSteps.intValue();
        } else {
            r0 = 0;
        }
        Integer runSteps = activityEntry.getRunSteps();
        if (runSteps != null) {
            r1 = runSteps.intValue();
        }
        return r0 + r1;
    }

    public static final double pace(Split split) {
        Intrinsics.checkNotNullParameter(split, "<this>");
        int r0 = Duration.$r8$clinit;
        return Duration.m1678getInWholeMinutesimpl(DurationKt.toDuration(split.getDuration(), DurationUnit.MILLISECONDS)) / (split.getDistance() / 1000.0d);
    }

    public static final List<Interval> toCurrentSessionActiveInterval(List<SessionEntry> list) {
        Long l;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            l = null;
            for (SessionEntry sessionEntry : list) {
                int r4 = WhenMappings.$EnumSwitchMapping$0[sessionEntry.getEvent().ordinal()];
                if (r4 != 1) {
                    if (r4 != 2) {
                        if (r4 != 3) {
                            if (r4 != 4) {
                                continue;
                            }
                        }
                    }
                    if (l != null) {
                        break;
                    }
                }
                l = Long.valueOf(sessionEntry.getTimestamp());
            }
            arrayList.add(new Interval(l.longValue(), sessionEntry.getTimestamp()));
        }
        if (l != null) {
            arrayList.add(new Interval(l.longValue(), DateTimeUtilsKt.currentTimeMillis()));
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public static final List<SessionIntervals> toSessionActiveIntervals(List<SessionEntry> list) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            SessionEntry sessionEntry = null;
            Long l = null;
            for (SessionEntry sessionEntry2 : list) {
                int r3 = WhenMappings.$EnumSwitchMapping$0[sessionEntry2.getEvent().ordinal()];
                if (r3 != 1) {
                    if (r3 != 2) {
                        if (r3 != 3) {
                            if (r3 == 4 && sessionEntry != null) {
                                if (l != null) {
                                    arrayList2.add(new Interval(l.longValue(), sessionEntry2.getTimestamp()));
                                }
                                String mo1121getHistoryDeviceIdV9ZILtA = sessionEntry2.mo1121getHistoryDeviceIdV9ZILtA();
                                long sessionId = sessionEntry.getSessionId();
                                SessionType type = sessionEntry.getType();
                                Boolean gps = sessionEntry.getGps();
                                if (gps != null) {
                                    z = gps.booleanValue();
                                } else {
                                    z = false;
                                }
                                arrayList.add(new SessionIntervals(mo1121getHistoryDeviceIdV9ZILtA, sessionId, type, z, new Interval(sessionEntry.getTimestamp(), sessionEntry2.getTimestamp()), CollectionsKt___CollectionsKt.toList(arrayList2), SessionStatus.Valid, null));
                                arrayList2.clear();
                            }
                        } else if (l == null && sessionEntry != null) {
                            l = Long.valueOf(sessionEntry2.getTimestamp());
                        }
                    } else if (l != null && sessionEntry != null) {
                        arrayList2.add(new Interval(l.longValue(), sessionEntry2.getTimestamp()));
                        l = null;
                    }
                } else {
                    if (sessionEntry != null) {
                        arrayList2.clear();
                        LogKt.warn$default((Object) list, "Bad history! New Start entry before Stop.", "toSessionActiveIntervals", (Throwable) null, false, 12, (Object) null);
                    }
                    l = Long.valueOf(sessionEntry2.getTimestamp());
                    sessionEntry = sessionEntry2;
                }
            }
            return arrayList;
        }
    }

    public static final long totalActiveTime(List<Interval> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        long j = 0;
        for (Interval interval : list) {
            j += interval.getEndTimestamp() - interval.getStartTimestamp();
        }
        return j;
    }

    public static final double totalDistance(List<LocationEntry> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt___CollectionsKt.sumOfDouble(CollectionsKt___CollectionsKt.windowed$default(list, 2, 0, new Function1<List<? extends LocationEntry>, Double>() { // from class: com.animaconnected.watch.fitness.FitnessDataUtilsKt$totalDistance$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Double invoke2(List<LocationEntry> list2) {
                Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                return Double.valueOf(LocationUtilsKt.distance(list2.get(0), list2.get(1)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(List<? extends LocationEntry> list2) {
                return invoke2((List<LocationEntry>) list2);
            }
        }, 6));
    }

    public static final double totalDistanceForIntervals(List<? extends List<LocationEntry>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += totalDistance((List) it.next());
        }
        return d;
    }
}
