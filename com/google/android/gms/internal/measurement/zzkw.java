package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkw extends zzla {
    public static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(long j, Object obj) {
        Object unmodifiableList;
        List list = (List) zzmy.zzf(j, obj);
        if (list instanceof zzku) {
            unmodifiableList = ((zzku) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzlt) && (list instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list;
                if (zzkmVar.zzc()) {
                    zzkmVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzmy.zzs(j, obj, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(long j, Object obj, Object obj2) {
        zzkt zzktVar;
        List list = (List) zzmy.zzf(j, obj2);
        int size = list.size();
        List list2 = (List) zzmy.zzf(j, obj);
        if (list2.isEmpty()) {
            if (list2 instanceof zzku) {
                list2 = new zzkt(size);
            } else if ((list2 instanceof zzlt) && (list2 instanceof zzkm)) {
                list2 = ((zzkm) list2).zzd(size);
            } else {
                list2 = new ArrayList(size);
            }
            zzmy.zzs(j, obj, list2);
        } else {
            if (zza.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                zzmy.zzs(j, obj, arrayList);
                zzktVar = arrayList;
            } else if (list2 instanceof zzmt) {
                zzkt zzktVar2 = new zzkt(list2.size() + size);
                zzktVar2.addAll(zzktVar2.size(), (zzmt) list2);
                zzmy.zzs(j, obj, zzktVar2);
                zzktVar = zzktVar2;
            } else if ((list2 instanceof zzlt) && (list2 instanceof zzkm)) {
                zzkm zzkmVar = (zzkm) list2;
                if (!zzkmVar.zzc()) {
                    list2 = zzkmVar.zzd(list2.size() + size);
                    zzmy.zzs(j, obj, list2);
                }
            }
            list2 = zzktVar;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        zzmy.zzs(j, obj, list);
    }
}
