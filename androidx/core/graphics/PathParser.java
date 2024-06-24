package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class PathParser {

    /* loaded from: classes.dex */
    public static class PathDataNode {
        public final float[] mParams;
        public char mType;

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        public static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            boolean z3;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = f2;
            double d5 = (d4 * sin) + (d3 * cos);
            double d6 = d3;
            double d7 = f5;
            double d8 = d5 / d7;
            double d9 = f6;
            double d10 = ((d4 * cos) + ((-f) * sin)) / d9;
            double d11 = d4;
            double d12 = f4;
            double d13 = ((d12 * sin) + (f3 * cos)) / d7;
            double d14 = ((d12 * cos) + ((-f3) * sin)) / d9;
            double d15 = d8 - d13;
            double d16 = d10 - d14;
            double d17 = (d8 + d13) / 2.0d;
            double d18 = (d10 + d14) / 2.0d;
            double d19 = (d16 * d16) + (d15 * d15);
            if (d19 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d20 = (1.0d / d19) - 0.25d;
            if (d20 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d19);
                float sqrt = (float) (Math.sqrt(d19) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d20);
            double d21 = d15 * sqrt2;
            double d22 = sqrt2 * d16;
            if (z == z2) {
                d = d17 - d22;
                d2 = d18 + d21;
            } else {
                d = d17 + d22;
                d2 = d18 - d21;
            }
            double atan2 = Math.atan2(d10 - d2, d8 - d);
            double atan22 = Math.atan2(d14 - d2, d13 - d) - atan2;
            if (atan22 >= 0.0d) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                if (atan22 > 0.0d) {
                    atan22 -= 6.283185307179586d;
                } else {
                    atan22 += 6.283185307179586d;
                }
            }
            double d23 = d * d7;
            double d24 = d2 * d9;
            double d25 = (d23 * cos) - (d24 * sin);
            double d26 = (d24 * cos) + (d23 * sin);
            int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
            double cos2 = Math.cos(radians);
            double sin2 = Math.sin(radians);
            double cos3 = Math.cos(atan2);
            double sin3 = Math.sin(atan2);
            double d27 = -d7;
            double d28 = d27 * cos2;
            double d29 = d9 * sin2;
            double d30 = (d28 * sin3) - (d29 * cos3);
            double d31 = d27 * sin2;
            double d32 = d9 * cos2;
            double d33 = (cos3 * d32) + (sin3 * d31);
            double d34 = d32;
            double d35 = atan22 / ceil;
            int r3 = 0;
            while (r3 < ceil) {
                double d36 = atan2 + d35;
                double sin4 = Math.sin(d36);
                double cos4 = Math.cos(d36);
                double d37 = d35;
                double d38 = (((d7 * cos2) * cos4) + d25) - (d29 * sin4);
                double d39 = d34;
                double d40 = d25;
                double d41 = (d39 * sin4) + (d7 * sin2 * cos4) + d26;
                double d42 = (d28 * sin4) - (d29 * cos4);
                double d43 = (cos4 * d39) + (sin4 * d31);
                double d44 = d36 - atan2;
                double tan = Math.tan(d44 / 2.0d);
                double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d44)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d30 * sqrt3) + d6), (float) ((d33 * sqrt3) + d11), (float) (d38 - (sqrt3 * d42)), (float) (d41 - (sqrt3 * d43)), (float) d38, (float) d41);
                r3++;
                atan2 = d36;
                d31 = d31;
                cos2 = cos2;
                ceil = ceil;
                d33 = d43;
                d7 = d7;
                d30 = d42;
                d6 = d38;
                d11 = d41;
                d25 = d40;
                d35 = d37;
                d34 = d39;
            }
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            int r21;
            int r30;
            char c;
            PathDataNode pathDataNode;
            int r28;
            boolean z;
            boolean z2;
            float f;
            float f2;
            boolean z3;
            boolean z4;
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
            PathDataNode[] pathDataNodeArr2 = pathDataNodeArr;
            int r12 = 6;
            float[] fArr = new float[6];
            char c2 = 'm';
            int r15 = 0;
            char c3 = 'm';
            int r10 = 0;
            while (r10 < pathDataNodeArr2.length) {
                PathDataNode pathDataNode2 = pathDataNodeArr2[r10];
                char c4 = pathDataNode2.mType;
                float f22 = fArr[r15];
                float f23 = fArr[1];
                float f24 = fArr[2];
                float f25 = fArr[3];
                float f26 = fArr[4];
                float f27 = fArr[5];
                switch (c4) {
                    case 'A':
                    case 'a':
                        r21 = 7;
                        break;
                    case 'C':
                    case 'c':
                        r21 = r12;
                        break;
                    case 'H':
                    case 'V':
                    case 'h':
                    case 'v':
                        r21 = 1;
                        break;
                    case 'Q':
                    case 'S':
                    case 'q':
                    case 's':
                        r21 = 4;
                        break;
                    case 'Z':
                    case 'z':
                        path.close();
                        path.moveTo(f26, f27);
                        f22 = f26;
                        f24 = f22;
                        f23 = f27;
                        f25 = f23;
                        break;
                }
                r21 = 2;
                float f28 = f26;
                float f29 = f27;
                float f30 = f22;
                float f31 = f23;
                int r3 = r15;
                while (true) {
                    float[] fArr2 = pathDataNode2.mParams;
                    if (r3 < fArr2.length) {
                        if (c4 != 'A') {
                            if (c4 != 'C') {
                                if (c4 != 'H') {
                                    if (c4 != 'Q') {
                                        if (c4 != 'V') {
                                            if (c4 != 'a') {
                                                if (c4 != 'c') {
                                                    if (c4 != 'h') {
                                                        if (c4 != 'q') {
                                                            if (c4 != 'v') {
                                                                if (c4 != 'L') {
                                                                    if (c4 != 'M') {
                                                                        if (c4 != 'S') {
                                                                            if (c4 != 'T') {
                                                                                if (c4 != 'l') {
                                                                                    if (c4 != c2) {
                                                                                        if (c4 != 's') {
                                                                                            if (c4 == 't') {
                                                                                                if (c3 != 'q' && c3 != 't' && c3 != 'Q' && c3 != 'T') {
                                                                                                    f21 = 0.0f;
                                                                                                    f20 = 0.0f;
                                                                                                } else {
                                                                                                    f20 = f30 - f24;
                                                                                                    f21 = f31 - f25;
                                                                                                }
                                                                                                int r4 = r3 + 0;
                                                                                                int r122 = r3 + 1;
                                                                                                path.rQuadTo(f20, f21, fArr2[r4], fArr2[r122]);
                                                                                                float f32 = f20 + f30;
                                                                                                float f33 = f21 + f31;
                                                                                                f30 += fArr2[r4];
                                                                                                f31 += fArr2[r122];
                                                                                                f25 = f33;
                                                                                                f24 = f32;
                                                                                            }
                                                                                            r30 = r3;
                                                                                        } else {
                                                                                            if (c3 != 'c' && c3 != 's' && c3 != 'C' && c3 != 'S') {
                                                                                                f18 = 0.0f;
                                                                                                f19 = 0.0f;
                                                                                            } else {
                                                                                                float f34 = f30 - f24;
                                                                                                f18 = f31 - f25;
                                                                                                f19 = f34;
                                                                                            }
                                                                                            int r123 = r3 + 0;
                                                                                            int r14 = r3 + 1;
                                                                                            int r25 = r3 + 2;
                                                                                            int r27 = r3 + 3;
                                                                                            r30 = r3;
                                                                                            f3 = f31;
                                                                                            float f35 = f30;
                                                                                            path.rCubicTo(f19, f18, fArr2[r123], fArr2[r14], fArr2[r25], fArr2[r27]);
                                                                                            f4 = fArr2[r123] + f35;
                                                                                            f5 = fArr2[r14] + f3;
                                                                                            f6 = f35 + fArr2[r25];
                                                                                            f7 = fArr2[r27];
                                                                                        }
                                                                                    } else {
                                                                                        r30 = r3;
                                                                                        float f36 = fArr2[r30 + 0];
                                                                                        f30 += f36;
                                                                                        float f37 = fArr2[r30 + 1];
                                                                                        f31 += f37;
                                                                                        if (r30 > 0) {
                                                                                            path.rLineTo(f36, f37);
                                                                                        } else {
                                                                                            path.rMoveTo(f36, f37);
                                                                                            f29 = f31;
                                                                                            f28 = f30;
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    r30 = r3;
                                                                                    f10 = f31;
                                                                                    int r32 = r30 + 0;
                                                                                    float f38 = fArr2[r32];
                                                                                    int r2 = r30 + 1;
                                                                                    path.rLineTo(f38, fArr2[r2]);
                                                                                    f30 += fArr2[r32];
                                                                                    f11 = fArr2[r2];
                                                                                }
                                                                            } else {
                                                                                r30 = r3;
                                                                                float f39 = f31;
                                                                                float f40 = f30;
                                                                                if (c3 != 'q' && c3 != 't' && c3 != 'Q' && c3 != 'T') {
                                                                                    f16 = f40;
                                                                                    f17 = f39;
                                                                                } else {
                                                                                    f16 = (f40 * 2.0f) - f24;
                                                                                    f17 = (f39 * 2.0f) - f25;
                                                                                }
                                                                                int r33 = r30 + 0;
                                                                                int r1 = r30 + 1;
                                                                                path.quadTo(f16, f17, fArr2[r33], fArr2[r1]);
                                                                                f25 = f17;
                                                                                f24 = f16;
                                                                                c = c4;
                                                                                pathDataNode = pathDataNode2;
                                                                                r28 = r10;
                                                                                f30 = fArr2[r33];
                                                                                f31 = fArr2[r1];
                                                                            }
                                                                        } else {
                                                                            r30 = r3;
                                                                            float f41 = f31;
                                                                            float f42 = f30;
                                                                            if (c3 != 'c' && c3 != 's' && c3 != 'C' && c3 != 'S') {
                                                                                f15 = f42;
                                                                                f14 = f41;
                                                                            } else {
                                                                                f14 = (f41 * 2.0f) - f25;
                                                                                f15 = (f42 * 2.0f) - f24;
                                                                            }
                                                                            int r0 = r30 + 0;
                                                                            int r124 = r30 + 1;
                                                                            int r142 = r30 + 2;
                                                                            int r152 = r30 + 3;
                                                                            path.cubicTo(f15, f14, fArr2[r0], fArr2[r124], fArr2[r142], fArr2[r152]);
                                                                            float f43 = fArr2[r0];
                                                                            float f44 = fArr2[r124];
                                                                            f9 = fArr2[r142];
                                                                            f8 = fArr2[r152];
                                                                            f24 = f43;
                                                                            f25 = f44;
                                                                            f30 = f9;
                                                                            f31 = f8;
                                                                        }
                                                                    } else {
                                                                        r30 = r3;
                                                                        f12 = fArr2[r30 + 0];
                                                                        f13 = fArr2[r30 + 1];
                                                                        if (r30 > 0) {
                                                                            path.lineTo(f12, f13);
                                                                        } else {
                                                                            path.moveTo(f12, f13);
                                                                            f28 = f12;
                                                                            f29 = f13;
                                                                        }
                                                                    }
                                                                    f30 = f28;
                                                                    f31 = f29;
                                                                } else {
                                                                    r30 = r3;
                                                                    int r34 = r30 + 0;
                                                                    int r13 = r30 + 1;
                                                                    path.lineTo(fArr2[r34], fArr2[r13]);
                                                                    f12 = fArr2[r34];
                                                                    f13 = fArr2[r13];
                                                                }
                                                                f30 = f12;
                                                                f31 = f13;
                                                            } else {
                                                                r30 = r3;
                                                                f10 = f31;
                                                                int r35 = r30 + 0;
                                                                path.rLineTo(0.0f, fArr2[r35]);
                                                                f11 = fArr2[r35];
                                                            }
                                                            f31 = f10 + f11;
                                                        } else {
                                                            r30 = r3;
                                                            f3 = f31;
                                                            float f45 = f30;
                                                            int r36 = r30 + 0;
                                                            float f46 = fArr2[r36];
                                                            int r22 = r30 + 1;
                                                            int r5 = r30 + 2;
                                                            int r7 = r30 + 3;
                                                            path.rQuadTo(f46, fArr2[r22], fArr2[r5], fArr2[r7]);
                                                            f4 = fArr2[r36] + f45;
                                                            f5 = fArr2[r22] + f3;
                                                            float f47 = f45 + fArr2[r5];
                                                            float f48 = fArr2[r7];
                                                            f6 = f47;
                                                            f7 = f48;
                                                        }
                                                    } else {
                                                        r30 = r3;
                                                        int r37 = r30 + 0;
                                                        path.rLineTo(fArr2[r37], 0.0f);
                                                        f30 += fArr2[r37];
                                                    }
                                                    c = c4;
                                                    pathDataNode = pathDataNode2;
                                                    r28 = r10;
                                                } else {
                                                    r30 = r3;
                                                    f3 = f31;
                                                    float f49 = f30;
                                                    int r125 = r30 + 2;
                                                    int r143 = r30 + 3;
                                                    int r24 = r30 + 4;
                                                    int r252 = r30 + 5;
                                                    path.rCubicTo(fArr2[r30 + 0], fArr2[r30 + 1], fArr2[r125], fArr2[r143], fArr2[r24], fArr2[r252]);
                                                    f4 = fArr2[r125] + f49;
                                                    f5 = fArr2[r143] + f3;
                                                    f6 = f49 + fArr2[r24];
                                                    f7 = fArr2[r252];
                                                }
                                                f8 = f3 + f7;
                                                f24 = f4;
                                                f25 = f5;
                                                f9 = f6;
                                                f30 = f9;
                                                f31 = f8;
                                                c = c4;
                                                pathDataNode = pathDataNode2;
                                                r28 = r10;
                                            } else {
                                                r30 = r3;
                                                float f50 = f31;
                                                float f51 = f30;
                                                int r126 = r30 + 5;
                                                float f52 = fArr2[r126] + f51;
                                                int r144 = r30 + 6;
                                                float f53 = fArr2[r144] + f50;
                                                float f54 = fArr2[r30 + 0];
                                                float f55 = fArr2[r30 + 1];
                                                float f56 = fArr2[r30 + 2];
                                                if (fArr2[r30 + 3] != 0.0f) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (fArr2[r30 + 4] != 0.0f) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                c = c4;
                                                pathDataNode = pathDataNode2;
                                                r28 = r10;
                                                drawArc(path, f51, f50, f52, f53, f54, f55, f56, z3, z4);
                                                f30 = f51 + fArr2[r126];
                                                f31 = f50 + fArr2[r144];
                                            }
                                        } else {
                                            r30 = r3;
                                            c = c4;
                                            pathDataNode = pathDataNode2;
                                            r28 = r10;
                                            int r38 = r30 + 0;
                                            path.lineTo(f30, fArr2[r38]);
                                            f31 = fArr2[r38];
                                        }
                                    } else {
                                        r30 = r3;
                                        c = c4;
                                        pathDataNode = pathDataNode2;
                                        r28 = r10;
                                        int r39 = r30 + 0;
                                        int r16 = r30 + 1;
                                        int r42 = r30 + 2;
                                        int r6 = r30 + 3;
                                        path.quadTo(fArr2[r39], fArr2[r16], fArr2[r42], fArr2[r6]);
                                        f = fArr2[r39];
                                        f2 = fArr2[r16];
                                        f30 = fArr2[r42];
                                        f31 = fArr2[r6];
                                    }
                                } else {
                                    r30 = r3;
                                    c = c4;
                                    pathDataNode = pathDataNode2;
                                    r28 = r10;
                                    int r310 = r30 + 0;
                                    path.lineTo(fArr2[r310], f31);
                                    f30 = fArr2[r310];
                                }
                                r3 = r30 + r21;
                                pathDataNode2 = pathDataNode;
                                c3 = c;
                                c4 = c3;
                                r10 = r28;
                                c2 = 'm';
                                r15 = 0;
                            } else {
                                r30 = r3;
                                c = c4;
                                pathDataNode = pathDataNode2;
                                r28 = r10;
                                int r02 = r30 + 2;
                                int r8 = r30 + 3;
                                int r9 = r30 + 4;
                                int r102 = r30 + 5;
                                path.cubicTo(fArr2[r30 + 0], fArr2[r30 + 1], fArr2[r02], fArr2[r8], fArr2[r9], fArr2[r102]);
                                float f57 = fArr2[r9];
                                float f58 = fArr2[r102];
                                f = fArr2[r02];
                                f30 = f57;
                                f31 = f58;
                                f2 = fArr2[r8];
                            }
                            f24 = f;
                            f25 = f2;
                            r3 = r30 + r21;
                            pathDataNode2 = pathDataNode;
                            c3 = c;
                            c4 = c3;
                            r10 = r28;
                            c2 = 'm';
                            r15 = 0;
                        } else {
                            r30 = r3;
                            float f59 = f31;
                            float f60 = f30;
                            c = c4;
                            pathDataNode = pathDataNode2;
                            r28 = r10;
                            int r127 = r30 + 5;
                            float f61 = fArr2[r127];
                            int r145 = r30 + 6;
                            float f62 = fArr2[r145];
                            float f63 = fArr2[r30 + 0];
                            float f64 = fArr2[r30 + 1];
                            float f65 = fArr2[r30 + 2];
                            if (fArr2[r30 + 3] != 0.0f) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (fArr2[r30 + 4] != 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            drawArc(path, f60, f59, f61, f62, f63, f64, f65, z, z2);
                            f30 = fArr2[r127];
                            f31 = fArr2[r145];
                        }
                        f25 = f31;
                        f24 = f30;
                        r3 = r30 + r21;
                        pathDataNode2 = pathDataNode;
                        c3 = c;
                        c4 = c3;
                        r10 = r28;
                        c2 = 'm';
                        r15 = 0;
                    }
                }
                int r282 = r10;
                int r17 = r15;
                fArr[r17] = f30;
                fArr[1] = f31;
                fArr[2] = f24;
                fArr[3] = f25;
                fArr[4] = f28;
                fArr[5] = f29;
                r10 = r282 + 1;
                r12 = 6;
                c2 = 'm';
                r15 = r17;
                c3 = pathDataNodeArr[r282].mType;
                pathDataNodeArr2 = pathDataNodeArr;
            }
        }
    }

    public static float[] copyOfRange(float[] fArr, int r3) {
        if (r3 >= 0) {
            int length = fArr.length;
            if (length >= 0) {
                int r32 = r3 - 0;
                int min = Math.min(r32, length - 0);
                float[] fArr2 = new float[r32];
                System.arraycopy(fArr, 0, fArr2, 0, min);
                return fArr2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x008a, code lost:            if (r13 == 0) goto L42;     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0097 A[Catch: NumberFormatException -> 0x00bc, LOOP:3: B:29:0x006c->B:40:0x0097, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:26:0x0059, B:29:0x006c, B:31:0x0072, B:36:0x0080, B:40:0x0097, B:44:0x009c, B:49:0x00ac, B:61:0x00b1), top: B:25:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c A[Catch: NumberFormatException -> 0x00bc, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:26:0x0059, B:29:0x006c, B:31:0x0072, B:36:0x0080, B:40:0x0097, B:44:0x009c, B:49:0x00ac, B:61:0x00b1), top: B:25:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ac A[Catch: NumberFormatException -> 0x00bc, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:26:0x0059, B:29:0x006c, B:31:0x0072, B:36:0x0080, B:40:0x0097, B:44:0x009c, B:49:0x00ac, B:61:0x00b1), top: B:25:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.core.graphics.PathParser.PathDataNode[] createNodesFromPathData(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.createNodesFromPathData(java.lang.String):androidx.core.graphics.PathParser$PathDataNode[]");
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData != null) {
            try {
                PathDataNode.nodesToPath(createNodesFromPathData, path);
                return path;
            } catch (RuntimeException e) {
                throw new RuntimeException(ConstraintSet$$ExternalSyntheticOutline0.m("Error in parsing ", str), e);
            }
        }
        return null;
    }
}
