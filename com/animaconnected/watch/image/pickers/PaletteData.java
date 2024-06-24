package com.animaconnected.watch.image.pickers;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import com.animaconnected.watch.image.Kolor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PalettePicker.kt */
/* loaded from: classes3.dex */
public final class PaletteData {
    private final List<Integer> indexes;
    private final List<Kolor> palette;

    public PaletteData(List<Kolor> palette, List<Integer> indexes) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        this.palette = palette;
        this.indexes = indexes;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaletteData copy$default(PaletteData paletteData, List list, List list2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            list = paletteData.palette;
        }
        if ((r3 & 2) != 0) {
            list2 = paletteData.indexes;
        }
        return paletteData.copy(list, list2);
    }

    public final List<Kolor> component1() {
        return this.palette;
    }

    public final List<Integer> component2() {
        return this.indexes;
    }

    public final PaletteData copy(List<Kolor> palette, List<Integer> indexes) {
        Intrinsics.checkNotNullParameter(palette, "palette");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        return new PaletteData(palette, indexes);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaletteData)) {
            return false;
        }
        PaletteData paletteData = (PaletteData) obj;
        if (Intrinsics.areEqual(this.palette, paletteData.palette) && Intrinsics.areEqual(this.indexes, paletteData.indexes)) {
            return true;
        }
        return false;
    }

    public final List<Integer> getIndexes() {
        return this.indexes;
    }

    public final List<Kolor> getPalette() {
        return this.palette;
    }

    public int hashCode() {
        return this.indexes.hashCode() + (this.palette.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PaletteData(palette=");
        sb.append(this.palette);
        sb.append(", indexes=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.indexes, ')');
    }
}
