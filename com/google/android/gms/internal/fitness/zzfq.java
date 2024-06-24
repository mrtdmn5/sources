package com.google.android.gms.internal.fitness;

import com.google.common.base.Objects;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzfq extends zzfm {
    public static final zzfq zza = new zzfq(0, new Object[0]);
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzfq(int r1, Object[] objArr) {
        this.zzb = objArr;
        this.zzc = r1;
    }

    @Override // java.util.List
    public final Object get(int r2) {
        Objects.zza(r2, this.zzc);
        Object obj = this.zzb[r2];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fitness.zzfm, com.google.android.gms.internal.fitness.zzfj
    public final void zza(Object[] objArr) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final Object[] zze() {
        return this.zzb;
    }
}
