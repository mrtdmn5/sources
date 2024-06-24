package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: IdentityArraySet.kt */
/* loaded from: classes.dex */
public final class IdentityArraySet<T> implements Set<T>, KMappedMarker {
    public int size;
    public Object[] values = new Object[16];

    @Override // java.util.Set, java.util.Collection
    public final boolean add(T value) {
        int r3;
        Intrinsics.checkNotNullParameter(value, "value");
        int r0 = this.size;
        Object[] objArr = this.values;
        if (r0 > 0) {
            r3 = find(value);
            if (r3 >= 0) {
                return false;
            }
        } else {
            r3 = -1;
        }
        int r32 = -(r3 + 1);
        if (r0 == objArr.length) {
            Object[] objArr2 = new Object[objArr.length * 2];
            ArraysKt___ArraysJvmKt.copyInto(r32 + 1, r32, r0, objArr, objArr2);
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r32, 6);
            this.values = objArr2;
        } else {
            ArraysKt___ArraysJvmKt.copyInto(r32 + 1, r32, r0, objArr, objArr);
        }
        this.values[r32] = value;
        this.size++;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        ArraysKt___ArraysJvmKt.fill$default(this.values, null);
        this.size = 0;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj == null || find(obj) < 0) {
            return false;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int find(Object obj) {
        Object obj2;
        int r0 = this.size - 1;
        int identityHashCode = System.identityHashCode(obj);
        Object[] objArr = this.values;
        int r3 = 0;
        while (r3 <= r0) {
            int r4 = (r3 + r0) >>> 1;
            Object obj3 = objArr[r4];
            int identityHashCode2 = System.identityHashCode(obj3);
            if (identityHashCode2 < identityHashCode) {
                r3 = r4 + 1;
            } else {
                if (identityHashCode2 <= identityHashCode) {
                    if (obj3 == obj) {
                        return r4;
                    }
                    Object[] objArr2 = this.values;
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
                r0 = r4 - 1;
            }
        }
        return -(r3 + 1);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this.size > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new IdentityArraySet$iterator$1(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(T t) {
        if (t == null) {
            return false;
        }
        int find = find(t);
        Object[] objArr = this.values;
        int r2 = this.size;
        if (find < 0) {
            return false;
        }
        int r0 = r2 - 1;
        if (find < r0) {
            ArraysKt___ArraysJvmKt.copyInto(find, find + 1, r2, objArr, objArr);
        }
        objArr[r0] = null;
        this.size--;
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.size;
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public final String toString() {
        return CollectionsKt___CollectionsKt.joinToString$default(this, null, "[", "]", new Function1<T, CharSequence>() { // from class: androidx.compose.runtime.collection.IdentityArraySet$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 25);
    }

    @Override // java.util.Set, java.util.Collection
    public final void addAll(Collection<? extends T> collection) {
        Object[] objArr;
        int r8;
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return;
        }
        if (!(collection instanceof IdentityArraySet)) {
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return;
        }
        Object[] objArr2 = this.values;
        IdentityArraySet identityArraySet = (IdentityArraySet) collection;
        Object[] objArr3 = identityArraySet.values;
        int r2 = this.size;
        int r15 = identityArraySet.size;
        int r3 = r2 + r15;
        boolean z2 = objArr2.length < r3;
        boolean z3 = r2 == 0 || System.identityHashCode(objArr2[r2 + (-1)]) < System.identityHashCode(objArr3[0]);
        if (!z2 && z3) {
            ArraysKt___ArraysJvmKt.copyInto(r2, 0, r15, objArr3, objArr2);
            this.size += r15;
            return;
        }
        if (z2) {
            objArr = new Object[r2 > r15 ? r2 * 2 : r15 * 2];
        } else {
            objArr = objArr2;
        }
        int r22 = r2 - 1;
        int r152 = r15 - 1;
        int r7 = r3 - 1;
        while (true) {
            if (r22 < 0 && r152 < 0) {
                break;
            }
            if (r22 < 0) {
                r8 = r152 - 1;
                obj = objArr3[r152];
            } else if (r152 < 0) {
                r8 = r152;
                obj = objArr2[r22];
                r22--;
            } else {
                Object obj2 = objArr2[r22];
                Object obj3 = objArr3[r152];
                int identityHashCode = System.identityHashCode(obj2);
                int identityHashCode2 = System.identityHashCode(obj3);
                if (identityHashCode > identityHashCode2) {
                    r22--;
                } else {
                    if (identityHashCode >= identityHashCode2) {
                        if (obj2 == obj3) {
                            r22--;
                            r152--;
                        } else {
                            int r82 = r22 - 1;
                            while (r82 >= 0) {
                                int r10 = r82 - 1;
                                Object obj4 = objArr2[r82];
                                if (System.identityHashCode(obj4) != identityHashCode2) {
                                    break;
                                }
                                if (obj3 == obj4) {
                                    z = true;
                                    break;
                                }
                                r82 = r10;
                            }
                            z = false;
                            if (z) {
                                r152--;
                            }
                        }
                    }
                    r8 = r152 - 1;
                    obj = obj3;
                }
                r8 = r152;
                obj = obj2;
            }
            objArr[r7] = obj;
            r152 = r8;
            r7--;
        }
        if (r7 >= 0) {
            ArraysKt___ArraysJvmKt.copyInto(0, r7 + 1, r3, objArr, objArr);
        }
        int r153 = r3 - (r7 + 1);
        ArraysKt___ArraysJvmKt.fill(r153, r3, objArr);
        this.values = objArr;
        this.size = r153;
    }

    @Override // java.util.Set, java.util.Collection
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
