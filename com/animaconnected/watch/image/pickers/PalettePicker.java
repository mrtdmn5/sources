package com.animaconnected.watch.image.pickers;

import com.animaconnected.watch.image.FormatType;
import com.animaconnected.watch.image.Kolor;
import java.util.List;

/* compiled from: PalettePicker.kt */
/* loaded from: classes3.dex */
public interface PalettePicker {
    PaletteData calculatePalette(FormatType formatType, List<Kolor> list);
}
