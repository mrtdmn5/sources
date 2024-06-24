package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdw extends zzch {
    public final com.google.android.gms.measurement.internal.zzgs zza;

    public zzdw(com.google.android.gms.measurement.internal.zzgs zzgsVar) {
        this.zza = zzgsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(long j, Bundle bundle, String str, String str2) {
        this.zza.onEvent(j, bundle, str, str2);
    }
}
