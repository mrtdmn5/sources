package aws.smithy.kotlin.runtime.retries.delay;

import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: ExponentialBackoffWithJitter.kt */
/* loaded from: classes.dex */
public final class ExponentialBackoffWithJitterOptions {
    public static final ExponentialBackoffWithJitterOptions Default;
    public final long initialDelay;
    public final long maxBackoff;
    public final double scaleFactor = 1.5d;
    public final double jitter = 1.0d;

    static {
        int r1 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.MILLISECONDS;
        Default = new ExponentialBackoffWithJitterOptions(DurationKt.toDuration(10, durationUnit), DurationKt.toDuration(20000, durationUnit));
    }

    public ExponentialBackoffWithJitterOptions(long j, long j2) {
        boolean z;
        this.initialDelay = j;
        this.maxBackoff = j2;
        if (j > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!Duration.m1685isNegativeimpl(j2)) {
                return;
            } else {
                throw new IllegalArgumentException("maxBackoffMs must be at least 0".toString());
            }
        }
        throw new IllegalArgumentException("initialDelayMs must be at least 0".toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExponentialBackoffWithJitterOptions)) {
            return false;
        }
        ExponentialBackoffWithJitterOptions exponentialBackoffWithJitterOptions = (ExponentialBackoffWithJitterOptions) obj;
        if (Duration.m1675equalsimpl0(this.initialDelay, exponentialBackoffWithJitterOptions.initialDelay) && Double.compare(this.scaleFactor, exponentialBackoffWithJitterOptions.scaleFactor) == 0 && Double.compare(this.jitter, exponentialBackoffWithJitterOptions.jitter) == 0 && Duration.m1675equalsimpl0(this.maxBackoff, exponentialBackoffWithJitterOptions.maxBackoff)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Duration.$r8$clinit;
        return Long.hashCode(this.maxBackoff) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.jitter, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.scaleFactor, Long.hashCode(this.initialDelay) * 31, 31), 31);
    }

    public final String toString() {
        return "ExponentialBackoffWithJitterOptions(initialDelay=" + ((Object) Duration.m1690toStringimpl(this.initialDelay)) + ", scaleFactor=" + this.scaleFactor + ", jitter=" + this.jitter + ", maxBackoff=" + ((Object) Duration.m1690toStringimpl(this.maxBackoff)) + ')';
    }
}
