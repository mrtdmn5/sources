package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzex implements Runnable {
    public final /* synthetic */ com.google.android.gms.internal.measurement.zzbr zza;
    public final /* synthetic */ zzey zzc;

    public zzex(zzey zzeyVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.zzc = zzeyVar;
        this.zza = zzbrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzey zzeyVar = this.zzc;
        zzez zzezVar = zzeyVar.zza;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.zza;
        zzfr zzfrVar = zzezVar.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", zzeyVar.zzb);
        try {
            if (zzbrVar.zzd(bundle) == null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zza("Install Referrer Service returned a null response");
            }
        } catch (Exception e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e.getMessage(), "Exception occurred while retrieving the Install Referrer");
        }
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
