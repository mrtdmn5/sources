package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzke extends zzap {
    public final /* synthetic */ zzkf zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzke(zzkf zzkfVar, zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = zzkfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzkf zzkfVar = this.zza;
        zzkfVar.zza();
        zzeh zzehVar = zzkfVar.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Starting upload from DelayedRunnable");
        zzkfVar.zzf.zzX();
    }
}
