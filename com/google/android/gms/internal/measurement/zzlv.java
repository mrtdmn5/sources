package com.google.android.gms.internal.measurement;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlv extends zzip implements RandomAccess {
    public static final zzlv zza;
    public Object[] zzb;
    public int zzc;

    static {
        zzlv zzlvVar = new zzlv(0, new Object[0]);
        zza = zzlvVar;
        zzlvVar.zza = false;
    }

    public zzlv(int r1, Object[] objArr) {
        this.zzb = objArr;
        this.zzc = r1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r6, Object obj) {
        int r0;
        zzbT();
        if (r6 >= 0 && r6 <= (r0 = this.zzc)) {
            Object[] objArr = this.zzb;
            if (r0 < objArr.length) {
                System.arraycopy(objArr, r6, objArr, r6 + 1, r0 - r6);
            } else {
                Object[] objArr2 = new Object[OpaqueKey$$ExternalSyntheticOutline0.m(r0, 3, 2, 1)];
                System.arraycopy(objArr, 0, objArr2, 0, r6);
                System.arraycopy(this.zzb, r6, objArr2, r6 + 1, this.zzc - r6);
                this.zzb = objArr2;
            }
            this.zzb[r6] = obj;
            this.zzc++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r6, ", Size:", this.zzc));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r2) {
        zzg(r2);
        return this.zzb[r2];
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final Object remove(int r5) {
        zzbT();
        zzg(r5);
        Object[] objArr = this.zzb;
        Object obj = objArr[r5];
        if (r5 < this.zzc - 1) {
            System.arraycopy(objArr, r5 + 1, objArr, r5, (r2 - r5) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object obj) {
        zzbT();
        zzg(r3);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[r3];
        objArr[r3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int r3) {
        if (r3 >= this.zzc) {
            return new zzlv(this.zzc, Arrays.copyOf(this.zzb, r3));
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(int r5) {
        if (r5 >= 0 && r5 < this.zzc) {
        } else {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Index:", r5, ", Size:", this.zzc));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzbT();
        int r0 = this.zzc;
        Object[] objArr = this.zzb;
        if (r0 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((r0 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int r1 = this.zzc;
        this.zzc = r1 + 1;
        objArr2[r1] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
