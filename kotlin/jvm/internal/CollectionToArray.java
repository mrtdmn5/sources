package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionToArray.kt */
/* loaded from: classes.dex */
public final class CollectionToArray {
    public static final Object[] EMPTY = new Object[0];

    public static final Object[] toArray(Collection<?> collection, Object[] objArr) {
        Object[] objArr2;
        Intrinsics.checkNotNullParameter(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int r2 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArr2 = objArr;
        } else {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr2 = (Object[]) newInstance;
        }
        while (true) {
            int r3 = r2 + 1;
            objArr2[r2] = it.next();
            if (r3 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int r22 = ((r3 * 3) + 1) >>> 1;
                if (r22 <= r3) {
                    r22 = 2147483645;
                    if (r3 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, r22);
                Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
            } else if (!it.hasNext()) {
                if (objArr2 == objArr) {
                    objArr[r3] = null;
                    return objArr;
                }
                Object[] copyOf = Arrays.copyOf(objArr2, r3);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            r2 = r3;
        }
    }

    public static final Object[] toArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size = collection.size();
        Object[] objArr = EMPTY;
        if (size == 0) {
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArr2 = new Object[size];
        int r0 = 0;
        while (true) {
            int r2 = r0 + 1;
            objArr2[r0] = it.next();
            if (r2 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int r02 = ((r2 * 3) + 1) >>> 1;
                if (r02 <= r2) {
                    r02 = 2147483645;
                    if (r2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, r02);
                Intrinsics.checkNotNullExpressionValue(objArr2, "copyOf(...)");
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr2, r2);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            r0 = r2;
        }
    }
}
