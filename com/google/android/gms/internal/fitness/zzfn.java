package com.google.android.gms.internal.fitness;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public abstract class zzfn extends zzfj implements Set {
    public transient zzfm zza;

    public static int zzf(int r5) {
        int max = Math.max(r5, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (highestOneBit * 0.7d < max);
            return highestOneBit;
        }
        if (max < 1073741824) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static zzfn zzk(int r14, Object... objArr) {
        if (r14 != 0) {
            if (r14 != 1) {
                int zzf = zzf(r14);
                Object[] objArr2 = new Object[zzf];
                int r5 = zzf - 1;
                int r4 = 0;
                int r6 = 0;
                for (int r3 = 0; r3 < r14; r3++) {
                    Object obj = objArr[r3];
                    if (obj != null) {
                        int hashCode = obj.hashCode();
                        int rotateLeft = (int) (Integer.rotateLeft((int) (hashCode * (-862048943)), 15) * 461845907);
                        while (true) {
                            int r11 = rotateLeft & r5;
                            Object obj2 = objArr2[r11];
                            if (obj2 == null) {
                                objArr[r6] = obj;
                                objArr2[r11] = obj;
                                r4 += hashCode;
                                r6++;
                                break;
                            }
                            if (obj2.equals(obj)) {
                                break;
                            }
                            rotateLeft++;
                        }
                    } else {
                        throw new NullPointerException(SubMenuBuilder$$ExternalSyntheticOutline0.m("at index ", r3));
                    }
                }
                Arrays.fill(objArr, r6, r14, (Object) null);
                if (r6 == 1) {
                    Object obj3 = objArr[0];
                    obj3.getClass();
                    return new zzfs(obj3);
                }
                if (zzf(r6) >= zzf / 2) {
                    if (r6 < 3) {
                        objArr = Arrays.copyOf(objArr, r6);
                    }
                    return new zzfr(r4, r5, r6, objArr, objArr2);
                }
                return zzk(r6, objArr);
            }
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzfs(obj4);
        }
        return zzfr.zza;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfn) && (this instanceof zzfr)) {
            zzfn zzfnVar = (zzfn) obj;
            zzfnVar.getClass();
            if ((zzfnVar instanceof zzfr) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int r3;
        int r2 = 0;
        for (Object obj : this) {
            if (obj != null) {
                r3 = obj.hashCode();
            } else {
                r3 = 0;
            }
            r2 += r3;
        }
        return r2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public abstract zzft iterator();
}
