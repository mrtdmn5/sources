package com.google.firebase.crashlytics.internal.send;

import android.database.SQLException;
import android.util.Log;
import com.google.android.datatransport.AutoValue_Event;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class ReportQueue {
    public final double base;
    public long lastUpdatedMs;
    public final OnDemandCounter onDemandCounter;
    public final ArrayBlockingQueue queue;
    public final int queueCapacity;
    public final double ratePerMinute;
    public final ThreadPoolExecutor singleThreadExecutor;
    public int step;
    public final long stepDurationMs;
    public final Transport<CrashlyticsReport> transport;

    /* loaded from: classes3.dex */
    public final class ReportRunnable implements Runnable {
        public final CrashlyticsReportWithSessionId reportWithSessionId;
        public final TaskCompletionSource<CrashlyticsReportWithSessionId> tcs;

        public ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource taskCompletionSource) {
            this.reportWithSessionId = crashlyticsReportWithSessionId;
            this.tcs = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReportQueue reportQueue = ReportQueue.this;
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = this.reportWithSessionId;
            reportQueue.sendReport(crashlyticsReportWithSessionId, this.tcs);
            boolean z = false;
            reportQueue.onDemandCounter.droppedOnDemandExceptions.set(0);
            double min = Math.min(3600000.0d, Math.pow(reportQueue.base, reportQueue.calcStep()) * (60000.0d / reportQueue.ratePerMinute));
            String str = "Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(min / 1000.0d)) + " s for report: " + crashlyticsReportWithSessionId.getSessionId();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                z = true;
            }
            if (z) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            try {
                Thread.sleep((long) min);
            } catch (InterruptedException unused) {
            }
        }
    }

    public ReportQueue(Transport<CrashlyticsReport> transport, Settings settings, OnDemandCounter onDemandCounter) {
        double d = settings.onDemandUploadRatePerMinute;
        this.ratePerMinute = d;
        this.base = settings.onDemandBackoffBase;
        this.stepDurationMs = settings.onDemandBackoffStepDurationSeconds * 1000;
        this.transport = transport;
        this.onDemandCounter = onDemandCounter;
        int r8 = (int) d;
        this.queueCapacity = r8;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(r8);
        this.queue = arrayBlockingQueue;
        this.singleThreadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.step = 0;
        this.lastUpdatedMs = 0L;
    }

    public final int calcStep() {
        boolean z;
        int max;
        if (this.lastUpdatedMs == 0) {
            this.lastUpdatedMs = System.currentTimeMillis();
        }
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.lastUpdatedMs) / this.stepDurationMs);
        if (this.queue.size() == this.queueCapacity) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            max = Math.min(100, this.step + currentTimeMillis);
        } else {
            max = Math.max(0, this.step - currentTimeMillis);
        }
        if (this.step != max) {
            this.step = max;
            this.lastUpdatedMs = System.currentTimeMillis();
        }
        return max;
    }

    public final void sendReport(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        String str = "Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.getSessionId();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
        ((TransportImpl) this.transport).schedule(new AutoValue_Event(crashlyticsReportWithSessionId.getReport(), Priority.HIGHEST), new TransportScheduleCallback() { // from class: com.google.firebase.crashlytics.internal.send.ReportQueue$$ExternalSyntheticLambda0
            @Override // com.google.android.datatransport.TransportScheduleCallback
            public final void onSchedule(Exception exc) {
                final ReportQueue reportQueue = this;
                reportQueue.getClass();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (exc != null) {
                    taskCompletionSource2.trySetException(exc);
                    return;
                }
                boolean z = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                new Thread(new Runnable() { // from class: com.google.firebase.crashlytics.internal.send.ReportQueue$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Transport<CrashlyticsReport> transport;
                        Priority priority;
                        ReportQueue reportQueue2 = ReportQueue.this;
                        reportQueue2.getClass();
                        try {
                            transport = reportQueue2.transport;
                            priority = Priority.HIGHEST;
                        } catch (SQLException unused) {
                        }
                        if (transport instanceof TransportImpl) {
                            TransportRuntime.getInstance().uploader.logAndUpdateState(((TransportImpl) transport).transportContext.withPriority(priority), 1);
                            countDownLatch.countDown();
                            return;
                        }
                        throw new IllegalArgumentException("Expected instance of TransportImpl.");
                    }
                }).start();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                ExecutorService executorService = Utils.TASK_CONTINUATION_EXECUTOR_SERVICE;
                boolean z2 = false;
                try {
                    long nanos = timeUnit.toNanos(2L);
                    long nanoTime = System.nanoTime() + nanos;
                    while (true) {
                        try {
                            try {
                                countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                                break;
                            } catch (Throwable th) {
                                th = th;
                                if (z) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        } catch (InterruptedException unused) {
                            nanos = nanoTime - System.nanoTime();
                            z2 = true;
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    taskCompletionSource2.trySetResult(crashlyticsReportWithSessionId);
                } catch (Throwable th2) {
                    th = th2;
                    z = z2;
                }
            }
        });
    }
}
