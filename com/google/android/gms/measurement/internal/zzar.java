package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzar {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final zzau zzf;

    public zzar(zzfr zzfrVar, String str, String str2, String str3, long j, Bundle bundle) {
        zzau zzauVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = 0L;
        if (!bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza("Param name can't be null");
                    it.remove();
                } else {
                    zzlb zzlbVar = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar);
                    Object zzA = zzlbVar.zzA(bundle2.get(next), next);
                    if (zzA == null) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzg.zzb(zzfrVar.zzq.zze(next), "Param value can't be null");
                        it.remove();
                    } else {
                        zzlb zzlbVar2 = zzfrVar.zzp;
                        zzfr.zzP(zzlbVar2);
                        zzlbVar2.zzO(bundle2, next, zzA);
                    }
                }
            }
            zzauVar = new zzau(bundle2);
        } else {
            zzauVar = new zzau(new Bundle());
        }
        this.zzf = zzauVar;
    }

    public final String toString() {
        return "Event{appId='" + this.zza + "', name='" + this.zzb + "', params=" + this.zzf.toString() + "}";
    }

    public final zzar zza(zzfr zzfrVar, long j) {
        return new zzar(zzfrVar, this.zzc, this.zza, this.zzb, this.zzd, j, this.zzf);
    }

    public zzar(zzfr zzfrVar, String str, String str2, String str3, long j, long j2, zzau zzauVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzauVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzc = true == TextUtils.isEmpty(str) ? null : str;
        this.zzd = j;
        this.zze = j2;
        if (j2 != 0 && j2 > j) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzc(zzeh.zzn(str2), zzeh.zzn(str3), "Event created with reverse previous/current timestamps. appId, name");
        }
        this.zzf = zzauVar;
    }
}
