package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkm implements Callable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzkt zzb;

    public zzkm(zzkt zzktVar, zzq zzqVar) {
        this.zzb = zzktVar;
        this.zza = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        zzq zzqVar = this.zza;
        String str = zzqVar.zza;
        Preconditions.checkNotNull(str);
        zzkt zzktVar = this.zzb;
        zzai zzh = zzktVar.zzh(str);
        zzah zzahVar = zzah.ANALYTICS_STORAGE;
        if (zzh.zzi(zzahVar) && zzai.zzb(zzqVar.zzv).zzi(zzahVar)) {
            return zzktVar.zzd(zzqVar).zzu();
        }
        zzktVar.zzay().zzl.zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
