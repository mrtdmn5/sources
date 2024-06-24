package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutParams {
    public final Layout.Alignment alignment;
    public final int breakStrategy;
    public final TextUtils.TruncateAt ellipsize;
    public final int ellipsizedWidth;
    public final int end;
    public final int hyphenationFrequency;
    public final boolean includePadding;
    public final int justificationMode;
    public final int[] leftIndents;
    public final int lineBreakStyle;
    public final int lineBreakWordStyle;
    public final float lineSpacingExtra;
    public final float lineSpacingMultiplier;
    public final int maxLines;
    public final TextPaint paint;
    public final int[] rightIndents;
    public final int start;
    public final CharSequence text;
    public final TextDirectionHeuristic textDir;
    public final boolean useFallbackLineSpacing;
    public final int width;

    public StaticLayoutParams(CharSequence text, int r14, int r15, AndroidTextPaint paint, int r17, TextDirectionHeuristic textDir, Layout.Alignment alignment, int r20, TextUtils.TruncateAt truncateAt, int r22, float f, float f2, int r25, boolean z, boolean z2, int r28, int r29, int r30, int r31, int[] r32, int[] r33) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.text = text;
        this.start = r14;
        this.end = r15;
        this.paint = paint;
        this.width = r17;
        this.textDir = textDir;
        this.alignment = alignment;
        this.maxLines = r20;
        this.ellipsize = truncateAt;
        this.ellipsizedWidth = r22;
        this.lineSpacingMultiplier = f;
        this.lineSpacingExtra = f2;
        this.justificationMode = r25;
        this.includePadding = z;
        this.useFallbackLineSpacing = z2;
        this.breakStrategy = r28;
        this.lineBreakStyle = r29;
        this.lineBreakWordStyle = r30;
        this.hyphenationFrequency = r31;
        this.leftIndents = r32;
        this.rightIndents = r33;
        if (!(r14 >= 0 && r14 <= r15)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(r15 >= 0 && r15 <= text.length())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(r20 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(r17 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(r22 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(f >= 0.0f)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
