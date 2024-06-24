package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.ranges.IntRange;

/* compiled from: ReversedViews.kt */
/* loaded from: classes.dex */
public class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static final void addAll(Iterable elements, Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static final boolean filterInPlace$CollectionsKt__MutableCollectionsKt(Iterable iterable, Function1 function1) {
        Iterator it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [kotlin.ranges.IntProgressionIterator] */
    public static final boolean removeAll(List list, Function1 predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (!(list instanceof RandomAccess)) {
            if ((list instanceof KMappedMarker) && !(list instanceof KMutableCollection)) {
                TypeIntrinsics.throwCce(list, "kotlin.collections.MutableIterable");
                throw null;
            }
            try {
                return filterInPlace$CollectionsKt__MutableCollectionsKt(list, predicate);
            } catch (ClassCastException e) {
                Intrinsics.sanitizeStackTrace(TypeIntrinsics.class.getName(), e);
                throw e;
            }
        }
        ?? it = new IntRange(0, CollectionsKt__CollectionsKt.getLastIndex(list)).iterator();
        int r1 = 0;
        while (it.hasNext) {
            int nextInt = it.nextInt();
            Object obj = list.get(nextInt);
            if (!((Boolean) predicate.invoke(obj)).booleanValue()) {
                if (r1 != nextInt) {
                    list.set(r1, obj);
                }
                r1++;
            }
        }
        if (r1 >= list.size()) {
            return false;
        }
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        if (r1 <= lastIndex) {
            while (true) {
                list.remove(lastIndex);
                if (lastIndex == r1) {
                    break;
                }
                lastIndex--;
            }
        }
        return true;
    }

    public static final Object removeLast(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final void addAll(Collection collection, Object[] elements) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        collection.addAll(ArraysKt___ArraysJvmKt.asList(elements));
    }
}
