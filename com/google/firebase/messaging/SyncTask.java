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
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class SyncTask implements Runnable {
    public final FirebaseMessaging firebaseMessaging;
    public final long nextDelaySeconds;
    public final PowerManager.WakeLock syncWakeLock;

    /* loaded from: classes3.dex */
    public static class ConnectivityChangeReceiver extends BroadcastReceiver {
        public SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask == null || !syncTask.isDeviceConnected()) {
                return;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
            }
            SyncTask syncTask2 = this.task;
            syncTask2.firebaseMessaging.getClass();
            FirebaseMessaging.enqueueTaskWithDelaySeconds(syncTask2, 0L);
            this.task.firebaseMessaging.context.unregisterReceiver(this);
            this.task = null;
        }

        public final void registerReceiver() {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.task.firebaseMessaging.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public SyncTask(FirebaseMessaging firebaseMessaging, long j) {
        new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
        this.firebaseMessaging = firebaseMessaging;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) firebaseMessaging.context.getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    public final boolean isDeviceConnected() {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.firebaseMessaging.context.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public final boolean maybeRefreshToken() throws IOException {
        boolean z = true;
        try {
            if (this.firebaseMessaging.blockingGetToken() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Token successfully retrieved");
            }
            return true;
        } catch (IOException e) {
            String message = e.getMessage();
            if (!"SERVICE_NOT_AVAILABLE".equals(message) && !"INTERNAL_SERVER_ERROR".equals(message) && !"InternalServerError".equals(message)) {
                z = false;
            }
            if (z) {
                Log.w("FirebaseMessaging", "Token retrieval failed: " + e.getMessage() + ". Will retry token retrieval");
                return false;
            }
            if (e.getMessage() == null) {
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            throw e;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public final void run() {
        ServiceStarter serviceStarter = ServiceStarter.getInstance();
        FirebaseMessaging firebaseMessaging = this.firebaseMessaging;
        boolean hasWakeLockPermission = serviceStarter.hasWakeLockPermission(firebaseMessaging.context);
        PowerManager.WakeLock wakeLock = this.syncWakeLock;
        if (hasWakeLockPermission) {
            wakeLock.acquire();
        }
        try {
            try {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = true;
                }
            } catch (IOException e) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e.getMessage() + ". Won't retry the operation.");
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = false;
                    if (!ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                        return;
                    }
                }
            }
            if (!firebaseMessaging.metadata.isGmscorePresent()) {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = false;
                }
                if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                    wakeLock.release();
                    return;
                }
                return;
            }
            if (ServiceStarter.getInstance().hasAccessNetworkStatePermission(firebaseMessaging.context) && !isDeviceConnected()) {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                    wakeLock.release();
                    return;
                }
                return;
            }
            if (maybeRefreshToken()) {
                synchronized (firebaseMessaging) {
                    firebaseMessaging.syncScheduledOrRunning = false;
                }
            } else {
                firebaseMessaging.syncWithDelaySecondsInternal(this.nextDelaySeconds);
            }
        } finally {
            if (ServiceStarter.getInstance().hasWakeLockPermission(firebaseMessaging.context)) {
                wakeLock.release();
            }
        }
    }
}
