package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzaf implements zzap {
    public final boolean zza;

    public zzaf(Boolean bool) {
        boolean booleanValue;
        if (bool == null) {
            booleanValue = false;
        } else {
            booleanValue = bool.booleanValue();
        }
        this.zza = booleanValue;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzaf) && this.zza == ((zzaf) obj).zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        boolean equals = "toString".equals(str);
        boolean z = this.zza;
        if (equals) {
            return new zzat(Boolean.toString(z));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(z), str));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzaf(Boolean.valueOf(this.zza));
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        double d;
        if (true != this.zza) {
            d = 0.0d;
        } else {
            d = 1.0d;
        }
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return Boolean.toString(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return null;
    }
}
