package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzt extends zzai {
    public final com.google.android.gms.measurement.internal.zzfg zza;

    public zzt(com.google.android.gms.measurement.internal.zzfg zzfgVar) {
        super("internal.logger");
        this.zza = zzfgVar;
        this.zze.put("log", new zzs(this, false, true));
        this.zze.put("silent", new zzp());
        ((zzai) this.zze.get("silent")).zzr("log", new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq());
        ((zzai) this.zze.get("unmonitored")).zzr("log", new zzs(this, false, false));
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzap zza(zzg zzgVar, List list) {
        return zzap.zzf;
    }
}
