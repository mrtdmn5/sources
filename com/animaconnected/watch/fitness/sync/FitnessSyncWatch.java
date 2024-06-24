package com.animaconnected.watch.fitness.sync;

import app.cash.sqldelight.TransactionWithoutReturn;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.WatchIO;
import com.animaconnected.watch.fitness.DBSpeedCalibration;
import com.animaconnected.watch.fitness.Distance;
import com.animaconnected.watch.fitness.Elevation;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessMetric;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.GpsQuality;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.Interval;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SpeedCalibration;
import com.animaconnected.watch.fitness.SyncResult;
import com.animaconnected.watch.fitness.SyncState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FitnessSyncWatch.kt */
/* loaded from: classes3.dex */
public final class FitnessSyncWatch implements FitnessSyncIO {
    public static final Companion Companion = new Companion(null);
    public static final String clearDailyFitnessDataKey = "clearFitnessDataFromWatch";
    private final FitnessQueries db;
    private final String historyDeviceId;
    private Job readFitnessDataJob;
    private final CoroutineScope scope;
    private final SharedFlow<SyncResult> sharedSyncProgressFlow;
    private final MutableStateFlow<SyncResult> syncProgressStateFlow;
    private final WatchIO watchIO;

    /* compiled from: FitnessSyncWatch.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ FitnessSyncWatch(String str, FitnessQueries fitnessQueries, WatchIO watchIO, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fitnessQueries, watchIO, coroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int accumulate(int r10, Integer num, String str) {
        int r1;
        if (num != null) {
            r1 = num.intValue();
        } else {
            r1 = 0;
        }
        int r12 = r10 - r1;
        if (r12 < 0) {
            LogKt.err$default((Object) Integer.valueOf(r10), str + " is negative! | App: " + num + ", Watch: " + r10, (String) null, (Throwable) null, false, 14, (Object) null);
            return 0;
        }
        return r12;
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public void addLocationData(double d, double d2, float f, double d3, boolean z) {
        this.db.m1342insertLocationDataEBUUAns(this.historyDeviceId, DateTimeUtilsKt.currentTimeMillis(), d, d2, f, d3, z);
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public void addProcessedSession(Session session) {
        Intrinsics.checkNotNullParameter(session, "session");
        FitnessDatabaseExtensionsKt.insertSession(this.db, session);
        int r8 = 0;
        for (Object obj : session.getElevation()) {
            int r17 = r8 + 1;
            if (r8 >= 0) {
                Elevation elevation = (Elevation) obj;
                this.db.m1337insertElevationEBUUAns(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs(), r8, elevation.getLong(), elevation.getLat(), elevation.getElevation(), elevation.getResolution());
                r8 = r17;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        for (Interval interval : session.getIntervals()) {
            this.db.m1341insertInterval4i7cvns(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs(), interval.getStartTimestamp(), interval.getEndTimestamp());
        }
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public void addProcessedSessions(final List<Session> sessions) {
        Intrinsics.checkNotNullParameter(sessions, "sessions");
        this.db.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.sync.FitnessSyncWatch$addProcessedSessions$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                List<Session> list = sessions;
                FitnessSyncWatch fitnessSyncWatch = this;
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    fitnessSyncWatch.addProcessedSession((Session) it.next());
                }
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object addSteps(long j, int r16, Continuation<? super Unit> continuation) {
        this.db.m1333insertActivityDatahSv7xU0(this.historyDeviceId, j, new Integer(0), new Integer(0), new Integer(r16), new Integer(0), new Integer(0), new Float(0.0f), new Integer(0), new Integer(0));
        return Unit.INSTANCE;
    }

    public final DBSpeedCalibration getLatestSpeedCalibrationCoefficient$watch_release() {
        return this.db.getLatestSpeedCalibrationData().executeAsOneOrNull();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:            if (r0.isActive() == true) goto L8;     */
    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlinx.coroutines.flow.Flow<com.animaconnected.watch.fitness.SyncResult> readFitnessData(com.animaconnected.watch.DisplayWatch r10) {
        /*
            r9 = this;
            java.lang.String r0 = "watch"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlinx.coroutines.Job r0 = r9.readFitnessDataJob
            if (r0 == 0) goto L11
            boolean r0 = r0.isActive()
            r1 = 1
            if (r0 != r1) goto L11
            goto L12
        L11:
            r1 = 0
        L12:
            if (r1 == 0) goto L24
            java.lang.String r3 = "Already a read in progress"
            java.lang.String r4 = "FitnessData"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            r2 = r9
            com.animaconnected.logger.LogKt.debug$default(r2, r3, r4, r5, r6, r7, r8)
            kotlinx.coroutines.flow.SharedFlow<com.animaconnected.watch.fitness.SyncResult> r10 = r9.sharedSyncProgressFlow
            return r10
        L24:
            kotlinx.coroutines.flow.MutableStateFlow<com.animaconnected.watch.fitness.SyncResult> r0 = r9.syncProgressStateFlow
            com.animaconnected.watch.fitness.SyncResult r7 = new com.animaconnected.watch.fitness.SyncResult
            com.animaconnected.watch.fitness.SyncState r2 = com.animaconnected.watch.fitness.SyncState.Calculating
            r3 = 0
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0.setValue(r7)
            kotlinx.coroutines.CoroutineScope r0 = r9.scope
            com.animaconnected.watch.fitness.sync.FitnessSyncWatch$readFitnessData$1 r1 = new com.animaconnected.watch.fitness.sync.FitnessSyncWatch$readFitnessData$1
            r2 = 0
            r1.<init>(r10, r9, r2)
            r10 = 3
            kotlinx.coroutines.StandaloneCoroutine r10 = kotlinx.coroutines.BuildersKt.launch$default(r0, r2, r2, r1, r10)
            r9.readFitnessDataJob = r10
            kotlinx.coroutines.flow.SharedFlow<com.animaconnected.watch.fitness.SyncResult> r10 = r9.sharedSyncProgressFlow
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.sync.FitnessSyncWatch.readFitnessData(com.animaconnected.watch.DisplayWatch):kotlinx.coroutines.flow.Flow");
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object readSessionData(Continuation<? super Map<FitnessMetric, Integer>> continuation) {
        return this.watchIO.readSessionData(continuation);
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object readStepsDay(int r2, Continuation<? super List<Integer>> continuation) {
        return this.watchIO.readStepsDay(r2, continuation);
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object setGoal(HealthGoals healthGoals, Continuation<? super Unit> continuation) {
        FitnessDatabaseExtensionsKt.m1238insertGoalkRTOawE(this.db, this.historyDeviceId, DateTimeUtilsKt.getStartOfDayEpochMillis$default(null, 1, null), healthGoals);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object writeDailyFitnessData(com.animaconnected.watch.device.BasicStorage r43, kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.sync.FitnessSyncWatch.writeDailyFitnessData(com.animaconnected.watch.device.BasicStorage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object writeHeartRateLive(boolean z, Continuation<? super Unit> continuation) {
        Object writeHeartrateLiveMode = this.watchIO.writeHeartrateLiveMode(z, continuation);
        if (writeHeartrateLiveMode == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeHeartrateLiveMode;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object writeSessionDataFeed(GpsQuality gpsQuality, Distance distance, Float f, Continuation<? super Unit> continuation) {
        Object writeSessionDataFeed = this.watchIO.writeSessionDataFeed(gpsQuality, distance, f, continuation);
        if (writeSessionDataFeed == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeSessionDataFeed;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object writeSpeedCalibration(SpeedCalibration speedCalibration, Continuation<? super Unit> continuation) {
        Object writeSpeedCalibration = this.watchIO.writeSpeedCalibration(speedCalibration, continuation);
        if (writeSpeedCalibration == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeSpeedCalibration;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.sync.FitnessSyncIO
    public Object writeStepsDay(int r2, int r3, Continuation<? super Unit> continuation) {
        Object writeStepsDay = this.watchIO.writeStepsDay(r2, r3, continuation);
        if (writeStepsDay == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeStepsDay;
        }
        return Unit.INSTANCE;
    }

    private FitnessSyncWatch(String historyDeviceId, FitnessQueries db, WatchIO watchIO, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(watchIO, "watchIO");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.historyDeviceId = historyDeviceId;
        this.db = db;
        this.watchIO = watchIO;
        this.scope = scope;
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(new SyncResult(SyncState.Done, 1.0f, null, 4, null));
        this.syncProgressStateFlow = MutableStateFlow;
        this.sharedSyncProgressFlow = FlowKt.shareIn(MutableStateFlow, scope, SharingStarted.Companion.WhileSubscribed$default(), 0);
    }
}
