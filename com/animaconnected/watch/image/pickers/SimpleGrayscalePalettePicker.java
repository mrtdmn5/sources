package com.animaconnected.watch.image.pickers;

import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: SimpleGrayscalePalettePicker.kt */
/* loaded from: classes3.dex */
public final class SimpleGrayscalePalettePicker implements PalettePicker {
    public static final SimpleGrayscalePalettePicker INSTANCE = new SimpleGrayscalePalettePicker();

    private SimpleGrayscalePalettePicker() {
    }

    /* renamed from: pixelToGrayscaleValue-ukcjflE, reason: not valid java name */
    private final int m1552pixelToGrayscaleValueukcjflE(int r9) {
        float pow;
        double m1541getBlueimpl = ((Kolor.m1541getBlueimpl(r9) / 255.0d) * 0.0722d) + ((Kolor.m1542getGreenimpl(r9) / 255.0d) * 0.7152d) + ((Kolor.m1543getRedimpl(r9) / 255.0d) * 0.2126d);
        if (m1541getBlueimpl <= 0.0031308d) {
            pow = (float) (12.92f * m1541getBlueimpl);
        } else {
            pow = (float) ((Math.pow(m1541getBlueimpl, 0.4166666666666667d) * 1.055f) - 0.055d);
        }
        return (int) (pow * 255);
    }

    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        int colors = 255 / (formatType.getColors() - 1);
        IntRange until = RangesKt___RangesKt.until(0, formatType.getColors());
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt() * colors;
            arrayList.add(Kolor.m1536boximpl(Kolor.Companion.m1548fromArgbpWQ4cJ4(nextInt, nextInt, nextInt, 255)));
        }
        List<Kolor> list = pixels;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Integer.valueOf(Math.min(INSTANCE.m1552pixelToGrayscaleValueukcjflE(((Kolor) it2.next()).m1546unboximpl()) / (255 / formatType.getColors()), formatType.getColors() - 1)));
        }
        return new PaletteData(arrayList, arrayList2);
    }
}
