package com.google.android.gms.internal.measurement;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhv extends zzib {
    public zzhv(zzhy zzhyVar, String str, Boolean bool) {
        super(zzhyVar, str, bool);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final Object zza(String str) {
        if (zzha.zzc.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (zzha.zzd.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        this.zza.getClass();
        Log.e("PhenotypeFlag", "Invalid boolean value for " + this.zzb + ": " + str);
        return null;
    }
}
