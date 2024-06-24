package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    public TextPaint mWorkingPaint;

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int r16, int r17, float f, int r19, int r20, int r21, Paint paint) {
        Paint paint2 = paint;
        TextPaint textPaint = null;
        if (charSequence instanceof Spanned) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(r16, r17, CharacterStyle.class);
            if (characterStyleArr.length != 0) {
                if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                    TextPaint textPaint2 = this.mWorkingPaint;
                    if (textPaint2 == null) {
                        textPaint2 = new TextPaint();
                        this.mWorkingPaint = textPaint2;
                    }
                    textPaint = textPaint2;
                    textPaint.set(paint2);
                    for (CharacterStyle characterStyle : characterStyleArr) {
                        if (!(characterStyle instanceof MetricAffectingSpan)) {
                            characterStyle.updateDrawState(textPaint);
                        }
                    }
                }
            }
            if (paint2 instanceof TextPaint) {
                textPaint = (TextPaint) paint2;
            }
        } else if (paint2 instanceof TextPaint) {
            textPaint = (TextPaint) paint2;
        }
        if (textPaint != null && textPaint.bgColor != 0) {
            int color = textPaint.getColor();
            Paint.Style style = textPaint.getStyle();
            textPaint.setColor(textPaint.bgColor);
            textPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(f, r19, f + this.mWidth, r21, textPaint);
            textPaint.setStyle(style);
            textPaint.setColor(color);
        }
        EmojiCompat.get().getClass();
        float f2 = r20;
        if (textPaint != null) {
            paint2 = textPaint;
        }
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataRepo metadataRepo = typefaceEmojiRasterizer.mMetadataRepo;
        Typeface typeface = metadataRepo.mTypeface;
        Typeface typeface2 = paint2.getTypeface();
        paint2.setTypeface(typeface);
        canvas.drawText(metadataRepo.mEmojiCharArray, typefaceEmojiRasterizer.mIndex * 2, 2, f, f2, paint2);
        paint2.setTypeface(typeface2);
    }
}
