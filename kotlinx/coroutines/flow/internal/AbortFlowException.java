package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: FlowExceptions.kt */
/* loaded from: classes4.dex */
public final class AbortFlowException extends CancellationException {
    public final transient FlowCollector<?> owner;

    public AbortFlowException(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.owner = flowCollector;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
