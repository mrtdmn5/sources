package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgz implements Runnable {
    public final /* synthetic */ zzhx zza;

    public zzgz(zzhx zzhxVar) {
        this.zza = zzhxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        zzs zzsVar = this.zza.zzb;
        zzfr zzfrVar = zzsVar.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        if (zzsVar.zzd()) {
            boolean zze = zzsVar.zze();
            zzhx zzhxVar = zzfrVar.zzt;
            zzew zzewVar = zzfrVar.zzl;
            if (zze) {
                zzfr.zzP(zzewVar);
                zzewVar.zzq.zzb(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                zzfr.zzQ(zzhxVar);
                zzhxVar.zzG("auto", "_cmpx", bundle);
            } else {
                zzfr.zzP(zzewVar);
                String zza = zzewVar.zzq.zza();
                if (TextUtils.isEmpty(zza)) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zze.zza("Cache still valid but referrer not found");
                } else {
                    long zza2 = ((zzewVar.zzr.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str2 : parse.getQueryParameterNames()) {
                        bundle2.putString(str2, parse.getQueryParameter(str2));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza2);
                    Object obj = pair.first;
                    if (obj == null) {
                        str = "app";
                    } else {
                        str = (String) obj;
                    }
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzG(str, "_cmp", (Bundle) pair.second);
                }
                zzewVar.zzq.zzb(null);
            }
            zzfr.zzP(zzewVar);
            zzewVar.zzr.zzb(0L);
        }
    }
}
