package com.animaconnected.watch.theme;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartTheme.kt */
/* loaded from: classes3.dex */
public final class ChartTheme {
    private final ChartColors colors;
    private final ChartFonts fonts;

    public ChartTheme(ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.colors = colors;
        this.fonts = fonts;
    }

    public static /* synthetic */ ChartTheme copy$default(ChartTheme chartTheme, ChartColors chartColors, ChartFonts chartFonts, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            chartColors = chartTheme.colors;
        }
        if ((r3 & 2) != 0) {
            chartFonts = chartTheme.fonts;
        }
        return chartTheme.copy(chartColors, chartFonts);
    }

    public final ChartColors component1() {
        return this.colors;
    }

    public final ChartFonts component2() {
        return this.fonts;
    }

    public final ChartTheme copy(ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        return new ChartTheme(colors, fonts);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChartTheme)) {
            return false;
        }
        ChartTheme chartTheme = (ChartTheme) obj;
        if (Intrinsics.areEqual(this.colors, chartTheme.colors) && Intrinsics.areEqual(this.fonts, chartTheme.fonts)) {
            return true;
        }
        return false;
    }

    public final ChartColors getColors() {
        return this.colors;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    public int hashCode() {
        return this.fonts.hashCode() + (this.colors.hashCode() * 31);
    }

    public String toString() {
        return "ChartTheme(colors=" + this.colors + ", fonts=" + this.fonts + ')';
    }
}
