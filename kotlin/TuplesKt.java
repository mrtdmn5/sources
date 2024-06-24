package kotlin;

import com.animaconnected.watch.strings.Key;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;

/* compiled from: Tuples.kt */
/* loaded from: classes.dex */
public final class TuplesKt implements zzdq {
    public static final /* synthetic */ TuplesKt zza = new TuplesKt();

    public static final Pair to(Key key, String str) {
        return new Pair(key, str);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Long.valueOf(zznn.zza.zza().zzn());
    }
}
