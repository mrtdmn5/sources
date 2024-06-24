package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Path;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: ShapeContainingUtil.kt */
/* loaded from: classes.dex */
public final class ShapeContainingUtilKt {
    public static final boolean isInPath(Path path, float f, float f2) {
        Rect rect = new Rect(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        AndroidPath Path = OnTimeoutKt.Path();
        Path.addRect(rect);
        AndroidPath Path2 = OnTimeoutKt.Path();
        Path2.mo305opN5in7k0(path, Path, 1);
        boolean isEmpty = Path2.isEmpty();
        Path2.reset();
        Path.reset();
        return !isEmpty;
    }

    /* renamed from: isWithinEllipse-VE1yxkc, reason: not valid java name */
    public static final boolean m503isWithinEllipseVE1yxkc(float f, float f2, float f3, float f4, long j) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float m253getXimpl = CornerRadius.m253getXimpl(j);
        float m254getYimpl = CornerRadius.m254getYimpl(j);
        if (((f6 * f6) / (m254getYimpl * m254getYimpl)) + ((f5 * f5) / (m253getXimpl * m253getXimpl)) <= 1.0f) {
            return true;
        }
        return false;
    }
}
