package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class TopicsSyncTask implements Runnable {
    public static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    public static Boolean hasAccessNetworkStatePermission;
    public static Boolean hasWakeLockPermission;
    public final Context context;
    public final Metadata metadata;
    public final long nextDelaySeconds;
    public final PowerManager.WakeLock syncWakeLock;
    public final TopicsSubscriber topicsSubscriber;

    /* loaded from: classes3.dex */
    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        public TopicsSyncTask task;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.task = topicsSyncTask;
        }

        @Override // android.content.BroadcastReceiver
        public final synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.task;
            if (topicsSyncTask == null) {
                return;
            }
            if (!topicsSyncTask.isDeviceConnected()) {
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            TopicsSyncTask topicsSyncTask2 = this.task;
            topicsSyncTask2.topicsSubscriber.syncExecutor.schedule(topicsSyncTask2, 0L, TimeUnit.SECONDS);
            context.unregisterReceiver(this);
            this.task = null;
        }

        public final void registerReceiver() {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j) {
        this.topicsSubscriber = topicsSubscriber;
        this.context = context;
        this.nextDelaySeconds = j;
        this.metadata = metadata;
        this.syncWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    public static boolean hasAccessNetworkStatePermission(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasAccessNetworkStatePermission;
            if (bool == null) {
                booleanValue = hasPermission(context, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            hasAccessNetworkStatePermission = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    public static boolean hasPermission(Context context, String str, Boolean bool) {
        boolean z;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context.checkCallingOrSelfPermission(str) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return z;
    }

    public static boolean hasWakeLockPermission(Context context) {
        boolean booleanValue;
        boolean booleanValue2;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasWakeLockPermission;
            if (bool == null) {
                booleanValue = hasPermission(context, "android.permission.WAKE_LOCK", bool);
            } else {
                booleanValue = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(booleanValue);
            hasWakeLockPermission = valueOf;
            booleanValue2 = valueOf.booleanValue();
        }
        return booleanValue2;
    }

    public final synchronized boolean isDeviceConnected() {
        NetworkInfo networkInfo;
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null) {
            if (networkInfo.isConnected()) {
                z = true;
            }
        }
        z = false;
        return z;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        TopicsSubscriber topicsSubscriber = this.topicsSubscriber;
        Context context = this.context;
        boolean hasWakeLockPermission2 = hasWakeLockPermission(context);
        PowerManager.WakeLock wakeLock = this.syncWakeLock;
        if (hasWakeLockPermission2) {
            wakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            try {
                synchronized (topicsSubscriber) {
                    topicsSubscriber.syncScheduledOrRunning = true;
                }
            } catch (IOException e) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e.getMessage());
                synchronized (topicsSubscriber) {
                    topicsSubscriber.syncScheduledOrRunning = false;
                    if (!hasWakeLockPermission(context)) {
                        return;
                    }
                }
            }
            if (!this.metadata.isGmscorePresent()) {
                synchronized (topicsSubscriber) {
                    topicsSubscriber.syncScheduledOrRunning = false;
                }
                if (hasWakeLockPermission(context)) {
                    try {
                        wakeLock.release();
                        return;
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (hasAccessNetworkStatePermission(context) && !isDeviceConnected()) {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (hasWakeLockPermission(context)) {
                    try {
                        wakeLock.release();
                        return;
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        return;
                    }
                }
                return;
            }
            if (topicsSubscriber.syncTopics()) {
                synchronized (topicsSubscriber) {
                    topicsSubscriber.syncScheduledOrRunning = false;
                }
            } else {
                topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
            }
            if (!hasWakeLockPermission(context)) {
                return;
            }
            try {
                wakeLock.release();
            } catch (RuntimeException unused3) {
                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
            }
        } catch (Throwable th) {
            if (hasWakeLockPermission(context)) {
                try {
                    wakeLock.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
