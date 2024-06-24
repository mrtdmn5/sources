package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzkh extends zzkg {
    public boolean zza;

    public zzkh(zzkt zzktVar) {
        super(zzktVar);
        this.zzf.zzr++;
    }

    public final void zzW() {
        if (this.zza) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (!this.zza) {
            zzb();
            this.zzf.zzs++;
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public abstract void zzb();
}
