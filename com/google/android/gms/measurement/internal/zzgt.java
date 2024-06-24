package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgt {
    public final /* synthetic */ zzfr zza;

    public zzgt(zzfr zzfrVar) {
        this.zza = zzfrVar;
    }

    public final boolean zza() {
        zzfr zzfrVar = this.zza;
        if (TextUtils.isEmpty(zzfrVar.zzf)) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            if (Log.isLoggable(zzehVar.zzq(), 3)) {
                return true;
            }
            return false;
        }
        return false;
    }
}
