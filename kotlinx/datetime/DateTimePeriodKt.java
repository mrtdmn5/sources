package kotlinx.datetime;

import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;

/* compiled from: DateTimePeriod.kt */
/* loaded from: classes4.dex */
public final class DateTimePeriodKt {
    public static final DateTimePeriod DateTimePeriod(int r16, int r17, int r18, int r19, int r20, int r21, long j) {
        int r5 = totalMonths(r16, r17);
        long j2 = 60;
        long j3 = ((r19 * j2) + r20) * j2;
        long j4 = 1000000000;
        long j5 = (j / j4) + j3 + r21;
        try {
            long j6 = j % j4;
            if (j5 > 0 && j6 < 0) {
                j5--;
                j6 += 1000000000;
            } else if (j5 < 0 && j6 > 0) {
                j5++;
                j6 -= 1000000000;
            }
            return buildDateTimePeriod(Math.addExact(Math.multiplyExact(j5, 1000000000L), j6), r5, r18);
        } catch (ArithmeticException unused) {
            StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("The total number of nanoseconds in ", r19, " hours, ", r20, " minutes, ");
            m.append(r21);
            m.append(" seconds, and ");
            m.append(j);
            m.append(" nanoseconds overflows a Long");
            throw new IllegalArgumentException(m.toString());
        }
    }

    public static /* synthetic */ DateTimePeriod DateTimePeriod$default(int r10, int r11, int r12, int r13) {
        int r2;
        int r4;
        int r6;
        if ((r13 & 1) != 0) {
            r2 = 0;
        } else {
            r2 = r10;
        }
        if ((r13 & 4) != 0) {
            r4 = 0;
        } else {
            r4 = r11;
        }
        if ((r13 & 16) != 0) {
            r6 = 0;
        } else {
            r6 = r12;
        }
        return DateTimePeriod(r2, 0, r4, 0, r6, 0, 0L);
    }

    public static final DateTimePeriod buildDateTimePeriod(long j, int r4, int r5) {
        if (j != 0) {
            return new DateTimePeriodImpl(j, r4, r5);
        }
        return new DatePeriod(r4, r5);
    }

    public static final int totalMonths(int r6, int r7) {
        long j = (r6 * 12) + r7;
        boolean z = false;
        if (-2147483648L <= j && j <= 2147483647L) {
            z = true;
        }
        if (z) {
            return (int) j;
        }
        throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("The total number of months in ", r6, " years and ", r7, " months overflows an Int"));
    }
}
