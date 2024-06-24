package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzil implements Serializable, zzii {
    public final Object zza;

    public zzil(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzil)) {
            return false;
        }
        Object obj2 = ((zzil) obj).zza;
        Object obj3 = this.zza;
        if (obj3 != obj2 && !obj3.equals(obj2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        return "Suppliers.ofInstance(" + this.zza + ")";
    }

    @Override // com.google.android.gms.internal.measurement.zzii
    public final Object zza() {
        return this.zza;
    }
}
