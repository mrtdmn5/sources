package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzkt;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
@TargetApi(24)
/* loaded from: classes3.dex */
public final class AppMeasurementJobService extends JobService implements zzjs {
    public zzjt zza;

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

    @Override // android.app.job.JobService
    public final boolean onStartJob(final JobParameters jobParameters) {
        final zzjt zzd = zzd();
        final zzeh zzehVar = zzfr.zzp(zzd.zza, null, null).zzm;
        zzfr.zzR(zzehVar);
        String string = jobParameters.getExtras().getString(AnalyticsConstants.KEY_ACTION);
        zzehVar.zzl.zzb(string, "Local AppMeasurementJobService called. action");
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjp
                @Override // java.lang.Runnable
                public final void run() {
                    zzjt zzjtVar = zzjt.this;
                    zzjtVar.getClass();
                    zzehVar.zzl.zza("AppMeasurementJobService processed last upload request.");
                    ((zzjs) zzjtVar.zza).zzb(jobParameters);
                }
            };
            zzkt zzt = zzkt.zzt(zzd.zza);
            zzt.zzaz().zzp(new zzjr(zzt, runnable));
            return true;
        }
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        zzd().zzj(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    @TargetApi(24)
    public final void zzb(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final boolean zzc(int r1) {
        throw new UnsupportedOperationException();
    }

    public final zzjt zzd() {
        if (this.zza == null) {
            this.zza = new zzjt(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zza(Intent intent) {
    }
}
