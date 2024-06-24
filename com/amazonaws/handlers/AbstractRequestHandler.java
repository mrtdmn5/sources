package com.amazonaws.handlers;

import com.amazonaws.Request;
import com.amazonaws.util.TimingInfo;

@Deprecated
/* loaded from: classes.dex */
public abstract class AbstractRequestHandler implements RequestHandler {
    @Override // com.amazonaws.handlers.RequestHandler
    public void beforeRequest(Request<?> request) {
    }

    @Override // com.amazonaws.handlers.RequestHandler
    public void afterError(Request<?> request, Exception exc) {
    }

    @Override // com.amazonaws.handlers.RequestHandler
    public void afterResponse(Request<?> request, Object obj, TimingInfo timingInfo) {
    }
}
