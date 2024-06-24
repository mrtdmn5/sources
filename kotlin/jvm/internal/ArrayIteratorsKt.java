package kotlin.jvm.internal;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;

/* compiled from: ArrayIterators.kt */
/* loaded from: classes.dex */
public final class ArrayIteratorsKt implements zzdq {
    public static final /* synthetic */ ArrayIteratorsKt zza = new ArrayIteratorsKt();

    public static final int findIndexByKey(LazyLayoutItemProvider lazyLayoutItemProvider, Object obj, int r3) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        if (obj != null && lazyLayoutItemProvider.getItemCount() != 0) {
            if (r3 < lazyLayoutItemProvider.getItemCount() && Intrinsics.areEqual(obj, lazyLayoutItemProvider.getKey(r3))) {
                return r3;
            }
            int index = lazyLayoutItemProvider.getIndex(obj);
            if (index != -1) {
                return index;
            }
        }
        return r3;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzpd.zza.zza().zzd());
    }
}
