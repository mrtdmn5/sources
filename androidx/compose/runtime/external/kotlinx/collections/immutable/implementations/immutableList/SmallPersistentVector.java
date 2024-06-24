package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.collections.ArraysKt__ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SmallPersistentVector.kt */
/* loaded from: classes.dex */
public final class SmallPersistentVector<E> extends AbstractPersistentList<E> implements ImmutableList<E> {
    public static final SmallPersistentVector EMPTY = new SmallPersistentVector(new Object[0]);
    public final Object[] buffer;

    public SmallPersistentVector(Object[] objArr) {
        this.buffer = objArr;
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> add(int r7, E e) {
        Object[] objArr = this.buffer;
        ListImplementation.checkPositionIndex$runtime_release(r7, objArr.length);
        if (r7 == objArr.length) {
            return add((SmallPersistentVector<E>) e);
        }
        if (objArr.length < 32) {
            Object[] objArr2 = new Object[objArr.length + 1];
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r7, 6);
            ArraysKt___ArraysJvmKt.copyInto(r7 + 1, r7, objArr.length, objArr, objArr2);
            objArr2[r7] = e;
            return new SmallPersistentVector(objArr2);
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        ArraysKt___ArraysJvmKt.copyInto(r7 + 1, r7, objArr.length - 1, objArr, copyOf);
        copyOf[r7] = e;
        Object[] objArr3 = new Object[32];
        objArr3[0] = objArr[31];
        return new PersistentVector(objArr.length + 1, 0, copyOf, objArr3);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> addAll(Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = this.buffer;
        if (elements.size() + objArr.length <= 32) {
            Object[] copyOf = Arrays.copyOf(objArr, elements.size() + objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            int length = objArr.length;
            Iterator<? extends E> it = elements.iterator();
            while (it.hasNext()) {
                copyOf[length] = it.next();
                length++;
            }
            return new SmallPersistentVector(copyOf);
        }
        PersistentVectorBuilder builder = builder();
        builder.addAll(elements);
        return builder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, null, this.buffer, 0);
    }

    @Override // java.util.List
    public final E get(int r2) {
        ListImplementation.checkElementIndex$runtime_release(r2, getSize());
        return (E) this.buffer[r2];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.buffer.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        return ArraysKt___ArraysKt.indexOf(this.buffer, obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        Object[] objArr = this.buffer;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int r2 = length - 1;
                if (objArr[length] == null) {
                    return length;
                }
                if (r2 < 0) {
                    return -1;
                }
                length = r2;
            }
        } else {
            int length2 = objArr.length - 1;
            if (length2 < 0) {
                return -1;
            }
            while (true) {
                int r3 = length2 - 1;
                if (Intrinsics.areEqual(obj, objArr[length2])) {
                    return length2;
                }
                if (r3 < 0) {
                    return -1;
                }
                length2 = r3;
            }
        }
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator<E> listIterator(int r4) {
        ListImplementation.checkPositionIndex$runtime_release(r4, getSize());
        return new BufferIterator(r4, getSize(), this.buffer);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList removeAll(AbstractPersistentList$removeAll$1 abstractPersistentList$removeAll$1) {
        Object[] objArr = this.buffer;
        int length = objArr.length;
        int length2 = objArr.length;
        Object[] objArr2 = objArr;
        boolean z = false;
        for (int r4 = 0; r4 < length2; r4++) {
            Object obj = objArr[r4];
            if (((Boolean) abstractPersistentList$removeAll$1.invoke(obj)).booleanValue()) {
                if (!z) {
                    objArr2 = Arrays.copyOf(objArr, objArr.length);
                    Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(this, size)");
                    z = true;
                    length = r4;
                }
            } else if (z) {
                objArr2[length] = obj;
                length++;
            }
        }
        if (length == objArr.length) {
            return this;
        }
        if (length == 0) {
            return EMPTY;
        }
        Intrinsics.checkNotNullParameter(objArr2, "<this>");
        ArraysKt__ArraysKt.copyOfRangeToIndexCheck(length, objArr2.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr2, 0, length);
        Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
        return new SmallPersistentVector(copyOfRange);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> removeAt(int r5) {
        Object[] objArr = this.buffer;
        ListImplementation.checkElementIndex$runtime_release(r5, objArr.length);
        if (objArr.length == 1) {
            return EMPTY;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length - 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt___ArraysJvmKt.copyInto(r5, r5 + 1, objArr.length, objArr, copyOf);
        return new SmallPersistentVector(copyOf);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> set(int r3, E e) {
        ListImplementation.checkElementIndex$runtime_release(r3, getSize());
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[r3] = e;
        return new SmallPersistentVector(copyOf);
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public final PersistentList<E> add(E e) {
        Object[] objArr = this.buffer;
        if (objArr.length < 32) {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[objArr.length] = e;
            return new SmallPersistentVector(copyOf);
        }
        Object[] objArr2 = new Object[32];
        objArr2[0] = e;
        return new PersistentVector(objArr.length + 1, 0, objArr, objArr2);
    }
}
