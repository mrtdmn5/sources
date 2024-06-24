package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidCanvas.android.kt */
/* loaded from: classes.dex */
public final class AndroidCanvas implements Canvas {
    public android.graphics.Canvas internalCanvas = AndroidCanvas_androidKt.EmptyCanvas;
    public final Rect srcRect = new Rect();
    public final Rect dstRect = new Rect();

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipPath-mtrdD-E */
    public final void mo282clipPathmtrdDE(Path path, int r4) {
        boolean z;
        Region.Op op;
        Intrinsics.checkNotNullParameter(path, "path");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            AndroidPath androidPath = (AndroidPath) path;
            if (r4 == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                op = Region.Op.DIFFERENCE;
            } else {
                op = Region.Op.INTERSECT;
            }
            canvas.clipPath(androidPath.internalPath, op);
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipRect-N_I0leg */
    public final void mo283clipRectN_I0leg(float f, float f2, float f3, float f4, int r11) {
        boolean z;
        Region.Op op;
        android.graphics.Canvas canvas = this.internalCanvas;
        if (r11 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            op = Region.Op.DIFFERENCE;
        } else {
            op = Region.Op.INTERSECT;
        }
        canvas.clipRect(f, f2, f3, f4, op);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: concat-58bKbWc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo284concat58bKbWc(float[] r24) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidCanvas.mo284concat58bKbWc(float[]):void");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void disableZ() {
        CanvasUtils.enableZ(this.internalCanvas, false);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawArc(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, false, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawCircle-9KIMszo */
    public final void mo285drawCircle9KIMszo(float f, long j, Paint paint) {
        this.internalCanvas.drawCircle(Offset.m259getXimpl(j), Offset.m260getYimpl(j), f, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImage-d-4ec7I */
    public final void mo286drawImaged4ec7I(ImageBitmap image, long j, Paint paint) {
        Intrinsics.checkNotNullParameter(image, "image");
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(image), Offset.m259getXimpl(j), Offset.m260getYimpl(j), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImageRect-HPBpro0 */
    public final void mo287drawImageRectHPBpro0(ImageBitmap image, long j, long j2, long j3, long j4, Paint paint) {
        Intrinsics.checkNotNullParameter(image, "image");
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(image);
        int r3 = IntOffset.$r8$clinit;
        int r4 = (int) (j >> 32);
        Rect rect = this.srcRect;
        rect.left = r4;
        rect.top = IntOffset.m590getYimpl(j);
        rect.right = r4 + ((int) (j2 >> 32));
        rect.bottom = IntSize.m593getHeightimpl(j2) + IntOffset.m590getYimpl(j);
        Unit unit = Unit.INSTANCE;
        int r42 = (int) (j3 >> 32);
        Rect rect2 = this.dstRect;
        rect2.left = r42;
        rect2.top = IntOffset.m590getYimpl(j3);
        rect2.right = r42 + ((int) (j4 >> 32));
        rect2.bottom = IntSize.m593getHeightimpl(j4) + IntOffset.m590getYimpl(j3);
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawLine-Wko1d7g */
    public final void mo288drawLineWko1d7g(long j, long j2, Paint paint) {
        this.internalCanvas.drawLine(Offset.m259getXimpl(j), Offset.m260getYimpl(j), Offset.m259getXimpl(j2), Offset.m260getYimpl(j2), paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).internalPath, paint.asFrameworkPaint());
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawPoints-O7TthRY */
    public final void mo289drawPointsO7TthRY(Paint paint, ArrayList arrayList) {
        int size = arrayList.size();
        for (int r1 = 0; r1 < size; r1++) {
            long j = ((Offset) arrayList.get(r1)).packedValue;
            this.internalCanvas.drawPoint(Offset.m259getXimpl(j), Offset.m260getYimpl(j), paint.asFrameworkPaint());
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.internalCanvas.drawRect(f, f2, f3, f4, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint.asFrameworkPaint());
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void enableZ() {
        CanvasUtils.enableZ(this.internalCanvas, true);
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void rotate() {
        this.internalCanvas.rotate(45.0f);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void saveLayer(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        this.internalCanvas.saveLayer(rect.left, rect.top, rect.right, rect.bottom, paint.asFrameworkPaint(), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void scale() {
        this.internalCanvas.scale(-1.0f, 1.0f);
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "<set-?>");
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public final void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }
}
