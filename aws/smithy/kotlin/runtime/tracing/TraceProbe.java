package aws.smithy.kotlin.runtime.tracing;

/* compiled from: TraceProbe.kt */
/* loaded from: classes.dex */
public interface TraceProbe {
    void postEvent(TraceSpan traceSpan, TraceEvent traceEvent);

    void spanClosed(TraceSpan traceSpan);
}
