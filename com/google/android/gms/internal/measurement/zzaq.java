package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzaq implements zzap {
    public final String zza;
    public final ArrayList zzb;

    public zzaq(String str, ArrayList arrayList) {
        this.zza = str;
        ArrayList arrayList2 = new ArrayList();
        this.zzb = arrayList2;
        arrayList2.addAll(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaq)) {
            return false;
        }
        zzaq zzaqVar = (zzaq) obj;
        String str = this.zza;
        if (str == null ? zzaqVar.zza != null : !str.equals(zzaqVar.zza)) {
            return false;
        }
        return this.zzb.equals(zzaqVar.zzb);
    }

    public final int hashCode() {
        int r0;
        String str = this.zza;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        return this.zzb.hashCode() + (r0 * 31);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return this;
    }
}
