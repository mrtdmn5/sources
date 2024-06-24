package kotlin.collections;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.CharRange;
import kotlin.text.StringsKt__AppendableKt;

/* compiled from: _Collections.kt */
/* loaded from: classes.dex */
public class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static final CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 asSequence(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(iterable);
    }

    public static final double averageOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        double d = 0.0d;
        int r2 = 0;
        while (it.hasNext()) {
            d += it.next().intValue();
            r2++;
            if (r2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
                throw null;
            }
        }
        if (r2 == 0) {
            return Double.NaN;
        }
        return d / r2;
    }

    public static final double averageOfLong(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        double d = 0.0d;
        int r2 = 0;
        while (it.hasNext()) {
            d += ((Number) it.next()).longValue();
            r2++;
            if (r2 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
                throw null;
            }
        }
        if (r2 == 0) {
            return Double.NaN;
        }
        return d / r2;
    }

    public static final ArrayList chunked(Iterable iterable, int r2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return windowed(iterable, r2, r2, true);
    }

    public static final <T> boolean contains(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        if (indexOf(iterable, t) >= 0) {
            return true;
        }
        return false;
    }

    public static final <T> int count(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        Iterator<? extends T> it = iterable.iterator();
        int r0 = 0;
        while (it.hasNext()) {
            it.next();
            r0++;
            if (r0 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
                throw null;
            }
        }
        return r0;
    }

    public static final List drop(Iterable iterable) {
        ArrayList arrayList;
        Object obj;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size() - 1;
            if (size <= 0) {
                return EmptyList.INSTANCE;
            }
            if (size == 1) {
                if (iterable instanceof List) {
                    obj = last((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (it.hasNext()) {
                        Object next = it.next();
                        while (it.hasNext()) {
                            next = it.next();
                        }
                        obj = next;
                    } else {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                }
                return CollectionsKt__CollectionsKt.listOf(obj);
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    int size2 = collection.size();
                    for (int r1 = 1; r1 < size2; r1++) {
                        arrayList.add(((List) iterable).get(r1));
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(1);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int r0 = 0;
        for (Object obj2 : iterable) {
            if (r0 >= 1) {
                arrayList.add(obj2);
            } else {
                r0++;
            }
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
    }

    public static final List dropLast(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List list2 = list;
        int size = list.size() - 1;
        if (size < 0) {
            size = 0;
        }
        return take(list2, size);
    }

    public static final ArrayList filterNotNull(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> T first(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) first((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T firstOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static final Object getOrNull(int r1, List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (r1 >= 0 && r1 <= CollectionsKt__CollectionsKt.getLastIndex(list)) {
            return list.get(r1);
        }
        return null;
    }

    public static final <T> int indexOf(Iterable<? extends T> iterable, T t) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int r0 = 0;
        for (T t2 : iterable) {
            if (r0 >= 0) {
                if (Intrinsics.areEqual(t, t2)) {
                    return r0;
                }
                r0++;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return -1;
    }

    public static final void joinTo(Iterable iterable, Appendable appendable, CharSequence separator, CharSequence prefix, CharSequence postfix, int r7, CharSequence truncated, Function1 function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        appendable.append(prefix);
        int r5 = 0;
        for (Object obj : iterable) {
            r5++;
            if (r5 > 1) {
                appendable.append(separator);
            }
            if (r7 >= 0 && r5 > r7) {
                break;
            } else {
                StringsKt__AppendableKt.appendElement(appendable, obj, function1);
            }
        }
        if (r7 >= 0 && r5 > r7) {
            appendable.append(truncated);
        }
        appendable.append(postfix);
    }

    public static /* synthetic */ void joinTo$default(Iterable iterable, Appendable appendable, String str, Function1 function1, int r12) {
        CharSequence charSequence;
        CharSequence charSequence2;
        int r10;
        CharSequence charSequence3;
        Function1 function12;
        if ((r12 & 2) != 0) {
            str = ", ";
        }
        String str2 = str;
        if ((r12 & 4) != 0) {
            charSequence = "";
        } else {
            charSequence = null;
        }
        if ((r12 & 8) != 0) {
            charSequence2 = "";
        } else {
            charSequence2 = null;
        }
        if ((r12 & 16) != 0) {
            r10 = -1;
        } else {
            r10 = 0;
        }
        int r5 = r10;
        if ((r12 & 32) != 0) {
            charSequence3 = "...";
        } else {
            charSequence3 = null;
        }
        if ((r12 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        joinTo(iterable, appendable, str2, charSequence, charSequence2, r5, charSequence3, function12);
    }

    public static String joinToString$default(Iterable iterable, String str, String str2, String str3, Function1 function1, int r13) {
        String prefix;
        String postfix;
        int r9;
        CharSequence truncated;
        Function1 function12;
        if ((r13 & 1) != 0) {
            str = ", ";
        }
        String separator = str;
        if ((r13 & 2) != 0) {
            prefix = "";
        } else {
            prefix = str2;
        }
        if ((r13 & 4) != 0) {
            postfix = "";
        } else {
            postfix = str3;
        }
        if ((r13 & 8) != 0) {
            r9 = -1;
        } else {
            r9 = 0;
        }
        int r5 = r9;
        if ((r13 & 16) != 0) {
            truncated = "...";
        } else {
            truncated = null;
        }
        if ((r13 & 32) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        joinTo(iterable, sb, separator, prefix, postfix, r5, truncated, function12);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final <T> T last(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.getLastIndex(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T lastOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    /* renamed from: maxOrNull */
    public static final Float m1666maxOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOrNull */
    public static final Float m1667minOrNull(Iterable<Float> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Float> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = it.next().floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, it.next().floatValue());
        }
        return Float.valueOf(floatValue);
    }

    public static final Comparable minOrThrow(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Comparable comparable = (Comparable) it.next();
            while (it.hasNext()) {
                Comparable comparable2 = (Comparable) it.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
            return comparable;
        }
        throw new NoSuchElementException();
    }

    public static final <T> List<T> minus(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (!(iterable2 instanceof Collection)) {
            iterable2 = toList(iterable2);
        }
        Collection collection = (Collection) iterable2;
        if (collection.isEmpty()) {
            return toList(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (T t : iterable) {
            if (!collection.contains(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final ArrayList plus(Collection collection, Object obj) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(obj);
        return arrayList;
    }

    public static final <T> List<T> reversed(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return toList(iterable);
        }
        List<T> mutableList = toMutableList(iterable);
        Collections.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T singleOrNull(List<? extends T> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Comparable[] comparableArr = (Comparable[]) array;
            Intrinsics.checkNotNullParameter(comparableArr, "<this>");
            if (comparableArr.length > 1) {
                Arrays.sort(comparableArr);
            }
            return ArraysKt___ArraysJvmKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        if (((ArrayList) mutableList).size() > 1) {
            Collections.sort(mutableList);
        }
        return mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sortedWith(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return toList(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Intrinsics.checkNotNullParameter(array, "<this>");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return ArraysKt___ArraysJvmKt.asList(array);
        }
        List<T> mutableList = toMutableList(iterable);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, comparator);
        return mutableList;
    }

    public static final double sumOfDouble(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        double d = 0.0d;
        while (it.hasNext()) {
            d += ((Number) it.next()).doubleValue();
        }
        return d;
    }

    public static final int sumOfInt(Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<Integer> it = iterable.iterator();
        int r0 = 0;
        while (it.hasNext()) {
            r0 += it.next().intValue();
        }
        return r0;
    }

    public static final <T> List<T> take(Iterable<? extends T> iterable, int r5) {
        boolean z;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        int r0 = 0;
        if (r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r5 == 0) {
                return EmptyList.INSTANCE;
            }
            if (iterable instanceof Collection) {
                if (r5 >= ((Collection) iterable).size()) {
                    return toList(iterable);
                }
                if (r5 == 1) {
                    return CollectionsKt__CollectionsKt.listOf(first(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(r5);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                r0++;
                if (r0 == r5) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.optimizeReadOnlyList(arrayList);
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", r5, " is less than zero.").toString());
    }

    public static final byte[] toByteArray(Collection<Byte> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        Iterator<Byte> it = collection.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            bArr[r1] = it.next().byteValue();
            r1++;
        }
        return bArr;
    }

    public static final void toCollection(Iterable iterable, java.util.AbstractCollection abstractCollection) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static final int[] toIntArray(Collection<Integer> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] r0 = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            r0[r1] = it.next().intValue();
            r1++;
        }
        return r0;
    }

    public static final <T> List<T> toList(Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return toMutableList(collection);
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return CollectionsKt__CollectionsKt.listOf(next);
            }
            return EmptyList.INSTANCE;
        }
        return CollectionsKt__CollectionsKt.optimizeReadOnlyList(toMutableList(iterable));
    }

    public static final <T> List<T> toMutableList(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return toMutableList((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        toCollection(iterable, arrayList);
        return arrayList;
    }

    public static final <T> Set<T> toMutableSet(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        toCollection(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static final <T> Set<T> toSet(Iterable<? extends T> iterable) {
        Object next;
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        boolean z = iterable instanceof Collection;
        EmptySet emptySet = EmptySet.INSTANCE;
        if (z) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(collection.size()));
                    toCollection(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                if (iterable instanceof List) {
                    next = ((List) iterable).get(0);
                } else {
                    next = iterable.iterator().next();
                }
                return SetsKt__SetsKt.setOf(next);
            }
            return emptySet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        toCollection(iterable, linkedHashSet2);
        int size2 = linkedHashSet2.size();
        if (size2 != 0) {
            if (size2 != 1) {
                return linkedHashSet2;
            }
            return SetsKt__SetsKt.setOf(linkedHashSet2.iterator().next());
        }
        return emptySet;
    }

    public static final ArrayList windowed(Iterable iterable, int r10, int r11, boolean z) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        SlidingWindowKt.checkWindowSizeStep(r10, r11);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            ArrayList arrayList = new ArrayList((size / r11) + (size % r11 == 0 ? 0 : 1));
            int r2 = 0;
            while (true) {
                if (!(r2 >= 0 && r2 < size)) {
                    break;
                }
                int r5 = size - r2;
                if (r10 <= r5) {
                    r5 = r10;
                }
                if (r5 < r10 && !z) {
                    break;
                }
                ArrayList arrayList2 = new ArrayList(r5);
                for (int r7 = 0; r7 < r5; r7++) {
                    arrayList2.add(list.get(r7 + r2));
                }
                arrayList.add(arrayList2);
                r2 += r11;
            }
            return arrayList;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), r10, r11, z, false);
        while (windowedIterator.hasNext()) {
            arrayList3.add((List) windowedIterator.next());
        }
        return arrayList3;
    }

    public static /* synthetic */ ArrayList windowed$default(Iterable iterable, int r1, int r2, Function1 function1, int r4) {
        if ((r4 & 2) != 0) {
            r2 = 1;
        }
        return windowed(iterable, r1, r2, false, function1);
    }

    public static final IndexingIterable withIndex(final Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return new IndexingIterable(new Function0<Iterator<Object>>() { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Iterator<Object> invoke() {
                return iterable.iterator();
            }
        });
    }

    public static final ArrayList chunked(Iterable iterable, int r2, Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        return windowed(iterable, r2, r2, true, transform);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final ArrayList plus(CharRange charRange, CharRange charRange2) {
        if (charRange instanceof Collection) {
            return plus(charRange2, (Collection) charRange);
        }
        ArrayList arrayList = new ArrayList();
        CollectionsKt__ReversedViewsKt.addAll(charRange, arrayList);
        CollectionsKt__ReversedViewsKt.addAll(charRange2, arrayList);
        return arrayList;
    }

    public static final ArrayList toMutableList(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final <T> T first(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T firstOrNull(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) < 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final <T extends Comparable<? super T>> T minOrNull(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static final ArrayList plus(Iterable elements, Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            Collection collection2 = (Collection) elements;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        CollectionsKt__ReversedViewsKt.addAll(elements, arrayList2);
        return arrayList2;
    }

    public static final ArrayList windowed(Iterable iterable, int r8, int r9, boolean z, Function1 transform) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(r8, r9);
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            List list = (List) iterable;
            int size = list.size();
            ArrayList arrayList = new ArrayList((size / r9) + (size % r9 == 0 ? 0 : 1));
            MovingSubList movingSubList = new MovingSubList(list);
            int r7 = 0;
            while (true) {
                if (!(r7 >= 0 && r7 < size)) {
                    break;
                }
                int r5 = size - r7;
                if (r8 <= r5) {
                    r5 = r8;
                }
                if (!z && r5 < r8) {
                    break;
                }
                int r52 = r5 + r7;
                AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(r7, r52, movingSubList.list.size());
                movingSubList.fromIndex = r7;
                movingSubList._size = r52 - r7;
                arrayList.add(transform.invoke(movingSubList));
                r7 += r9;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator windowedIterator = SlidingWindowKt.windowedIterator(iterable.iterator(), r8, r9, z, true);
        while (windowedIterator.hasNext()) {
            arrayList2.add(transform.invoke((List) windowedIterator.next()));
        }
        return arrayList2;
    }
}
