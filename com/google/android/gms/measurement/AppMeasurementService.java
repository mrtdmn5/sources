package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzkt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements zzjs {
    public zzjt zza;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        zzjt zzd = zzd();
        if (intent == null) {
            zzd.zzk().zzd.zza("onBind called with null intent");
        } else {
            zzd.getClass();
            String action = intent.getAction();
            if ("com.google.android.gms.measurement.START".equals(action)) {
                return new zzgj(zzkt.zzt(zzd.zza));
            }
            zzd.zzk().zzg.zzb(action, "onBind received unknown action");
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzeh zzehVar = zzfr.zzp(zzd().zza, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzeh zzehVar = zzfr.zzp(zzd().zza, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        zzd().zzg(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(final Intent intent, int r7, final int r8) {
        final zzjt zzd = zzd();
        final zzeh zzehVar = zzfr.zzp(zzd.zza, null, null).zzm;
        zzfr.zzR(zzehVar);
        if (intent == null) {
            zzehVar.zzg.zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzehVar.zzl.zzc(Integer.valueOf(r8), action, "Local AppMeasurementService called. startId, action");
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjq
                @Override // java.lang.Runnable
                public final void run() {
                    zzjt zzjtVar = zzjt.this;
                    zzjs zzjsVar = (zzjs) zzjtVar.zza;
                    int r2 = r8;
                    if (zzjsVar.zzc(r2)) {
                        zzehVar.zzl.zzb(Integer.valueOf(r2), "Local AppMeasurementService processed last upload request. StartId");
                        zzjtVar.zzk().zzl.zza("Completed wakeful intent.");
                        zzjsVar.zza(intent);
                    }
                }
            };
            zzkt zzt = zzkt.zzt(zzd.zza);
            zzt.zzaz().zzp(new zzjr(zzt, runnable));
            return 2;
        }
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zza(Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = WakefulBroadcastReceiver.sActiveWakeLocks;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra != 0) {
            SparseArray<PowerManager.WakeLock> sparseArray2 = WakefulBroadcastReceiver.sActiveWakeLocks;
            synchronized (sparseArray2) {
                PowerManager.WakeLock wakeLock = sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                } else {
                    Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zzb(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final boolean zzc(int r1) {
        return stopSelfResult(r1);
    }

    public final zzjt zzd() {
        if (this.zza == null) {
            this.zza = new zzjt(this);
        }
        return this.zza;
    }
}
