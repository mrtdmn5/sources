package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfy implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzgj zzd;

    public zzfy(zzgj zzgjVar, String str, String str2, String str3) {
        this.zzd = zzgjVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        zzgj zzgjVar = this.zzd;
        zzgjVar.zza.zzA$1();
        zzam zzamVar = zzgjVar.zza.zze;
        zzkt.zzal(zzamVar);
        return zzamVar.zzs(this.zza, this.zzb, this.zzc);
    }
}
