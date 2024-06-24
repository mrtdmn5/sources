package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.vector.PathNode;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PathParser.kt */
/* loaded from: classes.dex */
public final class PathParserKt {
    public static final void drawArc(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, boolean z, boolean z2) {
        boolean z3;
        double d8;
        double d9;
        boolean z4;
        double d10 = (d7 / 180) * 3.141592653589793d;
        double cos = Math.cos(d10);
        double sin = Math.sin(d10);
        double d11 = ((d2 * sin) + (d * cos)) / d5;
        double d12 = ((d2 * cos) + ((-d) * sin)) / d6;
        double d13 = ((d4 * sin) + (d3 * cos)) / d5;
        double d14 = ((d4 * cos) + ((-d3) * sin)) / d6;
        double d15 = d11 - d13;
        double d16 = d12 - d14;
        double d17 = 2;
        double d18 = (d11 + d13) / d17;
        double d19 = (d12 + d14) / d17;
        double d20 = (d16 * d16) + (d15 * d15);
        if (d20 == 0.0d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return;
        }
        double d21 = (1.0d / d20) - 0.25d;
        if (d21 < 0.0d) {
            double sqrt = (float) (Math.sqrt(d20) / 1.99999d);
            drawArc(path, d, d2, d3, d4, d5 * sqrt, d6 * sqrt, d7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d21);
        double d22 = d15 * sqrt2;
        double d23 = sqrt2 * d16;
        if (z == z2) {
            d8 = d18 - d23;
            d9 = d19 + d22;
        } else {
            d8 = d18 + d23;
            d9 = d19 - d22;
        }
        double atan2 = Math.atan2(d12 - d9, d11 - d8);
        double atan22 = Math.atan2(d14 - d9, d13 - d8) - atan2;
        if (atan22 >= 0.0d) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z2 != z4) {
            if (atan22 > 0.0d) {
                atan22 -= 6.283185307179586d;
            } else {
                atan22 += 6.283185307179586d;
            }
        }
        double d24 = d5;
        double d25 = d8 * d24;
        double d26 = d9 * d6;
        double d27 = (d25 * cos) - (d26 * sin);
        double d28 = (d26 * cos) + (d25 * sin);
        double d29 = 4;
        int ceil = (int) Math.ceil(Math.abs((atan22 * d29) / 3.141592653589793d));
        double cos2 = Math.cos(d10);
        double sin2 = Math.sin(d10);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d30 = -d24;
        double d31 = d30 * cos2;
        double d32 = d6 * sin2;
        double d33 = d30 * sin2;
        double d34 = d6 * cos2;
        double d35 = atan22 / ceil;
        double d36 = d;
        double d37 = d2;
        double d38 = (cos3 * d34) + (sin3 * d33);
        double d39 = (d31 * sin3) - (d32 * cos3);
        int r15 = 0;
        double d40 = atan2;
        while (r15 < ceil) {
            double d41 = d40 + d35;
            double sin4 = Math.sin(d41);
            double cos4 = Math.cos(d41);
            double d42 = d35;
            double d43 = (((d24 * cos2) * cos4) + d27) - (d32 * sin4);
            double d44 = sin2;
            double d45 = (d34 * sin4) + (d24 * sin2 * cos4) + d28;
            double d46 = (d31 * sin4) - (d32 * cos4);
            double d47 = (cos4 * d34) + (sin4 * d33);
            double d48 = d41 - d40;
            double tan = Math.tan(d48 / d17);
            double sqrt3 = ((Math.sqrt(((3.0d * tan) * tan) + d29) - 1) * Math.sin(d48)) / 3;
            path.cubicTo((float) ((d39 * sqrt3) + d36), (float) ((d38 * sqrt3) + d37), (float) (d43 - (sqrt3 * d46)), (float) (d45 - (sqrt3 * d47)), (float) d43, (float) d45);
            r15++;
            ceil = ceil;
            d24 = d5;
            d33 = d33;
            d36 = d43;
            d37 = d45;
            d40 = d41;
            d38 = d47;
            d39 = d46;
            d17 = d17;
            d35 = d42;
            sin2 = d44;
        }
    }

    public static final void toPath(List list, Path path) {
        PathNode pathNode;
        int r17;
        PathNode pathNode2;
        int r21;
        int r24;
        float f;
        PathNode pathNode3;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        List list2 = list;
        Path target = path;
        Intrinsics.checkNotNullParameter(list2, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int mo304getFillTypeRgk1Os = path.mo304getFillTypeRgk1Os();
        path.rewind();
        target.mo306setFillTypeoQ8Xj4U(mo304getFillTypeRgk1Os);
        if (list.isEmpty()) {
            pathNode = PathNode.Close.INSTANCE;
        } else {
            pathNode = (PathNode) list2.get(0);
        }
        int size = list.size();
        float f26 = 0.0f;
        int r13 = 0;
        float f27 = 0.0f;
        float f28 = 0.0f;
        float f29 = 0.0f;
        float f30 = 0.0f;
        float f31 = 0.0f;
        float f32 = 0.0f;
        while (r13 < size) {
            PathNode pathNode4 = (PathNode) list2.get(r13);
            if (pathNode4 instanceof PathNode.Close) {
                path.close();
                target.moveTo(f31, f32);
                f24 = f31;
                f23 = f24;
                f25 = f32;
                f17 = f25;
            } else if (pathNode4 instanceof PathNode.RelativeMoveTo) {
                PathNode.RelativeMoveTo relativeMoveTo = (PathNode.RelativeMoveTo) pathNode4;
                float f33 = relativeMoveTo.dx;
                float f34 = relativeMoveTo.dy;
                float f35 = f30 + f34;
                target.relativeMoveTo(f33, f34);
                f24 = f29 + f33;
                f17 = f35;
                f31 = f27;
                f23 = f24;
                f32 = f28;
                f25 = f17;
            } else {
                if (pathNode4 instanceof PathNode.MoveTo) {
                    PathNode.MoveTo moveTo = (PathNode.MoveTo) pathNode4;
                    f20 = moveTo.x;
                    f18 = moveTo.y;
                    target.moveTo(f20, f18);
                    f19 = f20;
                    f17 = f18;
                } else {
                    if (pathNode4 instanceof PathNode.RelativeLineTo) {
                        PathNode.RelativeLineTo relativeLineTo = (PathNode.RelativeLineTo) pathNode4;
                        float f36 = relativeLineTo.dx;
                        f21 = relativeLineTo.dy;
                        target.relativeLineTo(f36, f21);
                        f29 += relativeLineTo.dx;
                    } else {
                        if (pathNode4 instanceof PathNode.LineTo) {
                            PathNode.LineTo lineTo = (PathNode.LineTo) pathNode4;
                            float f37 = lineTo.x;
                            float f38 = lineTo.y;
                            target.lineTo(f37, f38);
                            f22 = lineTo.x;
                            f17 = f32;
                            f18 = f38;
                        } else if (pathNode4 instanceof PathNode.RelativeHorizontalTo) {
                            PathNode.RelativeHorizontalTo relativeHorizontalTo = (PathNode.RelativeHorizontalTo) pathNode4;
                            target.relativeLineTo(relativeHorizontalTo.dx, f26);
                            f29 += relativeHorizontalTo.dx;
                            f19 = f31;
                            f17 = f32;
                            f20 = f29;
                            f18 = f30;
                        } else if (pathNode4 instanceof PathNode.HorizontalTo) {
                            PathNode.HorizontalTo horizontalTo = (PathNode.HorizontalTo) pathNode4;
                            target.lineTo(horizontalTo.x, f30);
                            f22 = horizontalTo.x;
                            f17 = f32;
                            f18 = f30;
                        } else if (pathNode4 instanceof PathNode.RelativeVerticalTo) {
                            PathNode.RelativeVerticalTo relativeVerticalTo = (PathNode.RelativeVerticalTo) pathNode4;
                            target.relativeLineTo(f26, relativeVerticalTo.dy);
                            f21 = relativeVerticalTo.dy;
                        } else if (pathNode4 instanceof PathNode.VerticalTo) {
                            PathNode.VerticalTo verticalTo = (PathNode.VerticalTo) pathNode4;
                            target.lineTo(f29, verticalTo.y);
                            f17 = f32;
                            f18 = verticalTo.y;
                            f19 = f31;
                            f20 = f29;
                        } else {
                            if (pathNode4 instanceof PathNode.RelativeCurveTo) {
                                PathNode.RelativeCurveTo relativeCurveTo = (PathNode.RelativeCurveTo) pathNode4;
                                r17 = size;
                                pathNode2 = pathNode4;
                                path.relativeCubicTo(relativeCurveTo.dx1, relativeCurveTo.dy1, relativeCurveTo.dx2, relativeCurveTo.dy2, relativeCurveTo.dx3, relativeCurveTo.dy3);
                                f10 = relativeCurveTo.dx2 + f29;
                                f11 = relativeCurveTo.dy2 + f30;
                                f29 += relativeCurveTo.dx3;
                                f16 = relativeCurveTo.dy3;
                            } else {
                                r17 = size;
                                pathNode2 = pathNode4;
                                if (pathNode2 instanceof PathNode.CurveTo) {
                                    PathNode.CurveTo curveTo = (PathNode.CurveTo) pathNode2;
                                    path.cubicTo(curveTo.x1, curveTo.y1, curveTo.x2, curveTo.y2, curveTo.x3, curveTo.y3);
                                    f10 = curveTo.x2;
                                    f11 = curveTo.y2;
                                    f12 = curveTo.x3;
                                    f13 = curveTo.y3;
                                } else if (pathNode2 instanceof PathNode.RelativeReflectiveCurveTo) {
                                    if (pathNode.isCurve) {
                                        f14 = f29 - f27;
                                        f15 = f30 - f28;
                                    } else {
                                        f14 = 0.0f;
                                        f15 = 0.0f;
                                    }
                                    PathNode.RelativeReflectiveCurveTo relativeReflectiveCurveTo = (PathNode.RelativeReflectiveCurveTo) pathNode2;
                                    path.relativeCubicTo(f14, f15, relativeReflectiveCurveTo.dx1, relativeReflectiveCurveTo.dy1, relativeReflectiveCurveTo.dx2, relativeReflectiveCurveTo.dy2);
                                    f10 = relativeReflectiveCurveTo.dx1 + f29;
                                    f11 = relativeReflectiveCurveTo.dy1 + f30;
                                    f29 += relativeReflectiveCurveTo.dx2;
                                    f16 = relativeReflectiveCurveTo.dy2;
                                } else if (pathNode2 instanceof PathNode.ReflectiveCurveTo) {
                                    if (pathNode.isCurve) {
                                        float f39 = 2;
                                        f9 = (f39 * f30) - f28;
                                        f8 = (f29 * f39) - f27;
                                    } else {
                                        f8 = f29;
                                        f9 = f30;
                                    }
                                    PathNode.ReflectiveCurveTo reflectiveCurveTo = (PathNode.ReflectiveCurveTo) pathNode2;
                                    path.cubicTo(f8, f9, reflectiveCurveTo.x1, reflectiveCurveTo.y1, reflectiveCurveTo.x2, reflectiveCurveTo.y2);
                                    f10 = reflectiveCurveTo.x1;
                                    f11 = reflectiveCurveTo.y1;
                                    f12 = reflectiveCurveTo.x2;
                                    f13 = reflectiveCurveTo.y2;
                                } else {
                                    if (pathNode2 instanceof PathNode.RelativeQuadTo) {
                                        PathNode.RelativeQuadTo relativeQuadTo = (PathNode.RelativeQuadTo) pathNode2;
                                        float f40 = relativeQuadTo.dx1;
                                        float f41 = relativeQuadTo.dy1;
                                        f7 = relativeQuadTo.dx2;
                                        f4 = relativeQuadTo.dy2;
                                        target.relativeQuadraticBezierTo(f40, f41, f7, f4);
                                        f5 = relativeQuadTo.dx1 + f29;
                                        f6 = f41 + f30;
                                    } else {
                                        if (pathNode2 instanceof PathNode.QuadTo) {
                                            PathNode.QuadTo quadTo = (PathNode.QuadTo) pathNode2;
                                            float f42 = quadTo.x1;
                                            float f43 = quadTo.y1;
                                            float f44 = quadTo.x2;
                                            float f45 = quadTo.y2;
                                            target.quadraticBezierTo(f42, f43, f44, f45);
                                            f29 = f44;
                                            f30 = f45;
                                            r21 = r13;
                                            pathNode3 = pathNode2;
                                            r24 = r17;
                                            f = 0.0f;
                                            f27 = quadTo.x1;
                                            f28 = f43;
                                        } else if (pathNode2 instanceof PathNode.RelativeReflectiveQuadTo) {
                                            if (pathNode.isQuad) {
                                                f2 = f29 - f27;
                                                f3 = f30 - f28;
                                            } else {
                                                f2 = 0.0f;
                                                f3 = 0.0f;
                                            }
                                            PathNode.RelativeReflectiveQuadTo relativeReflectiveQuadTo = (PathNode.RelativeReflectiveQuadTo) pathNode2;
                                            float f46 = relativeReflectiveQuadTo.dx;
                                            f4 = relativeReflectiveQuadTo.dy;
                                            target.relativeQuadraticBezierTo(f2, f3, f46, f4);
                                            f5 = f2 + f29;
                                            f6 = f3 + f30;
                                            f7 = relativeReflectiveQuadTo.dx;
                                        } else if (pathNode2 instanceof PathNode.ReflectiveQuadTo) {
                                            if (pathNode.isQuad) {
                                                float f47 = 2;
                                                f29 = (f29 * f47) - f27;
                                                f30 = (f47 * f30) - f28;
                                            }
                                            PathNode.ReflectiveQuadTo reflectiveQuadTo = (PathNode.ReflectiveQuadTo) pathNode2;
                                            float f48 = reflectiveQuadTo.x;
                                            float f49 = reflectiveQuadTo.y;
                                            target.quadraticBezierTo(f29, f30, f48, f49);
                                            f27 = f29;
                                            f28 = f30;
                                            r21 = r13;
                                            pathNode3 = pathNode2;
                                            r24 = r17;
                                            f = 0.0f;
                                            f29 = reflectiveQuadTo.x;
                                            f30 = f49;
                                        } else if (pathNode2 instanceof PathNode.RelativeArcTo) {
                                            PathNode.RelativeArcTo relativeArcTo = (PathNode.RelativeArcTo) pathNode2;
                                            float f50 = relativeArcTo.arcStartDx + f29;
                                            float f51 = relativeArcTo.arcStartDy + f30;
                                            r21 = r13;
                                            f = 0.0f;
                                            r24 = r17;
                                            pathNode3 = pathNode2;
                                            drawArc(path, f29, f30, f50, f51, relativeArcTo.horizontalEllipseRadius, relativeArcTo.verticalEllipseRadius, relativeArcTo.theta, relativeArcTo.isMoreThanHalf, relativeArcTo.isPositiveArc);
                                            f27 = f50;
                                            f29 = f27;
                                            f31 = f31;
                                            f32 = f32;
                                            f28 = f51;
                                            f30 = f28;
                                        } else {
                                            float f52 = f31;
                                            float f53 = f32;
                                            r21 = r13;
                                            r24 = r17;
                                            f = 0.0f;
                                            if (pathNode2 instanceof PathNode.ArcTo) {
                                                PathNode.ArcTo arcTo = (PathNode.ArcTo) pathNode2;
                                                double d = arcTo.arcStartX;
                                                float f54 = arcTo.arcStartY;
                                                pathNode3 = pathNode2;
                                                drawArc(path, f29, f30, d, f54, arcTo.horizontalEllipseRadius, arcTo.verticalEllipseRadius, arcTo.theta, arcTo.isMoreThanHalf, arcTo.isPositiveArc);
                                                f29 = arcTo.arcStartX;
                                                f27 = f29;
                                                f28 = f54;
                                                f30 = f28;
                                            } else {
                                                pathNode3 = pathNode2;
                                            }
                                            f31 = f52;
                                            f32 = f53;
                                        }
                                        r13 = r21 + 1;
                                        list2 = list;
                                        target = path;
                                        f26 = f;
                                        size = r24;
                                        pathNode = pathNode3;
                                    }
                                    f29 += f7;
                                    f30 += f4;
                                    f27 = f5;
                                    f28 = f6;
                                    r21 = r13;
                                    pathNode3 = pathNode2;
                                    r24 = r17;
                                    f = 0.0f;
                                    r13 = r21 + 1;
                                    list2 = list;
                                    target = path;
                                    f26 = f;
                                    size = r24;
                                    pathNode = pathNode3;
                                }
                                f30 = f13;
                                f29 = f12;
                                f28 = f11;
                                r21 = r13;
                                pathNode3 = pathNode2;
                                r24 = r17;
                                f = 0.0f;
                                f27 = f10;
                                r13 = r21 + 1;
                                list2 = list;
                                target = path;
                                f26 = f;
                                size = r24;
                                pathNode = pathNode3;
                            }
                            f30 += f16;
                            f28 = f11;
                            r21 = r13;
                            pathNode3 = pathNode2;
                            r24 = r17;
                            f = 0.0f;
                            f27 = f10;
                            r13 = r21 + 1;
                            list2 = list;
                            target = path;
                            f26 = f;
                            size = r24;
                            pathNode = pathNode3;
                        }
                        float f55 = f31;
                        f20 = f22;
                        f19 = f55;
                    }
                    f30 += f21;
                    f19 = f31;
                    f17 = f32;
                    f20 = f29;
                    f18 = f30;
                }
                float f56 = f27;
                f23 = f19;
                f24 = f20;
                f31 = f56;
                float f57 = f18;
                f32 = f28;
                f25 = f57;
            }
            f29 = f24;
            f30 = f25;
            pathNode3 = pathNode4;
            f28 = f32;
            f = f26;
            r21 = r13;
            r24 = size;
            f32 = f17;
            float f58 = f31;
            f31 = f23;
            f27 = f58;
            r13 = r21 + 1;
            list2 = list;
            target = path;
            f26 = f;
            size = r24;
            pathNode = pathNode3;
        }
    }
}
