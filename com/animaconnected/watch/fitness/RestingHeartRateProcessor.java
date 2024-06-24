package com.animaconnected.watch.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.LocalTime;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.DateTimeArithmeticException;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: RestingHeartRateProcessor.kt */
/* loaded from: classes3.dex */
public final class RestingHeartRateProcessor {
    public static final RestingHeartRateProcessor INSTANCE = new RestingHeartRateProcessor();

    private RestingHeartRateProcessor() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009e, code lost:            if (r5.getHeartrate() != null) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Integer calculateRestingHeartRate(com.animaconnected.watch.fitness.TimePeriod r9, com.animaconnected.watch.fitness.FitnessQueries r10) {
        /*
            r8 = this;
            long r0 = r9.getStartTs()
            long r2 = r9.getEndTs()
            app.cash.sqldelight.Query r9 = r10.getRawHRAndActivty(r0, r2)
            java.util.List r9 = r9.executeAsList()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.util.Iterator r9 = r9.iterator()
        L1b:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L44
            java.lang.Object r0 = r9.next()
            r1 = r0
            com.animaconnected.watch.fitness.GetRawHRAndActivty r1 = (com.animaconnected.watch.fitness.GetRawHRAndActivty) r1
            java.lang.String r1 = r1.m1436getHdidV9ZILtA()
            com.animaconnected.watch.model.HistoryDeviceId r1 = com.animaconnected.watch.model.HistoryDeviceId.m1556boximpl(r1)
            java.lang.Object r2 = r10.get(r1)
            if (r2 != 0) goto L3e
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r10.put(r1, r2)
        L3e:
            java.util.List r2 = (java.util.List) r2
            r2.add(r0)
            goto L1b
        L44:
            java.util.ArrayList r9 = new java.util.ArrayList
            int r0 = r10.size()
            r9.<init>(r0)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L55:
            boolean r0 = r10.hasNext()
            r1 = 0
            if (r0 == 0) goto Lcb
            java.lang.Object r0 = r10.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r0 = r0.getValue()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
            r3 = r1
        L72:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto La8
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.animaconnected.watch.fitness.GetRawHRAndActivty r5 = (com.animaconnected.watch.fitness.GetRawHRAndActivty) r5
            java.lang.Integer r6 = r5.getActivity_class()
            r7 = 1
            if (r6 == 0) goto L98
            com.animaconnected.watch.fitness.ActivityClass$Companion r3 = com.animaconnected.watch.fitness.ActivityClass.Companion
            java.lang.Integer r5 = r5.getActivity_class()
            com.animaconnected.watch.fitness.ActivityClass r3 = r3.fromId(r5)
            com.animaconnected.watch.fitness.ActivityClass r5 = com.animaconnected.watch.fitness.ActivityClass.Rest
            if (r3 != r5) goto L96
            r3 = r7
            goto La1
        L96:
            r3 = r1
            goto La1
        L98:
            if (r3 == 0) goto La1
            java.lang.Integer r5 = r5.getHeartrate()
            if (r5 == 0) goto La1
            goto La2
        La1:
            r7 = r1
        La2:
            if (r7 == 0) goto L72
            r2.add(r4)
            goto L72
        La8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r2.iterator()
        Lb1:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto Lc7
            java.lang.Object r2 = r1.next()
            com.animaconnected.watch.fitness.GetRawHRAndActivty r2 = (com.animaconnected.watch.fitness.GetRawHRAndActivty) r2
            java.lang.Integer r2 = r2.getHeartrate()
            if (r2 == 0) goto Lb1
            r0.add(r2)
            goto Lb1
        Lc7:
            r9.add(r0)
            goto L55
        Lcb:
            java.util.ArrayList r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.flatten(r9)
            int r10 = r9.size()
            r0 = 30
            if (r10 <= r0) goto Led
            java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.sorted(r9)
            r10 = 10
            java.util.List r9 = r9.subList(r1, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            double r9 = kotlin.collections.CollectionsKt___CollectionsKt.averageOfInt(r9)
            int r9 = (int) r9
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            goto Lee
        Led:
            r9 = 0
        Lee:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.RestingHeartRateProcessor.calculateRestingHeartRate(com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.FitnessQueries):java.lang.Integer");
    }

    private final Instant plusLocalTime(Instant instant, DatePeriod period) {
        LocalDate localDate;
        TimeZone.Companion.getClass();
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(instant, TimeZone.Companion.currentSystemDefault());
        LocalTime localTime = localDateTime.value.toLocalTime();
        Intrinsics.checkNotNullExpressionValue(localTime, "value.toLocalTime()");
        kotlinx.datetime.LocalTime localTime2 = new kotlinx.datetime.LocalTime(localTime);
        kotlinx.datetime.LocalDate date = localDateTime.getDate();
        int r1 = LocalDateJvmKt.$r8$clinit;
        LocalDate localDate2 = date.value;
        Intrinsics.checkNotNullParameter(period, "period");
        try {
            int r2 = period.totalMonths;
            if (r2 != 0) {
                localDate = localDate2.plusMonths(r2);
            } else {
                localDate = localDate2;
            }
            int r7 = period.days;
            if (r7 != 0) {
                localDate = localDate.plusDays(r7);
            }
            j$.time.LocalDateTime of = j$.time.LocalDateTime.of(new kotlinx.datetime.LocalDate(localDate).value, localTime2.value);
            Intrinsics.checkNotNullExpressionValue(of, "of(date.value, time.value)");
            return TimeZoneKt.toInstant(new LocalDateTime(of), TimeZone.Companion.currentSystemDefault());
        } catch (DateTimeException unused) {
            throw new DateTimeArithmeticException("The result of adding " + localDate2 + " to " + date + " is out of LocalDate range.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.animaconnected.watch.fitness.TimePeriod, T] */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.animaconnected.watch.fitness.TimePeriod, T] */
    /* renamed from: process-cu7-zPM, reason: not valid java name */
    public final void m1459processcu7zPM(String historyDeviceId, FitnessQueries db) {
        Long l;
        Instant instant;
        int r0;
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(db, "db");
        DBRestingHeartrateData executeAsOneOrNull = db.getLastRestingHeartrateHistoryEntry().executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            l = Long.valueOf(executeAsOneOrNull.getTimestamp());
        } else {
            l = null;
        }
        if (l != null) {
            Instant.Companion companion = Instant.Companion;
            long longValue = l.longValue();
            companion.getClass();
            instant = plusLocalTime(Instant.Companion.fromEpochMilliseconds(longValue), new DatePeriod());
        } else {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.RestingHeartRateProcessor$process$dayToProcessFrom$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No previous processed resting HR values, trying HR values";
                }
            }, 7, (Object) null);
            DBHeartrateData executeAsOneOrNull2 = db.getFirstHeartrateData().executeAsOneOrNull();
            if (executeAsOneOrNull2 != null) {
                long timestamp = executeAsOneOrNull2.getTimestamp();
                Instant.Companion.getClass();
                instant = Instant.Companion.fromEpochMilliseconds(timestamp);
            } else {
                instant = null;
            }
        }
        if (instant == null) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.RestingHeartRateProcessor$process$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No data to process from.";
                }
            }, 7, (Object) null);
            return;
        }
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(instant, null, 2, null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Instant plusLocalTime = plusLocalTime(startOfDay$default, new DatePeriod());
        int r3 = Duration.$r8$clinit;
        ?? timePeriod = new TimePeriod(startOfDay$default, plusLocalTime.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.MILLISECONDS)));
        ref$ObjectRef.element = timePeriod;
        if (DateTimeUtilsKt.sameDay$default(timePeriod.getEnd(), DateTimeUtilsKt.now(), null, 2, null)) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.RestingHeartRateProcessor$process$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No previous days to process";
                }
            }, 7, (Object) null);
            return;
        }
        while (((TimePeriod) ref$ObjectRef.element).getEnd().compareTo(DateTimeUtilsKt.now()) < 0) {
            Integer calculateRestingHeartRate = calculateRestingHeartRate((TimePeriod) ref$ObjectRef.element, db);
            if (calculateRestingHeartRate != null) {
                r0 = calculateRestingHeartRate.intValue();
            } else {
                r0 = 0;
            }
            final int r14 = r0;
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.RestingHeartRateProcessor$process$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Inserting resting hr (" + r14 + ") for period " + ref$ObjectRef.element;
                }
            }, 7, (Object) null);
            db.m1346insertRestingHeartrateDataOZHprlw(historyDeviceId, ((TimePeriod) ref$ObjectRef.element).getEndTs(), r14);
            Instant startOfDay$default2 = DateTimeUtilsKt.getStartOfDay$default(plusLocalTime(((TimePeriod) ref$ObjectRef.element).getStart(), new DatePeriod()), null, 2, null);
            Instant plusLocalTime2 = plusLocalTime(startOfDay$default2, new DatePeriod());
            int r32 = Duration.$r8$clinit;
            ref$ObjectRef.element = new TimePeriod(startOfDay$default2, plusLocalTime2.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.MILLISECONDS)));
        }
    }
}
