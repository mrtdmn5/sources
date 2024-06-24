package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkj implements Runnable {
    public final /* synthetic */ zzkt zzb;

    public zzkj(zzkt zzktVar, zzku zzkuVar) {
        this.zzb = zzktVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkt zzktVar = this.zzb;
        zzktVar.zzaz().zzg();
        zzktVar.zzm = new zzez(zzktVar);
        zzam zzamVar = new zzam(zzktVar);
        zzamVar.zzX();
        zzktVar.zze = zzamVar;
        zzag zzg = zzktVar.zzg();
        zzfi zzfiVar = zzktVar.zzc;
        Preconditions.checkNotNull(zzfiVar);
        zzg.zzb = zzfiVar;
        zzjo zzjoVar = new zzjo(zzktVar);
        zzjoVar.zzX();
        zzktVar.zzk = zzjoVar;
        zzaa zzaaVar = new zzaa(zzktVar);
        zzaaVar.zzX();
        zzktVar.zzh = zzaaVar;
        zzic zzicVar = new zzic(zzktVar);
        zzicVar.zzX();
        zzktVar.zzj = zzicVar;
        zzkf zzkfVar = new zzkf(zzktVar);
        zzkfVar.zzX();
        zzktVar.zzg = zzkfVar;
        zzktVar.zzf = new zzep(zzktVar);
        if (zzktVar.zzr != zzktVar.zzs) {
            zzeh zzay = zzktVar.zzay();
            zzay.zzd.zzc(Integer.valueOf(zzktVar.zzr), Integer.valueOf(zzktVar.zzs), "Not all upload components initialized");
        }
        zzktVar.zzo = true;
        zzktVar.zzaz().zzg();
        zzam zzamVar2 = zzktVar.zze;
        zzkt.zzal(zzamVar2);
        zzamVar2.zzz();
        if (zzktVar.zzk.zzc.zza() == 0) {
            zzes zzesVar = zzktVar.zzk.zzc;
            ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
            zzesVar.zzb(System.currentTimeMillis());
        }
        zzktVar.zzag();
    }
}
