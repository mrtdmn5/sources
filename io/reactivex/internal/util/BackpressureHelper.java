package io.reactivex.internal.util;

import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class BackpressureHelper implements zzdq {
    public static final /* synthetic */ BackpressureHelper zza = new BackpressureHelper();

    public static long add(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j2 = atomicLong.get();
            j3 = Long.MAX_VALUE;
            if (j2 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            long j4 = j2 + j;
            if (j4 >= 0) {
                j3 = j4;
            }
        } while (!atomicLong.compareAndSet(j2, j3));
        return j2;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Long.valueOf(zznn.zza.zza().zzs());
    }
}
