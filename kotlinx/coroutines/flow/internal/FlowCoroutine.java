package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: FlowCoroutine.kt */
/* loaded from: classes4.dex */
public final class FlowCoroutine<T> extends ScopeCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean childCancelled(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th);
    }
}
