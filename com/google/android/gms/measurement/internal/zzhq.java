package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhq implements Runnable {
    public final /* synthetic */ Boolean zza;
    public final /* synthetic */ zzhx zzb;

    public zzhq(zzhx zzhxVar, Boolean bool) {
        this.zzb = zzhxVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}
