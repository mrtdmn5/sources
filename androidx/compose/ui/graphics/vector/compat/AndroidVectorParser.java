package androidx.compose.ui.graphics.vector.compat;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: XmlVectorParser.android.kt */
/* loaded from: classes.dex */
public final class AndroidVectorParser {
    public int config = 0;
    public final XmlPullParser xmlParser;

    public AndroidVectorParser(XmlResourceParser xmlResourceParser) {
        this.xmlParser = xmlResourceParser;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        if (Intrinsics.areEqual(this.xmlParser, androidVectorParser.xmlParser) && this.config == androidVectorParser.config) {
            return true;
        }
        return false;
    }

    public final ComplexColorCompat getNamedComplexColor(TypedArray typedArray, Resources.Theme theme, String str, int r5) {
        ComplexColorCompat namedComplexColor = TypedArrayUtils.getNamedComplexColor(typedArray, this.xmlParser, theme, str, r5);
        updateConfig(typedArray.getChangingConfigurations());
        return namedComplexColor;
    }

    public final float getNamedFloat(TypedArray typedArray, String str, int r4, float f) {
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, this.xmlParser, str, r4, f);
        updateConfig(typedArray.getChangingConfigurations());
        return namedFloat;
    }

    public final int getNamedInt(TypedArray typedArray, String str, int r4, int r5) {
        int namedInt = TypedArrayUtils.getNamedInt(typedArray, this.xmlParser, str, r4, r5);
        updateConfig(typedArray.getChangingConfigurations());
        return namedInt;
    }

    public final String getString(TypedArray typedArray, int r2) {
        String string = typedArray.getString(r2);
        updateConfig(typedArray.getChangingConfigurations());
        return string;
    }

    public final int hashCode() {
        return Integer.hashCode(this.config) + (this.xmlParser.hashCode() * 31);
    }

    public final TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] r4) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, r4);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(\n      …          attrs\n        )");
        updateConfig(obtainAttributes.getChangingConfigurations());
        return obtainAttributes;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidVectorParser(xmlParser=");
        sb.append(this.xmlParser);
        sb.append(", config=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.config, ')');
    }

    public final void updateConfig(int r2) {
        this.config = r2 | this.config;
    }
}
