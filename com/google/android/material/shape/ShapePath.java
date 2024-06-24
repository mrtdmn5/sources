package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ShapePath {

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    public final ArrayList operations = new ArrayList();
    public final ArrayList shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    /* loaded from: classes3.dex */
    public static class ArcShadowOperation extends ShadowCompatOperation {
        public final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void draw(Matrix matrix, ShadowRenderer shadowRenderer, int r22, Canvas canvas) {
            boolean z;
            PathArcOperation pathArcOperation = this.operation;
            float f = pathArcOperation.startAngle;
            float f2 = pathArcOperation.sweepAngle;
            RectF rectF = new RectF(pathArcOperation.left, pathArcOperation.top, pathArcOperation.right, pathArcOperation.bottom);
            shadowRenderer.getClass();
            if (f2 < 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Path path = shadowRenderer.scratch;
            int[] r16 = ShadowRenderer.cornerColors;
            if (z) {
                r16[0] = 0;
                r16[1] = shadowRenderer.shadowEndColor;
                r16[2] = shadowRenderer.shadowMiddleColor;
                r16[3] = shadowRenderer.shadowStartColor;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -r22;
                rectF.inset(f3, f3);
                r16[0] = 0;
                r16[1] = shadowRenderer.shadowStartColor;
                r16[2] = shadowRenderer.shadowMiddleColor;
                r16[3] = shadowRenderer.shadowEndColor;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f4 = 1.0f - (r22 / width);
                float[] fArr = ShadowRenderer.cornerPositions;
                fArr[1] = f4;
                fArr[2] = ((1.0f - f4) / 2.0f) + f4;
                RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), width, r16, fArr, Shader.TileMode.CLAMP);
                Paint paint = shadowRenderer.cornerShadowPaint;
                paint.setShader(radialGradient);
                canvas.save();
                canvas.concat(matrix);
                canvas.scale(1.0f, rectF.height() / rectF.width());
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, shadowRenderer.transparentPaint);
                }
                canvas.drawArc(rectF, f, f2, true, paint);
                canvas.restore();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class LineShadowOperation extends ShadowCompatOperation {
        public final PathLineOperation operation;
        public final float startX;
        public final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public final void draw(Matrix matrix, ShadowRenderer shadowRenderer, int r20, Canvas canvas) {
            PathLineOperation pathLineOperation = this.operation;
            float f = pathLineOperation.y;
            float f2 = this.startY;
            float f3 = pathLineOperation.x;
            float f4 = this.startX;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f - f2, f3 - f4), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(f4, f2);
            matrix2.preRotate(getAngle());
            shadowRenderer.getClass();
            rectF.bottom += r20;
            rectF.offset(0.0f, -r20);
            int[] r14 = ShadowRenderer.edgeColors;
            r14[0] = shadowRenderer.shadowEndColor;
            r14[1] = shadowRenderer.shadowMiddleColor;
            r14[2] = shadowRenderer.shadowStartColor;
            Paint paint = shadowRenderer.edgeShadowPaint;
            float f5 = rectF.left;
            paint.setShader(new LinearGradient(f5, rectF.top, f5, rectF.bottom, r14, ShadowRenderer.edgePositions, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, paint);
            canvas.restore();
        }

        public final float getAngle() {
            PathLineOperation pathLineOperation = this.operation;
            return (float) Math.toDegrees(Math.atan((pathLineOperation.y - this.startY) / (pathLineOperation.x - this.startX)));
        }
    }

    /* loaded from: classes3.dex */
    public static class PathArcOperation extends PathOperation {
        public static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        public PathArcOperation(float f, float f2, float f3, float f4) {
            this.left = f;
            this.top = f2;
            this.right = f3;
            this.bottom = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(this.left, this.top, this.right, this.bottom);
            path.arcTo(rectF2, this.startAngle, this.sweepAngle, false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes3.dex */
    public static class PathLineOperation extends PathOperation {
        public float x;
        public float y;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public final void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class PathOperation {
        public final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes3.dex */
    public static abstract class ShadowCompatOperation {
        public static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int r3, Canvas canvas);
    }

    public ShapePath() {
        reset(0.0f, 270.0f, 0.0f);
    }

    public final void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        boolean z;
        float f7;
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.startAngle = f5;
        pathArcOperation.sweepAngle = f6;
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f8 = f5 + f6;
        if (f6 < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f5 = (f5 + 180.0f) % 360.0f;
        }
        if (z) {
            f7 = (180.0f + f8) % 360.0f;
        } else {
            f7 = f8;
        }
        addConnectingShadowIfNecessary(f5);
        this.shadowCompatOperations.add(arcShadowOperation);
        this.currentShadowAngle = f7;
        double d = f8;
        this.endX = (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))) + ((f + f3) * 0.5f);
        this.endY = (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))) + ((f2 + f4) * 0.5f);
    }

    public final void addConnectingShadowIfNecessary(float f) {
        float f2 = this.currentShadowAngle;
        if (f2 == f) {
            return;
        }
        float f3 = ((f - f2) + 360.0f) % 360.0f;
        if (f3 > 180.0f) {
            return;
        }
        float f4 = this.endX;
        float f5 = this.endY;
        PathArcOperation pathArcOperation = new PathArcOperation(f4, f5, f4, f5);
        pathArcOperation.startAngle = this.currentShadowAngle;
        pathArcOperation.sweepAngle = f3;
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        this.currentShadowAngle = f;
    }

    public final void applyToPath(Matrix matrix, Path path) {
        ArrayList arrayList = this.operations;
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            ((PathOperation) arrayList.get(r2)).applyToPath(matrix, path);
        }
    }

    public final void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.x = f;
        pathLineOperation.y = f2;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, this.endX, this.endY);
        float angle = lineShadowOperation.getAngle() + 270.0f;
        float angle2 = lineShadowOperation.getAngle() + 270.0f;
        addConnectingShadowIfNecessary(angle);
        this.shadowCompatOperations.add(lineShadowOperation);
        this.currentShadowAngle = angle2;
        this.endX = f;
        this.endY = f2;
    }

    public final void reset(float f, float f2, float f3) {
        this.startX = 0.0f;
        this.startY = f;
        this.endX = 0.0f;
        this.endY = f;
        this.currentShadowAngle = f2;
        this.endShadowAngle = (f2 + f3) % 360.0f;
        this.operations.clear();
        this.shadowCompatOperations.clear();
    }
}
