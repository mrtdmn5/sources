package com.animaconnected.watch.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MathUtils.kt */
/* loaded from: classes3.dex */
public final class MathUtilsKt {
    public static final Float median(List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        List sorted = CollectionsKt___CollectionsKt.sorted(list);
        if (list.size() % 2 == 0) {
            return Float.valueOf((((Number) sorted.get((list.size() / 2) - 1)).floatValue() + ((Number) sorted.get(list.size() / 2)).floatValue()) / 2);
        }
        return (Float) sorted.get(list.size() / 2);
    }

    public static final Float weightedAverage(List<Float> list, float... weightList) {
        boolean z;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(weightList, "weightList");
        if (weightList.length == list.size()) {
            int r1 = 0;
            if (ArraysKt___ArraysKt.sum(weightList) == 1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                List<Float> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                for (Object obj : list2) {
                    int r4 = r1 + 1;
                    if (r1 >= 0) {
                        arrayList.add(Float.valueOf(((Number) obj).floatValue() * weightList[r1]));
                        r1 = r4;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                Iterator it = arrayList.iterator();
                float f = 0.0f;
                while (it.hasNext()) {
                    f += ((Number) it.next()).floatValue();
                }
                return Float.valueOf(f);
            }
        }
        return null;
    }
}
