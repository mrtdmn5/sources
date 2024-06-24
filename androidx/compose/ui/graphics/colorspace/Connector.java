package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: Connector.kt */
/* loaded from: classes.dex */
public class Connector {
    public static final Connector OklabToSrgbPerceptual;
    public static final Connector$Companion$identity$1 SrgbIdentity;
    public static final Connector SrgbToOklabPerceptual;
    public final ColorSpace destination;
    public final float[] transform;
    public final ColorSpace transformDestination;
    public final ColorSpace transformSource;

    /* compiled from: Connector.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    /* compiled from: Connector.kt */
    /* loaded from: classes.dex */
    public static final class RgbConnector extends Connector {
        public final Rgb mDestination;
        public final Rgb mSource;
        public final float[] mTransform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RgbConnector(Rgb rgb, Rgb mDestination, int r13) {
            super(rgb, mDestination, rgb, mDestination, null);
            boolean z;
            float[] mul3x3;
            Intrinsics.checkNotNullParameter(mDestination, "mDestination");
            this.mSource = rgb;
            this.mDestination = mDestination;
            WhitePoint whitePoint = rgb.whitePoint;
            WhitePoint whitePoint2 = mDestination.whitePoint;
            boolean compare = ColorSpaceKt.compare(whitePoint, whitePoint2);
            float[] fArr = rgb.transform;
            float[] fArr2 = mDestination.inverseTransform;
            if (compare) {
                mul3x3 = ColorSpaceKt.mul3x3(fArr2, fArr);
            } else {
                float[] xyz$ui_graphics_release = whitePoint.toXyz$ui_graphics_release();
                float[] xyz$ui_graphics_release2 = whitePoint2.toXyz$ui_graphics_release();
                WhitePoint whitePoint3 = MessageFormatter.D50;
                boolean compare2 = ColorSpaceKt.compare(whitePoint, whitePoint3);
                float[] fArr3 = MessageFormatter.D50Xyz;
                float[] fArr4 = Adaptation.Bradford.transform;
                if (!compare2) {
                    float[] copyOf = Arrays.copyOf(fArr3, 3);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                    fArr = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(fArr4, xyz$ui_graphics_release, copyOf), fArr);
                }
                if (!ColorSpaceKt.compare(whitePoint2, whitePoint3)) {
                    float[] copyOf2 = Arrays.copyOf(fArr3, 3);
                    Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                    fArr2 = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(fArr4, xyz$ui_graphics_release2, copyOf2), mDestination.transform));
                }
                if (r13 == 3) {
                    z = true;
                } else {
                    z = false;
                }
                mul3x3 = ColorSpaceKt.mul3x3(fArr2, z ? ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, fArr) : fArr);
            }
            this.mTransform = mul3x3;
        }

        @Override // androidx.compose.ui.graphics.colorspace.Connector
        /* renamed from: transformToColor-wmQWz5c$ui_graphics_release */
        public final long mo351transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
            Rgb rgb = this.mSource;
            float invoke = (float) rgb.eotfFunc.invoke(f);
            double d = f2;
            Rgb$$ExternalSyntheticLambda1 rgb$$ExternalSyntheticLambda1 = rgb.eotfFunc;
            float invoke2 = (float) rgb$$ExternalSyntheticLambda1.invoke(d);
            float invoke3 = (float) rgb$$ExternalSyntheticLambda1.invoke(f3);
            float[] fArr = this.mTransform;
            float mul3x3Float3_0 = ColorSpaceKt.mul3x3Float3_0(fArr, invoke, invoke2, invoke3);
            float mul3x3Float3_1 = ColorSpaceKt.mul3x3Float3_1(fArr, invoke, invoke2, invoke3);
            float mul3x3Float3_2 = ColorSpaceKt.mul3x3Float3_2(fArr, invoke, invoke2, invoke3);
            Rgb rgb2 = this.mDestination;
            float invoke4 = (float) rgb2.oetfFunc.invoke(mul3x3Float3_0);
            double d2 = mul3x3Float3_1;
            Rgb$$ExternalSyntheticLambda0 rgb$$ExternalSyntheticLambda0 = rgb2.oetfFunc;
            return ColorKt.Color(invoke4, (float) rgb$$ExternalSyntheticLambda0.invoke(d2), (float) rgb$$ExternalSyntheticLambda0.invoke(mul3x3Float3_2), f4, rgb2);
        }
    }

    static {
        new Companion();
        Rgb source = ColorSpaces.Srgb;
        Intrinsics.checkNotNullParameter(source, "source");
        SrgbIdentity = new Connector$Companion$identity$1(source);
        Oklab oklab = ColorSpaces.Oklab;
        SrgbToOklabPerceptual = new Connector(source, oklab, 0);
        OklabToSrgbPerceptual = new Connector(oklab, source, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Connector(androidx.compose.ui.graphics.colorspace.ColorSpace r12, androidx.compose.ui.graphics.colorspace.ColorSpace r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            long r0 = androidx.compose.ui.graphics.colorspace.ColorModel.Rgb
            long r2 = r12.model
            boolean r4 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r2, r0)
            if (r4 == 0) goto L1b
            androidx.compose.ui.graphics.colorspace.ColorSpace r4 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.adapt$default(r12)
            r8 = r4
            goto L1c
        L1b:
            r8 = r12
        L1c:
            long r4 = r13.model
            boolean r6 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r4, r0)
            if (r6 == 0) goto L2a
            androidx.compose.ui.graphics.colorspace.ColorSpace r6 = androidx.compose.ui.graphics.colorspace.ColorSpaceKt.adapt$default(r13)
            r9 = r6
            goto L2b
        L2a:
            r9 = r13
        L2b:
            r6 = 1
            r7 = 0
            r10 = 3
            if (r14 != r10) goto L32
            r14 = r6
            goto L33
        L32:
            r14 = r7
        L33:
            if (r14 != 0) goto L36
            goto L48
        L36:
            boolean r14 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r2, r0)
            boolean r0 = androidx.compose.ui.graphics.colorspace.ColorModel.m348equalsimpl0(r4, r0)
            if (r14 == 0) goto L43
            if (r0 == 0) goto L43
            goto L48
        L43:
            if (r14 != 0) goto L4b
            if (r0 == 0) goto L48
            goto L4b
        L48:
            r14 = 0
            r10 = r14
            goto L7d
        L4b:
            if (r14 == 0) goto L4f
            r1 = r12
            goto L50
        L4f:
            r1 = r13
        L50:
            androidx.compose.ui.graphics.colorspace.Rgb r1 = (androidx.compose.ui.graphics.colorspace.Rgb) r1
            float[] r2 = org.slf4j.helpers.MessageFormatter.D50Xyz
            androidx.compose.ui.graphics.colorspace.WhitePoint r1 = r1.whitePoint
            if (r14 == 0) goto L5d
            float[] r14 = r1.toXyz$ui_graphics_release()
            goto L5e
        L5d:
            r14 = r2
        L5e:
            if (r0 == 0) goto L64
            float[] r2 = r1.toXyz$ui_graphics_release()
        L64:
            float[] r0 = new float[r10]
            r1 = r14[r7]
            r3 = r2[r7]
            float r1 = r1 / r3
            r0[r7] = r1
            r1 = r14[r6]
            r3 = r2[r6]
            float r1 = r1 / r3
            r0[r6] = r1
            r1 = 2
            r14 = r14[r1]
            r2 = r2[r1]
            float r14 = r14 / r2
            r0[r1] = r14
            r10 = r0
        L7d:
            r5 = r11
            r6 = r12
            r7 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Connector.<init>(androidx.compose.ui.graphics.colorspace.ColorSpace, androidx.compose.ui.graphics.colorspace.ColorSpace, int):void");
    }

    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release */
    public long mo351transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
        ColorSpace colorSpace = this.transformSource;
        long xy$ui_graphics_release = colorSpace.toXy$ui_graphics_release(f, f2, f3);
        float intBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics_release >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics_release & 4294967295L));
        float z$ui_graphics_release = colorSpace.toZ$ui_graphics_release(f, f2, f3);
        float[] fArr = this.transform;
        if (fArr != null) {
            intBitsToFloat *= fArr[0];
            intBitsToFloat2 *= fArr[1];
            z$ui_graphics_release *= fArr[2];
        }
        float f5 = intBitsToFloat2;
        float f6 = intBitsToFloat;
        return this.transformDestination.mo350xyzaToColorJlNiLsg$ui_graphics_release(f6, f5, z$ui_graphics_release, f4, this.destination);
    }

    public Connector(ColorSpace source, ColorSpace destination, ColorSpace colorSpace, ColorSpace transformDestination, float[] fArr) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transformDestination, "transformDestination");
        this.destination = destination;
        this.transformSource = colorSpace;
        this.transformDestination = transformDestination;
        this.transform = fArr;
    }
}
