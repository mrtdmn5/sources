package com.animaconnected.secondo.provider;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.compose.material.Colors;
import androidx.compose.material.Shapes;
import androidx.compose.material.Typography;
import com.animaconnected.secondo.provider.productinfo.ProductInfoData;
import com.animaconnected.watch.theme.DarkThemeChartColors;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeDarkThemeProvider;
import com.animaconnected.widget.theme.KronabyComposeLightThemeProvider;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThemeProvider.kt */
/* loaded from: classes3.dex */
public final class ThemeProvider extends ThemeProviderBase implements ComposeThemeProvider {
    private static final String THEME_ASSET_VERSION_DARK = "D";
    private final Colors BrandColors;
    private final Shapes BrandShapes;
    private final Typography BrandTypography;
    private final int backgroundResource;
    private final DarkThemeChartColors chartColors;
    private final KronabyFonts chartFonts;
    private final ComposeThemeProvider composeThemeProvider;
    private final Context context;
    private boolean isRemoteThemeValid;
    private final ProductInfoData productInfoData;
    private int remoteBackgroundColor;
    private float remoteBackgroundGradientOpacity;
    private int remoteGradientBackgroundColor;
    private float remoteWatchShadowOpacity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "ThemeProvider";

    /* compiled from: ThemeProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ThemeProvider(ProductInfoData productInfoData, Context context) {
        ComposeThemeProvider composeThemeProvider;
        Intrinsics.checkNotNullParameter(context, "context");
        this.productInfoData = productInfoData;
        this.context = context;
        this.isRemoteThemeValid = true;
        if (getHasDarkAsset()) {
            composeThemeProvider = KronabyComposeLightThemeProvider.INSTANCE;
        } else {
            composeThemeProvider = KronabyComposeDarkThemeProvider.INSTANCE;
        }
        this.composeThemeProvider = composeThemeProvider;
        this.BrandShapes = composeThemeProvider.getBrandShapes();
        this.BrandTypography = composeThemeProvider.getBrandTypography();
        this.BrandColors = composeThemeProvider.getBrandColors();
        this.chartColors = new DarkThemeChartColors();
        this.chartFonts = new KronabyFonts();
        validateProductInfoData();
    }

    private final boolean getHasDarkAsset() {
        String str;
        if (this.isRemoteThemeValid) {
            ProductInfoData productInfoData = this.productInfoData;
            if (productInfoData != null) {
                str = productInfoData.assetVersion;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, THEME_ASSET_VERSION_DARK)) {
                return true;
            }
        }
        return false;
    }

    private final void validateProductInfoData() {
        ProductInfoData productInfoData = this.productInfoData;
        if (productInfoData != null) {
            try {
                this.remoteBackgroundColor = Color.parseColor(productInfoData.backgroundColor);
                this.remoteGradientBackgroundColor = Color.parseColor(this.productInfoData.gradientColor);
                Double d = this.productInfoData.gradientOpacity;
                Intrinsics.checkNotNull(d);
                this.remoteBackgroundGradientOpacity = (float) d.doubleValue();
                Double d2 = this.productInfoData.shadowOpacity;
                Intrinsics.checkNotNull(d2);
                this.remoteWatchShadowOpacity = (float) d2.doubleValue();
                return;
            } catch (Exception e) {
                Log.e(TAG, "Failed to use ProductInfo data, use default theme", e);
                this.isRemoteThemeValid = false;
                return;
            }
        }
        Log.e(TAG, "Product info data is null, use default theme");
        this.isRemoteThemeValid = false;
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public int getBackgroundColor() {
        if (this.isRemoteThemeValid) {
            return this.remoteBackgroundColor;
        }
        return ThemeProviderBase.Companion.getColor(this.context, R.attr.themeBackgroundColor);
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public float getBackgroundGradientOpacity() {
        if (this.isRemoteThemeValid) {
            return this.remoteBackgroundGradientOpacity;
        }
        return getFloat(this.context, R.attr.themeGradientOpacity);
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public int getBackgroundResource() {
        return this.backgroundResource;
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Colors getBrandColors() {
        return this.BrandColors;
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Shapes getBrandShapes() {
        return this.BrandShapes;
    }

    @Override // com.animaconnected.widget.theme.ComposeThemeProvider
    public Typography getBrandTypography() {
        return this.BrandTypography;
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public int getGradientBackgroundColor() {
        if (this.isRemoteThemeValid) {
            return this.remoteGradientBackgroundColor;
        }
        return ThemeProviderBase.Companion.getColor(this.context, R.attr.themeGradientColor);
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public int getThemeFromAssetVersion() {
        if (getHasDarkAsset()) {
            return 2132082736;
        }
        return 2132082735;
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public float getWatchShadowOpacity() {
        if (this.isRemoteThemeValid) {
            return this.remoteWatchShadowOpacity;
        }
        return getFloat(this.context, R.attr.themeShadowOpacity);
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public DarkThemeChartColors getChartColors() {
        return this.chartColors;
    }

    @Override // com.animaconnected.secondo.provider.ThemeProviderBase
    public KronabyFonts getChartFonts() {
        return this.chartFonts;
    }
}
