package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlq implements zzlx {
    public final zzlm zza;
    public final zzmo zzb;
    public final boolean zzc;
    public final zzjs zzd;

    public zzlq(zzmo zzmoVar, zzjs zzjsVar, zzlm zzlmVar) {
        this.zzb = zzmoVar;
        this.zzc = zzjsVar.zzc(zzlmVar);
        this.zzd = zzjsVar;
        this.zza = zzlmVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zza(Object obj) {
        zzmo zzmoVar = this.zzb;
        int zzb = zzmoVar.zzb(zzmoVar.zzd(obj));
        if (!this.zzc) {
            return zzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final zzkf zze() {
        zzlm zzlmVar = this.zza;
        if (zzlmVar instanceof zzkf) {
            return (zzkf) ((zzkf) zzlmVar).zzl(4);
        }
        return zzlmVar.zzbG().zzaD();
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzg(Object obj, Object obj2) {
        Class cls = zzlz.zza;
        zzmo zzmoVar = this.zzb;
        zzmoVar.zzh(obj, zzmoVar.zze(zzmoVar.zzd(obj), zzmoVar.zzd(obj2)));
        if (!this.zzc) {
            return;
        }
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzh(Object obj, byte[] bArr, int r3, int r4, zzir zzirVar) throws IOException {
        zzkf zzkfVar = (zzkf) obj;
        if (zzkfVar.zzc == zzmp.zza) {
            zzkfVar.zzc = zzmp.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final void zzi(Object obj, zzjn zzjnVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzj(Object obj, Object obj2) {
        zzmo zzmoVar = this.zzb;
        if (!zzmoVar.zzd(obj).equals(zzmoVar.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        zzjs zzjsVar = this.zzd;
        zzjsVar.zza(obj);
        zzjsVar.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlx
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
