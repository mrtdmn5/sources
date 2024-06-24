package aws.smithy.kotlin.runtime.tracing;

import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.tracing.TraceEventData;
import j$.time.format.DateTimeFormatter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraceSpanExt.kt */
/* loaded from: classes.dex */
public final class TraceSpanExtKt {
    public static final void log(TraceSpan traceSpan, EventLevel level, String str, Function0 content) {
        Intrinsics.checkNotNullParameter(traceSpan, "<this>");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(content, "content");
        DateTimeFormatter dateTimeFormatter = Instant.RFC_5322_FIXED_DATE_TIME;
        traceSpan.postEvent(new TraceEvent(level, str, Instant.Companion.now(), new TraceEventData.Message(null, content)));
    }
}
