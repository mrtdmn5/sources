package j$.time.format;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.behaviour.dayofweek.DayOfWeek;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.format.DateTimeTextProvider;
import j$.time.temporal.ChronoField;
import j$.time.temporal.IsoFields;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.ValueRange;
import j$.time.temporal.WeekFields;
import j$.time.zone.ZoneRulesProvider;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormatSymbols;
import java.text.ParsePosition;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class DateTimeFormatterBuilder {
    private static final Map FIELD_MAP;
    static final Comparator LENGTH_SORT;
    private static final TemporalQuery QUERY_REGION_ONLY = new TemporalQuery() { // from class: j$.time.format.DateTimeFormatterBuilder$$ExternalSyntheticLambda0
        @Override // j$.time.temporal.TemporalQuery
        public final Object queryFrom(TemporalAccessor temporalAccessor) {
            return DateTimeFormatterBuilder.lambda$static$0(temporalAccessor);
        }
    };
    private DateTimeFormatterBuilder active;
    private final boolean optional;
    private char padNextChar;
    private int padNextWidth;
    private final DateTimeFormatterBuilder parent;
    private final List printerParsers;
    private int valueParserIndex;

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends DateTimeTextProvider {
        final /* synthetic */ DateTimeTextProvider.LocaleStore val$store;

        AnonymousClass1(DateTimeTextProvider.LocaleStore localeStore) {
            r2 = localeStore;
        }

        @Override // j$.time.format.DateTimeTextProvider
        public String getText(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
            return r2.getText(j, textStyle);
        }

        @Override // j$.time.format.DateTimeTextProvider
        public Iterator getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale) {
            return r2.getTextIterator(textStyle);
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$2 */
    /* loaded from: classes2.dex */
    class AnonymousClass2 implements Comparator {
        AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    }

    /* renamed from: j$.time.format.DateTimeFormatterBuilder$3 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$java$time$format$SignStyle;

        static {
            int[] r0 = new int[SignStyle.values().length];
            $SwitchMap$java$time$format$SignStyle = r0;
            try {
                r0[SignStyle.EXCEEDS_PAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.ALWAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$format$SignStyle[SignStyle.NOT_NEGATIVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char literal;

        CharLiteralPrinterParser(char c) {
            this.literal = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r4) {
            if (r4 == charSequence.length()) {
                return ~r4;
            }
            char charAt = charSequence.charAt(r4);
            return (charAt == this.literal || (!dateTimeParseContext.isCaseSensitive() && (Character.toUpperCase(charAt) == Character.toUpperCase(this.literal) || Character.toLowerCase(charAt) == Character.toLowerCase(this.literal)))) ? r4 + 1 : ~r4;
        }

        public String toString() {
            if (this.literal == '\'') {
                return "''";
            }
            return "'" + this.literal + "'";
        }
    }

    /* loaded from: classes2.dex */
    public static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean optional;
        private final DateTimePrinterParser[] printerParsers;

        CompositePrinterParser(List list, boolean z) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z);
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.printerParsers = dateTimePrinterParserArr;
            this.optional = z;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.optional) {
                dateTimePrintContext.startOptional();
            }
            try {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    if (!dateTimePrinterParser.format(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
                return true;
            } finally {
                if (this.optional) {
                    dateTimePrintContext.endOptional();
                }
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r9) {
            if (!this.optional) {
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    r9 = dateTimePrinterParser.parse(dateTimeParseContext, charSequence, r9);
                    if (r9 < 0) {
                        break;
                    }
                }
                return r9;
            }
            dateTimeParseContext.startOptional();
            int r4 = r9;
            for (DateTimePrinterParser dateTimePrinterParser2 : this.printerParsers) {
                r4 = dateTimePrinterParser2.parse(dateTimeParseContext, charSequence, r4);
                if (r4 < 0) {
                    dateTimeParseContext.endOptional(false);
                    return r9;
                }
            }
            dateTimeParseContext.endOptional(true);
            return r4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.printerParsers != null) {
                sb.append(this.optional ? "[" : "(");
                for (DateTimePrinterParser dateTimePrinterParser : this.printerParsers) {
                    sb.append(dateTimePrinterParser);
                }
                sb.append(this.optional ? "]" : ")");
            }
            return sb.toString();
        }

        public CompositePrinterParser withOptional(boolean z) {
            return z == this.optional ? this : new CompositePrinterParser(this.printerParsers, z);
        }
    }

    /* loaded from: classes2.dex */
    public interface DateTimePrinterParser {
        boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb);

        int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r3);
    }

    /* loaded from: classes2.dex */
    public static final class FractionPrinterParser implements DateTimePrinterParser {
        private final boolean decimalPoint;
        private final TemporalField field;
        private final int maxWidth;
        private final int minWidth;

        FractionPrinterParser(TemporalField temporalField, int r4, int r5, boolean z) {
            Objects.requireNonNull(temporalField, "field");
            if (!temporalField.range().isFixed()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            }
            if (r4 < 0 || r4 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + r4);
            }
            if (r5 < 1 || r5 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + r5);
            }
            if (r5 >= r4) {
                this.field = temporalField;
                this.minWidth = r4;
                this.maxWidth = r5;
                this.decimalPoint = z;
                return;
            }
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
        }

        private long convertFromFraction(BigDecimal bigDecimal) {
            ValueRange range = this.field.range();
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            return bigDecimal.multiply(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        private BigDecimal convertToFraction(long j) {
            ValueRange range = this.field.range();
            range.checkValidValue(j, this.field);
            BigDecimal valueOf = BigDecimal.valueOf(range.getMinimum());
            BigDecimal divide = BigDecimal.valueOf(j).subtract(valueOf).divide(BigDecimal.valueOf(range.getMaximum()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            return divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            DecimalStyle decimalStyle = dateTimePrintContext.getDecimalStyle();
            BigDecimal convertToFraction = convertToFraction(value.longValue());
            if (convertToFraction.scale() != 0) {
                String convertNumberToI18N = decimalStyle.convertNumberToI18N(convertToFraction.setScale(Math.min(Math.max(convertToFraction.scale(), this.minWidth), this.maxWidth), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.decimalPoint) {
                    sb.append(decimalStyle.getDecimalSeparator());
                }
                sb.append(convertNumberToI18N);
                return true;
            }
            if (this.minWidth <= 0) {
                return true;
            }
            if (this.decimalPoint) {
                sb.append(decimalStyle.getDecimalSeparator());
            }
            for (int r1 = 0; r1 < this.minWidth; r1++) {
                sb.append(decimalStyle.getZeroDigit());
            }
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r13) {
            int r9;
            int r1 = 0;
            int r0 = dateTimeParseContext.isStrict() ? this.minWidth : 0;
            int r2 = dateTimeParseContext.isStrict() ? this.maxWidth : 9;
            int length = charSequence.length();
            if (r13 == length) {
                return r0 > 0 ? ~r13 : r13;
            }
            if (this.decimalPoint) {
                if (charSequence.charAt(r13) != dateTimeParseContext.getDecimalStyle().getDecimalSeparator()) {
                    return r0 > 0 ? ~r13 : r13;
                }
                r13++;
            }
            int r8 = r13;
            int r02 = r0 + r8;
            if (r02 > length) {
                return ~r8;
            }
            int min = Math.min(r2 + r8, length);
            int r22 = r8;
            while (true) {
                if (r22 >= min) {
                    r9 = r22;
                    break;
                }
                int r3 = r22 + 1;
                int convertToDigit = dateTimeParseContext.getDecimalStyle().convertToDigit(charSequence.charAt(r22));
                if (convertToDigit >= 0) {
                    r1 = (r1 * 10) + convertToDigit;
                    r22 = r3;
                } else {
                    if (r3 < r02) {
                        return ~r8;
                    }
                    r9 = r3 - 1;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, convertFromFraction(new BigDecimal(r1).movePointLeft(r9 - r8)), r8, r9);
        }

        public String toString() {
            return "Fraction(" + this.field + "," + this.minWidth + "," + this.maxWidth + (this.decimalPoint ? ",DecimalPoint" : "") + ")";
        }
    }

    /* loaded from: classes2.dex */
    public static final class InstantPrinterParser implements DateTimePrinterParser {
        private final int fractionalDigits;

        InstantPrinterParser(int r1) {
            this.fractionalDigits = r1;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.INSTANT_SECONDS);
            TemporalAccessor temporal = dateTimePrintContext.getTemporal();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            Long valueOf = temporal.isSupported(chronoField) ? Long.valueOf(dateTimePrintContext.getTemporal().getLong(chronoField)) : null;
            int r4 = 0;
            if (value == null) {
                return false;
            }
            long longValue = value.longValue();
            int checkValidIntValue = chronoField.checkValidIntValue(valueOf != null ? valueOf.longValue() : 0L);
            if (longValue >= -62167219200L) {
                long j = (longValue - 315569520000L) + 62167219200L;
                long floorDiv = 1 + Math.floorDiv(j, 315569520000L);
                LocalDateTime ofEpochSecond = LocalDateTime.ofEpochSecond(Math.floorMod(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                if (floorDiv > 0) {
                    sb.append('+');
                    sb.append(floorDiv);
                }
                sb.append(ofEpochSecond);
                if (ofEpochSecond.getSecond() == 0) {
                    sb.append(":00");
                }
            } else {
                long j2 = longValue + 62167219200L;
                long j3 = j2 / 315569520000L;
                long j4 = j2 % 315569520000L;
                LocalDateTime ofEpochSecond2 = LocalDateTime.ofEpochSecond(j4 - 62167219200L, 0, ZoneOffset.UTC);
                int length = sb.length();
                sb.append(ofEpochSecond2);
                if (ofEpochSecond2.getSecond() == 0) {
                    sb.append(":00");
                }
                if (j3 < 0) {
                    if (ofEpochSecond2.getYear() == -10000) {
                        sb.replace(length, length + 2, Long.toString(j3 - 1));
                    } else if (j4 == 0) {
                        sb.insert(length, j3);
                    } else {
                        sb.insert(length + 1, Math.abs(j3));
                    }
                }
            }
            int r3 = this.fractionalDigits;
            if ((r3 < 0 && checkValidIntValue > 0) || r3 > 0) {
                sb.append('.');
                int r32 = 100000000;
                while (true) {
                    int r5 = this.fractionalDigits;
                    if ((r5 != -1 || checkValidIntValue <= 0) && ((r5 != -2 || (checkValidIntValue <= 0 && r4 % 3 == 0)) && r4 >= r5)) {
                        break;
                    }
                    int r52 = checkValidIntValue / r32;
                    sb.append((char) (r52 + 48));
                    checkValidIntValue -= r52 * r32;
                    r32 /= 10;
                    r4++;
                }
            }
            sb.append('Z');
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r24) {
            int r17;
            int r19;
            int r1 = this.fractionalDigits;
            int r2 = 0;
            int r3 = r1 < 0 ? 0 : r1;
            if (r1 < 0) {
                r1 = 9;
            }
            DateTimeFormatterBuilder appendLiteral = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_LOCAL_DATE).appendLiteral('T');
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder appendLiteral2 = appendLiteral.appendValue(chronoField, 2).appendLiteral(':');
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder appendLiteral3 = appendLiteral2.appendValue(chronoField2, 2).appendLiteral(':');
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder appendValue = appendLiteral3.appendValue(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            CompositePrinterParser printerParser = appendValue.appendFraction(chronoField4, r3, r1, true).appendLiteral('Z').toFormatter().toPrinterParser(false);
            DateTimeParseContext copy = dateTimeParseContext.copy();
            int parse = printerParser.parse(copy, charSequence, r24);
            if (parse < 0) {
                return parse;
            }
            long longValue = copy.getParsed(ChronoField.YEAR).longValue();
            int intValue = copy.getParsed(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = copy.getParsed(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = copy.getParsed(chronoField).intValue();
            int intValue4 = copy.getParsed(chronoField2).intValue();
            Long parsed = copy.getParsed(chronoField3);
            Long parsed2 = copy.getParsed(chronoField4);
            int intValue5 = parsed != null ? parsed.intValue() : 0;
            int intValue6 = parsed2 != null ? parsed2.intValue() : 0;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                r17 = 0;
                r19 = intValue5;
                r2 = 1;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                dateTimeParseContext.setParsedLeapSecond();
                r17 = intValue3;
                r19 = 59;
            } else {
                r17 = intValue3;
                r19 = intValue5;
            }
            try {
                return dateTimeParseContext.setParsedField(chronoField4, intValue6, r24, dateTimeParseContext.setParsedField(ChronoField.INSTANT_SECONDS, Math.multiplyExact(longValue / 10000, 315569520000L) + LocalDateTime.of(((int) longValue) % Constants.MAXIMUM_UPLOAD_PARTS, intValue, intValue2, r17, intValue4, r19, 0).plusDays(r2).toEpochSecond(ZoneOffset.UTC), r24, parse));
            } catch (RuntimeException unused) {
                return ~r24;
            }
        }

        public String toString() {
            return "Instant()";
        }
    }

    /* loaded from: classes2.dex */
    public static final class LocalizedOffsetIdPrinterParser implements DateTimePrinterParser {
        private final TextStyle style;

        LocalizedOffsetIdPrinterParser(TextStyle textStyle) {
            this.style = textStyle;
        }

        private static StringBuilder appendHMS(StringBuilder sb, int r2) {
            sb.append((char) ((r2 / 10) + 48));
            sb.append((char) ((r2 % 10) + 48));
            return sb;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            sb.append("GMT");
            int intExact = Math.toIntExact(value.longValue());
            if (intExact == 0) {
                return true;
            }
            int abs = Math.abs((intExact / 3600) % 100);
            int abs2 = Math.abs((intExact / 60) % 60);
            int abs3 = Math.abs(intExact % 60);
            sb.append(intExact < 0 ? "-" : "+");
            if (this.style == TextStyle.FULL) {
                appendHMS(sb, abs);
                sb.append(':');
                appendHMS(sb, abs2);
                if (abs3 == 0) {
                    return true;
                }
            } else {
                if (abs >= 10) {
                    sb.append((char) ((abs / 10) + 48));
                }
                sb.append((char) ((abs % 10) + 48));
                if (abs2 == 0 && abs3 == 0) {
                    return true;
                }
                sb.append(':');
                appendHMS(sb, abs2);
                if (abs3 == 0) {
                    return true;
                }
            }
            sb.append(':');
            appendHMS(sb, abs3);
            return true;
        }

        int getDigit(CharSequence charSequence, int r3) {
            char charAt = charSequence.charAt(r3);
            if (charAt < '0' || charAt > '9') {
                return -1;
            }
            return charAt - '0';
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:            if (r13 >= 0) goto L138;     */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e1, code lost:            r4 = (r0 * 10) + r13;        r7 = r7 + 3;     */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00df, code lost:            if (r13 >= 0) goto L138;     */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(j$.time.format.DateTimeParseContext r12, java.lang.CharSequence r13, int r14) {
            /*
                Method dump skipped, instructions count: 268
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.LocalizedOffsetIdPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            return "LocalizedOffset(" + this.style + ")";
        }
    }

    /* loaded from: classes2.dex */
    public static class NumberPrinterParser implements DateTimePrinterParser {
        static final long[] EXCEED_POINTS = {0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};
        final TemporalField field;
        final int maxWidth;
        final int minWidth;
        private final SignStyle signStyle;
        final int subsequentWidth;

        NumberPrinterParser(TemporalField temporalField, int r2, int r3, SignStyle signStyle) {
            this.field = temporalField;
            this.minWidth = r2;
            this.maxWidth = r3;
            this.signStyle = signStyle;
            this.subsequentWidth = 0;
        }

        protected NumberPrinterParser(TemporalField temporalField, int r2, int r3, SignStyle signStyle, int r5) {
            this.field = temporalField;
            this.minWidth = r2;
            this.maxWidth = r3;
            this.signStyle = signStyle;
            this.subsequentWidth = r5;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00aa A[LOOP:0: B:18:0x00a1->B:20:0x00aa, LOOP_END] */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean format(j$.time.format.DateTimePrintContext r11, java.lang.StringBuilder r12) {
            /*
                r10 = this;
                j$.time.temporal.TemporalField r0 = r10.field
                java.lang.Long r0 = r11.getValue(r0)
                r1 = 0
                if (r0 != 0) goto La
                return r1
            La:
                long r2 = r0.longValue()
                long r2 = r10.getValue(r11, r2)
                j$.time.format.DecimalStyle r11 = r11.getDecimalStyle()
                r4 = -9223372036854775808
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L1f
                java.lang.String r0 = "9223372036854775808"
                goto L27
            L1f:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r0 = java.lang.Long.toString(r4)
            L27:
                int r4 = r0.length()
                int r5 = r10.maxWidth
                java.lang.String r6 = " cannot be printed as the value "
                java.lang.String r7 = "Field "
                if (r4 > r5) goto Lb8
                java.lang.String r0 = r11.convertNumberToI18N(r0)
                r4 = 0
                int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r5 = 2
                r8 = 1
                if (r4 < 0) goto L65
                int[] r4 = j$.time.format.DateTimeFormatterBuilder.AnonymousClass3.$SwitchMap$java$time$format$SignStyle
                j$.time.format.SignStyle r6 = r10.signStyle
                int r6 = r6.ordinal()
                r4 = r4[r6]
                if (r4 == r8) goto L56
                if (r4 == r5) goto L4e
                goto La1
            L4e:
                char r2 = r11.getPositiveSign()
            L52:
                r12.append(r2)
                goto La1
            L56:
                int r4 = r10.minWidth
                r5 = 19
                if (r4 >= r5) goto La1
                long[] r5 = j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.EXCEED_POINTS
                r4 = r5[r4]
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 < 0) goto La1
                goto L4e
            L65:
                int[] r4 = j$.time.format.DateTimeFormatterBuilder.AnonymousClass3.$SwitchMap$java$time$format$SignStyle
                j$.time.format.SignStyle r9 = r10.signStyle
                int r9 = r9.ordinal()
                r4 = r4[r9]
                if (r4 == r8) goto L9c
                if (r4 == r5) goto L9c
                r5 = 3
                if (r4 == r5) goto L9c
                r5 = 4
                if (r4 == r5) goto L7a
                goto La1
            L7a:
                j$.time.DateTimeException r11 = new j$.time.DateTimeException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r7)
                j$.time.temporal.TemporalField r0 = r10.field
                r12.append(r0)
                r12.append(r6)
                r12.append(r2)
                java.lang.String r0 = " cannot be negative according to the SignStyle"
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                throw r11
            L9c:
                char r2 = r11.getNegativeSign()
                goto L52
            La1:
                int r2 = r10.minWidth
                int r3 = r0.length()
                int r2 = r2 - r3
                if (r1 >= r2) goto Lb4
                char r2 = r11.getZeroDigit()
                r12.append(r2)
                int r1 = r1 + 1
                goto La1
            Lb4:
                r12.append(r0)
                return r8
            Lb8:
                j$.time.DateTimeException r11 = new j$.time.DateTimeException
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                r12.append(r7)
                j$.time.temporal.TemporalField r0 = r10.field
                r12.append(r0)
                r12.append(r6)
                r12.append(r2)
                java.lang.String r0 = " exceeds the maximum print width of "
                r12.append(r0)
                int r0 = r10.maxWidth
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.format(j$.time.format.DateTimePrintContext, java.lang.StringBuilder):boolean");
        }

        long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            return j;
        }

        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            int r2 = this.subsequentWidth;
            return r2 == -1 || (r2 > 0 && this.minWidth == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE);
        }

        /* JADX WARN: Removed duplicated region for block: B:66:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x017a  */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(j$.time.format.DateTimeParseContext r20, java.lang.CharSequence r21, int r22) {
            /*
                Method dump skipped, instructions count: 388
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        int setValue(DateTimeParseContext dateTimeParseContext, long j, int r10, int r11) {
            return dateTimeParseContext.setParsedField(this.field, j, r10, r11);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int r0 = this.minWidth;
            if (r0 == 1 && this.maxWidth == 19 && this.signStyle == SignStyle.NORMAL) {
                sb = new StringBuilder();
                sb.append("Value(");
                obj = this.field;
            } else {
                if (r0 == this.maxWidth && this.signStyle == SignStyle.NOT_NEGATIVE) {
                    sb = new StringBuilder();
                    sb.append("Value(");
                    sb.append(this.field);
                    sb.append(",");
                    sb.append(this.minWidth);
                    sb.append(")");
                    return sb.toString();
                }
                sb = new StringBuilder();
                sb.append("Value(");
                sb.append(this.field);
                sb.append(",");
                sb.append(this.minWidth);
                sb.append(",");
                sb.append(this.maxWidth);
                sb.append(",");
                obj = this.signStyle;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        NumberPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, -1);
        }

        NumberPrinterParser withSubsequentWidth(int r8) {
            return new NumberPrinterParser(this.field, this.minWidth, this.maxWidth, this.signStyle, this.subsequentWidth + r8);
        }
    }

    /* loaded from: classes2.dex */
    public static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        private final String noOffsetText;
        private final int type;
        static final String[] PATTERNS = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser INSTANCE_ID_Z = new OffsetIdPrinterParser("+HH:MM:ss", "Z");
        static final OffsetIdPrinterParser INSTANCE_ID_ZERO = new OffsetIdPrinterParser("+HH:MM:ss", "0");

        OffsetIdPrinterParser(String str, String str2) {
            Objects.requireNonNull(str, "pattern");
            Objects.requireNonNull(str2, "noOffsetText");
            this.type = checkPattern(str);
            this.noOffsetText = str2;
        }

        private int checkPattern(String str) {
            int r0 = 0;
            while (true) {
                String[] strArr = PATTERNS;
                if (r0 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                }
                if (strArr[r0].equals(str)) {
                    return r0;
                }
                r0++;
            }
        }

        private boolean parseNumber(int[] r6, int r7, CharSequence charSequence, boolean z) {
            int r1;
            int r0 = this.type;
            if ((r0 + 3) / 2 < r7) {
                return false;
            }
            int r12 = r6[0];
            if (r0 % 2 == 0 && r7 > 1) {
                int r02 = r12 + 1;
                if (r02 > charSequence.length() || charSequence.charAt(r12) != ':') {
                    return z;
                }
                r12 = r02;
            }
            if (r12 + 2 > charSequence.length()) {
                return z;
            }
            int r03 = r12 + 1;
            char charAt = charSequence.charAt(r12);
            int r3 = r03 + 1;
            char charAt2 = charSequence.charAt(r03);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (r1 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || r1 > 59) {
                return z;
            }
            r6[r7] = r1;
            r6[0] = r3;
            return false;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(ChronoField.OFFSET_SECONDS);
            if (value == null) {
                return false;
            }
            int intExact = Math.toIntExact(value.longValue());
            if (intExact != 0) {
                int abs = Math.abs((intExact / 3600) % 100);
                int abs2 = Math.abs((intExact / 60) % 60);
                int abs3 = Math.abs(intExact % 60);
                int length = sb.length();
                sb.append(intExact < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int r8 = this.type;
                if (r8 >= 3 || (r8 >= 1 && abs2 > 0)) {
                    sb.append(r8 % 2 == 0 ? ":" : "");
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int r82 = this.type;
                    if (r82 >= 7 || (r82 >= 5 && abs3 > 0)) {
                        sb.append(r82 % 2 != 0 ? "" : ":");
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.noOffsetText);
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0034, code lost:            if (r16.subSequenceEquals(r17, r18, r15.noOffsetText, 0, r9) != false) goto L53;     */
        /* JADX WARN: Removed duplicated region for block: B:29:0x007c  */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(j$.time.format.DateTimeParseContext r16, java.lang.CharSequence r17, int r18) {
            /*
                r15 = this;
                r0 = r15
                r7 = r17
                r8 = r18
                int r1 = r17.length()
                java.lang.String r2 = r0.noOffsetText
                int r9 = r2.length()
                if (r9 != 0) goto L22
                if (r8 != r1) goto L41
                j$.time.temporal.ChronoField r2 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                r1 = r16
                r5 = r18
                r6 = r18
            L1d:
                int r1 = r1.setParsedField(r2, r3, r5, r6)
                return r1
            L22:
                if (r8 != r1) goto L26
                int r1 = ~r8
                return r1
            L26:
                java.lang.String r4 = r0.noOffsetText
                r5 = 0
                r1 = r16
                r2 = r17
                r3 = r18
                r6 = r9
                boolean r1 = r1.subSequenceEquals(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L41
            L36:
                j$.time.temporal.ChronoField r2 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                goto L1d
            L41:
                char r1 = r17.charAt(r18)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L4d
                if (r1 != r3) goto L9b
            L4d:
                r2 = 1
                if (r1 != r3) goto L52
                r1 = -1
                goto L53
            L52:
                r1 = r2
            L53:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r15.parseNumber(r3, r2, r7, r2)
                r6 = 2
                r10 = 3
                if (r4 != 0) goto L79
                int r4 = r0.type
                if (r4 < r10) goto L69
                r4 = r2
                goto L6a
            L69:
                r4 = r5
            L6a:
                boolean r4 = r15.parseNumber(r3, r6, r7, r4)
                if (r4 != 0) goto L79
                boolean r4 = r15.parseNumber(r3, r10, r7, r5)
                if (r4 == 0) goto L77
                goto L79
            L77:
                r4 = r5
                goto L7a
            L79:
                r4 = r2
            L7a:
                if (r4 != 0) goto L9b
                long r11 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                r4 = r3[r6]
                long r6 = (long) r4
                r13 = 60
                long r6 = r6 * r13
                long r1 = r1 + r6
                r4 = r3[r10]
                long r6 = (long) r4
                long r1 = r1 + r6
                long r6 = r11 * r1
                j$.time.temporal.ChronoField r2 = j$.time.temporal.ChronoField.OFFSET_SECONDS
                r9 = r3[r5]
                r1 = r16
                r3 = r6
                r5 = r18
                r6 = r9
                goto L1d
            L9b:
                if (r9 != 0) goto L9e
                goto L36
            L9e:
                int r1 = ~r8
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            return "Offset(" + PATTERNS[this.type] + ",'" + this.noOffsetText.replace("'", "''") + "')";
        }
    }

    /* loaded from: classes2.dex */
    public static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final char padChar;
        private final int padWidth;
        private final DateTimePrinterParser printerParser;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int r2, char c) {
            this.printerParser = dateTimePrinterParser;
            this.padWidth = r2;
            this.padChar = c;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.printerParser.format(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.padWidth) {
                for (int r1 = 0; r1 < this.padWidth - length2; r1++) {
                    sb.insert(length, this.padChar);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.padWidth);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r8) {
            boolean isStrict = dateTimeParseContext.isStrict();
            if (r8 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            if (r8 == charSequence.length()) {
                return ~r8;
            }
            int r1 = this.padWidth + r8;
            if (r1 > charSequence.length()) {
                if (isStrict) {
                    return ~r8;
                }
                r1 = charSequence.length();
            }
            int r2 = r8;
            while (r2 < r1 && dateTimeParseContext.charEquals(charSequence.charAt(r2), this.padChar)) {
                r2++;
            }
            int parse = this.printerParser.parse(dateTimeParseContext, charSequence.subSequence(0, r1), r2);
            return (parse == r1 || !isStrict) ? parse : ~(r8 + r2);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Pad(");
            sb.append(this.printerParser);
            sb.append(",");
            sb.append(this.padWidth);
            if (this.padChar == ' ') {
                str = ")";
            } else {
                str = ",'" + this.padChar + "')";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class PrefixTree {
        protected char c0;
        protected PrefixTree child;
        protected String key;
        protected PrefixTree sibling;
        protected String value;

        /* loaded from: classes2.dex */
        public static class CI extends PrefixTree {
            private CI(String str, String str2, PrefixTree prefixTree) {
                super(str, str2, prefixTree);
            }

            /* synthetic */ CI(String str, String str2, PrefixTree prefixTree, AnonymousClass1 anonymousClass1) {
                this(str, str2, prefixTree);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean isEqual(char c, char c2) {
                return DateTimeParseContext.charEqualsIgnoreCase(c, c2);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            public CI newNode(String str, String str2, PrefixTree prefixTree) {
                return new CI(str, str2, prefixTree);
            }

            @Override // j$.time.format.DateTimeFormatterBuilder.PrefixTree
            protected boolean prefixOf(CharSequence charSequence, int r6, int r7) {
                int length = this.key.length();
                if (length > r7 - r6) {
                    return false;
                }
                int r72 = 0;
                while (true) {
                    int r2 = length - 1;
                    if (length <= 0) {
                        return true;
                    }
                    int r3 = r72 + 1;
                    int r0 = r6 + 1;
                    if (!isEqual(this.key.charAt(r72), charSequence.charAt(r6))) {
                        return false;
                    }
                    r6 = r0;
                    length = r2;
                    r72 = r3;
                }
            }
        }

        private PrefixTree(String str, String str2, PrefixTree prefixTree) {
            this.key = str;
            this.value = str2;
            this.child = prefixTree;
            this.c0 = str.length() == 0 ? (char) 65535 : this.key.charAt(0);
        }

        /* synthetic */ PrefixTree(String str, String str2, PrefixTree prefixTree, AnonymousClass1 anonymousClass1) {
            this(str, str2, prefixTree);
        }

        private boolean add0(String str, String str2) {
            String key = toKey(str);
            int prefixLength = prefixLength(key);
            if (prefixLength != this.key.length()) {
                PrefixTree newNode = newNode(this.key.substring(prefixLength), this.value, this.child);
                this.key = key.substring(0, prefixLength);
                this.child = newNode;
                if (prefixLength < key.length()) {
                    this.child.sibling = newNode(key.substring(prefixLength), str2, null);
                    this.value = null;
                } else {
                    this.value = str2;
                }
                return true;
            }
            if (prefixLength >= key.length()) {
                this.value = str2;
                return true;
            }
            String substring = key.substring(prefixLength);
            for (PrefixTree prefixTree = this.child; prefixTree != null; prefixTree = prefixTree.sibling) {
                if (isEqual(prefixTree.c0, substring.charAt(0))) {
                    return prefixTree.add0(substring, str2);
                }
            }
            PrefixTree newNode2 = newNode(substring, str2, null);
            newNode2.sibling = this.child;
            this.child = newNode2;
            return true;
        }

        public static PrefixTree newTree(DateTimeParseContext dateTimeParseContext) {
            return dateTimeParseContext.isCaseSensitive() ? new PrefixTree("", null, null) : new CI("", null, null);
        }

        public static PrefixTree newTree(Set set, DateTimeParseContext dateTimeParseContext) {
            PrefixTree newTree = newTree(dateTimeParseContext);
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                newTree.add0(str, str);
            }
            return newTree;
        }

        private int prefixLength(String str) {
            int r0 = 0;
            while (r0 < str.length() && r0 < this.key.length() && isEqual(str.charAt(r0), this.key.charAt(r0))) {
                r0++;
            }
            return r0;
        }

        public boolean add(String str, String str2) {
            return add0(str, str2);
        }

        protected boolean isEqual(char c, char c2) {
            return c == c2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:            r2 = r2.sibling;     */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:            if (r2 != null) goto L41;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:            r6.setIndex(r0);        r5 = r2.match(r5, r6);     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:            if (r5 == null) goto L37;     */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:            return r5;     */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:            if (r0 != r1) goto L30;     */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:            if (isEqual(r2.c0, r5.charAt(r0)) == false) goto L35;     */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String match(java.lang.CharSequence r5, java.text.ParsePosition r6) {
            /*
                r4 = this;
                int r0 = r6.getIndex()
                int r1 = r5.length()
                boolean r2 = r4.prefixOf(r5, r0, r1)
                if (r2 != 0) goto L10
                r5 = 0
                return r5
            L10:
                java.lang.String r2 = r4.key
                int r2 = r2.length()
                int r0 = r0 + r2
                j$.time.format.DateTimeFormatterBuilder$PrefixTree r2 = r4.child
                if (r2 == 0) goto L37
                if (r0 == r1) goto L37
            L1d:
                char r1 = r2.c0
                char r3 = r5.charAt(r0)
                boolean r1 = r4.isEqual(r1, r3)
                if (r1 == 0) goto L33
                r6.setIndex(r0)
                java.lang.String r5 = r2.match(r5, r6)
                if (r5 == 0) goto L37
                return r5
            L33:
                j$.time.format.DateTimeFormatterBuilder$PrefixTree r2 = r2.sibling
                if (r2 != 0) goto L1d
            L37:
                r6.setIndex(r0)
                java.lang.String r5 = r4.value
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.PrefixTree.match(java.lang.CharSequence, java.text.ParsePosition):java.lang.String");
        }

        protected PrefixTree newNode(String str, String str2, PrefixTree prefixTree) {
            return new PrefixTree(str, str2, prefixTree);
        }

        protected boolean prefixOf(CharSequence charSequence, int r6, int r7) {
            if (charSequence instanceof String) {
                return ((String) charSequence).startsWith(this.key, r6);
            }
            int length = this.key.length();
            if (length > r7 - r6) {
                return false;
            }
            int r72 = 0;
            while (true) {
                int r2 = length - 1;
                if (length <= 0) {
                    return true;
                }
                int r3 = r72 + 1;
                int r0 = r6 + 1;
                if (!isEqual(this.key.charAt(r72), charSequence.charAt(r6))) {
                    return false;
                }
                r6 = r0;
                length = r2;
                r72 = r3;
            }
        }

        protected String toKey(String str) {
            return str;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate BASE_DATE = LocalDate.of(2000, 1, 1);
        private final ChronoLocalDate baseDate;
        private final int baseValue;

        ReducedPrinterParser(TemporalField temporalField, int r9, int r10, int r11, ChronoLocalDate chronoLocalDate) {
            this(temporalField, r9, r10, r11, chronoLocalDate, 0);
            if (r9 < 1 || r9 > 10) {
                throw new IllegalArgumentException("The minWidth must be from 1 to 10 inclusive but was " + r9);
            }
            if (r10 < 1 || r10 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + r9);
            }
            if (r10 < r9) {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + r10 + " < " + r9);
            }
            if (chronoLocalDate == null) {
                long j = r11;
                if (!temporalField.range().isValidValue(j)) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                }
                if (j + NumberPrinterParser.EXCEED_POINTS[r10] > 2147483647L) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
        }

        private ReducedPrinterParser(TemporalField temporalField, int r8, int r9, int r10, ChronoLocalDate chronoLocalDate, int r12) {
            super(temporalField, r8, r9, SignStyle.NOT_NEGATIVE, r12);
            this.baseValue = r10;
            this.baseDate = chronoLocalDate;
        }

        /* synthetic */ ReducedPrinterParser(TemporalField temporalField, int r2, int r3, int r4, ChronoLocalDate chronoLocalDate, int r6, AnonymousClass1 anonymousClass1) {
            this(temporalField, r2, r3, r4, chronoLocalDate, r6);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        long getValue(DateTimePrintContext dateTimePrintContext, long j) {
            long abs = Math.abs(j);
            int r2 = this.baseValue;
            if (this.baseDate != null) {
                r2 = Chronology.from(dateTimePrintContext.getTemporal()).date(this.baseDate).get(this.field);
            }
            long j2 = r2;
            if (j >= j2) {
                long j3 = NumberPrinterParser.EXCEED_POINTS[this.minWidth];
                if (j < j2 + j3) {
                    return abs % j3;
                }
            }
            return abs % NumberPrinterParser.EXCEED_POINTS[this.maxWidth];
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        boolean isFixedWidth(DateTimeParseContext dateTimeParseContext) {
            if (dateTimeParseContext.isStrict()) {
                return super.isFixedWidth(dateTimeParseContext);
            }
            return false;
        }

        /* renamed from: lambda$setValue$0$java-time-format-DateTimeFormatterBuilder$ReducedPrinterParser */
        public /* synthetic */ void m1660xdf3a601e(DateTimeParseContext dateTimeParseContext, long j, int r4, int r5, Chronology chronology) {
            setValue(dateTimeParseContext, j, r4, r5);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        int setValue(final DateTimeParseContext dateTimeParseContext, final long j, final int r13, final int r14) {
            int r0 = this.baseValue;
            if (this.baseDate != null) {
                r0 = dateTimeParseContext.getEffectiveChronology().date(this.baseDate).get(this.field);
                dateTimeParseContext.addChronoChangedListener(new Consumer() { // from class: j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        DateTimeFormatterBuilder.ReducedPrinterParser.this.m1660xdf3a601e(dateTimeParseContext, j, r13, r14, (Chronology) obj);
                    }
                });
            }
            int r1 = r14 - r13;
            int r2 = this.minWidth;
            if (r1 == r2 && j >= 0) {
                long j2 = NumberPrinterParser.EXCEED_POINTS[r2];
                long j3 = r0;
                long j4 = j3 - (j3 % j2);
                j = r0 > 0 ? j4 + j : j4 - j;
                if (j < j3) {
                    j += j2;
                }
            }
            return dateTimeParseContext.setParsedField(this.field, j, r13, r14);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReducedValue(");
            sb.append(this.field);
            sb.append(",");
            sb.append(this.minWidth);
            sb.append(",");
            sb.append(this.maxWidth);
            sb.append(",");
            Object obj = this.baseDate;
            if (obj == null) {
                obj = Integer.valueOf(this.baseValue);
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withFixedWidth() {
            return this.subsequentWidth == -1 ? this : new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, -1);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.NumberPrinterParser
        public ReducedPrinterParser withSubsequentWidth(int r9) {
            return new ReducedPrinterParser(this.field, this.minWidth, this.maxWidth, this.baseValue, this.baseDate, this.subsequentWidth + r9);
        }
    }

    /* loaded from: classes2.dex */
    public enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r6) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.setCaseSensitive(true);
            } else if (ordinal == 1) {
                dateTimeParseContext.setCaseSensitive(false);
            } else if (ordinal == 2) {
                dateTimeParseContext.setStrict(true);
            } else if (ordinal == 3) {
                dateTimeParseContext.setStrict(false);
            }
            return r6;
        }

        @Override // java.lang.Enum
        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    /* loaded from: classes2.dex */
    public static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String literal;

        StringLiteralPrinterParser(String str) {
            this.literal = str;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.literal);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r10) {
            if (r10 > charSequence.length() || r10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.literal;
            return !dateTimeParseContext.subSequenceEquals(charSequence, r10, str, 0, str.length()) ? ~r10 : r10 + this.literal.length();
        }

        public String toString() {
            return "'" + this.literal.replace("'", "''") + "'";
        }
    }

    /* loaded from: classes2.dex */
    public static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField field;
        private volatile NumberPrinterParser numberPrinterParser;
        private final DateTimeTextProvider provider;
        private final TextStyle textStyle;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.field = temporalField;
            this.textStyle = textStyle;
            this.provider = dateTimeTextProvider;
        }

        private NumberPrinterParser numberPrinterParser() {
            if (this.numberPrinterParser == null) {
                this.numberPrinterParser = new NumberPrinterParser(this.field, 1, 19, SignStyle.NORMAL);
            }
            return this.numberPrinterParser;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long value = dateTimePrintContext.getValue(this.field);
            if (value == null) {
                return false;
            }
            Chronology chronology = (Chronology) dateTimePrintContext.getTemporal().query(TemporalQueries.chronology());
            String text = (chronology == null || chronology == IsoChronology.INSTANCE) ? this.provider.getText(this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale()) : this.provider.getText(chronology, this.field, value.longValue(), this.textStyle, dateTimePrintContext.getLocale());
            if (text == null) {
                return numberPrinterParser().format(dateTimePrintContext, sb);
            }
            sb.append(text);
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:            if (r0 != null) goto L51;     */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x003c, code lost:            if (r0.hasNext() == false) goto L66;     */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:            r1 = (java.util.Map.Entry) r0.next();        r2 = (java.lang.String) r1.getKey();     */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:            if (r11.subSequenceEquals(r2, 0, r12, r13, r2.length()) == false) goto L67;     */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:            return r11.setParsedField(r10.field, ((java.lang.Long) r1.getValue()).longValue(), r13, r13 + r2.length());     */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:            if (r11.isStrict() == false) goto L61;     */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:            return ~r13;     */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:            return numberPrinterParser().parse(r11, r12, r13);     */
        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int parse(j$.time.format.DateTimeParseContext r11, java.lang.CharSequence r12, int r13) {
            /*
                r10 = this;
                int r0 = r12.length()
                if (r13 < 0) goto L83
                if (r13 > r0) goto L83
                boolean r0 = r11.isStrict()
                if (r0 == 0) goto L11
                j$.time.format.TextStyle r0 = r10.textStyle
                goto L12
            L11:
                r0 = 0
            L12:
                j$.time.chrono.Chronology r1 = r11.getEffectiveChronology()
                if (r1 == 0) goto L2a
                j$.time.chrono.IsoChronology r2 = j$.time.chrono.IsoChronology.INSTANCE
                if (r1 != r2) goto L1d
                goto L2a
            L1d:
                j$.time.format.DateTimeTextProvider r2 = r10.provider
                j$.time.temporal.TemporalField r3 = r10.field
                java.util.Locale r4 = r11.getLocale()
                java.util.Iterator r0 = r2.getTextIterator(r1, r3, r0, r4)
                goto L36
            L2a:
                j$.time.format.DateTimeTextProvider r1 = r10.provider
                j$.time.temporal.TemporalField r2 = r10.field
                java.util.Locale r3 = r11.getLocale()
                java.util.Iterator r0 = r1.getTextIterator(r2, r0, r3)
            L36:
                if (r0 == 0) goto L7a
            L38:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L72
                java.lang.Object r1 = r0.next()
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1
                java.lang.Object r2 = r1.getKey()
                java.lang.String r2 = (java.lang.String) r2
                r5 = 0
                int r8 = r2.length()
                r3 = r11
                r4 = r2
                r6 = r12
                r7 = r13
                boolean r3 = r3.subSequenceEquals(r4, r5, r6, r7, r8)
                if (r3 == 0) goto L38
                j$.time.temporal.TemporalField r5 = r10.field
                java.lang.Object r12 = r1.getValue()
                java.lang.Long r12 = (java.lang.Long) r12
                long r6 = r12.longValue()
                int r12 = r2.length()
                int r9 = r13 + r12
                r4 = r11
                r8 = r13
                int r11 = r4.setParsedField(r5, r6, r8, r9)
                return r11
            L72:
                boolean r0 = r11.isStrict()
                if (r0 == 0) goto L7a
                int r11 = ~r13
                return r11
            L7a:
                j$.time.format.DateTimeFormatterBuilder$NumberPrinterParser r0 = r10.numberPrinterParser()
                int r11 = r0.parse(r11, r12, r13)
                return r11
            L83:
                java.lang.IndexOutOfBoundsException r11 = new java.lang.IndexOutOfBoundsException
                r11.<init>()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.TextPrinterParser.parse(j$.time.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            if (this.textStyle == TextStyle.FULL) {
                sb = new StringBuilder();
                sb.append("Text(");
                obj = this.field;
            } else {
                sb = new StringBuilder();
                sb.append("Text(");
                sb.append(this.field);
                sb.append(",");
                obj = this.textStyle;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static final class WeekBasedFieldPrinterParser implements DateTimePrinterParser {
        private char chr;
        private int count;

        WeekBasedFieldPrinterParser(char c, int r2) {
            this.chr = c;
            this.count = r2;
        }

        private DateTimePrinterParser printerParser(Locale locale) {
            TemporalField weekOfMonth;
            WeekFields of = WeekFields.of(locale);
            char c = this.chr;
            if (c == 'W') {
                weekOfMonth = of.weekOfMonth();
            } else {
                if (c == 'Y') {
                    TemporalField weekBasedYear = of.weekBasedYear();
                    if (this.count == 2) {
                        return new ReducedPrinterParser(weekBasedYear, 2, 2, 0, ReducedPrinterParser.BASE_DATE, 0);
                    }
                    int r5 = this.count;
                    return new NumberPrinterParser(weekBasedYear, r5, 19, r5 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
                }
                if (c == 'c' || c == 'e') {
                    weekOfMonth = of.dayOfWeek();
                } else {
                    if (c != 'w') {
                        throw new IllegalStateException("unreachable");
                    }
                    weekOfMonth = of.weekOfWeekBasedYear();
                }
            }
            return new NumberPrinterParser(weekOfMonth, this.count == 2 ? 2 : 1, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return printerParser(dateTimePrintContext.getLocale()).format(dateTimePrintContext, sb);
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r4) {
            return printerParser(dateTimeParseContext.getLocale()).parse(dateTimeParseContext, charSequence, r4);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c = this.chr;
            if (c == 'Y') {
                int r1 = this.count;
                if (r1 == 1) {
                    str2 = "WeekBasedYear";
                } else if (r1 == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.count);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.count < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
                sb.append(str2);
            } else {
                if (c == 'W') {
                    str = "WeekOfMonth";
                } else if (c == 'c' || c == 'e') {
                    str = DayOfWeek.TYPE;
                } else {
                    if (c == 'w') {
                        str = "WeekOfWeekBasedYear";
                    }
                    sb.append(",");
                    sb.append(this.count);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.count);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry cachedPrefixTree;
        private static volatile Map.Entry cachedPrefixTreeCI;
        private final String description;
        private final TemporalQuery query;

        ZoneIdPrinterParser(TemporalQuery temporalQuery, String str) {
            this.query = temporalQuery;
            this.description = str;
        }

        private int parseOffsetBased(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r6, int r7, OffsetIdPrinterParser offsetIdPrinterParser) {
            String upperCase = charSequence.toString().substring(r6, r7).toUpperCase();
            if (r7 >= charSequence.length() || charSequence.charAt(r7) == '0' || dateTimeParseContext.charEquals(charSequence.charAt(r7), 'Z')) {
                dateTimeParseContext.setParsed(ZoneId.of(upperCase));
                return r7;
            }
            DateTimeParseContext copy = dateTimeParseContext.copy();
            int parse = offsetIdPrinterParser.parse(copy, charSequence, r7);
            try {
                if (parse >= 0) {
                    dateTimeParseContext.setParsed(ZoneId.ofOffset(upperCase, ZoneOffset.ofTotalSeconds((int) copy.getParsed(ChronoField.OFFSET_SECONDS).longValue())));
                    return parse;
                }
                if (offsetIdPrinterParser == OffsetIdPrinterParser.INSTANCE_ID_Z) {
                    return ~r6;
                }
                dateTimeParseContext.setParsed(ZoneId.of(upperCase));
                return r7;
            } catch (DateTimeException unused) {
                return ~r6;
            }
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(this.query);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.getId());
            return true;
        }

        protected PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            Set availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map.Entry entry = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
            if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                synchronized (this) {
                    entry = dateTimeParseContext.isCaseSensitive() ? cachedPrefixTree : cachedPrefixTreeCI;
                    if (entry == null || ((Integer) entry.getKey()).intValue() != size) {
                        entry = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), PrefixTree.newTree(availableZoneIds, dateTimeParseContext));
                        if (dateTimeParseContext.isCaseSensitive()) {
                            cachedPrefixTree = entry;
                        } else {
                            cachedPrefixTreeCI = entry;
                        }
                    }
                }
            }
            return (PrefixTree) entry.getValue();
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int r12) {
            int r7;
            int length = charSequence.length();
            if (r12 > length) {
                throw new IndexOutOfBoundsException();
            }
            if (r12 == length) {
                return ~r12;
            }
            char charAt = charSequence.charAt(r12);
            if (charAt == '+' || charAt == '-') {
                return parseOffsetBased(dateTimeParseContext, charSequence, r12, r12, OffsetIdPrinterParser.INSTANCE_ID_Z);
            }
            int r5 = r12 + 2;
            if (length >= r5) {
                char charAt2 = charSequence.charAt(r12 + 1);
                if (dateTimeParseContext.charEquals(charAt, 'U') && dateTimeParseContext.charEquals(charAt2, 'T')) {
                    int r6 = r12 + 3;
                    return (length < r6 || !dateTimeParseContext.charEquals(charSequence.charAt(r5), 'C')) ? parseOffsetBased(dateTimeParseContext, charSequence, r12, r5, OffsetIdPrinterParser.INSTANCE_ID_ZERO) : parseOffsetBased(dateTimeParseContext, charSequence, r12, r6, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                }
                if (dateTimeParseContext.charEquals(charAt, 'G') && length >= (r7 = r12 + 3) && dateTimeParseContext.charEquals(charAt2, 'M') && dateTimeParseContext.charEquals(charSequence.charAt(r5), 'T')) {
                    return parseOffsetBased(dateTimeParseContext, charSequence, r12, r7, OffsetIdPrinterParser.INSTANCE_ID_ZERO);
                }
            }
            PrefixTree tree = getTree(dateTimeParseContext);
            ParsePosition parsePosition = new ParsePosition(r12);
            String match = tree.match(charSequence, parsePosition);
            if (match != null) {
                dateTimeParseContext.setParsed(ZoneId.of(match));
                return parsePosition.getIndex();
            }
            if (!dateTimeParseContext.charEquals(charAt, 'Z')) {
                return ~r12;
            }
            dateTimeParseContext.setParsed(ZoneOffset.UTC);
            return r12 + 1;
        }

        public String toString() {
            return this.description;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ZoneTextPrinterParser extends ZoneIdPrinterParser {
        private static final Map cache = new ConcurrentHashMap();
        private final Map cachedTree;
        private final Map cachedTreeCI;
        private Set preferredZones;
        private final TextStyle textStyle;

        ZoneTextPrinterParser(TextStyle textStyle, Set set) {
            super(TemporalQueries.zone(), "ZoneText(" + textStyle + ")");
            this.cachedTree = new HashMap();
            this.cachedTreeCI = new HashMap();
            Objects.requireNonNull(textStyle, "textStyle");
            this.textStyle = textStyle;
            if (set == null || set.size() == 0) {
                return;
            }
            this.preferredZones = new HashSet();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                this.preferredZones.add(((ZoneId) it.next()).getId());
            }
        }

        private String getDisplayName(String str, int r14, Locale locale) {
            String[] strArr;
            Map map = null;
            if (this.textStyle == TextStyle.NARROW) {
                return null;
            }
            Map map2 = cache;
            SoftReference softReference = (SoftReference) map2.get(str);
            if (softReference == null || (map = (Map) softReference.get()) == null || (strArr = (String[]) map.get(locale)) == null) {
                TimeZone timeZone = TimeZone.getTimeZone(str);
                strArr = new String[]{str, timeZone.getDisplayName(false, 1, locale), timeZone.getDisplayName(false, 0, locale), timeZone.getDisplayName(true, 1, locale), timeZone.getDisplayName(true, 0, locale), str, str};
                if (map == null) {
                    map = new ConcurrentHashMap();
                }
                map.put(locale, strArr);
                map2.put(str, new SoftReference(map));
            }
            int zoneNameStyleIndex = this.textStyle.zoneNameStyleIndex();
            return r14 != 0 ? r14 != 1 ? strArr[zoneNameStyleIndex + 5] : strArr[zoneNameStyleIndex + 3] : strArr[zoneNameStyleIndex + 1];
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser, j$.time.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean format(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.getValue(TemporalQueries.zoneId());
            int r1 = 0;
            if (zoneId == null) {
                return false;
            }
            String id = zoneId.getId();
            if (!(zoneId instanceof ZoneOffset)) {
                TemporalAccessor temporal = dateTimePrintContext.getTemporal();
                if (!temporal.isSupported(ChronoField.INSTANT_SECONDS)) {
                    r1 = 2;
                } else if (zoneId.getRules().isDaylightSavings(Instant.from(temporal))) {
                    r1 = 1;
                }
                String displayName = getDisplayName(id, r1, dateTimePrintContext.getLocale());
                if (displayName != null) {
                    id = displayName;
                }
            }
            sb.append(id);
            return true;
        }

        @Override // j$.time.format.DateTimeFormatterBuilder.ZoneIdPrinterParser
        protected PrefixTree getTree(DateTimeParseContext dateTimeParseContext) {
            PrefixTree newTree;
            if (this.textStyle == TextStyle.NARROW) {
                return super.getTree(dateTimeParseContext);
            }
            Locale locale = dateTimeParseContext.getLocale();
            boolean isCaseSensitive = dateTimeParseContext.isCaseSensitive();
            Set availableZoneIds = ZoneRulesProvider.getAvailableZoneIds();
            int size = availableZoneIds.size();
            Map map = isCaseSensitive ? this.cachedTree : this.cachedTreeCI;
            Map.Entry entry = (Map.Entry) map.get(locale);
            if (entry == null || ((Integer) entry.getKey()).intValue() != size || (newTree = (PrefixTree) ((SoftReference) entry.getValue()).get()) == null) {
                newTree = PrefixTree.newTree(dateTimeParseContext);
                String[][] zoneStrings = DateFormatSymbols.getInstance(locale).getZoneStrings();
                int length = zoneStrings.length;
                int r7 = 0;
                while (true) {
                    if (r7 >= length) {
                        break;
                    }
                    String[] strArr = zoneStrings[r7];
                    String str = strArr[0];
                    if (availableZoneIds.contains(str)) {
                        newTree.add(str, str);
                        String zid = ZoneName.toZid(str, locale);
                        for (int r8 = this.textStyle != TextStyle.FULL ? 2 : 1; r8 < strArr.length; r8 += 2) {
                            newTree.add(strArr[r8], zid);
                        }
                    }
                    r7++;
                }
                if (this.preferredZones != null) {
                    for (String[] strArr2 : zoneStrings) {
                        String str2 = strArr2[0];
                        if (this.preferredZones.contains(str2) && availableZoneIds.contains(str2)) {
                            for (int r12 = this.textStyle == TextStyle.FULL ? 1 : 2; r12 < strArr2.length; r12 += 2) {
                                newTree.add(strArr2[r12], str2);
                            }
                        }
                    }
                }
                map.put(locale, new AbstractMap.SimpleImmutableEntry(Integer.valueOf(size), new SoftReference(newTree)));
            }
            return newTree;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        FIELD_MAP = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.QUARTER_OF_YEAR;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put('D', ChronoField.DAY_OF_YEAR);
        hashMap.put('d', ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put('c', chronoField2);
        hashMap.put('e', chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put('N', ChronoField.NANO_OF_DAY);
        LENGTH_SORT = new Comparator() { // from class: j$.time.format.DateTimeFormatterBuilder.2
            AnonymousClass2() {
            }

            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
            }
        };
    }

    public DateTimeFormatterBuilder() {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = null;
        this.optional = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.active = this;
        this.printerParsers = new ArrayList();
        this.valueParserIndex = -1;
        this.parent = dateTimeFormatterBuilder;
        this.optional = z;
    }

    private int appendInternal(DateTimePrinterParser dateTimePrinterParser) {
        Objects.requireNonNull(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int r1 = dateTimeFormatterBuilder.padNextWidth;
        if (r1 > 0) {
            PadPrinterParserDecorator padPrinterParserDecorator = new PadPrinterParserDecorator(dateTimePrinterParser, r1, dateTimeFormatterBuilder.padNextChar);
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            dateTimeFormatterBuilder2.padNextWidth = 0;
            dateTimeFormatterBuilder2.padNextChar = (char) 0;
            dateTimePrinterParser = padPrinterParserDecorator;
        }
        this.active.printerParsers.add(dateTimePrinterParser);
        this.active.valueParserIndex = -1;
        return r4.printerParsers.size() - 1;
    }

    private DateTimeFormatterBuilder appendValue(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser withFixedWidth;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        int r1 = dateTimeFormatterBuilder.valueParserIndex;
        if (r1 >= 0) {
            NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) dateTimeFormatterBuilder.printerParsers.get(r1);
            if (numberPrinterParser.minWidth == numberPrinterParser.maxWidth && numberPrinterParser.signStyle == SignStyle.NOT_NEGATIVE) {
                withFixedWidth = numberPrinterParser2.withSubsequentWidth(numberPrinterParser.maxWidth);
                appendInternal(numberPrinterParser.withFixedWidth());
                this.active.valueParserIndex = r1;
            } else {
                withFixedWidth = numberPrinterParser2.withFixedWidth();
                this.active.valueParserIndex = appendInternal(numberPrinterParser);
            }
            this.active.printerParsers.set(r1, withFixedWidth);
        } else {
            dateTimeFormatterBuilder.valueParserIndex = appendInternal(numberPrinterParser);
        }
        return this;
    }

    public static /* synthetic */ ZoneId lambda$static$0(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.query(TemporalQueries.zoneId());
        if (zoneId == null || (zoneId instanceof ZoneOffset)) {
            return null;
        }
        return zoneId;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:            if (r10 == 1) goto L153;     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0030. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:23:0x0036. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseField(char r9, int r10, j$.time.temporal.TemporalField r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.DateTimeFormatterBuilder.parseField(char, int, j$.time.temporal.TemporalField):void");
    }

    private void parsePattern(String str) {
        WeekBasedFieldPrinterParser weekBasedFieldPrinterParser;
        String str2;
        String str3;
        TextStyle textStyle;
        int r4;
        int r1 = 0;
        while (r1 < str.length()) {
            char charAt = str.charAt(r1);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int r8 = r1 + 1;
                while (r8 < str.length() && str.charAt(r8) == charAt) {
                    r8++;
                }
                int r12 = r8 - r1;
                if (charAt == 'p') {
                    if (r8 >= str.length() || (((charAt = str.charAt(r8)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        r4 = r12;
                        r12 = 0;
                    } else {
                        int r3 = r8 + 1;
                        while (r3 < str.length() && str.charAt(r3) == charAt) {
                            r3++;
                        }
                        r4 = r3 - r8;
                        r8 = r3;
                    }
                    if (r12 == 0) {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                    padNext(r12);
                    r12 = r4;
                }
                TemporalField temporalField = (TemporalField) FIELD_MAP.get(Character.valueOf(charAt));
                if (temporalField != null) {
                    parseField(charAt, r12, temporalField);
                } else if (charAt == 'z') {
                    if (r12 > 4) {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    }
                    appendZoneText(r12 == 4 ? TextStyle.FULL : TextStyle.SHORT);
                } else if (charAt != 'V') {
                    String str4 = "+0000";
                    if (charAt == 'Z') {
                        if (r12 < 4) {
                            str2 = "+HHMM";
                            appendOffset(str2, str4);
                        } else {
                            if (r12 != 4) {
                                if (r12 != 5) {
                                    throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                                }
                                str3 = "+HH:MM:ss";
                                appendOffset(str3, "Z");
                            }
                            textStyle = TextStyle.FULL;
                            appendLocalizedOffset(textStyle);
                        }
                    } else if (charAt == 'O') {
                        if (r12 == 1) {
                            textStyle = TextStyle.SHORT;
                            appendLocalizedOffset(textStyle);
                        } else {
                            if (r12 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + charAt);
                            }
                            textStyle = TextStyle.FULL;
                            appendLocalizedOffset(textStyle);
                        }
                    } else if (charAt == 'X') {
                        if (r12 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        str3 = OffsetIdPrinterParser.PATTERNS[r12 + (r12 == 1 ? 0 : 1)];
                        appendOffset(str3, "Z");
                    } else if (charAt != 'x') {
                        if (charAt == 'W') {
                            if (r12 > 1) {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(charAt, r12);
                        } else if (charAt == 'w') {
                            if (r12 > 2) {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(charAt, r12);
                        } else {
                            if (charAt != 'Y') {
                                throw new IllegalArgumentException("Unknown pattern letter: " + charAt);
                            }
                            weekBasedFieldPrinterParser = new WeekBasedFieldPrinterParser(charAt, r12);
                        }
                        appendInternal(weekBasedFieldPrinterParser);
                    } else {
                        if (r12 > 5) {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                        if (r12 == 1) {
                            str4 = "+00";
                        } else if (r12 % 2 != 0) {
                            str4 = "+00:00";
                        }
                        str2 = OffsetIdPrinterParser.PATTERNS[r12 + (r12 == 1 ? 0 : 1)];
                        appendOffset(str2, str4);
                    }
                } else {
                    if (r12 != 2) {
                        throw new IllegalArgumentException("Pattern letter count must be 2: " + charAt);
                    }
                    appendZoneId();
                }
                r1 = r8 - 1;
            } else if (charAt == '\'') {
                int r13 = r1 + 1;
                int r2 = r13;
                while (r2 < str.length()) {
                    if (str.charAt(r2) == '\'') {
                        int r5 = r2 + 1;
                        if (r5 >= str.length() || str.charAt(r5) != '\'') {
                            break;
                        } else {
                            r2 = r5;
                        }
                    }
                    r2++;
                }
                if (r2 >= str.length()) {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
                String substring = str.substring(r13, r2);
                if (substring.length() == 0) {
                    appendLiteral('\'');
                } else {
                    appendLiteral(substring.replace("''", "'"));
                }
                r1 = r2;
            } else if (charAt == '[') {
                optionalStart();
            } else if (charAt == ']') {
                if (this.active.parent == null) {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
                optionalEnd();
            } else {
                if (charAt == '{' || charAt == '}' || charAt == '#') {
                    throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
                }
                appendLiteral(charAt);
            }
            r1++;
        }
    }

    private DateTimeFormatter toFormatter(Locale locale, ResolverStyle resolverStyle, Chronology chronology) {
        Objects.requireNonNull(locale, "locale");
        while (this.active.parent != null) {
            optionalEnd();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.printerParsers, false), locale, DecimalStyle.STANDARD, resolverStyle, null, chronology, null);
    }

    public DateTimeFormatterBuilder append(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        appendInternal(dateTimeFormatter.toPrinterParser(false));
        return this;
    }

    public DateTimeFormatterBuilder appendFraction(TemporalField temporalField, int r3, int r4, boolean z) {
        appendInternal(new FractionPrinterParser(temporalField, r3, r4, z));
        return this;
    }

    public DateTimeFormatterBuilder appendInstant() {
        appendInternal(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(char c) {
        appendInternal(new CharLiteralPrinterParser(c));
        return this;
    }

    public DateTimeFormatterBuilder appendLiteral(String str) {
        Objects.requireNonNull(str, "literal");
        if (str.length() > 0) {
            appendInternal(str.length() == 1 ? new CharLiteralPrinterParser(str.charAt(0)) : new StringLiteralPrinterParser(str));
        }
        return this;
    }

    public DateTimeFormatterBuilder appendLocalizedOffset(TextStyle textStyle) {
        Objects.requireNonNull(textStyle, "style");
        if (textStyle != TextStyle.FULL && textStyle != TextStyle.SHORT) {
            throw new IllegalArgumentException("Style must be either full or short");
        }
        appendInternal(new LocalizedOffsetIdPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder appendOffset(String str, String str2) {
        appendInternal(new OffsetIdPrinterParser(str, str2));
        return this;
    }

    public DateTimeFormatterBuilder appendOffsetId() {
        appendInternal(OffsetIdPrinterParser.INSTANCE_ID_Z);
        return this;
    }

    public DateTimeFormatterBuilder appendPattern(String str) {
        Objects.requireNonNull(str, "pattern");
        parsePattern(str);
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, TextStyle textStyle) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(textStyle, "textStyle");
        appendInternal(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.getInstance()));
        return this;
    }

    public DateTimeFormatterBuilder appendText(TemporalField temporalField, Map<Long, String> map) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        appendInternal(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() { // from class: j$.time.format.DateTimeFormatterBuilder.1
            final /* synthetic */ DateTimeTextProvider.LocaleStore val$store;

            AnonymousClass1(DateTimeTextProvider.LocaleStore localeStore) {
                r2 = localeStore;
            }

            @Override // j$.time.format.DateTimeTextProvider
            public String getText(TemporalField temporalField2, long j, TextStyle textStyle2, Locale locale) {
                return r2.getText(j, textStyle2);
            }

            @Override // j$.time.format.DateTimeTextProvider
            public Iterator getTextIterator(TemporalField temporalField2, TextStyle textStyle2, Locale locale) {
                return r2.getTextIterator(textStyle2);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField) {
        Objects.requireNonNull(temporalField, "field");
        appendValue(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int r4) {
        Objects.requireNonNull(temporalField, "field");
        if (r4 >= 1 && r4 <= 19) {
            appendValue(new NumberPrinterParser(temporalField, r4, r4, SignStyle.NOT_NEGATIVE));
            return this;
        }
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + r4);
    }

    public DateTimeFormatterBuilder appendValue(TemporalField temporalField, int r4, int r5, SignStyle signStyle) {
        if (r4 == r5 && signStyle == SignStyle.NOT_NEGATIVE) {
            return appendValue(temporalField, r5);
        }
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(signStyle, "signStyle");
        if (r4 < 1 || r4 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + r4);
        }
        if (r5 < 1 || r5 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + r5);
        }
        if (r5 >= r4) {
            appendValue(new NumberPrinterParser(temporalField, r4, r5, signStyle));
            return this;
        }
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + r5 + " < " + r4);
    }

    public DateTimeFormatterBuilder appendValueReduced(TemporalField temporalField, int r9, int r10, ChronoLocalDate chronoLocalDate) {
        Objects.requireNonNull(temporalField, "field");
        Objects.requireNonNull(chronoLocalDate, "baseDate");
        appendValue(new ReducedPrinterParser(temporalField, r9, r10, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneId() {
        appendInternal(new ZoneIdPrinterParser(TemporalQueries.zoneId(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneRegionId() {
        appendInternal(new ZoneIdPrinterParser(QUERY_REGION_ONLY, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        appendInternal(new ZoneTextPrinterParser(textStyle, null));
        return this;
    }

    public DateTimeFormatterBuilder optionalEnd() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        if (dateTimeFormatterBuilder.parent == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (dateTimeFormatterBuilder.printerParsers.size() > 0) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.active;
            CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.printerParsers, dateTimeFormatterBuilder2.optional);
            this.active = this.active.parent;
            appendInternal(compositePrinterParser);
        } else {
            this.active = this.active.parent;
        }
        return this;
    }

    public DateTimeFormatterBuilder optionalStart() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        this.active = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder padNext(int r2) {
        return padNext(r2, ' ');
    }

    public DateTimeFormatterBuilder padNext(int r3, char c) {
        if (r3 < 1) {
            throw new IllegalArgumentException("The pad width must be at least one but was " + r3);
        }
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.active;
        dateTimeFormatterBuilder.padNextWidth = r3;
        dateTimeFormatterBuilder.padNextChar = c;
        dateTimeFormatterBuilder.valueParserIndex = -1;
        return this;
    }

    public DateTimeFormatterBuilder parseCaseInsensitive() {
        appendInternal(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseCaseSensitive() {
        appendInternal(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder parseLenient() {
        appendInternal(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault());
    }

    public DateTimeFormatter toFormatter(ResolverStyle resolverStyle, Chronology chronology) {
        return toFormatter(Locale.getDefault(), resolverStyle, chronology);
    }

    public DateTimeFormatter toFormatter(Locale locale) {
        return toFormatter(locale, ResolverStyle.SMART, null);
    }
}
