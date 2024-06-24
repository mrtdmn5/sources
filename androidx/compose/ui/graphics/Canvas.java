package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public interface Canvas {
    /* renamed from: clipPath-mtrdD-E */
    void mo282clipPathmtrdDE(Path path, int r2);

    /* renamed from: clipRect-N_I0leg */
    void mo283clipRectN_I0leg(float f, float f2, float f3, float f4, int r5);

    /* renamed from: clipRect-mtrdD-E, reason: not valid java name */
    default void m314clipRectmtrdDE(Rect rect, int r8) {
        mo283clipRectN_I0leg(rect.left, rect.top, rect.right, rect.bottom, r8);
    }

    /* renamed from: concat-58bKbWc */
    void mo284concat58bKbWc(float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, Paint paint);

    /* renamed from: drawCircle-9KIMszo */
    void mo285drawCircle9KIMszo(float f, long j, Paint paint);

    /* renamed from: drawImage-d-4ec7I */
    void mo286drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint);

    /* renamed from: drawImageRect-HPBpro0 */
    void mo287drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint);

    /* renamed from: drawLine-Wko1d7g */
    void mo288drawLineWko1d7g(long j, long j2, Paint paint);

    void drawPath(Path path, Paint paint);

    /* renamed from: drawPoints-O7TthRY */
    void mo289drawPointsO7TthRY(Paint paint, ArrayList arrayList);

    void drawRect(float f, float f2, float f3, float f4, Paint paint);

    default void drawRect(Rect rect, AndroidPaint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint);

    void enableZ();

    void restore();

    void rotate();

    void save();

    void saveLayer(Rect rect, Paint paint);

    void scale();

    void translate(float f, float f2);
}
