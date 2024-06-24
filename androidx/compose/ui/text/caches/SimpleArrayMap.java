package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.font.AsyncTypefaceCache;
import aws.smithy.kotlin.runtime.io.SdkManagedGroupKt;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleArrayMap.kt */
/* loaded from: classes.dex */
public final class SimpleArrayMap<K, V> {
    public int _size;
    public int[] hashes;
    public Object[] keyValues;

    public SimpleArrayMap() {
        this(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        int indexOf;
        boolean z;
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int r2 = this._size;
                if (r2 != simpleArrayMap._size) {
                    return false;
                }
                for (int r3 = 0; r3 < r2; r3++) {
                    Object[] objArr = this.keyValues;
                    int r5 = r3 << 1;
                    Object obj2 = objArr[r5];
                    Object obj3 = objArr[r5 + 1];
                    Object obj4 = simpleArrayMap.get(obj2);
                    if (obj3 == null) {
                        if (obj4 == null) {
                            if (obj2 == null) {
                                indexOf = simpleArrayMap.indexOfNull();
                            } else {
                                indexOf = simpleArrayMap.indexOf(obj2.hashCode(), obj2);
                            }
                            if (indexOf >= 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                            }
                        }
                        return false;
                    }
                    if (!Intrinsics.areEqual(obj3, obj4)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this._size != ((Map) obj).size()) {
                return false;
            }
            int r22 = this._size;
            for (int r32 = 0; r32 < r22; r32++) {
                Object[] objArr2 = this.keyValues;
                int r52 = r32 << 1;
                Object obj5 = objArr2[r52];
                Object obj6 = objArr2[r52 + 1];
                Object obj7 = ((Map) obj).get(obj5);
                if (obj6 == null) {
                    if (obj7 != null || !((Map) obj).containsKey(obj5)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(obj6, obj7)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final V get(K k) {
        int indexOf;
        if (k == null) {
            indexOf = indexOfNull();
        } else {
            indexOf = indexOf(k.hashCode(), k);
        }
        if (indexOf >= 0) {
            return (V) this.keyValues[(indexOf << 1) + 1];
        }
        return null;
    }

    public final int hashCode() {
        int r7;
        int[] r0 = this.hashes;
        Object[] objArr = this.keyValues;
        int r2 = this._size;
        int r4 = 1;
        int r5 = 0;
        int r6 = 0;
        while (r5 < r2) {
            Object obj = objArr[r4];
            int r8 = r0[r5];
            if (obj != null) {
                r7 = obj.hashCode();
            } else {
                r7 = 0;
            }
            r6 += r7 ^ r8;
            r5++;
            r4 += 2;
        }
        return r6;
    }

    public final int indexOf(int r6, Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        int r0 = this._size;
        if (r0 == 0) {
            return -1;
        }
        int binarySearchInternal = SdkManagedGroupKt.binarySearchInternal(this.hashes, r0, r6);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (Intrinsics.areEqual(key, this.keyValues[binarySearchInternal << 1])) {
            return binarySearchInternal;
        }
        int r2 = binarySearchInternal + 1;
        while (r2 < r0 && this.hashes[r2] == r6) {
            if (Intrinsics.areEqual(key, this.keyValues[r2 << 1])) {
                return r2;
            }
            r2++;
        }
        for (int r1 = binarySearchInternal - 1; r1 >= 0 && this.hashes[r1] == r6; r1--) {
            if (Intrinsics.areEqual(key, this.keyValues[r1 << 1])) {
                return r1;
            }
        }
        return ~r2;
    }

    public final int indexOfNull() {
        int r0 = this._size;
        if (r0 == 0) {
            return -1;
        }
        int binarySearchInternal = SdkManagedGroupKt.binarySearchInternal(this.hashes, r0, 0);
        if (binarySearchInternal < 0) {
            return binarySearchInternal;
        }
        if (this.keyValues[binarySearchInternal << 1] == null) {
            return binarySearchInternal;
        }
        int r2 = binarySearchInternal + 1;
        while (r2 < r0 && this.hashes[r2] == 0) {
            if (this.keyValues[r2 << 1] == null) {
                return r2;
            }
            r2++;
        }
        for (int r1 = binarySearchInternal - 1; r1 >= 0 && this.hashes[r1] == 0; r1--) {
            if (this.keyValues[r1 << 1] == null) {
                return r1;
            }
        }
        return ~r2;
    }

    public final Object put(AsyncTypefaceCache.Key key, AsyncTypefaceCache.AsyncTypefaceResult asyncTypefaceResult) {
        int hashCode;
        int indexOf;
        int r0 = this._size;
        if (key == null) {
            indexOf = indexOfNull();
            hashCode = 0;
        } else {
            hashCode = key.hashCode();
            indexOf = indexOf(hashCode, key);
        }
        if (indexOf >= 0) {
            int r8 = (indexOf << 1) + 1;
            Object[] objArr = this.keyValues;
            Object obj = objArr[r8];
            objArr[r8] = asyncTypefaceResult;
            return obj;
        }
        int r1 = ~indexOf;
        int[] r3 = this.hashes;
        if (r0 >= r3.length) {
            int r4 = 8;
            if (r0 >= 8) {
                r4 = (r0 >> 1) + r0;
            } else if (r0 < 4) {
                r4 = 4;
            }
            int[] copyOf = Arrays.copyOf(r3, r4);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, r4 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
            if (r0 != this._size) {
                throw new ConcurrentModificationException();
            }
        }
        if (r1 < r0) {
            int[] r32 = this.hashes;
            int r42 = r1 + 1;
            ArraysKt___ArraysJvmKt.copyInto(r42, r1, r32, r32, r0);
            Object[] objArr2 = this.keyValues;
            ArraysKt___ArraysJvmKt.copyInto(r42 << 1, r1 << 1, this._size << 1, objArr2, objArr2);
        }
        int r33 = this._size;
        if (r0 == r33) {
            int[] r02 = this.hashes;
            if (r1 < r02.length) {
                r02[r1] = hashCode;
                Object[] objArr3 = this.keyValues;
                int r12 = r1 << 1;
                objArr3[r12] = key;
                objArr3[r12 + 1] = asyncTypefaceResult;
                this._size = r33 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final String toString() {
        boolean z;
        int r0 = this._size;
        if (r0 <= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(r0 * 28);
        sb.append('{');
        int r02 = this._size;
        for (int r1 = 0; r1 < r02; r1++) {
            if (r1 > 0) {
                sb.append(", ");
            }
            int r4 = r1 << 1;
            Object obj = this.keyValues[r4];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object obj2 = this.keyValues[r4 + 1];
            if (obj2 != this) {
                sb.append(obj2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "buffer.toString()");
        return sb2;
    }

    public SimpleArrayMap(int r1) {
        this.hashes = SdkManagedGroupKt.EMPTY_INTS;
        this.keyValues = SdkManagedGroupKt.EMPTY_OBJECTS;
        this._size = 0;
    }
}
