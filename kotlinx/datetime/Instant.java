package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Instant.kt */
@Serializable(with = InstantIso8601Serializer.class)
/* loaded from: classes4.dex */
public final class Instant implements Comparable<Instant> {
    public static final Companion Companion = new Companion();
    public static final Instant DISTANT_FUTURE;
    public static final Instant DISTANT_PAST;
    public static final Instant MAX;
    public static final Instant MIN;
    public final j$.time.Instant value;

    /* compiled from: Instant.kt */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static Instant fromEpochMilliseconds(long j) {
            j$.time.Instant ofEpochMilli = j$.time.Instant.ofEpochMilli(j);
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(epochMilliseconds)");
            return new Instant(ofEpochMilli);
        }

        public static Instant fromEpochSeconds$default(Companion companion, long j) {
            companion.getClass();
            try {
                j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond(j, 0L);
                Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(epochSeconds, nanosecondAdjustment)");
                return new Instant(ofEpochSecond);
            } catch (Exception e) {
                if (!(e instanceof ArithmeticException) && !(e instanceof DateTimeException)) {
                    throw e;
                }
                if (j > 0) {
                    return Instant.MAX;
                }
                return Instant.MIN;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static kotlinx.datetime.Instant parse(java.lang.String r9) {
            /*
                java.lang.String r0 = "isoString"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                kotlinx.datetime.Instant r0 = new kotlinx.datetime.Instant     // Catch: j$.time.format.DateTimeParseException -> L65
                r1 = 84
                r2 = 2
                r3 = 1
                r4 = 0
                int r1 = kotlin.text.StringsKt__StringsKt.indexOf$default(r9, r1, r4, r3, r2)     // Catch: j$.time.format.DateTimeParseException -> L65
                r2 = -1
                if (r1 != r2) goto L14
                goto L54
            L14:
                int r5 = r9.length()     // Catch: j$.time.format.DateTimeParseException -> L65
                int r5 = r5 + r2
                if (r5 < 0) goto L35
            L1b:
                int r6 = r5 + (-1)
                char r7 = r9.charAt(r5)     // Catch: j$.time.format.DateTimeParseException -> L65
                r8 = 43
                if (r7 == r8) goto L2c
                r8 = 45
                if (r7 != r8) goto L2a
                goto L2c
            L2a:
                r7 = r4
                goto L2d
            L2c:
                r7 = r3
            L2d:
                if (r7 == 0) goto L30
                goto L36
            L30:
                if (r6 >= 0) goto L33
                goto L35
            L33:
                r5 = r6
                goto L1b
            L35:
                r5 = r2
            L36:
                if (r5 >= r1) goto L39
                goto L54
            L39:
                r1 = 58
                r3 = 4
                int r1 = kotlin.text.StringsKt__StringsKt.indexOf$default(r9, r1, r5, r4, r3)     // Catch: j$.time.format.DateTimeParseException -> L65
                if (r1 == r2) goto L43
                goto L54
            L43:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: j$.time.format.DateTimeParseException -> L65
                r1.<init>()     // Catch: j$.time.format.DateTimeParseException -> L65
                r1.append(r9)     // Catch: j$.time.format.DateTimeParseException -> L65
                java.lang.String r9 = ":00"
                r1.append(r9)     // Catch: j$.time.format.DateTimeParseException -> L65
                java.lang.String r9 = r1.toString()     // Catch: j$.time.format.DateTimeParseException -> L65
            L54:
                j$.time.OffsetDateTime r9 = j$.time.OffsetDateTime.parse(r9)     // Catch: j$.time.format.DateTimeParseException -> L65
                j$.time.Instant r9 = r9.toInstant()     // Catch: j$.time.format.DateTimeParseException -> L65
                java.lang.String r1 = "parse(fixOffsetRepresent…n(isoString)).toInstant()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r1)     // Catch: j$.time.format.DateTimeParseException -> L65
                r0.<init>(r9)     // Catch: j$.time.format.DateTimeParseException -> L65
                return r0
            L65:
                r9 = move-exception
                kotlinx.datetime.DateTimeFormatException r0 = new kotlinx.datetime.DateTimeFormatException
                r0.<init>(r9)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.Instant.Companion.parse(java.lang.String):kotlinx.datetime.Instant");
        }

        public final KSerializer<Instant> serializer() {
            return InstantIso8601Serializer.INSTANCE;
        }
    }

    static {
        j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond(-3217862419201L, 999999999L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(DISTANT_PAST_SECONDS, 999_999_999)");
        DISTANT_PAST = new Instant(ofEpochSecond);
        j$.time.Instant ofEpochSecond2 = j$.time.Instant.ofEpochSecond(3093527980800L, 0L);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond2, "ofEpochSecond(DISTANT_FUTURE_SECONDS, 0)");
        DISTANT_FUTURE = new Instant(ofEpochSecond2);
        j$.time.Instant MIN2 = j$.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN2, "MIN");
        MIN = new Instant(MIN2);
        j$.time.Instant MAX2 = j$.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX2, "MAX");
        MAX = new Instant(MAX2);
    }

    public Instant(j$.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Instant) {
                if (Intrinsics.areEqual(this.value, ((Instant) obj).value)) {
                }
            }
            return false;
        }
        return true;
    }

    public final long getEpochSeconds() {
        return this.value.getEpochSecond();
    }

    public final int hashCode() {
        return this.value.hashCode();
    }

    /* renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m1704minus5sfh64U(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int r0 = Duration.$r8$clinit;
        j$.time.Instant instant = this.value;
        long epochSecond = instant.getEpochSecond();
        j$.time.Instant instant2 = other.value;
        return Duration.m1686plusLRDsOJo(DurationKt.toDuration(epochSecond - instant2.getEpochSecond(), DurationUnit.SECONDS), DurationKt.toDuration(instant.getNano() - instant2.getNano(), DurationUnit.NANOSECONDS));
    }

    /* renamed from: minus-LRDsOJo, reason: not valid java name */
    public final Instant m1705minusLRDsOJo(long j) {
        return m1706plusLRDsOJo(Duration.m1691unaryMinusUwyO8pc(j));
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public final Instant m1706plusLRDsOJo(long j) {
        boolean z;
        Instant instant;
        try {
            j$.time.Instant plusNanos = this.value.plusSeconds(Duration.m1679getInWholeSecondsimpl(j)).plusNanos(Duration.m1681getNanosecondsComponentimpl(j));
            Intrinsics.checkNotNullExpressionValue(plusNanos, "value.plusSeconds(second…nos(nanoseconds.toLong())");
            return new Instant(plusNanos);
        } catch (Exception e) {
            if (!(e instanceof ArithmeticException) && !(e instanceof DateTimeException)) {
                throw e;
            }
            if (j > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                instant = MAX;
            } else {
                instant = MIN;
            }
            return instant;
        }
    }

    public final long toEpochMilliseconds() {
        j$.time.Instant instant = this.value;
        try {
            return instant.toEpochMilli();
        } catch (ArithmeticException unused) {
            if (instant.isAfter(j$.time.Instant.EPOCH)) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    public final String toString() {
        String instant = this.value.toString();
        Intrinsics.checkNotNullExpressionValue(instant, "value.toString()");
        return instant;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
    }
}
