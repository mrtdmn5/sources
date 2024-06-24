package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoringLayoutFactory.kt */
/* loaded from: classes.dex */
public final class BoringLayoutFactory33 {
    public static final BoringLayout create(CharSequence text, TextPaint paint, int r14, Layout.Alignment alignment, float f, float f2, BoringLayout.Metrics metrics, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int r22) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return BoringLayoutFactory33$$ExternalSyntheticApiModelOutline2.m(text, paint, r14, alignment, f, f2, metrics, z, truncateAt, r22, z2);
    }

    public static final BoringLayout.Metrics isBoring(CharSequence text, TextPaint paint, TextDirectionHeuristic textDir) {
        BoringLayout.Metrics isBoring;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(textDir, "textDir");
        isBoring = BoringLayout.isBoring(text, paint, textDir, true, null);
        return isBoring;
    }
}
