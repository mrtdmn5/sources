package kotlin.collections;

import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayDeque.kt */
/* loaded from: classes.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData = emptyElementData;
    public int head;
    public int size;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r8, E e) {
        int r0 = this.size;
        if (r8 < 0 || r8 > r0) {
            throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r8, ", size: ", r0));
        }
        if (r8 == r0) {
            addLast(e);
            return;
        }
        if (r8 == 0) {
            addFirst(e);
            return;
        }
        ensureCapacity(r0 + 1);
        int positiveMod = positiveMod(this.head + r8);
        int r2 = this.size;
        if (r8 < ((r2 + 1) >> 1)) {
            if (positiveMod == 0) {
                Object[] objArr = this.elementData;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                positiveMod = objArr.length;
            }
            int r02 = positiveMod - 1;
            int r22 = this.head;
            if (r22 == 0) {
                Object[] objArr2 = this.elementData;
                Intrinsics.checkNotNullParameter(objArr2, "<this>");
                r22 = objArr2.length;
            }
            int r23 = r22 - 1;
            int r82 = this.head;
            if (r02 >= r82) {
                Object[] objArr3 = this.elementData;
                objArr3[r23] = objArr3[r82];
                ArraysKt___ArraysJvmKt.copyInto(r82, r82 + 1, r02 + 1, objArr3, objArr3);
            } else {
                Object[] objArr4 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(r82 - 1, r82, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.elementData;
                objArr5[objArr5.length - 1] = objArr5[0];
                ArraysKt___ArraysJvmKt.copyInto(0, 1, r02 + 1, objArr5, objArr5);
            }
            this.elementData[r02] = e;
            this.head = r23;
        } else {
            int positiveMod2 = positiveMod(r2 + this.head);
            if (positiveMod < positiveMod2) {
                Object[] objArr6 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(positiveMod + 1, positiveMod, positiveMod2, objArr6, objArr6);
            } else {
                Object[] objArr7 = this.elementData;
                ArraysKt___ArraysJvmKt.copyInto(1, 0, positiveMod2, objArr7, objArr7);
                Object[] objArr8 = this.elementData;
                objArr8[0] = objArr8[objArr8.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(positiveMod + 1, positiveMod, objArr8.length - 1, objArr8, objArr8);
            }
            this.elementData[positiveMod] = e;
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r9, Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int r0 = this.size;
        if (r9 >= 0 && r9 <= r0) {
            if (elements.isEmpty()) {
                return false;
            }
            int r02 = this.size;
            if (r9 == r02) {
                return addAll(elements);
            }
            ensureCapacity(elements.size() + r02);
            int positiveMod = positiveMod(this.size + this.head);
            int positiveMod2 = positiveMod(this.head + r9);
            int size = elements.size();
            if (r9 < ((this.size + 1) >> 1)) {
                int r92 = this.head;
                int r03 = r92 - size;
                if (positiveMod2 < r92) {
                    Object[] objArr = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(r03, r92, objArr.length, objArr, objArr);
                    if (size >= positiveMod2) {
                        Object[] objArr2 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(objArr2.length - size, 0, positiveMod2, objArr2, objArr2);
                    } else {
                        Object[] objArr3 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(objArr3.length - size, 0, size, objArr3, objArr3);
                        Object[] objArr4 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(0, size, positiveMod2, objArr4, objArr4);
                    }
                } else if (r03 >= 0) {
                    Object[] objArr5 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(r03, r92, positiveMod2, objArr5, objArr5);
                } else {
                    Object[] objArr6 = this.elementData;
                    r03 += objArr6.length;
                    int r6 = positiveMod2 - r92;
                    int length = objArr6.length - r03;
                    if (length >= r6) {
                        ArraysKt___ArraysJvmKt.copyInto(r03, r92, positiveMod2, objArr6, objArr6);
                    } else {
                        ArraysKt___ArraysJvmKt.copyInto(r03, r92, r92 + length, objArr6, objArr6);
                        Object[] objArr7 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(0, this.head + length, positiveMod2, objArr7, objArr7);
                    }
                }
                this.head = r03;
                int r2 = positiveMod2 - size;
                if (r2 < 0) {
                    r2 += this.elementData.length;
                }
                copyCollectionElements(r2, elements);
            } else {
                int r93 = positiveMod2 + size;
                if (positiveMod2 < positiveMod) {
                    int r3 = size + positiveMod;
                    Object[] objArr8 = this.elementData;
                    if (r3 <= objArr8.length) {
                        ArraysKt___ArraysJvmKt.copyInto(r93, positiveMod2, positiveMod, objArr8, objArr8);
                    } else if (r93 >= objArr8.length) {
                        ArraysKt___ArraysJvmKt.copyInto(r93 - objArr8.length, positiveMod2, positiveMod, objArr8, objArr8);
                    } else {
                        int length2 = positiveMod - (r3 - objArr8.length);
                        ArraysKt___ArraysJvmKt.copyInto(0, length2, positiveMod, objArr8, objArr8);
                        Object[] objArr9 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(r93, positiveMod2, length2, objArr9, objArr9);
                    }
                } else {
                    Object[] objArr10 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(size, 0, positiveMod, objArr10, objArr10);
                    Object[] objArr11 = this.elementData;
                    if (r93 >= objArr11.length) {
                        ArraysKt___ArraysJvmKt.copyInto(r93 - objArr11.length, positiveMod2, objArr11.length, objArr11, objArr11);
                    } else {
                        ArraysKt___ArraysJvmKt.copyInto(0, objArr11.length - size, objArr11.length, objArr11, objArr11);
                        Object[] objArr12 = this.elementData;
                        ArraysKt___ArraysJvmKt.copyInto(r93, positiveMod2, objArr12.length - size, objArr12, objArr12);
                    }
                }
                copyCollectionElements(positiveMod2, elements);
            }
            return true;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r9, ", size: ", r0));
    }

    public final void addFirst(E e) {
        ensureCapacity(this.size + 1);
        int r0 = this.head;
        if (r0 == 0) {
            Object[] objArr = this.elementData;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            r0 = objArr.length;
        }
        int r02 = r0 - 1;
        this.head = r02;
        this.elementData[r02] = e;
        this.size++;
    }

    public final void addLast(E e) {
        ensureCapacity(getSize() + 1);
        this.elementData[positiveMod(getSize() + this.head)] = e;
        this.size = getSize() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int positiveMod = positiveMod(this.size + this.head);
        int r1 = this.head;
        if (r1 < positiveMod) {
            ArraysKt___ArraysJvmKt.fill(r1, positiveMod, this.elementData);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.fill(this.head, objArr.length, objArr);
            ArraysKt___ArraysJvmKt.fill(0, positiveMod, this.elementData);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void copyCollectionElements(int r5, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.elementData.length;
        while (r5 < length && it.hasNext()) {
            this.elementData[r5] = it.next();
            r5++;
        }
        int r52 = this.head;
        for (int r1 = 0; r1 < r52 && it.hasNext(); r1++) {
            this.elementData[r1] = it.next();
        }
        this.size = collection.size() + getSize();
    }

    public final void ensureCapacity(int r5) {
        if (r5 >= 0) {
            Object[] objArr = this.elementData;
            if (r5 <= objArr.length) {
                return;
            }
            if (objArr == emptyElementData) {
                if (r5 < 10) {
                    r5 = 10;
                }
                this.elementData = new Object[r5];
                return;
            }
            int length = objArr.length;
            int r1 = length + (length >> 1);
            if (r1 - r5 < 0) {
                r1 = r5;
            }
            if (r1 - 2147483639 > 0) {
                if (r5 > 2147483639) {
                    r1 = Integer.MAX_VALUE;
                } else {
                    r1 = 2147483639;
                }
            }
            Object[] objArr2 = new Object[r1];
            ArraysKt___ArraysJvmKt.copyInto(0, this.head, objArr.length, objArr, objArr2);
            Object[] objArr3 = this.elementData;
            int length2 = objArr3.length;
            int r2 = this.head;
            ArraysKt___ArraysJvmKt.copyInto(length2 - r2, 0, r2, objArr3, objArr2);
            this.head = 0;
            this.elementData = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r5) {
        int size = getSize();
        if (r5 >= 0 && r5 < size) {
            return (E) this.elementData[positiveMod(this.head + r5)];
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r5, ", size: ", size));
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getSize() {
        return this.size;
    }

    public final int incremented(int r3) {
        Intrinsics.checkNotNullParameter(this.elementData, "<this>");
        if (r3 == r0.length - 1) {
            return 0;
        }
        return r3 + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int r5;
        int positiveMod = positiveMod(getSize() + this.head);
        int r1 = this.head;
        if (r1 < positiveMod) {
            while (r1 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[r1])) {
                    r5 = this.head;
                } else {
                    r1++;
                }
            }
            return -1;
        }
        if (r1 >= positiveMod) {
            int length = this.elementData.length;
            while (true) {
                if (r1 < length) {
                    if (Intrinsics.areEqual(obj, this.elementData[r1])) {
                        r5 = this.head;
                        break;
                    }
                    r1++;
                } else {
                    for (int r12 = 0; r12 < positiveMod; r12++) {
                        if (Intrinsics.areEqual(obj, this.elementData[r12])) {
                            r1 = r12 + this.elementData.length;
                            r5 = this.head;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return r1 - r5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.elementData[positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head)];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int r5;
        int positiveMod = positiveMod(this.size + this.head);
        int r1 = this.head;
        if (r1 < positiveMod) {
            length = positiveMod - 1;
            if (r1 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != r1) {
                        length--;
                    }
                }
                r5 = this.head;
                return length - r5;
            }
            return -1;
        }
        if (r1 > positiveMod) {
            int r0 = positiveMod - 1;
            while (true) {
                if (-1 < r0) {
                    if (Intrinsics.areEqual(obj, this.elementData[r0])) {
                        length = r0 + this.elementData.length;
                        r5 = this.head;
                        break;
                    }
                    r0--;
                } else {
                    Object[] objArr = this.elementData;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    length = objArr.length - 1;
                    int r12 = this.head;
                    if (r12 <= length) {
                        while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                            if (length != r12) {
                                length--;
                            }
                        }
                        r5 = this.head;
                    }
                }
            }
        }
        return -1;
    }

    public final int positiveMod(int r3) {
        Object[] objArr = this.elementData;
        if (r3 >= objArr.length) {
            return r3 - objArr.length;
        }
        return r3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> elements) {
        byte b;
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (this.elementData.length == 0) {
                b = true;
            } else {
                b = false;
            }
            if (b == false) {
                int positiveMod2 = positiveMod(this.size + this.head);
                int r3 = this.head;
                if (r3 < positiveMod2) {
                    positiveMod = r3;
                    while (r3 < positiveMod2) {
                        Object obj = this.elementData[r3];
                        if (!elements.contains(obj)) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z = true;
                        }
                        r3++;
                    }
                    ArraysKt___ArraysJvmKt.fill(positiveMod, positiveMod2, this.elementData);
                } else {
                    int length = this.elementData.length;
                    boolean z2 = false;
                    int r5 = r3;
                    while (r3 < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[r3];
                        objArr[r3] = null;
                        if (!elements.contains(obj2)) {
                            this.elementData[r5] = obj2;
                            r5++;
                        } else {
                            z2 = true;
                        }
                        r3++;
                    }
                    positiveMod = positiveMod(r5);
                    for (int r1 = 0; r1 < positiveMod2; r1++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[r1];
                        objArr2[r1] = null;
                        if (!elements.contains(obj3)) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    int r4 = positiveMod - this.head;
                    if (r4 < 0) {
                        r4 += this.elementData.length;
                    }
                    this.size = r4;
                }
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final E removeAt(int r9) {
        int r0 = this.size;
        if (r9 >= 0 && r9 < r0) {
            if (r9 == CollectionsKt__CollectionsKt.getLastIndex(this)) {
                return removeLast();
            }
            if (r9 == 0) {
                return removeFirst();
            }
            int positiveMod = positiveMod(this.head + r9);
            Object[] objArr = this.elementData;
            E e = (E) objArr[positiveMod];
            if (r9 < (this.size >> 1)) {
                int r92 = this.head;
                if (positiveMod >= r92) {
                    ArraysKt___ArraysJvmKt.copyInto(r92 + 1, r92, positiveMod, objArr, objArr);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(1, 0, positiveMod, objArr, objArr);
                    Object[] objArr2 = this.elementData;
                    objArr2[0] = objArr2[objArr2.length - 1];
                    int r02 = this.head;
                    ArraysKt___ArraysJvmKt.copyInto(r02 + 1, r02, objArr2.length - 1, objArr2, objArr2);
                }
                Object[] objArr3 = this.elementData;
                int r03 = this.head;
                objArr3[r03] = null;
                this.head = incremented(r03);
            } else {
                int positiveMod2 = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
                if (positiveMod <= positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(positiveMod, positiveMod + 1, positiveMod2 + 1, objArr4, objArr4);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt___ArraysJvmKt.copyInto(positiveMod, positiveMod + 1, objArr5.length, objArr5, objArr5);
                    Object[] objArr6 = this.elementData;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    ArraysKt___ArraysJvmKt.copyInto(0, 1, positiveMod2 + 1, objArr6, objArr6);
                }
                this.elementData[positiveMod2] = null;
            }
            this.size--;
            return e;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r9, ", size: ", r0));
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.elementData;
            int r1 = this.head;
            E e = (E) objArr[r1];
            objArr[r1] = null;
            this.head = incremented(r1);
            this.size = getSize() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int positiveMod = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
            Object[] objArr = this.elementData;
            E e = (E) objArr[positiveMod];
            objArr[positiveMod] = null;
            this.size = getSize() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> elements) {
        byte b;
        int positiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty()) {
            if (this.elementData.length == 0) {
                b = true;
            } else {
                b = false;
            }
            if (b == false) {
                int positiveMod2 = positiveMod(this.size + this.head);
                int r3 = this.head;
                if (r3 < positiveMod2) {
                    positiveMod = r3;
                    while (r3 < positiveMod2) {
                        Object obj = this.elementData[r3];
                        if (elements.contains(obj)) {
                            this.elementData[positiveMod] = obj;
                            positiveMod++;
                        } else {
                            z = true;
                        }
                        r3++;
                    }
                    ArraysKt___ArraysJvmKt.fill(positiveMod, positiveMod2, this.elementData);
                } else {
                    int length = this.elementData.length;
                    boolean z2 = false;
                    int r5 = r3;
                    while (r3 < length) {
                        Object[] objArr = this.elementData;
                        Object obj2 = objArr[r3];
                        objArr[r3] = null;
                        if (elements.contains(obj2)) {
                            this.elementData[r5] = obj2;
                            r5++;
                        } else {
                            z2 = true;
                        }
                        r3++;
                    }
                    positiveMod = positiveMod(r5);
                    for (int r1 = 0; r1 < positiveMod2; r1++) {
                        Object[] objArr2 = this.elementData;
                        Object obj3 = objArr2[r1];
                        objArr2[r1] = null;
                        if (elements.contains(obj3)) {
                            this.elementData[positiveMod] = obj3;
                            positiveMod = incremented(positiveMod);
                        } else {
                            z2 = true;
                        }
                    }
                    z = z2;
                }
                if (z) {
                    int r4 = positiveMod - this.head;
                    if (r4 < 0) {
                        r4 += this.elementData.length;
                    }
                    this.size = r4;
                }
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r4, E e) {
        int size = getSize();
        if (r4 >= 0 && r4 < size) {
            int positiveMod = positiveMod(this.head + r4);
            Object[] objArr = this.elementData;
            E e2 = (E) objArr[positiveMod];
            objArr[positiveMod] = e;
            return e2;
        }
        throw new IndexOutOfBoundsException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("index: ", r4, ", size: ", size));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[getSize()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int r1 = this.size;
        if (length < r1) {
            Object newInstance = Array.newInstance(array.getClass().getComponentType(), r1);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (T[]) ((Object[]) newInstance);
        }
        int positiveMod = positiveMod(this.size + this.head);
        int r12 = this.head;
        if (r12 < positiveMod) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.elementData, array, r12, positiveMod, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(0, this.head, objArr.length, objArr, array);
            Object[] objArr2 = this.elementData;
            ArraysKt___ArraysJvmKt.copyInto(objArr2.length - this.head, 0, positiveMod, objArr2, array);
        }
        int r0 = this.size;
        if (r0 < array.length) {
            array[r0] = null;
        }
        return array;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(elements.size() + getSize());
        copyCollectionElements(positiveMod(getSize() + this.head), elements);
        return true;
    }
}
