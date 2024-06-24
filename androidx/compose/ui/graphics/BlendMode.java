package androidx.compose.ui.graphics;

/* compiled from: BlendMode.kt */
/* loaded from: classes.dex */
public final class BlendMode {
    public final int value;

    public final boolean equals(Object obj) {
        if (!(obj instanceof BlendMode)) {
            return false;
        }
        if (this.value != ((BlendMode) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        int r0 = this.value;
        boolean z29 = false;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return "Clear";
        }
        if (r0 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return "Src";
        }
        if (r0 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return "Dst";
        }
        if (r0 == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return "SrcOver";
        }
        if (r0 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return "DstOver";
        }
        if (r0 == 5) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return "SrcIn";
        }
        if (r0 == 6) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return "DstIn";
        }
        if (r0 == 7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            return "SrcOut";
        }
        if (r0 == 8) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            return "DstOut";
        }
        if (r0 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "SrcAtop";
        }
        if (r0 == 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return "DstAtop";
        }
        if (r0 == 11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return "Xor";
        }
        if (r0 == 12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            return "Plus";
        }
        if (r0 == 13) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            return "Modulate";
        }
        if (r0 == 14) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            return "Screen";
        }
        if (r0 == 15) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "Overlay";
        }
        if (r0 == 16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return "Darken";
        }
        if (r0 == 17) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return "Lighten";
        }
        if (r0 == 18) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return "ColorDodge";
        }
        if (r0 == 19) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z20) {
            return "ColorBurn";
        }
        if (r0 == 20) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z21) {
            return "HardLight";
        }
        if (r0 == 21) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z22) {
            return "Softlight";
        }
        if (r0 == 22) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z23) {
            return "Difference";
        }
        if (r0 == 23) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (z24) {
            return "Exclusion";
        }
        if (r0 == 24) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z25) {
            return "Multiply";
        }
        if (r0 == 25) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            return "Hue";
        }
        if (r0 == 26) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            return "Saturation";
        }
        if (r0 == 27) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            return "Color";
        }
        if (r0 == 28) {
            z29 = true;
        }
        if (z29) {
            return "Luminosity";
        }
        return "Unknown";
    }
}
