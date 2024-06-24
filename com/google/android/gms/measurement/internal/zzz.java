package com.google.android.gms.measurement.internal;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zznz;
import java.math.BigDecimal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzz extends zzy {
    public final /* synthetic */ zzaa zza;
    public final zzet zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzaa zzaaVar, String str, int r3, zzet zzetVar) {
        super(str, r3);
        this.zza = zzaaVar;
        this.zzh = zzetVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzgm zzgmVar, boolean z) {
        byte b;
        Object obj;
        zznz.zzc();
        zzaa zzaaVar = this.zza;
        boolean zzs = zzaaVar.zzt.zzk.zzs(this.zzb, zzdu.zzU);
        zzet zzetVar = this.zzh;
        boolean zzg = zzetVar.zzg();
        boolean zzh = zzetVar.zzh();
        boolean zzi = zzetVar.zzi();
        if (!zzg && !zzh && !zzi) {
            b = false;
        } else {
            b = true;
        }
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        zzfr zzfrVar = zzaaVar.zzt;
        if (z && b == false) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            Integer valueOf = Integer.valueOf(this.zzc);
            if (zzetVar.zzj()) {
                num = Integer.valueOf(zzetVar.zza());
            }
            zzehVar.zzl.zzc(valueOf, num, "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID");
            return true;
        }
        com.google.android.gms.internal.measurement.zzem zzb = zzetVar.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzgmVar.zzr()) {
            if (!zzb.zzi()) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No number filter for long property. property");
            } else {
                try {
                    bool4 = zzy.zze(new BigDecimal(zzgmVar.zzb()), zzb.zzc(), 0.0d);
                } catch (NumberFormatException unused) {
                }
                bool = zzy.zzj(bool4, zzg2);
            }
        } else if (zzgmVar.zzq()) {
            if (!zzb.zzi()) {
                zzeh zzehVar3 = zzfrVar.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No number filter for double property. property");
            } else {
                double zza = zzgmVar.zza();
                try {
                    bool3 = zzy.zze(new BigDecimal(zza), zzb.zzc(), Math.ulp(zza));
                } catch (NumberFormatException unused2) {
                }
                bool = zzy.zzj(bool3, zzg2);
            }
        } else if (zzgmVar.zzt()) {
            if (!zzb.zzk()) {
                if (!zzb.zzi()) {
                    zzeh zzehVar4 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar4);
                    zzehVar4.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "No string or number filter defined. property");
                } else if (zzkv.zzx(zzgmVar.zzg())) {
                    String zzg3 = zzgmVar.zzg();
                    com.google.android.gms.internal.measurement.zzer zzc = zzb.zzc();
                    if (zzkv.zzx(zzg3)) {
                        try {
                            bool2 = zzy.zze(new BigDecimal(zzg3), zzc, 0.0d);
                        } catch (NumberFormatException unused3) {
                        }
                    }
                    bool = zzy.zzj(bool2, zzg2);
                } else {
                    zzeh zzehVar5 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar5);
                    zzehVar5.zzg.zzc(zzfrVar.zzq.zzf(zzgmVar.zzf()), zzgmVar.zzg(), "Invalid user property value for Numeric number filter. property, value");
                }
            } else {
                String zzg4 = zzgmVar.zzg();
                com.google.android.gms.internal.measurement.zzey zzd = zzb.zzd();
                zzeh zzehVar6 = zzfrVar.zzm;
                zzfr.zzR(zzehVar6);
                bool = zzy.zzj(zzy.zzf(zzg4, zzd, zzehVar6), zzg2);
            }
        } else {
            zzeh zzehVar7 = zzfrVar.zzm;
            zzfr.zzR(zzehVar7);
            zzehVar7.zzg.zzb(zzfrVar.zzq.zzf(zzgmVar.zzf()), "User property has no value, property");
        }
        zzeh zzehVar8 = zzfrVar.zzm;
        zzfr.zzR(zzehVar8);
        if (bool == null) {
            obj = Constants.NULL_VERSION_ID;
        } else {
            obj = bool;
        }
        zzehVar8.zzl.zzb(obj, "Property filter result");
        if (bool == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if (zzi && !bool.booleanValue()) {
            return true;
        }
        if (!z || zzetVar.zzg()) {
            this.zze = bool;
        }
        if (bool.booleanValue() && b != false && zzgmVar.zzs()) {
            long zzc2 = zzgmVar.zzc();
            if (l != null) {
                zzc2 = l.longValue();
            }
            if (zzs && zzetVar.zzg() && !zzetVar.zzh() && l2 != null) {
                zzc2 = l2.longValue();
            }
            if (zzetVar.zzh()) {
                this.zzg = Long.valueOf(zzc2);
            } else {
                this.zzf = Long.valueOf(zzc2);
            }
        }
        return true;
    }
}
