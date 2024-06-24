package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.fitness.DBSleepData;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: SleepHistoryProcessor.kt */
/* loaded from: classes3.dex */
public final class SleepHistoryProcessor {
    public static final SleepHistoryProcessor INSTANCE = new SleepHistoryProcessor();

    private SleepHistoryProcessor() {
    }

    /* renamed from: insertSleepHistoryData-VAJrmyI, reason: not valid java name */
    private final void m1532insertSleepHistoryDataVAJrmyI(FitnessQueries fitnessQueries, final SleepSession sleepSession, String str) {
        long m1677getInWholeMillisecondsimpl = Duration.m1677getInWholeMillisecondsimpl(SleepSessionKt.lightSleepAmount(sleepSession));
        long m1677getInWholeMillisecondsimpl2 = Duration.m1677getInWholeMillisecondsimpl(SleepSessionKt.deepSleepAmount(sleepSession));
        LogKt.debug$default((Object) fitnessQueries, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.sleep.SleepHistoryProcessor$insertSleepHistoryData$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "\n            Inserting SleepPeriod to DB:\n            start: " + SleepSession.this.getSleepTimePeriod().getStart() + "\n            end: " + SleepSession.this.getSleepTimePeriod().getEnd() + "\n            light: " + ((Object) Duration.m1690toStringimpl(SleepSessionKt.lightSleepAmount(SleepSession.this))) + "\n            deep: " + ((Object) Duration.m1690toStringimpl(SleepSessionKt.deepSleepAmount(SleepSession.this))) + "\n            ";
            }
        }, 7, (Object) null);
        fitnessQueries.m1350insertSleepHistoryData_w5UW7A(str, sleepSession.getSleepTimePeriod().getStart().toEpochMilliseconds(), sleepSession.getSleepTimePeriod().getEnd().toEpochMilliseconds(), m1677getInWholeMillisecondsimpl, m1677getInWholeMillisecondsimpl2);
    }

    public final void process(FitnessProvider fitnessProvider, FitnessQueries db) {
        long epochMilliseconds;
        boolean z;
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        Intrinsics.checkNotNullParameter(db, "db");
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.sleep.SleepHistoryProcessor$process$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Start pre-processing of sleep history data";
            }
        }, 7, (Object) null);
        long epochMilliseconds2 = DateTimeUtilsKt.now().toEpochMilliseconds();
        SleepHistoryEntry sleepHistoryLatestEntry = fitnessProvider.getSleepHistoryLatestEntry();
        if (sleepHistoryLatestEntry != null) {
            epochMilliseconds = sleepHistoryLatestEntry.getEnd();
        } else {
            DBSleepData dBSleepData = (DBSleepData) CollectionsKt___CollectionsKt.firstOrNull((List) db.getSleepData(0L, epochMilliseconds2).executeAsList());
            if (dBSleepData == null) {
                return;
            }
            Instant.Companion companion = Instant.Companion;
            long timestamp = dBSleepData.getTimestamp();
            companion.getClass();
            Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(timestamp);
            TimeZone.Companion.getClass();
            epochMilliseconds = DateTimeUtilsKt.getStartOfDay(fromEpochMilliseconds, TimeZone.UTC).toEpochMilliseconds();
        }
        final List<SleepTimePeriod> sleepTimePeriods = SleepHistoryProcessorKt.toSleepTimePeriods(new TimePeriod(epochMilliseconds, epochMilliseconds2), db);
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.sleep.SleepHistoryProcessor$process$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return sleepTimePeriods.size() + " sleepTimePeriods to process";
            }
        }, 7, (Object) null);
        for (SleepTimePeriod sleepTimePeriod : sleepTimePeriods) {
            List<SleepEntry> sleepDataEntries = SleepTimePeriodKt.sleepDataEntries(sleepTimePeriod, db);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : sleepDataEntries) {
                HistoryDeviceId m1556boximpl = HistoryDeviceId.m1556boximpl(((SleepEntry) obj).mo1121getHistoryDeviceIdV9ZILtA());
                Object obj2 = linkedHashMap.get(m1556boximpl);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(m1556boximpl, obj2);
                }
                ((List) obj2).add(obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                linkedHashMap2.put(entry.getKey(), SleepSessionKt.toSleepSession(sleepTimePeriod, (List) entry.getValue()));
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                if (((SleepSession) entry2.getValue()).getState() == SleepSessionState.Completed) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                String m1562unboximpl = ((HistoryDeviceId) entry3.getKey()).m1562unboximpl();
                final SleepSession sleepSession = (SleepSession) entry3.getValue();
                SleepHistoryProcessor sleepHistoryProcessor = INSTANCE;
                LogKt.debug$default((Object) sleepHistoryProcessor, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.sleep.SleepHistoryProcessor$process$3$4$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Completed SleepSession to save to database: " + SleepSession.this.getSleepTimePeriod().getStart() + " -> " + SleepSession.this.getSleepTimePeriod().getEnd();
                    }
                }, 7, (Object) null);
                sleepHistoryProcessor.m1532insertSleepHistoryDataVAJrmyI(db, sleepSession, m1562unboximpl);
            }
        }
    }
}
