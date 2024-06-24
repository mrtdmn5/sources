package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgi implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;
    public final /* synthetic */ zzgj zze;

    public zzgi(zzgj zzgjVar, String str, String str2, String str3, long j) {
        this.zze = zzgjVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.zzb;
        zzgj zzgjVar = this.zze;
        String str2 = this.zza;
        if (str2 == null) {
            zzkt zzktVar = zzgjVar.zza;
            zzktVar.zzaz().zzg();
            String str3 = zzktVar.zzE;
            if (str3 == null || str3.equals(str)) {
                zzktVar.zzE = str;
                zzktVar.zzD = null;
                return;
            }
            return;
        }
        zzie zzieVar = new zzie(this.zzc, str2, this.zzd);
        zzkt zzktVar2 = zzgjVar.zza;
        zzktVar2.zzaz().zzg();
        String str4 = zzktVar2.zzE;
        if (str4 != null) {
            str4.equals(str);
        }
        zzktVar2.zzE = str;
        zzktVar2.zzD = zzieVar;
    }
}
