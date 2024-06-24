package com.animaconnected.watch.graphs.utils;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.CanvasPath;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartPaints;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: ChartDrawUtils.kt */
/* loaded from: classes3.dex */
public final class ChartDrawUtilsKt {
    public static final void drawBarBackground(Chart chart, float f, float f2, float f3, float f4, Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        if (mitmap != null) {
            Kanvas.drawImage$default(chart.getCanvas(), f, f2, f3, f4, mitmap, null, 32, null);
        }
    }

    public static final void drawBarExt(Kanvas kanvas, RectF rect, CanvasPaint paint, DrawBarOptions options) {
        float cornerRadius;
        float cornerRadius2;
        float cornerRadius3;
        float cornerRadius4;
        Float tiltTLCornerRadius;
        Float tiltBLCornerRadius;
        Float tiltBRCornerRadius;
        Float tiltTRCornerRadius;
        Intrinsics.checkNotNullParameter(kanvas, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(options, "options");
        if (options.getFrontTiltDegrees() != 0 && (tiltTRCornerRadius = options.getTiltTRCornerRadius()) != null) {
            cornerRadius = tiltTRCornerRadius.floatValue();
        } else {
            cornerRadius = options.getCornerRadius();
        }
        if (options.getFrontTiltDegrees() != 0 && (tiltBRCornerRadius = options.getTiltBRCornerRadius()) != null) {
            cornerRadius2 = tiltBRCornerRadius.floatValue();
        } else {
            cornerRadius2 = options.getCornerRadius();
        }
        if (options.getBackTiltDegrees() != 0 && (tiltBLCornerRadius = options.getTiltBLCornerRadius()) != null) {
            cornerRadius3 = tiltBLCornerRadius.floatValue();
        } else {
            cornerRadius3 = options.getCornerRadius();
        }
        if (options.getBackTiltDegrees() != 0 && (tiltTLCornerRadius = options.getTiltTLCornerRadius()) != null) {
            cornerRadius4 = tiltTLCornerRadius.floatValue();
        } else {
            cornerRadius4 = options.getCornerRadius();
        }
        float f = cornerRadius + cornerRadius2;
        if (rect.getHeight() < f) {
            float height = rect.getHeight() / f;
            cornerRadius *= height;
            cornerRadius2 *= height;
            cornerRadius3 *= height;
            cornerRadius4 *= height;
        }
        float f2 = cornerRadius;
        float f3 = cornerRadius2;
        float f4 = cornerRadius3;
        float f5 = cornerRadius4;
        double radian = toRadian(options.getBackTiltDegrees());
        float abs = Math.abs((float) Math.cos(radian)) * f4;
        float height2 = ((rect.getHeight() - f4) - (Math.abs((float) Math.sin(radian)) * f4)) * Math.abs((float) Math.tan(radian));
        PointF pointF = new PointF(rect.getLeft() + f4, rect.getBottom() - f4);
        double d = 2.0f;
        PointF pointF2 = new PointF((float) (new PointF((pointF.getX() - abs) + height2, rect.getTop()).getX() + (f5 / Math.abs(Math.tan((radian + 1.5707963267948966d) / d)))), rect.getTop() + f5);
        double radian2 = toRadian(options.getFrontTiltDegrees());
        float abs2 = Math.abs((float) Math.cos(radian2)) * f2;
        float height3 = ((rect.getHeight() - f2) - (Math.abs((float) Math.sin(radian2)) * f2)) * Math.abs((float) Math.tan(radian2));
        PointF pointF3 = new PointF(rect.getRight() - f2, rect.getTop() + f2);
        PointF pointF4 = new PointF((float) (new PointF((pointF3.getX() + abs2) - height3, rect.getBottom()).getX() - (f3 / Math.abs(Math.tan((radian2 + 1.5707963267948966d) / d)))), rect.getBottom() - f3);
        if (pointF4.getX() < pointF.getX()) {
            float x = pointF.getX() - pointF4.getX();
            PointF pointF5 = new PointF(pointF4.getX() + x, pointF4.getY());
            pointF3 = new PointF(pointF3.getX() + x, pointF3.getY());
            pointF4 = pointF5;
        }
        CanvasPath createPath = kanvas.createPath();
        createPath.moveTo(pointF2.getX(), rect.getTop());
        createPath.lineTo(rect.getRight() - f2, rect.getTop());
        float x2 = pointF3.getX();
        float y = pointF3.getY();
        float f6 = 90;
        createPath.archTo(x2, y, f2, -90.0f, options.getFrontTiltDegrees() + f6);
        createPath.archTo(pointF4.getX(), pointF4.getY(), f3, options.getFrontTiltDegrees(), f6 - options.getFrontTiltDegrees());
        createPath.archTo(pointF.getX(), pointF.getY(), f4, 90.0f, f6 + options.getBackTiltDegrees());
        createPath.archTo(pointF2.getX(), pointF2.getY(), f5, 180 + options.getBackTiltDegrees(), f6 - options.getBackTiltDegrees());
        kanvas.drawPath(createPath, paint);
    }

    public static final void drawCircleWithBorder(Kanvas canvas, float f, float f2, float f3, CanvasPaint paint, CanvasPaint borderPaint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(borderPaint, "borderPaint");
        canvas.drawCircle(f, f2, f3, borderPaint);
        canvas.drawCircle(f, f2, f3 - 1, paint);
    }

    public static final void drawDotForEmptyBar(Chart chart, RectF frame, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Intrinsics.checkNotNullParameter(paint, "paint");
        chart.getCanvas().drawCircle(frame.getCenterX(), frame.getBottom() - (2 * 2.0f), 2.0f, paint);
    }

    public static final void drawDotOnTimeLine(Chart chart, float f, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paint, "paint");
        chart.getCanvas().drawCircle(f, ChartDrawXAxisUtilsKt.getYPosCircle(chart), ChartDrawXAxisUtilsKt.getCircleRadius(chart.getX()), paint);
    }

    public static final void drawHorizontalDashedLine(Chart chart, float f, float f2, CanvasPaint paintLine, float f3, float f4) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paintLine, "paintLine");
        float f5 = f4 + f3;
        int roundToInt = MathKt__MathJVMKt.roundToInt(f2 / f5);
        float f6 = 0.0f;
        for (int r1 = 0; r1 < roundToInt; r1++) {
            chart.getCanvas().drawLine(f6, f, f6 + f3, f, paintLine);
            f6 += f5;
        }
    }

    public static /* synthetic */ void drawHorizontalDashedLine$default(Chart chart, float f, float f2, CanvasPaint canvasPaint, float f3, float f4, int r13, Object obj) {
        float f5;
        float f6;
        if ((r13 & 8) != 0) {
            f5 = 2.0f;
        } else {
            f5 = f3;
        }
        if ((r13 & 16) != 0) {
            f6 = 2.0f;
        } else {
            f6 = f4;
        }
        drawHorizontalDashedLine(chart, f, f2, canvasPaint, f5, f6);
    }

    public static final void drawNoDataText(Chart chart, CanvasPaint paintText, CanvasPaint paintBackground) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paintText, "paintText");
        Intrinsics.checkNotNullParameter(paintBackground, "paintBackground");
        float measureWidth = paintText.measureWidth(chart.getNoDataText());
        float measureHeight = paintText.measureHeight(chart.getNoDataText());
        float f = 2;
        float width = (chart.getWidth() / f) - (measureWidth / f);
        float usableHeight = (measureHeight / f) + (chart.getUsableHeight() / f);
        float f2 = 8;
        chart.getCanvas().drawRect(width - f2, (usableHeight - measureHeight) - f2, measureWidth + width + f2, usableHeight + f2, paintBackground);
        Kanvas.drawText$default(chart.getCanvas(), chart.getNoDataText(), width, usableHeight, 0.0f, null, paintText, 24, null);
    }

    public static final void drawRoundRectPath(Kanvas canvas, RectF rect, float f, boolean z, boolean z2, boolean z3, boolean z4, CanvasPaint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float min = Math.min(f, Math.min(rect.getWidth(), rect.getHeight()) / 2.0f);
        CanvasPath createPath = canvas.createPath();
        if (z3) {
            createPath.moveTo(rect.getLeft(), rect.getBottom() - min);
        } else {
            createPath.moveTo(rect.getLeft(), rect.getBottom());
        }
        if (z) {
            createPath.lineTo(rect.getLeft(), rect.getTop() + min);
            createPath.quadTo(rect.getLeft(), rect.getTop(), rect.getLeft() + min, rect.getTop());
        } else {
            createPath.lineTo(rect.getLeft(), rect.getTop());
        }
        if (z2) {
            createPath.lineTo(rect.getRight() - min, rect.getTop());
            createPath.quadTo(rect.getRight(), rect.getTop(), rect.getRight(), rect.getTop() + min);
        } else {
            createPath.lineTo(rect.getRight(), rect.getTop());
        }
        if (z4) {
            createPath.lineTo(rect.getRight(), rect.getBottom() - min);
            createPath.quadTo(rect.getRight(), rect.getBottom(), rect.getRight() - min, rect.getBottom());
        } else {
            createPath.lineTo(rect.getRight(), rect.getBottom());
        }
        if (z3) {
            createPath.lineTo(rect.getLeft() + min, rect.getBottom());
            createPath.quadTo(rect.getLeft(), rect.getBottom(), rect.getLeft(), rect.getBottom() - min);
        } else {
            createPath.lineTo(rect.getLeft(), rect.getBottom());
        }
        createPath.close();
        canvas.drawPath(createPath, paint);
    }

    public static /* synthetic */ void drawRoundRectPath$default(Kanvas kanvas, RectF rectF, float f, boolean z, boolean z2, boolean z3, boolean z4, CanvasPaint canvasPaint, int r18, Object obj) {
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if ((r18 & 8) != 0) {
            z5 = true;
        } else {
            z5 = z;
        }
        if ((r18 & 16) != 0) {
            z6 = true;
        } else {
            z6 = z2;
        }
        if ((r18 & 32) != 0) {
            z7 = true;
        } else {
            z7 = z3;
        }
        if ((r18 & 64) != 0) {
            z8 = true;
        } else {
            z8 = z4;
        }
        drawRoundRectPath(kanvas, rectF, f, z5, z6, z7, z8, canvasPaint);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void drawVerticalDashedLine(com.animaconnected.watch.display.Kanvas r15, float r16, float r17, float r18, com.animaconnected.watch.display.CanvasPaint r19, float r20, float r21) {
        /*
            java.lang.String r0 = "canvas"
            r7 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "paintLine"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            float r0 = r20 + r21
            float r1 = r18 - r17
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 / r0
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r9 = (int) r1
            float r10 = r17 - r18
            r1 = 0
            r11 = r17
            r12 = r1
        L23:
            if (r12 >= r9) goto L4d
            r13 = 0
            int r14 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r14 <= 0) goto L2e
            float r1 = r11 - r20
        L2c:
            r5 = r1
            goto L36
        L2e:
            int r1 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r1 >= 0) goto L35
            float r1 = r11 + r20
            goto L2c
        L35:
            r5 = r13
        L36:
            r1 = r15
            r2 = r16
            r3 = r11
            r4 = r16
            r6 = r19
            r1.drawLine(r2, r3, r4, r5, r6)
            if (r14 <= 0) goto L45
            float r11 = r11 - r0
            goto L4a
        L45:
            int r1 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r1 >= 0) goto L4a
            float r11 = r11 + r0
        L4a:
            int r12 = r12 + 1
            goto L23
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt.drawVerticalDashedLine(com.animaconnected.watch.display.Kanvas, float, float, float, com.animaconnected.watch.display.CanvasPaint, float, float):void");
    }

    public static /* synthetic */ void drawVerticalDashedLine$default(Kanvas kanvas, float f, float f2, float f3, CanvasPaint canvasPaint, float f4, float f5, int r14, Object obj) {
        if ((r14 & 32) != 0) {
            f4 = 2.0f;
        }
        float f6 = f4;
        if ((r14 & 64) != 0) {
            f5 = 8.0f;
        }
        drawVerticalDashedLine(kanvas, f, f2, f3, canvasPaint, f6, f5);
    }

    public static final void drawYAxis(Chart chart, ChartPaints paints) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        YAxisProperties.Style style = chart.getY().getStyle();
        if (style instanceof YAxisProperties.Style.Normal) {
            YAxisUtilsKt.drawYAxisNormal(chart, paints, chart.getX().getStartPosition().invoke().floatValue());
            return;
        }
        if (style instanceof YAxisProperties.Style.Highlight) {
            YAxisUtilsKt.drawYAxisHighlight(chart, paints, ((YAxisProperties.Style.Highlight) style).getValue().invoke().intValue());
            return;
        }
        if (style instanceof YAxisProperties.Style.Average) {
            YAxisUtilsKt.drawYAxisAverageLineLabel(chart, paints, ((YAxisProperties.Style.Average) style).getDescriptionText());
        } else if (style instanceof YAxisProperties.Style.DualAxes) {
            YAxisUtilsKt.drawYAxisDual(chart, paints, ((YAxisProperties.Style.DualAxes) style).getEntriesLeftAxis());
        } else {
            if (style == null) {
                LogKt.debug$default((Object) chart, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt$drawYAxis$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "No y-axis drawn";
                    }
                }, 7, (Object) null);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final float toRadian(int r1) {
        return r1 * 0.017453292f;
    }
}
