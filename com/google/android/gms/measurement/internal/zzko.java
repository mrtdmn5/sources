package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzko implements zzla {
    public final /* synthetic */ zzkt zza;

    public zzko(zzkt zzktVar) {
        this.zza = zzktVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzla
    public final void zza(String str, Bundle bundle) {
        boolean isEmpty = TextUtils.isEmpty(str);
        zzkt zzktVar = this.zza;
        if (isEmpty) {
            zzfr zzfrVar = zzktVar.zzn;
            if (zzfrVar != null) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb("_err", "AppId not known when logging event");
                return;
            }
            return;
        }
        zzktVar.zzaz().zzp(new zzkn(this, str, bundle));
    }
}
