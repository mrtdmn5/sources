package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class RequestDeduplicator {
    public final Executor executor;
    public final ArrayMap getTokenRequests = new ArrayMap();

    public RequestDeduplicator(ExecutorService executorService) {
        this.executor = executorService;
    }
}
