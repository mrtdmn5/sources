package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhc implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Object zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzhx zze;

    public zzhc(zzhx zzhxVar, String str, String str2, Object obj, long j) {
        this.zze = zzhxVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzhx zzhxVar = this.zze;
        String str = this.zza;
        String str2 = this.zzb;
        zzhxVar.zzY(this.zzd, this.zzc, str, str2);
    }
}
