package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzba implements Comparator {
    public final /* synthetic */ zzai zza;
    public final /* synthetic */ zzg zzb;

    public zzba(zzai zzaiVar, zzg zzgVar) {
        this.zza = zzaiVar;
        this.zzb = zzgVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzap zzapVar = (zzap) obj;
        zzap zzapVar2 = (zzap) obj2;
        if (zzapVar instanceof zzau) {
            if (!(zzapVar2 instanceof zzau)) {
                return 1;
            }
            return 0;
        }
        if (zzapVar2 instanceof zzau) {
            return -1;
        }
        zzai zzaiVar = this.zza;
        if (zzaiVar == null) {
            return zzapVar.zzi().compareTo(zzapVar2.zzi());
        }
        return (int) zzh.zza(zzaiVar.zza(this.zzb, Arrays.asList(zzapVar, zzapVar2)).zzh().doubleValue());
    }
}
