package androidx.compose.ui.text.android;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextAndroidCanvas.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class TextAndroidCanvas extends Canvas {
    public Canvas nativeCanvas;

    @Override // android.graphics.Canvas
    public final boolean clipOutPath(Path path) {
        boolean clipOutPath;
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            clipOutPath = canvas.clipOutPath(path);
            return clipOutPath;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(RectF rect) {
        boolean clipOutRect;
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            clipOutRect = canvas.clipOutRect(rect);
            return clipOutRect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path, Region.Op op) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipPath(path, op);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rect, Region.Op op) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(rect, op);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void concat(Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.concat(matrix);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void disableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.disableZ();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawARGB(int r2, int r3, int r4, int r5) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawARGB(r2, r3, r4, r5);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawArc(RectF oval, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawArc(oval, f, f2, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmapMesh(Bitmap bitmap, int r12, int r13, float[] verts, int r15, int[] r16, int r17, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(verts, "verts");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmapMesh(bitmap, r12, r13, verts, r15, r16, r17, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawCircle(float f, float f2, float f3, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawCircle(f, f2, f3, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawColor(r2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF outer, float f, float f2, RectF inner, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawDoubleRoundRect(outer, f, f2, inner, f3, f4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawGlyphs(int[] glyphIds, int r11, float[] positions, int r13, int r14, Font font, Paint paint) {
        Intrinsics.checkNotNullParameter(glyphIds, "glyphIds");
        Intrinsics.checkNotNullParameter(positions, "positions");
        Intrinsics.checkNotNullParameter(font, "font");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawGlyphs(glyphIds, r11, positions, r13, r14, font, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawLine(f, f2, f3, f4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] pts, int r3, int r4, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawLines(pts, r3, r4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawOval(RectF oval, Paint paint) {
        Intrinsics.checkNotNullParameter(oval, "oval");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawOval(oval, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPaint(paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch patch, Rect dst, Paint paint) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPatch(patch, dst, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPath(Path path, Paint paint) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPath(path, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPicture(picture);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoint(float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPoint(f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] fArr, int r3, int r4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPoints(fArr, r3, r4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(char[] text, int r9, int r10, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPosText(text, r9, r10, pos, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRGB(int r2, int r3, int r4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRGB(r2, r3, r4);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(RectF rect, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRect(rect, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRenderNode(RenderNode renderNode) {
        Intrinsics.checkNotNullParameter(renderNode, "renderNode");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRenderNode(renderNode);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(RectF rect, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRoundRect(rect, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(char[] text, int r10, int r11, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawText(text, r10, r11, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(char[] text, int r11, int r12, Path path, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawTextOnPath(text, r11, r12, path, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(char[] text, int r13, int r14, int r15, int r16, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawTextRun(text, r13, r14, r15, r16, f, f2, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawVertices(Canvas.VertexMode mode, int r16, float[] verts, int r18, float[] fArr, int r20, int[] r21, int r22, short[] sArr, int r24, int r25, Paint paint) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(verts, "verts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawVertices(mode, r16, verts, r18, fArr, r20, r21, r22, sArr, r24, r25, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void enableZ() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.enableZ();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean getClipBounds(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            boolean clipBounds = canvas.getClipBounds(bounds);
            if (clipBounds) {
                bounds.set(0, 0, bounds.width(), Integer.MAX_VALUE);
            }
            return clipBounds;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getDensity() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getDensity();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final DrawFilter getDrawFilter() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getDrawFilter();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getHeight();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void getMatrix(Matrix ctm) {
        Intrinsics.checkNotNullParameter(ctm, "ctm");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.getMatrix(ctm);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapHeight() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getMaximumBitmapHeight();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getMaximumBitmapWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getMaximumBitmapWidth();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getSaveCount() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getSaveCount();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int getWidth() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.getWidth();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean isOpaque() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.isOpaque();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(RectF rect, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(type, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.quickReject(rect, type);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void restore() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.restore();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void restoreToCount(int r2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.restoreToCount(r2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void rotate(float f) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.rotate(f);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final int save() {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.save();
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint, int r4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayer(rectF, paint, r4);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int r3, int r4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayerAlpha(rectF, r3, r4);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void scale(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.scale(f, f2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setBitmap(Bitmap bitmap) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.setBitmap(bitmap);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setDensity(int r2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.setDensity(r2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setDrawFilter(DrawFilter drawFilter) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.setDrawFilter(drawFilter);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void setMatrix(Matrix matrix) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.setMatrix(matrix);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void skew(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.skew(f, f2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void translate(float f, float f2) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.translate(f, f2);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(Rect rect) {
        boolean clipOutRect;
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            clipOutRect = canvas.clipOutRect(rect);
            return clipOutRect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipPath(path);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect, Region.Op op) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(rect, op);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawArc(f, f2, f3, f4, f5, f6, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, RectF dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, rect, dst, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long j) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawColor(j);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawDoubleRoundRect(RectF outer, float[] outerRadii, RectF inner, float[] innerRadii, Paint paint) {
        Intrinsics.checkNotNullParameter(outer, "outer");
        Intrinsics.checkNotNullParameter(outerRadii, "outerRadii");
        Intrinsics.checkNotNullParameter(inner, "inner");
        Intrinsics.checkNotNullParameter(innerRadii, "innerRadii");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawDoubleRoundRect(outer, outerRadii, inner, innerRadii, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawLines(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawLines(pts, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawOval(f, f2, f3, f4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPatch(NinePatch patch, RectF dst, Paint paint) {
        Intrinsics.checkNotNullParameter(patch, "patch");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPatch(patch, dst, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, RectF dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPicture(picture, dst);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPoints(float[] pts, Paint paint) {
        Intrinsics.checkNotNullParameter(pts, "pts");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPoints(pts, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPosText(String text, float[] pos, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPosText(text, pos, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(Rect r, Paint paint) {
        Intrinsics.checkNotNullParameter(r, "r");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRect(r, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRoundRect(f, f2, f3, f4, f5, f6, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(String text, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawText(text, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextOnPath(String text, Path path, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawTextOnPath(text, path, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(CharSequence text, int r13, int r14, int r15, int r16, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawTextRun(text, r13, r14, r15, r16, f, f2, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(RectF rect) {
        boolean quickReject;
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            quickReject = canvas.quickReject(rect);
            return quickReject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(RectF rectF, Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayer(rectF, paint);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(RectF rectF, int r3) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayerAlpha(rectF, r3);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(float f, float f2, float f3, float f4) {
        boolean clipOutRect;
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            clipOutRect = canvas.clipOutRect(f, f2, f3, f4);
            return clipOutRect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(rect);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Rect rect, Rect dst, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, rect, dst, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r2, PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawColor(r2, mode);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawPicture(Picture picture, Rect dst) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        Intrinsics.checkNotNullParameter(dst, "dst");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawPicture(picture, dst);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawRect(f, f2, f3, f4, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(String text, int r10, int r11, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawText(text, r10, r11, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawTextRun(MeasuredText text, int r13, int r14, int r15, int r16, float f, float f2, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawTextRun(text, r13, r14, r15, r16, f, f2, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(Path path, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(type, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.quickReject(path, type);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f, float f2, float f3, float f4, Paint paint, int r13) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayer(f, f2, f3, f4, paint, r13);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f, float f2, float f3, float f4, int r12, int r13) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayerAlpha(f, f2, f3, f4, r12, r13);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipOutRect(int r2, int r3, int r4, int r5) {
        boolean clipOutRect;
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            clipOutRect = canvas.clipOutRect(r2, r3, r4, r5);
            return clipOutRect;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(rect);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] colors, int r13, int r14, float f, float f2, int r17, int r18, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(colors, r13, r14, f, f2, r17, r18, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(int r2, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawColor(r2, mode);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawText(CharSequence text, int r10, int r11, float f, float f2, Paint paint) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawText(text, r10, r11, f, f2, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(Path path) {
        boolean quickReject;
        Intrinsics.checkNotNullParameter(path, "path");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            quickReject = canvas.quickReject(path);
            return quickReject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayer(f, f2, f3, f4, paint);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final int saveLayerAlpha(float f, float f2, float f3, float f4, int r11) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.saveLayerAlpha(f, f2, f3, f4, r11);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        Intrinsics.checkNotNullParameter(op, "op");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(f, f2, f3, f4, op);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(int[] colors, int r13, int r14, int r15, int r16, int r17, int r18, boolean z, Paint paint) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(colors, r13, r14, r15, r16, r17, r18, z, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final void drawColor(long j, BlendMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawColor(j, mode);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.quickReject(f, f2, f3, f4, type);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(float f, float f2, float f3, float f4) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(f, f2, f3, f4);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            canvas.drawBitmap(bitmap, matrix, paint);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
            throw null;
        }
    }

    @Override // android.graphics.Canvas
    public final boolean quickReject(float f, float f2, float f3, float f4) {
        boolean quickReject;
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            quickReject = canvas.quickReject(f, f2, f3, f4);
            return quickReject;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }

    @Override // android.graphics.Canvas
    public final boolean clipRect(int r2, int r3, int r4, int r5) {
        Canvas canvas = this.nativeCanvas;
        if (canvas != null) {
            return canvas.clipRect(r2, r3, r4, r5);
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativeCanvas");
        throw null;
    }
}
