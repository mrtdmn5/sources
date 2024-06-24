package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat$Api21Impl;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class KeyframeParser {
    public static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;
    public static final LinearInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final JsonReader.Options NAMES = JsonReader.Options.of("t", "s", "e", "o", "i", "h", "to", "ti");
    public static final JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of("x", DateTimeFormattersKt.yearNoPaddingFormat);

    public static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        int r1;
        Interpolator interpolator;
        WeakReference weakReference;
        Interpolator linearInterpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        float clamp = MiscUtils.clamp(pointF2.y, -100.0f, 100.0f);
        pointF2.y = clamp;
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = pointF2.x;
        Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
        if (f != 0.0f) {
            r1 = (int) (527 * f);
        } else {
            r1 = 17;
        }
        if (f2 != 0.0f) {
            r1 = (int) (r1 * 31 * f2);
        }
        if (f3 != 0.0f) {
            r1 = (int) (r1 * 31 * f3);
        }
        if (clamp != 0.0f) {
            r1 = (int) (r1 * 31 * clamp);
        }
        synchronized (KeyframeParser.class) {
            if (pathInterpolatorCache == null) {
                pathInterpolatorCache = new SparseArrayCompat<>();
            }
            interpolator = null;
            weakReference = (WeakReference) pathInterpolatorCache.get(r1, null);
        }
        if (weakReference != null) {
            interpolator = (Interpolator) weakReference.get();
        }
        if (weakReference == null || interpolator == null) {
            try {
                linearInterpolator = PathInterpolatorCompat$Api21Impl.createPathInterpolator(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = PathInterpolatorCompat$Api21Impl.createPathInterpolator(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            try {
                WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                synchronized (KeyframeParser.class) {
                    pathInterpolatorCache.put(r1, weakReference2);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:139:0x0243. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x002d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0200 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.animation.Interpolator] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.airbnb.lottie.value.Keyframe<T> parse(com.airbnb.lottie.parser.moshi.JsonReader r25, com.airbnb.lottie.LottieComposition r26, float r27, com.airbnb.lottie.parser.ValueParser<T> r28, boolean r29, boolean r30) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition, float, com.airbnb.lottie.parser.ValueParser, boolean, boolean):com.airbnb.lottie.value.Keyframe");
    }
}
