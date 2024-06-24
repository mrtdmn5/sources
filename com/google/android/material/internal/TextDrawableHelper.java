package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.common.hash.AbstractHasher;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class TextDrawableHelper {
    public WeakReference<TextDrawableDelegate> delegate;
    public TextAppearance textAppearance;
    public float textWidth;
    public final TextPaint textPaint = new TextPaint(1);
    public final AnonymousClass1 fontCallback = new AbstractHasher() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // com.google.common.hash.AbstractHasher
        public final void onFontRetrievalFailed(int r2) {
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = textDrawableHelper.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        @Override // com.google.common.hash.AbstractHasher
        public final void onFontRetrieved(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            TextDrawableHelper textDrawableHelper = TextDrawableHelper.this;
            textDrawableHelper.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = textDrawableHelper.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }
    };
    public boolean textWidthDirty = true;

    /* loaded from: classes3.dex */
    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] r1);

        void onTextSizeChange();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.material.internal.TextDrawableHelper$1] */
    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        this.delegate = new WeakReference<>(null);
        this.delegate = new WeakReference<>(textDrawableDelegate);
    }

    public final float getTextWidth(String str) {
        float measureText;
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        if (str == null) {
            measureText = 0.0f;
        } else {
            measureText = this.textPaint.measureText((CharSequence) str, 0, str.length());
        }
        this.textWidth = measureText;
        this.textWidthDirty = false;
        return measureText;
    }

    public final void setTextAppearance(TextAppearance textAppearance, Context context) {
        if (this.textAppearance != textAppearance) {
            this.textAppearance = textAppearance;
            if (textAppearance != null) {
                TextPaint textPaint = this.textPaint;
                AnonymousClass1 anonymousClass1 = this.fontCallback;
                textAppearance.updateMeasureState(context, textPaint, anonymousClass1);
                TextDrawableDelegate textDrawableDelegate = this.delegate.get();
                if (textDrawableDelegate != null) {
                    textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, textPaint, anonymousClass1);
                this.textWidthDirty = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }
}
