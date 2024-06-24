package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbz;
import com.google.android.gms.internal.measurement.zzcn;
import com.google.android.gms.internal.measurement.zzco;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdc;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzhy;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzd implements zzhy {
    public final /* synthetic */ zzef zza;

    public zzd(zzef zzefVar) {
        this.zza = zzefVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final int zza(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final long zzb() {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzbz zzbzVar = new zzbz();
        zzefVar.zzV(new zzdc(zzefVar, zzbzVar));
        Long l = (Long) zzbz.zzf(zzbzVar.zzb(500L), Long.class);
        if (l == null) {
            long nanoTime = System.nanoTime();
            zzefVar.zza.getClass();
            long nextLong = new Random(nanoTime ^ System.currentTimeMillis()).nextLong();
            int r3 = zzefVar.zzg + 1;
            zzefVar.zzg = r3;
            return nextLong + r3;
        }
        return l.longValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzh() {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzbz zzbzVar = new zzbz();
        zzefVar.zzV(new zzdb(zzefVar, zzbzVar));
        return zzbzVar.zzd(50L);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzi() {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzbz zzbzVar = new zzbz();
        zzefVar.zzV(new zzde(zzefVar, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzj() {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzbz zzbzVar = new zzbz();
        zzefVar.zzV(new zzdd(zzefVar, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final String zzk() {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzbz zzbzVar = new zzbz();
        zzefVar.zzV(new zzda(zzefVar, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final List zzm(String str, String str2) {
        return this.zza.zzq(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final Map zzo(String str, String str2, boolean z) {
        return this.zza.zzr(str, str2, z);
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzp(String str) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzcy(zzefVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzq(String str, String str2, Bundle bundle) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzco(zzefVar, str, str2, bundle));
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzr(String str) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzcz(zzefVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzs(String str, String str2, Bundle bundle) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzds(zzefVar, str, str2, bundle, true));
    }

    @Override // com.google.android.gms.measurement.internal.zzhy
    public final void zzv(Bundle bundle) {
        zzef zzefVar = this.zza;
        zzefVar.getClass();
        zzefVar.zzV(new zzcn(zzefVar, bundle));
    }
}
