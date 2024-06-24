package androidx.compose.runtime.collection;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdentityArrayMap.kt */
/* loaded from: classes.dex */
public final class IdentityArrayMap<Key, Value> {
    public int size;
    public Object[] keys = new Object[16];
    public Object[] values = new Object[16];

    public final int find(Object obj) {
        Object obj2;
        int identityHashCode = System.identityHashCode(obj);
        int r1 = this.size - 1;
        Object[] objArr = this.keys;
        int r3 = 0;
        while (r3 <= r1) {
            int r4 = (r3 + r1) >>> 1;
            Object obj3 = objArr[r4];
            int identityHashCode2 = System.identityHashCode(obj3);
            if (identityHashCode2 < identityHashCode) {
                r3 = r4 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    if (obj == obj3) {
                        return r4;
                    }
                    Object[] objArr2 = this.keys;
                    int r2 = this.size;
                    for (int r32 = r4 - 1; -1 < r32; r32--) {
                        Object obj4 = objArr2[r32];
                        if (obj4 != obj) {
                            if (System.identityHashCode(obj4) != identityHashCode) {
                                break;
                            }
                        } else {
                            return r32;
                        }
                    }
                    do {
                        r4++;
                        if (r4 < r2) {
                            obj2 = objArr2[r4];
                            if (obj2 == obj) {
                                return r4;
                            }
                        } else {
                            return -(r2 + 1);
                        }
                    } while (System.identityHashCode(obj2) == identityHashCode);
                    return -(r4 + 1);
                }
                r1 = r4 - 1;
            }
        }
        return -(r3 + 1);
    }

    public final Value get(Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int find = find(key);
        if (find >= 0) {
            return (Value) this.values[find];
        }
        return null;
    }

    public final void set(Key key, Value value) {
        boolean z;
        Object[] objArr;
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(key, "key");
        Object[] objArr3 = this.keys;
        Object[] objArr4 = this.values;
        int r2 = this.size;
        int find = find(key);
        if (find >= 0) {
            objArr4[find] = value;
            return;
        }
        int r3 = -(find + 1);
        if (r2 == objArr3.length) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            objArr = new Object[r2 * 2];
        } else {
            objArr = objArr3;
        }
        int r8 = r3 + 1;
        ArraysKt___ArraysJvmKt.copyInto(r8, r3, r2, objArr3, objArr);
        if (z) {
            ArraysKt___ArraysJvmKt.copyInto$default(objArr3, objArr, 0, r3, 6);
        }
        objArr[r3] = key;
        this.keys = objArr;
        if (z) {
            objArr2 = new Object[r2 * 2];
        } else {
            objArr2 = objArr4;
        }
        ArraysKt___ArraysJvmKt.copyInto(r8, r3, r2, objArr4, objArr2);
        if (z) {
            ArraysKt___ArraysJvmKt.copyInto$default(objArr4, objArr2, 0, r3, 6);
        }
        objArr2[r3] = value;
        this.values = objArr2;
        this.size++;
    }
}
