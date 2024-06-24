package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzig implements Runnable {
    public final /* synthetic */ Bundle zza;
    public final /* synthetic */ zzie zzb;
    public final /* synthetic */ zzie zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzim zze;

    public zzig(zzim zzimVar, Bundle bundle, zzie zzieVar, zzie zzieVar2, long j) {
        this.zze = zzimVar;
        this.zza = bundle;
        this.zzb = zzieVar;
        this.zzc = zzieVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzie zzieVar = this.zzb;
        zzie zzieVar2 = this.zzc;
        long j = this.zzd;
        Bundle bundle = this.zza;
        bundle.remove("screen_name");
        bundle.remove("screen_class");
        zzim zzimVar = this.zze;
        zzlb zzlbVar = zzimVar.zzt.zzp;
        zzfr.zzP(zzlbVar);
        zzimVar.zzA(zzieVar, zzieVar2, j, true, zzlbVar.zzy("screen_view", bundle, null, false));
    }
}
