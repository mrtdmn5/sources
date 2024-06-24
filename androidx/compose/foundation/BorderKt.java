package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Border.kt */
/* loaded from: classes.dex */
public final class BorderKt {
    public static final Modifier border(BorderStroke border, Shape shape) {
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Brush brush = border.brush;
        Intrinsics.checkNotNullParameter(brush, "brush");
        return new BorderModifierNodeElement(border.width, brush, shape);
    }

    /* renamed from: shrink-Kibmq7A, reason: not valid java name */
    public static final long m23shrinkKibmq7A(float f, long j) {
        return CornerRadiusKt.CornerRadius(Math.max(0.0f, CornerRadius.m253getXimpl(j) - f), Math.max(0.0f, CornerRadius.m254getYimpl(j) - f));
    }
}
