package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePath;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class ShapeAppearancePathProvider {
    public final ShapePath[] cornerPaths = new ShapePath[4];
    public final Matrix[] cornerTransforms = new Matrix[4];
    public final Matrix[] edgeTransforms = new Matrix[4];
    public final PointF pointF = new PointF();
    public final Path overlappedEdgePath = new Path();
    public final Path boundsPath = new Path();
    public final ShapePath shapePath = new ShapePath();
    public final float[] scratch = new float[2];
    public final float[] scratch2 = new float[2];
    public final Path edgePath = new Path();
    public final Path cornerPath = new Path();
    public final boolean edgeIntersectionCheckEnabled = true;

    /* loaded from: classes3.dex */
    public static class Lazy {
        public static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();
    }

    public ShapeAppearancePathProvider() {
        for (int r1 = 0; r1 < 4; r1++) {
            this.cornerPaths[r1] = new ShapePath();
            this.cornerTransforms[r1] = new Matrix();
            this.edgeTransforms[r1] = new Matrix();
        }
    }

    public final void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, MaterialShapeDrawable.AnonymousClass1 anonymousClass1, Path path) {
        int r11;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        ShapePath[] shapePathArr;
        float abs;
        EdgeTreatment edgeTreatment;
        Path path2;
        MaterialShapeDrawable.AnonymousClass1 anonymousClass12;
        char c;
        CornerSize cornerSize;
        KeyEvent_androidKt keyEvent_androidKt;
        Path path3;
        ShapeAppearancePathProvider shapeAppearancePathProvider = this;
        ShapeAppearanceModel shapeAppearanceModel2 = shapeAppearanceModel;
        MaterialShapeDrawable.AnonymousClass1 anonymousClass13 = anonymousClass1;
        Path path4 = path;
        path.rewind();
        Path path5 = shapeAppearancePathProvider.overlappedEdgePath;
        path5.rewind();
        Path path6 = shapeAppearancePathProvider.boundsPath;
        path6.rewind();
        path6.addRect(rectF, Path.Direction.CW);
        int r9 = 0;
        while (true) {
            r11 = 4;
            matrixArr = shapeAppearancePathProvider.edgeTransforms;
            fArr = shapeAppearancePathProvider.scratch;
            matrixArr2 = shapeAppearancePathProvider.cornerTransforms;
            shapePathArr = shapeAppearancePathProvider.cornerPaths;
            if (r9 >= 4) {
                break;
            }
            if (r9 != 1) {
                if (r9 != 2) {
                    if (r9 != 3) {
                        cornerSize = shapeAppearanceModel2.topRightCornerSize;
                    } else {
                        cornerSize = shapeAppearanceModel2.topLeftCornerSize;
                    }
                } else {
                    cornerSize = shapeAppearanceModel2.bottomLeftCornerSize;
                }
            } else {
                cornerSize = shapeAppearanceModel2.bottomRightCornerSize;
            }
            if (r9 != 1) {
                if (r9 != 2) {
                    if (r9 != 3) {
                        keyEvent_androidKt = shapeAppearanceModel2.topRightCorner;
                    } else {
                        keyEvent_androidKt = shapeAppearanceModel2.topLeftCorner;
                    }
                } else {
                    keyEvent_androidKt = shapeAppearanceModel2.bottomLeftCorner;
                }
            } else {
                keyEvent_androidKt = shapeAppearanceModel2.bottomRightCorner;
            }
            ShapePath shapePath = shapePathArr[r9];
            keyEvent_androidKt.getClass();
            keyEvent_androidKt.getCornerPath(f, cornerSize.getCornerSize(rectF), shapePath);
            int r10 = r9 + 1;
            float f2 = r10 * 90;
            matrixArr2[r9].reset();
            PointF pointF = shapeAppearancePathProvider.pointF;
            if (r9 != 1) {
                if (r9 != 2) {
                    if (r9 != 3) {
                        path3 = path5;
                        pointF.set(rectF.right, rectF.top);
                    } else {
                        path3 = path5;
                        pointF.set(rectF.left, rectF.top);
                    }
                } else {
                    path3 = path5;
                    pointF.set(rectF.left, rectF.bottom);
                }
            } else {
                path3 = path5;
                pointF.set(rectF.right, rectF.bottom);
            }
            matrixArr2[r9].setTranslate(pointF.x, pointF.y);
            matrixArr2[r9].preRotate(f2);
            ShapePath shapePath2 = shapePathArr[r9];
            fArr[0] = shapePath2.endX;
            fArr[1] = shapePath2.endY;
            matrixArr2[r9].mapPoints(fArr);
            matrixArr[r9].reset();
            matrixArr[r9].setTranslate(fArr[0], fArr[1]);
            matrixArr[r9].preRotate(f2);
            r9 = r10;
            path5 = path3;
        }
        Path path7 = path5;
        char c2 = 1;
        char c3 = 0;
        int r6 = 0;
        while (r6 < r11) {
            ShapePath shapePath3 = shapePathArr[r6];
            fArr[c3] = shapePath3.startX;
            fArr[c2] = shapePath3.startY;
            matrixArr2[r6].mapPoints(fArr);
            if (r6 == 0) {
                path4.moveTo(fArr[c3], fArr[c2]);
            } else {
                path4.lineTo(fArr[c3], fArr[c2]);
            }
            shapePathArr[r6].applyToPath(matrixArr2[r6], path4);
            if (anonymousClass13 != null) {
                ShapePath shapePath4 = shapePathArr[r6];
                Matrix matrix = matrixArr2[r6];
                MaterialShapeDrawable materialShapeDrawable = MaterialShapeDrawable.this;
                BitSet bitSet = materialShapeDrawable.containsIncompatibleShadowOp;
                shapePath4.getClass();
                bitSet.set(r6, false);
                shapePath4.addConnectingShadowIfNecessary(shapePath4.endShadowAngle);
                materialShapeDrawable.cornerShadowOperation[r6] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transformCopy;

                    public AnonymousClass1(ArrayList arrayList, Matrix matrix2) {
                        r1 = arrayList;
                        r2 = matrix2;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void draw(Matrix matrix2, ShadowRenderer shadowRenderer, int r5, Canvas canvas) {
                        Iterator it = r1.iterator();
                        while (it.hasNext()) {
                            ((ShadowCompatOperation) it.next()).draw(r2, shadowRenderer, r5, canvas);
                        }
                    }
                };
            }
            int r3 = r6 + 1;
            int r92 = r3 % 4;
            ShapePath shapePath5 = shapePathArr[r6];
            fArr[0] = shapePath5.endX;
            fArr[1] = shapePath5.endY;
            matrixArr2[r6].mapPoints(fArr);
            ShapePath shapePath6 = shapePathArr[r92];
            float f3 = shapePath6.startX;
            float[] fArr2 = shapeAppearancePathProvider.scratch2;
            fArr2[0] = f3;
            fArr2[1] = shapePath6.startY;
            matrixArr2[r92].mapPoints(fArr2);
            float max = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            ShapePath shapePath7 = shapePathArr[r6];
            fArr[0] = shapePath7.endX;
            fArr[1] = shapePath7.endY;
            matrixArr2[r6].mapPoints(fArr);
            if (r6 != 1 && r6 != 3) {
                abs = Math.abs(rectF.centerY() - fArr[1]);
            } else {
                abs = Math.abs(rectF.centerX() - fArr[0]);
            }
            ShapePath shapePath8 = shapeAppearancePathProvider.shapePath;
            shapePath8.reset(0.0f, 270.0f, 0.0f);
            if (r6 != 1) {
                if (r6 != 2) {
                    if (r6 != 3) {
                        edgeTreatment = shapeAppearanceModel2.rightEdge;
                    } else {
                        edgeTreatment = shapeAppearanceModel2.topEdge;
                    }
                } else {
                    edgeTreatment = shapeAppearanceModel2.leftEdge;
                }
            } else {
                edgeTreatment = shapeAppearanceModel2.bottomEdge;
            }
            edgeTreatment.getEdgePath(max, abs, f, shapePath8);
            Path path8 = shapeAppearancePathProvider.edgePath;
            path8.reset();
            shapePath8.applyToPath(matrixArr[r6], path8);
            if (shapeAppearancePathProvider.edgeIntersectionCheckEnabled && (shapeAppearancePathProvider.pathOverlapsCorner(path8, r6) || shapeAppearancePathProvider.pathOverlapsCorner(path8, r92))) {
                path8.op(path8, path6, Path.Op.DIFFERENCE);
                fArr[0] = shapePath8.startX;
                fArr[1] = shapePath8.startY;
                matrixArr[r6].mapPoints(fArr);
                path2 = path7;
                path2.moveTo(fArr[0], fArr[1]);
                shapePath8.applyToPath(matrixArr[r6], path2);
                anonymousClass12 = anonymousClass1;
                path4 = path;
            } else {
                path2 = path7;
                path4 = path;
                shapePath8.applyToPath(matrixArr[r6], path4);
                anonymousClass12 = anonymousClass1;
            }
            if (anonymousClass12 != null) {
                Matrix matrix2 = matrixArr[r6];
                MaterialShapeDrawable materialShapeDrawable2 = MaterialShapeDrawable.this;
                c = 0;
                materialShapeDrawable2.containsIncompatibleShadowOp.set(r6 + 4, false);
                shapePath8.addConnectingShadowIfNecessary(shapePath8.endShadowAngle);
                materialShapeDrawable2.edgeShadowOperation[r6] = new ShapePath.ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
                    public final /* synthetic */ List val$operations;
                    public final /* synthetic */ Matrix val$transformCopy;

                    public AnonymousClass1(ArrayList arrayList, Matrix matrix22) {
                        r1 = arrayList;
                        r2 = matrix22;
                    }

                    @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
                    public final void draw(Matrix matrix22, ShadowRenderer shadowRenderer, int r5, Canvas canvas) {
                        Iterator it = r1.iterator();
                        while (it.hasNext()) {
                            ((ShadowCompatOperation) it.next()).draw(r2, shadowRenderer, r5, canvas);
                        }
                    }
                };
            } else {
                c = 0;
            }
            shapeAppearancePathProvider = this;
            c3 = c;
            anonymousClass13 = anonymousClass12;
            path7 = path2;
            r6 = r3;
            c2 = 1;
            r11 = 4;
            shapeAppearanceModel2 = shapeAppearanceModel;
        }
        Path path9 = path7;
        path.close();
        path9.close();
        if (!path9.isEmpty()) {
            path4.op(path9, Path.Op.UNION);
        }
    }

    public final boolean pathOverlapsCorner(Path path, int r5) {
        Path path2 = this.cornerPath;
        path2.reset();
        this.cornerPaths[r5].applyToPath(this.cornerTransforms[r5], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }
}
