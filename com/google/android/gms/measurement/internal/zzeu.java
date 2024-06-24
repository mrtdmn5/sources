package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzeu {
    public final String zza;
    public final /* synthetic */ zzew zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;

    public /* synthetic */ zzeu(zzew zzewVar, long j) {
        boolean z;
        this.zzb = zzewVar;
        Preconditions.checkNotEmpty("health_monitor");
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zza = "health_monitor:start";
        this.zzc = "health_monitor:count";
        this.zzd = "health_monitor:value";
        this.zze = j;
    }

    public final void zzd() {
        zzew zzewVar = this.zzb;
        zzewVar.zzg();
        zzewVar.zzt.zzr.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = zzewVar.zza().edit();
        edit.remove(this.zzc);
        edit.remove(this.zzd);
        edit.putLong(this.zza, currentTimeMillis);
        edit.apply();
    }
}
