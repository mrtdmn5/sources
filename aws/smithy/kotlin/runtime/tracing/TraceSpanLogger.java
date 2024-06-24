package aws.smithy.kotlin.runtime.tracing;

import aws.smithy.kotlin.runtime.logging.Logger;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.tracing.TraceEventData;
import j$.time.format.DateTimeFormatter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceSpanExt.kt */
/* loaded from: classes.dex */
public final class TraceSpanLogger implements Logger {
    public final String sourceComponent;
    public final TraceSpan span;

    public TraceSpanLogger(TraceSpan span, String str) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.span = span;
        this.sourceComponent = str;
    }

    @Override // aws.smithy.kotlin.runtime.logging.Logger
    public final void debug(Function0<? extends Object> function0) {
        log(EventLevel.Debug, null, function0);
    }

    public final void log(EventLevel level, Throwable th, Function0<? extends Object> msg) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(msg, "msg");
        DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
        this.span.postEvent(new TraceEvent(level, this.sourceComponent, Instant.Companion.now(), new TraceEventData.Message(th, msg)));
    }

    public final void trace(Function0<? extends Object> msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        log(EventLevel.Trace, null, msg);
    }
}
