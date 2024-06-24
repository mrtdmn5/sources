package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzgl extends zzgk {
    public boolean zza;

    public zzgl(zzfr zzfrVar) {
        super(zzfrVar);
        this.zzt.zzG++;
    }

    public abstract boolean zzf();

    public final void zzu() {
        if (this.zza) {
        } else {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
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
}
