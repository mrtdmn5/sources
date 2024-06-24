package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzf extends zze {
    public boolean zza;

    public zzf(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzt.zzG++;
    }

    public final void zza() {
        if (this.zza) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzb$1() {
        if (!this.zza) {
            if (!zzf()) {
                this.zzt.zzB$1();
                this.zza = true;
                return;
            }
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract boolean zzf();
}
