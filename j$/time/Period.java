package j$.time;

import j$.time.chrono.Chronology;
import j$.time.chrono.IsoChronology;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalQueries;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Period implements TemporalAmount, Serializable {
    private final int days;
    private final int months;
    private final int years;
    public static final Period ZERO = new Period(0, 0, 0);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    private static final List SUPPORTED_UNITS = Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));

    private Period(int r1, int r2, int r3) {
        this.years = r1;
        this.months = r2;
        this.days = r3;
    }

    private static Period create(int r1, int r2, int r3) {
        return ((r1 | r2) | r3) == 0 ? ZERO : new Period(r1, r2, r3);
    }

    public static Period ofDays(int r1) {
        return create(0, 0, r1);
    }

    private void validateChrono(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.query(TemporalQueries.chronology());
        if (chronology == null || IsoChronology.INSTANCE.equals(chronology)) {
            return;
        }
        throw new DateTimeException("Chronology mismatch, expected: ISO, actual: " + chronology.getId());
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long totalMonths;
        ChronoUnit chronoUnit;
        validateChrono(temporal);
        if (this.months == 0) {
            int r0 = this.years;
            if (r0 != 0) {
                totalMonths = r0;
                chronoUnit = ChronoUnit.YEARS;
                temporal = temporal.plus(totalMonths, chronoUnit);
            }
        } else {
            totalMonths = toTotalMonths();
            if (totalMonths != 0) {
                chronoUnit = ChronoUnit.MONTHS;
                temporal = temporal.plus(totalMonths, chronoUnit);
            }
        }
        int r02 = this.days;
        return r02 != 0 ? temporal.plus(r02, ChronoUnit.DAYS) : temporal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.years == period.years && this.months == period.months && this.days == period.days;
    }

    public int getDays() {
        return this.days;
    }

    public int hashCode() {
        return this.years + Integer.rotateLeft(this.months, 8) + Integer.rotateLeft(this.days, 16);
    }

    public boolean isZero() {
        return this == ZERO;
    }

    public String toString() {
        if (this == ZERO) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('P');
        int r1 = this.years;
        if (r1 != 0) {
            sb.append(r1);
            sb.append('Y');
        }
        int r12 = this.months;
        if (r12 != 0) {
            sb.append(r12);
            sb.append('M');
        }
        int r13 = this.days;
        if (r13 != 0) {
            sb.append(r13);
            sb.append('D');
        }
        return sb.toString();
    }

    public long toTotalMonths() {
        return (this.years * 12) + this.months;
    }
}
