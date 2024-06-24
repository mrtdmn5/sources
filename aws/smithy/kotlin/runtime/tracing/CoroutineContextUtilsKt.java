package aws.smithy.kotlin.runtime.tracing;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextUtils.kt */
/* loaded from: classes.dex */
public final class CoroutineContextUtilsKt {
    public static final TraceSpan getTraceSpan(CoroutineContext coroutineContext) {
        TraceSpan traceSpan;
        Intrinsics.checkNotNullParameter(coroutineContext, "<this>");
        TraceSpanContextElement traceSpanContextElement = (TraceSpanContextElement) coroutineContext.get(TraceSpanContextElement.Companion);
        if (traceSpanContextElement == null || (traceSpan = traceSpanContextElement.traceSpan) == null) {
            return NoOpTraceSpanKt.NoOpTraceSpan;
        }
        return traceSpan;
    }
}
