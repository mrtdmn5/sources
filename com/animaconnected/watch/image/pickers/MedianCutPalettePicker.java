package com.animaconnected.watch.image.pickers;

import androidx.compose.foundation.BorderStrokeKt;
import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MedianCutPalettePicker.kt */
/* loaded from: classes3.dex */
public final class MedianCutPalettePicker implements PalettePicker {
    public static final MedianCutPalettePicker INSTANCE = new MedianCutPalettePicker();

    private MedianCutPalettePicker() {
    }

    private final List<List<Kolor>> split(List<Kolor> list) {
        List<Kolor> list2 = list;
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.animaconnected.watch.image.pickers.MedianCutPalettePicker$split$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return BorderStrokeKt.compareValues(Integer.valueOf(Kolor.m1543getRedimpl(((Kolor) t).m1546unboximpl())), Integer.valueOf(Kolor.m1543getRedimpl(((Kolor) t2).m1546unboximpl())));
            }
        });
        List sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.animaconnected.watch.image.pickers.MedianCutPalettePicker$split$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return BorderStrokeKt.compareValues(Integer.valueOf(Kolor.m1542getGreenimpl(((Kolor) t).m1546unboximpl())), Integer.valueOf(Kolor.m1542getGreenimpl(((Kolor) t2).m1546unboximpl())));
            }
        });
        List sortedWith3 = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator() { // from class: com.animaconnected.watch.image.pickers.MedianCutPalettePicker$split$$inlined$sortedBy$3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return BorderStrokeKt.compareValues(Integer.valueOf(Kolor.m1541getBlueimpl(((Kolor) t).m1546unboximpl())), Integer.valueOf(Kolor.m1541getBlueimpl(((Kolor) t2).m1546unboximpl())));
            }
        });
        int abs = Math.abs(Kolor.m1543getRedimpl(((Kolor) CollectionsKt___CollectionsKt.last(sortedWith)).m1546unboximpl()) - Kolor.m1543getRedimpl(((Kolor) CollectionsKt___CollectionsKt.first(sortedWith)).m1546unboximpl()));
        int abs2 = Math.abs(Kolor.m1542getGreenimpl(((Kolor) CollectionsKt___CollectionsKt.last(sortedWith2)).m1546unboximpl()) - Kolor.m1542getGreenimpl(((Kolor) CollectionsKt___CollectionsKt.first(sortedWith2)).m1546unboximpl()));
        int abs3 = Math.abs(Kolor.m1541getBlueimpl(((Kolor) CollectionsKt___CollectionsKt.last(sortedWith3)).m1546unboximpl()) - Kolor.m1541getBlueimpl(((Kolor) CollectionsKt___CollectionsKt.first(sortedWith3)).m1546unboximpl()));
        int size = list.size() / 2;
        if (abs > abs2 && abs > abs3) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{sortedWith.subList(0, size), sortedWith.subList(size, list.size())});
        }
        if (abs2 > abs && abs2 > abs3) {
            return CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{sortedWith2.subList(0, size), sortedWith2.subList(size, list.size())});
        }
        return CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{sortedWith3.subList(0, size), sortedWith3.subList(size, list.size())});
    }

    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        List listOf = CollectionsKt__CollectionsKt.listOf(pixels);
        while (listOf.size() < formatType.getColors()) {
            List list = listOf;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.split((List) it.next()));
            }
            listOf = CollectionsKt__IteratorsJVMKt.flatten(arrayList);
        }
        List<List> list2 = listOf;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        for (List list3 : list2) {
            arrayList2.add(Kolor.m1536boximpl(((Kolor) list3.get(list3.size() / 2)).m1546unboximpl()));
        }
        List<Kolor> list4 = pixels;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it2 = list4.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Integer.valueOf(arrayList2.indexOf(PalettePickerKt.m1550closestValue8COdPW0(arrayList2, ((Kolor) it2.next()).m1546unboximpl()))));
        }
        return new PaletteData(arrayList2, arrayList3);
    }
}
