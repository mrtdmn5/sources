package com.google.android.gms.measurement.internal;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjz extends zzap {
    public final /* synthetic */ zzka zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjz(zzka zzkaVar, zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = zzkaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzka zzkaVar = this.zza;
        zzkaVar.zzc.zzg();
        zzkc zzkcVar = zzkaVar.zzc;
        zzkcVar.zzt.zzr.getClass();
        zzkaVar.zzd(false, false, SystemClock.elapsedRealtime());
        zzfr zzfrVar = zzkcVar.zzt;
        zzd zzd = zzfrVar.zzd();
        zzfrVar.zzr.getClass();
        zzd.zzf(SystemClock.elapsedRealtime());
    }
}
