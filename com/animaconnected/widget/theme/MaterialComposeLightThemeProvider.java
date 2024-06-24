package com.animaconnected.widget.theme;

import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;

/* compiled from: ComposeThemeProviders.kt */
/* loaded from: classes3.dex */
public final class MaterialComposeLightThemeProvider implements ComposeThemeProvider {
    public static final int $stable = 0;
    public static final MaterialComposeLightThemeProvider INSTANCE = new MaterialComposeLightThemeProvider();
    private static final Shapes BrandShapes = new Shapes(0);
    private static final Colors BrandColors = androidx.compose.material.ColorsKt.m178lightColors2qZNXz8$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095);
    private static final Typography BrandTypography = new Typography(null, null, null, null, null, null, null, null, null, null, 16383);

    private MaterialComposeLightThemeProvider() {
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
