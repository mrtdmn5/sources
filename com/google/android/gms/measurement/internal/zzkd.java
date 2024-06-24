package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkd {
    public final Clock zza;
    public long zzb;

    public zzkd(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }
}
