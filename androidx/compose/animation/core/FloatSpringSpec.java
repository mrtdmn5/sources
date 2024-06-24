package androidx.compose.animation.core;

/* compiled from: FloatAnimationSpec.kt */
/* loaded from: classes.dex */
public final class FloatSpringSpec implements FloatAnimationSpec {
    public final SpringSimulation spring;
    public final float visibilityThreshold;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FloatSpringSpec() {
        /*
            r2 = this;
            r0 = 0
            r1 = 7
            r2.<init>(r0, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.FloatSpringSpec.<init>():void");
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final long getDurationNanos(float f, float f2, float f3) {
        boolean z;
        double log;
        boolean z2;
        boolean z3;
        int r11;
        long j;
        boolean z4;
        boolean z5;
        double d;
        double d2;
        boolean z6;
        SpringSimulation springSimulation = this.spring;
        double d3 = springSimulation.naturalFreq;
        float f4 = springSimulation.dampingRatio;
        float f5 = this.visibilityThreshold;
        double d4 = (float) (d3 * d3);
        double d5 = f4;
        double d6 = f3 / f5;
        double d7 = (f - f2) / f5;
        double d8 = 1.0f;
        double sqrt = d5 * 2.0d * Math.sqrt(d4);
        double d9 = (sqrt * sqrt) - (d4 * 4.0d);
        double d10 = -sqrt;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d9);
        complexSqrt._real = (complexSqrt._real + d10) * 0.5d;
        complexSqrt._imaginary *= 0.5d;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d9);
        double d11 = -1;
        double d12 = complexSqrt2._real * d11;
        double d13 = complexSqrt2._imaginary * d11;
        complexSqrt2._real = (d12 + d10) * 0.5d;
        complexSqrt2._imaginary = d13 * 0.5d;
        if (d7 == 0.0d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (d6 == 0.0d) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (z6) {
                j = 0;
                return j * 1000000;
            }
        }
        if (d7 < 0.0d) {
            d6 = -d6;
        }
        double abs = Math.abs(d7);
        double d14 = Double.MAX_VALUE;
        if (d5 > 1.0d) {
            double d15 = complexSqrt._real;
            double d16 = complexSqrt2._real;
            double d17 = (d15 * abs) - d6;
            double d18 = d15 - d16;
            double d19 = d17 / d18;
            double d20 = abs - d19;
            double log2 = Math.log(Math.abs(d8 / d20)) / d15;
            double log3 = Math.log(Math.abs(d8 / d19)) / d16;
            if (!Double.isInfinite(log2) && !Double.isNaN(log2)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                log2 = log3;
            } else {
                if (!Double.isInfinite(log3) && !Double.isNaN(log3)) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (!(!z5)) {
                    log2 = Math.max(log2, log3);
                }
            }
            double d21 = d20 * d15;
            double d22 = log2;
            double log4 = Math.log(d21 / ((-d19) * d16)) / (d16 - d15);
            if (!Double.isNaN(log4) && log4 > 0.0d) {
                if (log4 > 0.0d) {
                    if ((-((Math.exp(log4 * d16) * d19) + (Math.exp(d15 * log4) * d20))) < d8) {
                        if (d19 > 0.0d && d20 < 0.0d) {
                            log = 0.0d;
                        } else {
                            log = d22;
                        }
                        d = d16;
                        d2 = -d8;
                    }
                }
                d2 = d8;
                d = d16;
                log = Math.log((-((d19 * d) * d)) / (d21 * d15)) / d18;
            } else {
                d = d16;
                d2 = -d8;
                log = d22;
            }
            double d23 = d19 * d;
            if (Math.abs((Math.exp(d * log) * d23) + (Math.exp(d15 * log) * d21)) >= 1.0E-4d) {
                int r9 = 0;
                while (d14 > 0.001d && r9 < 100) {
                    r9++;
                    double d24 = d15 * log;
                    double d25 = d * log;
                    double exp = log - ((((Math.exp(d25) * d19) + (Math.exp(d24) * d20)) + d2) / ((Math.exp(d25) * d23) + (Math.exp(d24) * d21)));
                    double abs2 = Math.abs(log - exp);
                    log = exp;
                    d14 = abs2;
                }
            }
        } else if (d5 < 1.0d) {
            double d26 = complexSqrt._real;
            double d27 = (d6 - (d26 * abs)) / complexSqrt._imaginary;
            log = Math.log(d8 / Math.sqrt((d27 * d27) + (abs * abs))) / d26;
        } else {
            double d28 = complexSqrt._real;
            double d29 = d28 * abs;
            double d30 = d6 - d29;
            log = Math.log(Math.abs(d8 / abs)) / d28;
            double log5 = Math.log(Math.abs(d8 / d30));
            double d31 = log5;
            for (int r14 = 0; r14 < 6; r14++) {
                d31 = log5 - Math.log(Math.abs(d31 / d28));
            }
            double d32 = d31 / d28;
            if (!Double.isInfinite(log) && !Double.isNaN(log)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                log = d32;
            } else {
                if (!Double.isInfinite(d32) && !Double.isNaN(d32)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!(!z3)) {
                    log = Math.max(log, d32);
                }
            }
            double d33 = (-(d29 + d30)) / (d28 * d30);
            double d34 = d28 * d33;
            double d35 = d8;
            double exp2 = (Math.exp(d34) * d30 * d33) + (Math.exp(d34) * abs);
            if (!Double.isNaN(d33) && d33 > 0.0d) {
                if (d33 > 0.0d && (-exp2) < d35) {
                    if (d30 < 0.0d && abs > 0.0d) {
                        log = 0.0d;
                    }
                } else {
                    log = (-(2.0d / d28)) - (abs / d30);
                    r11 = 0;
                    while (d14 > 0.001d && r11 < 100) {
                        r11++;
                        double d36 = d28 * log;
                        double exp3 = log - (((Math.exp(d36) * ((d30 * log) + abs)) + d35) / (Math.exp(d36) * (((1 + d36) * d30) + d29)));
                        d14 = Math.abs(log - exp3);
                        log = exp3;
                    }
                }
            }
            d35 = -d35;
            r11 = 0;
            while (d14 > 0.001d) {
                r11++;
                double d362 = d28 * log;
                double exp32 = log - (((Math.exp(d362) * ((d30 * log) + abs)) + d35) / (Math.exp(d362) * (((1 + d362) * d30) + d29)));
                d14 = Math.abs(log - exp32);
                log = exp32;
            }
        }
        j = (long) (log * 1000.0d);
        return j * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getEndVelocity(float f, float f2, float f3) {
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getValueFromNanos(long j, float f, float f2, float f3) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m11updateValuesIJZedt4$animation_core_release(f, f3, j / 1000000) >> 32));
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public final float getVelocityFromNanos(long j, float f, float f2, float f3) {
        SpringSimulation springSimulation = this.spring;
        springSimulation.finalPosition = f2;
        return Float.intBitsToFloat((int) (springSimulation.m11updateValuesIJZedt4$animation_core_release(f, f3, j / 1000000) & 4294967295L));
    }

    public FloatSpringSpec(float f, float f2, float f3) {
        this.visibilityThreshold = f3;
        SpringSimulation springSimulation = new SpringSimulation();
        if (f >= 0.0f) {
            springSimulation.dampingRatio = f;
            springSimulation.initialized = false;
            double d = springSimulation.naturalFreq;
            if (((float) (d * d)) > 0.0f) {
                springSimulation.naturalFreq = Math.sqrt(f2);
                springSimulation.initialized = false;
                this.spring = springSimulation;
                return;
            }
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public /* synthetic */ FloatSpringSpec(float f, float f2, int r4) {
        this((r4 & 1) != 0 ? 1.0f : f, (r4 & 2) != 0 ? 1500.0f : f2, (r4 & 4) != 0 ? 0.01f : 0.0f);
    }
}
