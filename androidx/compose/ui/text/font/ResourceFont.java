package androidx.compose.ui.text.font;

import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import com.google.android.gms.measurement.internal.zzdc;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Font.kt */
/* loaded from: classes.dex */
public final class ResourceFont implements Font {
    public final int loadingStrategy;
    public final int resId;
    public final int style;
    public final FontVariation$Settings variationSettings;
    public final FontWeight weight;

    public ResourceFont(int r1, FontWeight fontWeight, int r3, FontVariation$Settings fontVariation$Settings, int r5) {
        this.resId = r1;
        this.weight = fontWeight;
        this.style = r3;
        this.variationSettings = fontVariation$Settings;
        this.loadingStrategy = r5;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        if (this.resId != resourceFont.resId) {
            return false;
        }
        if (!Intrinsics.areEqual(this.weight, resourceFont.weight)) {
            return false;
        }
        if (this.style == resourceFont.style) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !Intrinsics.areEqual(this.variationSettings, resourceFont.variationSettings)) {
            return false;
        }
        if (this.loadingStrategy == resourceFont.loadingStrategy) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getLoadingStrategy-PKNRLFQ */
    public final int mo532getLoadingStrategyPKNRLFQ() {
        return this.loadingStrategy;
    }

    @Override // androidx.compose.ui.text.font.Font
    /* renamed from: getStyle-_-LCdwA */
    public final int mo533getStyle_LCdwA() {
        return this.style;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final FontWeight getWeight() {
        return this.weight;
    }

    public final int hashCode() {
        return this.variationSettings.hashCode() + HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.loadingStrategy, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.style, ((this.resId * 31) + this.weight.weight) * 31, 31), 31);
    }

    public final String toString() {
        return "ResourceFont(resId=" + this.resId + ", weight=" + this.weight + ", style=" + ((Object) FontStyle.m536toStringimpl(this.style)) + ", loadingStrategy=" + ((Object) zzdc.m1642toStringimpl(this.loadingStrategy)) + ')';
    }
}
