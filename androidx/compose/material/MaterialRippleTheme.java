package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.material.ripple.RippleTheme;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: MaterialTheme.kt */
/* loaded from: classes.dex */
public final class MaterialRippleTheme implements RippleTheme {
    public static final MaterialRippleTheme INSTANCE = new MaterialRippleTheme();

    @Override // androidx.compose.material.ripple.RippleTheme
    /* renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public final long mo189defaultColorWaAFU9c(Composer composer) {
        composer.startReplaceableGroup(550536719);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long j = ((Color) composer.consume(ContentColorKt.LocalContentColor)).value;
        boolean isLight = ((Colors) composer.consume(ColorsKt.LocalColors)).isLight();
        float m326luminance8_81llA = ColorKt.m326luminance8_81llA(j);
        if (!isLight && m326luminance8_81llA < 0.5d) {
            j = Color.White;
        }
        composer.endReplaceableGroup();
        return j;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public final RippleAlpha rippleAlpha(Composer composer) {
        RippleAlpha rippleAlpha;
        composer.startReplaceableGroup(-1419762518);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long j = ((Color) composer.consume(ContentColorKt.LocalContentColor)).value;
        if (((Colors) composer.consume(ColorsKt.LocalColors)).isLight()) {
            if (ColorKt.m326luminance8_81llA(j) > 0.5d) {
                rippleAlpha = RippleThemeKt.LightThemeHighContrastRippleAlpha;
            } else {
                rippleAlpha = RippleThemeKt.LightThemeLowContrastRippleAlpha;
            }
        } else {
            rippleAlpha = RippleThemeKt.DarkThemeRippleAlpha;
        }
        composer.endReplaceableGroup();
        return rippleAlpha;
    }
}
