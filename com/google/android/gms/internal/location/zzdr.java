package com.google.android.gms.internal.location;

import androidx.compose.ui.graphics.ShadowKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzdr extends zzds {
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzds zzc;

    public zzdr(zzds zzdsVar, int r2, int r3) {
        this.zzc = zzdsVar;
        this.zza = r2;
        this.zzb = r3;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        ShadowKt.zza(r2, this.zzb);
        return this.zzc.get(r2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.android.gms.internal.location.zzds, java.util.List
    /* renamed from: zzh */
    public final zzds subList(int r2, int r3) {
        ShadowKt.zzc(r2, r3, this.zzb);
        int r0 = this.zza;
        return this.zzc.subList(r2 + r0, r3 + r0);
    }
}
