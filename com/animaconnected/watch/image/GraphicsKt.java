package com.animaconnected.watch.image;

import com.animaconnected.watch.display.ImageCommand;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Graphics.kt */
/* loaded from: classes3.dex */
public final class GraphicsKt {
    public static final byte[] compress(Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(mitmap, "<this>");
        ImageBuilder imageBuilder = ImageBuilder.INSTANCE;
        int width = mitmap.getWidth();
        int height = mitmap.getHeight();
        int[] pixels = mitmap.getPixels();
        ArrayList arrayList = new ArrayList(pixels.length);
        for (int r0 : pixels) {
            arrayList.add(Kolor.m1536boximpl(Kolor.m1537constructorimpl(r0)));
        }
        return imageBuilder.compressBlocking$graphics_release(width, height, CollectionsKt___CollectionsKt.toList(arrayList), mitmap.getFormatType(), mitmap.getPalettePicker(), mitmap.getAllowChromaKey());
    }

    public static final int darkenColorByPercentage(int r4, int r5) {
        int r1 = 0;
        int coerceIn = (int) (255 * (RangesKt___RangesKt.coerceIn(r5, 0, 100) / 100.0f));
        int r0 = 255 & (r4 >> 8);
        int r3 = r4 & 255;
        int r2 = ((r4 >> 16) & 255) - coerceIn;
        if (r2 < 0) {
            r2 = 0;
        }
        int r02 = r0 - coerceIn;
        if (r02 < 0) {
            r02 = 0;
        }
        int r32 = r3 - coerceIn;
        if (r32 >= 0) {
            r1 = r32;
        }
        return (r4 & Kolors.black) | (r2 << 16) | (r02 << 8) | r1;
    }

    public static final Mitmap emptyMitmap() {
        return new Mitmap(0, 0, new int[0], null, null, false, null, 120, null);
    }

    public static final ImageCommand toImageCommand(Mitmap mitmap, int r11, int r12, String str, Integer num) {
        Intrinsics.checkNotNullParameter(mitmap, "<this>");
        return new ImageCommand(r11, r12, mitmap.getWidth(), mitmap.getHeight(), mitmap.getBytes(), mitmap.getBytesHash(), str, num);
    }

    public static /* synthetic */ ImageCommand toImageCommand$default(Mitmap mitmap, int r2, int r3, String str, Integer num, int r6, Object obj) {
        if ((r6 & 4) != 0) {
            str = null;
        }
        if ((r6 & 8) != 0) {
            num = null;
        }
        return toImageCommand(mitmap, r2, r3, str, num);
    }

    public static final Mitmap toMitmap(ImageCommand imageCommand) throws Exception {
        Intrinsics.checkNotNullParameter(imageCommand, "<this>");
        return ImageBuilder.INSTANCE.decodeToMitmap(imageCommand.getBytes());
    }
}
