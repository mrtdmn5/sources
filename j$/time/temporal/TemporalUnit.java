package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
public interface TemporalUnit {
    Temporal addTo(Temporal temporal, long j);

    long between(Temporal temporal, Temporal temporal2);

    Duration getDuration();

    boolean isDateBased();

    boolean isTimeBased();
}
