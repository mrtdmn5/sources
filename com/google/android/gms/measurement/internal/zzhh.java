package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhh implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzhx zzd;

    public zzhh(zzhx zzhxVar, AtomicReference atomicReference, String str, String str2) {
        this.zzd = zzhxVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzt = this.zzd.zzt.zzt();
        AtomicReference atomicReference = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjd(zzt, atomicReference, str, str2, zzt.zzO(false)));
    }
}
