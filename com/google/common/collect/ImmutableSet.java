package com.google.common.collect;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public transient ImmutableList<E> asList;

    public static int chooseTableSize(int r5) {
        int max = Math.max(r5, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        if (z) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static <E> ImmutableSet<E> construct(int r13, Object... objArr) {
        if (r13 != 0) {
            boolean z = false;
            if (r13 != 1) {
                int chooseTableSize = chooseTableSize(r13);
                Object[] objArr2 = new Object[chooseTableSize];
                int r5 = chooseTableSize - 1;
                int r4 = 0;
                int r6 = 0;
                for (int r3 = 0; r3 < r13; r3++) {
                    Object obj = objArr[r3];
                    if (obj != null) {
                        int hashCode = obj.hashCode();
                        int smear = Hashing.smear(hashCode);
                        while (true) {
                            int r11 = smear & r5;
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
                            smear++;
                        }
                    } else {
                        throw new NullPointerException(SubMenuBuilder$$ExternalSyntheticOutline0.m("at index ", r3));
                    }
                }
                Arrays.fill(objArr, r6, r13, (Object) null);
                if (r6 == 1) {
                    return new SingletonImmutableSet(r4, objArr[0]);
                }
                if (chooseTableSize(r6) < chooseTableSize / 2) {
                    return construct(r6, objArr);
                }
                int length = objArr.length;
                if (r6 < (length >> 1) + (length >> 2)) {
                    z = true;
                }
                if (z) {
                    objArr = Arrays.copyOf(objArr, r6);
                }
                return new RegularImmutableSet(r4, r5, r6, objArr, objArr2);
            }
            return new SingletonImmutableSet(objArr[0]);
        }
        return RegularImmutableSet.EMPTY;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
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
        for (E e : this) {
            if (e != null) {
                r3 = e.hashCode();
            } else {
                r3 = 0;
            }
            r2 = ~(~(r2 + r3));
        }
        return r2;
    }

    public boolean isHashCodeFast() {
        return this instanceof RegularImmutableSet;
    }
}
