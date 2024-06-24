package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzff extends LruCache {
    public final /* synthetic */ zzfi zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzff(zzfi zzfiVar) {
        super(20);
        this.zza = zzfiVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.collection.LruCache
    public final Object create(Object obj) {
        LinkedHashMap linkedHashMap;
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        zzfi zzfiVar = this.zza;
        zzfiVar.zzW();
        Preconditions.checkNotEmpty(str);
        if (!zzfiVar.zzo(str)) {
            return null;
        }
        if (zzfiVar.zzh.containsKey(str) && zzfiVar.zzh.getOrDefault(str, null) != 0) {
            zzfiVar.zzD(str, (com.google.android.gms.internal.measurement.zzff) zzfiVar.zzh.getOrDefault(str, null));
        } else {
            zzfiVar.zzC(str);
        }
        zzff zzffVar = zzfiVar.zzd;
        synchronized (zzffVar) {
            linkedHashMap = new LinkedHashMap(zzffVar.map);
        }
        return (com.google.android.gms.internal.measurement.zzc) linkedHashMap.get(str);
    }
}
