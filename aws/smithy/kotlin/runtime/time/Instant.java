package aws.smithy.kotlin.runtime.time;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.SignStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groupValues$1;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.time.Duration;

/* compiled from: InstantJVM.kt */
/* loaded from: classes.dex */
public final class Instant implements Comparable<Instant> {
    public static final DateTimeFormatter ISO_8601_CONDENSED;
    public static final DateTimeFormatter ISO_8601_CONDENSED_DATE;
    public static final Instant MIN_VALUE;
    public static final DateTimeFormatter RFC_5322_FIXED_DATE_TIME;
    public final j$.time.Instant value;

    /* compiled from: InstantJVM.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static Instant fromEpochSeconds(int r3, long j) {
            j$.time.Instant ofEpochSecond = j$.time.Instant.ofEpochSecond(j, r3);
            Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(seconds, ns.toLong())");
            return new Instant(ofEpochSecond);
        }

        public static Instant now() {
            j$.time.Instant now = j$.time.Instant.now();
            Intrinsics.checkNotNullExpressionValue(now, "now()");
            return new Instant(now);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v15, types: [kotlin.ranges.IntProgressionIterator] */
        /* JADX WARN: Type inference failed for: r1v4, types: [aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$char$1] */
        /* JADX WARN: Type inference failed for: r4v1, types: [aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$fraction$1] */
        public static Instant fromEpochSeconds(String ts) {
            Pair pair;
            Pair pair2;
            Pair pair3;
            CharSequence charSequence;
            Intrinsics.checkNotNullParameter(ts, "ts");
            Regex regex = ParsersKt.exponentialNotationNumber;
            regex.getClass();
            Matcher matcher = regex.nativePattern.matcher(ts);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            MatcherMatchResult matcherMatchResult = !matcher.matches() ? null : new MatcherMatchResult(matcher, ts);
            if (matcherMatchResult != null) {
                String str = (String) ((MatcherMatchResult$groupValues$1) matcherMatchResult.getGroupValues()).get(1);
                String str2 = (String) ((MatcherMatchResult$groupValues$1) matcherMatchResult.getGroupValues()).get(2);
                String str3 = (String) ((MatcherMatchResult$groupValues$1) matcherMatchResult.getGroupValues()).get(5);
                StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
                if (StringsKt__StringsKt.contains$default(str2, '.')) {
                    int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, '.', 0, false, 6);
                    String substring = str2.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String substring2 = str2.substring(indexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    pair = new Pair(substring.concat(substring2), Integer.valueOf(indexOf$default));
                } else {
                    pair = new Pair(str2, Integer.valueOf(str2.length()));
                }
                String str4 = (String) pair.first;
                int intValue = ((Number) pair.second).intValue();
                Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3);
                if (intOrNull != null) {
                    int intValue2 = intOrNull.intValue() + intValue;
                    if (intValue2 <= 0) {
                        pair3 = new Pair(String.valueOf('0'), StringsKt__StringsKt.padStart(str4, str4.length() - intValue2, '0'));
                    } else {
                        if (intValue2 < str4.length()) {
                            String substring3 = str4.substring(0, intValue2);
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            String substring4 = str4.substring(intValue2);
                            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
                            pair2 = new Pair(substring3, substring4);
                        } else if (intValue2 >= 0) {
                            if (intValue2 <= str4.length()) {
                                charSequence = str4.subSequence(0, str4.length());
                            } else {
                                StringBuilder sb = new StringBuilder(intValue2);
                                sb.append((CharSequence) str4);
                                ?? it = new IntRange(1, intValue2 - str4.length()).iterator();
                                while (it.hasNext) {
                                    it.nextInt();
                                    sb.append('0');
                                }
                                charSequence = sb;
                            }
                            pair2 = new Pair(charSequence.toString(), String.valueOf('0'));
                        } else {
                            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Desired length ", intValue2, " is less than zero."));
                        }
                        pair3 = pair2;
                    }
                    String str5 = (String) pair3.first;
                    String str6 = (String) pair3.second;
                    m.append(str5);
                    m.append('.');
                    m.append(str6);
                    ts = m.toString();
                    Intrinsics.checkNotNullExpressionValue(ts, "StringBuilder().apply(builderAction).toString()");
                } else {
                    throw new ParseException(ts, "Failed to read exponent", 0);
                }
            }
            final ParserCombinatorsKt$takeMNDigitsLong$1 transform = new Function2<String, IntRange, Long>() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$takeMNDigitsLong$1
                @Override // kotlin.jvm.functions.Function2
                public final Long invoke(String str7, IntRange intRange) {
                    String str8 = str7;
                    IntRange range = intRange;
                    Intrinsics.checkNotNullParameter(str8, "str");
                    Intrinsics.checkNotNullParameter(range, "range");
                    return Long.valueOf(Long.parseLong(StringsKt__StringsKt.substring(str8, range)));
                }
            };
            Intrinsics.checkNotNullParameter(transform, "transform");
            ParseResult<Object> invoke = new Function2<String, Integer, ParseResult<Object>>() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$takeMNDigitsT$1
                public final /* synthetic */ int $m = 1;
                public final /* synthetic */ int $n = 19;

                /* compiled from: ParserCombinators.kt */
                /* renamed from: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$takeMNDigitsT$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Character, Boolean> {
                    public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                    public AnonymousClass1() {
                        super(1, ParserCombinatorsKt.class, "isDigit", "isDigit(C)Z", 1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Character ch) {
                        boolean z;
                        char charValue = ch.charValue();
                        if ('0' <= charValue && charValue < ':') {
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public final ParseResult<Object> invoke(String str7, Integer num) {
                    String str8 = str7;
                    int intValue3 = num.intValue();
                    int r0 = this.$n;
                    int r1 = this.$m;
                    Intrinsics.checkNotNullParameter(str8, "str");
                    ParserCombinatorsKt.precond(intValue3, 0, str8);
                    try {
                        AnonymousClass1 predicate = AnonymousClass1.INSTANCE;
                        Intrinsics.checkNotNullParameter(predicate, "predicate");
                        ParseResult<? extends IntRange> invoke2 = new ParserCombinatorsKt$takeWhileMN$1(r0, r1, predicate).invoke(str8, Integer.valueOf(intValue3));
                        int r3 = invoke2.pos;
                        IntRange intRange = (IntRange) invoke2.result;
                        if (!intRange.isEmpty()) {
                            return new ParseResult<>(r3, (Number) transform.invoke(str8, intRange));
                        }
                        throw new ParseException(str8, "expected integer", intValue3);
                    } catch (IncompleteException e) {
                        throw new ParseException(str8, ParserCombinatorsKt.access$fmtTakeWhileErrorMsg(r1, String.valueOf(e.needed), r0, r1), intValue3);
                    } catch (TakeWhileMNException e2) {
                        throw new ParseException(str8, ParserCombinatorsKt.access$fmtTakeWhileErrorMsg(r1, "found " + e2.matched, r0, e2.expected), intValue3);
                    }
                }
            }.invoke(ts, 0);
            long longValue = ((Number) invoke.result).longValue();
            int length = ts.length();
            int r0 = invoke.pos;
            if (r0 == length) {
                DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
                return fromEpochSeconds(0, longValue);
            }
            final ?? r1 = new Function2<String, Integer, ParseResult<? extends Character>>() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$char$1
                public final /* synthetic */ char $chr = '.';

                @Override // kotlin.jvm.functions.Function2
                public final ParseResult<? extends Character> invoke(String str7, Integer num) {
                    String str8 = str7;
                    int intValue3 = num.intValue();
                    Intrinsics.checkNotNullParameter(str8, "str");
                    ParserCombinatorsKt.precond(intValue3, 1, str8);
                    char charAt = str8.charAt(intValue3);
                    char c = this.$chr;
                    if (charAt == c) {
                        return new ParseResult<>(intValue3 + 1, Character.valueOf(charAt));
                    }
                    throw new ParseException(str8, "expected `" + c + "` found `" + charAt + '`', intValue3);
                }
            };
            final ?? r4 = new Function2<String, Integer, ParseResult<? extends Integer>>() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$fraction$1
                public final /* synthetic */ int $denomDigits = 9;
                public final /* synthetic */ int $n = 9;
                public final /* synthetic */ int $m = 1;

                /* compiled from: ParserCombinators.kt */
                /* renamed from: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$fraction$1$2, reason: invalid class name */
                /* loaded from: classes.dex */
                public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Character, Boolean> {
                    public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

                    public AnonymousClass2() {
                        super(1, ParserCombinatorsKt.class, "isDigit", "isDigit(C)Z", 1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Character ch) {
                        boolean z;
                        char charValue = ch.charValue();
                        if ('0' <= charValue && charValue < ':') {
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public final ParseResult<? extends Integer> invoke(String str7, Integer num) {
                    boolean z;
                    String str8 = str7;
                    int intValue3 = num.intValue();
                    Intrinsics.checkNotNullParameter(str8, "str");
                    int r2 = this.$denomDigits;
                    int r3 = this.$n;
                    if (r2 <= r3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ParserCombinatorsKt.precond(intValue3, 0, str8);
                        AnonymousClass2 predicate = AnonymousClass2.INSTANCE;
                        Intrinsics.checkNotNullParameter(predicate, "predicate");
                        ParseResult<? extends IntRange> invoke2 = new ParserCombinatorsKt$takeWhileMN$1(r3, this.$m, predicate).invoke(str8, Integer.valueOf(intValue3));
                        IntRange intRange = (IntRange) invoke2.result;
                        if (!intRange.isEmpty()) {
                            int parseInt = Integer.parseInt(StringsKt__StringsKt.substring(str8, intRange));
                            for (int r8 = intRange.last - intRange.first; r8 < r2 - 1; r8++) {
                                parseInt *= 10;
                            }
                            return new ParseResult<>(invoke2.pos, Integer.valueOf(parseInt));
                        }
                        throw new ParseException(str8, "expected integer", intValue3);
                    }
                    throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("denomDigits (", r2, ") must be less than max=", r3, " digits to parse").toString());
                }
            };
            int intValue3 = ((Number) new Function2<String, Integer, ParseResult<Object>>() { // from class: aws.smithy.kotlin.runtime.time.ParserCombinatorsKt$preceded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final ParseResult<Object> invoke(String str7, Integer num) {
                    String str8 = str7;
                    int intValue4 = num.intValue();
                    Intrinsics.checkNotNullParameter(str8, "str");
                    return r4.invoke(str8, Integer.valueOf(r1.invoke(str8, Integer.valueOf(intValue4)).pos));
                }
            }.invoke(ts, Integer.valueOf(r0)).result).intValue();
            DateTimeFormatter dateTimeFormatter2 = Instant.RFC_5322_FIXED_DATE_TIME;
            return fromEpochSeconds(intValue3, longValue);
        }
    }

    /* compiled from: InstantJVM.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[TimestampFormat.values().length];
            try {
                r0[TimestampFormat.ISO_8601.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[TimestampFormat.ISO_8601_CONDENSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[TimestampFormat.ISO_8601_CONDENSED_DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[TimestampFormat.RFC_5322.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[TimestampFormat.EPOCH_SECONDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        new Companion();
        Map<Long, String> mapOf = MapsKt__MapsKt.mapOf(new Pair(1L, "Mon"), new Pair(2L, "Tue"), new Pair(3L, "Wed"), new Pair(4L, "Thu"), new Pair(5L, "Fri"), new Pair(6L, "Sat"), new Pair(7L, "Sun"));
        DateTimeFormatter withChronology = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient().optionalStart().appendText(ChronoField.DAY_OF_WEEK, mapOf).appendLiteral(", ").optionalEnd().appendValue(ChronoField.DAY_OF_MONTH, 2, 2, SignStyle.NOT_NEGATIVE).appendLiteral(' ').appendText(ChronoField.MONTH_OF_YEAR, MapsKt__MapsKt.mapOf(new Pair(1L, "Jan"), new Pair(2L, "Feb"), new Pair(3L, "Mar"), new Pair(4L, "Apr"), new Pair(5L, "May"), new Pair(6L, "Jun"), new Pair(7L, "Jul"), new Pair(8L, "Aug"), new Pair(9L, "Sep"), new Pair(10L, "Oct"), new Pair(11L, "Nov"), new Pair(12L, "Dec"))).appendLiteral(' ').appendValue(ChronoField.YEAR, 4).appendLiteral(' ').appendValue(ChronoField.HOUR_OF_DAY, 2).appendLiteral(':').appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(':').appendValue(ChronoField.SECOND_OF_MINUTE, 2).optionalEnd().appendLiteral(' ').appendOffset("+HHMM", "GMT").toFormatter().withChronology(IsoChronology.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(withChronology, "formatter.withChronology(IsoChronology.INSTANCE)");
        RFC_5322_FIXED_DATE_TIME = withChronology;
        ZoneId of = ZoneId.of("Z");
        DateTimeFormatter withZone = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(of);
        Intrinsics.checkNotNullExpressionValue(withZone, "ofPattern(\"yyyyMMdd'T'HH…       .withZone(utcZone)");
        ISO_8601_CONDENSED = withZone;
        DateTimeFormatter withZone2 = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(of);
        Intrinsics.checkNotNullExpressionValue(withZone2, "ofPattern(\"yyyyMMdd\")\n  …       .withZone(utcZone)");
        ISO_8601_CONDENSED_DATE = withZone2;
        j$.time.Instant MIN = j$.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        MIN_VALUE = new Instant(MIN);
        j$.time.Instant MAX = j$.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
    }

    public Instant(j$.time.Instant instant) {
        this.value = instant;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant other = instant;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value.compareTo(other.value);
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

    /* renamed from: plus-LRDsOJo */
    public final Instant m621plusLRDsOJo(long j) {
        long m1679getInWholeSecondsimpl = Duration.m1679getInWholeSecondsimpl(j);
        int m1681getNanosecondsComponentimpl = Duration.m1681getNanosecondsComponentimpl(j);
        return Companion.fromEpochSeconds(this.value.getNano() + m1681getNanosecondsComponentimpl, getEpochSeconds() + m1679getInWholeSecondsimpl);
    }

    public final String toString() {
        CharSequence charSequence;
        TimestampFormat fmt = TimestampFormat.ISO_8601;
        Intrinsics.checkNotNullParameter(fmt, "fmt");
        int r0 = WhenMappings.$EnumSwitchMapping$0[fmt.ordinal()];
        j$.time.Instant instant = this.value;
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        if (r0 == 5) {
                            StringBuffer stringBuffer = new StringBuffer(String.valueOf(getEpochSeconds()));
                            if (instant.getNano() > 0) {
                                stringBuffer.append(InstructionFileId.DOT);
                                String valueOf = String.valueOf(instant.getNano());
                                stringBuffer.append(StringsKt__StringsJVMKt.repeat(9 - valueOf.length(), "0"));
                                stringBuffer.append(valueOf);
                                char[] cArr = {'0'};
                                int length = stringBuffer.length() - 1;
                                if (length >= 0) {
                                    while (true) {
                                        int r5 = length - 1;
                                        if (!ArraysKt___ArraysKt.contains(cArr, stringBuffer.charAt(length))) {
                                            charSequence = stringBuffer.subSequence(0, length + 1);
                                            break;
                                        }
                                        if (r5 < 0) {
                                            break;
                                        }
                                        length = r5;
                                    }
                                    return charSequence.toString();
                                }
                                charSequence = "";
                                return charSequence.toString();
                            }
                            String stringBuffer2 = stringBuffer.toString();
                            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "{\n                sb.toString()\n            }");
                            return stringBuffer2;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    String format = RFC_5322_FIXED_DATE_TIME.format(ZonedDateTime.ofInstant(instant, ZoneOffset.UTC));
                    Intrinsics.checkNotNullExpressionValue(format, "RFC_5322_FIXED_DATE_TIME…t(value, ZoneOffset.UTC))");
                    return format;
                }
                String format2 = ISO_8601_CONDENSED_DATE.format(instant);
                Intrinsics.checkNotNullExpressionValue(format2, "ISO_8601_CONDENSED_DATE.format(value)");
                return format2;
            }
            String format3 = ISO_8601_CONDENSED.format(instant);
            Intrinsics.checkNotNullExpressionValue(format3, "ISO_8601_CONDENSED.format(value)");
            return format3;
        }
        String format4 = DateTimeFormatter.ISO_INSTANT.format(instant.truncatedTo(ChronoUnit.MICROS));
        Intrinsics.checkNotNullExpressionValue(format4, "ISO_INSTANT.format(value…tedTo(ChronoUnit.MICROS))");
        return format4;
    }
}
