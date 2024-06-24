package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgd implements Runnable {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzgj zzc;

    public zzgd(zzgj zzgjVar, zzaw zzawVar, String str) {
        this.zzc = zzgjVar;
        this.zza = zzawVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzc;
        zzgjVar.zza.zzA$1();
        zzgjVar.zza.zzF(this.zza, this.zzb);
    }
}
