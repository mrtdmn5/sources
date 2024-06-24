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
public final class zzlb extends zzip implements RandomAccess, zzkl, zzlt {
    public static final zzlb zza;
    public long[] zzb;
    public int zzc;

    static {
        zzlb zzlbVar = new zzlb(new long[0], 0);
        zza = zzlbVar;
        zzlbVar.zza = false;
    }

    public zzlb() {
        this(new long[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r7, Object obj) {
        int r8;
        long longValue = ((Long) obj).longValue();
        zzbT();
        if (r7 >= 0 && r7 <= (r8 = this.zzc)) {
            long[] jArr = this.zzb;
            if (r8 < jArr.length) {
                System.arraycopy(jArr, r7, jArr, r7 + 1, r8 - r7);
            } else {
                long[] jArr2 = new long[OpaqueKey$$ExternalSyntheticOutline0.m(r8, 3, 2, 1)];
                System.arraycopy(jArr, 0, jArr2, 0, r7);
                System.arraycopy(this.zzb, r7, jArr2, r7 + 1, this.zzc - r7);
                this.zzb = jArr2;
            }
            this.zzb[r7] = longValue;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r7, ", Size:", this.zzc));
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbT();
        Charset charset = zzkn.zzb;
        collection.getClass();
        if (!(collection instanceof zzlb)) {
            return super.addAll(collection);
        }
        zzlb zzlbVar = (zzlb) collection;
        int r0 = zzlbVar.zzc;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.zzc;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            long[] jArr = this.zzb;
            if (r22 > jArr.length) {
                this.zzb = Arrays.copyOf(jArr, r22);
            }
            System.arraycopy(zzlbVar.zzb, 0, this.zzb, this.zzc, zzlbVar.zzc);
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
        if (!(obj instanceof zzlb)) {
            return super.equals(obj);
        }
        zzlb zzlbVar = (zzlb) obj;
        if (this.zzc != zzlbVar.zzc) {
            return false;
        }
        long[] jArr = zzlbVar.zzb;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            if (this.zzb[r1] != jArr[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int r4) {
        zzi(r4);
        return Long.valueOf(this.zzb[r4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            r0 = (r0 * 31) + zzkn.zzc(this.zzb[r1]);
        }
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int r8 = this.zzc;
        for (int r0 = 0; r0 < r8; r0++) {
            if (this.zzb[r0] == longValue) {
                return r0;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r6) {
        zzbT();
        zzi(r6);
        long[] jArr = this.zzb;
        long j = jArr[r6];
        if (r6 < this.zzc - 1) {
            System.arraycopy(jArr, r6 + 1, jArr, r6, (r3 - r6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        zzbT();
        if (r4 >= r3) {
            long[] jArr = this.zzb;
            System.arraycopy(jArr, r4, jArr, r3, this.zzc - r4);
            this.zzc -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r5, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbT();
        zzi(r5);
        long[] jArr = this.zzb;
        long j = jArr[r5];
        jArr[r5] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzlb(Arrays.copyOf(this.zzb, r3), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(long j) {
        zzbT();
        int r0 = this.zzc;
        long[] jArr = this.zzb;
        if (r0 == jArr.length) {
            long[] jArr2 = new long[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(jArr, 0, jArr2, 0, r0);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int r1 = this.zzc;
        this.zzc = r1 + 1;
        jArr3[r1] = j;
    }

    public final void zzi(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    public zzlb(long[] jArr, int r2) {
        this.zzb = jArr;
        this.zzc = r2;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }
}
