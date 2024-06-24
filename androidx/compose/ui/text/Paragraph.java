package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;

/* compiled from: Paragraph.android.kt */
/* loaded from: classes.dex */
public interface Paragraph {
    ResolvedTextDirection getBidiRunDirection(int r1);

    Rect getBoundingBox(int r1);

    Rect getCursorRect(int r1);

    float getFirstBaseline();

    float getHeight();

    float getHorizontalPosition(int r1, boolean z);

    float getLastBaseline();

    float getLineBottom(int r1);

    int getLineEnd(int r1, boolean z);

    int getLineForOffset(int r1);

    int getLineForVerticalPosition(float f);

    float getLineLeft(int r1);

    float getLineRight(int r1);

    int getLineStart(int r1);

    float getLineTop(int r1);

    /* renamed from: getOffsetForPosition-k-4lQ0M */
    int mo507getOffsetForPositionk4lQ0M(long j);

    ResolvedTextDirection getParagraphDirection(int r1);

    AndroidPath getPathForRange(int r1, int r2);

    List<Rect> getPlaceholderRects();

    float getWidth();

    /* renamed from: getWordBoundary--jx7JFs */
    long mo508getWordBoundaryjx7JFs(int r1);

    boolean isLineEllipsized(int r1);

    /* renamed from: paint-LG529CI */
    void mo509paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int r7);

    /* renamed from: paint-hn5TExg */
    void mo510painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int r7);
}
