package aws.smithy.kotlin.runtime.time;

import aws.smithy.kotlin.runtime.time.Instant;
import j$.time.format.DateTimeFormatter;

/* compiled from: Clock.kt */
/* loaded from: classes.dex */
public interface Clock {

    /* compiled from: Clock.kt */
    /* loaded from: classes.dex */
    public static final class System implements Clock {
        public static final System INSTANCE = new System();

        @Override // aws.smithy.kotlin.runtime.time.Clock
        public final Instant now() {
            DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
            return Instant.Companion.now();
        }
    }

    Instant now();
}
