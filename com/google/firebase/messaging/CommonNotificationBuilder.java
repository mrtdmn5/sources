package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class CommonNotificationBuilder {
    public static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    @TargetApi(26)
    public static boolean isValidIcon(Resources resources, int r6) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!CommonNotificationBuilder$$ExternalSyntheticApiModelOutline2.m(resources.getDrawable(r6, null))) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + r6);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + r6 + ", treating it as an invalid icon");
            return false;
        }
    }
}
