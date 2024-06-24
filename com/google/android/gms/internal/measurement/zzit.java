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
public final class zzit extends zzip implements RandomAccess, zzlt {
    public boolean[] zzb;
    public int zzc;

    static {
        new zzit(new boolean[0], 0).zza = false;
    }

    public zzit() {
        this(new boolean[10], 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbT();
        if (r6 >= 0 && r6 <= (r0 = this.zzc)) {
            boolean[] zArr = this.zzb;
            if (r0 < zArr.length) {
                System.arraycopy(zArr, r6, zArr, r6 + 1, r0 - r6);
            } else {
                boolean[] zArr2 = new boolean[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(zArr, 0, zArr2, 0, r6);
                System.arraycopy(this.zzb, r6, zArr2, r6 + 1, this.zzc - r6);
                this.zzb = zArr2;
            }
            this.zzb[r6] = booleanValue;
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
        if (!(collection instanceof zzit)) {
            return super.addAll(collection);
        }
        zzit zzitVar = (zzit) collection;
        int r0 = zzitVar.zzc;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.zzc;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            boolean[] zArr = this.zzb;
            if (r22 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, r22);
            }
            System.arraycopy(zzitVar.zzb, 0, this.zzb, this.zzc, zzitVar.zzc);
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
        if (!(obj instanceof zzit)) {
            return super.equals(obj);
        }
        zzit zzitVar = (zzit) obj;
        if (this.zzc != zzitVar.zzc) {
            return false;
        }
        boolean[] zArr = zzitVar.zzb;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            if (this.zzb[r1] != zArr[r1]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int r2) {
        zzg(r2);
        return Boolean.valueOf(this.zzb[r2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r2;
        int r0 = 1;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            int r02 = r0 * 31;
            boolean z = this.zzb[r1];
            Charset charset = zzkn.zzb;
            if (z) {
                r2 = 1231;
            } else {
                r2 = 1237;
            }
            r0 = r02 + r2;
        }
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int r0 = this.zzc;
        for (int r2 = 0; r2 < r0; r2++) {
            if (this.zzb[r2] == booleanValue) {
                return r2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r5) {
        zzbT();
        zzg(r5);
        boolean[] zArr = this.zzb;
        boolean z = zArr[r5];
        if (r5 < this.zzc - 1) {
            System.arraycopy(zArr, r5 + 1, zArr, r5, (r2 - r5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        zzbT();
        if (r4 >= r3) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, r4, zArr, r3, this.zzc - r4);
            this.zzc -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r3, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbT();
        zzg(r3);
        boolean[] zArr = this.zzb;
        boolean z = zArr[r3];
        zArr[r3] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzit(Arrays.copyOf(this.zzb, r3), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z) {
        zzbT();
        int r0 = this.zzc;
        boolean[] zArr = this.zzb;
        if (r0 == zArr.length) {
            boolean[] zArr2 = new boolean[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, r0);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int r1 = this.zzc;
        this.zzc = r1 + 1;
        zArr3[r1] = z;
    }

    public final void zzg(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    public zzit(boolean[] zArr, int r2) {
        this.zzb = zArr;
        this.zzc = r2;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }
}
