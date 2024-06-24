package com.google.android.gms.internal.fitness;

import com.animaconnected.firebase.AnalyticsConstants;
import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfm extends zzfj implements List, RandomAccess {
    public static final zzfk zza = new zzfk(zzfq.zza, 0);

    @Override // java.util.List
    @Deprecated
    public final void add(int r1, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int r1, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.fitness.zzfj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int r3 = 0; r3 < size; r3++) {
                        Object obj2 = get(r3);
                        Object obj3 = list.get(r3);
                        if (obj2 != obj3 && (obj2 == null || !obj2.equals(obj3))) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                        }
                    }
                    return true;
                }
                zzfk listIterator = listIterator(0);
                Iterator it = list.iterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = listIterator.next();
                        Object next2 = it.next();
                        if (next != next2 && (next == null || !next.equals(next2))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int r1 = 1;
        for (int r2 = 0; r2 < size; r2++) {
            r1 = (r1 * 31) + get(r2).hashCode();
        }
        return r1;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int r2 = 0; r2 < size; r2++) {
            if (obj.equals(get(r2))) {
                return r2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int r1, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public void zza(Object[] objArr) {
        int size = size();
        for (int r1 = 0; r1 < size; r1++) {
            objArr[r1] = get(r1);
        }
    }

    @Override // java.util.List
    /* renamed from: zzf */
    public zzfm subList(int r2, int r3) {
        Objects.zzc(r2, r3, size());
        int r32 = r3 - r2;
        if (r32 == size()) {
            return this;
        }
        if (r32 == 0) {
            return zzfq.zza;
        }
        return new zzfl(this, r2, r32);
    }

    @Override // java.util.List
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final zzfk listIterator(int r4) {
        int size = size();
        if (r4 >= 0 && r4 <= size) {
            if (isEmpty()) {
                return zza;
            }
            return new zzfk(this, r4);
        }
        throw new IndexOutOfBoundsException(Objects.zzd(r4, size, AnalyticsConstants.KEY_INDEX));
    }
}
