package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhl implements zzla {
    public final /* synthetic */ zzhx zza;

    public zzhl(zzhx zzhxVar) {
        this.zza = zzhxVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzla
    public final void zza(String str, Bundle bundle) {
        boolean isEmpty = TextUtils.isEmpty(str);
        zzhx zzhxVar = this.zza;
        if (isEmpty) {
            zzhxVar.zzt.zzr.getClass();
            zzhxVar.zzE("auto", "_err", bundle, true, true, System.currentTimeMillis());
        } else {
            zzhxVar.getClass();
            throw new IllegalStateException("Unexpected call on client side");
        }
    }
}
