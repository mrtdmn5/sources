package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndentationFixSpan.kt */
/* loaded from: classes.dex */
public final class IndentationFixSpanKt {

    /* compiled from: IndentationFixSpan.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Layout.Alignment.values().length];
            try {
                r0[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final float getEllipsizedLeftPadding(Layout layout, int r5, Paint paint) {
        int r52;
        float abs;
        float width;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float lineLeft = layout.getLineLeft(r5);
        if (!TextLayoutKt.isLineEllipsized(layout, r5) || layout.getParagraphDirection(r5) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float measureText = paint.measureText("…") + (layout.getPrimaryHorizontal(layout.getEllipsisStart(r5) + layout.getLineStart(r5)) - lineLeft);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(r5);
        if (paragraphAlignment == null) {
            r52 = -1;
        } else {
            r52 = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
        }
        if (r52 == 1) {
            abs = Math.abs(lineLeft);
            width = (layout.getWidth() - measureText) / 2.0f;
        } else {
            abs = Math.abs(lineLeft);
            width = layout.getWidth() - measureText;
        }
        return width + abs;
    }

    public static final float getEllipsizedRightPadding(Layout layout, int r4, Paint paint) {
        float width;
        float width2;
        Intrinsics.checkNotNullParameter(layout, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (TextLayoutKt.isLineEllipsized(layout, r4)) {
            int r1 = -1;
            if (layout.getParagraphDirection(r4) == -1 && layout.getWidth() < layout.getLineRight(r4)) {
                float measureText = paint.measureText("…") + (layout.getLineRight(r4) - layout.getPrimaryHorizontal(layout.getEllipsisStart(r4) + layout.getLineStart(r4)));
                Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(r4);
                if (paragraphAlignment != null) {
                    r1 = WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()];
                }
                if (r1 == 1) {
                    width = layout.getWidth() - layout.getLineRight(r4);
                    width2 = (layout.getWidth() - measureText) / 2.0f;
                } else {
                    width = layout.getWidth() - layout.getLineRight(r4);
                    width2 = layout.getWidth() - measureText;
                }
                return width - width2;
            }
            return 0.0f;
        }
        return 0.0f;
    }
}
