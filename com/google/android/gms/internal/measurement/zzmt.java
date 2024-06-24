package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmt extends AbstractList implements RandomAccess, zzku {
    public final zzku zza;

    public zzmt(zzku zzkuVar) {
        this.zza = zzkuVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int r2) {
        return ((zzkt) this.zza).get(r2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzms(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int r2) {
        return new zzmr(this, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final Object zzf(int r2) {
        return this.zza.zzf(r2);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final void zzi(zzje zzjeVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final zzku zze() {
        return this;
    }
}
