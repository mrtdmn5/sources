package com.google.android.gms.measurement.internal;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkc extends zzf {
    public final zzkb zza;
    public final zzka zzb;
    public final zzjy zzc;
    public com.google.android.gms.internal.measurement.zzby zzd;

    public zzkc(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = new zzkb(this);
        this.zzb = new zzka(this);
        this.zzc = new zzjy(this);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final void zzm$2() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new com.google.android.gms.internal.measurement.zzby(Looper.getMainLooper());
        }
    }
}
