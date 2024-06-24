package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzm implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzm(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcfVar, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zzd.zza.zzt();
        zzcf zzcfVar = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzje(zzt, str, str2, zzt.zzO(false), zzcfVar));
    }
}
