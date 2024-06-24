package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbj extends zzaw {
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, ArrayList arrayList) {
        if (str != null && !str.isEmpty() && zzgVar.zzh(str)) {
            zzap zzd = zzgVar.zzd(str);
            if (zzd instanceof zzai) {
                return ((zzai) zzd).zza(zzgVar, arrayList);
            }
            throw new IllegalArgumentException(String.format("Function %s is not defined", str));
        }
        throw new IllegalArgumentException(String.format("Command not found: %s", str));
    }
}
