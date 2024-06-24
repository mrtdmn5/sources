package kotlin;

import com.google.android.gms.internal.measurement.zzor;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.firebase.heartbeatinfo.HeartBeatConsumer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

/* compiled from: UnsignedUtils.kt */
/* loaded from: classes.dex */
public final class UnsignedKt implements zzdq, HeartBeatConsumer {
    public static final /* synthetic */ UnsignedKt zza = new UnsignedKt();

    public static void checkBuilderRequirement(Class cls, Object obj) {
        if (obj != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static void checkNotNullFromProvides(Object obj) {
        if (obj != null) {
        } else {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    public static final double ulongToDouble(long j) {
        return ((j >>> 11) * 2048) + (j & 2047);
    }

    public static final String ulongToString(int r8, long j) {
        if (j >= 0) {
            CharsKt__CharKt.checkRadix(r8);
            String l = Long.toString(j, r8);
            Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
            return l;
        }
        long j2 = r8;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        CharsKt__CharKt.checkRadix(r8);
        String l2 = Long.toString(j3, r8);
        Intrinsics.checkNotNullExpressionValue(l2, "toString(...)");
        CharsKt__CharKt.checkRadix(r8);
        String l3 = Long.toString(j4, r8);
        Intrinsics.checkNotNullExpressionValue(l3, "toString(...)");
        return l2.concat(l3);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Long.valueOf(zzor.zza.zza().zzc());
    }
}
