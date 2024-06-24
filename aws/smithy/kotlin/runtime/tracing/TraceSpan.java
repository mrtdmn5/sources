package aws.smithy.kotlin.runtime.tracing;

import java.io.Closeable;

/* compiled from: TraceSpan.kt */
/* loaded from: classes.dex */
public interface TraceSpan extends Closeable {
    TraceSpan child(String str);

    String getId();

    TraceSpan getParent();

    void postEvent(TraceEvent traceEvent);
}
