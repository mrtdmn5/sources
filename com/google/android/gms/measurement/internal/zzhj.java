package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhj implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzhx zze;

    public zzhj(zzhx zzhxVar, AtomicReference atomicReference, String str, String str2, boolean z) {
        this.zze = zzhxVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zze.zzt.zzt();
        AtomicReference atomicReference = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        boolean z = this.zzd;
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjf(zzt, atomicReference, str, str2, zzt.zzO(false), z));
    }
}
