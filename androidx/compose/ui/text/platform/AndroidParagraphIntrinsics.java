package androidx.compose.ui.text.platform;

import android.text.Layout;
import android.text.TextPaint;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.LayoutIntrinsicsKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    public final CharSequence charSequence;
    public final Density density;
    public final boolean emojiCompatProcessed;
    public final FontFamily.Resolver fontFamilyResolver;
    public final LayoutIntrinsics layoutIntrinsics;
    public final List<AnnotatedString.Range<Placeholder>> placeholders;
    public TypefaceDirtyTrackerLinkedList resolvedTypefaces;
    public final List<AnnotatedString.Range<SpanStyle>> spanStyles;
    public final TextStyle style;
    public final String text;
    public final int textDirectionHeuristic;
    public final AndroidTextPaint textPaint;

    /* JADX WARN: Code restructure failed: missing block: B:131:0x039b, code lost:            if (androidx.compose.ui.unit.TextUnitKt.m600isUnspecifiedR2X_6o(r10.lineHeight) == false) goto L668;     */
    /* JADX WARN: Code restructure failed: missing block: B:428:0x00c7, code lost:            if (r11 == null) goto L512;     */
    /* JADX WARN: Code restructure failed: missing block: B:431:0x00d5, code lost:            if (r11 == 1) goto L517;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02da A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x086a  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:380:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b8  */
    /* JADX WARN: Type inference failed for: r11v10, types: [androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.List<androidx.compose.ui.text.AnnotatedString$Range<androidx.compose.ui.text.SpanStyle>>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v8, types: [android.text.Spannable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidParagraphIntrinsics(androidx.compose.ui.text.TextStyle r40, androidx.compose.ui.text.font.FontFamily.Resolver r41, androidx.compose.ui.unit.Density r42, java.lang.String r43, java.util.List r44, java.util.List r45) {
        /*
            Method dump skipped, instructions count: 2192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics.<init>(androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.font.FontFamily$Resolver, androidx.compose.ui.unit.Density, java.lang.String, java.util.List, java.util.List):void");
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final boolean getHasStaleResolvedFonts() {
        boolean z;
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = this.resolvedTypefaces;
        if (typefaceDirtyTrackerLinkedList != null) {
            z = typefaceDirtyTrackerLinkedList.isStaleResolvedFont();
        } else {
            z = false;
        }
        if (!z) {
            if (this.emojiCompatProcessed || !AndroidParagraphIntrinsics_androidKt.access$getHasEmojiCompat(this.style)) {
                return false;
            }
            DefaultImpl defaultImpl = EmojiCompatStatus.delegate;
            DefaultImpl defaultImpl2 = EmojiCompatStatus.delegate;
            State<Boolean> state = defaultImpl2.loadState;
            if (state == null) {
                if (EmojiCompat.isConfigured()) {
                    state = defaultImpl2.getFontLoadState();
                    defaultImpl2.loadState = state;
                } else {
                    state = EmojiCompatStatusKt.Falsey;
                }
            }
            if (!state.getValue().booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public final float getMinIntrinsicWidth() {
        LayoutIntrinsics layoutIntrinsics = this.layoutIntrinsics;
        if (!Float.isNaN(layoutIntrinsics._minIntrinsicWidth)) {
            return layoutIntrinsics._minIntrinsicWidth;
        }
        CharSequence text = layoutIntrinsics.charSequence;
        Intrinsics.checkNotNullParameter(text, "text");
        TextPaint paint = layoutIntrinsics.textPaint;
        Intrinsics.checkNotNullParameter(paint, "paint");
        BreakIterator lineInstance = BreakIterator.getLineInstance(paint.getTextLocale());
        lineInstance.setText(new CharSequenceCharacterIterator(text.length(), text));
        PriorityQueue priorityQueue = new PriorityQueue(10, new LayoutIntrinsicsKt$$ExternalSyntheticLambda0());
        int r7 = 0;
        for (int next = lineInstance.next(); next != -1; next = lineInstance.next()) {
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(r7), Integer.valueOf(next)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.second).intValue() - ((Number) pair.first).intValue() < next - r7) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(r7), Integer.valueOf(next)));
                }
            }
            r7 = next;
        }
        Iterator it = priorityQueue.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            Pair pair2 = (Pair) it.next();
            f = Math.max(f, Layout.getDesiredWidth(text, ((Number) pair2.first).intValue(), ((Number) pair2.second).intValue(), paint));
        }
        layoutIntrinsics._minIntrinsicWidth = f;
        return f;
    }
}
