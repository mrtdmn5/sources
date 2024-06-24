package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ChronoZonedDateTimeImpl implements ChronoZonedDateTime, Serializable {
    private final transient ChronoLocalDateTimeImpl dateTime;
    private final transient ZoneOffset offset;
    private final transient ZoneId zone;

    /* renamed from: j$.time.chrono.ChronoZonedDateTimeImpl$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = r0;
            try {
                r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        Objects.requireNonNull(chronoLocalDateTimeImpl, "dateTime");
        this.dateTime = chronoLocalDateTimeImpl;
        Objects.requireNonNull(zoneOffset, "offset");
        this.offset = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.zone = zoneId;
    }

    private ChronoZonedDateTimeImpl create(Instant instant, ZoneId zoneId) {
        return ofInstant(getChronology(), instant, zoneId);
    }

    public static ChronoZonedDateTimeImpl ensureValid(Chronology chronology, Temporal temporal) {
        ChronoZonedDateTimeImpl chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (chronology.equals(chronoZonedDateTimeImpl.getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chronology mismatch, required: " + chronology.getId() + ", actual: " + chronoZonedDateTimeImpl.getChronology().getId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:            if (r2.contains(r8) != false) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static j$.time.chrono.ChronoZonedDateTime ofBest(j$.time.chrono.ChronoLocalDateTimeImpl r6, j$.time.ZoneId r7, j$.time.ZoneOffset r8) {
        /*
            java.lang.String r0 = "localDateTime"
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.String r0 = "zone"
            java.util.Objects.requireNonNull(r7, r0)
            boolean r0 = r7 instanceof j$.time.ZoneOffset
            if (r0 == 0) goto L17
            j$.time.chrono.ChronoZonedDateTimeImpl r8 = new j$.time.chrono.ChronoZonedDateTimeImpl
            r0 = r7
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            r8.<init>(r6, r0, r7)
            return r8
        L17:
            j$.time.zone.ZoneRules r0 = r7.getRules()
            j$.time.LocalDateTime r1 = j$.time.LocalDateTime.from(r6)
            java.util.List r2 = r0.getValidOffsets(r1)
            int r3 = r2.size()
            r4 = 1
            r5 = 0
            if (r3 != r4) goto L32
        L2b:
            java.lang.Object r8 = r2.get(r5)
            j$.time.ZoneOffset r8 = (j$.time.ZoneOffset) r8
            goto L55
        L32:
            int r3 = r2.size()
            if (r3 != 0) goto L4d
            j$.time.zone.ZoneOffsetTransition r8 = r0.getTransition(r1)
            j$.time.Duration r0 = r8.getDuration()
            long r0 = r0.getSeconds()
            j$.time.chrono.ChronoLocalDateTimeImpl r6 = r6.plusSeconds(r0)
            j$.time.ZoneOffset r8 = r8.getOffsetAfter()
            goto L55
        L4d:
            if (r8 == 0) goto L2b
            boolean r0 = r2.contains(r8)
            if (r0 == 0) goto L2b
        L55:
            java.lang.String r0 = "offset"
            java.util.Objects.requireNonNull(r8, r0)
            j$.time.chrono.ChronoZonedDateTimeImpl r0 = new j$.time.chrono.ChronoZonedDateTimeImpl
            r0.<init>(r6, r8, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.ChronoZonedDateTimeImpl.ofBest(j$.time.chrono.ChronoLocalDateTimeImpl, j$.time.ZoneId, j$.time.ZoneOffset):j$.time.chrono.ChronoZonedDateTime");
    }

    public static ChronoZonedDateTimeImpl ofInstant(Chronology chronology, Instant instant, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        Objects.requireNonNull(offset, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) chronology.localDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset)), offset, zoneId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && compareTo2((ChronoZonedDateTime) obj) == 0;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public ZoneOffset getOffset() {
        return this.offset;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.Temporal
    public ChronoZonedDateTime plus(long j, TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? with((TemporalAdjuster) this.dateTime.plus(j, temporalUnit)) : ensureValid(getChronology(), temporalUnit.addTo(this, j));
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public ChronoLocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + ']';
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoZonedDateTime zonedDateTime = getChronology().zonedDateTime(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            return this.dateTime.until(zonedDateTime.withZoneSameInstant(this.offset).toLocalDateTime(), temporalUnit);
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.between(this, zonedDateTime);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime, j$.time.temporal.Temporal
    public ChronoZonedDateTime with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return ensureValid(getChronology(), temporalField.adjustInto(this, j));
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int r1 = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
        if (r1 == 1) {
            return plus(j - toEpochSecond(), (TemporalUnit) ChronoUnit.SECONDS);
        }
        if (r1 != 2) {
            return ofBest(this.dateTime.with(temporalField, j), this.zone, this.offset);
        }
        return create(this.dateTime.toInstant(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j))), this.zone);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public ChronoZonedDateTime withZoneSameInstant(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : create(this.dateTime.toInstant(this.offset), zoneId);
    }
}
