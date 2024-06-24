package com.animaconnected.secondo.provider;

import com.animaconnected.watch.display.AndroidFontConfig;
import com.animaconnected.watch.theme.ChartFonts;
import com.kronaby.watch.app.R;

/* compiled from: KronabyFonts.kt */
/* loaded from: classes3.dex */
public final class KronabyFonts implements ChartFonts {
    public static final int $stable = 8;
    private final AndroidFontConfig H1 = new AndroidFontConfig(null, 24.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig H2 = new AndroidFontConfig(null, 20.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig H3 = new AndroidFontConfig(null, 16.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig H4 = new AndroidFontConfig(null, 13.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig H5 = new AndroidFontConfig(null, 11.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig big = new AndroidFontConfig(null, 32.0f, R.font.inter_medium, 1, null);
    private final AndroidFontConfig caption = new AndroidFontConfig(null, 11.0f, R.font.inter_regular, 1, null);

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getBig() {
        return this.big;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getCaption() {
        return this.caption;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getH1() {
        return this.H1;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getH2() {
        return this.H2;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getH3() {
        return this.H3;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getH4() {
        return this.H4;
    }

    @Override // com.animaconnected.watch.theme.ChartFonts
    public AndroidFontConfig getH5() {
        return this.H5;
    }
}
