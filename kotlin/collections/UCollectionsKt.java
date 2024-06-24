package kotlin.collections;

import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.UInt;

/* compiled from: _UCollections.kt */
/* loaded from: classes.dex */
public final class UCollectionsKt implements zzdq {
    public static final /* synthetic */ UCollectionsKt zza = new UCollectionsKt();

    public static final int[] toUIntArray(Collection collection) {
        int[] r0 = new int[collection.size()];
        Iterator it = collection.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            r0[r1] = ((UInt) it.next()).data;
            r1++;
        }
        return r0;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzpn) zzpm.zza.zzb.zza()).zza());
    }
}
