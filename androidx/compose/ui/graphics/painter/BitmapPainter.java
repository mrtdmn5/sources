package androidx.compose.ui.graphics.painter;

import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: BitmapPainter.kt */
/* loaded from: classes.dex */
public final class BitmapPainter extends Painter {
    public float alpha;
    public ColorFilter colorFilter;
    public int filterQuality;
    public final ImageBitmap image;
    public final long size;
    public final long srcOffset;
    public final long srcSize;

    public BitmapPainter(ImageBitmap image, long j, long j2) {
        int r6;
        Intrinsics.checkNotNullParameter(image, "image");
        this.image = image;
        this.srcOffset = j;
        this.srcSize = j2;
        this.filterQuality = 1;
        int r1 = IntOffset.$r8$clinit;
        if (((int) (j >> 32)) >= 0 && IntOffset.m590getYimpl(j) >= 0 && (r6 = (int) (j2 >> 32)) >= 0 && IntSize.m593getHeightimpl(j2) >= 0 && r6 <= image.getWidth() && IntSize.m593getHeightimpl(j2) <= image.getHeight()) {
            this.size = j2;
            this.alpha = 1.0f;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyAlpha(float f) {
        this.alpha = f;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final boolean applyColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        return true;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapPainter)) {
            return false;
        }
        BitmapPainter bitmapPainter = (BitmapPainter) obj;
        if (!Intrinsics.areEqual(this.image, bitmapPainter.image) || !IntOffset.m589equalsimpl0(this.srcOffset, bitmapPainter.srcOffset) || !IntSize.m592equalsimpl0(this.srcSize, bitmapPainter.srcSize)) {
            return false;
        }
        if (this.filterQuality == bitmapPainter.filterQuality) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public final long mo392getIntrinsicSizeNHjbRc() {
        return IntSizeKt.m595toSizeozmzZPI(this.size);
    }

    public final int hashCode() {
        int hashCode = this.image.hashCode() * 31;
        int r1 = IntOffset.$r8$clinit;
        return Integer.hashCode(this.filterQuality) + Scale$$ExternalSyntheticOutline0.m(this.srcSize, Scale$$ExternalSyntheticOutline0.m(this.srcOffset, hashCode, 31), 31);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        DrawScope.m379drawImageAZ2fEMs$default(drawScope, this.image, this.srcOffset, this.srcSize, 0L, IntSizeKt.IntSize(MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(drawScope.mo391getSizeNHjbRc())), MathKt__MathJVMKt.roundToInt(Size.m274getHeightimpl(drawScope.mo391getSizeNHjbRc()))), this.alpha, null, this.colorFilter, 0, this.filterQuality, 328);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        StringBuilder sb = new StringBuilder("BitmapPainter(image=");
        sb.append(this.image);
        sb.append(", srcOffset=");
        sb.append((Object) IntOffset.m591toStringimpl(this.srcOffset));
        sb.append(", srcSize=");
        sb.append((Object) IntSize.m594toStringimpl(this.srcSize));
        sb.append(", filterQuality=");
        int r1 = this.filterQuality;
        boolean z4 = false;
        if (r1 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "None";
        } else {
            if (r1 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = "Low";
            } else {
                if (r1 == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    str = "Medium";
                } else {
                    if (r1 == 3) {
                        z4 = true;
                    }
                    if (z4) {
                        str = "High";
                    } else {
                        str = "Unknown";
                    }
                }
            }
        }
        sb.append((Object) str);
        sb.append(')');
        return sb.toString();
    }

    public BitmapPainter(ImageBitmap imageBitmap) {
        this(imageBitmap, IntOffset.Zero, IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight()));
    }
}
