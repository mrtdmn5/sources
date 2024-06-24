package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VelocityTracker.kt */
/* loaded from: classes.dex */
public final class VelocityTrackerKt {
    public static final void addPointerInputChange(VelocityTracker velocityTracker, PointerInputChange event) {
        Intrinsics.checkNotNullParameter(velocityTracker, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        boolean changedToDownIgnoreConsumed = PointerEventKt.changedToDownIgnoreConsumed(event);
        int r3 = 0;
        VelocityTracker1D velocityTracker1D = velocityTracker.yVelocityTracker;
        VelocityTracker1D velocityTracker1D2 = velocityTracker.xVelocityTracker;
        long j = event.position;
        if (changedToDownIgnoreConsumed) {
            velocityTracker.currentPointerPositionAccumulator = j;
            ArraysKt___ArraysJvmKt.fill$default(velocityTracker1D2.samples, null);
            velocityTracker1D2.index = 0;
            ArraysKt___ArraysJvmKt.fill$default(velocityTracker1D.samples, null);
            velocityTracker1D.index = 0;
        }
        List list = event._historical;
        if (list == null) {
            list = EmptyList.INSTANCE;
        }
        int size = list.size();
        long j2 = event.previousPosition;
        while (r3 < size) {
            HistoricalChange historicalChange = (HistoricalChange) list.get(r3);
            long m262plusMKHz9U = Offset.m262plusMKHz9U(velocityTracker.currentPointerPositionAccumulator, Offset.m261minusMKHz9U(historicalChange.position, j2));
            velocityTracker.currentPointerPositionAccumulator = m262plusMKHz9U;
            float m259getXimpl = Offset.m259getXimpl(m262plusMKHz9U);
            int r13 = (velocityTracker1D2.index + 1) % 20;
            velocityTracker1D2.index = r13;
            DataPointAtTime[] dataPointAtTimeArr = velocityTracker1D2.samples;
            DataPointAtTime dataPointAtTime = dataPointAtTimeArr[r13];
            List list2 = list;
            long j3 = historicalChange.uptimeMillis;
            if (dataPointAtTime == null) {
                dataPointAtTimeArr[r13] = new DataPointAtTime(m259getXimpl, j3);
            } else {
                dataPointAtTime.time = j3;
                dataPointAtTime.dataPoint = m259getXimpl;
            }
            float m260getYimpl = Offset.m260getYimpl(m262plusMKHz9U);
            int r10 = (velocityTracker1D.index + 1) % 20;
            velocityTracker1D.index = r10;
            DataPointAtTime[] dataPointAtTimeArr2 = velocityTracker1D.samples;
            DataPointAtTime dataPointAtTime2 = dataPointAtTimeArr2[r10];
            if (dataPointAtTime2 == null) {
                dataPointAtTimeArr2[r10] = new DataPointAtTime(m260getYimpl, j3);
            } else {
                dataPointAtTime2.time = j3;
                dataPointAtTime2.dataPoint = m260getYimpl;
            }
            r3++;
            j2 = historicalChange.position;
            list = list2;
        }
        long m262plusMKHz9U2 = Offset.m262plusMKHz9U(velocityTracker.currentPointerPositionAccumulator, Offset.m261minusMKHz9U(j, j2));
        velocityTracker.currentPointerPositionAccumulator = m262plusMKHz9U2;
        float m259getXimpl2 = Offset.m259getXimpl(m262plusMKHz9U2);
        int r32 = (velocityTracker1D2.index + 1) % 20;
        velocityTracker1D2.index = r32;
        DataPointAtTime[] dataPointAtTimeArr3 = velocityTracker1D2.samples;
        DataPointAtTime dataPointAtTime3 = dataPointAtTimeArr3[r32];
        long j4 = event.uptimeMillis;
        if (dataPointAtTime3 == null) {
            dataPointAtTimeArr3[r32] = new DataPointAtTime(m259getXimpl2, j4);
        } else {
            dataPointAtTime3.time = j4;
            dataPointAtTime3.dataPoint = m259getXimpl2;
        }
        float m260getYimpl2 = Offset.m260getYimpl(m262plusMKHz9U2);
        int r1 = (velocityTracker1D.index + 1) % 20;
        velocityTracker1D.index = r1;
        DataPointAtTime[] dataPointAtTimeArr4 = velocityTracker1D.samples;
        DataPointAtTime dataPointAtTime4 = dataPointAtTimeArr4[r1];
        if (dataPointAtTime4 == null) {
            dataPointAtTimeArr4[r1] = new DataPointAtTime(m260getYimpl2, j4);
        } else {
            dataPointAtTime4.time = j4;
            dataPointAtTime4.dataPoint = m260getYimpl2;
        }
    }

    public static final float dot(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f = 0.0f;
        for (int r2 = 0; r2 < length; r2++) {
            f += fArr[r2] * fArr2[r2];
        }
        return f;
    }

    public static final void polyFitLeastSquares(float[] x, float[] y, int r20, float[] coefficients) {
        float dot;
        Intrinsics.checkNotNullParameter(x, "x");
        Intrinsics.checkNotNullParameter(y, "y");
        Intrinsics.checkNotNullParameter(coefficients, "coefficients");
        if (r20 != 0) {
            int r4 = (2 >= r20 ? r20 - 1 : 2) + 1;
            float[][] fArr = new float[r4];
            for (int r8 = 0; r8 < r4; r8++) {
                fArr[r8] = new float[r20];
            }
            for (int r82 = 0; r82 < r20; r82++) {
                fArr[0][r82] = 1.0f;
                for (int r9 = 1; r9 < r4; r9++) {
                    fArr[r9][r82] = fArr[r9 - 1][r82] * x[r82];
                }
            }
            float[][] fArr2 = new float[r4];
            for (int r83 = 0; r83 < r4; r83++) {
                fArr2[r83] = new float[r20];
            }
            float[][] fArr3 = new float[r4];
            for (int r10 = 0; r10 < r4; r10++) {
                fArr3[r10] = new float[r4];
            }
            for (int r102 = 0; r102 < r4; r102++) {
                float[] fArr4 = fArr2[r102];
                float[] fArr5 = fArr[r102];
                for (int r13 = 0; r13 < r20; r13++) {
                    fArr4[r13] = fArr5[r13];
                }
                for (int r12 = 0; r12 < r102; r12++) {
                    float[] fArr6 = fArr2[r12];
                    float dot2 = dot(fArr4, fArr6);
                    for (int r15 = 0; r15 < r20; r15++) {
                        fArr4[r15] = fArr4[r15] - (fArr6[r15] * dot2);
                    }
                }
                float sqrt = (float) Math.sqrt(dot(fArr4, fArr4));
                if (sqrt >= 1.0E-6f) {
                    float f = 1.0f / sqrt;
                    for (int r132 = 0; r132 < r20; r132++) {
                        fArr4[r132] = fArr4[r132] * f;
                    }
                    float[] fArr7 = fArr3[r102];
                    for (int r133 = 0; r133 < r4; r133++) {
                        if (r133 < r102) {
                            dot = 0.0f;
                        } else {
                            dot = dot(fArr4, fArr[r133]);
                        }
                        fArr7[r133] = dot;
                    }
                } else {
                    throw new IllegalArgumentException("Vectors are linearly dependent or zero so no solution. TODO(shepshapard), actually determine what this means");
                }
            }
            int r42 = r4 - 1;
            for (int r2 = r42; -1 < r2; r2--) {
                coefficients[r2] = dot(fArr2[r2], y);
                int r5 = r2 + 1;
                if (r5 <= r42) {
                    int r6 = r42;
                    while (true) {
                        coefficients[r2] = coefficients[r2] - (fArr3[r2][r6] * coefficients[r6]);
                        if (r6 != r5) {
                            r6--;
                        }
                    }
                }
                coefficients[r2] = coefficients[r2] / fArr3[r2][r2];
            }
            return;
        }
        throw new IllegalArgumentException("At least one point must be provided");
    }
}
