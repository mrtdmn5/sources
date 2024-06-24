package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzb implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public zzb(zzd zzdVar, String str, long j) {
        this.zzc = zzdVar;
        this.zza = str;
        this.zzb = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.zzc;
        zzdVar.zzg();
        String str = this.zza;
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = zzdVar.zzb;
        Integer num = (Integer) arrayMap.getOrDefault(str, null);
        zzfr zzfrVar = zzdVar.zzt;
        if (num != null) {
            zzim zzimVar = zzfrVar.zzs;
            zzfr.zzQ(zzimVar);
            zzie zzj = zzimVar.zzj(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                arrayMap.remove(str);
                ArrayMap arrayMap2 = zzdVar.zza;
                Long l = (Long) arrayMap2.getOrDefault(str, null);
                long j = this.zzb;
                zzeh zzehVar = zzfrVar.zzm;
                if (l == null) {
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza("First ad unit exposure time was never set");
                } else {
                    long longValue = l.longValue();
                    arrayMap2.remove(str);
                    zzdVar.zzi(str, j - longValue, zzj);
                }
                if (arrayMap.isEmpty()) {
                    long j2 = zzdVar.zzc;
                    if (j2 == 0) {
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zza("First ad exposure time was never set");
                        return;
                    } else {
                        zzdVar.zzh(j - j2, zzj);
                        zzdVar.zzc = 0L;
                        return;
                    }
                }
                return;
            }
            arrayMap.put(str, Integer.valueOf(intValue));
            return;
        }
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar2);
        zzehVar2.zzd.zzb(str, "Call to endAdUnitExposure for unknown ad unit id");
    }
}
