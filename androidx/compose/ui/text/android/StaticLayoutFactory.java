package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextUtils;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
/* loaded from: classes.dex */
public final class StaticLayoutFactory {
    public static final StaticLayoutFactory23 delegate = new StaticLayoutFactory23();

    public static StaticLayout create(CharSequence text, int r25, int r26, AndroidTextPaint paint, int r28, TextDirectionHeuristic textDir, Layout.Alignment alignment, int r31, TextUtils.TruncateAt truncateAt, int r33, float f, float f2, int r36, boolean z, boolean z2, int r39, int r40, int r41, int r42, int[] r43, int[] r44) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return delegate.create(new StaticLayoutParams(text, r25, r26, paint, r28, textDir, alignment, r31, truncateAt, r33, f, f2, r36, z, z2, r39, r40, r41, r42, r43, r44));
    }
}
