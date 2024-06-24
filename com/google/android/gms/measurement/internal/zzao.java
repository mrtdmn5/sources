package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzao implements Runnable {
    public final /* synthetic */ zzgm zza;
    public final /* synthetic */ zzap zzb;

    public zzao(zzap zzapVar, zzgm zzgmVar) {
        this.zzb = zzapVar;
        this.zza = zzgmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        if (this.zzb.zzd != 0) {
            z = true;
        } else {
            z = false;
        }
        this.zzb.zzd = 0L;
        if (z) {
            this.zzb.zzc();
        }
    }
}
