package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class WakeLockHolder {
    public static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    public static final Object syncObject = new Object();
    public static WakeLock wakeLock;

    public static void completeWakefulIntent(Intent intent) {
        synchronized (syncObject) {
            if (wakeLock != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
                wakeLock.release();
            }
        }
    }

    public static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (syncObject) {
            if (wakeLock == null) {
                WakeLock wakeLock2 = new WakeLock(context);
                wakeLock = wakeLock2;
                synchronized (wakeLock2.zzf) {
                    wakeLock2.zzl = true;
                }
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
            }
            return startService;
        }
    }
}
