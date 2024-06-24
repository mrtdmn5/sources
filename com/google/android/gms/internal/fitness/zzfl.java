package com.google.android.gms.internal.fitness;

import com.google.common.base.Objects;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzfl extends zzfm {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzfm zzc;

    public zzfl(zzfm zzfmVar, int r2, int r3) {
        this.zzc = zzfmVar;
        this.zza = r2;
        this.zzb = r3;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        Objects.zza(r2, this.zzb);
        return this.zzc.get(r2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.fitness.zzfm, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzfm subList(int r2, int r3) {
        Objects.zzc(r2, r3, this.zzb);
        int r0 = this.zza;
        return this.zzc.subList(r2 + r0, r3 + r0);
    }
}
