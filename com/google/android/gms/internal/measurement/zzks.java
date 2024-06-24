package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public class zzks {
    public volatile zzlm zza;
    public volatile zzje zzc;

    static {
        zzjr zzjrVar = zzjr.zzd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        zzks zzksVar = (zzks) obj;
        zzlm zzlmVar = this.zza;
        zzlm zzlmVar2 = zzksVar.zza;
        if (zzlmVar == null && zzlmVar2 == null) {
            return zzb().equals(zzksVar.zzb());
        }
        if (zzlmVar != null && zzlmVar2 != null) {
            return zzlmVar.equals(zzlmVar2);
        }
        if (zzlmVar != null) {
            zzksVar.zzc(zzlmVar.zzbS());
            return zzlmVar.equals(zzksVar.zza);
        }
        zzc(zzlmVar2.zzbS());
        return this.zza.equals(zzlmVar2);
    }

    public final int hashCode() {
        return 1;
    }

    public final zzje zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzje.zzb;
            } else {
                this.zzc = this.zza.zzbs();
            }
            return this.zzc;
        }
    }

    public final void zzc(zzlm zzlmVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzlmVar;
                    this.zzc = zzje.zzb;
                } catch (zzkp unused) {
                    this.zza = zzlmVar;
                    this.zzc = zzje.zzb;
                }
            }
        }
    }
}
