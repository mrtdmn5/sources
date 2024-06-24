package kotlinx.datetime;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.serializers.DateTimePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: DateTimePeriod.kt */
@Serializable(with = DateTimePeriodIso8601Serializer.class)
/* loaded from: classes4.dex */
public abstract class DateTimePeriod {
    public static final Companion Companion = new Companion();

    /* compiled from: DateTimePeriod.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:138:0x0268 A[LOOP:2: B:130:0x024f->B:138:0x0268, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:139:0x026b A[EDGE_INSN: B:139:0x026b->B:140:0x026b BREAK  A[LOOP:2: B:130:0x024f->B:138:0x0268], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static kotlinx.datetime.DateTimePeriod parse(java.lang.String r22) {
            /*
                Method dump skipped, instructions count: 749
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.DateTimePeriod.Companion.parse(java.lang.String):kotlinx.datetime.DateTimePeriod");
        }

        public static final void parse$parseException(int r3, String str) {
            throw new DateTimeFormatException("Parse error at char " + r3 + ": " + str);
        }

        public static final int parse$toIntThrowing(long j, int r4, char c) {
            if (j >= -2147483648L && j <= 2147483647L) {
                return (int) j;
            }
            parse$parseException(r4, "Value " + j + " does not fit into an Int, which is required for component '" + c + '\'');
            throw null;
        }

        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodIso8601Serializer.INSTANCE;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimePeriod)) {
            return false;
        }
        DateTimePeriod dateTimePeriod = (DateTimePeriod) obj;
        if (getTotalMonths$kotlinx_datetime() == dateTimePeriod.getTotalMonths$kotlinx_datetime() && getDays() == dateTimePeriod.getDays() && getTotalNanoseconds$kotlinx_datetime() == dateTimePeriod.getTotalNanoseconds$kotlinx_datetime()) {
            return true;
        }
        return false;
    }

    public abstract int getDays();

    public int getHours() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() / 3600000000000L);
    }

    public int getMinutes() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % 3600000000000L) / 60000000000L);
    }

    public int getNanoseconds() {
        return (int) (getTotalNanoseconds$kotlinx_datetime() % 1000000000);
    }

    public int getSeconds() {
        return (int) ((getTotalNanoseconds$kotlinx_datetime() % 60000000000L) / 1000000000);
    }

    public abstract int getTotalMonths$kotlinx_datetime();

    public abstract long getTotalNanoseconds$kotlinx_datetime();

    public final int hashCode() {
        return Long.hashCode(getTotalNanoseconds$kotlinx_datetime()) + ((getDays() + (getTotalMonths$kotlinx_datetime() * 31)) * 31);
    }

    public final String toString() {
        boolean z;
        int r1;
        Object obj;
        StringBuilder sb = new StringBuilder();
        if (getTotalMonths$kotlinx_datetime() <= 0 && getDays() <= 0 && getTotalNanoseconds$kotlinx_datetime() <= 0 && ((getTotalMonths$kotlinx_datetime() | getDays()) != 0 || getTotalNanoseconds$kotlinx_datetime() != 0)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            sb.append('-');
            r1 = -1;
        } else {
            r1 = 1;
        }
        sb.append('P');
        if (getTotalMonths$kotlinx_datetime() / 12 != 0) {
            sb.append((getTotalMonths$kotlinx_datetime() / 12) * r1);
            sb.append('Y');
        }
        if (getTotalMonths$kotlinx_datetime() % 12 != 0) {
            sb.append((getTotalMonths$kotlinx_datetime() % 12) * r1);
            sb.append('M');
        }
        if (getDays() != 0) {
            sb.append(getDays() * r1);
            sb.append('D');
        }
        String str = "";
        String str2 = "T";
        if (getHours() != 0) {
            sb.append("T");
            sb.append(getHours() * r1);
            sb.append('H');
            str2 = "";
        }
        if (getMinutes() != 0) {
            sb.append(str2);
            sb.append(getMinutes() * r1);
            sb.append('M');
        } else {
            str = str2;
        }
        if ((getSeconds() | getNanoseconds()) != 0) {
            sb.append(str);
            if (getSeconds() != 0) {
                obj = Integer.valueOf(getSeconds() * r1);
            } else if (getNanoseconds() * r1 < 0) {
                obj = "-0";
            } else {
                obj = "0";
            }
            sb.append(obj);
            if (getNanoseconds() != 0) {
                sb.append('.');
                sb.append(StringsKt__StringsKt.padStart(String.valueOf(Math.abs(getNanoseconds())), 9, '0'));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
