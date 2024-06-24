package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: EdgeEffectCompat.kt */
/* loaded from: classes.dex */
public final class GlowEdgeEffectCompat extends EdgeEffect {
    public float oppositeReleaseDelta;
    public final float oppositeReleaseDeltaThreshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlowEdgeEffectCompat(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.oppositeReleaseDeltaThreshold = TimeZoneKt.Density(context).density * 1;
    }

    @Override // android.widget.EdgeEffect
    public final void onAbsorb(int r2) {
        this.oppositeReleaseDelta = 0.0f;
        super.onAbsorb(r2);
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f, float f2) {
        this.oppositeReleaseDelta = 0.0f;
        super.onPull(f, f2);
    }

    @Override // android.widget.EdgeEffect
    public final void onRelease() {
        this.oppositeReleaseDelta = 0.0f;
        super.onRelease();
    }

    @Override // android.widget.EdgeEffect
    public final void onPull(float f) {
        this.oppositeReleaseDelta = 0.0f;
        super.onPull(f);
    }
}
