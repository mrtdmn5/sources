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
public final class zzjy extends zzip implements RandomAccess, zzlt {
    public float[] zzb;
    public int zzc;

    static {
        new zzjy(0, new float[0]).zza = false;
    }

    public zzjy() {
        this(0, new float[10]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        float floatValue = ((Float) obj).floatValue();
        zzbT();
        if (r6 >= 0 && r6 <= (r0 = this.zzc)) {
            float[] fArr = this.zzb;
            if (r0 < fArr.length) {
                System.arraycopy(fArr, r6, fArr, r6 + 1, r0 - r6);
            } else {
                float[] fArr2 = new float[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(fArr, 0, fArr2, 0, r6);
                System.arraycopy(this.zzb, r6, fArr2, r6 + 1, this.zzc - r6);
                this.zzb = fArr2;
            }
            this.zzb[r6] = floatValue;
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
        if (!(collection instanceof zzjy)) {
            return super.addAll(collection);
        }
        zzjy zzjyVar = (zzjy) collection;
        int r0 = zzjyVar.zzc;
        if (r0 == 0) {
            return false;
        }
        int r2 = this.zzc;
        if (Integer.MAX_VALUE - r2 >= r0) {
            int r22 = r2 + r0;
            float[] fArr = this.zzb;
            if (r22 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, r22);
            }
            System.arraycopy(zzjyVar.zzb, 0, this.zzb, this.zzc, zzjyVar.zzc);
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
        if (!(obj instanceof zzjy)) {
            return super.equals(obj);
        }
        zzjy zzjyVar = (zzjy) obj;
        if (this.zzc != zzjyVar.zzc) {
            return false;
        }
        float[] fArr = zzjyVar.zzb;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            if (Float.floatToIntBits(this.zzb[r1]) != Float.floatToIntBits(fArr[r1])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int r2) {
        zzg(r2);
        return Float.valueOf(this.zzb[r2]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int r0 = 1;
        for (int r1 = 0; r1 < this.zzc; r1++) {
            r0 = (r0 * 31) + Float.floatToIntBits(this.zzb[r1]);
        }
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int r0 = this.zzc;
        for (int r2 = 0; r2 < r0; r2++) {
            if (this.zzb[r2] == floatValue) {
                return r2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int r5) {
        zzbT();
        zzg(r5);
        float[] fArr = this.zzb;
        float f = fArr[r5];
        if (r5 < this.zzc - 1) {
            System.arraycopy(fArr, r5 + 1, fArr, r5, (r2 - r5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int r3, int r4) {
        zzbT();
        if (r4 >= r3) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, r4, fArr, r3, this.zzc - r4);
            this.zzc -= r4 - r3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int r3, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbT();
        zzg(r3);
        float[] fArr = this.zzb;
        float f = fArr[r3];
        fArr[r3] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzjy(this.zzc, Arrays.copyOf(this.zzb, r3));
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f) {
        zzbT();
        int r0 = this.zzc;
        float[] fArr = this.zzb;
        if (r0 == fArr.length) {
            float[] fArr2 = new float[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
            System.arraycopy(fArr, 0, fArr2, 0, r0);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int r1 = this.zzc;
        this.zzc = r1 + 1;
        fArr3[r1] = f;
    }

    public final void zzg(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    public zzjy(int r1, float[] fArr) {
        this.zzb = fArr;
        this.zzc = r1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }
}
