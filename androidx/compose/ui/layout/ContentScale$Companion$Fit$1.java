package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* compiled from: ContentScale.kt */
/* loaded from: classes.dex */
public final class ContentScale$Companion$Fit$1 implements ContentScale {
    @Override // androidx.compose.ui.layout.ContentScale
    /* renamed from: computeScaleFactor-H7hwNQA */
    public final long mo420computeScaleFactorH7hwNQA(long j, long j2) {
        float min = Math.min(Size.m276getWidthimpl(j2) / Size.m276getWidthimpl(j), Size.m274getHeightimpl(j2) / Size.m274getHeightimpl(j));
        return ScaleFactorKt.ScaleFactor(min, min);
    }
}
