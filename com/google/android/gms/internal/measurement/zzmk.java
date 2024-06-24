package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public class zzmk extends AbstractMap {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int zza;
    public boolean zzd;
    public volatile zzmi zze;
    public List zzb = Collections.emptyList();
    public Map zzc = Collections.emptyMap();
    public Map zzf = Collections.emptyMap();

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (zzk(comparable) < 0 && !this.zzc.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zze == null) {
            this.zze = new zzmi(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmk)) {
            return super.equals(obj);
        }
        zzmk zzmkVar = (zzmk) obj;
        int size = size();
        if (size != zzmkVar.size()) {
            return false;
        }
        int zzb = zzb();
        if (zzb == zzmkVar.zzb()) {
            for (int r4 = 0; r4 < zzb; r4++) {
                if (!((Map.Entry) this.zzb.get(r4)).equals((Map.Entry) zzmkVar.zzb.get(r4))) {
                    return false;
                }
            }
            if (zzb == size) {
                return true;
            }
            return this.zzc.equals(zzmkVar.zzc);
        }
        return entrySet().equals(zzmkVar.entrySet());
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzme) this.zzb.get(zzk)).zzc;
        }
        return this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int zzb = zzb();
        int r2 = 0;
        for (int r1 = 0; r1 < zzb; r1++) {
            r2 += ((zzme) this.zzb.get(r1)).hashCode();
        }
        if (this.zzc.size() > 0) {
            return this.zzc.hashCode() + r2;
        }
        return r2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzc.size() + this.zzb.size();
    }

    public void zza() {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = unmodifiableMap;
            if (this.zzf.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = unmodifiableMap2;
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return ((zzme) this.zzb.get(zzk)).setValue(obj);
        }
        zzn();
        boolean isEmpty = this.zzb.isEmpty();
        int r2 = this.zza;
        if (isEmpty && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(r2);
        }
        int r0 = -(zzk + 1);
        if (r0 >= r2) {
            return zzm().put(comparable, obj);
        }
        if (this.zzb.size() == r2) {
            zzme zzmeVar = (zzme) this.zzb.remove(r2 - 1);
            zzm().put(zzmeVar.zzb, zzmeVar.zzc);
        }
        this.zzb.add(r0, new zzme(this, comparable, obj));
        return null;
    }

    public final int zzk(Comparable comparable) {
        int size = this.zzb.size() - 1;
        int r1 = 0;
        if (size >= 0) {
            int compareTo = comparable.compareTo(((zzme) this.zzb.get(size)).zzb);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (r1 <= size) {
            int r2 = (r1 + size) / 2;
            int compareTo2 = comparable.compareTo(((zzme) this.zzb.get(r2)).zzb);
            if (compareTo2 < 0) {
                size = r2 - 1;
            } else if (compareTo2 > 0) {
                r1 = r2 + 1;
            } else {
                return r2;
            }
        }
        return -(r1 + 1);
    }

    public final Object zzl(int r6) {
        zzn();
        Object obj = ((zzme) this.zzb.remove(r6)).zzc;
        if (!this.zzc.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zzb;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzme(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return obj;
    }

    public final SortedMap zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    public final void zzn() {
        if (!this.zzd) {
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
