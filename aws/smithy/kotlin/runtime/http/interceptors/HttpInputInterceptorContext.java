package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.RequestInterceptorContext;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class HttpInputInterceptorContext<I> implements RequestInterceptorContext<I> {
    public final ExecutionContext executionContext;
    public I request;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpInputInterceptorContext(ExecutionContext executionContext, Object obj) {
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = obj;
        this.executionContext = executionContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpInputInterceptorContext)) {
            return false;
        }
        HttpInputInterceptorContext httpInputInterceptorContext = (HttpInputInterceptorContext) obj;
        if (Intrinsics.areEqual(this.request, httpInputInterceptorContext.request) && Intrinsics.areEqual(this.executionContext, httpInputInterceptorContext.executionContext)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public final ExecutionContext getExecutionContext() {
        throw null;
    }

    public final int hashCode() {
        int hashCode;
        I r0 = this.request;
        if (r0 == null) {
            hashCode = 0;
        } else {
            hashCode = r0.hashCode();
        }
        return this.executionContext.hashCode() + (hashCode * 31);
    }

    public final String toString() {
        return "HttpInputInterceptorContext(request=" + this.request + ", executionContext=" + this.executionContext + ')';
    }
}
