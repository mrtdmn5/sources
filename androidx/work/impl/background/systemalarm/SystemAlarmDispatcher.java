package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.SerialExecutor;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final class SystemAlarmDispatcher implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    public final CommandHandler mCommandHandler;
    public CommandsCompletedListener mCompletedListener;
    public final Context mContext;
    public Intent mCurrentIntent;
    public final ArrayList mIntents;
    public final Handler mMainHandler;
    public final Processor mProcessor;
    public final TaskExecutor mTaskExecutor;
    public final WorkManagerImpl mWorkManager;
    public final WorkTimer mWorkTimer;

    /* loaded from: classes.dex */
    public static class AddRunnable implements Runnable {
        public final SystemAlarmDispatcher mDispatcher;
        public final Intent mIntent;
        public final int mStartId;

        public AddRunnable(int dispatcher, Intent intent, SystemAlarmDispatcher startId) {
            this.mDispatcher = startId;
            this.mIntent = intent;
            this.mStartId = dispatcher;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    /* loaded from: classes.dex */
    public interface CommandsCompletedListener {
    }

    /* loaded from: classes.dex */
    public static class DequeueAndCheckForCompletion implements Runnable {
        public final SystemAlarmDispatcher mDispatcher;

        public DequeueAndCheckForCompletion(SystemAlarmDispatcher dispatcher) {
            this.mDispatcher = dispatcher;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.getClass();
            Logger logger = Logger.get();
            String str = SystemAlarmDispatcher.TAG;
            logger.debug(str, "Checking if commands are complete.", new Throwable[0]);
            systemAlarmDispatcher.assertMainThread();
            synchronized (systemAlarmDispatcher.mIntents) {
                boolean z2 = true;
                if (systemAlarmDispatcher.mCurrentIntent != null) {
                    Logger.get().debug(str, String.format("Removing command %s", systemAlarmDispatcher.mCurrentIntent), new Throwable[0]);
                    if (((Intent) systemAlarmDispatcher.mIntents.remove(0)).equals(systemAlarmDispatcher.mCurrentIntent)) {
                        systemAlarmDispatcher.mCurrentIntent = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                SerialExecutor serialExecutor = ((WorkManagerTaskExecutor) systemAlarmDispatcher.mTaskExecutor).mBackgroundExecutor;
                CommandHandler commandHandler = systemAlarmDispatcher.mCommandHandler;
                synchronized (commandHandler.mLock) {
                    if (!commandHandler.mPendingDelayMet.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z && systemAlarmDispatcher.mIntents.isEmpty()) {
                    synchronized (serialExecutor.mLock) {
                        if (serialExecutor.mTasks.isEmpty()) {
                            z2 = false;
                        }
                    }
                    if (!z2) {
                        Logger.get().debug(str, "No more commands & intents.", new Throwable[0]);
                        CommandsCompletedListener commandsCompletedListener = systemAlarmDispatcher.mCompletedListener;
                        if (commandsCompletedListener != null) {
                            ((SystemAlarmService) commandsCompletedListener).onAllCommandsCompleted();
                        }
                    }
                }
                if (!systemAlarmDispatcher.mIntents.isEmpty()) {
                    systemAlarmDispatcher.processCommand();
                }
            }
        }
    }

    public SystemAlarmDispatcher(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mCommandHandler = new CommandHandler(applicationContext);
        this.mWorkTimer = new WorkTimer();
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
        this.mWorkManager = workManagerImpl;
        Processor processor = workManagerImpl.mProcessor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManagerImpl.mWorkTaskExecutor;
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public final void add(final Intent intent, final int startId) {
        Logger logger = Logger.get();
        String str = TAG;
        boolean z = false;
        logger.debug(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(startId)), new Throwable[0]);
        assertMainThread();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring", new Throwable[0]);
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            assertMainThread();
            synchronized (this.mIntents) {
                Iterator it = this.mIntents.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return;
            }
        }
        intent.putExtra("KEY_START_ID", startId);
        synchronized (this.mIntents) {
            boolean z2 = !this.mIntents.isEmpty();
            this.mIntents.add(intent);
            if (!z2) {
                processCommand();
            }
        }
    }

    public final void assertMainThread() {
        if (this.mMainHandler.getLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        Processor processor = this.mProcessor;
        synchronized (processor.mLock) {
            processor.mOuterListeners.remove(this);
        }
        ScheduledExecutorService scheduledExecutorService = this.mWorkTimer.mExecutorService;
        if (!scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdownNow();
        }
        this.mCompletedListener = null;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        String str = CommandHandler.TAG;
        Intent intent = new Intent(this.mContext, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", needsReschedule);
        postOnMainThread(new AddRunnable(0, intent, this));
    }

    public final void postOnMainThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    public final void processCommand() {
        assertMainThread();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mContext, "ProcessCommand");
        try {
            newWakeLock.acquire();
            ((WorkManagerTaskExecutor) this.mWorkManager.mWorkTaskExecutor).executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.background.systemalarm.SystemAlarmDispatcher.1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemAlarmDispatcher systemAlarmDispatcher;
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    synchronized (SystemAlarmDispatcher.this.mIntents) {
                        SystemAlarmDispatcher systemAlarmDispatcher2 = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher2.mCurrentIntent = (Intent) systemAlarmDispatcher2.mIntents.get(0);
                    }
                    Intent intent = SystemAlarmDispatcher.this.mCurrentIntent;
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.mCurrentIntent.getIntExtra("KEY_START_ID", 0);
                        Logger logger = Logger.get();
                        String str = SystemAlarmDispatcher.TAG;
                        logger.debug(str, String.format("Processing command %s, %s", SystemAlarmDispatcher.this.mCurrentIntent, Integer.valueOf(intExtra)), new Throwable[0]);
                        PowerManager.WakeLock newWakeLock2 = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.mContext, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                        try {
                            Logger.get().debug(str, String.format("Acquiring operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                            newWakeLock2.acquire();
                            SystemAlarmDispatcher systemAlarmDispatcher3 = SystemAlarmDispatcher.this;
                            systemAlarmDispatcher3.mCommandHandler.onHandleIntent(intExtra, systemAlarmDispatcher3.mCurrentIntent, systemAlarmDispatcher3);
                            Logger.get().debug(str, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                            newWakeLock2.release();
                            systemAlarmDispatcher = SystemAlarmDispatcher.this;
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                        } catch (Throwable th) {
                            try {
                                Logger logger2 = Logger.get();
                                String str2 = SystemAlarmDispatcher.TAG;
                                logger2.error(str2, "Unexpected error in onHandleIntent", th);
                                Logger.get().debug(str2, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                                newWakeLock2.release();
                                systemAlarmDispatcher = SystemAlarmDispatcher.this;
                                dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(systemAlarmDispatcher);
                            } catch (Throwable th2) {
                                Logger.get().debug(SystemAlarmDispatcher.TAG, String.format("Releasing operation wake lock (%s) %s", action, newWakeLock2), new Throwable[0]);
                                newWakeLock2.release();
                                SystemAlarmDispatcher systemAlarmDispatcher4 = SystemAlarmDispatcher.this;
                                systemAlarmDispatcher4.postOnMainThread(new DequeueAndCheckForCompletion(systemAlarmDispatcher4));
                                throw th2;
                            }
                        }
                        systemAlarmDispatcher.postOnMainThread(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            newWakeLock.release();
        }
    }
}
