package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PersistentVector.kt */
/* loaded from: classes.dex */
public final class PersistentVector<E> extends AbstractPersistentList<E> {
    public final Object[] root;
    public final int rootShift;
    public final int size;
    public final Object[] tail;

    public PersistentVector(int r2, int r3, Object[] root, Object[] tail) {
        boolean z;
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(tail, "tail");
        this.root = root;
        this.tail = tail;
        this.size = r2;
        this.rootShift = r3;
        if (getSize() > 32) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("Trie-based persistent vector should have at least 33 elements, got " + getSize()).toString());
    }

    public static Object[] setInRoot(int r3, int r4, Object obj, Object[] objArr) {
        int r0 = (r4 >> r3) & 31;
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (r3 == 0) {
            copyOf[r0] = obj;
        } else {
            Object obj2 = copyOf[r0];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            copyOf[r0] = setInRoot(r3 - 5, r4, obj, (Object[]) obj2);
        }
        return copyOf;
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> add(int r8, E e) {
        ListImplementation.checkPositionIndex$runtime_release(r8, getSize());
        if (r8 == getSize()) {
            return add((PersistentVector<E>) e);
        }
        int rootSize = rootSize();
        if (r8 >= rootSize) {
            return insertIntoTail(this.root, r8 - rootSize, e);
        }
        ObjectRef objectRef = new ObjectRef(null);
        return insertIntoTail(insertIntoRoot(this.root, this.rootShift, r8, e, objectRef), 0, objectRef.value);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    /* renamed from: builder$1, reason: merged with bridge method [inline-methods] */
    public final PersistentVectorBuilder<E> builder() {
        return new PersistentVectorBuilder<>(this, this.root, this.tail, this.rootShift);
    }

    @Override // java.util.List
    public final E get(int r4) {
        Object[] objArr;
        ListImplementation.checkElementIndex$runtime_release(r4, getSize());
        if (rootSize() <= r4) {
            objArr = this.tail;
        } else {
            objArr = this.root;
            for (int r1 = this.rootShift; r1 > 0; r1 -= 5) {
                Object obj = objArr[(r4 >> r1) & 31];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr = (Object[]) obj;
            }
        }
        return (E) objArr[r4 & 31];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.size;
    }

    public final Object[] insertIntoRoot(Object[] objArr, int r15, int r16, Object obj, ObjectRef objectRef) {
        Object[] objArr2;
        int r8 = (r16 >> r15) & 31;
        if (r15 == 0) {
            if (r8 == 0) {
                objArr2 = new Object[32];
            } else {
                Object[] copyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                objArr2 = copyOf;
            }
            ArraysKt___ArraysJvmKt.copyInto(r8 + 1, r8, 31, objArr, objArr2);
            objectRef.value = objArr[31];
            objArr2[r8] = obj;
            return objArr2;
        }
        Object[] copyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        int r11 = r15 - 5;
        Object obj2 = objArr[r8];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf2[r8] = insertIntoRoot((Object[]) obj2, r11, r16, obj, objectRef);
        while (true) {
            r8++;
            if (r8 >= 32 || copyOf2[r8] == null) {
                break;
            }
            Object obj3 = objArr[r8];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            copyOf2[r8] = insertIntoRoot((Object[]) obj3, r11, 0, objectRef.value, objectRef);
        }
        return copyOf2;
    }

    public final PersistentVector<E> insertIntoTail(Object[] objArr, int r8, Object obj) {
        int rootSize = rootSize();
        int r1 = this.size;
        int r0 = r1 - rootSize;
        Object[] objArr2 = this.tail;
        Object[] copyOf = Arrays.copyOf(objArr2, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        if (r0 < 32) {
            ArraysKt___ArraysJvmKt.copyInto(r8 + 1, r8, r0, objArr2, copyOf);
            copyOf[r8] = obj;
            return new PersistentVector<>(r1 + 1, this.rootShift, objArr, copyOf);
        }
        Object obj2 = objArr2[31];
        ArraysKt___ArraysJvmKt.copyInto(r8 + 1, r8, r0 - 1, objArr2, copyOf);
        copyOf[r8] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return pushFilledTail(objArr, copyOf, objArr3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int r8) {
        ListImplementation.checkPositionIndex$runtime_release(r8, getSize());
        return new PersistentVectorIterator(r8, getSize(), (this.rootShift / 5) + 1, this.root, this.tail);
    }

    public final Object[] pullLastBuffer(Object[] objArr, int r7, int r8, ObjectRef objectRef) {
        Object[] pullLastBuffer;
        int r0 = (r8 >> r7) & 31;
        if (r7 == 5) {
            objectRef.value = objArr[r0];
            pullLastBuffer = null;
        } else {
            Object obj = objArr[r0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            pullLastBuffer = pullLastBuffer((Object[]) obj, r7 - 5, r8, objectRef);
        }
        if (pullLastBuffer == null && r0 == 0) {
            return null;
        }
        Object[] copyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[r0] = pullLastBuffer;
        return copyOf;
    }

    public final PersistentVector<E> pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int r0 = this.size;
        int r1 = r0 >> 5;
        int r3 = this.rootShift;
        if (r1 > (1 << r3)) {
            Object[] objArr4 = new Object[32];
            objArr4[0] = objArr;
            int r32 = r3 + 5;
            return new PersistentVector<>(r0 + 1, r32, pushTail(r32, objArr4, objArr2), objArr3);
        }
        return new PersistentVector<>(r0 + 1, r3, pushTail(r3, objArr, objArr2), objArr3);
    }

    public final Object[] pushTail(int r4, Object[] objArr, Object[] objArr2) {
        Object[] objArr3;
        int size = ((getSize() - 1) >> r4) & 31;
        if (objArr != null) {
            objArr3 = Arrays.copyOf(objArr, 32);
            Intrinsics.checkNotNullExpressionValue(objArr3, "copyOf(this, newSize)");
        } else {
            objArr3 = new Object[32];
        }
        if (r4 == 5) {
            objArr3[size] = objArr2;
        } else {
            objArr3[size] = pushTail(r4 - 5, (Object[]) objArr3[size], objArr2);
        }
        return objArr3;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList removeAll(AbstractPersistentList$removeAll$1 abstractPersistentList$removeAll$1) {
        PersistentVectorBuilder<E> builder = builder();
        builder.removeAllWithPredicate(abstractPersistentList$removeAll$1);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> removeAt(int r7) {
        ListImplementation.checkElementIndex$runtime_release(r7, this.size);
        int rootSize = rootSize();
        Object[] objArr = this.root;
        int r2 = this.rootShift;
        if (r7 >= rootSize) {
            return removeFromTailAt(objArr, rootSize, r2, r7 - rootSize);
        }
        return removeFromTailAt(removeFromRootAt(objArr, r2, r7, new ObjectRef(this.tail[0])), rootSize, r2, 0);
    }

    public final Object[] removeFromRootAt(Object[] objArr, int r8, int r9, ObjectRef objectRef) {
        Object[] copyOf;
        int r1 = 31;
        int r0 = (r9 >> r8) & 31;
        if (r8 == 0) {
            if (r0 == 0) {
                copyOf = new Object[32];
            } else {
                copyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            }
            ArraysKt___ArraysJvmKt.copyInto(r0, r0 + 1, 32, objArr, copyOf);
            copyOf[31] = objectRef.value;
            objectRef.value = objArr[r0];
            return copyOf;
        }
        if (objArr[31] == null) {
            r1 = 31 & ((rootSize() - 1) >> r8);
        }
        Object[] copyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        int r82 = r8 - 5;
        int r2 = r0 + 1;
        if (r2 <= r1) {
            while (true) {
                Object obj = copyOf2[r1];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                copyOf2[r1] = removeFromRootAt((Object[]) obj, r82, 0, objectRef);
                if (r1 == r2) {
                    break;
                }
                r1--;
            }
        }
        Object obj2 = copyOf2[r0];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        copyOf2[r0] = removeFromRootAt((Object[]) obj2, r82, r9, objectRef);
        return copyOf2;
    }

    public final AbstractPersistentList removeFromTailAt(Object[] objArr, int r9, int r10, int r11) {
        PersistentVector persistentVector;
        int r0 = this.size - r9;
        if (r0 == 1) {
            if (r10 == 0) {
                if (objArr.length == 33) {
                    objArr = Arrays.copyOf(objArr, 32);
                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
                }
                return new SmallPersistentVector(objArr);
            }
            ObjectRef objectRef = new ObjectRef(null);
            Object[] pullLastBuffer = pullLastBuffer(objArr, r10, r9 - 1, objectRef);
            Intrinsics.checkNotNull(pullLastBuffer);
            Object obj = objectRef.value;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] objArr2 = (Object[]) obj;
            if (pullLastBuffer[1] == null) {
                Object obj2 = pullLastBuffer[0];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                persistentVector = new PersistentVector(r9, r10 - 5, (Object[]) obj2, objArr2);
            } else {
                persistentVector = new PersistentVector(r9, r10, pullLastBuffer, objArr2);
            }
            return persistentVector;
        }
        Object[] objArr3 = this.tail;
        Object[] copyOf = Arrays.copyOf(objArr3, 32);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int r3 = r0 - 1;
        if (r11 < r3) {
            ArraysKt___ArraysJvmKt.copyInto(r11, r11 + 1, r0, objArr3, copyOf);
        }
        copyOf[r3] = null;
        return new PersistentVector((r9 + r0) - 1, r10, objArr, copyOf);
    }

    public final int rootSize() {
        return (getSize() - 1) & (-32);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> set(int r6, E e) {
        int r0 = this.size;
        ListImplementation.checkElementIndex$runtime_release(r6, r0);
        int rootSize = rootSize();
        Object[] objArr = this.tail;
        Object[] objArr2 = this.root;
        int r4 = this.rootShift;
        if (rootSize <= r6) {
            Object[] copyOf = Arrays.copyOf(objArr, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[r6 & 31] = e;
            return new PersistentVector(r0, r4, objArr2, copyOf);
        }
        return new PersistentVector(r0, r4, setInRoot(r4, r6, e, objArr2), objArr);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> add(E e) {
        int rootSize = rootSize();
        int r1 = this.size;
        int r0 = r1 - rootSize;
        Object[] objArr = this.tail;
        Object[] objArr2 = this.root;
        if (r0 < 32) {
            Object[] copyOf = Arrays.copyOf(objArr, 32);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[r0] = e;
            return new PersistentVector(r1 + 1, this.rootShift, objArr2, copyOf);
        }
        Object[] objArr3 = new Object[32];
        objArr3[0] = e;
        return pushFilledTail(objArr2, objArr, objArr3);
    }
}
