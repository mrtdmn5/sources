package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkn implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ zzko zzd;

    public zzkn(zzko zzkoVar, String str, Bundle bundle) {
        this.zzd = zzkoVar;
        this.zza = str;
        this.zzc = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzko zzkoVar = this.zzd;
        zzlb zzv = zzkoVar.zza.zzv();
        Bundle bundle = this.zzc;
        zzkt zzktVar = zzkoVar.zza;
        ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
        zzaw zzz = zzv.zzz("_err", bundle, "auto", System.currentTimeMillis(), false);
        Preconditions.checkNotNull(zzz);
        zzktVar.zzF(zzz, this.zza);
    }
}
