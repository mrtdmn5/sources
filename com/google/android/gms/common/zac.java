package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@SuppressLint({"HandlerLeak"})
/* loaded from: classes3.dex */
public final class zac extends zau {
    public final /* synthetic */ GoogleApiAvailability zaa;
    public final Context zab;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zac(com.google.android.gms.common.GoogleApiAvailability r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.zaa = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto Ld
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L11
        Ld:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L11:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.zab = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zac.<init>(com.google.android.gms.common.GoogleApiAvailability, android.content.Context):void");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        PendingIntent activity;
        int r6 = message.what;
        boolean z = true;
        if (r6 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + r6);
            return;
        }
        int r62 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        GoogleApiAvailability googleApiAvailability = this.zaa;
        Context context = this.zab;
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, r62);
        AtomicBoolean atomicBoolean = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
        if (isGooglePlayServicesAvailable != 1 && isGooglePlayServicesAvailable != 2 && isGooglePlayServicesAvailable != 3 && isGooglePlayServicesAvailable != 9) {
            z = false;
        }
        if (z) {
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(isGooglePlayServicesAvailable, context, "n");
            if (errorResolutionIntent == null) {
                activity = null;
            } else {
                activity = PendingIntent.getActivity(context, 0, errorResolutionIntent, 201326592);
            }
            googleApiAvailability.zae(context, isGooglePlayServicesAvailable, activity);
        }
    }
}
