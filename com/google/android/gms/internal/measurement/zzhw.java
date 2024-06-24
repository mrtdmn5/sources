package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhw extends zzib {
    public zzhw(zzhy zzhyVar, Double d) {
        super(zzhyVar, "measurement.test.double_flag", d);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final Object zza(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            this.zza.getClass();
            Log.e("PhenotypeFlag", "Invalid double value for " + this.zzb + ": " + str);
            return null;
        }
    }
}
