package androidx.compose.ui.text.font;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public final class TypefaceRequest {
    public final FontFamily fontFamily;
    public final int fontStyle;
    public final int fontSynthesis;
    public final FontWeight fontWeight;
    public final Object resourceLoaderCacheKey;

    public TypefaceRequest(FontFamily fontFamily, FontWeight fontWeight, int r4, int r5, Object obj) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        this.fontFamily = fontFamily;
        this.fontWeight = fontWeight;
        this.fontStyle = r4;
        this.fontSynthesis = r5;
        this.resourceLoaderCacheKey = obj;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceRequest)) {
            return false;
        }
        TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
        if (!Intrinsics.areEqual(this.fontFamily, typefaceRequest.fontFamily) || !Intrinsics.areEqual(this.fontWeight, typefaceRequest.fontWeight)) {
            return false;
        }
        if (this.fontStyle == typefaceRequest.fontStyle) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.fontSynthesis == typefaceRequest.fontSynthesis) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && Intrinsics.areEqual(this.resourceLoaderCacheKey, typefaceRequest.resourceLoaderCacheKey)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        FontFamily fontFamily = this.fontFamily;
        if (fontFamily == null) {
            hashCode = 0;
        } else {
            hashCode = fontFamily.hashCode();
        }
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.fontSynthesis, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.fontStyle, ((hashCode * 31) + this.fontWeight.weight) * 31, 31), 31);
        Object obj = this.resourceLoaderCacheKey;
        if (obj != null) {
            r0 = obj.hashCode();
        }
        return m + r0;
    }

    public final String toString() {
        return "TypefaceRequest(fontFamily=" + this.fontFamily + ", fontWeight=" + this.fontWeight + ", fontStyle=" + ((Object) FontStyle.m536toStringimpl(this.fontStyle)) + ", fontSynthesis=" + ((Object) FontSynthesis.m537toStringimpl(this.fontSynthesis)) + ", resourceLoaderCacheKey=" + this.resourceLoaderCacheKey + ')';
    }
}
