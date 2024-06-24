package androidx.compose.foundation;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EdgeEffectCompat.kt */
/* loaded from: classes.dex */
public final class Api31Impl {
    public static final Api31Impl INSTANCE = new Api31Impl();

    public final EdgeEffect create(Context context, AttributeSet attributeSet) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return new EdgeEffect(context, attributeSet);
        } catch (Throwable unused) {
            return new EdgeEffect(context);
        }
    }

    public final float getDistance(EdgeEffect edgeEffect) {
        Intrinsics.checkNotNullParameter(edgeEffect, "edgeEffect");
        try {
            return edgeEffect.getDistance();
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    public final float onPullDistance(EdgeEffect edgeEffect, float f, float f2) {
        Intrinsics.checkNotNullParameter(edgeEffect, "edgeEffect");
        try {
            return edgeEffect.onPullDistance(f, f2);
        } catch (Throwable unused) {
            edgeEffect.onPull(f, f2);
            return 0.0f;
        }
    }
}
