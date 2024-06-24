package androidx.compose.ui.geometry;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundRect.kt */
/* loaded from: classes.dex */
public final class RoundRectKt {
    /* renamed from: RoundRect-gG7oq9Y, reason: not valid java name */
    public static final RoundRect m272RoundRectgG7oq9Y(float f, float f2, float f3, float f4, long j) {
        long CornerRadius = CornerRadiusKt.CornerRadius(CornerRadius.m253getXimpl(j), CornerRadius.m254getYimpl(j));
        return new RoundRect(f, f2, f3, f4, CornerRadius, CornerRadius, CornerRadius, CornerRadius);
    }

    public static final boolean isSimple(RoundRect roundRect) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(roundRect, "<this>");
        long j = roundRect.topLeftCornerRadius;
        if (CornerRadius.m253getXimpl(j) == CornerRadius.m254getYimpl(j)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            float m253getXimpl = CornerRadius.m253getXimpl(j);
            long j2 = roundRect.topRightCornerRadius;
            if (m253getXimpl == CornerRadius.m253getXimpl(j2)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (CornerRadius.m253getXimpl(j) == CornerRadius.m254getYimpl(j2)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    float m253getXimpl2 = CornerRadius.m253getXimpl(j);
                    long j3 = roundRect.bottomRightCornerRadius;
                    if (m253getXimpl2 == CornerRadius.m253getXimpl(j3)) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        if (CornerRadius.m253getXimpl(j) == CornerRadius.m254getYimpl(j3)) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            float m253getXimpl3 = CornerRadius.m253getXimpl(j);
                            long j4 = roundRect.bottomLeftCornerRadius;
                            if (m253getXimpl3 == CornerRadius.m253getXimpl(j4)) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                if (CornerRadius.m253getXimpl(j) == CornerRadius.m254getYimpl(j4)) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                if (z7) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
