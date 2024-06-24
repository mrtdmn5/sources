package aws.smithy.kotlin.runtime.http.interceptors;

import aws.smithy.kotlin.runtime.client.ProtocolRequestInterceptorContext;
import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.http.response.HttpCall;
import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import aws.smithy.kotlin.runtime.operation.ExecutionContext;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InterceptorExecutor.kt */
/* loaded from: classes.dex */
public final class HttpInputOutputInterceptorContext<I, O> implements ProtocolRequestInterceptorContext {
    public final HttpCall call;
    public final ExecutionContext executionContext;
    public final HttpRequest protocolRequest;
    public final I request;
    public final Object response;

    public HttpInputOutputInterceptorContext(I r2, Object obj, HttpCall httpCall, ExecutionContext executionContext) {
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        this.request = r2;
        this.response = obj;
        this.call = httpCall;
        this.executionContext = executionContext;
        this.protocolRequest = httpCall.request;
        HttpResponse httpResponse = httpCall.response;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpInputOutputInterceptorContext)) {
            return false;
        }
        HttpInputOutputInterceptorContext httpInputOutputInterceptorContext = (HttpInputOutputInterceptorContext) obj;
        if (Intrinsics.areEqual(this.request, httpInputOutputInterceptorContext.request) && Intrinsics.areEqual(this.response, httpInputOutputInterceptorContext.response) && Intrinsics.areEqual(this.call, httpInputOutputInterceptorContext.call) && Intrinsics.areEqual(this.executionContext, httpInputOutputInterceptorContext.executionContext)) {
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
        int r0 = 0;
        I r1 = this.request;
        if (r1 == null) {
            hashCode = 0;
        } else {
            hashCode = r1.hashCode();
        }
        int r12 = hashCode * 31;
        Object obj = this.response;
        if (obj != null) {
            r0 = obj.hashCode();
        }
        return this.executionContext.hashCode() + ((this.call.hashCode() + ((r0 + r12) * 31)) * 31);
    }

    public final String toString() {
        return "HttpInputOutputInterceptorContext(request=" + this.request + ", response=" + ((Object) Result.m1662toStringimpl(this.response)) + ", call=" + this.call + ", executionContext=" + this.executionContext + ')';
    }
}
