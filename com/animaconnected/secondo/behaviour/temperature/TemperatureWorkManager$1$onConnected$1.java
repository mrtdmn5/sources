package com.animaconnected.secondo.behaviour.temperature;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTypeConverters;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.google.common.util.concurrent.DirectExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TemperatureWorkManager.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$1$onConnected$1", f = "TemperatureWorkManager.kt", l = {109, 36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TemperatureWorkManager$1$onConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public TemperatureWorkManager$1$onConnected$1(Continuation<? super TemperatureWorkManager$1$onConnected$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemperatureWorkManager$1$onConnected$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        HistoricalWeatherProvider historicalWeatherProvider;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        boolean z2 = true;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            TemperatureWorkManager temperatureWorkManager = TemperatureWorkManager.INSTANCE;
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(KronabyApplication.Companion.getContext());
            workManagerImpl.getClass();
            StatusRunnable.AnonymousClass3 anonymousClass3 = new StatusRunnable<List<WorkInfo>>() { // from class: androidx.work.impl.utils.StatusRunnable.3
                public final /* synthetic */ String val$tag = "WeatherTask";

                public AnonymousClass3() {
                }

                @Override // androidx.work.impl.utils.StatusRunnable
                public final List runInternal$1() {
                    ArrayList<String> arrayList;
                    ArrayList<Data> arrayList2;
                    WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) WorkManagerImpl.this.mWorkDatabase.workSpecDao();
                    workSpecDao_Impl.getClass();
                    RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
                    String str = this.val$tag;
                    if (str == null) {
                        acquire.bindNull(1);
                    } else {
                        acquire.bindString(1, str);
                    }
                    RoomDatabase roomDatabase = workSpecDao_Impl.__db;
                    roomDatabase.assertNotSuspendingTransaction();
                    roomDatabase.beginTransaction();
                    try {
                        Cursor query = DBUtil.query(roomDatabase, acquire, true);
                        try {
                            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, ConfigurationItem.COLUMN_NAME_ID);
                            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndexOrThrow)) {
                                    String string = query.getString(columnIndexOrThrow);
                                    if (arrayMap.getOrDefault(string, null) == null) {
                                        arrayMap.put(string, new ArrayList<>());
                                    }
                                }
                                if (!query.isNull(columnIndexOrThrow)) {
                                    String string2 = query.getString(columnIndexOrThrow);
                                    if (arrayMap2.getOrDefault(string2, null) == null) {
                                        arrayMap2.put(string2, new ArrayList<>());
                                    }
                                }
                            }
                            query.moveToPosition(-1);
                            workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                            workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                            ArrayList arrayList3 = new ArrayList(query.getCount());
                            while (query.moveToNext()) {
                                if (!query.isNull(columnIndexOrThrow)) {
                                    arrayList = arrayMap.getOrDefault(query.getString(columnIndexOrThrow), null);
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList<>();
                                }
                                if (!query.isNull(columnIndexOrThrow)) {
                                    arrayList2 = arrayMap2.getOrDefault(query.getString(columnIndexOrThrow), null);
                                } else {
                                    arrayList2 = null;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList<>();
                                }
                                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                                workInfoPojo.id = query.getString(columnIndexOrThrow);
                                workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                                workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                                workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                                workInfoPojo.tags = arrayList;
                                workInfoPojo.progress = arrayList2;
                                arrayList3.add(workInfoPojo);
                            }
                            roomDatabase.setTransactionSuccessful();
                            query.close();
                            acquire.release();
                            roomDatabase.endTransaction();
                            return WorkSpec.WORK_INFO_MAPPER.apply(arrayList3);
                        } catch (Throwable th) {
                            query.close();
                            acquire.release();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        roomDatabase.endTransaction();
                        throw th2;
                    }
                }
            };
            ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).mBackgroundExecutor.execute(anonymousClass3);
            AbstractFuture abstractFuture = anonymousClass3.mFuture;
            Intrinsics.checkNotNullExpressionValue(abstractFuture, "getWorkInfosByTag(...)");
            if (abstractFuture.isDone()) {
                try {
                    obj = abstractFuture.get();
                } catch (ExecutionException e) {
                    Throwable cause = e.getCause();
                    if (cause == null) {
                        throw e;
                    }
                    throw cause;
                }
            } else {
                this.L$0 = abstractFuture;
                this.label = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(this));
                cancellableContinuationImpl.initCancellability();
                abstractFuture.addListener(new TemperatureWorkManager$getSuspending$2$1(cancellableContinuationImpl, abstractFuture), DirectExecutor.INSTANCE);
                obj = cancellableContinuationImpl.getResult();
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getSuspending(...)");
        Iterable iterable = (Iterable) obj;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                WorkInfo.State state = ((WorkInfo) it.next()).mState;
                if (state != WorkInfo.State.ENQUEUED && state != WorkInfo.State.RUNNING) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            historicalWeatherProvider = TemperatureWorkManager.provider;
            this.L$0 = null;
            this.label = 2;
            if (historicalWeatherProvider.fetchTemperatureSuspending(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemperatureWorkManager$1$onConnected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
