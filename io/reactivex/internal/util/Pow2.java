package io.reactivex.internal.util;

import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public final class Pow2 implements zzdq {
    public static final /* synthetic */ Pow2 zza = new Pow2();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00a1, code lost:            if (r6 == r1) goto L77;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:35:0x00bb. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.coroutines.intrinsics.CoroutineSingletons access$throwRevokeTokenError(aws.smithy.kotlin.runtime.operation.ExecutionContext r4, aws.smithy.kotlin.runtime.http.response.HttpResponse r5, kotlin.coroutines.Continuation r6) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.Pow2.access$throwRevokeTokenError(aws.smithy.kotlin.runtime.operation.ExecutionContext, aws.smithy.kotlin.runtime.http.response.HttpResponse, kotlin.coroutines.Continuation):kotlin.coroutines.intrinsics.CoroutineSingletons");
    }

    public static zzii zza(zzii zziiVar) {
        if ((zziiVar instanceof zzik) || (zziiVar instanceof zzij)) {
            return zziiVar;
        }
        if (zziiVar instanceof Serializable) {
            return new zzij(zziiVar);
        }
        return new zzik(zziiVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Long.valueOf(zznn.zza.zza().zza());
    }
}
