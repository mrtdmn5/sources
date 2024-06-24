package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoringLayoutFactory.kt */
/* loaded from: classes.dex */
public final class BoringLayoutFactoryDefault {
    public static final BoringLayout create(CharSequence text, TextPaint paint, int r14, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, TextUtils.TruncateAt truncateAt, int r21) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new BoringLayout(text, paint, r14, alignment, f, f2, metrics, z, truncateAt, r21);
    }

    public static final BoringLayout.Metrics isBoring(CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        if (textDir.isRtl(text, 0, text.length())) {
            return null;
        }
        return BoringLayout.isBoring(text, paint, null);
    }
}
