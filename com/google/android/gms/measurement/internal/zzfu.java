package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfu implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ zzgj zzb;

    public zzfu(zzgj zzgjVar, zzac zzacVar) {
        this.zzb = zzgjVar;
        this.zza = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgj zzgjVar = this.zzb;
        zzgjVar.zza.zzA$1();
        zzac zzacVar = this.zza;
        Object zza = zzacVar.zzc.zza();
        zzkt zzktVar = zzgjVar.zza;
        if (zza == null) {
            zzktVar.getClass();
            String str = zzacVar.zza;
            Preconditions.checkNotNull(str);
            zzq zzac = zzktVar.zzac(str);
            if (zzac != null) {
                zzktVar.zzO(zzacVar, zzac);
                return;
            }
            return;
        }
        zzktVar.getClass();
        String str2 = zzacVar.zza;
        Preconditions.checkNotNull(str2);
        zzq zzac2 = zzktVar.zzac(str2);
        if (zzac2 != null) {
            zzktVar.zzU(zzacVar, zzac2);
        }
    }
}
