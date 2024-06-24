package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import okhttp3.Dns$Companion$DnsSystem;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzap {
    public static volatile com.google.android.gms.internal.measurement.zzby zza;
    public final zzgm zzb;
    public final zzao zzc;
    public volatile long zzd;

    public zzap(zzgm zzgmVar) {
        Preconditions.checkNotNull(zzgmVar);
        this.zzb = zzgmVar;
        this.zzc = new zzao(this, zzgmVar);
    }

    public final void zzb() {
        this.zzd = 0L;
        zzf().removeCallbacks(this.zzc);
    }

    public abstract void zzc();

    public final void zzd(long j) {
        zzb();
        if (j >= 0) {
            ((Dns$Companion$DnsSystem) this.zzb.zzav()).getClass();
            this.zzd = System.currentTimeMillis();
            if (!zzf().postDelayed(this.zzc, j)) {
                this.zzb.zzay().zzd.zzb(Long.valueOf(j), "Failed to schedule delayed post. time");
            }
        }
    }

    public final Handler zzf() {
        com.google.android.gms.internal.measurement.zzby zzbyVar;
        if (zza != null) {
            return zza;
        }
        synchronized (zzap.class) {
            if (zza == null) {
                zza = new com.google.android.gms.internal.measurement.zzby(this.zzb.zzau().getMainLooper());
            }
            zzbyVar = zza;
        }
        return zzbyVar;
    }
}
