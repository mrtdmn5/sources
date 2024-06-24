package com.animaconnected.watch.image.pickers;

import com.animaconnected.info.ByteUtils;
import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationColorPalettePicker.kt */
/* loaded from: classes3.dex */
public final class NotificationColorPalettePicker implements PalettePicker {
    public static final NotificationColorPalettePicker INSTANCE = new NotificationColorPalettePicker();

    private NotificationColorPalettePicker() {
    }

    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        PaletteData calculatePalette = MedianCutPalettePicker.INSTANCE.calculatePalette(formatType, pixels);
        List<Kolor> palette = calculatePalette.getPalette();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : palette) {
            int m1546unboximpl = ((Kolor) obj).m1546unboximpl();
            String str = ByteUtils.toHexString$default(Kolor.m1543getRedimpl(m1546unboximpl), 0, 1, null) + ByteUtils.toHexString$default(Kolor.m1542getGreenimpl(m1546unboximpl), 0, 1, null) + ByteUtils.toHexString$default(Kolor.m1541getBlueimpl(m1546unboximpl), 0, 1, null);
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        if (linkedHashMap.size() > 2) {
            return calculatePalette;
        }
        return new TintColorPalettePicker(Kolor.m1537constructorimpl(-1), null).calculatePalette(formatType, pixels);
    }
}
