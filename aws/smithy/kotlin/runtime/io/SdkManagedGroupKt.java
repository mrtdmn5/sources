package aws.smithy.kotlin.runtime.io;

import com.google.android.gms.internal.measurement.zzpd;
import com.google.android.gms.measurement.internal.zzdq;
import com.google.android.gms.measurement.internal.zzdu;
import java.io.Closeable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkManagedGroup.kt */
/* loaded from: classes.dex */
public final class SdkManagedGroupKt implements zzdq {
    public static final int[] EMPTY_INTS = new int[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];
    public static final /* synthetic */ SdkManagedGroupKt zza = new SdkManagedGroupKt();

    public static final void addIfManaged(SdkManagedGroup sdkManagedGroup, Closeable resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        if (resource instanceof SdkManaged) {
            SdkManaged sdkManaged = (SdkManaged) resource;
            sdkManaged.share();
            sdkManagedGroup.resources.add(sdkManaged);
        }
    }

    public static final int binarySearchInternal(int[] r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r42 = r4 - 1;
        int r0 = 0;
        while (r0 <= r42) {
            int r1 = (r0 + r42) >>> 1;
            int r2 = r3[r1];
            if (r2 < r5) {
                r0 = r1 + 1;
            } else if (r2 > r5) {
                r42 = r1 - 1;
            } else {
                return r1;
            }
        }
        return ~r0;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    public Object zza() {
        List list = zzdu.zzav;
        return Boolean.valueOf(zzpd.zza.zza().zzb());
    }
}
