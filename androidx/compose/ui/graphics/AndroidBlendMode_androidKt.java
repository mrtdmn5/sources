package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;

/* compiled from: AndroidBlendMode.android.kt */
/* loaded from: classes.dex */
public final class AndroidBlendMode_androidKt {
    /* renamed from: toAndroidBlendMode-s9anfk8 */
    public static final android.graphics.BlendMode m280toAndroidBlendModes9anfk8(int r3) {
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
        android.graphics.BlendMode blendMode;
        android.graphics.BlendMode blendMode2;
        android.graphics.BlendMode blendMode3;
        android.graphics.BlendMode blendMode4;
        android.graphics.BlendMode blendMode5;
        android.graphics.BlendMode blendMode6;
        android.graphics.BlendMode blendMode7;
        android.graphics.BlendMode blendMode8;
        android.graphics.BlendMode blendMode9;
        android.graphics.BlendMode blendMode10;
        android.graphics.BlendMode blendMode11;
        android.graphics.BlendMode blendMode12;
        android.graphics.BlendMode blendMode13;
        android.graphics.BlendMode blendMode14;
        android.graphics.BlendMode blendMode15;
        android.graphics.BlendMode blendMode16;
        android.graphics.BlendMode blendMode17;
        android.graphics.BlendMode blendMode18;
        android.graphics.BlendMode blendMode19;
        android.graphics.BlendMode blendMode20;
        android.graphics.BlendMode blendMode21;
        android.graphics.BlendMode blendMode22;
        android.graphics.BlendMode blendMode23;
        android.graphics.BlendMode blendMode24;
        android.graphics.BlendMode blendMode25;
        android.graphics.BlendMode blendMode26;
        android.graphics.BlendMode blendMode27;
        android.graphics.BlendMode blendMode28;
        android.graphics.BlendMode blendMode29;
        android.graphics.BlendMode blendMode30;
        boolean z29 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            blendMode30 = android.graphics.BlendMode.CLEAR;
            return blendMode30;
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            blendMode29 = android.graphics.BlendMode.SRC;
            return blendMode29;
        }
        if (r3 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            blendMode28 = android.graphics.BlendMode.DST;
            return blendMode28;
        }
        if (r3 == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            blendMode27 = android.graphics.BlendMode.SRC_OVER;
            return blendMode27;
        }
        if (r3 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            blendMode26 = android.graphics.BlendMode.DST_OVER;
            return blendMode26;
        }
        if (r3 == 5) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            blendMode25 = android.graphics.BlendMode.SRC_IN;
            return blendMode25;
        }
        if (r3 == 6) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            blendMode24 = android.graphics.BlendMode.DST_IN;
            return blendMode24;
        }
        if (r3 == 7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            blendMode23 = android.graphics.BlendMode.SRC_OUT;
            return blendMode23;
        }
        if (r3 == 8) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            blendMode22 = android.graphics.BlendMode.DST_OUT;
            return blendMode22;
        }
        if (r3 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            blendMode21 = android.graphics.BlendMode.SRC_ATOP;
            return blendMode21;
        }
        if (r3 == 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            blendMode20 = android.graphics.BlendMode.DST_ATOP;
            return blendMode20;
        }
        if (r3 == 11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            blendMode19 = android.graphics.BlendMode.XOR;
            return blendMode19;
        }
        if (r3 == 12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            blendMode18 = android.graphics.BlendMode.PLUS;
            return blendMode18;
        }
        if (r3 == 13) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            blendMode17 = android.graphics.BlendMode.MODULATE;
            return blendMode17;
        }
        if (r3 == 14) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            blendMode16 = android.graphics.BlendMode.SCREEN;
            return blendMode16;
        }
        if (r3 == 15) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            blendMode15 = android.graphics.BlendMode.OVERLAY;
            return blendMode15;
        }
        if (r3 == 16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            blendMode14 = android.graphics.BlendMode.DARKEN;
            return blendMode14;
        }
        if (r3 == 17) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            blendMode13 = android.graphics.BlendMode.LIGHTEN;
            return blendMode13;
        }
        if (r3 == 18) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            blendMode12 = android.graphics.BlendMode.COLOR_DODGE;
            return blendMode12;
        }
        if (r3 == 19) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (z20) {
            blendMode11 = android.graphics.BlendMode.COLOR_BURN;
            return blendMode11;
        }
        if (r3 == 20) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z21) {
            blendMode10 = android.graphics.BlendMode.HARD_LIGHT;
            return blendMode10;
        }
        if (r3 == 21) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (z22) {
            blendMode9 = android.graphics.BlendMode.SOFT_LIGHT;
            return blendMode9;
        }
        if (r3 == 22) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z23) {
            blendMode8 = android.graphics.BlendMode.DIFFERENCE;
            return blendMode8;
        }
        if (r3 == 23) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (z24) {
            blendMode7 = android.graphics.BlendMode.EXCLUSION;
            return blendMode7;
        }
        if (r3 == 24) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z25) {
            blendMode6 = android.graphics.BlendMode.MULTIPLY;
            return blendMode6;
        }
        if (r3 == 25) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            blendMode5 = android.graphics.BlendMode.HUE;
            return blendMode5;
        }
        if (r3 == 26) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            blendMode4 = android.graphics.BlendMode.SATURATION;
            return blendMode4;
        }
        if (r3 == 27) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            blendMode3 = android.graphics.BlendMode.COLOR;
            return blendMode3;
        }
        if (r3 == 28) {
            z29 = true;
        }
        if (z29) {
            blendMode2 = android.graphics.BlendMode.LUMINOSITY;
            return blendMode2;
        }
        blendMode = android.graphics.BlendMode.SRC_OVER;
        return blendMode;
    }

    /* renamed from: toPorterDuffMode-s9anfk8 */
    public static final PorterDuff.Mode m281toPorterDuffModes9anfk8(int r3) {
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
        boolean z18 = false;
        if (r3 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return PorterDuff.Mode.CLEAR;
        }
        if (r3 == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return PorterDuff.Mode.SRC;
        }
        if (r3 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return PorterDuff.Mode.DST;
        }
        if (r3 == 3) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (r3 == 4) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (r3 == 5) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (r3 == 6) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return PorterDuff.Mode.DST_IN;
        }
        if (r3 == 7) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (r3 == 8) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (r3 == 9) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (r3 == 10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (r3 == 11) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            return PorterDuff.Mode.XOR;
        }
        if (r3 == 12) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            return PorterDuff.Mode.ADD;
        }
        if (r3 == 14) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            return PorterDuff.Mode.SCREEN;
        }
        if (r3 == 15) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (r3 == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return PorterDuff.Mode.DARKEN;
        }
        if (r3 == 17) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (r3 == 13) {
            z18 = true;
        }
        if (z18) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
