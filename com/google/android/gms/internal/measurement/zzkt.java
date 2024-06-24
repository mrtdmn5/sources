package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkt extends zzip implements RandomAccess, zzku {
    public final ArrayList zzc;

    static {
        new zzkt(10).zza = false;
    }

    public zzkt() {
        this(10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int r2, Object obj) {
        zzbT();
        this.zzc.add(r2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final boolean addAll(int r2, Collection collection) {
        zzbT();
        if (collection instanceof zzku) {
            collection = ((zzku) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(r2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbT();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final Object remove(int r3) {
        zzbT();
        Object remove = this.zzc.remove(r3);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (remove instanceof zzje) {
            zzje zzjeVar = (zzje) remove;
            Charset charset = zzkn.zzb;
            if (zzjeVar.zzd() == 0) {
                return "";
            }
            return zzjeVar.zzg(charset);
        }
        return new String((byte[]) remove, zzkn.zzb);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r2, Object obj) {
        zzbT();
        Object obj2 = this.zzc.set(r2, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (obj2 instanceof zzje) {
            zzje zzjeVar = (zzje) obj2;
            Charset charset = zzkn.zzb;
            if (zzjeVar.zzd() == 0) {
                return "";
            }
            return zzjeVar.zzg(charset);
        }
        return new String((byte[]) obj2, zzkn.zzb);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int r2) {
        if (r2 >= size()) {
            ArrayList arrayList = new ArrayList(r2);
            arrayList.addAll(this.zzc);
            return new zzkt(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final zzku zze() {
        if (this.zza) {
            return new zzmt(this);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final Object zzf(int r2) {
        return this.zzc.get(r2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg */
    public final String get(int r6) {
        String zzg;
        ArrayList arrayList = this.zzc;
        Object obj = arrayList.get(r6);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzje) {
            zzje zzjeVar = (zzje) obj;
            Charset charset = zzkn.zzb;
            if (zzjeVar.zzd() == 0) {
                zzg = "";
            } else {
                zzg = zzjeVar.zzg(charset);
            }
            if (zzjeVar.zzi()) {
                arrayList.set(r6, zzg);
            }
            return zzg;
        }
        byte[] bArr = (byte[]) obj;
        String str = new String(bArr, zzkn.zzb);
        zznb zznbVar = zznd.zza;
        int length = bArr.length;
        zznbVar.getClass();
        if (zzna.zzb(bArr, 0, length)) {
            arrayList.set(r6, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final void zzi(zzje zzjeVar) {
        zzbT();
        this.zzc.add(zzjeVar);
        ((AbstractList) this).modCount++;
    }

    public zzkt(int r2) {
        this.zzc = new ArrayList(r2);
    }

    public zzkt(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
