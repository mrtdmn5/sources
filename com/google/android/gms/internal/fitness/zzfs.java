package com.google.android.gms.internal.fitness;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzfs extends zzfn {
    public final transient Object zza;

    public zzfs(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.fitness.zzfn, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.fitness.zzfn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return new zzfo(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.zza.toString() + ']';
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final void zza(Object[] objArr) {
        objArr[0] = this.zza;
    }

    @Override // com.google.android.gms.internal.fitness.zzfn
    /* renamed from: zzd */
    public final zzft iterator() {
        return new zzfo(this.zza);
    }
}
