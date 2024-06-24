package com.animaconnected.watch.display;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.content.res.ResourcesCompat;
import com.animaconnected.watch.theme.FontConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFontConfig.kt */
/* loaded from: classes3.dex */
public final class AndroidFontConfig implements FontConfig {
    private final String fontName;
    private final float fontSize;
    private final int resourceInt;

    public AndroidFontConfig(String fontName, float f, int r4) {
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        this.fontName = fontName;
        this.fontSize = f;
        this.resourceInt = r4;
    }

    public static /* synthetic */ AndroidFontConfig copy$default(AndroidFontConfig androidFontConfig, String str, float f, int r3, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            str = androidFontConfig.fontName;
        }
        if ((r4 & 2) != 0) {
            f = androidFontConfig.fontSize;
        }
        if ((r4 & 4) != 0) {
            r3 = androidFontConfig.resourceInt;
        }
        return androidFontConfig.copy(str, f, r3);
    }

    public final String component1() {
        return this.fontName;
    }

    public final float component2() {
        return this.fontSize;
    }

    public final int component3() {
        return this.resourceInt;
    }

    public final AndroidFontConfig copy(String fontName, float f, int r4) {
        Intrinsics.checkNotNullParameter(fontName, "fontName");
        return new AndroidFontConfig(fontName, f, r4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidFontConfig)) {
            return false;
        }
        AndroidFontConfig androidFontConfig = (AndroidFontConfig) obj;
        if (Intrinsics.areEqual(this.fontName, androidFontConfig.fontName) && Float.compare(this.fontSize, androidFontConfig.fontSize) == 0 && this.resourceInt == androidFontConfig.resourceInt) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.theme.FontConfig
    public String getFontName() {
        return this.fontName;
    }

    @Override // com.animaconnected.watch.theme.FontConfig
    public float getFontSize() {
        return this.fontSize;
    }

    @Override // com.animaconnected.watch.theme.FontConfig
    public int getResourceInt() {
        return this.resourceInt;
    }

    public final Typeface getTypeface(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourcesCompat.getFont(context, getResourceInt());
    }

    public int hashCode() {
        return Integer.hashCode(this.resourceInt) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.fontSize, this.fontName.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AndroidFontConfig(fontName=");
        sb.append(this.fontName);
        sb.append(", fontSize=");
        sb.append(this.fontSize);
        sb.append(", resourceInt=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.resourceInt, ')');
    }

    public /* synthetic */ AndroidFontConfig(String str, float f, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "" : str, f, r3);
    }
}
