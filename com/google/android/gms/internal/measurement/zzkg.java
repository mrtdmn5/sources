package com.google.android.gms.internal.measurement;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkg extends zzip implements RandomAccess, zzkk, zzlt {
    public static final zzkg zza;
    public int[] zzb;
    public int zzc;

    static {
        zzkg zzkgVar = new zzkg(new int[0], 0);
        zza = zzkgVar;
        zzkgVar.zza = false;
    }

    public zzkg() {
        this(new int[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        int intValue = ((Integer) obj).intValue();
        zzbT();
        if (r6 >= 0 && r6 <= (r0 = this.zzc)) {
            int[] r1 = this.zzb;
            if (r0 < r1.length) {
                System.arraycopy(r1, r6, r1, r6 + 1, r0 - r6);
            } else {
                int[] r02 = new int[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(r1, 0, r02, 0, r6);
                System.arraycopy(this.zzb, r6, r02, r6 + 1, this.zzc - r6);
                this.zzb = r02;
            }
            this.zzb[r6] = intValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:", this.zzc));
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbT();
        Charset charset = zzkn.zzb;
        collection.getClass();
        if (!(collection instanceof zzkg)) {
            return super.addAll(collection);
        }
        zzkg zzkgVar = (zzkg) collection;
        int r0 = zzkgVar.zzc;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.zzc;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            int[] r02 = this.zzb;
            if (r22 > r02.length) {
                this.zzb = Arrays.copyOf(r02, r22);
            }
            System.arraycopy(zzkgVar.zzb, 0, this.zzb, this.zzc, zzkgVar.zzc);
            this.zzc = r22;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkg)) {
            return super.equals(obj);
        }
        zzkg zzkgVar = (zzkg) obj;
        if (this.zzc != zzkgVar.zzc) {
            return false;
        }
        int[] r6 = zzkgVar.zzb;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            if (this.zzb[r1] != r6[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int r2) {
        zzj(r2);
        return Integer.valueOf(this.zzb[r2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            r0 = (r0 * 31) + this.zzb[r1];
        }
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int r0 = this.zzc;
        for (int r2 = 0; r2 < r0; r2++) {
            if (this.zzb[r2] == intValue) {
                return r2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r5) {
        zzbT();
        zzj(r5);
        int[] r0 = this.zzb;
        int r1 = r0[r5];
        if (r5 < this.zzc - 1) {
            System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(r1);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        zzbT();
        if (r4 >= r3) {
            int[] r0 = this.zzb;
            System.arraycopy(r0, r4, r0, r3, this.zzc - r4);
            this.zzc -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r3, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbT();
        zzj(r3);
        int[] r0 = this.zzb;
        int r1 = r0[r3];
        r0[r3] = intValue;
        return Integer.valueOf(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzkg(Arrays.copyOf(this.zzb, r3), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(int r6) {
        zzbT();
        int r0 = this.zzc;
        int[] r1 = this.zzb;
        if (r0 == r1.length) {
            int[] r2 = new int[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(r1, 0, r2, 0, r0);
            this.zzb = r2;
        }
        int[] r02 = this.zzb;
        int r12 = this.zzc;
        this.zzc = r12 + 1;
        r02[r12] = r6;
    }

    public final void zzj(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    public zzkg(int[] r1, int r2) {
        this.zzb = r1;
        this.zzc = r2;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
