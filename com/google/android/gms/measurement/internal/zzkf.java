package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import com.animaconnected.watch.device.Command;
import com.google.android.gms.internal.measurement.zzbs;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkf extends zzkh {
    public final AlarmManager zza;
    public zzke zzb;
    public Integer zzc;

    public zzkf(zzkt zzktVar) {
        super(zzktVar);
        this.zza = (AlarmManager) this.zzt.zze.getSystemService(Command.ALARM);
    }

    public final void zza() {
        zzW();
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Unscheduling upload");
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        zzi().zzb();
        JobScheduler jobScheduler = (JobScheduler) zzfrVar.zze.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzf());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
        AlarmManager alarmManager = this.zza;
        if (alarmManager != null) {
            alarmManager.cancel(zzh());
        }
        JobScheduler jobScheduler = (JobScheduler) this.zzt.zze.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(zzf());
        }
    }

    public final int zzf() {
        if (this.zzc == null) {
            this.zzc = Integer.valueOf("measurement".concat(String.valueOf(this.zzt.zze.getPackageName())).hashCode());
        }
        return this.zzc.intValue();
    }

    public final PendingIntent zzh() {
        Context context = this.zzt.zze;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    public final zzap zzi() {
        if (this.zzb == null) {
            this.zzb = new zzke(this, this.zzf.zzn);
        }
        return this.zzb;
    }
}
