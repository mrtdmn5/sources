package com.animaconnected.watch.image.pickers;

import androidx.compose.foundation.BorderStrokeKt;
import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: CommonColorPalettePicker.kt */
/* loaded from: classes3.dex */
public final class CommonColorPalettePicker implements PalettePicker {
    public static final CommonColorPalettePicker INSTANCE = new CommonColorPalettePicker();

    private CommonColorPalettePicker() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        List subList;
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        List<Kolor> list = pixels;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Kolor m1536boximpl = Kolor.m1536boximpl(((Kolor) obj).m1546unboximpl());
            Object obj2 = linkedHashMap.get(m1536boximpl);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(m1536boximpl, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Integer.valueOf(((List) entry.getValue()).size())));
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.animaconnected.watch.image.pickers.CommonColorPalettePicker$calculatePalette$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return BorderStrokeKt.compareValues((Integer) ((Pair) t2).second, (Integer) ((Pair) t).second);
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(sortedWith, 10));
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            arrayList2.add(Kolor.m1536boximpl(((Kolor) ((Pair) it.next()).first).m1546unboximpl()));
        }
        if (arrayList2.size() < formatType.getColors()) {
            IntRange until = RangesKt___RangesKt.until(0, formatType.getColors() - arrayList2.size());
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
            ?? it2 = until.iterator();
            while (it2.hasNext) {
                it2.nextInt();
                arrayList3.add(Kolor.m1536boximpl(Kolor.Companion.m1548fromArgbpWQ4cJ4(0, 0, 0, 0)));
            }
            subList = CollectionsKt___CollectionsKt.plus((Iterable) arrayList3, (Collection) arrayList2);
        } else {
            subList = arrayList2.subList(0, formatType.getColors());
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            Kolor m1550closestValue8COdPW0 = PalettePickerKt.m1550closestValue8COdPW0(subList, ((Kolor) it3.next()).m1546unboximpl());
            Intrinsics.checkNotNullParameter(subList, "<this>");
            arrayList4.add(Integer.valueOf(subList.indexOf(m1550closestValue8COdPW0)));
        }
        return new PaletteData(subList, arrayList4);
    }
}
