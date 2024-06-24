package aws.smithy.kotlin.runtime.tracing;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextUtils.kt */
/* loaded from: classes.dex */
public final class WrappedRootSpan implements TraceSpan {
    public final TraceSpan parent;
    public final TraceSpan rootSpan;

    public WrappedRootSpan(TraceSpan traceSpan, TraceSpan traceSpan2) {
        this.rootSpan = traceSpan;
        this.parent = traceSpan2;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan child(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this.rootSpan.child(id);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.rootSpan.close();
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final String getId() {
        return this.rootSpan.getId();
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan getParent() {
        return this.parent;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final void postEvent(TraceEvent traceEvent) {
        this.rootSpan.postEvent(traceEvent);
    }
}
