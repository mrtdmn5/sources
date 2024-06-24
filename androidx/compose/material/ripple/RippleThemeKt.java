package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;

/* compiled from: RippleTheme.kt */
/* loaded from: classes.dex */
public final class RippleThemeKt {
    public static final StaticProvidableCompositionLocal LocalRippleTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<RippleTheme>() { // from class: androidx.compose.material.ripple.RippleThemeKt$LocalRippleTheme$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ RippleTheme invoke() {
            return DebugRippleTheme.INSTANCE;
        }
    });
    public static final RippleAlpha LightThemeHighContrastRippleAlpha = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);
    public static final RippleAlpha LightThemeLowContrastRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);
    public static final RippleAlpha DarkThemeRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);
}
