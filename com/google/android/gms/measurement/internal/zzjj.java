package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjj implements Runnable {
    public final /* synthetic */ zzjl zza;

    public zzjj(zzjl zzjlVar) {
        this.zza = zzjlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjl zzjlVar = this.zza;
        zzjm zzjmVar = zzjlVar.zza;
        Context context = zzjmVar.zzt.zze;
        zzjlVar.zza.zzt.getClass();
        zzjm.zzo(zzjmVar, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
