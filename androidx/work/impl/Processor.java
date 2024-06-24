package androidx.work.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class Processor implements ExecutionListener, ForegroundProcessor {
    public static final String TAG = Logger.tagWithPrefix("Processor");
    public final Context mAppContext;
    public final Configuration mConfiguration;
    public final List<Scheduler> mSchedulers;
    public final WorkDatabase mWorkDatabase;
    public final TaskExecutor mWorkTaskExecutor;
    public final HashMap mEnqueuedWorkMap = new HashMap();
    public final HashMap mForegroundWorkMap = new HashMap();
    public final HashSet mCancelledIds = new HashSet();
    public final ArrayList mOuterListeners = new ArrayList();
    public PowerManager.WakeLock mForegroundLock = null;
    public final Object mLock = new Object();

    /* loaded from: classes.dex */
    public static class FutureListener implements Runnable {
        public final ExecutionListener mExecutionListener;
        public final ListenableFuture<Boolean> mFuture;
        public final String mWorkSpecId;

        public FutureListener(ExecutionListener executionListener, String workSpecId, SettableFuture future) {
            this.mExecutionListener = executionListener;
            this.mWorkSpecId = workSpecId;
            this.mFuture = future;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            try {
                z = this.mFuture.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.mExecutionListener.onExecuted(this.mWorkSpecId, z);
        }
    }

    public Processor(Context appContext, Configuration configuration, WorkManagerTaskExecutor workTaskExecutor, WorkDatabase workDatabase, List schedulers) {
        this.mAppContext = appContext;
        this.mConfiguration = configuration;
        this.mWorkTaskExecutor = workTaskExecutor;
        this.mWorkDatabase = workDatabase;
        this.mSchedulers = schedulers;
    }

    public static boolean interrupt(String id, WorkerWrapper wrapper) {
        boolean z;
        if (wrapper != null) {
            wrapper.mInterrupted = true;
            wrapper.tryCheckForInterruptionAndResolve();
            ListenableFuture<ListenableWorker.Result> listenableFuture = wrapper.mInnerFuture;
            if (listenableFuture != null) {
                z = listenableFuture.isDone();
                wrapper.mInnerFuture.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = wrapper.mWorker;
            if (listenableWorker != null && !z) {
                listenableWorker.stop();
            } else {
                Logger.get().debug(WorkerWrapper.TAG, String.format("WorkSpec %s is already done. Not interrupting.", wrapper.mWorkSpec), new Throwable[0]);
            }
            Logger.get().debug(TAG, String.format("WorkerWrapper interrupted for %s", id), new Throwable[0]);
            return true;
        }
        Logger.get().debug(TAG, String.format("WorkerWrapper could not be found for %s", id), new Throwable[0]);
        return false;
    }

    public final void addExecutionListener(ExecutionListener executionListener) {
        synchronized (this.mLock) {
            this.mOuterListeners.add(executionListener);
        }
    }

    public final boolean isEnqueued(String workSpecId) {
        boolean z;
        synchronized (this.mLock) {
            if (!this.mEnqueuedWorkMap.containsKey(workSpecId) && !this.mForegroundWorkMap.containsKey(workSpecId)) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(final String workSpecId, boolean needsReschedule) {
        synchronized (this.mLock) {
            this.mEnqueuedWorkMap.remove(workSpecId);
            Logger.get().debug(TAG, String.format("%s %s executed; reschedule = %s", "Processor", workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
            Iterator it = this.mOuterListeners.iterator();
            while (it.hasNext()) {
                ((ExecutionListener) it.next()).onExecuted(workSpecId, needsReschedule);
            }
        }
    }

    public final void startForeground(String workSpecId, ForegroundInfo foregroundInfo) {
        synchronized (this.mLock) {
            Logger.get().info(TAG, String.format("Moving WorkSpec (%s) to the foreground", workSpecId), new Throwable[0]);
            WorkerWrapper workerWrapper = (WorkerWrapper) this.mEnqueuedWorkMap.remove(workSpecId);
            if (workerWrapper != null) {
                if (this.mForegroundLock == null) {
                    PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mAppContext, "ProcessorForegroundLck");
                    this.mForegroundLock = newWakeLock;
                    newWakeLock.acquire();
                }
                this.mForegroundWorkMap.put(workSpecId, workerWrapper);
                Intent createStartForegroundIntent = SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, workSpecId, foregroundInfo);
                Context context = this.mAppContext;
                Object obj = ContextCompat.sLock;
                if (Build.VERSION.SDK_INT >= 26) {
                    ContextCompat.Api26Impl.startForegroundService(context, createStartForegroundIntent);
                } else {
                    context.startService(createStartForegroundIntent);
                }
            }
        }
    }

    public final boolean startWork(String id, WorkerParameters.RuntimeExtras runtimeExtras) {
        synchronized (this.mLock) {
            if (isEnqueued(id)) {
                Logger.get().debug(TAG, String.format("Work %s is already enqueued for processing", id), new Throwable[0]);
                return false;
            }
            WorkerWrapper.Builder builder = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, id);
            builder.mSchedulers = this.mSchedulers;
            if (runtimeExtras != null) {
                builder.mRuntimeExtras = runtimeExtras;
            }
            WorkerWrapper workerWrapper = new WorkerWrapper(builder);
            SettableFuture<Boolean> settableFuture = workerWrapper.mFuture;
            settableFuture.addListener(new FutureListener(this, id, settableFuture), ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mMainThreadExecutor);
            this.mEnqueuedWorkMap.put(id, workerWrapper);
            ((WorkManagerTaskExecutor) this.mWorkTaskExecutor).mBackgroundExecutor.execute(workerWrapper);
            Logger.get().debug(TAG, String.format("%s: processing %s", "Processor", id), new Throwable[0]);
            return true;
        }
    }

    public final void stopForegroundService() {
        synchronized (this.mLock) {
            if (!(!this.mForegroundWorkMap.isEmpty())) {
                Context context = this.mAppContext;
                String str = SystemForegroundDispatcher.TAG;
                Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                try {
                    this.mAppContext.startService(intent);
                } catch (Throwable th) {
                    Logger.get().error(TAG, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.mForegroundLock;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.mForegroundLock = null;
                }
            }
        }
    }

    public final boolean stopForegroundWork(String id) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping foreground work %s", id), new Throwable[0]);
            interrupt = interrupt(id, (WorkerWrapper) this.mForegroundWorkMap.remove(id));
        }
        return interrupt;
    }

    public final boolean stopWork(String id) {
        boolean interrupt;
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Processor stopping background work %s", id), new Throwable[0]);
            interrupt = interrupt(id, (WorkerWrapper) this.mEnqueuedWorkMap.remove(id));
        }
        return interrupt;
    }
}
