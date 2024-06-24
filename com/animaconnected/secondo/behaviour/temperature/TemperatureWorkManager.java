package com.animaconnected.secondo.behaviour.temperature;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: TemperatureWorkManager.kt */
/* loaded from: classes3.dex */
public final class TemperatureWorkManager {
    public static final int $stable;
    private static final String WORK_NAME = "WeatherTask";
    public static final TemperatureWorkManager INSTANCE = new TemperatureWorkManager();
    private static final HistoricalWeatherProvider provider = ProviderFactory.getWeatherProvider();

    /* compiled from: TemperatureWorkManager.kt */
    /* loaded from: classes3.dex */
    public static final class TemperatureWorker extends CoroutineWorker {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TemperatureWorker(Context context, WorkerParameters params) {
            super(context, params);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(params, "params");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @Override // androidx.work.CoroutineWorker
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$1
                if (r0 == 0) goto L13
                r0 = r6
                com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$1 r0 = (com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$1 r0 = new com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$1
                r0.<init>(r5, r6)
            L18:
                java.lang.Object r6 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.ResultKt.throwOnFailure(r6)
                goto L45
            L27:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L2f:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlinx.coroutines.scheduling.DefaultScheduler r6 = kotlinx.coroutines.Dispatchers.Default
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.internal.MainDispatcherLoader.dispatcher
                com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$2 r2 = new com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager$TemperatureWorker$doWork$2
                r4 = 0
                r2.<init>(r4)
                r0.label = r3
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
                if (r6 != r1) goto L45
                return r1
            L45:
                java.lang.String r0 = "withContext(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager.TemperatureWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    static {
        ProviderFactory.getWatch().registerDeviceConnectionListener(new DeviceConnectionListener() { // from class: com.animaconnected.secondo.behaviour.temperature.TemperatureWorkManager.1
            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onConnected() {
                BuildersKt.async$default(KronabyApplication.Companion.getScope(), null, new TemperatureWorkManager$1$onConnected$1(null), 3);
            }
        });
        $stable = 8;
    }

    private TemperatureWorkManager() {
    }

    private final <R> Object getSuspending$$forInline(ListenableFuture<R> listenableFuture, Continuation<? super R> continuation) {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw e;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        listenableFuture.addListener(new TemperatureWorkManager$getSuspending$2$1(cancellableContinuationImpl, listenableFuture), DirectExecutor.INSTANCE);
        Unit unit = Unit.INSTANCE;
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    public final <R> Object getSuspending(ListenableFuture<R> listenableFuture, Continuation<? super R> continuation) {
        if (listenableFuture.isDone()) {
            try {
                return listenableFuture.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    throw e;
                }
                throw cause;
            }
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        listenableFuture.addListener(new TemperatureWorkManager$getSuspending$2$1(cancellableContinuationImpl, listenableFuture), DirectExecutor.INSTANCE);
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    public final void startTemperatureScheduler$secondo_kronabyRelease() {
        Constraints.Builder builder = new Constraints.Builder();
        builder.mRequiredNetworkType = NetworkType.CONNECTED;
        Constraints constraints = new Constraints(builder);
        PeriodicWorkRequest.Builder builder2 = new PeriodicWorkRequest.Builder(TemperatureWorker.class, TimeUnit.HOURS);
        WorkSpec workSpec = builder2.mWorkSpec;
        workSpec.constraints = constraints;
        BackoffPolicy backoffPolicy = BackoffPolicy.EXPONENTIAL;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        builder2.mBackoffCriteriaSet = true;
        workSpec.backoffPolicy = backoffPolicy;
        long millis = timeUnit.toMillis(15L);
        String str = WorkSpec.TAG;
        if (millis > 18000000) {
            Logger.get().warning(str, "Backoff delay duration exceeds maximum value", new Throwable[0]);
            millis = 18000000;
        }
        if (millis < 10000) {
            Logger.get().warning(str, "Backoff delay duration less than minimum value", new Throwable[0]);
            millis = 10000;
        }
        workSpec.backoffDelayDuration = millis;
        builder2.mTags.add(WORK_NAME);
        PeriodicWorkRequest build = builder2.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(KronabyApplication.Companion.getContext());
        ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy = ExistingPeriodicWorkPolicy.REPLACE;
        workManagerImpl.getClass();
        new WorkContinuationImpl(workManagerImpl, WORK_NAME, ExistingWorkPolicy.KEEP, Collections.singletonList(build)).enqueue();
        LogKt.debug$default((Object) this, "Start fetching temperature", (String) null, (Throwable) null, false, 14, (Object) null);
    }

    public final void stopTemperatureScheduler$secondo_kronabyRelease() {
        final WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(KronabyApplication.Companion.getContext());
        workManagerImpl.getClass();
        ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).executeOnBackgroundThread(new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            public final /* synthetic */ String val$tag = "WeatherTask";

            @Override // androidx.work.impl.utils.CancelWorkRunnable
            public final void runInternal() {
                WorkManagerImpl workManagerImpl2 = WorkManagerImpl.this;
                WorkDatabase workDatabase = workManagerImpl2.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    Iterator it = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getUnfinishedWorkWithTag(this.val$tag).iterator();
                    while (it.hasNext()) {
                        CancelWorkRunnable.cancel(workManagerImpl2, (String) it.next());
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    Schedulers.schedule(workManagerImpl2.mConfiguration, workManagerImpl2.mWorkDatabase, workManagerImpl2.mSchedulers);
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        });
        LogKt.debug$default((Object) this, "Stop fetching temperature", (String) null, (Throwable) null, false, 14, (Object) null);
    }
}
