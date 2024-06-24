package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzip extends AbstractList implements zzkm {
    public boolean zza = true;

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        zzbT();
        return super.add(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r1, Collection collection) {
        zzbT();
        return super.addAll(r1, collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        zzbT();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int r3 = 0; r3 < size; r3++) {
            if (!get(r3).equals(list.get(r3))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int r1 = 1;
        for (int r2 = 0; r2 < size; r2++) {
            r1 = (r1 * 31) + get(r2).hashCode();
        }
        return r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract Object remove(int r1);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbT();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        zzbT();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        zzbT();
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final void zzb() {
        this.zza = false;
    }

    public final void zzbT() {
        if (this.zza) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final boolean zzc() {
        return this.zza;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        zzbT();
        return super.addAll(collection);
    }
}
