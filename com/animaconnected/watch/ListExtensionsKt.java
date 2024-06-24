package com.animaconnected.watch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListExtensions.kt */
/* loaded from: classes3.dex */
public final class ListExtensionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> sample(List<? extends T> list, int r10) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (r10 < list.size()) {
            List<? extends T> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
            int r3 = 0;
            for (T t : list2) {
                int r5 = r3 + 1;
                if (r3 >= 0) {
                    int size = (int) ((r10 / r0.size()) * r3);
                    int r7 = r10 - 1;
                    if (size > r7) {
                        size = r7;
                    }
                    arrayList.add(new Pair(Integer.valueOf(size), t));
                    r3 = r5;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (T t2 : arrayList) {
                if (hashSet.add(Integer.valueOf(((Number) ((Pair) t2).first).intValue()))) {
                    arrayList2.add(t2);
                }
            }
            list = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator<T> it = arrayList2.iterator();
            while (it.hasNext()) {
                list.add(((Pair) it.next()).second);
            }
        }
        return (List<T>) list;
    }
}
