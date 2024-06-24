package com.google.android.gms.internal.measurement;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public class zzjb extends zzja {
    public final byte[] zza;

    public zzjb(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzje) || zzd() != ((zzje) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (obj instanceof zzjb) {
            zzjb zzjbVar = (zzjb) obj;
            int r1 = this.zzc;
            int r3 = zzjbVar.zzc;
            if (r1 != 0 && r3 != 0 && r1 != r3) {
                return false;
            }
            int zzd = zzd();
            if (zzd <= zzjbVar.zzd()) {
                if (zzd <= zzjbVar.zzd()) {
                    zzjbVar.zzc();
                    int r32 = 0;
                    int r4 = 0;
                    while (r32 < zzd) {
                        if (this.zza[r32] != zzjbVar.zza[r4]) {
                            return false;
                        }
                        r32++;
                        r4++;
                    }
                    return true;
                }
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Ran off end of other: 0, ", zzd, ", ", zzjbVar.zzd()));
            }
            throw new IllegalArgumentException("Length too large: " + zzd + zzd());
        }
        return obj.equals(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zza(int r2) {
        return this.zza[r2];
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public byte zzb(int r2) {
        return this.zza[r2];
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final int zze(int r3, int r4) {
        Charset charset = zzkn.zzb;
        for (int r0 = 0; r0 < r4; r0++) {
            r3 = (r3 * 31) + this.zza[r0];
        }
        return r3;
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final zzjb zzf() {
        int zzj = zzje.zzj(0, 47, zzd());
        if (zzj == 0) {
            return zzje.zzb;
        }
        return new zziy(this.zza, zzj);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final void zzh(zzjm zzjmVar) throws IOException {
        ((zzjj) zzjmVar).zzc(this.zza, zzd());
    }

    @Override // com.google.android.gms.internal.measurement.zzje
    public final boolean zzi() {
        return zznd.zzf(this.zza, 0, zzd());
    }

    public void zzc() {
    }
}
