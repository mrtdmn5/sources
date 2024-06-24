package com.animaconnected.widget.theme;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;

/* compiled from: ComposeThemeProviders.kt */
/* loaded from: classes3.dex */
public final class LotusComposeThemeProvider implements ComposeThemeProvider {
    public static final int $stable = 0;
    public static final LotusComposeThemeProvider INSTANCE = new LotusComposeThemeProvider();
    private static final Shapes BrandShapes = ShapesKt.getLotusRoundShapes();
    private static final Colors BrandColors = ColorsKt.getLotusComposeColors();
    private static final Typography BrandTypography = TypographyKt.getMainTypography();

    private LotusComposeThemeProvider() {
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
