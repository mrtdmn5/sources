package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfr;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfa.zza {
    public zzfa zza;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzfa(this);
        }
        zzfa zzfaVar = this.zza;
        zzfaVar.getClass();
        zzeh zzehVar = zzfr.zzp(context, null, null).zzm;
        zzfr.zzR(zzehVar);
        if (intent == null) {
            zzehVar.zzg.zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzehVar.zzl.zzb(action, "Local receiver got");
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzehVar.zzl.zza("Starting wakeful intent.");
            ((AppMeasurementReceiver) zzfaVar.zza).getClass();
            SparseArray<PowerManager.WakeLock> sparseArray = WakefulBroadcastReceiver.sActiveWakeLocks;
            synchronized (sparseArray) {
                int r1 = WakefulBroadcastReceiver.mNextId;
                int r3 = r1 + 1;
                WakefulBroadcastReceiver.mNextId = r3;
                if (r3 <= 0) {
                    WakefulBroadcastReceiver.mNextId = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", r1);
                ComponentName startService = context.startService(className);
                if (startService != null) {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + startService.flattenToShortString());
                    newWakeLock.setReferenceCounted(false);
                    newWakeLock.acquire(60000L);
                    sparseArray.put(r1, newWakeLock);
                    return;
                }
                return;
            }
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzehVar.zzg.zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
