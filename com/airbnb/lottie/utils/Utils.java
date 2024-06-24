package com.airbnb.lottie.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.airbnb.lottie.L;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class Utils {
    public static final AnonymousClass1 threadLocalPathMeasure = new AnonymousClass1();
    public static final AnonymousClass2 threadLocalTempPath = new AnonymousClass2();
    public static final AnonymousClass3 threadLocalTempPath2 = new AnonymousClass3();
    public static final AnonymousClass4 threadLocalPoints = new AnonymousClass4();
    public static final float INV_SQRT_2 = (float) (Math.sqrt(2.0d) / 2.0d);

    /* renamed from: com.airbnb.lottie.utils.Utils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends ThreadLocal<PathMeasure> {
        @Override // java.lang.ThreadLocal
        public final PathMeasure initialValue() {
            return new PathMeasure();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends ThreadLocal<Path> {
        @Override // java.lang.ThreadLocal
        public final Path initialValue() {
            return new Path();
        }
    }

    /* renamed from: com.airbnb.lottie.utils.Utils$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends ThreadLocal<float[]> {
        @Override // java.lang.ThreadLocal
        public final float[] initialValue() {
            return new float[4];
        }
    }

    public static void applyTrimPathIfNeeded(Path path, float f, float f2, float f3) {
        PathMeasure pathMeasure = threadLocalPathMeasure.get();
        Path path2 = threadLocalTempPath.get();
        Path path3 = threadLocalTempPath2.get();
        pathMeasure.setPath(path, false);
        float length = pathMeasure.getLength();
        if (f == 1.0f && f2 == 0.0f) {
            L.endSection();
            return;
        }
        if (length >= 1.0f && Math.abs((f2 - f) - 1.0f) >= 0.01d) {
            float f4 = f * length;
            float f5 = f2 * length;
            float f6 = f3 * length;
            float min = Math.min(f4, f5) + f6;
            float max = Math.max(f4, f5) + f6;
            if (min >= length && max >= length) {
                min = MiscUtils.floorMod(min, length);
                max = MiscUtils.floorMod(max, length);
            }
            if (min < 0.0f) {
                min = MiscUtils.floorMod(min, length);
            }
            if (max < 0.0f) {
                max = MiscUtils.floorMod(max, length);
            }
            if (min == max) {
                path.reset();
                L.endSection();
                return;
            }
            if (min >= max) {
                min -= length;
            }
            path2.reset();
            pathMeasure.getSegment(min, max, path2, true);
            if (max > length) {
                path3.reset();
                pathMeasure.getSegment(0.0f, max % length, path3, true);
                path2.addPath(path3);
            } else if (min < 0.0f) {
                path3.reset();
                pathMeasure.getSegment(min + length, length, path3, true);
                path2.addPath(path3);
            }
            path.set(path2);
            L.endSection();
            return;
        }
        L.endSection();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static float dpScale() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static float getScale(Matrix matrix) {
        float[] fArr = threadLocalPoints.get();
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        float f = INV_SQRT_2;
        fArr[2] = f;
        fArr[3] = f;
        matrix.mapPoints(fArr);
        return (float) Math.hypot(fArr[2] - fArr[0], fArr[3] - fArr[1]);
    }

    public static Bitmap resizeBitmapIfNeeded(Bitmap bitmap, int r2, int r3) {
        if (bitmap.getWidth() == r2 && bitmap.getHeight() == r3) {
            return bitmap;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, r2, r3, true);
        bitmap.recycle();
        return createScaledBitmap;
    }
}
