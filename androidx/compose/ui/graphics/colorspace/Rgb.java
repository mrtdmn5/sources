package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Rgb.kt */
/* loaded from: classes.dex */
public final class Rgb extends ColorSpace {
    public static final Rgb$$ExternalSyntheticLambda2 DoubleIdentity = new Rgb$$ExternalSyntheticLambda2();
    public final Rgb$eotf$1 eotf;
    public final Rgb$$ExternalSyntheticLambda1 eotfFunc;
    public final DoubleFunction eotfOrig;
    public final float[] inverseTransform;
    public final boolean isSrgb;
    public final float max;
    public final float min;
    public final Rgb$oetf$1 oetf;
    public final Rgb$$ExternalSyntheticLambda0 oetfFunc;
    public final DoubleFunction oetfOrig;
    public final float[] primaries;
    public final TransferParameters transferParameters;
    public final float[] transform;
    public final WhitePoint whitePoint;

    /* compiled from: Rgb.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static float area(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float f7 = (((((f3 * f6) + ((f2 * f5) + (f * f4))) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
            if (f7 < 0.0f) {
                return -f7;
            }
            return f7;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.graphics.colorspace.Rgb$oetf$1] */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.graphics.colorspace.Rgb$eotf$1] */
    public Rgb(String name, float[] primaries, WhitePoint whitePoint, float[] fArr, DoubleFunction oetf, DoubleFunction eotf, float f, float f2, TransferParameters transferParameters, int r40) {
        super(name, ColorModel.Rgb, r40);
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(primaries, "primaries");
        Intrinsics.checkNotNullParameter(oetf, "oetf");
        Intrinsics.checkNotNullParameter(eotf, "eotf");
        this.whitePoint = whitePoint;
        this.min = f;
        this.max = f2;
        this.transferParameters = transferParameters;
        this.oetfOrig = oetf;
        this.oetf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$oetf$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Double invoke(Double d) {
                return Double.valueOf(RangesKt___RangesKt.coerceIn(Rgb.this.oetfOrig.invoke(d.doubleValue()), r10.min, r10.max));
            }
        };
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda0(this);
        this.eotfOrig = eotf;
        this.eotf = new Function1<Double, Double>() { // from class: androidx.compose.ui.graphics.colorspace.Rgb$eotf$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Double invoke(Double d) {
                double doubleValue = d.doubleValue();
                return Double.valueOf(Rgb.this.eotfOrig.invoke(RangesKt___RangesKt.coerceIn(doubleValue, r8.min, r8.max)));
            }
        };
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda1(this);
        if (primaries.length != 6 && primaries.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        }
        if (f < f2) {
            float[] fArr2 = new float[6];
            if (primaries.length == 9) {
                float f3 = primaries[0];
                float f4 = primaries[1];
                float f5 = f3 + f4 + primaries[2];
                fArr2[0] = f3 / f5;
                fArr2[1] = f4 / f5;
                float f6 = primaries[3];
                float f7 = primaries[4];
                float f8 = f6 + f7 + primaries[5];
                fArr2[2] = f6 / f8;
                fArr2[3] = f7 / f8;
                float f9 = primaries[6];
                float f10 = primaries[7];
                float f11 = f9 + f10 + primaries[8];
                fArr2[4] = f9 / f11;
                fArr2[5] = f10 / f11;
            } else {
                System.arraycopy(primaries, 0, fArr2, 0, 6);
            }
            this.primaries = fArr2;
            if (fArr == null) {
                float f12 = fArr2[0];
                float f13 = fArr2[1];
                float f14 = fArr2[2];
                float f15 = fArr2[3];
                float f16 = fArr2[4];
                float f17 = fArr2[5];
                float f18 = 1;
                float f19 = (f18 - f12) / f13;
                float f20 = (f18 - f14) / f15;
                float f21 = (f18 - f16) / f17;
                float f22 = whitePoint.x;
                float f23 = whitePoint.y;
                float f24 = (f18 - f22) / f23;
                float f25 = f12 / f13;
                float f26 = (f14 / f15) - f25;
                float f27 = (f22 / f23) - f25;
                float f28 = f20 - f19;
                float f29 = (f16 / f17) - f25;
                float f30 = (((f24 - f19) * f26) - (f27 * f28)) / (((f21 - f19) * f26) - (f28 * f29));
                float f31 = (f27 - (f29 * f30)) / f26;
                float f32 = (1.0f - f31) - f30;
                float f33 = f32 / f13;
                float f34 = f31 / f15;
                float f35 = f30 / f17;
                this.transform = new float[]{f33 * f12, f32, ((1.0f - f12) - f13) * f33, f34 * f14, f31, ((1.0f - f14) - f15) * f34, f35 * f16, f30, ((1.0f - f16) - f17) * f35};
            } else if (fArr.length == 9) {
                this.transform = fArr;
            } else {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr.length);
            }
            this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
            float area = Companion.area(fArr2);
            float[] fArr3 = ColorSpaces.SrgbPrimaries;
            if (area / Companion.area(ColorSpaces.Ntsc1953Primaries) > 0.9f) {
                float[] fArr4 = ColorSpaces.SrgbPrimaries;
                float f36 = fArr2[0];
                float f37 = fArr4[0];
                float f38 = f36 - f37;
                z = true;
                float f39 = fArr2[1];
                float f40 = fArr4[1];
                float f41 = f39 - f40;
                float f42 = fArr2[2];
                float f43 = fArr4[2];
                float f44 = f42 - f43;
                float f45 = fArr2[3];
                float f46 = fArr4[3];
                float f47 = f45 - f46;
                float f48 = fArr2[4];
                float f49 = fArr4[4];
                float f50 = f48 - f49;
                float f51 = fArr2[5];
                float f52 = fArr4[5];
                float f53 = f51 - f52;
                if (((f40 - f52) * f38) - ((f37 - f49) * f41) < 0.0f || ((f37 - f43) * f41) - ((f40 - f46) * f38) < 0.0f || ((f46 - f40) * f44) - ((f43 - f37) * f47) < 0.0f || ((f43 - f49) * f47) - ((f46 - f52) * f44) < 0.0f || ((f52 - f46) * f50) - ((f49 - f43) * f53) < 0.0f || ((f49 - f37) * f53) - ((f52 - f40) * f50) < 0.0f) {
                }
            } else {
                z = true;
            }
            if (r40 != 0) {
                float[] fArr5 = ColorSpaces.SrgbPrimaries;
                if (fArr2 != fArr5) {
                    for (int r9 = 0; r9 < 6; r9++) {
                        if (Float.compare(fArr2[r9], fArr5[r9]) != 0 && Math.abs(fArr2[r9] - fArr5[r9]) > 0.001f) {
                            z3 = false;
                            break;
                        }
                    }
                }
                z3 = z;
                if (z3 && ColorSpaceKt.compare(whitePoint, MessageFormatter.D65)) {
                    if (f == 0.0f ? z : false) {
                        if (f2 == 1.0f ? z : false) {
                            float[] fArr6 = ColorSpaces.SrgbPrimaries;
                            Rgb rgb = ColorSpaces.Srgb;
                            for (double d = 0.0d; d <= 1.0d; d += 0.00392156862745098d) {
                                if (Math.abs(oetf.invoke(d) - rgb.oetfOrig.invoke(d)) <= 0.001d ? z : false) {
                                    if (Math.abs(eotf.invoke(d) - rgb.eotfOrig.invoke(d)) <= 0.001d ? z : false) {
                                    }
                                }
                            }
                        }
                    }
                }
                z2 = false;
                this.isSrgb = z2;
                return;
            }
            z2 = z;
            this.isSrgb = z2;
            return;
        }
        throw new IllegalArgumentException("Invalid range: min=" + f + ", max=" + f2 + "; min must be strictly < max");
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Rgb.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual(this.whitePoint, rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters = rgb.transferParameters;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual(transferParameters2, transferParameters);
        }
        if (transferParameters == null) {
            return true;
        }
        if (!Intrinsics.areEqual(this.oetfOrig, rgb.oetfOrig)) {
            return false;
        }
        return Intrinsics.areEqual(this.eotfOrig, rgb.eotfOrig);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] fromXyz(float[] fArr) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, fArr);
        double d = fArr[0];
        Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.oetfFunc;
        fArr[0] = (float) rgb$$ExternalSyntheticLambda0.invoke(d);
        fArr[1] = (float) rgb$$ExternalSyntheticLambda0.invoke(fArr[1]);
        fArr[2] = (float) rgb$$ExternalSyntheticLambda0.invoke(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMaxValue(int r1) {
        return this.max;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float getMinValue(int r1) {
        return this.min;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final int hashCode() {
        boolean z;
        int r1;
        int r12;
        int hashCode = (Arrays.hashCode(this.primaries) + ((this.whitePoint.hashCode() + (super.hashCode() * 31)) * 31)) * 31;
        float f = this.min;
        boolean z2 = true;
        int r5 = 0;
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            r1 = Float.floatToIntBits(f);
        } else {
            r1 = 0;
        }
        int r0 = (hashCode + r1) * 31;
        float f2 = this.max;
        if (f2 != 0.0f) {
            z2 = false;
        }
        if (!z2) {
            r12 = Float.floatToIntBits(f2);
        } else {
            r12 = 0;
        }
        int r02 = (r0 + r12) * 31;
        TransferParameters transferParameters = this.transferParameters;
        if (transferParameters != null) {
            r5 = transferParameters.hashCode();
        }
        int r03 = r02 + r5;
        if (transferParameters == null) {
            return this.eotfOrig.hashCode() + ((this.oetfOrig.hashCode() + (r03 * 31)) * 31);
        }
        return r03;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final boolean isSrgb() {
        return this.isSrgb;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final long toXy$ui_graphics_release(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.eotfFunc;
        float invoke = (float) rgb$$ExternalSyntheticLambda1.invoke(d);
        float invoke2 = (float) rgb$$ExternalSyntheticLambda1.invoke(f2);
        float invoke3 = (float) rgb$$ExternalSyntheticLambda1.invoke(f3);
        float[] fArr = this.transform;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, invoke, invoke2, invoke3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, invoke, invoke2, invoke3);
        return (Float.floatToIntBits(mul3x3Float3_0) << 32) | (Float.floatToIntBits(mul3x3Float3_1) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float[] toXyz(float[] fArr) {
        double d = fArr[0];
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.eotfFunc;
        fArr[0] = (float) rgb$$ExternalSyntheticLambda1.invoke(d);
        fArr[1] = (float) rgb$$ExternalSyntheticLambda1.invoke(fArr[1]);
        fArr[2] = (float) rgb$$ExternalSyntheticLambda1.invoke(fArr[2]);
        ColorSpaceKt.mul3x3Float3(this.transform, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public final float toZ$ui_graphics_release(float f, float f2, float f3) {
        double d = f;
        Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = this.eotfFunc;
        return ColorSpaceKt.mul3x3Float3_2(this.transform, (float) rgb$$ExternalSyntheticLambda1.invoke(d), (float) rgb$$ExternalSyntheticLambda1.invoke(f2), (float) rgb$$ExternalSyntheticLambda1.invoke(f3));
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public final long mo350xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        float[] fArr = this.inverseTransform;
        float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, f, f2, f3);
        float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, f, f2, f3);
        float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, f, f2, f3);
        Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = this.oetfFunc;
        return ColorKt.Color((float) rgb$$ExternalSyntheticLambda0.invoke(mul3x3Float3_0), (float) rgb$$ExternalSyntheticLambda0.invoke(mul3x3Float3_1), (float) rgb$$ExternalSyntheticLambda0.invoke(mul3x3Float3_2), f4, colorSpace);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Rgb(java.lang.String r12, float[] r13, androidx.compose.ui.graphics.colorspace.WhitePoint r14, final androidx.compose.ui.graphics.colorspace.TransferParameters r15, int r16) {
        /*
            r11 = this;
            r9 = r15
            r4 = 0
            double r0 = r9.e
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 1
            r5 = 0
            if (r0 != 0) goto Le
            r6 = r1
            goto Lf
        Le:
            r6 = r5
        Lf:
            double r7 = r9.f
            if (r6 == 0) goto L22
            int r6 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r6 != 0) goto L19
            r6 = r1
            goto L1a
        L19:
            r6 = r5
        L1a:
            if (r6 == 0) goto L22
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3 r6 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
            r6.<init>(r15)
            goto L27
        L22:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4 r6 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda4
            r6.<init>()
        L27:
            if (r0 != 0) goto L2b
            r0 = r1
            goto L2c
        L2b:
            r0 = r5
        L2c:
            if (r0 == 0) goto L3c
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L33
            goto L34
        L33:
            r1 = r5
        L34:
            if (r1 == 0) goto L3c
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda5
            r0.<init>()
            goto L41
        L3c:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6
            r0.<init>()
        L41:
            r7 = r0
            r8 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r9 = r15
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8] */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Rgb(java.lang.String r16, float[] r17, androidx.compose.ui.graphics.colorspace.WhitePoint r18, final double r19, float r21, float r22, int r23) {
        /*
            r15 = this;
            r1 = r19
            r11 = 0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r0 != 0) goto Ld
            r5 = r3
            goto Le
        Ld:
            r5 = r4
        Le:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2 r6 = androidx.compose.ui.graphics.colorspace.Rgb.DoubleIdentity
            if (r5 == 0) goto L14
            r12 = r6
            goto L1a
        L14:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7 r5 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7
            r5.<init>()
            r12 = r5
        L1a:
            if (r0 != 0) goto L1d
            goto L1e
        L1d:
            r3 = r4
        L1e:
            if (r3 == 0) goto L22
            r13 = r6
            goto L28
        L22:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8
            r0.<init>()
            r13 = r0
        L28:
            androidx.compose.ui.graphics.colorspace.TransferParameters r14 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r0 = r14
            r1 = r19
            r0.<init>(r1, r3, r5, r7, r9)
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r21
            r8 = r22
            r9 = r14
            r10 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }
}
