package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjd implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzq zzd;
    public final /* synthetic */ zzjm zze;

    public zzjd(zzjm zzjmVar, AtomicReference atomicReference, String str, String str2, zzq zzqVar) {
        this.zze = zzjmVar;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjm zzjmVar;
        zzdx zzdxVar;
        synchronized (this.zza) {
            try {
                try {
                    zzjmVar = this.zze;
                    zzdxVar = zzjmVar.zzb;
                } catch (RemoteException e) {
                    zzeh zzehVar = this.zze.zzt.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzd("(legacy) Failed to get conditional properties; remote exception", null, this.zzb, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                }
                if (zzdxVar == null) {
                    zzeh zzehVar2 = zzjmVar.zzt.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.zzb, this.zzc);
                    this.zza.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    Preconditions.checkNotNull(this.zzd);
                    this.zza.set(zzdxVar.zzf(this.zzb, this.zzc, this.zzd));
                } else {
                    this.zza.set(zzdxVar.zzg(null, this.zzb, this.zzc));
                }
                this.zze.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
