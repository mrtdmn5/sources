package aws.smithy.kotlin.runtime.http.response;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCall.kt */
/* loaded from: classes.dex */
public final class HttpCall {
    public final CoroutineContext callContext;
    public final HttpRequest request;
    public final Instant requestTime;
    public final HttpResponse response;
    public final Instant responseTime;

    public HttpCall(HttpRequest request, HttpResponse httpResponse, Instant instant, Instant instant2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        this.response = httpResponse;
        this.requestTime = instant;
        this.responseTime = instant2;
        this.callContext = coroutineContext;
    }

    public static HttpCall copy$default(HttpCall httpCall, HttpResponse response) {
        HttpRequest request = httpCall.request;
        Instant requestTime = httpCall.requestTime;
        Instant responseTime = httpCall.responseTime;
        CoroutineContext callContext = httpCall.callContext;
        httpCall.getClass();
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        return new HttpCall(request, response, requestTime, responseTime, callContext);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpCall)) {
            return false;
        }
        HttpCall httpCall = (HttpCall) obj;
        if (Intrinsics.areEqual(this.request, httpCall.request) && Intrinsics.areEqual(this.response, httpCall.response) && Intrinsics.areEqual(this.requestTime, httpCall.requestTime) && Intrinsics.areEqual(this.responseTime, httpCall.responseTime) && Intrinsics.areEqual(this.callContext, httpCall.callContext)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.callContext.hashCode() + ((this.responseTime.hashCode() + ((this.requestTime.hashCode() + ((this.response.hashCode() + (this.request.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "HttpCall(request=" + this.request + ", response=" + this.response + ", requestTime=" + this.requestTime + ", responseTime=" + this.responseTime + ", callContext=" + this.callContext + ')';
    }
}
