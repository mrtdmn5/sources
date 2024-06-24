package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;

/* compiled from: RippleTheme.kt */
/* loaded from: classes.dex */
public final class DebugRippleTheme implements RippleTheme {
    public static final DebugRippleTheme INSTANCE = new DebugRippleTheme();

    @Override // androidx.compose.material.ripple.RippleTheme
    /* renamed from: defaultColor-WaAFU9c */
    public final long mo189defaultColorWaAFU9c(Composer composer) {
        composer.startReplaceableGroup(2042140174);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long j = Color.Black;
        ColorKt.m326luminance8_81llA(j);
        composer.endReplaceableGroup();
        return j;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    public final RippleAlpha rippleAlpha(Composer composer) {
        RippleAlpha rippleAlpha;
        composer.startReplaceableGroup(-1629816343);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        if (ColorKt.m326luminance8_81llA(Color.Black) > 0.5d) {
            rippleAlpha = RippleThemeKt.LightThemeHighContrastRippleAlpha;
        } else {
            rippleAlpha = RippleThemeKt.LightThemeLowContrastRippleAlpha;
        }
        composer.endReplaceableGroup();
        return rippleAlpha;
    }
}
