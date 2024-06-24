package j$.time;

import com.animaconnected.dfu.dfu.utils.DfuConstants;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class LocalTime implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    private static final LocalTime[] HOURS = new LocalTime[24];
    public static final LocalTime MAX;
    public static final LocalTime MIDNIGHT;
    public static final LocalTime MIN;
    public static final LocalTime NOON;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j$.time.LocalTime$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = r0;
            try {
                r0[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] r7 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = r7;
            try {
                r7[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.AMPM_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int r1 = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (r1 >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                NOON = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, 999999999);
                return;
            }
            localTimeArr[r1] = new LocalTime(r1, 0, 0, 0);
            r1++;
        }
    }

    private LocalTime(int r1, int r2, int r3, int r4) {
        this.hour = (byte) r1;
        this.minute = (byte) r2;
        this.second = (byte) r3;
        this.nano = r4;
    }

    private static LocalTime create(int r1, int r2, int r3, int r4) {
        return ((r2 | r3) | r4) == 0 ? HOURS[r1] : new LocalTime(r1, r2, r3, r4);
    }

    public static LocalTime from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalTime localTime = (LocalTime) temporalAccessor.query(TemporalQueries.localTime());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new UnsupportedTemporalTypeException("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.nano / 1000;
            case 4:
                throw new UnsupportedTemporalTypeException("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / 1000000);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int r5 = this.hour % 12;
                if (r5 % 12 == 0) {
                    return 12;
                }
                return r5;
            case 13:
                return this.hour;
            case 14:
                byte b = this.hour;
                if (b == 0) {
                    return 24;
                }
                return b;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public static LocalTime of(int r3, int r4) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r3);
        if (r4 == 0) {
            return HOURS[r3];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        return new LocalTime(r3, r4, 0, 0);
    }

    public static LocalTime of(int r3, int r4, int r5, int r6) {
        ChronoField.HOUR_OF_DAY.checkValidValue(r3);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r5);
        ChronoField.NANO_OF_SECOND.checkValidValue(r6);
        return create(r3, r4, r5, r6);
    }

    public static LocalTime ofNanoOfDay(long j) {
        ChronoField.NANO_OF_DAY.checkValidValue(j);
        int r2 = (int) (j / 3600000000000L);
        long j2 = j - (r2 * 3600000000000L);
        int r3 = (int) (j2 / 60000000000L);
        long j3 = j2 - (r3 * 60000000000L);
        int r4 = (int) (j3 / 1000000000);
        return create(r2, r3, r4, (int) (j3 - (r4 * 1000000000)));
    }

    public static LocalTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: j$.time.LocalTime$$ExternalSyntheticLambda0
            @Override // j$.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalTime.from(temporalAccessor);
            }
        });
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime localTime) {
        int compare = Integer.compare(this.hour, localTime.hour);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Integer.compare(this.minute, localTime.minute);
        if (compare2 != 0) {
            return compare2;
        }
        int compare3 = Integer.compare(this.second, localTime.second);
        return compare3 == 0 ? Integer.compare(this.nano, localTime.nano) : compare3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.NANO_OF_DAY ? toNanoOfDay() : temporalField == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : get0(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isTimeBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    @Override // j$.time.temporal.Temporal
    public LocalTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.addTo(this, j);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plusNanos((j % 86400000000L) * 1000);
            case 3:
                return plusNanos((j % 86400000) * 1000000);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusMinutes(j);
            case 6:
                return plusHours(j);
            case 7:
                return plusHours((j % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime plusHours(long j) {
        return j == 0 ? this : create(((((int) (j % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j) {
        if (j == 0) {
            return this;
        }
        int r0 = (this.hour * 60) + this.minute;
        int r4 = ((((int) (j % 1440)) + r0) + 1440) % 1440;
        return r0 == r4 ? this : create(r4 / 60, r4 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j) {
        if (j == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j2 = (((j % 86400000000000L) + nanoOfDay) + 86400000000000L) % 86400000000000L;
        return nanoOfDay == j2 ? this : create((int) (j2 / 3600000000000L), (int) ((j2 / 60000000000L) % 60), (int) ((j2 / 1000000000) % 60), (int) (j2 % 1000000000));
    }

    public LocalTime plusSeconds(long j) {
        if (j == 0) {
            return this;
        }
        int r0 = (this.hour * DfuConstants.OpResponse) + (this.minute * 60) + this.second;
        int r4 = ((((int) (j % 86400)) + r0) + 86400) % 86400;
        return r0 == r4 ? this : create(r4 / 3600, (r4 / 60) % 60, r4 % 60, this.nano);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.chronology() || temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset()) {
            return null;
        }
        if (temporalQuery == TemporalQueries.localTime()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.localDate()) {
            return null;
        }
        return temporalQuery == TemporalQueries.precision() ? ChronoUnit.NANOS : temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return super.range(temporalField);
    }

    public long toNanoOfDay() {
        return (this.hour * 3600000000000L) + (this.minute * 60000000000L) + (this.second * 1000000000) + this.nano;
    }

    public int toSecondOfDay() {
        return (this.hour * DfuConstants.OpResponse) + (this.minute * 60) + this.second;
    }

    public String toString() {
        int r4;
        StringBuilder sb = new StringBuilder(18);
        byte b = this.hour;
        byte b2 = this.minute;
        byte b3 = this.second;
        int r42 = this.nano;
        sb.append(b < 10 ? "0" : "");
        sb.append((int) b);
        sb.append(b2 < 10 ? ":0" : ":");
        sb.append((int) b2);
        if (b3 > 0 || r42 > 0) {
            sb.append(b3 >= 10 ? ":" : ":0");
            sb.append((int) b3);
            if (r42 > 0) {
                sb.append('.');
                int r1 = 1000000;
                if (r42 % 1000000 == 0) {
                    r4 = (r42 / 1000000) + 1000;
                } else {
                    if (r42 % 1000 == 0) {
                        r42 /= 1000;
                    } else {
                        r1 = 1000000000;
                    }
                    r4 = r42 + r1;
                }
                sb.append(Integer.toString(r4).substring(1));
            }
        }
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long j;
        LocalTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        long nanoOfDay = from.toNanoOfDay() - toNanoOfDay();
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return nanoOfDay;
            case 2:
                j = 1000;
                break;
            case 3:
                j = 1000000;
                break;
            case 4:
                j = 1000000000;
                break;
            case 5:
                j = 60000000000L;
                break;
            case 6:
                j = 3600000000000L;
                break;
            case 7:
                j = 43200000000000L;
                break;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return nanoOfDay / j;
    }

    @Override // j$.time.temporal.Temporal
    public LocalTime with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalTime ? (LocalTime) temporalAdjuster : (LocalTime) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public LocalTime with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j);
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
                return withNano((int) j);
            case 2:
                return ofNanoOfDay(j);
            case 3:
                return withNano(((int) j) * 1000);
            case 4:
                return ofNanoOfDay(j * 1000);
            case 5:
                return withNano(((int) j) * 1000000);
            case 6:
                return ofNanoOfDay(j * 1000000);
            case 7:
                return withSecond((int) j);
            case 8:
                return plusSeconds(j - toSecondOfDay());
            case 9:
                return withMinute((int) j);
            case 10:
                return plusMinutes(j - ((this.hour * 60) + this.minute));
            case 11:
                return plusHours(j - (this.hour % 12));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return plusHours(j - (this.hour % 12));
            case 13:
                return withHour((int) j);
            case 14:
                if (j == 24) {
                    j = 0;
                }
                return withHour((int) j);
            case 15:
                return plusHours((j - (this.hour / 12)) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public LocalTime withHour(int r4) {
        if (this.hour == r4) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue(r4);
        return create(r4, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int r4) {
        if (this.minute == r4) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(r4);
        return create(this.hour, r4, this.second, this.nano);
    }

    public LocalTime withNano(int r4) {
        if (this.nano == r4) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue(r4);
        return create(this.hour, this.minute, this.second, r4);
    }

    public LocalTime withSecond(int r4) {
        if (this.second == r4) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue(r4);
        return create(this.hour, this.minute, r4, this.nano);
    }
}
