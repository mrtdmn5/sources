package com.animaconnected.secondo.behaviour.distress.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.secondo.behaviour.distress.api.DistressApi;
import com.animaconnected.secondo.behaviour.distress.service.DistressService;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PendingTimeout.kt */
/* loaded from: classes3.dex */
public final class PendingTimeout {
    private static final String KEY_PENDING_NOTIFICTION_TIMEOUT = "pending-notification";
    private static final String KEY_PENDING_TIMEOUT = "pending";
    private static final long PENDING_NOTIFICATION_TIMEOUT = 300000;
    private static final long PENDING_TIMEOUT = 900000;
    private static final String SP_NAME = "distress-pending-timeout";
    private static Runnable sNotificationTimeout;
    private static long sPendingNotificationTimeoutTime;
    private static Runnable sPendingTimeout;
    private static long sPendingTimeoutTime;
    public static final PendingTimeout INSTANCE = new PendingTimeout();
    private static final String TAG = "PendingTimeout";
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    public static final int $stable = 8;

    private PendingTimeout() {
    }

    public static final void cancelPending() {
        Runnable runnable = sPendingTimeout;
        if (runnable != null) {
            sHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = sNotificationTimeout;
        if (runnable2 != null) {
            sHandler.removeCallbacks(runnable2);
        }
    }

    private final void maybeCreateNotificationTimeoutRunnable(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (sNotificationTimeout == null) {
            sNotificationTimeout = new Runnable() { // from class: com.animaconnected.secondo.behaviour.distress.notifications.PendingTimeout$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PendingTimeout.maybeCreateNotificationTimeoutRunnable$lambda$5(applicationContext);
                }
            };
        }
        Runnable runnable = sNotificationTimeout;
        if (runnable != null) {
            Handler handler = sHandler;
            handler.removeCallbacks(runnable);
            handler.postAtTime(runnable, sPendingNotificationTimeoutTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeCreateNotificationTimeoutRunnable$lambda$5(final Context context) {
        DistressApi.Companion companion = DistressApi.Companion;
        Intrinsics.checkNotNull(context);
        companion.getInstance(context).homeFuture().always(new AlwaysCallback() { // from class: com.animaconnected.secondo.behaviour.distress.notifications.PendingTimeout$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                PendingTimeout.maybeCreateNotificationTimeoutRunnable$lambda$5$lambda$4(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeCreateNotificationTimeoutRunnable$lambda$5$lambda$4(Context context) {
        DistressService.Companion companion = DistressService.Companion;
        Intrinsics.checkNotNull(context);
        companion.stop(context);
    }

    private final void maybeCreatePendingTimeoutRunnable(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (sPendingTimeout == null) {
            sPendingTimeout = new Runnable() { // from class: com.animaconnected.secondo.behaviour.distress.notifications.PendingTimeout$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PendingTimeout.maybeCreatePendingTimeoutRunnable$lambda$2(applicationContext);
                }
            };
        }
        Runnable runnable = sPendingTimeout;
        if (runnable != null) {
            Handler handler = sHandler;
            handler.removeCallbacks(runnable);
            handler.postAtTime(runnable, sPendingTimeoutTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maybeCreatePendingTimeoutRunnable$lambda$2(Context context) {
        StateNotificationHandler.pushNotification(context, context.getString(R.string.distress_ntf_pending_title), context.getString(R.string.distress_ntf_pending_timeout_message));
        INSTANCE.maybeCreateNotificationTimeoutRunnable(context);
    }

    private final void startFreshNotifications(Context context, SharedPreferences sharedPreferences) {
        Log.d(TAG, "startFreshNotifications: ");
        long uptimeMillis = SystemClock.uptimeMillis() + PENDING_TIMEOUT;
        sPendingTimeoutTime = uptimeMillis;
        sPendingNotificationTimeoutTime = uptimeMillis + PENDING_NOTIFICATION_TIMEOUT;
        sharedPreferences.edit().putLong(KEY_PENDING_TIMEOUT, System.currentTimeMillis() + PENDING_TIMEOUT).putLong(KEY_PENDING_NOTIFICTION_TIMEOUT, System.currentTimeMillis() + PENDING_TIMEOUT + PENDING_NOTIFICATION_TIMEOUT).apply();
        maybeCreatePendingTimeoutRunnable(context);
    }

    private final boolean startInterruptedNotifications(Context context) {
        if (sPendingTimeoutTime > SystemClock.uptimeMillis()) {
            Log.d(TAG, "startInterruptedNotifications: pending timeout");
            maybeCreatePendingTimeoutRunnable(context);
            return true;
        }
        if (sPendingNotificationTimeoutTime > SystemClock.uptimeMillis()) {
            Log.d(TAG, "startInterruptedNotifications: pending notification timeout");
            maybeCreateNotificationTimeoutRunnable(context);
            return true;
        }
        return false;
    }

    public static final void startPendingTimeout(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME, 0);
        sPendingTimeoutTime = SystemClock.uptimeMillis() + (sharedPreferences.getLong(KEY_PENDING_TIMEOUT, 0L) - System.currentTimeMillis());
        sPendingNotificationTimeoutTime = SystemClock.uptimeMillis() + (sharedPreferences.getLong(KEY_PENDING_NOTIFICTION_TIMEOUT, 0L) - System.currentTimeMillis());
        PendingTimeout pendingTimeout = INSTANCE;
        if (!pendingTimeout.startInterruptedNotifications(context)) {
            pendingTimeout.startFreshNotifications(context, sharedPreferences);
        }
    }
}
