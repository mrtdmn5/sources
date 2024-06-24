package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhy {
    public final Uri zzb;
    public final boolean zze;

    public zzhy(Uri uri, boolean z, boolean z2) {
        this.zzb = uri;
        this.zze = z;
    }

    public final zzhu zzd(long j, String str) {
        return new zzhu(this, str, Long.valueOf(j));
    }

    public final zzhx zze(String str, String str2) {
        return new zzhx(this, str, str2);
    }

    public final zzhv zzf(String str, boolean z) {
        return new zzhv(this, str, Boolean.valueOf(z));
    }
}
