package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.Processor;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.util.UUID;

/* loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    public static final String TAG = Logger.tagWithPrefix("SystemFgService");
    public SystemForegroundDispatcher mDispatcher;
    public Handler mHandler;
    public boolean mIsShutdown;
    public NotificationManager mNotificationManager;

    /* renamed from: androidx.work.impl.foreground.SystemForegroundService$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ Notification val$notification;
        public final /* synthetic */ int val$notificationId;
        public final /* synthetic */ int val$notificationType;

        public AnonymousClass1(final int val$notificationId, final Notification val$notification, final int val$notificationType) {
            this.val$notificationId = val$notificationId;
            this.val$notification = val$notification;
            this.val$notificationType = val$notificationType;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = Build.VERSION.SDK_INT;
            Notification notification = this.val$notification;
            int r3 = this.val$notificationId;
            SystemForegroundService systemForegroundService = SystemForegroundService.this;
            if (r0 >= 29) {
                systemForegroundService.startForeground(r3, notification, this.val$notificationType);
            } else {
                systemForegroundService.startForeground(r3, notification);
            }
        }
    }

    public final void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        if (systemForegroundDispatcher.mCallback != null) {
            Logger.get().error(SystemForegroundDispatcher.TAG, "A callback already exists.", new Throwable[0]);
        } else {
            systemForegroundDispatcher.mCallback = this;
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onCreate() {
        super.onCreate();
        initializeDispatcher();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
        systemForegroundDispatcher.mCallback = null;
        synchronized (systemForegroundDispatcher.mLock) {
            systemForegroundDispatcher.mConstraintsTracker.reset();
        }
        Processor processor = systemForegroundDispatcher.mWorkManagerImpl.mProcessor;
        synchronized (processor.mLock) {
            processor.mOuterListeners.remove(systemForegroundDispatcher);
        }
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public final int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        boolean z = this.mIsShutdown;
        String str = TAG;
        if (z) {
            Logger.get().info(str, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            SystemForegroundDispatcher systemForegroundDispatcher = this.mDispatcher;
            systemForegroundDispatcher.mCallback = null;
            synchronized (systemForegroundDispatcher.mLock) {
                systemForegroundDispatcher.mConstraintsTracker.reset();
            }
            Processor processor = systemForegroundDispatcher.mWorkManagerImpl.mProcessor;
            synchronized (processor.mLock) {
                processor.mOuterListeners.remove(systemForegroundDispatcher);
            }
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent != null) {
            final SystemForegroundDispatcher systemForegroundDispatcher2 = this.mDispatcher;
            systemForegroundDispatcher2.getClass();
            String action = intent.getAction();
            boolean equals = "ACTION_START_FOREGROUND".equals(action);
            String str2 = SystemForegroundDispatcher.TAG;
            final WorkManagerImpl workManagerImpl = systemForegroundDispatcher2.mWorkManagerImpl;
            if (equals) {
                Logger.get().info(str2, String.format("Started foreground service %s", intent), new Throwable[0]);
                final String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
                final WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
                ((WorkManagerTaskExecutor) systemForegroundDispatcher2.mTaskExecutor).executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundDispatcher.1
                    public final /* synthetic */ WorkDatabase val$database;
                    public final /* synthetic */ String val$workSpecId;

                    public AnonymousClass1(final WorkDatabase workDatabase2, final String stringExtra2) {
                        val$database = workDatabase2;
                        val$workSpecId = stringExtra2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WorkSpec workSpec = ((WorkSpecDao_Impl) val$database.workSpecDao()).getWorkSpec(val$workSpecId);
                        if (workSpec != null && workSpec.hasConstraints()) {
                            synchronized (SystemForegroundDispatcher.this.mLock) {
                                SystemForegroundDispatcher.this.mWorkSpecById.put(val$workSpecId, workSpec);
                                SystemForegroundDispatcher.this.mTrackedWorkSpecs.add(workSpec);
                                SystemForegroundDispatcher systemForegroundDispatcher3 = SystemForegroundDispatcher.this;
                                systemForegroundDispatcher3.mConstraintsTracker.replace(systemForegroundDispatcher3.mTrackedWorkSpecs);
                            }
                        }
                    }
                });
                systemForegroundDispatcher2.handleNotify(intent);
                return 3;
            }
            if ("ACTION_NOTIFY".equals(action)) {
                systemForegroundDispatcher2.handleNotify(intent);
                return 3;
            }
            if ("ACTION_CANCEL_WORK".equals(action)) {
                Logger.get().info(str2, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
                String stringExtra2 = intent.getStringExtra("KEY_WORKSPEC_ID");
                if (stringExtra2 != null && !TextUtils.isEmpty(stringExtra2)) {
                    final UUID fromString = UUID.fromString(stringExtra2);
                    workManagerImpl.getClass();
                    ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).executeOnBackgroundThread(new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
                        public final /* synthetic */ UUID val$id;

                        public AnonymousClass1(final UUID fromString2) {
                            val$id = fromString2;
                        }

                        @Override // androidx.work.impl.utils.CancelWorkRunnable
                        public final void runInternal() {
                            WorkManagerImpl workManagerImpl2 = WorkManagerImpl.this;
                            WorkDatabase workDatabase2 = workManagerImpl2.mWorkDatabase;
                            workDatabase2.beginTransaction();
                            try {
                                CancelWorkRunnable.cancel(workManagerImpl2, val$id.toString());
                                workDatabase2.setTransactionSuccessful();
                                workDatabase2.endTransaction();
                                Schedulers.schedule(workManagerImpl2.mConfiguration, workManagerImpl2.mWorkDatabase, workManagerImpl2.mSchedulers);
                            } catch (Throwable th) {
                                workDatabase2.endTransaction();
                                throw th;
                            }
                        }
                    });
                    return 3;
                }
                return 3;
            }
            if ("ACTION_STOP_FOREGROUND".equals(action)) {
                Logger.get().info(str2, "Stopping foreground service", new Throwable[0]);
                SystemForegroundDispatcher.Callback callback = systemForegroundDispatcher2.mCallback;
                if (callback != null) {
                    SystemForegroundService systemForegroundService = (SystemForegroundService) callback;
                    systemForegroundService.mIsShutdown = true;
                    Logger.get().debug(str, "All commands completed.", new Throwable[0]);
                    if (Build.VERSION.SDK_INT >= 26) {
                        systemForegroundService.stopForeground(true);
                    }
                    systemForegroundService.stopSelf();
                    return 3;
                }
                return 3;
            }
            return 3;
        }
        return 3;
    }
}
