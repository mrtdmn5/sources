package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.ui.geometry.MutableRectKt;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgc implements Runnable {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzgj zzc;

    public zzgc(zzgj zzgjVar, zzaw zzawVar, zzq zzqVar) {
        this.zzc = zzgjVar;
        this.zza = zzawVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzc zzcVar;
        zzau zzauVar;
        zzgj zzgjVar = this.zzc;
        zzgjVar.getClass();
        zzaw zzawVar = this.zza;
        boolean equals = "_cmp".equals(zzawVar.zza);
        zzkt zzktVar = zzgjVar.zza;
        if (equals && (zzauVar = zzawVar.zzb) != null) {
            Bundle bundle = zzauVar.zza;
            if (bundle.size() != 0) {
                String string = bundle.getString("_cis");
                if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                    zzktVar.zzay().zzj.zzb(zzawVar.toString(), "Event has been filtered ");
                    zzawVar = new zzaw("_cmpx", zzawVar.zzb, zzawVar.zzc, zzawVar.zzd);
                }
            }
        }
        String str = zzawVar.zza;
        zzfi zzfiVar = zzktVar.zzc;
        zzkv zzkvVar = zzktVar.zzi;
        zzkt.zzal(zzfiVar);
        zzq zzqVar = this.zzb;
        if (!zzfiVar.zzo(zzqVar.zza)) {
            zzgjVar.zzA(zzawVar, zzqVar);
            return;
        }
        zzef zzefVar = zzktVar.zzay().zzl;
        String str2 = zzqVar.zza;
        zzefVar.zzb(str2, "EES config found for");
        zzfi zzfiVar2 = zzktVar.zzc;
        zzkt.zzal(zzfiVar2);
        if (TextUtils.isEmpty(str2)) {
            zzcVar = null;
        } else {
            zzcVar = (com.google.android.gms.internal.measurement.zzc) zzfiVar2.zzd.get(str2);
        }
        if (zzcVar != null) {
            try {
                com.google.android.gms.internal.measurement.zzab zzabVar = zzcVar.zzc;
                zzkt.zzal(zzkvVar);
                HashMap zzs = zzkv.zzs(zzawVar.zzb.zzc(), true);
                String zzb = MutableRectKt.zzb(str, zzgo.zzc, zzgo.zza);
                if (zzb == null) {
                    zzb = str;
                }
                if (zzcVar.zze(new com.google.android.gms.internal.measurement.zzaa(zzs, zzb, zzawVar.zzd))) {
                    if (!zzabVar.zzb.equals(zzabVar.zza)) {
                        zzktVar.zzay().zzl.zzb(str, "EES edited event");
                        zzkt.zzal(zzkvVar);
                        zzgjVar.zzA(zzkv.zzi(zzabVar.zzb), zzqVar);
                    } else {
                        zzgjVar.zzA(zzawVar, zzqVar);
                    }
                    if (!zzabVar.zzc.isEmpty()) {
                        Iterator it = zzabVar.zzc.iterator();
                        while (it.hasNext()) {
                            com.google.android.gms.internal.measurement.zzaa zzaaVar = (com.google.android.gms.internal.measurement.zzaa) it.next();
                            zzktVar.zzay().zzl.zzb(zzaaVar.zza, "EES logging created event");
                            zzkt.zzal(zzkvVar);
                            zzgjVar.zzA(zzkv.zzi(zzaaVar), zzqVar);
                        }
                        return;
                    }
                    return;
                }
            } catch (com.google.android.gms.internal.measurement.zzd unused) {
                zzktVar.zzay().zzd.zzc(zzqVar.zzb, str, "EES error. appId, eventName");
            }
            zzktVar.zzay().zzl.zzb(str, "EES was not applied to event");
            zzgjVar.zzA(zzawVar, zzqVar);
            return;
        }
        zzktVar.zzay().zzl.zzb(str2, "EES not loaded for");
        zzgjVar.zzA(zzawVar, zzqVar);
    }
}
