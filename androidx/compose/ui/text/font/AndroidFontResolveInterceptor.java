package androidx.compose.ui.text.font;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: AndroidFontResolveInterceptor.android.kt */
/* loaded from: classes.dex */
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    public final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int r1) {
        this.fontWeightAdjustment = r1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.fontWeightAdjustment);
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public final FontWeight interceptFontWeight(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        int r0 = this.fontWeightAdjustment;
        if (r0 != 0 && r0 != Integer.MAX_VALUE) {
            return new FontWeight(RangesKt___RangesKt.coerceIn(fontWeight.weight + r0, 1, 1000));
        }
        return fontWeight;
    }

    public final String toString() {
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(new StringBuilder("AndroidFontResolveInterceptor(fontWeightAdjustment="), this.fontWeightAdjustment, ')');
    }
}
