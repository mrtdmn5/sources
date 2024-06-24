package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzs {
    public final zzfr zza;

    public zzs(zzfr zzfrVar) {
        this.zza = zzfrVar;
    }

    public final void zza(Bundle bundle, String str) {
        String uri;
        zzfr zzfrVar = this.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (!zzfrVar.zzJ()) {
            if (bundle.isEmpty()) {
                uri = null;
            } else {
                if (true == str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str2 : bundle.keySet()) {
                    builder.appendQueryParameter(str2, bundle.getString(str2));
                }
                uri = builder.build().toString();
            }
            if (!TextUtils.isEmpty(uri)) {
                zzew zzewVar = zzfrVar.zzl;
                zzfr.zzP(zzewVar);
                zzewVar.zzq.zzb(uri);
                zzfr.zzP(zzewVar);
                zzfrVar.zzr.getClass();
                zzewVar.zzr.zzb(System.currentTimeMillis());
            }
        }
    }

    public final boolean zzd() {
        zzew zzewVar = this.zza.zzl;
        zzfr.zzP(zzewVar);
        if (zzewVar.zzr.zza() > 0) {
            return true;
        }
        return false;
    }

    public final boolean zze() {
        if (!zzd()) {
            return false;
        }
        zzfr zzfrVar = this.zza;
        zzfrVar.zzr.getClass();
        long currentTimeMillis = System.currentTimeMillis();
        zzew zzewVar = zzfrVar.zzl;
        zzfr.zzP(zzewVar);
        if (currentTimeMillis - zzewVar.zzr.zza() <= zzfrVar.zzk.zzi(null, zzdu.zzQ)) {
            return false;
        }
        return true;
    }
}
