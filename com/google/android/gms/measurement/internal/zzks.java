package com.google.android.gms.measurement.internal;

import android.os.SystemClock;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzks {
    public final String zza;
    public final long zzb;

    public zzks(zzkt zzktVar, String str) {
        this.zza = str;
        ((Dns$Companion$DnsSystem) zzktVar.zzav()).getClass();
        this.zzb = SystemClock.elapsedRealtime();
    }
}
