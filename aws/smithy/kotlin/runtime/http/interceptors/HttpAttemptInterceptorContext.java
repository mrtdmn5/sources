package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class HttpAttemptInterceptorContext<I, O> implements ProtocolRequestInterceptorContext {
    public final ExecutionContext executionContext;
    public final HttpRequest protocolRequest;
    public final HttpResponse protocolResponse;
    public final I request;
    public Object response;

    public HttpAttemptInterceptorContext(I r2, Object obj, HttpRequest protocolRequest, HttpResponse httpResponse, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(protocolRequest, "protocolRequest");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = r2;
        this.response = obj;
        this.protocolRequest = protocolRequest;
        this.protocolResponse = httpResponse;
        this.executionContext = executionContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpAttemptInterceptorContext)) {
            return false;
        }
        HttpAttemptInterceptorContext httpAttemptInterceptorContext = (HttpAttemptInterceptorContext) obj;
        if (Intrinsics.areEqual(this.request, httpAttemptInterceptorContext.request) && Intrinsics.areEqual(this.response, httpAttemptInterceptorContext.response) && Intrinsics.areEqual(this.protocolRequest, httpAttemptInterceptorContext.protocolRequest) && Intrinsics.areEqual(this.protocolResponse, httpAttemptInterceptorContext.protocolResponse) && Intrinsics.areEqual(this.executionContext, httpAttemptInterceptorContext.executionContext)) {
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
        int hashCode2;
        int r0 = 0;
        I r1 = this.request;
        if (r1 == null) {
            hashCode = 0;
        } else {
            hashCode = r1.hashCode();
        }
        int r12 = hashCode * 31;
        Object obj = this.response;
        if (obj == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = obj.hashCode();
        }
        int hashCode3 = (this.protocolRequest.hashCode() + ((hashCode2 + r12) * 31)) * 31;
        HttpResponse httpResponse = this.protocolResponse;
        if (httpResponse != null) {
            r0 = httpResponse.hashCode();
        }
        return this.executionContext.hashCode() + ((hashCode3 + r0) * 31);
    }

    public final String toString() {
        return "HttpAttemptInterceptorContext(request=" + this.request + ", response=" + ((Object) Result.m1662toStringimpl(this.response)) + ", protocolRequest=" + this.protocolRequest + ", protocolResponse=" + this.protocolResponse + ", executionContext=" + this.executionContext + ')';
    }
}
