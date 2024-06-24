package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhu extends zzib {
    public zzhu(zzhy zzhyVar, String str, Long l) {
        super(zzhyVar, str, l);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final Object zza(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException unused) {
            this.zza.getClass();
            Log.e("PhenotypeFlag", "Invalid long value for " + this.zzb + ": " + str);
            return null;
        }
    }
}
