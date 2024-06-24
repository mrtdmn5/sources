package com.animaconnected.watch.account.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: FitnessCloudProvider.kt */
/* loaded from: classes3.dex */
public final class FitnessCloudProvider {
    private final FitnessQueries db;
    private boolean failedLastSync;
    private final FitnessCloudSyncApi fitnessCloudSyncApi;
    private boolean isSyncing;
    private final String lastSyncedKey;
    private final BasicStorage storage;
    private final long syncInterval;
    private final String tag;
    private final String uploadFromKey;

    public FitnessCloudProvider(FitnessCloudSyncApi fitnessCloudSyncApi, BasicStorage storage, FitnessQueries db) {
        Intrinsics.checkNotNullParameter(fitnessCloudSyncApi, "fitnessCloudSyncApi");
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(db, "db");
        this.fitnessCloudSyncApi = fitnessCloudSyncApi;
        this.storage = storage;
        this.db = db;
        this.tag = "FitnessCloudProvider";
        int r2 = Duration.$r8$clinit;
        this.syncInterval = DurationKt.toDuration(12, DurationUnit.HOURS);
        this.lastSyncedKey = "last_synced_fitness";
        this.uploadFromKey = "fitness_upload_from";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0081 A[LOOP:0: B:11:0x007b->B:13:0x0081, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object exportFitnessFiles(com.animaconnected.watch.fitness.FitnessQueries r10, final com.animaconnected.watch.fitness.TimePeriod r11, kotlin.coroutines.Continuation<? super java.util.List<com.animaconnected.watch.account.fitness.FitnessFile>> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$1 r0 = (com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$1 r0 = new com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$1
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r10 = r0.L$2
            r11 = r10
            com.animaconnected.watch.fitness.TimePeriod r11 = (com.animaconnected.watch.fitness.TimePeriod) r11
            java.lang.Object r10 = r0.L$1
            com.animaconnected.watch.fitness.FitnessQueries r10 = (com.animaconnected.watch.fitness.FitnessQueries) r10
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudProvider r0 = (com.animaconnected.watch.account.fitness.FitnessCloudProvider) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L59
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.CoroutineDispatcher r12 = com.animaconnected.watch.DispatchersKt.ioDispatcher()
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1 r2 = new com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$daysToUpdate$1
            r4 = 0
            r2.<init>(r9, r11, r10, r4)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r12, r2, r0)
            if (r12 != r1) goto L58
            return r1
        L58:
            r0 = r9
        L59:
            java.util.Set r12 = (java.util.Set) r12
            java.lang.String r3 = r0.tag
            r4 = 0
            r5 = 0
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$2 r6 = new com.animaconnected.watch.account.fitness.FitnessCloudProvider$exportFitnessFiles$2
            r6.<init>()
            r7 = 6
            r8 = 0
            r2 = r10
            com.animaconnected.logger.LogKt.debug$default(r2, r3, r4, r5, r6, r7, r8)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.ArrayList r11 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r12, r0)
            r11.<init>(r0)
            java.util.Iterator r12 = r12.iterator()
        L7b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L9e
            java.lang.Object r0 = r12.next()
            com.animaconnected.watch.fitness.TimePeriod r0 = (com.animaconnected.watch.fitness.TimePeriod) r0
            com.animaconnected.watch.account.fitness.FitnessFile r1 = new com.animaconnected.watch.account.fitness.FitnessFile
            kotlinx.datetime.Instant r2 = r0.getStart()
            long r2 = r2.toEpochMilliseconds()
            com.animaconnected.watch.fitness.FitnessDatabaseParser r4 = com.animaconnected.watch.fitness.FitnessDatabaseParser.INSTANCE
            java.lang.String r0 = r4.exportToJson(r10, r0)
            r1.<init>(r2, r0)
            r11.add(r1)
            goto L7b
        L9e:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudProvider.exportFitnessFiles(com.animaconnected.watch.fitness.FitnessQueries, com.animaconnected.watch.fitness.TimePeriod, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getDeletedDays(FitnessQueries fitnessQueries, Continuation<? super Set<TimePeriod>> continuation) {
        return BuildersKt.withContext(DispatchersKt.ioDispatcher(), new FitnessCloudProvider$getDeletedDays$2(fitnessQueries, null), continuation);
    }

    private final Instant getLastSyncedInstant() {
        Instant.Companion companion = Instant.Companion;
        long lastSynced = getLastSynced();
        companion.getClass();
        return Instant.Companion.fromEpochMilliseconds(lastSynced);
    }

    private final Instant getUploadFrom() {
        long currentTimeMillis;
        Instant.Companion companion = Instant.Companion;
        Long l = this.storage.getLong(this.uploadFromKey);
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = DateTimeUtilsKt.currentTimeMillis();
        }
        companion.getClass();
        return Instant.Companion.fromEpochMilliseconds(currentTimeMillis);
    }

    public final Object importFitnessFiles(FitnessQueries fitnessQueries, List<FitnessFile> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(DispatchersKt.ioDispatcher(), new FitnessCloudProvider$importFitnessFiles$2(fitnessQueries, list, this, null), continuation);
        if (withContext == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    private final void setUploadFrom(Instant instant) {
        this.storage.put(this.uploadFromKey, instant.toEpochMilliseconds());
    }

    public final List<TimePeriod> splitToDays(TimePeriod timePeriod) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        Instant start = timePeriod.getStart();
        TimeZone.Companion.getClass();
        TimePeriod day = companion.day(start, TimeZone.UTC);
        ArrayList arrayList = new ArrayList();
        while (timePeriod.getEnd().compareTo(day.getStart()) > 0) {
            arrayList.add(day);
            TimePeriod.Companion companion2 = TimePeriod.Companion;
            Instant start2 = day.getStart();
            int r3 = Duration.$r8$clinit;
            Instant m1706plusLRDsOJo = start2.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
            TimeZone.Companion.getClass();
            day = companion2.day(m1706plusLRDsOJo, TimeZone.UTC);
        }
        return arrayList;
    }

    public static /* synthetic */ Object sync$default(FitnessCloudProvider fitnessCloudProvider, String str, boolean z, Continuation continuation, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            z = false;
        }
        return fitnessCloudProvider.sync(str, z, continuation);
    }

    public final void clearLocalTimestamps() {
        setLastSynced(0L);
        setUploadFrom(DateTimeUtilsKt.now());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteData(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.animaconnected.watch.account.fitness.FitnessCloudProvider$deleteData$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$deleteData$1 r0 = (com.animaconnected.watch.account.fitness.FitnessCloudProvider$deleteData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.account.fitness.FitnessCloudProvider$deleteData$1 r0 = new com.animaconnected.watch.account.fitness.FitnessCloudProvider$deleteData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.account.fitness.FitnessCloudProvider r5 = (com.animaconnected.watch.account.fitness.FitnessCloudProvider) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.account.fitness.FitnessCloudSyncApi r6 = r4.fitnessCloudSyncApi
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.deleteData(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            r5.clearLocalTimestamps()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudProvider.deleteData(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long getLastSynced() {
        Long l = this.storage.getLong(this.lastSyncedKey);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void setLastSynced(long j) {
        this.storage.put(this.lastSyncedKey, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01dd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sync(java.lang.String r25, boolean r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r27) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.account.fitness.FitnessCloudProvider.sync(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
