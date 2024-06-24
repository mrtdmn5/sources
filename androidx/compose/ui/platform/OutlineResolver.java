package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: OutlineResolver.android.kt */
/* loaded from: classes.dex */
public final class OutlineResolver {
    public boolean cacheIsDirty;
    public final Outline cachedOutline;
    public AndroidPath cachedRrectPath;
    public androidx.compose.ui.graphics.Outline calculatedOutline;
    public Density density;
    public boolean isSupportedOutline;
    public LayoutDirection layoutDirection;
    public boolean outlineNeeded;
    public Path outlinePath;
    public long rectSize;
    public long rectTopLeft;
    public float roundedCornerRadius;
    public Shape shape;
    public long size;
    public Path tmpPath;
    public RoundRect tmpRoundRect;
    public boolean usePathForClip;

    public OutlineResolver(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.density = density;
        this.isSupportedOutline = true;
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        long j = Size.Zero;
        this.size = j;
        this.shape = RectangleShapeKt.RectangleShape;
        this.rectTopLeft = Offset.Zero;
        this.rectSize = j;
        this.layoutDirection = LayoutDirection.Ltr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:            if (r8 == false) goto L41;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void clipToOutline(androidx.compose.ui.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.clipToOutline(androidx.compose.ui.graphics.Canvas):void");
    }

    public final Outline getOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m502isInOutlinek4lQ0M(long r19) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.OutlineResolver.m502isInOutlinek4lQ0M(long):boolean");
    }

    public final boolean update(Shape shape, float f, boolean z, float f2, LayoutDirection layoutDirection, Density density) {
        boolean z2;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(density, "density");
        this.cachedOutline.setAlpha(f);
        boolean z3 = !Intrinsics.areEqual(this.shape, shape);
        if (z3) {
            this.shape = shape;
            this.cacheIsDirty = true;
        }
        if (!z && f2 <= 0.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (this.outlineNeeded != z2) {
            this.outlineNeeded = z2;
            this.cacheIsDirty = true;
        }
        if (this.layoutDirection != layoutDirection) {
            this.layoutDirection = layoutDirection;
            this.cacheIsDirty = true;
        }
        if (!Intrinsics.areEqual(this.density, density)) {
            this.density = density;
            this.cacheIsDirty = true;
        }
        return z3;
    }

    public final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Zero;
            long j = this.size;
            this.rectSize = j;
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            boolean z = this.outlineNeeded;
            Outline outline = this.cachedOutline;
            if (z && Size.m276getWidthimpl(j) > 0.0f && Size.m274getHeightimpl(this.size) > 0.0f) {
                this.isSupportedOutline = true;
                androidx.compose.ui.graphics.Outline mo27createOutlinePq9zytI = this.shape.mo27createOutlinePq9zytI(this.size, this.layoutDirection, this.density);
                this.calculatedOutline = mo27createOutlinePq9zytI;
                if (mo27createOutlinePq9zytI instanceof Outline.Rectangle) {
                    Rect rect = ((Outline.Rectangle) mo27createOutlinePq9zytI).rect;
                    float f = rect.left;
                    float f2 = rect.top;
                    this.rectTopLeft = OffsetKt.Offset(f, f2);
                    float f3 = rect.right;
                    float f4 = rect.left;
                    float f5 = rect.bottom;
                    this.rectSize = SizeKt.Size(f3 - f4, f5 - f2);
                    outline.setRect(MathKt__MathJVMKt.roundToInt(f4), MathKt__MathJVMKt.roundToInt(f2), MathKt__MathJVMKt.roundToInt(f3), MathKt__MathJVMKt.roundToInt(f5));
                    return;
                }
                if (mo27createOutlinePq9zytI instanceof Outline.Rounded) {
                    RoundRect roundRect = ((Outline.Rounded) mo27createOutlinePq9zytI).roundRect;
                    float m253getXimpl = CornerRadius.m253getXimpl(roundRect.topLeftCornerRadius);
                    float f6 = roundRect.left;
                    float f7 = roundRect.top;
                    this.rectTopLeft = OffsetKt.Offset(f6, f7);
                    float f8 = roundRect.right;
                    float f9 = roundRect.bottom;
                    this.rectSize = SizeKt.Size(f8 - f6, f9 - f7);
                    if (RoundRectKt.isSimple(roundRect)) {
                        this.cachedOutline.setRoundRect(MathKt__MathJVMKt.roundToInt(f6), MathKt__MathJVMKt.roundToInt(f7), MathKt__MathJVMKt.roundToInt(f8), MathKt__MathJVMKt.roundToInt(f9), m253getXimpl);
                        this.roundedCornerRadius = m253getXimpl;
                        return;
                    }
                    AndroidPath androidPath = this.cachedRrectPath;
                    if (androidPath == null) {
                        androidPath = OnTimeoutKt.Path();
                        this.cachedRrectPath = androidPath;
                    }
                    androidPath.reset();
                    androidPath.addRoundRect(roundRect);
                    updateCacheWithPath(androidPath);
                    return;
                }
                if (mo27createOutlinePq9zytI instanceof Outline.Generic) {
                    ((Outline.Generic) mo27createOutlinePq9zytI).getClass();
                    updateCacheWithPath(null);
                    return;
                }
                return;
            }
            outline.setEmpty();
        }
    }

    public final void updateCacheWithPath(Path path) {
        int r0 = Build.VERSION.SDK_INT;
        android.graphics.Outline outline = this.cachedOutline;
        if (r0 <= 28 && !path.isConvex()) {
            this.isSupportedOutline = false;
            outline.setEmpty();
            this.usePathForClip = true;
        } else if (path instanceof AndroidPath) {
            outline.setConvexPath(((AndroidPath) path).internalPath);
            this.usePathForClip = !outline.canClip();
        } else {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        this.outlinePath = path;
    }
}
