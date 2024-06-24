package androidx.compose.ui.text.platform;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.ArrayList;

/* compiled from: AndroidMultiParagraphDraw.kt */
/* loaded from: classes.dex */
public final class AndroidMultiParagraphDrawKt {
    /* renamed from: drawParagraphs-7AXcY_I, reason: not valid java name */
    public static final void m546drawParagraphs7AXcY_I(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int r19) {
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(r2);
            paragraphInfo.paragraph.mo510painthn5TExg(canvas, brush, f, shadow, textDecoration, drawStyle, r19);
            canvas.translate(0.0f, paragraphInfo.paragraph.getHeight());
        }
    }
}
