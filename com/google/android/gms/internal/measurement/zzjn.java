package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjn {
    public final zzjm zza;

    public zzjn(zzjj zzjjVar) {
        Charset charset = zzkn.zzb;
        this.zza = zzjjVar;
        zzjjVar.zza = this;
    }

    public final void zzA(int r2, int r3) throws IOException {
        this.zza.zzp(r2, (r3 >> 31) ^ (r3 + r3));
    }

    public final void zzC(int r4, long j) throws IOException {
        this.zza.zzr(r4, (j >> 63) ^ (j + j));
    }

    public final void zzH(int r2, int r3) throws IOException {
        this.zza.zzp(r2, r3);
    }

    public final void zzJ(int r2, long j) throws IOException {
        this.zza.zzr(r2, j);
    }

    public final void zzb(int r2, boolean z) throws IOException {
        this.zza.zzd(r2, z);
    }

    public final void zzd(int r2, zzje zzjeVar) throws IOException {
        this.zza.zze(r2, zzjeVar);
    }

    public final void zzf(int r2, double d) throws IOException {
        this.zza.zzh(r2, Double.doubleToRawLongBits(d));
    }

    public final void zzi(int r2, int r3) throws IOException {
        this.zza.zzj(r2, r3);
    }

    public final void zzk(int r2, int r3) throws IOException {
        this.zza.zzf(r2, r3);
    }

    public final void zzm(int r2, long j) throws IOException {
        this.zza.zzh(r2, j);
    }

    public final void zzo(float f, int r3) throws IOException {
        this.zza.zzf(r3, Float.floatToRawIntBits(f));
    }

    public final void zzq(int r3, zzlx zzlxVar, Object obj) throws IOException {
        zzjm zzjmVar = this.zza;
        zzjmVar.zzo(r3, 3);
        zzlxVar.zzi((zzlm) obj, zzjmVar.zza);
        zzjmVar.zzo(r3, 4);
    }

    public final void zzr(int r2, int r3) throws IOException {
        this.zza.zzj(r2, r3);
    }

    public final void zzt(int r2, long j) throws IOException {
        this.zza.zzr(r2, j);
    }

    public final void zzv(int r2, zzlx zzlxVar, Object obj) throws IOException {
        zzlm zzlmVar = (zzlm) obj;
        zzjj zzjjVar = (zzjj) this.zza;
        zzjjVar.zzq((r2 << 3) | 2);
        zzjjVar.zzq(((zzio) zzlmVar).zzbr(zzlxVar));
        zzlxVar.zzi(zzlmVar, zzjjVar.zza);
    }

    public final void zzw(int r2, int r3) throws IOException {
        this.zza.zzf(r2, r3);
    }

    public final void zzy(int r2, long j) throws IOException {
        this.zza.zzh(r2, j);
    }
}
