package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzu {
    public final /* synthetic */ zzaa zza;
    public final String zzb;
    public final boolean zzc;
    public final com.google.android.gms.internal.measurement.zzgi zzd;
    public final BitSet zze;
    public final BitSet zzf;
    public final Map zzg;
    public final ArrayMap zzh;

    public /* synthetic */ zzu(zzaa zzaaVar, String str) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    public final zzfp zza(int r10) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzfo zzb$1 = zzfp.zzb$1();
        zzb$1.zzaG();
        zzfp.zzf((zzfp) zzb$1.zza, r10);
        zzb$1.zzaG();
        zzfp.zzi((zzfp) zzb$1.zza, this.zzc);
        com.google.android.gms.internal.measurement.zzgi zzgiVar = this.zzd;
        if (zzgiVar != null) {
            zzb$1.zzaG();
            zzfp.zzh((zzfp) zzb$1.zza, zzgiVar);
        }
        com.google.android.gms.internal.measurement.zzgh zzf = com.google.android.gms.internal.measurement.zzgi.zzf();
        ArrayList zzr = zzkv.zzr(this.zze);
        zzf.zzaG();
        com.google.android.gms.internal.measurement.zzgi.zzq((com.google.android.gms.internal.measurement.zzgi) zzf.zza, zzr);
        ArrayList zzr2 = zzkv.zzr(this.zzf);
        zzf.zzaG();
        com.google.android.gms.internal.measurement.zzgi.zzo((com.google.android.gms.internal.measurement.zzgi) zzf.zza, zzr2);
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(map.size());
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                Long l = (Long) map.get(Integer.valueOf(intValue));
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzfq zzc = com.google.android.gms.internal.measurement.zzfr.zzc();
                    zzc.zzaG();
                    com.google.android.gms.internal.measurement.zzfr.zze((com.google.android.gms.internal.measurement.zzfr) zzc.zza, intValue);
                    long longValue = l.longValue();
                    zzc.zzaG();
                    com.google.android.gms.internal.measurement.zzfr.zzf((com.google.android.gms.internal.measurement.zzfr) zzc.zza, longValue);
                    arrayList.add((com.google.android.gms.internal.measurement.zzfr) zzc.zzaC());
                }
            }
        }
        if (arrayList != null) {
            zzf.zzaG();
            com.google.android.gms.internal.measurement.zzgi.zzs((com.google.android.gms.internal.measurement.zzgi) zzf.zza, arrayList);
        }
        ArrayMap arrayMap = this.zzh;
        if (arrayMap == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap.mSize);
            Iterator it2 = ((MapCollections.KeySet) arrayMap.keySet()).iterator();
            while (it2.hasNext()) {
                Integer num = (Integer) it2.next();
                com.google.android.gms.internal.measurement.zzgj zzd = com.google.android.gms.internal.measurement.zzgk.zzd();
                int intValue2 = num.intValue();
                zzd.zzaG();
                com.google.android.gms.internal.measurement.zzgk.zzg((com.google.android.gms.internal.measurement.zzgk) zzd.zza, intValue2);
                List list2 = (List) arrayMap.getOrDefault(num, null);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zzaG();
                    com.google.android.gms.internal.measurement.zzgk.zzh((com.google.android.gms.internal.measurement.zzgk) zzd.zza, list2);
                }
                arrayList2.add((com.google.android.gms.internal.measurement.zzgk) zzd.zzaC());
            }
            list = arrayList2;
        }
        zzf.zzaG();
        com.google.android.gms.internal.measurement.zzgi.zzv((com.google.android.gms.internal.measurement.zzgi) zzf.zza, list);
        zzb$1.zzaG();
        zzfp.zzg((zzfp) zzb$1.zza, (com.google.android.gms.internal.measurement.zzgi) zzf.zzaC());
        return (zzfp) zzb$1.zzaC();
    }

    public final void zzc(zzy zzyVar) {
        int zza = zzyVar.zza();
        Boolean bool = zzyVar.zzd;
        if (bool != null) {
            this.zzf.set(zza, bool.booleanValue());
        }
        Boolean bool2 = zzyVar.zze;
        if (bool2 != null) {
            this.zze.set(zza, bool2.booleanValue());
        }
        if (zzyVar.zzf != null) {
            Integer valueOf = Integer.valueOf(zza);
            Map map = this.zzg;
            Long l = (Long) map.get(valueOf);
            long longValue = zzyVar.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                map.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzyVar.zzg != null) {
            Integer valueOf2 = Integer.valueOf(zza);
            ArrayMap arrayMap = this.zzh;
            List list = (List) arrayMap.getOrDefault(valueOf2, null);
            if (list == null) {
                list = new ArrayList();
                arrayMap.put(valueOf2, list);
            }
            if (zzyVar.zzc()) {
                list.clear();
            }
            zznz.zzc();
            zzaa zzaaVar = this.zza;
            zzag zzagVar = zzaaVar.zzt.zzk;
            zzdt zzdtVar = zzdu.zzW;
            String str = this.zzb;
            if (zzagVar.zzs(str, zzdtVar) && zzyVar.zzb()) {
                list.clear();
            }
            zznz.zzc();
            if (zzaaVar.zzt.zzk.zzs(str, zzdtVar)) {
                Long valueOf3 = Long.valueOf(zzyVar.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzyVar.zzg.longValue() / 1000));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        this.zza = zzaaVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = arrayMap;
        this.zzh = new ArrayMap();
        Iterator it = ((MapCollections.KeySet) arrayMap2.keySet()).iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.getOrDefault(num, null));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgiVar;
    }
}
