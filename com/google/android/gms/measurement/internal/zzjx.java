package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjx implements Runnable {
    public final long zza;
    public final long zzb;
    public final /* synthetic */ zzjy zzc;

    public zzjx(zzjy zzjyVar, long j, long j2) {
        this.zzc = zzjyVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar = this.zzc.zza.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjw
            @Override // java.lang.Runnable
            public final void run() {
                zzjx zzjxVar = zzjx.this;
                zzjy zzjyVar = zzjxVar.zzc;
                long j = zzjxVar.zza;
                zzjyVar.zza.zzg();
                zzkc zzkcVar = zzjyVar.zza;
                zzeh zzehVar = zzkcVar.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzk.zza("Application going to the background");
                zzfr zzfrVar = zzkcVar.zzt;
                zzew zzewVar = zzfrVar.zzl;
                zzfr.zzP(zzewVar);
                zzewVar.zzm.zza(true);
                Bundle bundle = new Bundle();
                if (!zzfrVar.zzk.zzu()) {
                    zzka zzkaVar = zzkcVar.zzb;
                    zzkaVar.zzd.zzb();
                    zzkaVar.zzd(false, false, zzjxVar.zzb);
                }
                zzhx zzhxVar = zzfrVar.zzt;
                zzfr.zzQ(zzhxVar);
                zzhxVar.zzH(j, bundle, "auto", "_ab");
            }
        });
    }
}
