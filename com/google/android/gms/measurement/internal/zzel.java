package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzel implements Runnable {
    public final zzej zza;
    public final int zzb;
    public final Throwable zzc;
    public final byte[] zzd;
    public final String zze;
    public final Map zzf;

    public /* synthetic */ zzel(String str, zzej zzejVar, int r3, IOException iOException, byte[] bArr, Map map) {
        Preconditions.checkNotNull(zzejVar);
        this.zza = zzejVar;
        this.zzb = r3;
        this.zzc = iOException;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
