package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import io.ktor.http.ContentTypesKt;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlinx.coroutines.JobKt;

/* compiled from: PersistentVectorBuilder.kt */
/* loaded from: classes.dex */
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements Collection, KMutableCollection {
    public JobKt ownership;
    public Object[] root;
    public int rootShift;
    public int size;
    public Object[] tail;
    public PersistentList<? extends E> vector;
    public Object[] vectorRoot;
    public Object[] vectorTail;

    public PersistentVectorBuilder(PersistentList<? extends E> vector, Object[] objArr, Object[] vectorTail, int r5) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.vector = vector;
        this.vectorRoot = objArr;
        this.vectorTail = vectorTail;
        this.rootShift = r5;
        this.ownership = new JobKt();
        this.root = objArr;
        this.tail = vectorTail;
        this.size = vector.size();
    }

    public static void copyToBuffer(Object[] objArr, int r3, Iterator it) {
        while (r3 < 32 && it.hasNext()) {
            objArr[r3] = it.next();
            r3++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractList, java.util.List
    public final void add(int r9, E e) {
        ListImplementation.checkPositionIndex$runtime_release(r9, getSize());
        if (r9 == getSize()) {
            add(e);
            return;
        }
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (r9 >= rootSize) {
            insertIntoTail(this.root, r9 - rootSize, e);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        insertIntoTail(insertIntoRoot(objArr, this.rootShift, r9, e, objectRef), 0, objectRef.value);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r15, Collection<? extends E> elements) {
        Object[] mutableBuffer;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.checkPositionIndex$runtime_release(r15, this.size);
        if (r15 == this.size) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int r11 = (r15 >> 5) << 5;
        int size = ((elements.size() + (this.size - r11)) - 1) / 32;
        if (size == 0) {
            int r0 = r15 & 31;
            int size2 = ((elements.size() + r15) - 1) & 31;
            Object[] objArr = this.tail;
            Object[] makeMutable = makeMutable(objArr);
            ArraysKt___ArraysJvmKt.copyInto(size2 + 1, r0, tailSize(), objArr, makeMutable);
            copyToBuffer(makeMutable, r0, elements.iterator());
            this.tail = makeMutable;
            this.size = elements.size() + this.size;
            return true;
        }
        Object[][] objArr2 = new Object[size];
        int tailSize = tailSize();
        int size3 = elements.size() + this.size;
        if (size3 > 32) {
            size3 -= (size3 - 1) & (-32);
        }
        if (r15 >= rootSize()) {
            mutableBuffer = mutableBuffer();
            splitToBuffers(elements, r15, this.tail, tailSize, objArr2, size, mutableBuffer);
        } else if (size3 > tailSize) {
            int r3 = size3 - tailSize;
            mutableBuffer = makeMutableShiftingRight(r3, this.tail);
            insertIntoRoot(elements, r15, r3, objArr2, size, mutableBuffer);
        } else {
            Object[] objArr3 = this.tail;
            mutableBuffer = mutableBuffer();
            int r5 = tailSize - size3;
            ArraysKt___ArraysJvmKt.copyInto(0, r5, tailSize, objArr3, mutableBuffer);
            int r32 = 32 - r5;
            Object[] makeMutableShiftingRight = makeMutableShiftingRight(r32, this.tail);
            int r52 = size - 1;
            objArr2[r52] = makeMutableShiftingRight;
            insertIntoRoot(elements, r15, r32, objArr2, r52, makeMutableShiftingRight);
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, r11, objArr2);
        this.tail = mutableBuffer;
        this.size = elements.size() + this.size;
        return true;
    }

    public final PersistentList<E> build() {
        PersistentVector persistentVector;
        boolean z;
        Object[] objArr = this.root;
        if (objArr == this.vectorRoot && this.tail == this.vectorTail) {
            persistentVector = this.vector;
        } else {
            this.ownership = new JobKt();
            this.vectorRoot = objArr;
            Object[] objArr2 = this.tail;
            this.vectorTail = objArr2;
            if (objArr == null) {
                if (objArr2.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    persistentVector = SmallPersistentVector.EMPTY;
                } else {
                    Object[] copyOf = Arrays.copyOf(this.tail, getSize());
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    persistentVector = new SmallPersistentVector(copyOf);
                }
            } else {
                Intrinsics.checkNotNull(objArr);
                persistentVector = new PersistentVector(getSize(), this.rootShift, objArr, this.tail);
            }
        }
        this.vector = persistentVector;
        return (PersistentList<E>) persistentVector;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r4) {
        Object[] objArr;
        ListImplementation.checkElementIndex$runtime_release(r4, getSize());
        if (rootSize() <= r4) {
            objArr = this.tail;
        } else {
            objArr = this.root;
            Intrinsics.checkNotNull(objArr);
            for (int r1 = this.rootShift; r1 > 0; r1 -= 5) {
                Object obj = objArr[(r4 >> r1) & 31];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArr = (Object[]) obj;
            }
        }
        return (E) objArr[r4 & 31];
    }

    public final int getModCount$runtime_release() {
        return ((AbstractList) this).modCount;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final Object[] insertIntoRoot(Object[] objArr, int r9, int r10, Object obj, ObjectRef objectRef) {
        Object obj2;
        int r0 = (r10 >> r9) & 31;
        if (r9 == 0) {
            objectRef.value = objArr[31];
            Object[] makeMutable = makeMutable(objArr);
            ArraysKt___ArraysJvmKt.copyInto(r0 + 1, r0, 31, objArr, makeMutable);
            makeMutable[r0] = obj;
            return makeMutable;
        }
        Object[] makeMutable2 = makeMutable(objArr);
        int r92 = r9 - 5;
        Object obj3 = makeMutable2[r0];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable2[r0] = insertIntoRoot((Object[]) obj3, r92, r10, obj, objectRef);
        while (true) {
            r0++;
            if (r0 >= 32 || (obj2 = makeMutable2[r0]) == null) {
                break;
            }
            makeMutable2[r0] = insertIntoRoot((Object[]) obj2, r92, 0, objectRef.value, objectRef);
        }
        return makeMutable2;
    }

    public final void insertIntoTail(Object[] objArr, int r7, E e) {
        int tailSize = tailSize();
        Object[] makeMutable = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt___ArraysJvmKt.copyInto(r7 + 1, r7, tailSize, this.tail, makeMutable);
            makeMutable[r7] = e;
            this.root = objArr;
            this.tail = makeMutable;
            this.size++;
            return;
        }
        Object[] objArr2 = this.tail;
        Object obj = objArr2[31];
        ArraysKt___ArraysJvmKt.copyInto(r7 + 1, r7, 31, objArr2, makeMutable);
        makeMutable[r7] = e;
        pushFilledTail(objArr, makeMutable, mutableBufferWith(obj));
    }

    public final boolean isMutable(Object[] objArr) {
        if (objArr.length == 33 && objArr[32] == this.ownership) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<E> iterator() {
        return listIterator(0);
    }

    public final AbstractListIterator leafBufferIterator(int r5) {
        if (this.root != null) {
            int rootSize = rootSize() >> 5;
            ListImplementation.checkPositionIndex$runtime_release(r5, rootSize);
            int r1 = this.rootShift;
            if (r1 == 0) {
                Object[] objArr = this.root;
                Intrinsics.checkNotNull(objArr);
                return new SingleElementListIterator(r5, objArr);
            }
            Object[] objArr2 = this.root;
            Intrinsics.checkNotNull(objArr2);
            return new TrieIterator(objArr2, r5, rootSize, r1 / 5);
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int r2) {
        ListImplementation.checkPositionIndex$runtime_release(r2, getSize());
        return new PersistentVectorMutableIterator(this, r2);
    }

    public final Object[] makeMutable(Object[] objArr) {
        if (objArr == null) {
            return mutableBuffer();
        }
        if (isMutable(objArr)) {
            return objArr;
        }
        Object[] mutableBuffer = mutableBuffer();
        int length = objArr.length;
        if (length > 32) {
            length = 32;
        }
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, mutableBuffer, 0, length, 6);
        return mutableBuffer;
    }

    public final Object[] makeMutableShiftingRight(int r4, Object[] objArr) {
        if (isMutable(objArr)) {
            ArraysKt___ArraysJvmKt.copyInto(r4, 0, 32 - r4, objArr, objArr);
            return objArr;
        }
        Object[] mutableBuffer = mutableBuffer();
        ArraysKt___ArraysJvmKt.copyInto(r4, 0, 32 - r4, objArr, mutableBuffer);
        return mutableBuffer;
    }

    public final Object[] mutableBuffer() {
        Object[] objArr = new Object[33];
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] mutableBufferWith(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.ownership;
        return objArr;
    }

    public final Object[] nullifyAfter(int r6, int r7, Object[] objArr) {
        boolean z;
        if (r7 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r7 == 0) {
                return objArr;
            }
            int r1 = (r6 >> r7) & 31;
            Object obj = objArr[r1];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object nullifyAfter = nullifyAfter(r6, r7 - 5, (Object[]) obj);
            if (r1 < 31) {
                int r72 = r1 + 1;
                if (objArr[r72] != null) {
                    if (isMutable(objArr)) {
                        Arrays.fill(objArr, r72, 32, (Object) null);
                    }
                    Object[] mutableBuffer = mutableBuffer();
                    ArraysKt___ArraysJvmKt.copyInto(0, 0, r72, objArr, mutableBuffer);
                    objArr = mutableBuffer;
                }
            }
            if (nullifyAfter != objArr[r1]) {
                Object[] makeMutable = makeMutable(objArr);
                makeMutable[r1] = nullifyAfter;
                return makeMutable;
            }
            return objArr;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final Object[] pullLastBuffer(Object[] objArr, int r7, int r8, ObjectRef objectRef) {
        Object[] pullLastBuffer;
        int r0 = ((r8 - 1) >> r7) & 31;
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
        Object[] makeMutable = makeMutable(objArr);
        makeMutable[r0] = pullLastBuffer;
        return makeMutable;
    }

    public final void pullLastBufferFromRoot(int r4, int r5, Object[] objArr) {
        if (r5 == 0) {
            this.root = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.tail = objArr;
            this.size = r4;
            this.rootShift = r5;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Intrinsics.checkNotNull(objArr);
        Object[] pullLastBuffer = pullLastBuffer(objArr, r5, r4, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object obj = objectRef.value;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[]) obj;
        this.size = r4;
        if (pullLastBuffer[1] == null) {
            this.root = (Object[]) pullLastBuffer[0];
            this.rootShift = r5 - 5;
        } else {
            this.root = pullLastBuffer;
            this.rootShift = r5;
        }
    }

    public final Object[] pushBuffers(Object[] objArr, int r6, int r7, Iterator<Object[]> it) {
        boolean z;
        if (it.hasNext()) {
            if (r7 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (r7 == 0) {
                    return it.next();
                }
                Object[] makeMutable = makeMutable(objArr);
                int r1 = (r6 >> r7) & 31;
                int r72 = r7 - 5;
                makeMutable[r1] = pushBuffers((Object[]) makeMutable[r1], r6, r72, it);
                while (true) {
                    r1++;
                    if (r1 >= 32 || !it.hasNext()) {
                        break;
                    }
                    makeMutable[r1] = pushBuffers((Object[]) makeMutable[r1], 0, r72, it);
                }
                return makeMutable;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] objArr, int r6, Object[][] objArr2) {
        Object[] makeMutable;
        ArrayIterator it = ContentTypesKt.iterator(objArr2);
        int r0 = r6 >> 5;
        int r1 = this.rootShift;
        if (r0 < (1 << r1)) {
            makeMutable = pushBuffers(objArr, r6, r1, it);
        } else {
            makeMutable = makeMutable(objArr);
        }
        while (it.hasNext()) {
            this.rootShift += 5;
            makeMutable = mutableBufferWith(makeMutable);
            int r62 = this.rootShift;
            pushBuffers(makeMutable, 1 << r62, r62, it);
        }
        return makeMutable;
    }

    public final void pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int r0 = this.size;
        int r1 = r0 >> 5;
        int r2 = this.rootShift;
        if (r1 > (1 << r2)) {
            this.root = pushTail(this.rootShift + 5, mutableBufferWith(objArr), objArr2);
            this.tail = objArr3;
            this.rootShift += 5;
            this.size++;
            return;
        }
        if (objArr == null) {
            this.root = objArr2;
            this.tail = objArr3;
            this.size = r0 + 1;
        } else {
            this.root = pushTail(r2, objArr, objArr2);
            this.tail = objArr3;
            this.size++;
        }
    }

    public final Object[] pushTail(int r4, Object[] objArr, Object[] objArr2) {
        int size = ((getSize() - 1) >> r4) & 31;
        Object[] makeMutable = makeMutable(objArr);
        if (r4 == 5) {
            makeMutable[size] = objArr2;
        } else {
            makeMutable[size] = pushTail(r4 - 5, (Object[]) makeMutable[size], objArr2);
        }
        return makeMutable;
    }

    public final int recyclableRemoveAll(Function1 function1, Object[] objArr, int r9, int r10, ObjectRef objectRef, ArrayList arrayList, ArrayList arrayList2) {
        Object[] mutableBuffer;
        if (isMutable(objArr)) {
            arrayList.add(objArr);
        }
        Object obj = objectRef.value;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) obj;
        Object[] objArr3 = objArr2;
        for (int r2 = 0; r2 < r9; r2++) {
            Object obj2 = objArr[r2];
            if (!((Boolean) function1.invoke(obj2)).booleanValue()) {
                if (r10 == 32) {
                    if (!arrayList.isEmpty()) {
                        mutableBuffer = (Object[]) arrayList.remove(arrayList.size() - 1);
                    } else {
                        mutableBuffer = mutableBuffer();
                    }
                    objArr3 = mutableBuffer;
                    r10 = 0;
                }
                objArr3[r10] = obj2;
                r10++;
            }
        }
        objectRef.value = objArr3;
        if (objArr2 != objArr3) {
            arrayList2.add(objArr2);
        }
        return r10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(final Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return removeAllWithPredicate(new Function1<E, Boolean>() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder$removeAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(elements.contains(obj));
            }
        });
    }

    public final int removeAllFromTail(Function1<? super E, Boolean> function1, int r3, ObjectRef objectRef) {
        int removeAll = removeAll(function1, this.tail, r3, objectRef);
        if (removeAll == r3) {
            return r3;
        }
        Object obj = objectRef.value;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr = (Object[]) obj;
        Arrays.fill(objArr, removeAll, r3, (Object) null);
        this.tail = objArr;
        this.size -= r3 - removeAll;
        return removeAll;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:            if (r0 != r10) goto L88;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:            if (removeAllFromTail(r19, r10, r11) != r10) goto L88;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean removeAllWithPredicate(kotlin.jvm.functions.Function1<? super E, java.lang.Boolean> r19) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.removeAllWithPredicate(kotlin.jvm.functions.Function1):boolean");
    }

    @Override // kotlin.collections.AbstractMutableList
    public final E removeAt(int r6) {
        ListImplementation.checkElementIndex$runtime_release(r6, getSize());
        ((AbstractList) this).modCount++;
        int rootSize = rootSize();
        if (r6 >= rootSize) {
            return (E) removeFromTailAt(this.root, rootSize, this.rootShift, r6 - rootSize);
        }
        ObjectRef objectRef = new ObjectRef(this.tail[0]);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        removeFromTailAt(removeFromRootAt(objArr, this.rootShift, r6, objectRef), rootSize, this.rootShift, 0);
        return (E) objectRef.value;
    }

    public final Object[] removeFromRootAt(Object[] objArr, int r8, int r9, ObjectRef objectRef) {
        int r1 = 31;
        int r0 = (r9 >> r8) & 31;
        if (r8 == 0) {
            Object obj = objArr[r0];
            Object[] makeMutable = makeMutable(objArr);
            ArraysKt___ArraysJvmKt.copyInto(r0, r0 + 1, 32, objArr, makeMutable);
            makeMutable[31] = objectRef.value;
            objectRef.value = obj;
            return makeMutable;
        }
        if (objArr[31] == null) {
            r1 = 31 & ((rootSize() - 1) >> r8);
        }
        Object[] makeMutable2 = makeMutable(objArr);
        int r82 = r8 - 5;
        int r2 = r0 + 1;
        if (r2 <= r1) {
            while (true) {
                Object obj2 = makeMutable2[r1];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                makeMutable2[r1] = removeFromRootAt((Object[]) obj2, r82, 0, objectRef);
                if (r1 == r2) {
                    break;
                }
                r1--;
            }
        }
        Object obj3 = makeMutable2[r0];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable2[r0] = removeFromRootAt((Object[]) obj3, r82, r9, objectRef);
        return makeMutable2;
    }

    public final Object removeFromTailAt(Object[] objArr, int r8, int r9, int r10) {
        int r0 = this.size - r8;
        if (r0 == 1) {
            Object obj = this.tail[0];
            pullLastBufferFromRoot(r8, r9, objArr);
            return obj;
        }
        Object[] objArr2 = this.tail;
        Object obj2 = objArr2[r10];
        Object[] makeMutable = makeMutable(objArr2);
        ArraysKt___ArraysJvmKt.copyInto(r10, r10 + 1, r0, objArr2, makeMutable);
        makeMutable[r0 - 1] = null;
        this.root = objArr;
        this.tail = makeMutable;
        this.size = (r8 + r0) - 1;
        this.rootShift = r9;
        return obj2;
    }

    public final int rootSize() {
        if (getSize() <= 32) {
            return 0;
        }
        return (getSize() - 1) & (-32);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r9, E e) {
        ListImplementation.checkElementIndex$runtime_release(r9, getSize());
        if (rootSize() <= r9) {
            Object[] makeMutable = makeMutable(this.tail);
            if (makeMutable != this.tail) {
                ((AbstractList) this).modCount++;
            }
            int r92 = r9 & 31;
            E e2 = (E) makeMutable[r92];
            makeMutable[r92] = e;
            this.tail = makeMutable;
            return e2;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.root;
        Intrinsics.checkNotNull(objArr);
        this.root = setInRoot(objArr, this.rootShift, r9, e, objectRef);
        return (E) objectRef.value;
    }

    public final Object[] setInRoot(Object[] objArr, int r11, int r12, E e, ObjectRef objectRef) {
        int r0 = (r12 >> r11) & 31;
        Object[] makeMutable = makeMutable(objArr);
        if (r11 == 0) {
            if (makeMutable != objArr) {
                ((AbstractList) this).modCount++;
            }
            objectRef.value = makeMutable[r0];
            makeMutable[r0] = e;
            return makeMutable;
        }
        Object obj = makeMutable[r0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        makeMutable[r0] = setInRoot((Object[]) obj, r11 - 5, r12, e, objectRef);
        return makeMutable;
    }

    public final void splitToBuffers(Collection<? extends E> collection, int r7, Object[] objArr, int r9, Object[][] objArr2, int r11, Object[] objArr3) {
        boolean z;
        Object[] mutableBuffer;
        if (r11 >= 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object[] makeMutable = makeMutable(objArr);
            objArr2[0] = makeMutable;
            int r2 = r7 & 31;
            int size = ((collection.size() + r7) - 1) & 31;
            int r3 = (r9 - r2) + size;
            if (r3 < 32) {
                ArraysKt___ArraysJvmKt.copyInto(size + 1, r2, r9, makeMutable, objArr3);
            } else {
                int r32 = (r3 - 32) + 1;
                if (r11 == 1) {
                    mutableBuffer = makeMutable;
                } else {
                    mutableBuffer = mutableBuffer();
                    r11--;
                    objArr2[r11] = mutableBuffer;
                }
                int r33 = r9 - r32;
                ArraysKt___ArraysJvmKt.copyInto(0, r33, r9, makeMutable, objArr3);
                ArraysKt___ArraysJvmKt.copyInto(size + 1, r2, r33, makeMutable, mutableBuffer);
                objArr3 = mutableBuffer;
            }
            Iterator<? extends E> it = collection.iterator();
            copyToBuffer(makeMutable, r2, it);
            for (int r1 = 1; r1 < r11; r1++) {
                Object[] mutableBuffer2 = mutableBuffer();
                copyToBuffer(mutableBuffer2, 0, it);
                objArr2[r1] = mutableBuffer2;
            }
            copyToBuffer(objArr3, 0, it);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int tailSize() {
        int r0 = this.size;
        if (r0 > 32) {
            return r0 - ((r0 - 1) & (-32));
        }
        return r0;
    }

    public final int removeAll(Function1<? super E, Boolean> function1, Object[] objArr, int r9, ObjectRef objectRef) {
        Object[] objArr2 = objArr;
        int r3 = r9;
        boolean z = false;
        for (int r0 = 0; r0 < r9; r0++) {
            Object obj = objArr[r0];
            if (function1.invoke(obj).booleanValue()) {
                if (!z) {
                    objArr2 = makeMutable(objArr);
                    z = true;
                    r3 = r0;
                }
            } else if (z) {
                objArr2[r3] = obj;
                r3++;
            }
        }
        objectRef.value = objArr2;
        return r3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public final void insertIntoRoot(Collection<? extends E> collection, int r11, int r12, Object[][] objArr, int r14, Object[] objArr2) {
        if (this.root != null) {
            int r0 = r11 >> 5;
            AbstractListIterator leafBufferIterator = leafBufferIterator(rootSize() >> 5);
            int r3 = r14;
            Object[] objArr3 = objArr2;
            while (leafBufferIterator.index - 1 != r0) {
                Object[] objArr4 = (Object[]) leafBufferIterator.previous();
                ArraysKt___ArraysJvmKt.copyInto(0, 32 - r12, 32, objArr4, objArr3);
                objArr3 = makeMutableShiftingRight(r12, objArr4);
                r3--;
                objArr[r3] = objArr3;
            }
            Object[] objArr5 = (Object[]) leafBufferIterator.previous();
            int rootSize = r14 - (((rootSize() >> 5) - 1) - r0);
            if (rootSize < r14) {
                objArr2 = objArr[rootSize];
                Intrinsics.checkNotNull(objArr2);
            }
            splitToBuffers(collection, r11, objArr5, 32, objArr, rootSize, objArr2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        if (tailSize < 32) {
            Object[] makeMutable = makeMutable(this.tail);
            makeMutable[tailSize] = e;
            this.tail = makeMutable;
            this.size = getSize() + 1;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(e));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int tailSize = tailSize();
        Iterator<? extends E> it = elements.iterator();
        if (32 - tailSize >= elements.size()) {
            Object[] makeMutable = makeMutable(this.tail);
            copyToBuffer(makeMutable, tailSize, it);
            this.tail = makeMutable;
            this.size = elements.size() + this.size;
        } else {
            int size = ((elements.size() + tailSize) - 1) / 32;
            Object[][] objArr = new Object[size];
            Object[] makeMutable2 = makeMutable(this.tail);
            copyToBuffer(makeMutable2, tailSize, it);
            objArr[0] = makeMutable2;
            for (int r0 = 1; r0 < size; r0++) {
                Object[] mutableBuffer = mutableBuffer();
                copyToBuffer(mutableBuffer, 0, it);
                objArr[r0] = mutableBuffer;
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), objArr);
            Object[] mutableBuffer2 = mutableBuffer();
            copyToBuffer(mutableBuffer2, 0, it);
            this.tail = mutableBuffer2;
            this.size = elements.size() + this.size;
        }
        return true;
    }
}
