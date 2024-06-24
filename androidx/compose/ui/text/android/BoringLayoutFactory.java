package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.TextUtils;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BoringLayoutFactory.kt */
/* loaded from: classes.dex */
public final class BoringLayoutFactory {
    public static BoringLayout create(CharSequence text, AndroidTextPaint paint, int r14, BoringLayout.Metrics metrics, Layout.Alignment alignment, boolean z, boolean z2, TextUtils.TruncateAt truncateAt, int r20) {
        boolean z3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        boolean z4 = true;
        if (r14 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (r20 < 0) {
                z4 = false;
            }
            if (z4) {
                if (Build.VERSION.SDK_INT >= 33) {
                    return BoringLayoutFactory33.create(text, paint, r14, alignment, 1.0f, 0.0f, metrics, z, z2, truncateAt, r20);
                }
                return BoringLayoutFactoryDefault.create(text, paint, r14, alignment, 1.0f, 0.0f, metrics, z, truncateAt, r20);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
