package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfg {
    public final /* synthetic */ zzfi zza;

    public zzfg(zzfi zzfiVar) {
        this.zza = zzfiVar;
    }

    public final void zza(int r5, String str, List list, boolean z, boolean z2) {
        zzef zzefVar;
        int r52 = r5 - 1;
        zzfi zzfiVar = this.zza;
        if (r52 != 0) {
            if (r52 != 1) {
                if (r52 != 3) {
                    if (r52 != 4) {
                        zzeh zzehVar = zzfiVar.zzt.zzm;
                        zzfr.zzR(zzehVar);
                        zzefVar = zzehVar.zzj;
                    } else if (z) {
                        zzeh zzehVar2 = zzfiVar.zzt.zzm;
                        zzfr.zzR(zzehVar2);
                        zzefVar = zzehVar2.zzh;
                    } else if (!z2) {
                        zzeh zzehVar3 = zzfiVar.zzt.zzm;
                        zzfr.zzR(zzehVar3);
                        zzefVar = zzehVar3.zzi;
                    } else {
                        zzeh zzehVar4 = zzfiVar.zzt.zzm;
                        zzfr.zzR(zzehVar4);
                        zzefVar = zzehVar4.zzg;
                    }
                } else {
                    zzeh zzehVar5 = zzfiVar.zzt.zzm;
                    zzfr.zzR(zzehVar5);
                    zzefVar = zzehVar5.zzl;
                }
            } else if (z) {
                zzeh zzehVar6 = zzfiVar.zzt.zzm;
                zzfr.zzR(zzehVar6);
                zzefVar = zzehVar6.zze;
            } else if (!z2) {
                zzeh zzehVar7 = zzfiVar.zzt.zzm;
                zzfr.zzR(zzehVar7);
                zzefVar = zzehVar7.zzf;
            } else {
                zzeh zzehVar8 = zzfiVar.zzt.zzm;
                zzfr.zzR(zzehVar8);
                zzefVar = zzehVar8.zzd;
            }
        } else {
            zzeh zzehVar9 = zzfiVar.zzt.zzm;
            zzfr.zzR(zzehVar9);
            zzefVar = zzehVar9.zzk;
        }
        int size = list.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    zzefVar.zza(str);
                    return;
                } else {
                    zzefVar.zzd(str, list.get(0), list.get(1), list.get(2));
                    return;
                }
            }
            zzefVar.zzc(list.get(0), list.get(1), str);
            return;
        }
        zzefVar.zzb(list.get(0), str);
    }
}
