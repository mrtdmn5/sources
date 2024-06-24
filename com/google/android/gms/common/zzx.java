package com.google.android.gms.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public class zzx {
    public static final zzx zze = new zzx(true, null, null);
    public final boolean zza;
    public final String zzb;
    public final Throwable zzc;

    public zzx(boolean z, String str, Exception exc) {
        this.zza = z;
        this.zzb = str;
        this.zzc = exc;
    }

    public static zzx zzc(String str) {
        return new zzx(false, str, null);
    }

    public static zzx zzd(String str, Exception exc) {
        return new zzx(false, str, exc);
    }

    public String zza() {
        return this.zzb;
    }
}
