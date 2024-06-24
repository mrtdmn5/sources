package kotlin.internal;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.Modifier;
import com.google.android.gms.internal.measurement.zzof;
import com.google.android.gms.internal.measurement.zzog;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.observer.DelegatedCall;
import io.ktor.utils.io.ByteReadChannel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: progressionUtil.kt */
/* loaded from: classes.dex */
public final class ProgressionUtilKt implements zzdq {
    public static final /* synthetic */ ProgressionUtilKt zza = new ProgressionUtilKt();

    public static final int getProgressionLastElement(int r1, int r2, int r3) {
        if (r3 > 0) {
            if (r1 < r2) {
                int r0 = r2 % r3;
                if (r0 < 0) {
                    r0 += r3;
                }
                int r12 = r1 % r3;
                if (r12 < 0) {
                    r12 += r3;
                }
                int r02 = (r0 - r12) % r3;
                if (r02 < 0) {
                    r02 += r3;
                }
                return r2 - r02;
            }
            return r2;
        }
        if (r3 < 0) {
            if (r1 > r2) {
                int r32 = -r3;
                int r13 = r1 % r32;
                if (r13 < 0) {
                    r13 += r32;
                }
                int r03 = r2 % r32;
                if (r03 < 0) {
                    r03 += r32;
                }
                int r14 = (r13 - r03) % r32;
                if (r14 < 0) {
                    r14 += r32;
                }
                return r2 + r14;
            }
            return r2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final Modifier overscroll(Modifier modifier, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(overscrollEffect, "overscrollEffect");
        return modifier.then(overscrollEffect.getEffectModifier());
    }

    public static final DelegatedCall wrapWithContent(HttpClientCall httpClientCall, ByteReadChannel content) {
        Intrinsics.checkNotNullParameter(httpClientCall, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        return new DelegatedCall(httpClientCall.client, content, httpClientCall);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(((zzog) zzof.zza.zzb.zza()).zzb());
    }
}
