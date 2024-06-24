package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlw implements zzlj {
    public final zzlm zza;
    public final String zzb;
    public final Object[] zzc;
    public final int zzd;

    public zzlw(zzkf zzkfVar, String str, Object[] objArr) {
        this.zza = zzkfVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int r4 = charAt & 8191;
        int r0 = 1;
        int r1 = 13;
        while (true) {
            int r2 = r0 + 1;
            char charAt2 = str.charAt(r0);
            if (charAt2 >= 55296) {
                r4 |= (charAt2 & 8191) << r1;
                r1 += 13;
                r0 = r2;
            } else {
                this.zzd = r4 | (charAt2 << r1);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzlm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzb() {
        if ((this.zzd & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zzc() {
        if ((this.zzd & 1) == 1) {
            return 1;
        }
        return 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
