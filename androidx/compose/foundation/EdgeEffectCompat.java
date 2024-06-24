package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EdgeEffectCompat.kt */
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public static EdgeEffect create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.create(context, null);
        }
        return new GlowEdgeEffectCompat(context);
    }

    public static float getDistanceCompat(EdgeEffect edgeEffect) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public static void onPullDistanceCompat(EdgeEffect edgeEffect, float f) {
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.INSTANCE.onPullDistance(edgeEffect, f, 0.0f);
        } else {
            edgeEffect.onPull(f, 0.0f);
        }
    }
}
