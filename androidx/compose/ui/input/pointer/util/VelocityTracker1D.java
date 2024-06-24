package androidx.compose.ui.input.pointer.util;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public final class VelocityTracker1D {
    public int index;
    public final boolean isDataDifferential;
    public final int minSampleSize;
    public final float[] reusableDataPointsArray;
    public final float[] reusableTimeArray;
    public final float[] reusableVelocityCoefficients;
    public final DataPointAtTime[] samples;
    public final Strategy strategy;

    /* compiled from: VelocityTracker.kt */
    /* loaded from: classes.dex */
    public enum Strategy {
        Lsq2,
        Impulse
    }

    /* compiled from: VelocityTracker.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Strategy.values().length];
            try {
                r0[Strategy.Impulse.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Strategy.Lsq2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public VelocityTracker1D() {
        Strategy strategy = Strategy.Lsq2;
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        this.isDataDifferential = false;
        this.strategy = strategy;
        int r0 = WhenMappings.$EnumSwitchMapping$0[strategy.ordinal()];
        int r1 = 2;
        if (r0 != 1) {
            if (r0 == 2) {
                r1 = 3;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        this.minSampleSize = r1;
        this.samples = new DataPointAtTime[20];
        this.reusableDataPointsArray = new float[20];
        this.reusableTimeArray = new float[20];
        this.reusableVelocityCoefficients = new float[3];
    }

    public final float calculateVelocity() {
        float[] fArr;
        float[] fArr2;
        float signum;
        boolean z;
        float f;
        boolean z2;
        float f2;
        int r1 = this.index;
        DataPointAtTime[] dataPointAtTimeArr = this.samples;
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[r1];
        if (dataPointAtTime == null) {
            return 0.0f;
        }
        DataPointAtTime dataPointAtTime2 = dataPointAtTime;
        int r7 = 0;
        while (true) {
            DataPointAtTime dataPointAtTime3 = dataPointAtTimeArr[r1];
            fArr = this.reusableDataPointsArray;
            fArr2 = this.reusableTimeArray;
            if (dataPointAtTime3 != null) {
                long j = dataPointAtTime.time;
                long j2 = dataPointAtTime3.time;
                float f3 = (float) (j - j2);
                float abs = (float) Math.abs(j2 - dataPointAtTime2.time);
                if (f3 > 100.0f || abs > 40.0f) {
                    break;
                }
                fArr[r7] = dataPointAtTime3.dataPoint;
                fArr2[r7] = -f3;
                if (r1 == 0) {
                    r1 = 20;
                }
                r1--;
                r7++;
                if (r7 >= 20) {
                    break;
                }
                dataPointAtTime2 = dataPointAtTime3;
            } else {
                break;
            }
        }
        if (r7 >= this.minSampleSize) {
            int r12 = WhenMappings.$EnumSwitchMapping$0[this.strategy.ordinal()];
            if (r12 != 1) {
                if (r12 == 2) {
                    try {
                        float[] fArr3 = this.reusableVelocityCoefficients;
                        VelocityTrackerKt.polyFitLeastSquares(fArr2, fArr, r7, fArr3);
                        signum = fArr3[1];
                    } catch (IllegalArgumentException unused) {
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (r7 >= 2) {
                    boolean z3 = this.isDataDifferential;
                    if (r7 == 2) {
                        float f4 = fArr2[0];
                        float f5 = fArr2[1];
                        if (f4 == f5) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            if (z3) {
                                f2 = fArr[0];
                            } else {
                                f2 = fArr[0] - fArr[1];
                            }
                            signum = f2 / (f4 - f5);
                        }
                    } else {
                        int r72 = r7 - 1;
                        int r5 = r72;
                        float f6 = 0.0f;
                        while (r5 > 0) {
                            int r8 = r5 - 1;
                            if (fArr2[r5] == fArr2[r8]) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                float signum2 = Math.signum(f6) * ((float) Math.sqrt(Math.abs(f6) * 2));
                                if (z3) {
                                    f = -fArr[r8];
                                } else {
                                    f = fArr[r5] - fArr[r8];
                                }
                                float f7 = f / (fArr2[r5] - fArr2[r8]);
                                float abs2 = (Math.abs(f7) * (f7 - signum2)) + f6;
                                if (r5 == r72) {
                                    abs2 *= 0.5f;
                                }
                                f6 = abs2;
                            }
                            r5 = r8;
                        }
                        signum = Math.signum(f6) * ((float) Math.sqrt(Math.abs(f6) * 2));
                    }
                }
                signum = 0.0f;
            }
            return signum * 1000;
        }
        return 0.0f;
    }
}
