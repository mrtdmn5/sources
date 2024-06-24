package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzji implements Runnable {
    public final /* synthetic */ zzdx zza;
    public final /* synthetic */ zzjl zzb;

    public zzji(zzjl zzjlVar, zzdx zzdxVar) {
        this.zzb = zzjlVar;
        this.zza = zzdxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            try {
                this.zzb.zzb = false;
                if (!this.zzb.zza.zzL()) {
                    zzeh zzehVar = this.zzb.zza.zzt.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Connected to remote service");
                    zzjm zzjmVar = this.zzb.zza;
                    zzdx zzdxVar = this.zza;
                    zzjmVar.zzg();
                    Preconditions.checkNotNull(zzdxVar);
                    zzjmVar.zzb = zzdxVar;
                    zzjmVar.zzQ();
                    zzjmVar.zzP$1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
