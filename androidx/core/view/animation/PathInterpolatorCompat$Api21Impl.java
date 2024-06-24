package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* loaded from: classes.dex */
public final class PathInterpolatorCompat$Api21Impl {
    public static Interpolator createPathInterpolator(Path path) {
        return new PathInterpolator(path);
    }

    public static Interpolator createPathInterpolator(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    public static Interpolator createPathInterpolator(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }
}
