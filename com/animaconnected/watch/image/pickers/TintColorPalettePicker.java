package com.animaconnected.watch.image.pickers;

import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: TintColorPalettePicker.kt */
/* loaded from: classes3.dex */
public final class TintColorPalettePicker implements PalettePicker {
    private final int tint;

    public /* synthetic */ TintColorPalettePicker(int r1, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1);
    }

    /* renamed from: getPaletteColors-8COdPW0, reason: not valid java name */
    private final List<Kolor> m1553getPaletteColors8COdPW0(FormatType formatType, int r9) {
        int colors = 255 / (formatType.getColors() - 1);
        IntRange until = RangesKt___RangesKt.until(0, formatType.getColors());
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Kolor.m1536boximpl(Kolor.Companion.m1548fromArgbpWQ4cJ4(Kolor.m1543getRedimpl(r9), Kolor.m1542getGreenimpl(r9), Kolor.m1541getBlueimpl(r9), ((IntIterator) it).nextInt() * colors)));
        }
        return arrayList;
    }

    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        List<Kolor> m1553getPaletteColors8COdPW0 = m1553getPaletteColors8COdPW0(formatType, this.tint);
        List<Kolor> list = pixels;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Kolor m1550closestValue8COdPW0 = PalettePickerKt.m1550closestValue8COdPW0(m1553getPaletteColors8COdPW0, ((Kolor) it.next()).m1546unboximpl());
            Intrinsics.checkNotNullParameter(m1553getPaletteColors8COdPW0, "<this>");
            arrayList.add(Integer.valueOf(m1553getPaletteColors8COdPW0.indexOf(m1550closestValue8COdPW0)));
        }
        return new PaletteData(m1553getPaletteColors8COdPW0, arrayList);
    }

    /* renamed from: getTint-IpmnaRI, reason: not valid java name */
    public final int m1554getTintIpmnaRI() {
        return this.tint;
    }

    private TintColorPalettePicker(int r1) {
        this.tint = r1;
    }
}
