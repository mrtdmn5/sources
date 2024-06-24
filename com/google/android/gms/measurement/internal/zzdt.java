package com.google.android.gms.measurement.internal;

import no.nordicsemi.android.error.SecureDfuError;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdt {
    public static final Object zza = new Object();
    public final String zzb;
    public final zzdq zzc;
    public final Object zzd;
    public final Object zze;
    public final Object zzf = new Object();
    public volatile Object zzh = null;

    public /* synthetic */ zzdt(String str, Object obj, Object obj2, zzdq zzdqVar) {
        this.zzb = str;
        this.zzd = obj;
        this.zze = obj2;
        this.zzc = zzdqVar;
    }

    public final Object zza(Object obj) {
        Object obj2;
        synchronized (this.zzf) {
        }
        if (obj != null) {
            return obj;
        }
        if (SecureDfuError.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzab.zza()) {
                if (this.zzh == null) {
                    obj2 = this.zzd;
                } else {
                    obj2 = this.zzh;
                }
                return obj2;
            }
            try {
                for (zzdt zzdtVar : zzdu.zzav) {
                    if (!zzab.zza()) {
                        Object obj3 = null;
                        try {
                            zzdq zzdqVar = zzdtVar.zzc;
                            if (zzdqVar != null) {
                                obj3 = zzdqVar.zza();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (zza) {
                            zzdtVar.zzh = obj3;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzdq zzdqVar2 = this.zzc;
            if (zzdqVar2 == null) {
                return this.zzd;
            }
            try {
                return zzdqVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzd;
            } catch (SecurityException unused4) {
                return this.zzd;
            }
        }
    }
}
