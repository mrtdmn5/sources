package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzaa extends zzkh {
    public String zza;
    public HashSet zzb;
    public ArrayMap zzc;
    public Long zzd;
    public Long zze;

    /* JADX WARN: Multi-variable type inference failed */
    public final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.getOrDefault(num, null);
        }
        zzu zzuVar = new zzu(this, this.zza);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
