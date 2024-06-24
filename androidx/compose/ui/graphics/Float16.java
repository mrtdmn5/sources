package androidx.compose.ui.graphics;

import com.animaconnected.secondo.R;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Float16.kt */
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    public static final Companion Companion = new Companion();
    public static final float FP32_DENORMAL_FLOAT;

    /* compiled from: Float16.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    static {
        m329constructorimpl(1.0f);
        m329constructorimpl(-1.0f);
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(1056964608);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m329constructorimpl(float f) {
        int r5;
        int r52;
        Companion.getClass();
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int r0 = floatToRawIntBits >>> 31;
        int r1 = (floatToRawIntBits >>> 23) & 255;
        int r53 = floatToRawIntBits & 8388607;
        int r3 = 31;
        int r4 = 0;
        if (r1 == 255) {
            if (r53 != 0) {
                r52 = DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
                r4 = r52;
            }
            r5 = (r0 << 15) | (r3 << 10) | r4;
        } else {
            int r12 = (r1 - 127) + 15;
            if (r12 >= 31) {
                r3 = 49;
            } else if (r12 <= 0) {
                if (r12 >= -10) {
                    int r54 = (r53 | 8388608) >> (1 - r12);
                    if ((r54 & 4096) != 0) {
                        r54 += DfuBaseService.ERROR_REMOTE_MASK;
                    }
                    r52 = r54 >> 13;
                    r3 = 0;
                    r4 = r52;
                } else {
                    r3 = 0;
                }
            } else {
                r4 = r53 >> 13;
                if ((r53 & 4096) != 0) {
                    r5 = (((r12 << 10) | r4) + 1) | (r0 << 15);
                } else {
                    r3 = r12;
                }
            }
            r5 = (r0 << 15) | (r3 << 10) | r4;
        }
        return (short) r5;
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m330toFloatimpl(short s) {
        int r1;
        int r12;
        int r4;
        int r42 = s & 65535;
        int r0 = 32768 & r42;
        int r13 = (r42 >>> 10) & 31;
        int r43 = r42 & 1023;
        if (r13 == 0) {
            if (r43 != 0) {
                float intBitsToFloat = Float.intBitsToFloat(r43 + 1056964608) - FP32_DENORMAL_FLOAT;
                if (r0 != 0) {
                    return -intBitsToFloat;
                }
                return intBitsToFloat;
            }
            r4 = 0;
            r12 = 0;
        } else {
            int r44 = r43 << 13;
            if (r13 == 31) {
                r1 = 255;
                if (r44 != 0) {
                    r44 |= 4194304;
                }
            } else {
                r1 = (r13 - 15) + R.styleable.AppTheme_statusTextH5;
            }
            int r3 = r1;
            r12 = r44;
            r4 = r3;
        }
        return Float.intBitsToFloat((r4 << 23) | (r0 << 16) | r12);
    }
}
