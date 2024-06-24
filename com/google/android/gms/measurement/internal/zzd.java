package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzd extends zze {
    public final ArrayMap zza;
    public final ArrayMap zzb;
    public long zzc;

    public zzd(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    public final void zzd(long j, String str) {
        zzfr zzfrVar = this.zzt;
        if (str != null && str.length() != 0) {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zza(this, str, j));
        } else {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Ad unit id must be a non-empty string");
        }
    }

    public final void zze(long j, String str) {
        zzfr zzfrVar = this.zzt;
        if (str != null && str.length() != 0) {
            zzfo zzfoVar = zzfrVar.zzn;
            zzfr.zzR(zzfoVar);
            zzfoVar.zzp(new zzb(this, str, j));
        } else {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Ad unit id must be a non-empty string");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzf(long j) {
        zzim zzimVar = this.zzt.zzs;
        zzfr.zzQ(zzimVar);
        zzie zzj = zzimVar.zzj(false);
        ArrayMap arrayMap = this.zza;
        Iterator it = ((MapCollections.KeySet) arrayMap.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zzi(str, j - ((Long) arrayMap.getOrDefault(str, null)).longValue(), zzj);
        }
        if (!arrayMap.isEmpty()) {
            zzh(j - this.zzc, zzj);
        }
        zzj(j);
    }

    public final void zzh(long j, zzie zzieVar) {
        zzfr zzfrVar = this.zzt;
        if (zzieVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Not logging ad exposure. No active activity");
        } else {
            if (j < 1000) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzb(Long.valueOf(j), "Not logging ad exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            zzlb.zzK(zzieVar, bundle, true);
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("am", "_xa", bundle);
        }
    }

    public final void zzi(String str, long j, zzie zzieVar) {
        zzfr zzfrVar = this.zzt;
        if (zzieVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzl.zza("Not logging ad unit exposure. No active activity");
        } else {
            if (j < 1000) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzl.zzb(Long.valueOf(j), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            zzlb.zzK(zzieVar, bundle, true);
            zzhx zzhxVar = zzfrVar.zzt;
            zzfr.zzQ(zzhxVar);
            zzhxVar.zzG("am", "_xu", bundle);
        }
    }

    public final void zzj(long j) {
        ArrayMap arrayMap = this.zza;
        Iterator it = ((MapCollections.KeySet) arrayMap.keySet()).iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j));
        }
        if (!arrayMap.isEmpty()) {
            this.zzc = j;
        }
    }
}
