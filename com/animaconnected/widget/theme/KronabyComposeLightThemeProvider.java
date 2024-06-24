package com.animaconnected.widget.theme;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;

/* compiled from: ComposeThemeProviders.kt */
/* loaded from: classes3.dex */
public final class KronabyComposeLightThemeProvider implements ComposeThemeProvider {
    public static final int $stable = 0;
    public static final KronabyComposeLightThemeProvider INSTANCE = new KronabyComposeLightThemeProvider();
    private static final Shapes BrandShapes = ShapesKt.getBasicSharpShapes();
    private static final Colors BrandColors = ColorsKt.getKronabyLightColors();
    private static final Typography BrandTypography = TypographyKt.getKronabyTypography();

    private KronabyComposeLightThemeProvider() {
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Colors getBrandColors() {
        return BrandColors;
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Shapes getBrandShapes() {
        return BrandShapes;
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Typography getBrandTypography() {
        return BrandTypography;
    }
}
