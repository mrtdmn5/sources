package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class HttpProtocolResponseInterceptorContext<I> implements ProtocolRequestInterceptorContext {
    public final ExecutionContext executionContext;
    public final HttpRequest protocolRequest;
    public HttpResponse protocolResponse;
    public final I request;

    public HttpProtocolResponseInterceptorContext(I r2, HttpRequest protocolRequest, HttpResponse protocolResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(protocolResponse, "protocolResponse");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = r2;
        this.protocolRequest = protocolRequest;
        this.protocolResponse = protocolResponse;
        this.executionContext = executionContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpProtocolResponseInterceptorContext)) {
            return false;
        }
        HttpProtocolResponseInterceptorContext httpProtocolResponseInterceptorContext = (HttpProtocolResponseInterceptorContext) obj;
        if (Intrinsics.areEqual(this.request, httpProtocolResponseInterceptorContext.request) && Intrinsics.areEqual(this.protocolRequest, httpProtocolResponseInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.protocolResponse, httpProtocolResponseInterceptorContext.protocolResponse) && Intrinsics.areEqual(this.executionContext, httpProtocolResponseInterceptorContext.executionContext)) {
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
        return this.executionContext.hashCode() + ((this.protocolResponse.hashCode() + ((this.protocolRequest.hashCode() + (hashCode * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "HttpProtocolResponseInterceptorContext(request=" + this.request + ", protocolRequest=" + this.protocolRequest + ", protocolResponse=" + this.protocolResponse + ", executionContext=" + this.executionContext + ')';
    }
}
