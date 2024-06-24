package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzei {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final Bundle zzd;

    public zzei(long j, Bundle bundle, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j;
    }

    public static zzei zzb(zzaw zzawVar) {
        String str = zzawVar.zza;
        String str2 = zzawVar.zzc;
        return new zzei(zzawVar.zzd, zzawVar.zzb.zzc(), str, str2);
    }

    public final String toString() {
        return "origin=" + this.zzb + ",name=" + this.zza + ",params=" + this.zzd.toString();
    }

    public final zzaw zza() {
        return new zzaw(this.zza, new zzau(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
