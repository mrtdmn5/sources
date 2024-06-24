package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zza implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public zza(zzd zzdVar, String str, long j) {
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
        boolean isEmpty = arrayMap.isEmpty();
        long j = this.zzb;
        if (isEmpty) {
            zzdVar.zzc = j;
        }
        Integer num = (Integer) arrayMap.getOrDefault(str, null);
        if (num != null) {
            arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
            return;
        }
        if (arrayMap.mSize >= 100) {
            zzeh zzehVar = zzdVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zza("Too many ads visible");
        } else {
            arrayMap.put(str, 1);
            zzdVar.zza.put(str, Long.valueOf(j));
        }
    }
}
