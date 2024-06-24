package kotlin.collections;

import androidx.compose.foundation.BorderStrokeKt;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Collections.kt */
/* loaded from: classes.dex */
public class CollectionsKt__CollectionsKt {
    public static final <T> ArrayList<T> arrayListOf(T... tArr) {
        if (tArr.length == 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new ArrayAsCollection(tArr, true));
    }

    public static int binarySearch$default(ArrayList arrayList, Comparable comparable) {
        int size = arrayList.size();
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        int size2 = arrayList.size();
        int r2 = 0;
        if (size >= 0) {
            if (size <= size2) {
                int r0 = size - 1;
                while (r2 <= r0) {
                    int r1 = (r2 + r0) >>> 1;
                    int compareValues = BorderStrokeKt.compareValues((Comparable) arrayList.get(r1), comparable);
                    if (compareValues < 0) {
                        r2 = r1 + 1;
                    } else if (compareValues > 0) {
                        r0 = r1 - 1;
                    } else {
                        return r1;
                    }
                }
                return -(r2 + 1);
            }
            throw new IndexOutOfBoundsException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("toIndex (", size, ") is greater than size (", size2, ")."));
        }
        throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("fromIndex (", 0, ") is greater than toIndex (", size, ")."));
    }

    public static final ListBuilder build(ListBuilder listBuilder) {
        if (listBuilder.backing == null) {
            listBuilder.checkIsMutable();
            listBuilder.isReadOnly = true;
            if (listBuilder.length <= 0) {
                return ListBuilder.Empty;
            }
            return listBuilder;
        }
        throw new IllegalStateException();
    }

    public static final <T> int getLastIndex(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static final List listOf(Object obj) {
        List singletonList = Collections.singletonList(obj);
        Intrinsics.checkNotNullExpressionValue(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static final ArrayList mutableListOf(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new ArrayAsCollection(elements, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> optimizeReadOnlyList(List<? extends T> list) {
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return listOf(list.get(0));
            }
            return list;
        }
        return EmptyList.INSTANCE;
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T> List<T> listOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length > 0 ? ArraysKt___ArraysJvmKt.asList(elements) : EmptyList.INSTANCE;
    }
}
