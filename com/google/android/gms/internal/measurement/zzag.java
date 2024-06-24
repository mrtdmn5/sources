package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzag implements zzap {
    public final zzap zza;
    public final String zzb;

    public zzag(String str) {
        this.zza = zzap.zzf;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzag)) {
            return false;
        }
        zzag zzagVar = (zzag) obj;
        if (this.zzb.equals(zzagVar.zzb) && this.zza.equals(zzagVar.zza)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + (this.zzb.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzag(this.zzb, this.zza.zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }

    public zzag(String str, zzap zzapVar) {
        this.zza = zzapVar;
        this.zzb = str;
    }

    public zzag() {
        throw null;
    }
}
