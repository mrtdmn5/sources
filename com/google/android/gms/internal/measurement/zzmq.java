package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmq extends zzmo {
    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ int zza(Object obj) {
        return ((zzmp) obj).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final int zzb(Object obj) {
        zzmp zzmpVar = (zzmp) obj;
        int r0 = zzmpVar.zze;
        if (r0 == -1) {
            int r1 = 0;
            for (int r02 = 0; r02 < zzmpVar.zzb; r02++) {
                int r2 = zzmpVar.zzc[r02];
                zzje zzjeVar = (zzje) zzmpVar.zzd[r02];
                int zzA = zzjm.zzA(8);
                int zzd = zzjeVar.zzd();
                r1 += zzjm.zzA(zzd) + zzd + zzjm.zzA(24) + zzjm.zzA(r2 >>> 3) + zzjm.zzA(16) + zzA + zzA;
            }
            zzmpVar.zze = r1;
            return r1;
        }
        return r0;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* bridge */ /* synthetic */ zzmp zzc(Object obj) {
        zzkf zzkfVar = (zzkf) obj;
        zzmp zzmpVar = zzkfVar.zzc;
        if (zzmpVar == zzmp.zza) {
            zzmp zzf = zzmp.zzf();
            zzkfVar.zzc = zzf;
            return zzf;
        }
        return zzmpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ zzmp zzd(Object obj) {
        return ((zzkf) obj).zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final Object zze(Object obj, Object obj2) {
        zzmp zzmpVar = zzmp.zza;
        if (!zzmpVar.equals(obj2)) {
            if (zzmpVar.equals(obj)) {
                zzmp zzmpVar2 = (zzmp) obj2;
                zzmp zzmpVar3 = (zzmp) obj;
                int r0 = zzmpVar3.zzb + zzmpVar2.zzb;
                int[] copyOf = Arrays.copyOf(zzmpVar3.zzc, r0);
                System.arraycopy(zzmpVar2.zzc, 0, copyOf, zzmpVar3.zzb, zzmpVar2.zzb);
                Object[] copyOf2 = Arrays.copyOf(zzmpVar3.zzd, r0);
                System.arraycopy(zzmpVar2.zzd, 0, copyOf2, zzmpVar3.zzb, zzmpVar2.zzb);
                return new zzmp(r0, copyOf, copyOf2, true);
            }
            zzmp zzmpVar4 = (zzmp) obj2;
            zzmp zzmpVar5 = (zzmp) obj;
            zzmpVar5.getClass();
            if (!zzmpVar4.equals(zzmpVar)) {
                if (zzmpVar5.zzf) {
                    int r02 = zzmpVar5.zzb + zzmpVar4.zzb;
                    zzmpVar5.zzl(r02);
                    System.arraycopy(zzmpVar4.zzc, 0, zzmpVar5.zzc, zzmpVar5.zzb, zzmpVar4.zzb);
                    System.arraycopy(zzmpVar4.zzd, 0, zzmpVar5.zzd, zzmpVar5.zzb, zzmpVar4.zzb);
                    zzmpVar5.zzb = r02;
                    return obj;
                }
                throw new UnsupportedOperationException();
            }
            return obj;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* bridge */ /* synthetic */ void zzf(long j, int r3, Object obj) {
        ((zzmp) obj).zzj(r3 << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final void zzg(Object obj) {
        ((zzkf) obj).zzc.zzf = false;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzkf) obj).zzc = (zzmp) obj2;
    }

    @Override // com.google.android.gms.internal.measurement.zzmo
    public final /* synthetic */ void zzi(Object obj, zzjn zzjnVar) throws IOException {
        ((zzmp) obj).zzk(zzjnVar);
    }
}
