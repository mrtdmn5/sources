package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzk implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ AppMeasurementDynamiteService zze;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zze.zza.zzt();
        zzcf zzcfVar = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        boolean z = this.zzd;
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzin(zzt, str, str2, zzt.zzO(false), z, zzcfVar));
    }
}
