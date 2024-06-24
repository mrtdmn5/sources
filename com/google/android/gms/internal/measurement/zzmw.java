package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmw extends zzmx {
    @Override // com.google.android.gms.internal.measurement.zzmx
    public final double zza(long j, Object obj) {
        return Double.longBitsToDouble(zzk(j, obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final float zzb(long j, Object obj) {
        return Float.intBitsToFloat(zzj(j, obj));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(Object obj, long j, boolean z) {
        if (zzmy.zzb) {
            zzmy.zzD(obj, j, z ? (byte) 1 : (byte) 0);
        } else {
            zzmy.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(Object obj, long j, byte b) {
        if (zzmy.zzb) {
            zzmy.zzD(obj, j, b);
        } else {
            zzmy.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzf(Object obj, long j, float f) {
        zzn(j, Float.floatToIntBits(f), obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final boolean zzg(long j, Object obj) {
        if (zzmy.zzb) {
            if (((byte) ((zzmy.zzf.zzj((-4) & j, obj) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0) {
                return true;
            }
            return false;
        }
        if (((byte) ((zzmy.zzf.zzj((-4) & j, obj) >>> ((int) ((j & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }
}
