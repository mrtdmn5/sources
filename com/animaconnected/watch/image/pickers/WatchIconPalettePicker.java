package com.animaconnected.watch.image.pickers;

import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchIconPalettePicker.kt */
/* loaded from: classes3.dex */
public final class WatchIconPalettePicker implements PalettePicker {
    public static final WatchIconPalettePicker INSTANCE = new WatchIconPalettePicker();

    private WatchIconPalettePicker() {
    }

    @Override // com.animaconnected.watch.image.pickers.PalettePicker
    public PaletteData calculatePalette(FormatType formatType, List<Kolor> pixels) {
        Intrinsics.checkNotNullParameter(formatType, "formatType");
        Intrinsics.checkNotNullParameter(pixels, "pixels");
        return CommonColorPalettePicker.INSTANCE.calculatePalette(formatType, pixels);
    }
}
