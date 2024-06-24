package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class FcmLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public final Set<Intent> seenIntents = Collections.newSetFromMap(new WeakHashMap());

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void logNotificationOpen(android.content.Intent r5) {
        /*
            java.lang.String r0 = "FirebaseMessaging"
            android.os.Bundle r5 = r5.getExtras()     // Catch: java.lang.RuntimeException -> Lf
            if (r5 == 0) goto L15
            java.lang.String r1 = "gcm.n.analytics_data"
            android.os.Bundle r5 = r5.getBundle(r1)     // Catch: java.lang.RuntimeException -> Lf
            goto L16
        Lf:
            r5 = move-exception
            java.lang.String r1 = "Failed trying to get analytics data from Intent extras."
            android.util.Log.w(r0, r1, r5)
        L15:
            r5 = 0
        L16:
            java.lang.String r1 = "1"
            if (r5 != 0) goto L1c
            r2 = 0
            goto L26
        L1c:
            java.lang.String r2 = "google.c.a.e"
            java.lang.String r2 = r5.getString(r2)
            boolean r2 = r1.equals(r2)
        L26:
            if (r2 == 0) goto L90
            if (r5 != 0) goto L2b
            goto L8b
        L2b:
            java.lang.String r2 = "google.c.a.tc"
            java.lang.String r2 = r5.getString(r2)
            boolean r1 = r1.equals(r2)
            r2 = 3
            if (r1 == 0) goto L80
            com.google.firebase.FirebaseApp r1 = com.google.firebase.FirebaseApp.getInstance()
            java.lang.Class<com.google.firebase.analytics.connector.AnalyticsConnector> r3 = com.google.firebase.analytics.connector.AnalyticsConnector.class
            java.lang.Object r1 = r1.get(r3)
            com.google.firebase.analytics.connector.AnalyticsConnector r1 = (com.google.firebase.analytics.connector.AnalyticsConnector) r1
            boolean r2 = android.util.Log.isLoggable(r0, r2)
            if (r2 == 0) goto L4f
            java.lang.String r2 = "Received event with track-conversion=true. Setting user property and reengagement event"
            android.util.Log.d(r0, r2)
        L4f:
            if (r1 == 0) goto L7a
            java.lang.String r0 = "google.c.a.c_id"
            java.lang.String r0 = r5.getString(r0)
            r1.setUserProperty(r0)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "source"
            java.lang.String r4 = "Firebase"
            r2.putString(r3, r4)
            java.lang.String r3 = "medium"
            java.lang.String r4 = "notification"
            r2.putString(r3, r4)
            java.lang.String r3 = "campaign"
            r2.putString(r3, r0)
            java.lang.String r0 = "_cmp"
            java.lang.String r3 = "fcm"
            r1.logEvent(r3, r0, r2)
            goto L8b
        L7a:
            java.lang.String r1 = "Unable to set user property for conversion tracking:  analytics library is missing"
            android.util.Log.w(r0, r1)
            goto L8b
        L80:
            boolean r1 = android.util.Log.isLoggable(r0, r2)
            if (r1 == 0) goto L8b
            java.lang.String r1 = "Received event with track-conversion=false. Do not set user property"
            android.util.Log.d(r0, r1)
        L8b:
            java.lang.String r0 = "_no"
            com.google.firebase.messaging.MessagingAnalytics.logToScion(r5, r0)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.FcmLifecycleCallbacks.logNotificationOpen(android.content.Intent):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @SuppressLint({"ThreadPoolCreation"})
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        final Intent intent = activity.getIntent();
        if (intent != null && this.seenIntents.add(intent)) {
            if (Build.VERSION.SDK_INT <= 25) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.firebase.messaging.FcmLifecycleCallbacks$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FcmLifecycleCallbacks.this.getClass();
                        FcmLifecycleCallbacks.logNotificationOpen(intent);
                    }
                });
            } else {
                logNotificationOpen(intent);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity.isFinishing()) {
            this.seenIntents.remove(activity.getIntent());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
