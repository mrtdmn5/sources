package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgh implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgj zzb;

    public zzgh(zzgj zzgjVar, zzq zzqVar) {
        this.zzb = zzgjVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzb;
        zzgjVar.zza.zzA$1();
        zzgjVar.zza.zzL(this.zza);
    }
}
