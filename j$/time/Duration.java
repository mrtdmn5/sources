package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class Duration implements TemporalAmount, Comparable<Duration>, Serializable {
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(1000000000);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    private Duration(long j, int r3) {
        this.seconds = j;
        this.nanos = r3;
    }

    private static Duration create(long j, int r6) {
        return (((long) r6) | j) == 0 ? ZERO : new Duration(j, r6);
    }

    public static Duration ofMillis(long j) {
        long j2 = j / 1000;
        int r4 = (int) (j % 1000);
        if (r4 < 0) {
            r4 += 1000;
            j2--;
        }
        return create(j2, r4 * 1000000);
    }

    public static Duration ofNanos(long j) {
        long j2 = j / 1000000000;
        int r4 = (int) (j % 1000000000);
        if (r4 < 0) {
            r4 = (int) (r4 + 1000000000);
            j2--;
        }
        return create(j2, r4);
    }

    public static Duration ofSeconds(long j) {
        return create(j, 0);
    }

    public static Duration ofSeconds(long j, long j2) {
        return create(Math.addExact(j, Math.floorDiv(j2, 1000000000L)), (int) Math.floorMod(j2, 1000000000L));
    }

    @Override // j$.time.temporal.TemporalAmount
    public Temporal addTo(Temporal temporal) {
        long j = this.seconds;
        if (j != 0) {
            temporal = temporal.plus(j, ChronoUnit.SECONDS);
        }
        int r0 = this.nanos;
        return r0 != 0 ? temporal.plus(r0, ChronoUnit.NANOS) : temporal;
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int compare = Long.compare(this.seconds, duration.seconds);
        return compare != 0 ? compare : this.nanos - duration.nanos;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j = this.seconds;
        return ((int) (j ^ (j >>> 32))) + (this.nanos * 51);
    }

    public long toMillis() {
        return Math.addExact(Math.multiplyExact(this.seconds, 1000L), this.nanos / 1000000);
    }

    public long toNanos() {
        return Math.addExact(Math.multiplyExact(this.seconds, 1000000000L), this.nanos);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j = this.seconds;
        long j2 = j / 3600;
        int r2 = (int) ((j % 3600) / 60);
        int r0 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (r2 != 0) {
            sb.append(r2);
            sb.append('M');
        }
        if (r0 == 0 && this.nanos == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (r0 >= 0 || this.nanos <= 0) {
            sb.append(r0);
        } else if (r0 == -1) {
            sb.append("-0");
        } else {
            sb.append(r0 + 1);
        }
        if (this.nanos > 0) {
            int length = sb.length();
            if (r0 < 0) {
                sb.append(2000000000 - this.nanos);
            } else {
                sb.append(this.nanos + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
