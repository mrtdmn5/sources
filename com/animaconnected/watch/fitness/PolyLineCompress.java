package com.animaconnected.watch.fitness;

import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PolyLineCompress.kt */
/* loaded from: classes3.dex */
public final class PolyLineCompress {
    public static final PolyLineCompress INSTANCE = new PolyLineCompress();

    private PolyLineCompress() {
    }

    private final String encodeValue(int r7) {
        int r72;
        if (r7 < 0) {
            r72 = ~(r7 << 1);
        } else {
            r72 = r7 << 1;
        }
        List<Integer> splitIntoChunks = splitIntoChunks(r72);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(splitIntoChunks, 10));
        Iterator<T> it = splitIntoChunks.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf((char) (((Number) it.next()).intValue() + 63)));
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, null, 62);
    }

    private final double round(double d, int r7) {
        return ((int) (d * r0)) / Math.pow(10.0d, r7);
    }

    private final List<Integer> splitIntoChunks(int r4) {
        ArrayList arrayList = new ArrayList();
        while (r4 >= 32) {
            arrayList.add(Integer.valueOf(32 | (r4 & 31)));
            r4 >>= 5;
        }
        arrayList.add(Integer.valueOf(r4));
        return arrayList;
    }

    public final List<LocationEntry> decode(String polyline) {
        List list;
        List list2;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(polyline, "polyline");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        char[] charArray = polyline.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        for (char c : charArray) {
            int r7 = c - '?';
            if ((r7 & 32) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            arrayList.add(Integer.valueOf(r7 & 31));
            if (z2) {
                Iterator it = arrayList.iterator();
                int r8 = 0;
                int r9 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    int r11 = r9 + 1;
                    if (r9 >= 0) {
                        r8 |= ((Number) next).intValue() << (r9 * 5);
                        r9 = r11;
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                if ((r8 & 1) == 1) {
                    r8 = ~r8;
                }
                arrayList2.add(Double.valueOf((r8 >> 1) / 100000.0d));
                arrayList.clear();
            }
        }
        ArrayList windowed = CollectionsKt___CollectionsKt.windowed(arrayList2, 2, 2, false);
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = windowed.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            List list3 = (List) next2;
            if (((Number) list3.get(1)).doubleValue() * ((Number) list3.get(0)).doubleValue() == 0.0d) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                arrayList3.add(next2);
            }
        }
        Double valueOf = Double.valueOf(0.0d);
        int collectionSizeOrDefault = CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList3, 9);
        if (collectionSizeOrDefault == 0) {
            list = CollectionsKt__CollectionsKt.listOf(valueOf);
        } else {
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault + 1);
            arrayList4.add(valueOf);
            Iterator it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                valueOf = Double.valueOf(((Number) ((List) it3.next()).get(1)).doubleValue() + valueOf.doubleValue());
                arrayList4.add(valueOf);
            }
            list = arrayList4;
        }
        List drop = CollectionsKt___CollectionsKt.drop(list);
        Double valueOf2 = Double.valueOf(0.0d);
        int collectionSizeOrDefault2 = CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList3, 9);
        if (collectionSizeOrDefault2 == 0) {
            list2 = CollectionsKt__CollectionsKt.listOf(valueOf2);
        } else {
            ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2 + 1);
            arrayList5.add(valueOf2);
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                valueOf2 = Double.valueOf(((Number) ((List) it4.next()).get(0)).doubleValue() + valueOf2.doubleValue());
                arrayList5.add(valueOf2);
            }
            list2 = arrayList5;
        }
        List drop2 = CollectionsKt___CollectionsKt.drop(list2);
        List list4 = drop;
        Iterator it5 = list4.iterator();
        List list5 = drop2;
        Iterator it6 = list5.iterator();
        ArrayList arrayList6 = new ArrayList(Math.min(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list4, 10), CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list5, 10)));
        while (it5.hasNext() && it6.hasNext()) {
            Object next3 = it5.next();
            double doubleValue = ((Number) it6.next()).doubleValue();
            double doubleValue2 = ((Number) next3).doubleValue();
            PolyLineCompress polyLineCompress = INSTANCE;
            arrayList6.add(new LocationEntry(HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion), 0L, polyLineCompress.round(doubleValue2, 5), polyLineCompress.round(doubleValue, 5), 0.0f, 0.0d, false, (DefaultConstructorMarker) null));
        }
        return arrayList6;
    }

    public final String encode(List<LocationEntry> locations) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        ArrayList arrayList = new ArrayList();
        int r0 = 0;
        int r2 = 0;
        for (LocationEntry locationEntry : locations) {
            int lat = (int) (locationEntry.getLat() * 100000.0d);
            int r3 = (int) (locationEntry.getLong() * 100000.0d);
            PolyLineCompress polyLineCompress = INSTANCE;
            String encodeValue = polyLineCompress.encodeValue(lat - r0);
            String encodeValue2 = polyLineCompress.encodeValue(r3 - r2);
            arrayList.add(encodeValue);
            arrayList.add(encodeValue2);
            r2 = r3;
            r0 = lat;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", null, null, null, 62);
    }
}
