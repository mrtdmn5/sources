package com.animaconnected.watch.image;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.animaconnected.info.ByteUtils;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.image.pickers.MedianCutPalettePicker;
import com.animaconnected.watch.image.pickers.PaletteData;
import com.animaconnected.watch.image.pickers.PalettePicker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysJvmKt$asList$1;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Graphics.kt */
/* loaded from: classes3.dex */
public final class ImageBuilder {
    public static final ImageBuilder INSTANCE = new ImageBuilder();

    /* compiled from: Graphics.kt */
    /* loaded from: classes3.dex */
    public static final class Prefix {
        private final FormatType formatType;
        private final int height;
        private final int width;

        public Prefix(FormatType formatType, int r3, int r4) {
            Intrinsics.checkNotNullParameter(formatType, "formatType");
            this.formatType = formatType;
            this.width = r3;
            this.height = r4;
        }

        public static /* synthetic */ Prefix copy$default(Prefix prefix, FormatType formatType, int r2, int r3, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                formatType = prefix.formatType;
            }
            if ((r4 & 2) != 0) {
                r2 = prefix.width;
            }
            if ((r4 & 4) != 0) {
                r3 = prefix.height;
            }
            return prefix.copy(formatType, r2, r3);
        }

        public final FormatType component1() {
            return this.formatType;
        }

        public final int component2() {
            return this.width;
        }

        public final int component3() {
            return this.height;
        }

        public final Prefix copy(FormatType formatType, int r3, int r4) {
            Intrinsics.checkNotNullParameter(formatType, "formatType");
            return new Prefix(formatType, r3, r4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Prefix)) {
                return false;
            }
            Prefix prefix = (Prefix) obj;
            if (this.formatType == prefix.formatType && this.width == prefix.width && this.height == prefix.height) {
                return true;
            }
            return false;
        }

        public final FormatType getFormatType() {
            return this.formatType;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Integer.hashCode(this.height) + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.width, this.formatType.hashCode() * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Prefix(formatType=");
            sb.append(this.formatType);
            sb.append(", width=");
            sb.append(this.width);
            sb.append(", height=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.height, ')');
        }
    }

    private ImageBuilder() {
    }

    public static Object compress$default(ImageBuilder imageBuilder, int r11, int r12, List list, FormatType formatType, PalettePicker palettePicker, boolean z, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int r19, Object obj) {
        FormatType formatType2;
        PalettePicker palettePicker2;
        boolean z2;
        CoroutineDispatcher coroutineDispatcher2;
        if ((r19 & 8) != 0) {
            formatType2 = FormatType.INDEXED_4BIT;
        } else {
            formatType2 = formatType;
        }
        if ((r19 & 16) != 0) {
            palettePicker2 = MedianCutPalettePicker.INSTANCE;
        } else {
            palettePicker2 = palettePicker;
        }
        if ((r19 & 32) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((r19 & 64) != 0) {
            coroutineDispatcher2 = Dispatchers.Default;
        } else {
            coroutineDispatcher2 = coroutineDispatcher;
        }
        return imageBuilder.compress(r11, r12, list, formatType2, palettePicker2, z2, coroutineDispatcher2, continuation);
    }

    private final Prefix decodePrefix(List<Byte> list) {
        List<Byte> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((Number) it.next()).byteValue()));
        }
        int int32 = toInt32(arrayList);
        int r0 = (int32 >> 21) & 1023;
        int r1 = (int32 >> 10) & 1023;
        FormatType parseFromValue = FormatType.Companion.parseFromValue(int32 & 255);
        if (parseFromValue != null) {
            return new Prefix(parseFromValue, r1, r0);
        }
        throw new IllegalArgumentException("Invalid format type");
    }

    private final byte[] prefix(FormatType formatType, int r2, int r3) {
        return ByteUtils.encodeInt32LE(formatType.getValue() + (r2 << 10) + (r3 << 21) + 0);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    private final byte[] toIndexedByteArray(List<Integer> list, int r10, FormatType formatType) {
        int ceil = ((((int) Math.ceil((formatType.getBit() * r10) / 8.0f)) * 8) - (formatType.getBit() * r10)) / formatType.getBit();
        if (ceil != 0) {
            ArrayList chunked = CollectionsKt___CollectionsKt.chunked(list, r10);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked, 10));
            Iterator it = chunked.iterator();
            while (it.hasNext()) {
                List list2 = (List) it.next();
                IntRange until = RangesKt___RangesKt.until(0, ceil);
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
                ?? it2 = until.iterator();
                while (it2.hasNext) {
                    it2.nextInt();
                    arrayList2.add(0);
                }
                arrayList.add(CollectionsKt___CollectionsKt.plus((Iterable) CollectionsKt___CollectionsKt.toList(arrayList2), (Collection) list2));
            }
            list = CollectionsKt__IteratorsJVMKt.flatten(arrayList);
        }
        ArrayList chunked2 = CollectionsKt___CollectionsKt.chunked(list, 8 / formatType.getBit());
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked2, 10));
        Iterator it3 = chunked2.iterator();
        while (it3.hasNext()) {
            int r1 = 0;
            int r2 = 0;
            for (Object obj : CollectionsKt___CollectionsKt.reversed((List) it3.next())) {
                int r5 = r2 + 1;
                if (r2 >= 0) {
                    r1 += ((Number) obj).intValue() << (formatType.getBit() * r2);
                    r2 = r5;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            }
            arrayList3.add(Byte.valueOf((byte) r1));
        }
        return CollectionsKt___CollectionsKt.toByteArray(arrayList3);
    }

    private final int toInt32(List<Integer> list) {
        boolean z;
        if (list.size() > 4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return (list.get(0).intValue() & 255) | ((list.get(3).intValue() & 255) << 24) | ((list.get(2).intValue() & 255) << 16) | ((list.get(1).intValue() & 255) << 8);
        }
        throw new IllegalArgumentException("Bytes must be at least 4 bytes".toString());
    }

    private final byte[] toPaletteByteArray(List<Kolor> list, boolean z) {
        List<Kolor> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            int m1546unboximpl = ((Kolor) it.next()).m1546unboximpl();
            int m1542getGreenimpl = Kolor.m1542getGreenimpl(m1546unboximpl);
            if (!z && m1542getGreenimpl > 251) {
                m1542getGreenimpl = 251;
            }
            arrayList.add(CollectionsKt__CollectionsKt.listOf((Object[]) new Byte[]{Byte.valueOf((byte) Kolor.m1541getBlueimpl(m1546unboximpl)), Byte.valueOf((byte) m1542getGreenimpl), Byte.valueOf((byte) Kolor.m1543getRedimpl(m1546unboximpl)), Byte.valueOf((byte) Kolor.m1540getAlphaimpl(m1546unboximpl))}));
        }
        return CollectionsKt___CollectionsKt.toByteArray(CollectionsKt__IteratorsJVMKt.flatten(arrayList));
    }

    public final Object compress(int r10, int r11, List<Kolor> list, FormatType formatType, PalettePicker palettePicker, boolean z, CoroutineDispatcher coroutineDispatcher, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(coroutineDispatcher, new ImageBuilder$compress$2(r10, r11, list, formatType, palettePicker, z, null), continuation);
    }

    public final byte[] compressBlocking$graphics_release(int r10, int r11, List<Kolor> pixels, FormatType type, PalettePicker palettePicker, boolean z) {
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(palettePicker, "palettePicker");
        try {
            if (pixels.isEmpty()) {
                LogKt.debug$default((Object) this, "ImageBuilder", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.image.ImageBuilder$compressBlocking$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Invalid image. No pixels";
                    }
                }, 6, (Object) null);
                return new byte[0];
            }
            PaletteData calculatePalette = palettePicker.calculatePalette(type, pixels);
            return ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(ArraysKt___ArraysJvmKt.plus(prefix(type, r10, r11), toPaletteByteArray(calculatePalette.getPalette(), z)), toIndexedByteArray(calculatePalette.getIndexes(), r10, type)), new byte[]{10});
        } catch (Exception e) {
            LogKt.warn$default((Object) this, "Invalid image", (String) null, (Throwable) e, false, 10, (Object) null);
            return new byte[0];
        }
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public final Mitmap decodeToMitmap(byte[] bytes) throws Exception {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        ArraysKt___ArraysJvmKt$asList$1 asList = ArraysKt___ArraysJvmKt.asList(bytes);
        Prefix decodePrefix = decodePrefix(asList);
        FormatType formatType = decodePrefix.getFormatType();
        int colors = (formatType.getColors() * 4) + 4;
        ArrayList chunked = CollectionsKt___CollectionsKt.chunked(new AbstractList.SubList(asList, 4, colors), 4);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(chunked, 10));
        Iterator it = chunked.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            arrayList.add(Kolor.m1536boximpl(Kolor.Companion.m1548fromArgbpWQ4cJ4(((Number) list.get(2)).byteValue() & 255, ((Number) list.get(1)).byteValue() & 255, ((Number) list.get(0)).byteValue() & 255, ((Number) list.get(3)).byteValue() & 255)));
        }
        int ceil = ((((int) Math.ceil((formatType.getBit() * decodePrefix.getWidth()) / 8.0f)) * 8) - (formatType.getBit() * decodePrefix.getWidth())) / formatType.getBit();
        int bit = 255 >> (8 - formatType.getBit());
        AbstractList.SubList subList = new AbstractList.SubList(asList, colors, asList.getSize() - 1);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(subList, 10));
        AbstractList.IteratorImpl iteratorImpl = new AbstractList.IteratorImpl();
        while (iteratorImpl.hasNext()) {
            int byteValue = ((Number) iteratorImpl.next()).byteValue();
            IntProgression reversed = RangesKt___RangesKt.reversed(RangesKt___RangesKt.until(0, 8 / formatType.getBit()));
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(reversed, 10));
            ?? it2 = reversed.iterator();
            while (it2.hasNext) {
                arrayList3.add(Integer.valueOf(((Kolor) arrayList.get((byteValue >> (formatType.getBit() * it2.nextInt())) & bit)).m1546unboximpl()));
            }
            arrayList2.add(arrayList3);
        }
        return new Mitmap(decodePrefix.getWidth(), decodePrefix.getHeight(), CollectionsKt___CollectionsKt.toIntArray(CollectionsKt__IteratorsJVMKt.flatten(CollectionsKt___CollectionsKt.windowed(CollectionsKt__IteratorsJVMKt.flatten(arrayList2), decodePrefix.getWidth(), decodePrefix.getWidth() + ceil, false))), null, null, false, null, 120, null);
    }
}
