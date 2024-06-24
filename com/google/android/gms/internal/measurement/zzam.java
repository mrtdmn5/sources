package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.helpers.NormalizedParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public class zzam implements zzap, zzal {
    public final HashMap zza = new HashMap();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzam)) {
            return false;
        }
        return this.zza.equals(((zzam) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        HashMap hashMap = this.zza;
        if (!hashMap.isEmpty()) {
            for (String str : hashMap.keySet()) {
                sb.append(String.format("%s: %s,", str, hashMap.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        if ("toString".equals(str)) {
            return new zzat(toString());
        }
        return NormalizedParameters.zza(this, new zzat(str), zzgVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        zzam zzamVar = new zzam();
        for (Map.Entry entry : this.zza.entrySet()) {
            boolean z = entry.getValue() instanceof zzal;
            HashMap hashMap = zzamVar.zza;
            if (z) {
                hashMap.put((String) entry.getKey(), (zzap) entry.getValue());
            } else {
                hashMap.put((String) entry.getKey(), ((zzap) entry.getValue()).zzd());
            }
        }
        return zzamVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzap zzf(String str) {
        HashMap hashMap = this.zza;
        if (hashMap.containsKey(str)) {
            return (zzap) hashMap.get(str);
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return "[object Object]";
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzak(this.zza.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final void zzr(String str, zzap zzapVar) {
        HashMap hashMap = this.zza;
        if (zzapVar == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, zzapVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final boolean zzt(String str) {
        return this.zza.containsKey(str);
    }
}
