package com.google.android.gms.measurement.internal;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjr implements Runnable {
    public final /* synthetic */ zzkt zza;
    public final /* synthetic */ Runnable zzb;

    public zzjr(zzkt zzktVar, Runnable runnable) {
        this.zza = zzktVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkt zzktVar = this.zza;
        zzktVar.zzA$1();
        zzktVar.zzaz().zzg();
        if (zzktVar.zzq == null) {
            zzktVar.zzq = new ArrayList();
        }
        zzktVar.zzq.add(this.zzb);
        zzktVar.zzX();
    }
}
