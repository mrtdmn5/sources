package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;

/* loaded from: classes.dex */
public abstract class EmojiSpan extends ReplacementSpan {
    public final TypefaceEmojiRasterizer mRasterizer;
    public final Paint.FontMetricsInt mTmpFontMetrics = new Paint.FontMetricsInt();
    public short mWidth = -1;
    public float mRatio = 1.0f;

    public EmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (typefaceEmojiRasterizer != null) {
            this.mRasterizer = typefaceEmojiRasterizer;
            return;
        }
        throw new NullPointerException("rasterizer cannot be null");
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int r7, int r8, Paint.FontMetricsInt fontMetricsInt) {
        short s;
        Paint.FontMetricsInt fontMetricsInt2 = this.mTmpFontMetrics;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        TypefaceEmojiRasterizer typefaceEmojiRasterizer = this.mRasterizer;
        MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
        int __offset = metadataItem.__offset(14);
        short s2 = 0;
        if (__offset != 0) {
            s = metadataItem.bb.getShort(__offset + metadataItem.bb_pos);
        } else {
            s = 0;
        }
        this.mRatio = abs / s;
        MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
        int __offset2 = metadataItem2.__offset(14);
        if (__offset2 != 0) {
            metadataItem2.bb.getShort(__offset2 + metadataItem2.bb_pos);
        }
        MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
        int __offset3 = metadataItem3.__offset(12);
        if (__offset3 != 0) {
            s2 = metadataItem3.bb.getShort(__offset3 + metadataItem3.bb_pos);
        }
        short s3 = (short) (s2 * this.mRatio);
        this.mWidth = s3;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s3;
    }
}
