package kotlinx.datetime;

import j$.time.Month;
import j$.time.chrono.ChronoLocalDateTime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: LocalDateTime.kt */
@Serializable(with = LocalDateTimeIso8601Serializer.class)
/* loaded from: classes4.dex */
public final class LocalDateTime implements Comparable<LocalDateTime> {
    public static final Companion Companion = new Companion();
    public final j$.time.LocalDateTime value;

    /* compiled from: LocalDateTime.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeIso8601Serializer.INSTANCE;
        }
    }

    static {
        j$.time.LocalDateTime MIN = j$.time.LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalDateTime(MIN);
        j$.time.LocalDateTime MAX = j$.time.LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalDateTime(MAX);
    }

    public LocalDateTime(j$.time.LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalDateTime localDateTime) {
        LocalDateTime other = localDateTime;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo((ChronoLocalDateTime<?>) other.value);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof LocalDateTime) {
                if (Intrinsics.areEqual(this.value, ((LocalDateTime) obj).value)) {
                }
            }
            return false;
        }
        return true;
    }

    public final LocalDate getDate() {
        j$.time.LocalDate localDate = this.value.toLocalDate();
        Intrinsics.checkNotNullExpressionValue(localDate, "value.toLocalDate()");
        return new LocalDate(localDate);
    }

    public final int getDayOfMonth() {
        return this.value.getDayOfMonth();
    }

    public final int getHour() {
        return this.value.getHour();
    }

    public final int getMinute() {
        return this.value.getMinute();
    }

    public final Month getMonth() {
        Month month = this.value.getMonth();
        Intrinsics.checkNotNullExpressionValue(month, "value.month");
        return month;
    }

    public final int getYear() {
        return this.value.getYear();
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    public final String toString() {
        String localDateTime = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(localDateTime, "value.toString()");
        return localDateTime;
    }

    public /* synthetic */ LocalDateTime(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17) {
        this(r10, r11, r12, r13, r14, (r16 & 32) != 0 ? 0 : r15, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LocalDateTime(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        /*
            r0 = this;
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.of(r1, r2, r3, r4, r5, r6, r7)     // Catch: j$.time.DateTimeException -> Ld
            java.lang.String r2 = "try {\n                jt…xception(e)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.<init>(r1)
            return
        Ld:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.LocalDateTime.<init>(int, int, int, int, int, int, int):void");
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(int r9, Month month, int r11, int r12, int r13, int r14, int r15) {
        this(r9, month.ordinal() + 1, r11, r12, r13, r14, r15);
        Intrinsics.checkNotNullParameter(month, "month");
        List<Month> list = MonthKt.allMonths;
    }
}
