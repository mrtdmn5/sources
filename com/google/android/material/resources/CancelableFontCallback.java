package com.google.android.material.resources;

import android.graphics.Typeface;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.common.hash.AbstractHasher;

/* loaded from: classes3.dex */
public final class CancelableFontCallback extends AbstractHasher {
    public final ApplyFont applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    /* loaded from: classes3.dex */
    public interface ApplyFont {
    }

    public CancelableFontCallback(CollapsingTextHelper.AnonymousClass1 anonymousClass1, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = anonymousClass1;
    }

    @Override // com.google.common.hash.AbstractHasher
    public final void onFontRetrievalFailed(int r2) {
        if (!this.cancelled) {
            CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
            if (collapsingTextHelper.setCollapsedTypefaceInternal(this.fallbackFont)) {
                collapsingTextHelper.recalculate(false);
            }
        }
    }

    @Override // com.google.common.hash.AbstractHasher
    public final void onFontRetrieved(Typeface typeface, boolean z) {
        if (!this.cancelled) {
            CollapsingTextHelper collapsingTextHelper = CollapsingTextHelper.this;
            if (collapsingTextHelper.setCollapsedTypefaceInternal(typeface)) {
                collapsingTextHelper.recalculate(false);
            }
        }
    }
}
