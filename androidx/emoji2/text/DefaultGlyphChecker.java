package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    public static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
    public final TextPaint mTextPaint;

    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
