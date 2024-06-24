package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjr {
    public static final zzjr zza = new zzjr(0);
    public static volatile zzjr zzd;
    public final Map zze;

    public zzjr() {
        this.zze = new HashMap();
    }

    public final zzkd zzb(zzlm zzlmVar, int r3) {
        return (zzkd) this.zze.get(new zzjq(r3, zzlmVar));
    }

    public zzjr(int r1) {
        this.zze = Collections.emptyMap();
    }
}
