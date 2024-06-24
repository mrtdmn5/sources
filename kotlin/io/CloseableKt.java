package kotlin.io;

import com.google.android.gms.internal.measurement.zznq;
import com.google.android.gms.internal.measurement.zznr;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.io.Closeable;
import java.util.List;
import kotlin.ExceptionsKt;

/* compiled from: Closeable.kt */
/* loaded from: classes.dex */
public final class CloseableKt implements zzdq {
    public static final /* synthetic */ CloseableKt zza = new CloseableKt();

    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Integer.valueOf((int) ((zznr) zznq.zza.zzb.zza()).zza());
    }
}
