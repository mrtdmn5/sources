package androidx.compose.ui.text;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.platform.AndroidMultiParagraphDrawKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MultiParagraph.kt */
/* loaded from: classes.dex */
public final class MultiParagraph {
    public final boolean didExceedMaxLines;
    public final float height;
    public final MultiParagraphIntrinsics intrinsics;
    public final int lineCount;
    public final int maxLines;
    public final ArrayList paragraphInfoList;
    public final ArrayList placeholderRects;
    public final float width;

    public MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j, int r24, boolean z) {
        boolean z2;
        boolean z3;
        Rect rect;
        int m564getMaxHeightimpl;
        this.intrinsics = multiParagraphIntrinsics;
        this.maxLines = r24;
        if (Constraints.m567getMinWidthimpl(j) == 0 && Constraints.m566getMinHeightimpl(j) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = multiParagraphIntrinsics.infoList;
            int size = arrayList2.size();
            float f = 0.0f;
            int r6 = 0;
            int r11 = 0;
            while (r6 < size) {
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) arrayList2.get(r6);
                ParagraphIntrinsics paragraphIntrinsics = paragraphIntrinsicInfo.intrinsics;
                int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                if (Constraints.m560getHasBoundedHeightimpl(j)) {
                    m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j) - ((int) Math.ceil(f));
                    if (m564getMaxHeightimpl < 0) {
                        m564getMaxHeightimpl = 0;
                    }
                } else {
                    m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
                }
                long Constraints$default = ConstraintsKt.Constraints$default(m565getMaxWidthimpl, m564getMaxHeightimpl, 5);
                int r16 = this.maxLines - r11;
                Intrinsics.checkNotNullParameter(paragraphIntrinsics, "paragraphIntrinsics");
                AndroidParagraph androidParagraph = new AndroidParagraph((AndroidParagraphIntrinsics) paragraphIntrinsics, r16, z, Constraints$default);
                float height = androidParagraph.getHeight() + f;
                TextLayout textLayout = androidParagraph.layout;
                int r12 = r11 + textLayout.lineCount;
                arrayList.add(new ParagraphInfo(androidParagraph, paragraphIntrinsicInfo.startIndex, paragraphIntrinsicInfo.endIndex, r11, r12, f, height));
                if (!textLayout.didExceedMaxLines) {
                    r11 = r12;
                    if (r11 != this.maxLines || r6 == CollectionsKt__CollectionsKt.getLastIndex(this.intrinsics.infoList)) {
                        r6++;
                        f = height;
                    }
                } else {
                    r11 = r12;
                }
                f = height;
                z3 = true;
                break;
            }
            z3 = false;
            this.height = f;
            this.lineCount = r11;
            this.didExceedMaxLines = z3;
            this.paragraphInfoList = arrayList;
            this.width = Constraints.m565getMaxWidthimpl(j);
            ArrayList arrayList3 = new ArrayList(arrayList.size());
            int size2 = arrayList.size();
            for (int r4 = 0; r4 < size2; r4++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(r4);
                List<Rect> placeholderRects = paragraphInfo.paragraph.getPlaceholderRects();
                ArrayList arrayList4 = new ArrayList(placeholderRects.size());
                int size3 = placeholderRects.size();
                for (int r10 = 0; r10 < size3; r10++) {
                    Rect rect2 = placeholderRects.get(r10);
                    if (rect2 != null) {
                        rect = paragraphInfo.toGlobal(rect2);
                    } else {
                        rect = null;
                    }
                    arrayList4.add(rect);
                }
                CollectionsKt__ReversedViewsKt.addAll(arrayList4, arrayList3);
            }
            if (arrayList3.size() < this.intrinsics.placeholders.size()) {
                int size4 = this.intrinsics.placeholders.size() - arrayList3.size();
                ArrayList arrayList5 = new ArrayList(size4);
                for (int r42 = 0; r42 < size4; r42++) {
                    arrayList5.add(null);
                }
                arrayList3 = CollectionsKt___CollectionsKt.plus((Iterable) arrayList5, (Collection) arrayList3);
            }
            this.placeholderRects = arrayList3;
            return;
        }
        throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.".toString());
    }

    /* renamed from: paint-LG529CI$default, reason: not valid java name */
    public static void m512paintLG529CI$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        multiParagraph.getClass();
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        int size = arrayList.size();
        for (int r12 = 0; r12 < size; r12++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(r12);
            paragraphInfo.paragraph.mo509paintLG529CI(canvas, j, shadow, textDecoration, drawStyle, 3);
            canvas.translate(0.0f, paragraphInfo.paragraph.getHeight());
        }
        canvas.restore();
    }

    /* renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static void m513painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        multiParagraph.getClass();
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (arrayList.size() <= 1) {
            AndroidMultiParagraphDrawKt.m546drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle, 3);
        } else if (brush instanceof SolidColor) {
            AndroidMultiParagraphDrawKt.m546drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle, 3);
        } else if (brush instanceof ShaderBrush) {
            int size = arrayList.size();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int r3 = 0; r3 < size; r3++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(r3);
                f3 += paragraphInfo.paragraph.getHeight();
                f2 = Math.max(f2, paragraphInfo.paragraph.getWidth());
            }
            Shader mo312createShaderuvyYCjk = ((ShaderBrush) brush).mo312createShaderuvyYCjk(SizeKt.Size(f2, f3));
            Matrix matrix = new Matrix();
            mo312createShaderuvyYCjk.getLocalMatrix(matrix);
            int size2 = arrayList.size();
            for (int r15 = 0; r15 < size2; r15++) {
                ParagraphInfo paragraphInfo2 = (ParagraphInfo) arrayList.get(r15);
                paragraphInfo2.paragraph.mo510painthn5TExg(canvas, new BrushKt$ShaderBrush$1(mo312createShaderuvyYCjk), f, shadow, textDecoration, drawStyle, 3);
                Paragraph paragraph = paragraphInfo2.paragraph;
                canvas.translate(0.0f, paragraph.getHeight());
                matrix.setTranslate(0.0f, -paragraph.getHeight());
                mo312createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    public final void requireIndexInRangeInclusiveEnd(int r4) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.intrinsics;
        boolean z = false;
        if (r4 >= 0 && r4 <= multiParagraphIntrinsics.annotatedString.text.length()) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("offset(", r4, ") is out of bounds [0, ");
        m.append(multiParagraphIntrinsics.annotatedString.length());
        m.append(']');
        throw new IllegalArgumentException(m.toString().toString());
    }

    public final void requireLineIndexInRange(int r4) {
        int r0 = this.lineCount;
        boolean z = false;
        if (r4 >= 0 && r4 < r0) {
            z = true;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("lineIndex(" + r4 + ") is out of bounds [0, " + r0 + ')').toString());
    }
}
