package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgg implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzgj zzb;

    public zzgg(zzgj zzgjVar, String str) {
        this.zzb = zzgjVar;
        this.zza = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        zzgj zzgjVar = this.zzb;
        zzgjVar.zza.zzA$1();
        zzam zzamVar = zzgjVar.zza.zze;
        zzkt.zzal(zzamVar);
        return zzamVar.zzu(this.zza);
    }
}
