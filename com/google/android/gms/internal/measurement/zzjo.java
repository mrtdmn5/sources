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
public final class zzjo extends zzip implements RandomAccess, zzlt {
    public double[] zzb;
    public int zzc;

    static {
        new zzjo(0, new double[0]).zza = false;
    }

    public zzjo() {
        this(0, new double[10]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r7, Object obj) {
        int r8;
        double doubleValue = ((Double) obj).doubleValue();
        zzbT();
        if (r7 >= 0 && r7 <= (r8 = this.zzc)) {
            double[] dArr = this.zzb;
            if (r8 < dArr.length) {
                System.arraycopy(dArr, r7, dArr, r7 + 1, r8 - r7);
            } else {
                double[] dArr2 = new double[OpaqueKey$$ExternalSyntheticOutline0.m(r8, 3, 2, 1)];
                System.arraycopy(dArr, 0, dArr2, 0, r7);
                System.arraycopy(this.zzb, r7, dArr2, r7 + 1, this.zzc - r7);
                this.zzb = dArr2;
            }
            this.zzb[r7] = doubleValue;
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
        if (!(collection instanceof zzjo)) {
            return super.addAll(collection);
        }
        zzjo zzjoVar = (zzjo) collection;
        int r0 = zzjoVar.zzc;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.zzc;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            double[] dArr = this.zzb;
            if (r22 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, r22);
            }
            System.arraycopy(zzjoVar.zzb, 0, this.zzb, this.zzc, zzjoVar.zzc);
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
        if (!(obj instanceof zzjo)) {
            return super.equals(obj);
        }
        zzjo zzjoVar = (zzjo) obj;
        if (this.zzc != zzjoVar.zzc) {
            return false;
        }
        double[] dArr = zzjoVar.zzb;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            if (Double.doubleToLongBits(this.zzb[r1]) != Double.doubleToLongBits(dArr[r1])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int r4) {
        zzg(r4);
        return Double.valueOf(this.zzb[r4]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            r0 = (r0 * 31) + zzkn.zzc(Double.doubleToLongBits(this.zzb[r1]));
        }
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int r8 = this.zzc;
        for (int r0 = 0; r0 < r8; r0++) {
            if (this.zzb[r0] == doubleValue) {
                return r0;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r6) {
        zzbT();
        zzg(r6);
        double[] dArr = this.zzb;
        double d = dArr[r6];
        if (r6 < this.zzc - 1) {
            System.arraycopy(dArr, r6 + 1, dArr, r6, (r3 - r6) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        zzbT();
        if (r4 >= r3) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, r4, dArr, r3, this.zzc - r4);
            this.zzc -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r5, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbT();
        zzg(r5);
        double[] dArr = this.zzb;
        double d = dArr[r5];
        dArr[r5] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzjo(this.zzc, Arrays.copyOf(this.zzb, r3));
        }
        throw new IllegalArgumentException();
    }

    public final void zze(double d) {
        zzbT();
        int r0 = this.zzc;
        double[] dArr = this.zzb;
        if (r0 == dArr.length) {
            double[] dArr2 = new double[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(dArr, 0, dArr2, 0, r0);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int r1 = this.zzc;
        this.zzc = r1 + 1;
        dArr3[r1] = d;
    }

    public final void zzg(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    public zzjo(int r1, double[] dArr) {
        this.zzb = dArr;
        this.zzc = r1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
