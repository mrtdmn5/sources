package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjh implements Runnable {
    public final /* synthetic */ ComponentName zza;
    public final /* synthetic */ zzjl zzb;

    public zzjh(zzjl zzjlVar, ComponentName componentName) {
        this.zzb = zzjlVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm.zzo(this.zzb.zza, this.zza);
    }
}
