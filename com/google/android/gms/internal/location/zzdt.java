package com.google.android.gms.internal.location;

import androidx.compose.ui.graphics.ShadowKt;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public final class zzdt extends zzds {
    public static final zzdt zza = new zzdt(0, new Object[0]);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzdt(int r1, Object[] objArr) {
        this.zzb = objArr;
        this.zzc = r1;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        ShadowKt.zza(r2, this.zzc);
        Object obj = this.zzb[r2];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzds, com.google.android.gms.internal.location.zzdp
    public final void zza(Object[] objArr) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final Object[] zzg() {
        return this.zzb;
    }
}
