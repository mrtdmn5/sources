package aws.smithy.kotlin.runtime.tracing;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTracer.kt */
/* loaded from: classes.dex */
public final class DefaultTraceSpan implements TraceSpan {
    public final String id;
    public final TraceSpan parent;
    public final TraceProbe probe;

    public DefaultTraceSpan(TraceProbe probe, TraceSpan traceSpan, String id) {
        Intrinsics.checkNotNullParameter(probe, "probe");
        Intrinsics.checkNotNullParameter(id, "id");
        this.probe = probe;
        this.parent = traceSpan;
        this.id = id;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan child(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new DefaultTraceSpan(this.probe, this, id);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.probe.spanClosed(this);
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final String getId() {
        return this.id;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan getParent() {
        return this.parent;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final void postEvent(TraceEvent traceEvent) {
        this.probe.postEvent(this, traceEvent);
    }
}
