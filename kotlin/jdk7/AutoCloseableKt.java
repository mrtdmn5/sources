package kotlin.jdk7;

import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zzni;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AutoCloseableJVM.kt */
/* loaded from: classes.dex */
public final class AutoCloseableKt implements zzdq {
    public static final /* synthetic */ AutoCloseableKt zza = new AutoCloseableKt();

    public static final void closeFinally(AutoCloseable autoCloseable, Throwable th) {
        if (autoCloseable != null) {
            if (th == null) {
                autoCloseable.close();
                return;
            }
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    public static final Throwable unwrapCancellationException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Throwable th2 = th;
        while (th2 instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) th2;
            if (Intrinsics.areEqual(th2, cancellationException.getCause())) {
                return th;
            }
            th2 = cancellationException.getCause();
        }
        if (th2 != null) {
            return th2;
        }
        return th;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzni) zznh.zza.zzb.zza()).zza());
    }
}
