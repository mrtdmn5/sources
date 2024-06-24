package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzge implements Callable {
    public final /* synthetic */ zzgj zzc;

    public zzge(zzgj zzgjVar, zzaw zzawVar, String str) {
        this.zzc = zzgjVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        zzgj zzgjVar = this.zzc;
        zzgjVar.zza.zzA$1();
        zzic zzicVar = zzgjVar.zza.zzj;
        zzkt.zzal(zzicVar);
        zzicVar.zzg();
        throw new IllegalStateException("Unexpected call on client side");
    }
}
