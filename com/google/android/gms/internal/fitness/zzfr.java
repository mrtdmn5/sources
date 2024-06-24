package com.google.android.gms.internal.fitness;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzfr extends zzfn {
    public static final zzfr zza;
    public static final Object[] zzd;
    public final transient Object[] zzb;
    public final transient Object[] zzc;
    public final transient int zze;
    public final transient int zzf;
    public final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzfr(0, 0, 0, objArr, objArr);
    }

    public zzfr(int r1, int r2, int r3, Object[] objArr, Object[] objArr2) {
        this.zzb = objArr;
        this.zze = r1;
        this.zzc = objArr2;
        this.zzf = r2;
        this.zzg = r3;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int rotateLeft = (int) (Integer.rotateLeft((int) (obj.hashCode() * (-862048943)), 15) * 461845907);
                while (true) {
                    int r2 = rotateLeft & this.zzf;
                    Object obj2 = objArr[r2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    rotateLeft = r2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fitness.zzfn, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.fitness.zzfn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfm zzfmVar = this.zza;
        if (zzfmVar == null) {
            zzfmVar = zzh();
            this.zza = zzfmVar;
        }
        return zzfmVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final void zza(Object[] objArr) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fitness.zzfn
    /* renamed from: zzd */
    public final zzft iterator() {
        zzfm zzfmVar = this.zza;
        if (zzfmVar == null) {
            zzfmVar = zzh();
            this.zza = zzfmVar;
        }
        return zzfmVar.listIterator(0);
    }

    @Override // com.google.android.gms.internal.fitness.zzfj
    public final Object[] zze() {
        return this.zzb;
    }

    public final zzfq zzh() {
        zzfk zzfkVar = zzfm.zza;
        int r0 = this.zzg;
        if (r0 == 0) {
            return zzfq.zza;
        }
        return new zzfq(r0, this.zzb);
    }
}
