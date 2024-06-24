package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.TimingInfo;

/* loaded from: classes.dex */
final class RequestHandler2Adaptor extends RequestHandler2 {
    private final RequestHandler old;

    public RequestHandler2Adaptor(RequestHandler requestHandler) {
        if (requestHandler != null) {
            this.old = requestHandler;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void afterError(Request<?> request, Response<?> response, Exception exc) {
        this.old.afterError(request, exc);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void afterResponse(Request<?> request, Response<?> response) {
        AWSRequestMetrics aWSRequestMetrics;
        Object awsResponse;
        TimingInfo timingInfo = null;
        if (request == null) {
            aWSRequestMetrics = null;
        } else {
            aWSRequestMetrics = request.getAWSRequestMetrics();
        }
        if (response == null) {
            awsResponse = null;
        } else {
            awsResponse = response.getAwsResponse();
        }
        if (aWSRequestMetrics != null) {
            timingInfo = aWSRequestMetrics.getTimingInfo();
        }
        this.old.afterResponse(request, awsResponse, timingInfo);
    }

    @Override // com.amazonaws.handlers.RequestHandler2
    public void beforeRequest(Request<?> request) {
        this.old.beforeRequest(request);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RequestHandler2Adaptor)) {
            return false;
        }
        return this.old.equals(((RequestHandler2Adaptor) obj).old);
    }

    public int hashCode() {
        return this.old.hashCode();
    }
}
