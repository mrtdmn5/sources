package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.Rgb$eotf$1;
import androidx.compose.ui.graphics.colorspace.Rgb$oetf$1;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import java.util.function.DoubleUnaryOperator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidColorSpace.android.kt */
/* loaded from: classes.dex */
public final class ColorSpaceVerificationHelper {
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda44] */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda45] */
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        Rgb rgb;
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace.Rgb m;
        ColorSpace.Named named2;
        ColorSpace colorSpace3;
        ColorSpace.Named named3;
        ColorSpace colorSpace4;
        ColorSpace.Named named4;
        ColorSpace colorSpace5;
        ColorSpace.Named named5;
        ColorSpace colorSpace6;
        ColorSpace.Named named6;
        ColorSpace colorSpace7;
        ColorSpace.Named named7;
        ColorSpace colorSpace8;
        ColorSpace.Named named8;
        ColorSpace colorSpace9;
        ColorSpace.Named named9;
        ColorSpace colorSpace10;
        ColorSpace.Named named10;
        ColorSpace colorSpace11;
        ColorSpace.Named named11;
        ColorSpace colorSpace12;
        ColorSpace.Named named12;
        ColorSpace colorSpace13;
        ColorSpace.Named named13;
        ColorSpace colorSpace14;
        ColorSpace.Named named14;
        ColorSpace colorSpace15;
        ColorSpace.Named named15;
        ColorSpace colorSpace16;
        ColorSpace.Named named16;
        ColorSpace colorSpace17;
        ColorSpace.Named named17;
        ColorSpace colorSpace18;
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Srgb)) {
            named17 = ColorSpace.Named.SRGB;
            colorSpace18 = ColorSpace.get(named17);
            Intrinsics.checkNotNullExpressionValue(colorSpace18, "get(android.graphics.ColorSpace.Named.SRGB)");
            return colorSpace18;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Aces)) {
            named16 = ColorSpace.Named.ACES;
            colorSpace17 = ColorSpace.get(named16);
            Intrinsics.checkNotNullExpressionValue(colorSpace17, "get(android.graphics.ColorSpace.Named.ACES)");
            return colorSpace17;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Acescg)) {
            named15 = ColorSpace.Named.ACESCG;
            colorSpace16 = ColorSpace.get(named15);
            Intrinsics.checkNotNullExpressionValue(colorSpace16, "get(android.graphics.ColorSpace.Named.ACESCG)");
            return colorSpace16;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.AdobeRgb)) {
            named14 = ColorSpace.Named.ADOBE_RGB;
            colorSpace15 = ColorSpace.get(named14);
            Intrinsics.checkNotNullExpressionValue(colorSpace15, "get(android.graphics.ColorSpace.Named.ADOBE_RGB)");
            return colorSpace15;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt2020)) {
            named13 = ColorSpace.Named.BT2020;
            colorSpace14 = ColorSpace.get(named13);
            Intrinsics.checkNotNullExpressionValue(colorSpace14, "get(android.graphics.ColorSpace.Named.BT2020)");
            return colorSpace14;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Bt709)) {
            named12 = ColorSpace.Named.BT709;
            colorSpace13 = ColorSpace.get(named12);
            Intrinsics.checkNotNullExpressionValue(colorSpace13, "get(android.graphics.ColorSpace.Named.BT709)");
            return colorSpace13;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.CieLab)) {
            named11 = ColorSpace.Named.CIE_LAB;
            colorSpace12 = ColorSpace.get(named11);
            Intrinsics.checkNotNullExpressionValue(colorSpace12, "get(android.graphics.ColorSpace.Named.CIE_LAB)");
            return colorSpace12;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.CieXyz)) {
            named10 = ColorSpace.Named.CIE_XYZ;
            colorSpace11 = ColorSpace.get(named10);
            Intrinsics.checkNotNullExpressionValue(colorSpace11, "get(android.graphics.ColorSpace.Named.CIE_XYZ)");
            return colorSpace11;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.DciP3)) {
            named9 = ColorSpace.Named.DCI_P3;
            colorSpace10 = ColorSpace.get(named9);
            Intrinsics.checkNotNullExpressionValue(colorSpace10, "get(android.graphics.ColorSpace.Named.DCI_P3)");
            return colorSpace10;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.DisplayP3)) {
            named8 = ColorSpace.Named.DISPLAY_P3;
            colorSpace9 = ColorSpace.get(named8);
            Intrinsics.checkNotNullExpressionValue(colorSpace9, "get(android.graphics.ColorSpace.Named.DISPLAY_P3)");
            return colorSpace9;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.ExtendedSrgb)) {
            named7 = ColorSpace.Named.EXTENDED_SRGB;
            colorSpace8 = ColorSpace.get(named7);
            Intrinsics.checkNotNullExpressionValue(colorSpace8, "get(android.graphics.Col…pace.Named.EXTENDED_SRGB)");
            return colorSpace8;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.LinearExtendedSrgb)) {
            named6 = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
            colorSpace7 = ColorSpace.get(named6);
            Intrinsics.checkNotNullExpressionValue(colorSpace7, "get(android.graphics.Col…med.LINEAR_EXTENDED_SRGB)");
            return colorSpace7;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.LinearSrgb)) {
            named5 = ColorSpace.Named.LINEAR_SRGB;
            colorSpace6 = ColorSpace.get(named5);
            Intrinsics.checkNotNullExpressionValue(colorSpace6, "get(android.graphics.ColorSpace.Named.LINEAR_SRGB)");
            return colorSpace6;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.Ntsc1953)) {
            named4 = ColorSpace.Named.NTSC_1953;
            colorSpace5 = ColorSpace.get(named4);
            Intrinsics.checkNotNullExpressionValue(colorSpace5, "get(android.graphics.ColorSpace.Named.NTSC_1953)");
            return colorSpace5;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.ProPhotoRgb)) {
            named3 = ColorSpace.Named.PRO_PHOTO_RGB;
            colorSpace4 = ColorSpace.get(named3);
            Intrinsics.checkNotNullExpressionValue(colorSpace4, "get(android.graphics.Col…pace.Named.PRO_PHOTO_RGB)");
            return colorSpace4;
        }
        if (Intrinsics.areEqual(colorSpace, ColorSpaces.SmpteC)) {
            named2 = ColorSpace.Named.SMPTE_C;
            colorSpace3 = ColorSpace.get(named2);
            Intrinsics.checkNotNullExpressionValue(colorSpace3, "get(android.graphics.ColorSpace.Named.SMPTE_C)");
            return colorSpace3;
        }
        if (!(colorSpace instanceof Rgb)) {
            named = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named);
        } else {
            Rgb rgb2 = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = rgb2.whitePoint.toXyz$ui_graphics_release();
            TransferParameters transferParameters2 = rgb2.transferParameters;
            if (transferParameters2 != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline42.m();
                rgb = rgb2;
                transferParameters = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline39.m(transferParameters2.a, transferParameters2.b, transferParameters2.c, transferParameters2.d, transferParameters2.e, transferParameters2.f, transferParameters2.gamma);
            } else {
                rgb = rgb2;
                transferParameters = null;
            }
            if (transferParameters != null) {
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline43.m();
                m = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline41.m(colorSpace.name, rgb.primaries, xyz$ui_graphics_release, transferParameters);
            } else {
                Rgb rgb3 = rgb;
                ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline43.m();
                String str = colorSpace.name;
                float[] fArr = rgb3.primaries;
                final Rgb$oetf$1 rgb$oetf$1 = rgb3.oetf;
                ?? r6 = new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda44
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        Function1 tmp0 = rgb$oetf$1;
                        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                        return ((Number) tmp0.invoke(Double.valueOf(d))).doubleValue();
                    }
                };
                final Rgb$eotf$1 rgb$eotf$1 = rgb3.eotf;
                m = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline40.m(str, fArr, xyz$ui_graphics_release, r6, new DoubleUnaryOperator() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda45
                    @Override // java.util.function.DoubleUnaryOperator
                    public final double applyAsDouble(double d) {
                        Function1 tmp0 = rgb$eotf$1;
                        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                        return ((Number) tmp0.invoke(Double.valueOf(d))).doubleValue();
                    }
                }, colorSpace.getMinValue(0), colorSpace.getMaxValue(0));
            }
            colorSpace2 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline14.m(m);
        }
        Intrinsics.checkNotNullExpressionValue(colorSpace2, "{\n                if (th…          }\n            }");
        return colorSpace2;
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(final ColorSpace colorSpace) {
        int id;
        ColorSpace.Named named;
        int ordinal;
        ColorSpace.Named named2;
        int ordinal2;
        ColorSpace.Named named3;
        int ordinal3;
        ColorSpace.Named named4;
        int ordinal4;
        ColorSpace.Named named5;
        int ordinal5;
        ColorSpace.Named named6;
        int ordinal6;
        ColorSpace.Named named7;
        int ordinal7;
        ColorSpace.Named named8;
        int ordinal8;
        ColorSpace.Named named9;
        int ordinal9;
        ColorSpace.Named named10;
        int ordinal10;
        ColorSpace.Named named11;
        int ordinal11;
        ColorSpace.Named named12;
        int ordinal12;
        ColorSpace.Named named13;
        int ordinal13;
        ColorSpace.Named named14;
        int ordinal14;
        ColorSpace.Named named15;
        int ordinal15;
        ColorSpace.Named named16;
        int ordinal16;
        ColorSpace.Rgb.TransferParameters transferParameters;
        float[] whitePoint;
        WhitePoint whitePoint2;
        float[] whitePoint3;
        float[] whitePoint4;
        TransferParameters transferParameters2;
        String name;
        float[] primaries;
        float[] transform;
        float minValue;
        float maxValue;
        int id2;
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        float[] whitePoint5;
        float[] whitePoint6;
        float[] whitePoint7;
        Intrinsics.checkNotNullParameter(colorSpace, "<this>");
        id = colorSpace.getId();
        named = ColorSpace.Named.SRGB;
        ordinal = named.ordinal();
        if (id != ordinal) {
            named2 = ColorSpace.Named.ACES;
            ordinal2 = named2.ordinal();
            if (id != ordinal2) {
                named3 = ColorSpace.Named.ACESCG;
                ordinal3 = named3.ordinal();
                if (id != ordinal3) {
                    named4 = ColorSpace.Named.ADOBE_RGB;
                    ordinal4 = named4.ordinal();
                    if (id != ordinal4) {
                        named5 = ColorSpace.Named.BT2020;
                        ordinal5 = named5.ordinal();
                        if (id != ordinal5) {
                            named6 = ColorSpace.Named.BT709;
                            ordinal6 = named6.ordinal();
                            if (id != ordinal6) {
                                named7 = ColorSpace.Named.CIE_LAB;
                                ordinal7 = named7.ordinal();
                                if (id != ordinal7) {
                                    named8 = ColorSpace.Named.CIE_XYZ;
                                    ordinal8 = named8.ordinal();
                                    if (id != ordinal8) {
                                        named9 = ColorSpace.Named.DCI_P3;
                                        ordinal9 = named9.ordinal();
                                        if (id != ordinal9) {
                                            named10 = ColorSpace.Named.DISPLAY_P3;
                                            ordinal10 = named10.ordinal();
                                            if (id != ordinal10) {
                                                named11 = ColorSpace.Named.EXTENDED_SRGB;
                                                ordinal11 = named11.ordinal();
                                                if (id != ordinal11) {
                                                    named12 = ColorSpace.Named.LINEAR_EXTENDED_SRGB;
                                                    ordinal12 = named12.ordinal();
                                                    if (id != ordinal12) {
                                                        named13 = ColorSpace.Named.LINEAR_SRGB;
                                                        ordinal13 = named13.ordinal();
                                                        if (id != ordinal13) {
                                                            named14 = ColorSpace.Named.NTSC_1953;
                                                            ordinal14 = named14.ordinal();
                                                            if (id != ordinal14) {
                                                                named15 = ColorSpace.Named.PRO_PHOTO_RGB;
                                                                ordinal15 = named15.ordinal();
                                                                if (id != ordinal15) {
                                                                    named16 = ColorSpace.Named.SMPTE_C;
                                                                    ordinal16 = named16.ordinal();
                                                                    if (id == ordinal16) {
                                                                        return ColorSpaces.SmpteC;
                                                                    }
                                                                    if (ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline20.m(colorSpace)) {
                                                                        transferParameters = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getTransferParameters();
                                                                        whitePoint = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                        if (whitePoint.length == 3) {
                                                                            whitePoint5 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                            float f = whitePoint5[0];
                                                                            whitePoint6 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                            float f2 = whitePoint6[1];
                                                                            whitePoint7 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                            float f3 = f + f2 + whitePoint7[2];
                                                                            whitePoint2 = new WhitePoint(f / f3, f2 / f3);
                                                                        } else {
                                                                            whitePoint3 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                            float f4 = whitePoint3[0];
                                                                            whitePoint4 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getWhitePoint();
                                                                            whitePoint2 = new WhitePoint(f4, whitePoint4[1]);
                                                                        }
                                                                        WhitePoint whitePoint8 = whitePoint2;
                                                                        if (transferParameters != null) {
                                                                            d = transferParameters.g;
                                                                            d2 = transferParameters.a;
                                                                            d3 = transferParameters.b;
                                                                            d4 = transferParameters.c;
                                                                            d5 = transferParameters.d;
                                                                            d6 = transferParameters.e;
                                                                            d7 = transferParameters.f;
                                                                            transferParameters2 = new TransferParameters(d, d2, d3, d4, d5, d6, d7);
                                                                        } else {
                                                                            transferParameters2 = null;
                                                                        }
                                                                        name = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getName();
                                                                        Intrinsics.checkNotNullExpressionValue(name, "this.name");
                                                                        primaries = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getPrimaries();
                                                                        Intrinsics.checkNotNullExpressionValue(primaries, "this.primaries");
                                                                        transform = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getTransform();
                                                                        DoubleFunction doubleFunction = new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda46
                                                                            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                                                                            public final double invoke(double d8) {
                                                                                DoubleUnaryOperator oetf;
                                                                                ColorSpace this_composeColorSpace = colorSpace;
                                                                                Intrinsics.checkNotNullParameter(this_composeColorSpace, "$this_composeColorSpace");
                                                                                oetf = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(this_composeColorSpace).getOetf();
                                                                                return oetf.applyAsDouble(d8);
                                                                            }
                                                                        };
                                                                        DoubleFunction doubleFunction2 = new DoubleFunction() { // from class: androidx.compose.ui.graphics.ColorSpaceVerificationHelper$$ExternalSyntheticLambda47
                                                                            @Override // androidx.compose.ui.graphics.colorspace.DoubleFunction
                                                                            public final double invoke(double d8) {
                                                                                DoubleUnaryOperator eotf;
                                                                                ColorSpace this_composeColorSpace = colorSpace;
                                                                                Intrinsics.checkNotNullParameter(this_composeColorSpace, "$this_composeColorSpace");
                                                                                eotf = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(this_composeColorSpace).getEotf();
                                                                                return eotf.applyAsDouble(d8);
                                                                            }
                                                                        };
                                                                        minValue = colorSpace.getMinValue(0);
                                                                        maxValue = colorSpace.getMaxValue(0);
                                                                        id2 = ColorSpaceVerificationHelper$$ExternalSyntheticApiModelOutline21.m(colorSpace).getId();
                                                                        return new Rgb(name, primaries, whitePoint8, transform, doubleFunction, doubleFunction2, minValue, maxValue, transferParameters2, id2);
                                                                    }
                                                                    return ColorSpaces.Srgb;
                                                                }
                                                                return ColorSpaces.ProPhotoRgb;
                                                            }
                                                            return ColorSpaces.Ntsc1953;
                                                        }
                                                        return ColorSpaces.LinearSrgb;
                                                    }
                                                    return ColorSpaces.LinearExtendedSrgb;
                                                }
                                                return ColorSpaces.ExtendedSrgb;
                                            }
                                            return ColorSpaces.DisplayP3;
                                        }
                                        return ColorSpaces.DciP3;
                                    }
                                    return ColorSpaces.CieXyz;
                                }
                                return ColorSpaces.CieLab;
                            }
                            return ColorSpaces.Bt709;
                        }
                        return ColorSpaces.Bt2020;
                    }
                    return ColorSpaces.AdobeRgb;
                }
                return ColorSpaces.Acescg;
            }
            return ColorSpaces.Aces;
        }
        return ColorSpaces.Srgb;
    }
}
