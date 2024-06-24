package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilderView;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class HttpProtocolRequestInterceptorContext<I> implements ProtocolRequestInterceptorContext<I, HttpRequest> {
    public final ExecutionContext executionContext;
    public HttpRequest protocolRequest;
    public final I request;

    /* JADX WARN: Multi-variable type inference failed */
    public HttpProtocolRequestInterceptorContext(Object obj, HttpRequestBuilderView protocolRequest, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = obj;
        this.protocolRequest = protocolRequest;
        this.executionContext = executionContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolRequestInterceptorContext)) {
            return false;
        }
        HttpProtocolRequestInterceptorContext httpProtocolRequestInterceptorContext = (HttpProtocolRequestInterceptorContext) obj;
        if (Intrinsics.areEqual(this.request, httpProtocolRequestInterceptorContext.request) && Intrinsics.areEqual(this.protocolRequest, httpProtocolRequestInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.executionContext, httpProtocolRequestInterceptorContext.executionContext)) {
            return true;
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.client.RequestInterceptorContext
    public final ExecutionContext getExecutionContext() {
        return this.executionContext;
    }

    @Override // aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext
    public final HttpRequest getProtocolRequest() {
        return this.protocolRequest;
    }

    public final int hashCode() {
        int hashCode;
        I r0 = this.request;
        if (r0 == null) {
            hashCode = 0;
        } else {
            hashCode = r0.hashCode();
        }
        return this.executionContext.hashCode() + ((this.protocolRequest.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "HttpProtocolRequestInterceptorContext(request=" + this.request + ", protocolRequest=" + this.protocolRequest + ", executionContext=" + this.executionContext + ')';
    }
}
