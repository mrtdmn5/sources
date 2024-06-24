package aws.smithy.kotlin.runtime.tracing;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoOpTraceSpan.kt */
/* loaded from: classes.dex */
public final class NoOpTraceSpanImpl implements TraceSpan {
    public final String id = "no-op";
    public final NoOpTraceSpanImpl parent = this;

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan child(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoOpTraceSpanImpl)) {
            return false;
        }
        if (Intrinsics.areEqual(this.id, ((NoOpTraceSpanImpl) obj).id)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final String getId() {
        return this.id;
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final TraceSpan getParent() {
        return this.parent;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("NoOpTraceSpanImpl(id="), this.id, ')');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // aws.smithy.kotlin.runtime.tracing.TraceSpan
    public final void postEvent(TraceEvent traceEvent) {
    }
}
