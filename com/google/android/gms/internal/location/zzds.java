package com.google.android.gms.internal.location;

import androidx.compose.ui.graphics.ShadowKt;
import androidx.compose.ui.text.font.FontWeightKt;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes3.dex */
public abstract class zzds extends zzdp implements List, RandomAccess {
    public static final zzdq zza = new zzdq(zzdt.zza, 0);

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

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (list instanceof RandomAccess) {
                for (int r2 = 0; r2 < size; r2++) {
                    if (!FontWeightKt.zza(get(r2), list.get(r2))) {
                        return false;
                    }
                }
            } else {
                zzdq listIterator = listIterator(0);
                Iterator it = list.iterator();
                while (listIterator.hasNext()) {
                    if (!it.hasNext() || !FontWeightKt.zza(listIterator.next(), it.next())) {
                        return false;
                    }
                }
                if (it.hasNext()) {
                    return false;
                }
            }
        }
        return true;
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

    @Override // com.google.android.gms.internal.location.zzdp, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.location.zzdp
    public void zza(Object[] objArr) {
        int size = size();
        for (int r1 = 0; r1 < size; r1++) {
            objArr[r1] = get(r1);
        }
    }

    @Override // com.google.android.gms.internal.location.zzdp
    /* renamed from: zze */
    public final zzdq iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public zzds subList(int r2, int r3) {
        ShadowKt.zzc(r2, r3, size());
        int r32 = r3 - r2;
        if (r32 == size()) {
            return this;
        }
        if (r32 == 0) {
            return zzdt.zza;
        }
        return new zzdr(this, r2, r32);
    }

    @Override // java.util.List
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final zzdq listIterator(int r4) {
        int size = size();
        if (r4 >= 0 && r4 <= size) {
            if (isEmpty()) {
                return zza;
            }
            return new zzdq(this, r4);
        }
        throw new IndexOutOfBoundsException(ShadowKt.zzd(r4, size, AnalyticsConstants.KEY_INDEX));
    }

    @Override // com.google.android.gms.internal.location.zzdp
    @Deprecated
    public final zzds zzd() {
        return this;
    }
}
